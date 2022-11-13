package com.assignment.turbo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class SplashActivity extends Activity {

    Handler handler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashscreen);
        DataProvider.getInstance();
        handler=new Handler();
        handler.postDelayed(() -> {
            Intent intent=new Intent(SplashActivity.this,MainActivity.class);
            startActivity(intent);
            this.finish();
        },2000);

    }
}