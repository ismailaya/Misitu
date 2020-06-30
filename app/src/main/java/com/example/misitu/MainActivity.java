package com.example.misitu;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;

import com.shivamkibhu.onboardwalkthrough.OnboardWalkthrough;
import com.shivamkibhu.onboardwalkthrough.Page;
import com.shivamkibhu.onboardwalkthrough.PageListener;

public class MainActivity extends AppCompatActivity {

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().hide();
        OnboardWalkthrough view = findViewById(R.id.mainView);

        Page page1 = new Page();
        Page page2 = new Page();
        Page page3 = new Page();

        Typeface typeface = getResources().getFont(R.font.abyssinicasil_regular);


        page1.setTitle("Green")
                .setDescription("Omba Mchanga Popote Ulipo")
                .setBackgroundColor("#7bed9f")
                .setImage(R.drawable.picone)
                .setImageLayoutParams(500, 100, 300, 300, 300, 0);



        page2.setTitle("Green")
                .setDescription("Pata Taarifa za Mchanga Kupitia Simu Yako")
                .setBackgroundColor("#7bed9f")
                .setImage(R.drawable.onec)
                .setImageLayoutParams(500, 100, 300, 300, 300, 0);



        page3.setTitle("Green")
                .setDescription("Mchanga Kiganjani Mwako")
                .setBackgroundColor("#7bed9f")
                .setImage(R.drawable.three)
                .setImageLayoutParams(500, 100, 300, 300, 300, 0);



        view.setStartTitle("Anza Maombi")
                .setStartClickListener(new PageListener() {
                    @Override
                    public void OnClick() {
                        Intent intent = new Intent(MainActivity.this,Menu.class);
                        startActivity(intent);
                        finish();
                    }
                }).setSkipClickListener(new PageListener() {
            @Override
            public void OnClick() {
                Intent intent = new Intent(MainActivity.this,Menu.class);
                startActivity(intent);
                finish();
            }
        });


        view.add(page1);
        view.add(page2);
        view.add(page3);


        view.build();

    }

}