package com.example.socialchat.view.act;


import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.viewpager2.widget.ViewPager2;

import com.example.socialchat.R;

import com.example.socialchat.view.adapter.ViewPager2Adapter;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class HomeActivity extends BaseActivity{
    private BottomNavigationView bottomNavigationView;
    private ViewPager2 viewPager2;


    @Override
    protected Class getClassViewModel() {
        return null;
    }

    @Override
    protected int getLayoutID() {
        return R.layout.activity_home;
    }

    @Override
    protected void initView() {
            bottomNavigationView = findViewById(R.id.bottom_nav);
            viewPager2 = findViewById(R.id.view_pager);

        ViewPager2Adapter viewPagerAdapter = new ViewPager2Adapter(this);
        viewPager2.setAdapter(viewPagerAdapter);

        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                switch (position){
                    case 0:
                        bottomNavigationView.getMenu().findItem(R.id.messenger).setChecked(true);
                        break;
                    case 1:
                        bottomNavigationView.getMenu().findItem(R.id.friend).setChecked(true);
                        break;
                    case 2:
                        bottomNavigationView.getMenu().findItem(R.id.wall).setChecked(true);
                        break;
                }
            }
        });
        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
               switch (item.getItemId()){
                   case R.id.messenger:
                       viewPager2.setCurrentItem(0);
                       break;
                   case R.id.friend:
                       viewPager2.setCurrentItem(1);
                       break;
                   case R.id.wall:
                       viewPager2.setCurrentItem(2);
                       break;
               }
               return true;
            }
        });
    }
}
