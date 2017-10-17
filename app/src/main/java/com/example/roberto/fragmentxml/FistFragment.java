package com.example.roberto.fragmentxml;

import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by roberto on 21.10.2015.
 */
public class FistFragment extends Fragment{

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Log.i("INFO","oCreateView");
        View view = inflater.inflate(R.layout.firstfragment,container,false);
        return view;
    }
}
