package com.sanyagupta.healthdream;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Help extends AppCompatActivity {
    TextView help1,help2, help3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);

        help1 = findViewById(R.id.neb);
        help2=findViewById(R.id.inh);
        help3=findViewById(R.id.syr);

        help1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Help.this, Help1.class);
                startActivity(intent);
            }
        });
        help2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Help.this, Help2.class);
                startActivity(intent);
            }
        });
        help3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Help.this, Help3.class);
                startActivity(intent);
            }
        });

    }
}