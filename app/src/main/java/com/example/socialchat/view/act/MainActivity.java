package com.example.socialchat.view.act;

import com.example.socialchat.ActionCallBack;
import com.example.socialchat.R;
import com.example.socialchat.view.viewmodel.MainViewModel;


public class MainActivity extends BaseActivity<MainViewModel>{


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

    }

}