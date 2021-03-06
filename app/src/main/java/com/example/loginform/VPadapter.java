package com.example.loginform;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class VPadapter extends FragmentStateAdapter {

    public VPadapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {


        switch (position)
        {
            case 1:
                return new calender();
            case 2:
                return new task();
            case 3:
                return new payment();
            case 4:
                return new setting();
            default:
                return new home();
        }

    }

    @Override
    public int getItemCount() {
        return 5;
    }
}
