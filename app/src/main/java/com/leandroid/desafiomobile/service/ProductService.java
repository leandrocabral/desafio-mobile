package com.leandroid.desafiomobile.service;

import android.util.Log;

import com.leandroid.desafiomobile.infra.URL;
import com.leandroid.desafiomobile.model.Data;
import com.leandroid.desafiomobile.service.request.ProductRequest;
import com.leandroid.desafiomobile.view.fragment.IProductFragment;



import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ProductService {

    public static void mountProduct(final IProductFragment iProductFragment,final int offset,final String query){

        OkHttpClient okHttpClient = new OkHttpClient().newBuilder()
                .connectTimeout(60, TimeUnit.SECONDS)
                .readTimeout(60, TimeUnit.SECONDS)
                .writeTimeout(60, TimeUnit.SECONDS)
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(URL.getUrlSearch())
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        IProductService iService = retrofit.create(IProductService.class);
        Call<Data> request = iService.mountProduct(new ProductRequest(query,offset,10));

        request.enqueue(new Callback<Data>() {
            @Override
            public void onResponse(Call<Data> call, Response<Data> response) {
                if(response.code()==200){
                    iProductFragment.mountProduct(response.body(),query);
                }
            }

            @Override
            public void onFailure(Call<Data> call, Throwable t) {

            }
        });
    }
}
