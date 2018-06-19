package com.example.pcoscar.firebasedemo1;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;

public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super .onCreate(savedInstanceState);

        setContentView(getLayoutId());
        ButterKnife.bind(this);//no olvidar
    }

    public abstract  int getLayoutId();
}
