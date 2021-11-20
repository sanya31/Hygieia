package com.sanyagupta.healthdream;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Payment extends AppCompatActivity {
TextView name,price,total,d;
Button Pay,donate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);

        Intent intent = getIntent();
        String medName=intent.getStringExtra("med_name");
        double medPrice = intent.getDoubleExtra("med_price",0);

        name=findViewById(R.id.name);
        price=findViewById(R.id.price);
        total=findViewById(R.id.total);
        Pay =findViewById(R.id.pay);
        donate=findViewById(R.id.donate_btn);
        d=findViewById(R.id.donate);
        name.setText(medName);
        price.setText(String.format("%.2f",medPrice));

        Pay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog();
            }
        });

        donate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                d.setText("₹ 1");
                double amount = medPrice + Double.valueOf(d.getText().toString().substring(2));
                total.setText("₹ "+String.format("%.2f",amount));
            }
        });

        double amount = medPrice + Double.valueOf(d.getText().toString().substring(2));
        total.setText("₹ "+String.format("%.2f",amount));
    }


    private void showDialog() {
        final AlertDialog.Builder dialog =new AlertDialog.Builder(this);
        LayoutInflater inflater = LayoutInflater.from(this);
        View reg_layout = inflater.inflate(R.layout.paymentdone, null);
        dialog.setView(reg_layout);

        Button ok =reg_layout.findViewById(R.id.ok);

        AlertDialog alertDialog = dialog.create();

        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertDialog.dismiss();
            }
        });

        alertDialog.show();
    }


}