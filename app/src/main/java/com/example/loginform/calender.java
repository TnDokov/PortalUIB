package com.example.loginform;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CalendarView;
import android.widget.TextView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.material.snackbar.Snackbar;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class calender extends Fragment {
    private static final String TAG = "CalenderActivity";
    RecyclerView.Adapter adapter;
    List<HelperClassCalender> data;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.fragment_calender, container, false);
        CalendarView calendarView = view.findViewById(R.id.CalCalender);

        RecyclerView recyclerViewcalender = view.findViewById(R.id.rc_calender);
        Calendar selected = Calendar.getInstance();

        calendarView.setOnDateChangeListener(
                new CalendarView.OnDateChangeListener() {
                    @Override
                    public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                        String date = dayOfMonth +"-"+ (month+1) + "-" + year;

                        selected.setTimeInMillis(view.getDate());
                        int dayOfWeek = selected.get(Calendar.DAY_OF_WEEK);
                        String hari;
                        switch (dayOfWeek ) {
                            case Calendar.SUNDAY:
                                hari = "Minggu";
                            case Calendar.MONDAY:
                                hari = "Senin";
                            case Calendar.TUESDAY:
                                hari = "Selasa";
                            case Calendar.WEDNESDAY:
                                hari = "Rabu";
                            case Calendar.THURSDAY:
                                hari = "Senin";
                            case Calendar.FRIDAY:
                                hari = "Senin";
                            case Calendar.SATURDAY:
                                hari = "Senin";

                        }
                    }
                }
        );
        data = new ArrayList<>();
        GetData();
        recyclerViewcalender.setHasFixedSize(true);
        recyclerViewcalender.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false));
        adapter = new AdapterCalender(this,data);
        recyclerViewcalender.setAdapter(adapter);

        return view;
    }


    private Context mContext;
    private Activity mActivity;
    private CoordinatorLayout mCLayout;
    private TextView mTextView;

    Intent intent = getActivity().getIntent();
    String nppm = intent.getStringExtra("npm");

   public void GetData(){
        RequestQueue requestQueue = Volley.newRequestQueue(mContext);
        JsonArrayRequest jsonarrayRequest = new JsonArrayRequest(
                Request.Method.POST,
                ContractDB.CALENDER_URL,
                null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {

                            if(response != null){
                                for(int i=0; i<response.length();i++){
                                    try {
                                        JSONObject barang = response.getJSONObject(i);
                                        HelperClassCalender helper = new HelperClassCalender();

                                        helper.setWaktu(barang.getString("pukul").toString());
                                        helper.setMatkul(barang.getString("nama_mk").toString());
                                        helper.setKelas(barang.getString("ruang").toString());
                                        helper.setDosen(barang.getString("dosen").toString());
                                        data.add(helper);
                                    }
                                    catch (JSONException e){
                                        e.printStackTrace();
                                    }
                                }
                            }
                    }
                },error -> {
            Snackbar.make(
                    mCLayout,"Error.",
                    Snackbar.LENGTH_LONG
            ).show();
        }
        ){
            @Override
            protected Map<String,String> getParams() throws AuthFailureError {
                Map<String,String> params = new HashMap<>();
                params.put("nim",nppm);
                return params;
            }
        };;
        requestQueue.add(jsonarrayRequest);
    }

}
