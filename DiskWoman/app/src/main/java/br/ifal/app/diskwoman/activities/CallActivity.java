package br.ifal.app.diskwoman.activities;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import br.ifal.app.diskwoman.R;

public class CallActivity extends AppCompatActivity {

    private static final int REQUEST_CALL = 123;

    TextView number1 = findViewById(R.id.textview_institution_1);
    TextView number2 = findViewById(R.id.textview_institution_2);
    TextView number3 = findViewById(R.id.textview_institution_3);

    TextView [] txtViewArray = {number1, number2, number3};

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_call);
        ImageButton btn1 = findViewById(R.id.imagebutton_call_id_1);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ContextCompat.checkSelfPermission(CallActivity.this,Manifest.permission.CALL_PHONE)!= PackageManager.PERMISSION_GRANTED){
                    ActivityCompat.requestPermissions(CallActivity.this,
                            new String [] {Manifest.permission.CALL_PHONE}, REQUEST_CALL);
                }
                else {
                    String call = "tel:"+ number1;
                    Intent i = new Intent(Intent.ACTION_CALL, Uri.parse(call));
                    startActivity(i);
                }


            }

        });
        ImageButton btn2 = findViewById(R.id.imagebutton_call_id_2);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ContextCompat.checkSelfPermission(CallActivity.this,Manifest.permission.CALL_PHONE)!= PackageManager.PERMISSION_GRANTED){
                    ActivityCompat.requestPermissions(CallActivity.this,
                            new String [] {Manifest.permission.CALL_PHONE}, REQUEST_CALL);
                }
                else {
                    String call = "tel:" + number2;
                    Intent i = new Intent(Intent.ACTION_CALL, Uri.parse(call));
                    startActivity(i);
                }
            }
        });

        ImageButton btn3= findViewById(R.id.imagebutton_call_id_3);
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ContextCompat.checkSelfPermission(CallActivity.this,Manifest.permission.CALL_PHONE)!= PackageManager.PERMISSION_GRANTED){
                    ActivityCompat.requestPermissions(CallActivity.this,
                            new String [] {Manifest.permission.CALL_PHONE}, REQUEST_CALL);
                }
                else {
                    String call = "tel:" + number2;
                    Intent i = new Intent(Intent.ACTION_CALL, Uri.parse(call));
                    startActivity(i);

            }
        });
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if (requestCode == REQUEST_CALL) {
            if(grantResults.length > 0 && grantResults [0] == PackageManager.PERMISSION_GRANTED){

                Intent i = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + txtViewArray[0]));
                startActivity(i);
            } else {
                Toast.makeText(this,"Permission DENIED", Toast.LENGTH_SHORT).show();
            }

        }
    }
}
