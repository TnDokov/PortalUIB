package com.example.loginform;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


public class task1 extends Fragment {


    RecyclerView recyclerView;
    AdapterTask1 adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.fragment_task1, container, false);
        RecyclerView featuredRecycler = view.findViewById(R.id.task_rview);
        featuredRecycler();
        featuredRecycler.setHasFixedSize(true);
        featuredRecycler.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        featuredRecycler.setAdapter(adapter);
        return view;
    }

    private void featuredRecycler() {
        ArrayList<HelperTask1> lokasift = new ArrayList<>();
        lokasift.add(new HelperTask1("Time : 12:00, 31 October 2021", "Sistem Basis Data", "Project UTS","Pembuatan ERD Mobile Apps"));
        lokasift.add(new HelperTask1("Time : 12:00, 31 October 2021", "Mobile And Web Service", "Project UTS","Pembuatan Mobile Apps"));
        lokasift.add(new HelperTask1("Time : 12:00, 31 October 2021", "Design Interaksi", "Project UTS","Pembuatan Laporan Proyek Design Mobile App"));
        lokasift.add(new HelperTask1("Time : 12:00, 31 October 2021", "Jaringan Enterprise", "Project UTS","Pembuatan Rancangan Topologi Kampus"));

        adapter = new AdapterTask1(lokasift);
    }

}