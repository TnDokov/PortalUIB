package com.example.loginform;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class AdapterCalender extends RecyclerView.Adapter<AdapterCalender.DataViewHolder> {

    ArrayList<HelperClassCalender> lokasihelper;

    public AdapterCalender(ArrayList<HelperClassCalender> lokasihelper) {
        this.lokasihelper = lokasihelper;
    }




    @NonNull
    @Override
    public DataViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.calenderbox,parent,false);
        DataViewHolder dataViewHolder=  new DataViewHolder(view);
        return dataViewHolder;
    }


    @Override
    public void onBindViewHolder(@NonNull DataViewHolder holder, int position) {
        HelperClassCalender helperClassCalender =  lokasihelper.get(position);

        holder.waktu.setText(helperClassCalender.getWaktu());
        holder.matkul.setText(helperClassCalender.getMatkul());
        holder.kelas.setText((helperClassCalender.getKelas()));
        holder.dosen.setText((helperClassCalender.getDosen()));

    }

    @Override
    public int getItemCount() {
        return lokasihelper.size();
    }

    public static class DataViewHolder extends RecyclerView.ViewHolder {

        TextView waktu,matkul,kelas,dosen;
        public DataViewHolder(@NonNull View itemView) {
            super(itemView);

            waktu = itemView.findViewById(R.id.waktu);
            matkul = itemView.findViewById(R.id.matkul);
            kelas = itemView.findViewById(R.id.kelas);
            dosen = itemView.findViewById(R.id.namadosen);
        }
    }

}
