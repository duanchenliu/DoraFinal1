package com.example.user.dorafinal1;

import android.arch.persistence.room.Room;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class MapAdapter extends RecyclerView.Adapter<MapAdapter.ViewHolder> {

    Context mContext;
    HospitalRecord hospital;
    List<HospitalRecord> hospitals;

    public MapAdapter(List<HospitalRecord> hospitals) {
        this.hospitals = hospitals;
    }

    @Override
    public MapAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.map_row, parent,false);
        mContext = parent.getContext();
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MapAdapter.ViewHolder holder, int position) {
        final int index = position;
        holder.hospital.setText(" " + hospitals.get(position).getHospitalName());
        holder.city.setText(" " + hospitals.get(position).getCity());

        holder.itemView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                hospitals.get(index);
                hospital = hospitals.get(index);

                Intent map = new Intent(mContext, MapActivity.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("hospital",hospitals.get(index));
                map.putExtras(bundle);
                mContext.startActivity(map);
            }
        });
    }

    @Override
    public int getItemCount() {
        if (hospitals == null)
            return 0;
        else
            return hospitals.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView hospital;
        TextView city;

        public ViewHolder(View itemView) {
            super(itemView);
            hospital = itemView.findViewById(R.id.hospital);
            city = itemView.findViewById(R.id.city);

        }
    }
}
