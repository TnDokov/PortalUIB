package com.example.loginform;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class VPadapterCalender extends FragmentStateAdapter {


    public VPadapterCalender(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle){
        super(fragmentManager,lifecycle);
    }
    @NonNull
    @Override
    public Fragment createFragment(int position) {

        switch (position) {
            case 1:
                return new tgl2();
            case 2:
                return new tgl3();
            case 3:
                return new tgl4();
            default:
                return new tgl1();

        }
    }

    @Override
    public int getItemCount() {
        return 4;
    }
}
