package com.example.sagarsharma4.retailfragmented;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Collections;
import java.util.List;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolder> {
    Context context;
    List<Data> list;

    public ListAdapter(Context context, List<Data> list){
        this.context = context;
        this.list = list;
    }

    @Override
    public ListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        View row=inflater.inflate(R.layout.cell_design, parent, false);
        ViewHolder item=new ViewHolder(row);
        return item;
    }



    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
       // ((ViewHolder)holder).bindView(position);
        final Data getData = list.get(position);

        holder.nameView.setText(getData.name);
        holder.phoneNumberView.setText(getData.phoneNumber);

        holder.parentView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                ListFragment.sendPos(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private View parentView;
        private TextView nameView;
        private TextView phoneNumberView;

        public ViewHolder(View v) {
            super(v);
            parentView = v.findViewById(R.id.itemCell);
            nameView = (TextView) v.findViewById(R.id.contactName);
            phoneNumberView= (TextView) v.findViewById(R.id.contactNumber);
        }

    }



}