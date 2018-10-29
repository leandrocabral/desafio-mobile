package com.leandroid.desafiomobile.view.adapter;

import android.content.Context;
import android.graphics.Paint;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.leandroid.desafiomobile.R;
import com.leandroid.desafiomobile.model.Product;
import com.leandroid.desafiomobile.util.MonetarioUtil;
import com.leandroid.desafiomobile.util.StringUtil;
import com.leandroid.desafiomobile.view.fragment.IProductFragment;
import com.squareup.picasso.Picasso;

import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProdutoViewHolder>{

    private Context context;
    private List<Product> productList;
    private IProductFragment iProductFragment;

    public ProductAdapter(IProductFragment iProductFragment, List<Product> productList, Context context) {
        this.productList          = productList;
        this.context              = context;
        this.iProductFragment     = iProductFragment;
    }

    @Override
    public int getItemCount() {
        return productList.size();
    }

    public void setItems(List<Product> productList) {
        this.productList = productList;
    }

    @Override
    public void onBindViewHolder(final ProdutoViewHolder produtoViewHolder, final int i) {

        Product product = productList.get(i);

        final CardView  vCardProduto     = produtoViewHolder.vCardProduto;
        final TextView  vTitleProduto    = produtoViewHolder.vTitleProduto;
        final ImageView vImageProduto    = produtoViewHolder.vImageProduto;
        final TextView  vPrecoTabela     = produtoViewHolder.vPrecoTabela;
        final TextView  vPrecoTotal      = produtoViewHolder.vPrecoTotal;
        final TextView  vPrecoParcelado  = produtoViewHolder.vPrecoParcelado;

        vTitleProduto.setText(StringUtil.getTituloReduzido(product.getSkus().get(0).getName()));
        vPrecoTabela.setText(MonetarioUtil.getValorMonetario(product.getSkus().get(0).getSellers().get(0).getListPrice()));
        vPrecoTabela.setPaintFlags(vPrecoTabela.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
        vPrecoTotal.setText(MonetarioUtil.getValorMonetario(product.getSkus().get(0).getSellers().get(0).getPrice()));

        if(product.getSkus().get(0).getSellers().get(0).getBestInstallment()!=null){
            vPrecoParcelado.setText(product.getSkus().get(0).getSellers().get(0).getBestInstallment().getCount()
                    +context.getResources().getString(R.string.text_multiplicador)
                    +context.getResources().getString(R.string.text_de)
                    +MonetarioUtil.getValorMonetario(product.getSkus().get(0).getSellers().get(0).getBestInstallment().getValue()));
        }

        Picasso.with(context)
                .load(product.getSkus().get(0).getImages().get(0).getImageUrl())
                .resize(600,500)
                .placeholder(R.color.colorGray)
                .error(R.color.colorGray)
                .into(vImageProduto);
    }

    @Override
    public ProdutoViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.
                from(viewGroup.getContext()).
                inflate(R.layout.produto_item, viewGroup, false);

        return new ProdutoViewHolder(itemView);
    }

    public static class ProdutoViewHolder extends RecyclerView.ViewHolder {

        protected CardView vCardProduto;
        protected TextView vTitleProduto;
        protected ImageView vImageProduto;
        protected TextView vPrecoTabela;
        protected TextView vPrecoTotal;
        protected TextView vPrecoParcelado;

        public ProdutoViewHolder(View v) {
            super(v);
            vCardProduto      = (CardView)   v.findViewById(R.id.cv_produto);
            vTitleProduto     = (TextView)   v.findViewById(R.id.tv_title_produto);
            vImageProduto     = (ImageView)   v.findViewById(R.id.iv_produto);
            vPrecoTabela      = (TextView)   v.findViewById(R.id.tv_preco_tabela);
            vPrecoTotal       = (TextView)   v.findViewById(R.id.tv_preco_final);
            vPrecoParcelado   = (TextView)   v.findViewById(R.id.tv_preco_parcelado);
        }
    }
}
