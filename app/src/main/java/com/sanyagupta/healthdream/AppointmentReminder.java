package com.sanyagupta.healthdream;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

import com.sanyagupta.healthdream.models.Appointment;

import java.util.Calendar;

public class AppointmentReminder extends AppCompatActivity {
EditText name , date ,time;
Button save;
MyDbHandler db = new MyDbHandler(AppointmentReminder.this);
    int hour,minutes,second,year,month,day;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appointment_reminder);

        name =findViewById(R.id.nameEdt);
        date =findViewById(R.id.dateEdt);
        time =findViewById(R.id.timeEdt);
        save=findViewById(R.id.savebtn);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Name = String.valueOf(name.getText());
                String Date =String.valueOf(date.getText());
                String Time =String.valueOf(time.getText());
                Appointment appointment = new Appointment(Name,Date,Time);
                db.addAppointment(appointment);
                Toast.makeText(AppointmentReminder.this, "Saved", Toast.LENGTH_SHORT).show();
            }
        });
        Calendar calendar= Calendar.getInstance();
        time.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hour=calendar.get(Calendar.HOUR);
                minutes=calendar.get(Calendar.MINUTE);
                second=calendar.get(Calendar.SECOND);

                TimePickerDialog timePickerDialog = new TimePickerDialog(AppointmentReminder.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        time.setText(hourOfDay + ":" + minute);
                    }
                },hour,minutes,false);
                timePickerDialog.show();
            }
        });

        date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                year=calendar.get(Calendar.YEAR);
                month=calendar.get(Calendar.MONTH);
                day=calendar.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog datePickerDialog = new DatePickerDialog(AppointmentReminder.this, new DatePickerDialog.OnDateSetListener() {

                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        date.setText(dayOfMonth + "/"+ (month+1) + "/" + year);
                    }
                },year,month,day);

                //for setting minimum date as current date of system
                datePickerDialog.getDatePicker().setMinDate(calendar.getTimeInMillis());
                datePickerDialog.show();
            }
        });
    }
}