package com.sanyagupta.healthdream;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.sanyagupta.healthdream.models.Appointment;
import com.sanyagupta.healthdream.models.Family;
import com.sanyagupta.healthdream.models.User;
import com.sanyagupta.healthdream.models.WeekDay;
import com.sanyagupta.healthdream.parameters.Parameters;

import java.net.PortUnreachableException;
import java.util.ArrayList;
import java.util.List;

public class MyDbHandler extends SQLiteOpenHelper {
    public MyDbHandler(Context context){
        super(context, Parameters.DB_Name, null, Parameters.DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String create1 = "CREATE TABLE "+Parameters.TABLE_1+"("
                +Parameters.KEY_NAME+" TEXT PRIMARY KEY, "
                +Parameters.KEY_PHONE+" TEXT, "+Parameters.KEY_EMAIL+" TEXT, "
                +Parameters.KEY_AGE+" INTEGER, "+Parameters.KEY_GENDER+" TEXT, "
                +Parameters.KEY_AREA+" TEXT)";
        sqLiteDatabase.execSQL(create1);

        String create2 = "CREATE TABLE "+Parameters.TABLE_2+"("
                +Parameters.KEY_ID+" INTEGER PRIMARY KEY, "
                +Parameters.KEY_FNAME+" TEXT, "+Parameters.KEY_EMAIL+" TEXT, "
                +Parameters.KEY_PHONE+" TEXT)";
        sqLiteDatabase.execSQL(create2);

        String create3 = "CREATE TABLE "+Parameters.TABLE_3+"("
                +Parameters.KEY_DNAME+" TEXT PRIMARY KEY, "
                +Parameters.KEY_DATE+" TEXT, "+Parameters.KEY_TIME+" TEXT)";
        sqLiteDatabase.execSQL(create3);

        String create4 = "CREATE TABLE "+Parameters.MONDAY+"("
                +Parameters.KEY_MEDNAME+" TEXT PRIMARY KEY, "
                +Parameters.KEY_TIME1+" TEXT)";
        sqLiteDatabase.execSQL(create4);

        String create5 = "CREATE TABLE "+Parameters.TUESDAY+"("
                +Parameters.KEY_MEDNAME+" TEXT PRIMARY KEY, "
                +Parameters.KEY_TIME1+" TEXT)";
        sqLiteDatabase.execSQL(create5);

        String create6 = "CREATE TABLE "+Parameters.WEDNESDAY+"("
                +Parameters.KEY_MEDNAME+" TEXT PRIMARY KEY, "
                +Parameters.KEY_TIME1+" TEXT)";
        sqLiteDatabase.execSQL(create6);

        String create7 = "CREATE TABLE "+Parameters.THURSDAY+"("
                +Parameters.KEY_MEDNAME+" TEXT PRIMARY KEY, "
                +Parameters.KEY_TIME1+" TEXT)";
        sqLiteDatabase.execSQL(create7);

        String create8 = "CREATE TABLE "+Parameters.FRIDAY+"("
                +Parameters.KEY_MEDNAME+" TEXT PRIMARY KEY, "
                +Parameters.KEY_TIME1+" TEXT)";
        sqLiteDatabase.execSQL(create8);

        String create9 = "CREATE TABLE "+Parameters.SATURDAY+"("
                +Parameters.KEY_MEDNAME+" TEXT PRIMARY KEY, "
                +Parameters.KEY_TIME1+" TEXT)";
        sqLiteDatabase.execSQL(create9);

        String create10 = "CREATE TABLE "+Parameters.SUNDAY+"("
                +Parameters.KEY_MEDNAME+" TEXT PRIMARY KEY, "
                +Parameters.KEY_TIME1+" TEXT)";
        sqLiteDatabase.execSQL(create10);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public void addUser(User user){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(Parameters.KEY_NAME, user.getName());
        values.put(Parameters.KEY_PHONE, user.getPhone());
        values.put(Parameters.KEY_AGE, user.getAge());
        values.put(Parameters.KEY_EMAIL, user.getEmail());
        values.put(Parameters.KEY_GENDER, user.getGender());
        values.put(Parameters.KEY_AREA, user.getArea());
        db.insert(Parameters.TABLE_1, null, values);
        db.close();
    }

    public void addFamily(Family family){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(Parameters.KEY_FNAME, family.getName());
        values.put(Parameters.KEY_FEMAIL, family.getEmail());
        values.put(Parameters.KEY_FPHONE, family.getPhone());
        db.insert(Parameters.TABLE_2, null, values);
        db.close();
    }

    public void addAppointment(Appointment appointment){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(Parameters.KEY_DNAME, appointment.getDoctor());
        values.put(Parameters.KEY_DATE, appointment.getDate());
        values.put(Parameters.KEY_TIME, appointment.getTime());
        db.insert(Parameters.TABLE_3, null, values);
        db.close();
    }

    public void addSchedule(WeekDay weekDay, String day){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(Parameters.KEY_MEDNAME, weekDay.getMedicine_name());
        values.put(Parameters.KEY_TIME1, weekDay.getTime());
        day=day+"_table";
        db.insert(day, null, values);
        db.close();
    }

    public List<WeekDay> getDailyDoseReminders(){
        SQLiteDatabase db = this.getReadableDatabase();
        List<WeekDay> weekDayList= new ArrayList<>();
        String select = "SELECT * FROM "+Parameters.MONDAY;
        Cursor cursor = db.rawQuery(select, null);

        if(cursor.moveToFirst()){
            do{
                WeekDay weekDay = new WeekDay();
                weekDay.setMedicine_name(String.valueOf(cursor.getString(0)));
                weekDay.setTime(cursor.getString(1));
                weekDay.setDay("Monday");
                weekDayList.add(weekDay);
            }while(cursor.moveToNext());
        }
        String select1 = "SELECT * FROM "+Parameters.TUESDAY;
        Cursor cursor1 = db.rawQuery(select1, null);

        if(cursor1.moveToFirst()){
            do{
                WeekDay weekDay = new WeekDay();
                weekDay.setMedicine_name(String.valueOf(cursor1.getString(0)));
                weekDay.setTime(cursor1.getString(1));
                weekDay.setDay("Tuesday");
                weekDayList.add(weekDay);
            }while(cursor1.moveToNext());
        }
        String select2 = "SELECT * FROM "+Parameters.WEDNESDAY;
        Cursor cursor2 = db.rawQuery(select2, null);

        if(cursor2.moveToFirst()){
            do{
                WeekDay weekDay = new WeekDay();
                weekDay.setMedicine_name(String.valueOf(cursor2.getString(0)));
                weekDay.setTime(cursor2.getString(1));
                weekDay.setDay("Wednesday");
                weekDayList.add(weekDay);
            }while(cursor2.moveToNext());
        }
        String select3 = "SELECT * FROM "+Parameters.THURSDAY;
        Cursor cursor3 = db.rawQuery(select3, null);

        if(cursor3.moveToFirst()){
            do{
                WeekDay weekDay = new WeekDay();
                weekDay.setMedicine_name(String.valueOf(cursor3.getString(0)));
                weekDay.setTime(cursor3.getString(1));
                weekDay.setDay("Thursday");
                weekDayList.add(weekDay);
            }while(cursor3.moveToNext());
        }
        String select4 = "SELECT * FROM "+Parameters.FRIDAY;
        Cursor cursor4 = db.rawQuery(select4, null);

        if(cursor4.moveToFirst()){
            do{
                WeekDay weekDay = new WeekDay();
                weekDay.setMedicine_name(String.valueOf(cursor4.getString(0)));
                weekDay.setTime(cursor4.getString(1));
                weekDay.setDay("Friday");
                weekDayList.add(weekDay);
            }while(cursor4.moveToNext());
        }
        String select5 = "SELECT * FROM "+Parameters.SATURDAY;
        Cursor cursor5 = db.rawQuery(select5, null);

        if(cursor5.moveToFirst()){
            do{
                WeekDay weekDay = new WeekDay();
                weekDay.setMedicine_name(String.valueOf(cursor5.getString(0)));
                weekDay.setTime(cursor5.getString(1));
                weekDay.setDay("Saturday");
                weekDayList.add(weekDay);
            }while(cursor5.moveToNext());
        }
        String select6 = "SELECT * FROM "+Parameters.SUNDAY;
        Cursor cursor6 = db.rawQuery(select6, null);

        if(cursor6.moveToFirst()){
            do{
                WeekDay weekDay = new WeekDay();
                weekDay.setMedicine_name(String.valueOf(cursor6.getString(0)));
                weekDay.setTime(cursor6.getString(1));
                weekDay.setDay("Sunday");
                weekDayList.add(weekDay);
            }while(cursor6.moveToNext());
        }
        db.close();
        return weekDayList;
    }

    public List<WeekDay> Day(String day){
        SQLiteDatabase db = this.getReadableDatabase();
        List<WeekDay> weekDayList= new ArrayList<>();
        String table =day+"_table";
        String select = "SELECT * FROM "+table;
        Cursor cursor = db.rawQuery(select, null);

        if(cursor.moveToFirst()){
            do{
                WeekDay weekDay = new WeekDay();
                weekDay.setMedicine_name(String.valueOf(cursor.getString(0)));
                weekDay.setTime(cursor.getString(1));
                weekDay.setDay(day);
                weekDayList.add(weekDay);
            }while(cursor.moveToNext());
        }
        db.close();
        return weekDayList;
    }

    public List<Appointment> getAppointments(){
        SQLiteDatabase db = this.getReadableDatabase();
        List<Appointment> appointments= new ArrayList<>();
        String select = "SELECT * FROM "+Parameters.TABLE_3;
        Cursor cursor = db.rawQuery(select, null);

        if(cursor.moveToFirst()){
            do{
                Appointment appointment=new Appointment();
                appointment.setDoctor(String.valueOf(cursor.getString(0)));
                appointment.setDate(cursor.getString(1));
                appointment.setTime(cursor.getString(2));
                appointments.add(appointment);
            }while(cursor.moveToNext());
        }
        db.close();
        return appointments;
    }

    public boolean isEmpty(String TableName){

        SQLiteDatabase database = this.getReadableDatabase();
        long NoOfRows = DatabaseUtils.queryNumEntries(database,TableName);

        if (NoOfRows == 0){
            return true;
        } else {
            return false;
        }
    }

}
