package com.example.loginform;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class VPadapterTask extends FragmentStateAdapter {


    public VPadapterTask (@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle){
        super(fragmentManager,lifecycle);
    }
    @NonNull
    @Override
    public Fragment createFragment(int position) {

        switch (position) {
            case 1:
                return new task2();
            case 2:
                return new task3();
            default:
                return new task1();

        }
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}
