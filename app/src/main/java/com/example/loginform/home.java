package com.example.loginform;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;


public class home extends Fragment {
    RecyclerView.Adapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = LayoutInflater.from(getContext()).inflate(R.layout.fragment_home, container, false);

        RecyclerView featuredRecycler = view.findViewById(R.id.ft_rview);
        featuredRecycler();
        featuredRecycler.setHasFixedSize(true);
        featuredRecycler.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));
        featuredRecycler.setAdapter(adapter);
        return view;
    }

        private void featuredRecycler() {
            ArrayList<HelperClass> lokasift = new ArrayList<>();
            lokasift.add(new HelperClass(R.drawable.reddote, "1 Day Left", "Design Interaksi"));
            lokasift.add(new HelperClass(R.drawable.reddote, "2 Day Left", "Sistem Basis Data"));
            lokasift.add(new HelperClass(R.drawable.greendote, "5 Day Left", "Jaringan Enteprise"));
            lokasift.add(new HelperClass(R.drawable.greendote, "6 Day Left", "Jaringan Nirkabel"));

            adapter = new Adapter(lokasift);
        }
    }

 