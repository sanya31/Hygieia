package com.sanyagupta.healthdream;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Buy extends AppCompatActivity {
    TextView name,price;
    Button buy1,buy2,buy3,buy4;
    String Name;
    double Price;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy);

        buy1=findViewById(R.id.buy1);
        buy2=findViewById(R.id.buy2);
        buy3=findViewById(R.id.buy3);
        buy4=findViewById(R.id.buy4);

        buy1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                name=findViewById(R.id.med1);
                price=findViewById(R.id.price1);
                Name = name.getText().toString();
                Price = Double.valueOf(price.getText().toString().substring(15));
                Intent intent = new Intent(Buy.this, Payment.class);
                intent.putExtra("med_name", Name);
                intent.putExtra("med_price", Price);
                startActivity(intent);
            }
        });
        buy2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                name=findViewById(R.id.med2);
                price=findViewById(R.id.price2);
                Name = name.getText().toString();
                Price = Double.valueOf(price.getText().toString().substring(15));
                Intent intent = new Intent(Buy.this, Payment.class);
                intent.putExtra("med_name", Name);
                intent.putExtra("med_price", Price);
                startActivity(intent);
            }
        });
        buy3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                name=findViewById(R.id.med3);
                price=findViewById(R.id.price3);
                Name = name.getText().toString();
                Price = Double.valueOf(price.getText().toString().substring(15));
                Intent intent = new Intent(Buy.this, Payment.class);
                intent.putExtra("med_name", Name);
                intent.putExtra("med_price", Price);
                startActivity(intent);
            }
        });
        buy4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                name=findViewById(R.id.med4);
                price=findViewById(R.id.price4);
                Name = name.getText().toString();
                Price = Double.valueOf(price.getText().toString().substring(15));
                Intent intent = new Intent(Buy.this, Payment.class);
                intent.putExtra("med_name", Name);
                intent.putExtra("med_price", Price);
                startActivity(intent);
            }
        });
    }
}