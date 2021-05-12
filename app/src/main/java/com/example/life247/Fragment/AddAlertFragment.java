package com.example.life247.Fragment;

import android.app.DatePickerDialog;
 import android.app.Activity;
import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
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
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.ThemedSpinnerAdapter;
import android.widget.Toast;

import com.example.life247.AlertAdapter;
import com.example.life247.R;

import java.text.BreakIterator;
import java.util.AbstractSequentialList;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;


public class AddAlertFragment extends Fragment {
    private TextView ClassName;
    private TextView Time;
    private EditText NameClass;
    private EditText etDescription;
    private EditText DueTime;
    private Button SSubmit;
    private Button Meds;
    private TextView alarmDate;
    private DatePickerDialog.OnDateSetListener DDateSetListener;
    private TextView alarmTime;


    List<String> items = new ArrayList<>();;
    private Object RadialPickerLayout;


    public AddAlertFragment() {
        // Required empty public constructor
    }


    public static int getNameClass() {
        return(getNameClass());
    }

    public static int getetDescription() {
        return(getetDescription());
    }

    public static int getDueTime() {
        return(getDueTime());
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
        //DueTime=view.findViewById(R.id.DueTime);
        SSubmit=view.findViewById(R.id.SSubmit);
        Meds=view.findViewById(R.id.Meds);
        alarmDate=view.findViewById(R.id.alarmDate);

        alarmDate.setOnClickListener(new View.OnClickListener() {
            //@RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View v) {
                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(getContext(), android.R.style.Theme,DDateSetListener,year,month,day);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
            }
        });
        DDateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                month= month + 1;
                String date = month + "/" + dayOfMonth + "/" + year;
                alarmDate.setText(date);

            }
        };



        SSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String classN = NameClass.getText().toString();
                String Time = DueTime.getText().toString();
                String description = etDescription.getText().toString();

                // add item to the model
                items.add(classN);
                items.add(Time);
                items.add(description);

                // notify adapter that an item is inserted
                //AlertAdapter.notifyItemInserted(items.size() - 1);
                NameClass.setText("");
                DueTime.setText("");
                etDescription.setText("");

                //saveItems();
            }


        });
    };



}