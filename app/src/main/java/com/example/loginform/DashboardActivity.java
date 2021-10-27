package com.example.loginform;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import com.google.android.material.tabs.TabLayout;

public class DashboardActivity extends AppCompatActivity {


    private ViewPager2 viewPager;
    private TabLayout tabLayout;
    private VPadapter vPadapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dashboard);
        tabLayout = findViewById(R.id.tablayout);
        viewPager = findViewById(R.id.viewpager);


        FragmentManager fm = getSupportFragmentManager();
        vPadapter = new VPadapter(fm,getLifecycle());
        viewPager.setAdapter(vPadapter);
        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.home));
        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.calendar));
        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.task));
        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.bill));
        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.settings));

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        viewPager.setUserInputEnabled(false);


    }
}