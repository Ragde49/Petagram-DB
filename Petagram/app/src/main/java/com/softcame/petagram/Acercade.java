package com.softcame.petagram;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageButton;

public class Acercade extends AppCompatActivity {
    ImageButton imbFav;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acercade);

        Toolbar mtoolbar = (Toolbar) findViewById(R.id.miActionBar);
        setSupportActionBar(mtoolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        imbFav = (ImageButton) findViewById(R.id.ibtFavs);
        imbFav.setVisibility(View.INVISIBLE);
    }
}
