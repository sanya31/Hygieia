package com.sanyagupta.healthdream;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.sanyagupta.healthdream.models.Appointment;
import com.sanyagupta.healthdream.models.WeekDay;

import java.util.ArrayList;
import java.util.List;

public class DailyDoseLog extends AppCompatActivity {
    LinearLayout add;
    ListView listView;
    MyDbHandler db=new MyDbHandler(DailyDoseLog.this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daily_dose_log);
        add =findViewById(R.id.add);
        listView=findViewById(R.id.listview);
        List<WeekDay> weekDays = new ArrayList<>();
        weekDays=db.getDailyDoseReminders();
        int s=weekDays.size();
        ArrayList<String> medicine = new ArrayList<>();
        ArrayList<String> time = new ArrayList<>();
        ArrayList<String> day = new ArrayList<>();

        for(int i=0; i<s; i++){
            medicine.add(weekDays.get(i).getMedicine_name());
            time.add(weekDays.get(i).getTime());
            day.add(weekDays.get(i).getDay());
        }
        MyAdapter myAdapter = new MyAdapter(this, medicine,time,day);
        listView.setAdapter(myAdapter);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(DailyDoseLog.this,DailyDoseReminder.class);
                startActivity(intent);
            }
        });
    }
    class MyAdapter extends ArrayAdapter<String> {
        Context context;
        ArrayList<String> medicine = new ArrayList<String>();
        ArrayList<String> time =new ArrayList<String>();
        ArrayList<String> day =new ArrayList<String>();
        MyAdapter(Context c, ArrayList<String> med, ArrayList<String> t, ArrayList<String> d){
            super(c,R.layout.item,R.id.dosename,med);
            this.context=c;
            this.medicine=med;
            this.time=t;
            this.day=d;
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater layoutInflater = (LayoutInflater)getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View row= layoutInflater.inflate(R.layout.item,parent,false);
//            ImageView delete,edit;
//            delete =row.findViewById(R.id.delete);
//            edit=row.findViewById(R.id.edit);
            TextView textView =row.findViewById(R.id.dosename);
            TextView textView1 = row.findViewById(R.id.timing);
            TextView textView2 =row.findViewById(R.id.day);
            textView.setText(medicine.get(position));
            textView1.setText(time.get(position));
            textView2.setText(day.get(position));
//            pb.setProgress(Integer.valueOf(dur.get(position)));
            return row;
        }
    }
}