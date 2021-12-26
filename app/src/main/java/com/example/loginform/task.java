package com.example.loginform;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import android.os.RecoverySystem;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;


public class task extends Fragment {

    RecyclerView.Adapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.fragment_task, container, false);

        RecyclerView rctask = view.findViewById(R.id.rc_task);

        rctask();
        rctask.setHasFixedSize(true);
        rctask.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false));
        rctask.setAdapter(adapter);

        return view;
    }

    private void rctask() {
        ArrayList<HelperTask1> lokasirctask = new ArrayList<>();
        lokasirctask.add(new HelperTask1("Time : 16:00, 30 October 2021","Sistem Basis Data","Project UTS",". . . . . "));
        lokasirctask.add(new HelperTask1("Time : 16:00, 30 October 2021","Sistem Basis Data","Project UTS",". . . . . "));
        lokasirctask.add(new HelperTask1("Time : 16:00, 30 October 2021","Sistem Basis Data","Project UTS",". . . . . "));
        lokasirctask.add(new HelperTask1("Time : 16:00, 30 October 2021","Sistem Basis Data","Project UTS",". . . . . "));

        adapter = new AdapterTask1(lokasirctask);
    }
}