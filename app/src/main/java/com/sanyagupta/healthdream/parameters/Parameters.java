package com.sanyagupta.healthdream.parameters;

public class Parameters {
    public static final int DB_VERSION = 1;
    public static final String DB_Name = "HealthDream_db";

    //Table Names:
    public static final String TABLE_1 = "UserDetails_table";
    public static final String TABLE_2 = "FamilyDetails_table";
    public static final String TABLE_3 = "Treatment_table";
    public static final String MONDAY = "Monday_table";
    public static final String TUESDAY = "Tuesday_table";
    public static final String WEDNESDAY = "Wednesday_table";
    public static final String THURSDAY = "Thursday_table";
    public static final String FRIDAY = "Friday_table";
    public static final String SATURDAY = "Saturday_table";
    public static final String SUNDAY = "Sunday_table";


    //Column Names : TABLE_1
    public static final String KEY_EMAIL = "email";
    public static final String KEY_NAME = "name";
    public static final String KEY_PHONE = "phone_number";
    public static final String KEY_AGE = "age";
    public static final String KEY_GENDER = "gender";
    public static final String KEY_AREA = "area";

    //Column Names: TABLE_2
    public static final String KEY_FNAME = "name";
    public static final String KEY_ID = "id";
    public static final String KEY_FPHONE = "phone";
    public static final String KEY_FEMAIL = "email";

    //Column Names: TABLE_3
    public static final String KEY_DNAME = "doctor_name";
    public static final String KEY_DATE = "date";
    public static final String KEY_TIME = "time";

    //Column Names: Week Tables
    public static final String KEY_MEDNAME = "medicine_name";
    public static final String KEY_TIME1 = "time";
    public static final String KEY_DAY = "day";
}
