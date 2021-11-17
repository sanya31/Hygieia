package com.sanyagupta.healthdream;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.sanyagupta.healthdream.models.Appointment;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class AppointmentSchedule extends AppCompatActivity {
    ListView listView;
    MyDbHandler db=new MyDbHandler(AppointmentSchedule.this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appointment_schedule);
        listView=findViewById(R.id.listview);
        List<Appointment> appointments = new ArrayList<>();
        appointments=db.getAppointments();
        int s=appointments.size();
        ArrayList<String> doctor = new ArrayList<>();
        ArrayList<String> time = new ArrayList<>();
        ArrayList<String> date = new ArrayList<>();
        Calendar c= Calendar.getInstance();
        String currdate= DateFormat.getDateInstance().format(c.getTime());
TextView textView = findViewById(R.id.curr);
textView.setText(currdate);
        for(int i=0; i<s; i++){
            doctor.add(appointments.get(i).getDoctor());
            time.add(appointments.get(i).getTime());
            date.add(appointments.get(i).getDate());
        }
        MyAdapter myAdapter = new MyAdapter(this, doctor,date,time);
        listView.setAdapter(myAdapter);
    }
    class MyAdapter extends ArrayAdapter<String> {
        Context context;
        ArrayList<String> doctor = new ArrayList<String>();
        ArrayList<String> time =new ArrayList<String>();
        ArrayList<String > date = new ArrayList<>();
        MyAdapter(Context c, ArrayList<String> doc, ArrayList<String> d, ArrayList<String> t){
            super(c,R.layout.item2,R.id.nameEdt,doc);
            this.context=c;
            this.doctor=doc;
            this.time=t;
            this.date=d;
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater layoutInflater = (LayoutInflater)getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View row= layoutInflater.inflate(R.layout.item2,parent,false);
//            ImageView delete,edit;
//            delete =row.findViewById(R.id.delete);
//            edit=row.findViewById(R.id.edit);
            TextView textView =row.findViewById(R.id.doctorname);
            TextView textView1 = row.findViewById(R.id.Date);
            TextView textView2 = row.findViewById(R.id.time);
            textView.setText(doctor.get(position));
            textView1.setText(time.get(position));
            textView2.setText(date.get(position));
//            pb.setProgress(Integer.valueOf(dur.get(position)));
            return row;
        }
    }
}