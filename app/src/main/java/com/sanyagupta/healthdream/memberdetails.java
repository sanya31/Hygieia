package com.sanyagupta.healthdream;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.fragment.app.Fragment;

import com.sanyagupta.healthdream.models.Family;


public class memberdetails extends Fragment {

    View view;
    EditText name,email,phone;
    Button save;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_memberdetails, container, false);
        MyDbHandler db=new MyDbHandler(container.getContext());
        name=view.findViewById(R.id.name);
        email=view.findViewById(R.id.email);
        phone=view.findViewById(R.id.Phone);
        save=view.findViewById(R.id.save);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Name=name.getText().toString();
                String Email=email.getText().toString();
                String Phone=phone.getText().toString();
                Family family = new Family(Name,Phone,Email);
                db.addFamily(family);
            }
        });
        return view;
    }
}