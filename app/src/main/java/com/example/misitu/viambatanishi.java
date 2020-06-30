package com.example.misitu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class viambatanishi extends AppCompatActivity {
    public static final int PICKFILE_RESULT_CODE = 1;
    public static final int PICKFILE_RESULT_CODE2 = 1;

    Button sheha, kibali;
    TextView shehaName, kibaliName;
    private Uri fileUri;
    private String filePath;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viambatanishi);
        //getSupportActionBar().hide();

        sheha = (Button)findViewById(R.id.btnSheha);
        shehaName = (TextView)findViewById(R.id.shehaName);
        kibali = (Button)findViewById(R.id.btnKibali);
        kibaliName = (TextView)findViewById(R.id.kibaliName);

        sheha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent chooseFile = new Intent(Intent.ACTION_GET_CONTENT);
                chooseFile.setType("*/*");
                chooseFile = Intent.createChooser(chooseFile, "Choose a file");
                startActivityForResult(chooseFile, PICKFILE_RESULT_CODE);
            }
        });

        kibali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent chooseFile = new Intent(Intent.ACTION_GET_CONTENT);
                chooseFile.setType("*/*");
                chooseFile = Intent.createChooser(chooseFile, "Choose a file");
                startActivityForResult(chooseFile, PICKFILE_RESULT_CODE2);
            }
        });
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode) {
            case PICKFILE_RESULT_CODE:
                if (resultCode == -1) {
                    fileUri = data.getData();
                    filePath = fileUri.getPath();
                    shehaName.setText(filePath);
                }
                else {
                    fileUri = data.getData();
                    filePath = fileUri.getPath();
                    kibaliName.setText(filePath);
                }
                break;

        }
    }

}