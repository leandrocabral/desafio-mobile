package com.leandroid.desafiomobile.view.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.leandroid.desafiomobile.R;
import com.leandroid.desafiomobile.model.Data;
import com.leandroid.desafiomobile.model.Product;
import com.leandroid.desafiomobile.presenter.ProductPresenter;
import com.leandroid.desafiomobile.view.adapter.ProductAdapter;

import java.util.ArrayList;
import java.util.List;


public class ProductFragment extends Fragment implements IProductFragment {

    private Context context;
    private RecyclerView recList;
    private RelativeLayout rlLoadgin;
    private ProductPresenter productPresenter = new ProductPresenter();

    public ProductFragment() {
        // Required empty public constructor
    }

    public static ProductFragment newInstance() {
        ProductFragment fragment = new ProductFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_produto, container, false);
        setComponents(v);
        setAction();
        return v;
    }

    private void setComponents(View v){
        recList    = (RecyclerView) v.findViewById(R.id.rv_product);
        rlLoadgin  = (RelativeLayout) v.findViewById(R.id.loading);
    }

    private void setAction(){
        productPresenter.mountProductList(this,"");
    }

    @Override
    public void mountProduct(Data data) {

        context = getActivity().getApplicationContext();
        recList.setHasFixedSize(true);
        GridLayoutManager llm = new GridLayoutManager(getContext(),2);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        recList.setLayoutManager(llm);

        ProductAdapter productAdapter = new ProductAdapter(this,data.getProducts(),context);
        recList.setAdapter(productAdapter);

        rlLoadgin.setVisibility(View.GONE);
    }
}
