package com.example.misitu;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class viambatanishi extends AppCompatActivity {



    Button sheha, kibali, sendData;
    TextView shehaName, kibaliName;
    private Uri fileUri;
    private Uri fileUriSheha;
    private String filePath;
    private String filePathSheha;
    String maelezoYote;
    private ProgressDialog prg;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viambatanishi);
        //getSupportActionBar().hide();

        sheha = (Button)findViewById(R.id.btnSheha);
        shehaName = (TextView)findViewById(R.id.shehaName);
        kibali = (Button)findViewById(R.id.btnKibali);
        sendData = (Button)findViewById(R.id.btnTuma);
        kibaliName = (TextView)findViewById(R.id.kibaliName);
        Intent tester = getIntent();
        maelezoYote = tester.getStringExtra("maelezoYote");


    }






}