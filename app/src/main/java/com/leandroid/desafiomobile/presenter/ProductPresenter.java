package com.leandroid.desafiomobile.presenter;

import android.app.Activity;
import android.content.Intent;

import com.leandroid.desafiomobile.service.ProductService;
import com.leandroid.desafiomobile.view.activity.SearchActivity;
import com.leandroid.desafiomobile.view.fragment.IProductFragment;

public class ProductPresenter {

    public void mountProductList(IProductFragment iProductFragment,int offset,String query ){
        ProductService.mountProduct(iProductFragment,offset,query);
    }

}
