package com.example.life247.Fragment;

import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;

import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.ThemedSpinnerAdapter;
import android.widget.Toast;

import com.example.life247.AlertAdapter;
import com.example.life247.R;

import java.util.AbstractSequentialList;
import java.util.List;


public class AddAlertFragment extends Fragment {
    private TextView ClassName;
    private TextView Time;
    private EditText NameClass;
    private EditText etDescription;
    private EditText DueTime;
    private Button Submit;

    List<String> items;


    public AddAlertFragment() {
        // Required empty public constructor
    }
    public interface OnClickListener {
        void onItemClicked(int position);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_add_alert, container, false);

    }
    // This event is triggered soon after onCreateView().
    // Any view setup should occur here.  E.g., view lookups and attaching view listeners.
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        NameClass=view.findViewById(R.id.NameClass);
        etDescription=view.findViewById(R.id.etDescription);
        DueTime=view.findViewById(R.id.DueTime);
        Submit=view.findViewById(R.id.Submit);

        Submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String classN = NameClass.getText().toString();
                String Time = DueTime.getText().toString();
                String description = etDescription.getText().toString();

                // add item to the model
                AbstractSequentialList<Object> items;
                items.add(classN);
                items.add(Time);
                items.add(description);

                // notify adapter that an item is inserted
                AlertAdapter.notifyItemInserted(items.size() - 1);
                NameClass.setText("");
                DueTime.setText("");
                etDescription.setText("");

                saveItems();
            }



    }



}