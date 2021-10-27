package com.example.loginform;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.text.CollationElementIterator;
import java.util.ArrayList;


public class AdapterTask1 extends RecyclerView.Adapter<AdapterTask1.DataViewHolder> {

    ArrayList<HelperTask1> lokasihelper;

    public AdapterTask1(ArrayList<HelperTask1> lokasihelper) {
        this.lokasihelper = lokasihelper;
    }

    @NonNull
    @Override
    public DataViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.taskbox,parent,false);
        DataViewHolder dataViewHolder=  new DataViewHolder(view);
        return dataViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull DataViewHolder holder, int position) {
        HelperTask1 helperTask1 =  lokasihelper.get(position);

        holder.tanggaldeadline.setText(helperTask1.getTanggaldeadline());
        holder.namakelas.setText(helperTask1.getKelas());
        holder.tujuantugas.setText(helperTask1.getTujuantugas());
        holder.deskripsitugas.setText(helperTask1.getDeskripsitugas());

    }

    @Override
    public int getItemCount() {
        return lokasihelper.size();
    }

    public static class DataViewHolder extends RecyclerView.ViewHolder {


        TextView tanggaldeadline,namakelas,tujuantugas,deskripsitugas;
        public DataViewHolder(@NonNull View itemView) {
            super(itemView);

            tanggaldeadline = itemView.findViewById(R.id.tanggaldeadline);
            namakelas = itemView.findViewById(R.id.namakelas);
            tujuantugas = itemView.findViewById(R.id.tujuantugas);
            deskripsitugas = itemView.findViewById(R.id.deskripsitugas);

        }
    }

}
