package com.example.life247.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.life247.R;

public class AssignmentFragment extends Fragment {
    private RecyclerView rvalert;



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

    }
}