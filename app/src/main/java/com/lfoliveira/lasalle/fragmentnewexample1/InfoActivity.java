package com.lfoliveira.lasalle.fragmentnewexample1;

import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class InfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE){
            finish();
            return;
        }

        info infoFragment = new info();
        infoFragment.setArguments(getIntent().getExtras());
        getSupportFragmentManager().beginTransaction().add(android.R.id.content, infoFragment).commit();


    }
}
