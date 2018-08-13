package com.example.sagarsharma4.retailfragmented;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class DetailFragment extends Fragment {

    private String name;
    private String phoneNumber;


    public DetailFragment() {
        // Required empty public constructor
    }

    public void setContactDetails(String name, String phoneNumber){
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_detail, container, false);
        ((TextView)v.findViewById(R.id.Name)).setText(name);
        ((TextView)v.findViewById(R.id.phoneNumber)).setText(phoneNumber);
        return v;
    }

}
