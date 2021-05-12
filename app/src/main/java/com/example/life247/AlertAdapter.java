package com.example.life247;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.life247.Fragment.AddAlertFragment;
import com.example.life247.Fragment.AssignmentFragment;

import java.util.List;

public class AlertAdapter extends RecyclerView.Adapter<AlertAdapter.ViewHolder> {
    private Context context;
    private List<String> Alert;
    private Object View;


    public AlertAdapter(Context context) {
        this.context = context;
        this.Alert = Alert;
    }



    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.alert_post, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        //grab the item at the position
        String alert = Alert.get(position);
        // bind the item into the specified view holder
        holder.bind(Alert);
    }

    @Override
    public int getItemCount() {
        return Alert.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        private TextView ClassName;
        private TextView Time;
        private EditText NameClass;
        private EditText etDescription;
        private EditText DueTime;
        RecyclerView rvalert;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            NameClass=itemView.findViewById(R.id.NameClass);
            etDescription=itemView.findViewById(R.id.etDescription);
            //DueTime=itemView.findViewById(R.id.DueTime);
            rvalert=itemView.findViewById(R.id.rvalert);
        }

        public void bind(List<String> item) {
            NameClass.setText(AddAlertFragment.getNameClass());
            etDescription.setText(AddAlertFragment.getetDescription());
            //DueTime.setText(AddAlertFragment.getDueTime());


            rvalert.setOnClickListener(new View.OnClickListener() {
                private Object AssignmentFragment;

                @Override
                public void onClick(View view) {
                    Intent i = new Intent(context, AssignmentFragment.getClass());
                    i.putExtra("Class name",ClassName.toString());
                    i.putExtra("Description",etDescription.toString());
                    i.putExtra("Due Date",DueTime.toString());


                    context.startActivity(i);
                }
            });
        }
    }
}
