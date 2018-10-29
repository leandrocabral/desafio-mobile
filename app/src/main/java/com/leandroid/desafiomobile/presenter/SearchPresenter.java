package com.leandroid.desafiomobile.presenter;

import com.leandroid.desafiomobile.service.ProductService;
import com.leandroid.desafiomobile.view.fragment.IProductFragment;

public class SearchPresenter {
    public void mountProductList(IProductFragment iProductFragment, int offset, String query ){
        ProductService.mountProduct(iProductFragment,offset,query);
    }
}
