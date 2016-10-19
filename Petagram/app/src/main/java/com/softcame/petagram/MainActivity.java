package com.softcame.petagram;

import android.app.Activity;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;

import com.softcame.petagram.Adapter.PageAdapter;
import com.softcame.petagram.Adapter.PerfilAdapter;
import com.softcame.petagram.Fragment.HomeFragment;
import com.softcame.petagram.Fragment.PerfilFragment;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    FloatingActionButton fabCamara;
    ImageButton imbFav;
    Activity activity;
    Toolbar toolbar;
    TabLayout tabLayout;
    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        viewPager = (ViewPager) findViewById(R.id.viewPager);


        fabCamara = (FloatingActionButton) findViewById(R.id.fabCamara);
        imbFav = (ImageButton) findViewById(R.id.ibtFavs);

        imbFav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,ascotas_favoritas.class);
                startActivity(intent);


            }
        });

        fabCamara.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view,"Sonrie....Click",Snackbar.LENGTH_SHORT).show();
            }
        });


        //opcion para meter el menu personalizado
        toolbar = (Toolbar) findViewById(R.id.miActionBar);
        setSupportActionBar(toolbar);
        //getSupportActionBar().setDisplayShowTitleEnabled(false);

        setUpViewPager();
        if(toolbar != null){
            setSupportActionBar(toolbar);
        }

    }

    private ArrayList<Fragment> agregarFragments(){
        Log.i("Fragments","SI");
        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(new HomeFragment());
        fragments.add(new PerfilFragment());
        return fragments;
    }

    private void setUpViewPager(){
        viewPager.setAdapter(new PageAdapter(getSupportFragmentManager(),agregarFragments()));
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.getTabAt(0).setIcon(R.drawable.home_48);
        tabLayout.getTabAt(1).setIcon(R.drawable.panda_48);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.mAcerca:
                Intent intentAcerca = new Intent(this,Acercade.class);
                startActivity(intentAcerca);
                break;
            case R.id.mContacto:
                Intent intentContacto = new Intent(this,Contacto.class);
                startActivity(intentContacto);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_opciones,menu);
        return true;
    }


}
