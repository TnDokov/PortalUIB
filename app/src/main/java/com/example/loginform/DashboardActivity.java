package com.example.loginform;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;
import android.os.Bundle;
import com.google.android.material.tabs.TabLayout;

public class DashboardActivity extends AppCompatActivity {


    private ViewPager viewPager;
    private TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dashboard);

        tabLayout = findViewById(R.id.tablayout);
        viewPager = findViewById(R.id.viewpager);


        VPadapter vPadapter = new VPadapter(getSupportFragmentManager(), FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        vPadapter.addFragment(new home(),"");
        vPadapter.addFragment(new calender(), "");
        vPadapter.addFragment(new task(), "");
        vPadapter.addFragment(new payment(), "");
        vPadapter.addFragment(new setting(), "");

        viewPager.setAdapter(vPadapter);
        tabLayout.setupWithViewPager(viewPager);

        tabLayout.getTabAt(0).setIcon(R.drawable.home);
        tabLayout.getTabAt(1).setIcon(R.drawable.calendar);
        tabLayout.getTabAt(2).setIcon(R.drawable.task);
        tabLayout.getTabAt(3).setIcon(R.drawable.bill);
        tabLayout.getTabAt(4).setIcon(R.drawable.settings);


    }
}