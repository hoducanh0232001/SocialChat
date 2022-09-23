package com.example.socialchat.view.act;

import com.example.socialchat.ActionCallBack;
import com.example.socialchat.R;
import com.example.socialchat.view.viewmodel.MainViewModel;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


public class MainActivity extends BaseActivity<MainViewModel>{

    FirebaseAuth mAuth;
    @Override
    protected Class<MainViewModel> getClassViewModel() {
        return MainViewModel.class;
    }

    @Override
    protected int getLayoutID() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        mAuth = FirebaseAuth.getInstance();
    }

    protected void onStart(){
        super.onStart();
        FirebaseUser user = mAuth.getCurrentUser();
    }
}