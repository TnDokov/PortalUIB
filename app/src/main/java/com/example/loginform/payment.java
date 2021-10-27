package com.example.loginform;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


public class payment extends Fragment {

    RecyclerView recyclerView;
    AdapterPayment adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = LayoutInflater.from(getContext()).inflate(R.layout.fragment_payment, container, false);
        RecyclerView featuredRecycler = view.findViewById(R.id.rview_bills);
        featuredRecycler();
        featuredRecycler.setHasFixedSize(true);
        featuredRecycler.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        featuredRecycler.setAdapter(adapter);
        return view;
    }

    private void featuredRecycler() {
        ArrayList<HelperPayment> lokasift = new ArrayList<>();

        lokasift.add(new HelperPayment("Ganjil 2021","Rp.6.275.000,-","18 Okt 2021","Belum Lunas"));
        lokasift.add(new HelperPayment("Ganjil 2020","Rp.19.325.000,-","18 Okt 2021","Lunas"));
        lokasift.add(new HelperPayment("Genap 2020","Rp.8.825.000,-","18 Okt 2021","Lunas"));
        lokasift.add(new HelperPayment("Sisipan Genap 2020","Rp.875.000,-","18 Okt 2021","Lunas"));




        adapter = new AdapterPayment(lokasift);
    }
    }