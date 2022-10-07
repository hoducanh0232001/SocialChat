package com.example.socialchat.view.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.socialchat.view.fragment.FriendFragment;
import com.example.socialchat.view.fragment.MessFragment;
import com.example.socialchat.view.fragment.WallFragment;

public class ViewPager2Adapter extends FragmentStateAdapter {
    public ViewPager2Adapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position){
            case 0:
                return new MessFragment();
            case 1:
                return new FriendFragment();
            case 2:
                return new WallFragment();
            default:
                return new MessFragment();
        }
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}
