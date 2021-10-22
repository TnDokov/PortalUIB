package com.example.loginform;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.DataViewHolder> {

    ArrayList<HelperClass> lokasihelper;

    public Adapter(ArrayList<HelperClass> lokasihelper) {
        this.lokasihelper = lokasihelper;
    }

    @NonNull
    @Override
    public DataViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.assignment,parent,false);
        DataViewHolder dataViewHolder=  new DataViewHolder(view);
        return dataViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull DataViewHolder holder, int position) {
        HelperClass helperClass =  lokasihelper.get(position);

        holder.image.setImageResource(helperClass.getImage());
        holder.deadline.setText(helperClass.getDeadline());
        holder.matkul.setText(helperClass.getMatkul());

    }

    @Override
    public int getItemCount() {
        return lokasihelper.size();
    }

    public static class DataViewHolder extends RecyclerView.ViewHolder {

        ImageView image;
        TextView deadline,matkul;
        public DataViewHolder(@NonNull View itemView) {
            super(itemView);

            image = itemView.findViewById(R.id.ft_dot);
            deadline = itemView.findViewById(R.id.ft_deadline);
            matkul = itemView.findViewById(R.id.ft_matkul);
        }
    }

}
