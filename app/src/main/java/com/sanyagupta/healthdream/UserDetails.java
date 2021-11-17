package com.sanyagupta.healthdream;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.sanyagupta.healthdream.models.User;
import com.sanyagupta.healthdream.parameters.Parameters;

import java.lang.reflect.Parameter;

public class UserDetails extends AppCompatActivity {
    Button save;
    EditText name,email,age,phone,area;
    Spinner list;
    MyDbHandler db=new MyDbHandler(UserDetails.this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_details);

        save=findViewById(R.id.save);
        name=findViewById(R.id.name);
        email=findViewById(R.id.email);
        age=findViewById(R.id.age);
        phone=findViewById(R.id.phone);
        area = findViewById(R.id.city);
        list=findViewById(R.id.gender);

        ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(UserDetails.this, android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.gender));
        myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        list.setAdapter(myAdapter);


        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Name = name.getText().toString();
                String Email = email.getText().toString();
                int Age = Integer.valueOf(age.getText().toString());
                String Phone = phone.getText().toString();
                String Area = area.getText().toString();
                String Gender = list.getSelectedItem().toString();
                User user = new User(Name, Phone, Gender, Area, Email, Age);
                db.addUser(user);
                //Toast.makeText(UserDetails.this, "Your details are saved", Toast.LENGTH_SHORT).show();
                boolean isempty=db.isEmpty(Parameters.TABLE_2);
                if(isempty){
                    Intent intent=new Intent(UserDetails.this, FamilyDetails.class);
                    startActivity(intent);
                }
            }
            });
        }
}
