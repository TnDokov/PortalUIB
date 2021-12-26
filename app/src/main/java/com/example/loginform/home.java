package com.example.loginform;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;


public class home extends Fragment {
    RecyclerView.Adapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = LayoutInflater.from(getContext()).inflate(R.layout.fragment_home, container, false);

        RecyclerView featuredRecycler = view.findViewById(R.id.ft_rview);
        RecyclerView recyclerViewcalender = view.findViewById(R.id.rcViewTodayClass);
        TextView datedisplay = view.findViewById(R.id.todaydate);
        TextView nickname = view.findViewById(R.id.nickname);
        TextView npm = view.findViewById(R.id.npm);
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat dateFormat = new SimpleDateFormat("d MMM yyyy");
        String date = dateFormat.format(calendar.getTime());
        datedisplay.setText(date);


        Intent intent = getActivity().getIntent();
            String nick = intent.getStringExtra("nama");
            String nppm = intent.getStringExtra("npm");
            npm.setText("Nim : "+nppm);
            nickname.setText(nick);


        recyclerViewcalender();
        recyclerViewcalender.setHasFixedSize(true);
        recyclerViewcalender.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false));
        recyclerViewcalender.setAdapter(adapter);

        featuredRecycler();
        featuredRecycler.setHasFixedSize(true);
        featuredRecycler.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));
        featuredRecycler.setAdapter(adapter);
        return view;

    }

    private void recyclerViewcalender() {
        ArrayList<HelperClassCalender> lokasircview = new ArrayList<>();
        lokasircview.add(new HelperClassCalender());
        lokasircview.add(new HelperClassCalender());
        lokasircview.add(new HelperClassCalender());
        lokasircview.add(new HelperClassCalender());
        lokasircview.add(new HelperClassCalender());
        lokasircview.add(new HelperClassCalender());
        lokasircview.add(new HelperClassCalender());
        lokasircview.add(new HelperClassCalender());
        adapter = new AdapterCalender(lokasircview);
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

 