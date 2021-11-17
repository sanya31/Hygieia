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

import com.sanyagupta.healthdream.models.WeekDay;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

public class DailyDoseSchedule extends AppCompatActivity {
    ListView listView;
    MyDbHandler db=new MyDbHandler(DailyDoseSchedule.this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daily_dose_schedule);
        listView=findViewById(R.id.listview);
        List<WeekDay> schedule = new ArrayList<>();
        String weekday_name = new SimpleDateFormat("EEEE", Locale.ENGLISH).format(System.currentTimeMillis());
        schedule = db.Day(weekday_name);
        int s=schedule.size();
        ArrayList<String> medicine = new ArrayList<>();
        ArrayList<String> time = new ArrayList<>();
        ArrayList<String> day = new ArrayList<>();
        Calendar c= Calendar.getInstance();
        String currdate= DateFormat.getDateInstance().format(c.getTime());
        TextView textView = findViewById(R.id.curr);
        textView.setText(currdate);
        for(int i=0; i<s; i++){
            medicine.add(schedule.get(i).getMedicine_name());
            time.add(schedule.get(i).getTime());
            day.add(schedule.get(i).getDay());
        }
        MyAdapter myAdapter = new MyAdapter(this, medicine,time,day);
        listView.setAdapter(myAdapter);
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