package com.example.life247;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.life247.Fragment.AddAlertFragment;

import java.util.List;

public class AlertAdapter extends RecyclerView.Adapter<AlertAdapter.ViewHolder> {
    private Context context;
    private List<String> Alert;
    private Object View;


    public AlertAdapter(Context context, List<String> Alert) {
        this.context = this.context;
        this.Alert = Alert;
    }



    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.alert_post, parent, false);
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
        TextView tvItem;
        private TextView ClassName;
        private TextView Time;
        private EditText NameClass;
        private EditText etDescription;
        private EditText DueTime;
        private TextView alarmDate;
        private TextView alarmTime;
        RecyclerView rvalert;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            NameClass=itemView.findViewById(R.id.NameClass);
            etDescription=itemView.findViewById(R.id.etDescription);
            //DueTime=itemView.findViewById(R.id.DueTime);
            rvalert=itemView.findViewById(R.id.rvalert);
            alarmTime=itemView.findViewById(R.id.alarmTime);
            alarmDate=itemView.findViewById(R.id.alarmDate);
        }

        public void bind(List<String> Alert) {
            NameClass.setText((CharSequence) Alert);
            etDescription.setText((CharSequence) Alert);
            alarmDate.setText((CharSequence) Alert);
            alarmTime.setText((CharSequence) Alert);
            //DueTime.setText(AddAlertFragment.getDueTime());


//            rvalert.setOnClickListener(new View.OnClickListener() {
//                private Object AssignmentFragment;
//
//                @Override
//                public void onClick(View view) {
//                    Intent i = new Intent(context, AssignmentFragment.getClass());
//                    i.putExtra("Class name",ClassName.toString());
//                    i.putExtra("Description",etDescription.toString());
//                    i.putExtra("Due Date",DueTime.toString());
//
//
//                    context.startActivity(i);
//                }
//            });
        }
    }
}
