package com.example.misitu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class malezo_binafsi extends AppCompatActivity {

    Button endelea;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_malezo_binafsi);

        //getSupportActionBar().hide();
        endelea = (Button)findViewById(R.id.btnMchanga);

        endelea.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                event();
            }
        });


    }

    public void event() {
        Intent intent = new Intent(malezo_binafsi.this, maelezo_mchanga.class);
        startActivity(intent);
        finish();
    }
}