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

    public static final String UPLOAD_URL = "https://192.168.56.1/misitu/apply.php";

    //Pdf request code
    private int PICK_PDF_REQUEST = 1;
    //storage permission code
    private static final int STORAGE_PERMISSION_CODE = 123;



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

        prg = new ProgressDialog(this);
//        Toast.makeText(this, maelezoYote, Toast.LENGTH_SHORT).show();

        sheha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent chooseFile = new Intent(Intent.ACTION_GET_CONTENT);
                chooseFile.setType("*/*");
                chooseFile = Intent.createChooser(chooseFile, "Choose a file");
                startActivityForResult(chooseFile, 0);
            }
        });

        kibali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent chooseFile = new Intent(Intent.ACTION_GET_CONTENT);
                chooseFile.setType("*/*");
                chooseFile = Intent.createChooser(chooseFile, "Choose a file");
                startActivityForResult(chooseFile, 1);
            }
        });

        sendData.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(shehaName.toString().equals("") && kibaliName.toString().equals(" ")) {
                    Toast.makeText(getApplication(), "Tafadhali Chagua Viambatanishi", Toast.LENGTH_LONG).show();
                }
                else {
                    event();

                }

            }
        });
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 0 && resultCode == RESULT_OK && null != data){
            fileUriSheha = data.getData();
            filePathSheha = fileUriSheha.getPath();
            shehaName.setText(filePathSheha);
        }

        else if (requestCode == 1 && resultCode == RESULT_OK && null != data) {
            fileUri = data.getData();
            filePath = fileUri.getPath();
            kibaliName.setText(filePath);

        }
        else
        {
            Toast.makeText(this, "HujaChagua Kiambatanishi Chochote", Toast.LENGTH_LONG).show();
        }
    }


    public void event(){

        prg.setMessage("Sending Application ...");
        prg.show();
        Map<String, String> postParam= new HashMap<String, String>();


        postParam.put("un", maelezoYote);






        JsonObjectRequest jsonReq = new JsonObjectRequest(Request.Method.POST, "https://192.168.56.1/misitu/apply.php",
                new JSONObject(postParam),
                new Response.Listener<JSONObject>(){
                    @Override
                    public void onResponse(JSONObject response){
                        prg.dismiss();
                        try {
                            JSONObject jsObj = new JSONObject(response.toString());
                            Toast.makeText(getApplicationContext(), jsObj.getString("message"), Toast.LENGTH_SHORT).show();
                        }
                        catch (JSONException ex){
                            ex.printStackTrace();
                        }

                    }
                },
                new Response.ErrorListener(){
                    @Override
                    public void onErrorResponse(VolleyError error){
                        prg.hide();
                        Toast.makeText(getApplicationContext(), error.getMessage(), Toast.LENGTH_LONG).show();
                    }
                })
        {
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
            HashMap<String, String> headers = new HashMap<String, String>();
            headers.put("Content-Type", "application/json; charset=utf-8");
            return headers;
        }
        };

        RequestQueue reqQue = Volley.newRequestQueue(this);
        reqQue.add(jsonReq);

    }

}