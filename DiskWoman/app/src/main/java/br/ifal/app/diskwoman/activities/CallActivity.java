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

    ImageButton btn1;
    ImageButton btn2;
    ImageButton btn3;

    String[] numbersArray;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_call);

        String number1 = "35216318";
        String number2 = "180";
        String number3 = "192";

        numbersArray = new String[] {number1, number2, number3};

        btn1 = findViewById(R.id.imagebutton_call_id_1);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(ContextCompat.checkSelfPermission(CallActivity.this, Manifest.permission.CALL_PHONE)
                        != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(CallActivity.this,
                            new String[]{Manifest.permission.CALL_PHONE}, REQUEST_CALL);
                } else {
                    String call = "tel:" + number1;
                    Intent i = new Intent(Intent.ACTION_CALL, Uri.parse(call));
                    startActivity(i);
                }
            }
        });

        btn2 = findViewById(R.id.imagebutton_call_id_2);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ContextCompat.checkSelfPermission(CallActivity.this, Manifest.permission.CALL_PHONE)
                        != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(CallActivity.this,
                            new String[]{Manifest.permission.CALL_PHONE}, REQUEST_CALL);
                } else {
                    String call = "tel:" + number2;
                    Intent i = new Intent(Intent.ACTION_CALL, Uri.parse(call));
                    startActivity(i);
                }
            }
        });

        btn3 = findViewById(R.id.imagebutton_call_id_3);
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ContextCompat.checkSelfPermission(CallActivity.this,
                        Manifest.permission.CALL_PHONE)
                        != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(CallActivity.this,
                            new String[]{Manifest.permission.CALL_PHONE}, REQUEST_CALL);
                } else {
                    String call = "tel:" + number3;
                    Intent i = new Intent(Intent.ACTION_CALL, Uri.parse(call));
                    startActivity(i);
                }
            }
        });

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if (requestCode == REQUEST_CALL) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                if(btn1.isPressed() == true) {
                    Intent i = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + numbersArray[0]));
                    startActivity(i);
                } else if (btn2.isPressed() == true) {
                    Intent i = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + numbersArray[1]));
                    startActivity(i);
                } else if (btn3.isPressed() == true) {
                    Intent i = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + numbersArray[2]));
                    startActivity(i);
                }
            } else {
                Toast.makeText(this, "Permission Denied", Toast.LENGTH_SHORT).show();
            }

        }
    }
}