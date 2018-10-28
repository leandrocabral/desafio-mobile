package com.leandroid.desafiomobile.view.activity;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.leandroid.desafiomobile.R;
import com.leandroid.desafiomobile.view.fragment.ProductFragment;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private  Toolbar toolbar;
    private  DrawerLayout drawer;
    private  NavigationView navigationView;
    private  ActionBarDrawerToggle toggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setComponents();
        configActionBar();
        setAction();

    }

    private void setComponents(){
        toolbar        = (Toolbar) findViewById(R.id.toolbar);
        drawer         = (DrawerLayout) findViewById(R.id.drawer_layout);
        navigationView = (NavigationView) findViewById(R.id.nav_view);
    }

    private void configActionBar(){

        setSupportActionBar(toolbar);
        toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);
    }

    private void setAction(){
        openFragment(ProductFragment.newInstance());
    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.ic_search) {

            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_home) {
            // Handle the camera action
        } else if (id == R.id.nav_pedidos) {

        } else if (id == R.id.nav_carrinho) {

        } else if (id == R.id.nav_favoritos) {

        } else if (id == R.id.nav_categoria) {

        } else if (id == R.id.nav_loja) {

        }else if (id == R.id.nav_atendimento) {

        }else if (id == R.id.nav_politica) {

        }else if (id == R.id.nav_configuracoes) {

        }
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void openFragment(Fragment openfragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        Fragment fragment = openfragment;
        String backStateName = fragment.getClass().getName();
        transaction.addToBackStack(backStateName);
        transaction.replace(R.id.content_main, fragment);
        transaction.commitAllowingStateLoss();

        drawer.closeDrawer(GravityCompat.START);
    }
}
