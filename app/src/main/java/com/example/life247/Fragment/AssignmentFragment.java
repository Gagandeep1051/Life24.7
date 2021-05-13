package com.example.life247.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;

import com.example.life247.AlertAdapter;
import com.example.life247.R;

import java.util.ArrayList;
import java.util.List;

public class AssignmentFragment extends AddAlertFragment {
    private RecyclerView rvalert;
    protected AlertAdapter adapter;
    List<String> Alert = new ArrayList<>();;
    private Object Adapter;


    public AssignmentFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_assignment, container, false);

    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        rvalert=view.findViewById(R.id.rvalert);

        Alert = new ArrayList<>();
        Adapter = new AlertAdapter(getContext(),Alert);
        rvalert.setAdapter((RecyclerView.Adapter)Adapter);
        rvalert.setLayoutManager(new LinearLayoutManager(getContext()));



    }
}