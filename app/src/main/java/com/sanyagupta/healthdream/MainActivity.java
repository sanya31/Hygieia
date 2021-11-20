package com.sanyagupta.healthdream;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlarmManager;
import android.app.AlertDialog;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.sanyagupta.healthdream.parameters.Parameters;

public class MainActivity extends AppCompatActivity {
    LinearLayout dose_schedule, appointment, reminder, profile, donate, btn;
    MyDbHandler db=new MyDbHandler(MainActivity.this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        boolean isEmpty=db.isEmpty(Parameters.TABLE_1);
        if(isEmpty){
            Intent intent = new Intent(MainActivity.this,UserDetails.class);
            startActivity(intent);
        }
            dose_schedule = findViewById(R.id.medicationschedule);
            //appointment = findViewById(R.id.appointment);
            reminder = findViewById(R.id.reminder);
            profile = findViewById(R.id.settings);
            donate = findViewById(R.id.donate);
            btn = findViewById(R.id.help);
            //notification
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                NotificationChannel channel = new NotificationChannel("my notifi", "My Notification", NotificationManager.IMPORTANCE_DEFAULT);
                NotificationManager manager = getSystemService(NotificationManager.class);
                manager.createNotificationChannel(channel);
            }

            dose_schedule.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(MainActivity.this, DailyDoseSchedule.class);
                    startActivity(intent);
                }
            });

            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(MainActivity.this, Help.class);
                    startActivity(intent);
                }
            });

//            appointment.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//                    Intent intent = new Intent(MainActivity.this, AppointmentSchedule.class);
//                    startActivity(intent);
//                }
//            });

            profile.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(MainActivity.this, Buy.class);
                    startActivity(intent);
                }
            });

            reminder.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    showDialog();
                }
            });

            donate.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(MainActivity.this, Donate.class);
                    startActivity(intent);
                }
            });

    }

private void showDialog() {

    final AlertDialog.Builder dialog =new AlertDialog.Builder(this);
    LayoutInflater inflater = LayoutInflater.from(this);
    View reg_layout = inflater.inflate(R.layout.reminder_option, null);
    dialog.setView(reg_layout);
    Button meds=reg_layout.findViewById(R.id.medication);
    Button appt=reg_layout.findViewById(R.id.appoint);
    dialog.setTitle("Set Reminder");
    Button back=reg_layout.findViewById(R.id.Goback);
    meds.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent=new Intent(MainActivity.this, DailyDoseLog.class);
            startActivity(intent);
        }
    });
    appt.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent=new Intent(MainActivity.this, AppointmentLog.class);
            startActivity(intent);
        }
    });
    //set button
    AlertDialog alertDialog = dialog.create();

    back.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            alertDialog.dismiss();
        }
    });

    alertDialog.show();
}
}