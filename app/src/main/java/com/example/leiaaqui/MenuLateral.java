package com.example.leiaaqui;

import androidx.annotation.NonNull;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.navigation.NavigationView;

public class MenuLateral extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{
    private DrawerLayout drawer;
    protected DrawerLayout drawerLayout;
    protected Toolbar toolbar;
    protected boolean drawerLayoutEnable;
    protected NavigationView navigationView;
    protected ActionBarDrawerToggle toggle;

    protected void setUpDrawerLayout(){
        this.drawerLayoutEnable = true;

        toolbar = (Toolbar)findViewById(R.id.toolbar);
        if(toolbar !=null){
            setSupportActionBar(toolbar);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setHomeButtonEnabled(true);

            drawerLayout = (DrawerLayout)findViewById(R.id.drawer_layout);
            setUpDrawerToggle();
            setUpNavigationView();
        }
    }

    private void setUpNavigationView() {
        navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener((NavigationView.OnNavigationItemSelectedListener) this);
    }

    private void setUpDrawerToggle(){
        toggle = new ActionBarDrawerToggle(
                this,
                drawerLayout,
                toolbar,
                R.string.open_drawer,
                R.string.close_drawer);
        drawerLayout.setDrawerListener(toggle);
        toggle.syncState();
    }

    /*@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        setContentView(R.layout.activity_menu_lateral);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.open_drawer, R.string.close_drawer);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
    }*/

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.nav_leitores:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new FragmentMenuCatLeitores()).commit();
                break;
            case R.id.nav_cat_livro:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new FragmentMenuCatLivros()).commit();
                break;
            case R.id.nav_cliente:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new FragmentMenuClientes()).commit();
                break;
            case R.id.nav_consulta:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new FragmentConsultaEspecificas()).commit();
                break;
            /*case R.id.nav_aluguel:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new FragmentAluguel()).commit();
                break;*/
        }
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
}
