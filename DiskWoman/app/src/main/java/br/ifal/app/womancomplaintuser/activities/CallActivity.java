package br.ifal.app.womancomplaintuser.activities;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import br.ifal.app.womancomplaintuser.R;

public class CallActivity extends AppCompatActivity {

    private Context context;

    ImageButton imgBtnCall1;
    ImageButton imgBtnCall2;

    TextView number1;
    TextView number2;

    int firstNumber;
    int secondNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_call);

        imgBtnCall1 = (ImageButton) findViewById(R.id.imagebutton_call_id_2);
        imgBtnCall2 = (ImageButton) findViewById(R.id.imagebutton_call_id_1);

        number1 = (TextView) findViewById(R.id.textview_number_1);
        number2 = (TextView) findViewById(R.id.textview_number_2);

        firstNumber = Integer.parseInt(number1.getText().toString());
        secondNumber = Integer.parseInt(number2.getText().toString());

        imgBtnCall1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (ActivityCompat.checkSelfPermission(context,
                        Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {

                    String[] permissions = {Manifest.permission.CALL_PHONE};
                    ActivityCompat.requestPermissions(CallActivity.this, permissions,
                            123);

                } else {
                    Intent i = new Intent(Intent.ACTION_CALL);
                    i.setData(Uri.parse("tel:" + firstNumber));
                    startActivity(i);
                }

            }
        });

        imgBtnCall2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ActivityCompat.checkSelfPermission(context,
                        Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {

                    String[] permissions = {Manifest.permission.CALL_PHONE};
                    ActivityCompat.requestPermissions(CallActivity.this, permissions,
                            123);

                } else {
                    Intent i = new Intent(Intent.ACTION_CALL);
                    i.setData(Uri.parse("tel:" + secondNumber));
                    startActivity(i);
                }
            }
        });

    }

    /*
    @SuppressLint("MissingPermission")
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions,
                                           @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if (permissions[0].equals(Manifest.permission.CALL_PHONE) &&
                grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            Intent i = new Intent(Intent.ACTION_CALL);
            i.setData(Uri.parse("tel:" + firstNumber));
            startActivity(i);
        }
    }
*/

}