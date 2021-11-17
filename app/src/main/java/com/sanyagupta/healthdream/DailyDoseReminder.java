package com.sanyagupta.healthdream;

import androidx.appcompat.app.AppCompatActivity;

import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.provider.AlarmClock;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;

import com.sanyagupta.healthdream.models.Appointment;
import com.sanyagupta.healthdream.models.WeekDay;

import java.util.ArrayList;
import java.util.Calendar;

public class DailyDoseReminder extends AppCompatActivity {
    EditText name , time ;
    TextView monday,tuesday,wednesday,thursday,friday,saturday,sunday;
    Button save;
    MyDbHandler db = new MyDbHandler(DailyDoseReminder.this);
    int hour,minutes,second;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daily_dose_reminder);

        name =findViewById(R.id.med_name);
        time =findViewById(R.id.timeEdt);
        save=findViewById(R.id.savebtn);
        monday=findViewById(R.id.monday);
        tuesday=findViewById(R.id.tuesday);
        wednesday=findViewById(R.id.wednesday);
        thursday=findViewById(R.id.thursday);
        friday=findViewById(R.id.friday);
        saturday=findViewById(R.id.saturday);
        sunday=findViewById(R.id.sunday);



        ArrayList<String> list =new ArrayList<>();
        ArrayList<Integer> days=new ArrayList<>();

        Calendar calendar= Calendar.getInstance();
        time.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hour=calendar.get(Calendar.HOUR);
                minutes=calendar.get(Calendar.MINUTE);
                second=calendar.get(Calendar.SECOND);

                TimePickerDialog timePickerDialog = new TimePickerDialog(DailyDoseReminder.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        time.setText(hourOfDay + ":" + minute);
                    }
                },hour,minutes,false);
                timePickerDialog.show();
            }
        });

        monday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                list.add("Monday");
                days.add(2);
            }
        });

        tuesday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                list.add("Tuesday");
                days.add(3);
            }
        });

        wednesday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                list.add("Wednesday");
                days.add(4);
            }
        });

        thursday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                list.add("Thursday");
                days.add(5);
            }
        });

        friday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                list.add("Friday");
                days.add(6);
            }
        });

        saturday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                list.add("Saturday");
                days.add(7);
            }
        });

        sunday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                list.add("Sunday");
                days.add(1);
            }
        });



        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Name = name.getText().toString();
                String Time =time.getText().toString();
                WeekDay weekDay =new WeekDay(Name,Time);
                for(int i=0; i<list.size(); i++){

                    db.addSchedule(weekDay, list.get(i));
                }
                Intent intent=new Intent(AlarmClock.ACTION_SET_ALARM);
                intent.putExtra(AlarmClock.EXTRA_HOUR,hour);
                intent.putExtra(AlarmClock.EXTRA_MINUTES,minutes);
                intent.putExtra(AlarmClock.EXTRA_MESSAGE,Name);
                intent.putExtra(AlarmClock.EXTRA_DAYS,days);
                    startActivity(intent);
            }
        });

    }
}