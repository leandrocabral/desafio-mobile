package com.leandroid.desafiomobile.presenter;

import android.app.Activity;
import android.content.Intent;

import com.leandroid.desafiomobile.view.activity.SearchActivity;

public class MainPresenter {

    public void openScreenSearch(Activity activity){
        Intent intent = new Intent(activity, SearchActivity.class);
        activity.startActivity(intent);
    }
}
