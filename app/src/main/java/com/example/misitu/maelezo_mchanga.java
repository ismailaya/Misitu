package com.example.misitu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class maelezo_mchanga extends AppCompatActivity {

    Button viambatanishi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maelezo_mchanga);

        viambatanishi = (Button)findViewById(R.id.btnViambatanishi);
        viambatanishi.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                event();
            }
        });

    }

    public void event() {
        Intent intent = new Intent(maelezo_mchanga.this, viambatanishi.class);
        startActivity(intent);
        finish();
    }
}