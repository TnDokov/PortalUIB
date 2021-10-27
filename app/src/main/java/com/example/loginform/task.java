package com.example.loginform;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.tabs.TabLayout;


public class task extends Fragment {

    VPadapterTask vPadapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.fragment_task, container, false);
        TabLayout tabLayout = view.findViewById(R.id.tablayouttask);
        ViewPager2 viewPager2 = view.findViewById(R.id.viewpagertask);

        FragmentManager fm = getFragmentManager();
        vPadapter = new VPadapterTask(fm,getLifecycle());
        viewPager2.setAdapter(vPadapter);

        tabLayout.addTab(tabLayout.newTab().setText("S\n1"));
        tabLayout.addTab(tabLayout.newTab().setText("M\n2"));
        tabLayout.addTab(tabLayout.newTab().setText("T\n3"));
        tabLayout.addTab(tabLayout.newTab().setText("W\n4"));
        tabLayout.addTab(tabLayout.newTab().setText("T\n5"));
        tabLayout.addTab(tabLayout.newTab().setText("F\n7"));
        tabLayout.addTab(tabLayout.newTab().setText("S\n8"));
        tabLayout.addTab(tabLayout.newTab().setText("S\n9"));
        tabLayout.addTab(tabLayout.newTab().setText("M\n10"));

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager2.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                tabLayout.selectTab(tabLayout.getTabAt(position));
            }
        });
        viewPager2.setUserInputEnabled(false);
        return view;
    }
}