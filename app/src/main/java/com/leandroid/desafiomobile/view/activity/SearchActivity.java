package com.leandroid.desafiomobile.view.activity;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.leandroid.desafiomobile.R;
import com.leandroid.desafiomobile.model.Data;
import com.leandroid.desafiomobile.presenter.SearchPresenter;
import com.leandroid.desafiomobile.view.adapter.ProductAdapter;
import com.leandroid.desafiomobile.view.fragment.IProductFragment;

public class SearchActivity extends AppCompatActivity implements IProductFragment {

    private SearchPresenter searchPresenter = new SearchPresenter();
    private ImageView searchButton;
    private ImageView backButton;
    private TextView tv_number_result;
    private TextView tv_result_busca;
    private EditText edtSearch;
    private RelativeLayout rlLoading;
    private Context context;
    private RecyclerView recList;
    private ProductAdapter productAdapter;
    private GridLayoutManager llm;
    private int pageScreen = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        setComponents();
        setAction();

    }

    private void setComponents(){
        recList            = (RecyclerView) findViewById(R.id.rv_product);
        searchButton       = (ImageView) findViewById(R.id.iv_search);
        backButton         = (ImageView) findViewById(R.id.iv_arrow_back);
        tv_number_result   = (TextView) findViewById(R.id.tv_number_result);
        tv_result_busca    = (TextView) findViewById(R.id.tv_result_busca);
        edtSearch          = (EditText) findViewById(R.id.edt_search);
        rlLoading          = (RelativeLayout) findViewById(R.id.loading);
    }

    private void setAction(){

        searchButton.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                searchPresenter.mountProductList(SearchActivity.this,pageScreen,edtSearch.getText().toString());
                rlLoading.setVisibility(View.VISIBLE);
            }
        });

        backButton.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @Override
    public void mountProduct(Data data,String search) {

        context = getApplicationContext();
        recList.setHasFixedSize(true);
        llm = new GridLayoutManager(this,2);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        recList.setLayoutManager(llm);

        productAdapter = new ProductAdapter(this,data.getProducts(),context);
        recList.setAdapter(productAdapter);

        tv_number_result.setText(String.valueOf(data.getProducts().size()));
        tv_result_busca.setText(search);

        rlLoading.setVisibility(View.GONE);
    }
}
