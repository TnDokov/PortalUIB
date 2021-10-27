package com.example.loginform;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


public class AdapterPayment extends RecyclerView.Adapter<AdapterPayment.DataViewHolder> {

    ArrayList<HelperPayment> lokasihelper;

    public AdapterPayment(ArrayList<HelperPayment> lokasihelper) {
        this.lokasihelper = lokasihelper;
    }

    @NonNull
    @Override
    public DataViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.listpayment,parent,false);
        DataViewHolder dataViewHolder=  new DataViewHolder(view);
        return dataViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull DataViewHolder holder, int position) {
        HelperPayment helperPayment =  lokasihelper.get(position);


        holder.jenisfee.setText(helperPayment.getJenisfee());
        holder.jumlah.setText(helperPayment.getJumlah());
        holder.tanggalbayar.setText(helperPayment.getTanggal());

        String status = lokasihelper.get(position).getDeskripsi();
        if(status.equalsIgnoreCase("Lunas")){
            holder.deskripsilunas.setText("Lunas");
            holder.deskripsilunas.setTextColor(Color.parseColor("#00FF00"));
        }else{
            holder.deskripsilunas.setText("Belum Lunas");
            holder.deskripsilunas.setTextColor(Color.parseColor("#FF0000"));
        }
    }





    @Override
    public int getItemCount() {
        return lokasihelper.size();
    }

    public static class DataViewHolder extends RecyclerView.ViewHolder {

        TextView jenisfee,jumlah,tanggalbayar,deskripsilunas;
        public DataViewHolder(@NonNull View itemView) {
            super(itemView);

            jenisfee = itemView.findViewById(R.id.jenisfee);
            jumlah = itemView.findViewById(R.id.jumlah);
            tanggalbayar = itemView.findViewById(R.id.tanggalbayar);
            deskripsilunas = itemView.findViewById(R.id.deskripsilunas);

        }
    }



}
