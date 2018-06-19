package com.example.pcoscar.firebasedemo1;

import android.os.Bundle;

public class login extends BaseActivity {

    


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
    }
    public int getLayoutId(){
        return R.layout.activity_login;
    }
}
