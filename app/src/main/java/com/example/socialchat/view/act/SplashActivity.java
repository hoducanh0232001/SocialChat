package com.example.socialchat.view.act;

import android.content.Intent;
import android.os.Handler;

import com.example.socialchat.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class SplashActivity extends BaseActivity{
    @Override
    protected Class getClassViewModel() {
        return null;
    }
    @Override
    protected int getLayoutID() {
        return R.layout.activity_splash;
    }

    @Override
    protected void initView() {

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
               goToLogin();
            }
        },2000);
    }
    public  void nextActivity(){
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if(user == null){
            //chua login
            goToLogin();
        }
        else{
            //da login
            Intent intent = new Intent(this,HomeActivity.class);
            startActivity(intent);
        }
    }
    public void goToLogin(){
        Intent intent = new Intent(this,LoginActivity.class);
        startActivity(intent);
        overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right);
    }
}
