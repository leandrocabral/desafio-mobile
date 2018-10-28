package com.leandroid.desafiomobile.service;

import com.leandroid.desafiomobile.model.Data;
import com.leandroid.desafiomobile.model.Product;
import com.leandroid.desafiomobile.service.request.ProductRequest;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface IProductService {

    @POST("Criteria")
    Call<Data> mountProduct(@Body ProductRequest productRequest);
}
