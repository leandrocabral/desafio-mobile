package com.leandroid.desafiomobile.presenter;

import com.leandroid.desafiomobile.service.ProductService;
import com.leandroid.desafiomobile.view.fragment.IProductFragment;

public class ProductPresenter {

    public void mountProductList(IProductFragment iProductFragment,String query ){
        ProductService.mountProduct(iProductFragment,query);
    }
}
