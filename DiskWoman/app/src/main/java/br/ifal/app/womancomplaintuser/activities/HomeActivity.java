package br.ifal.app.womancomplaintuser.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import br.ifal.app.womancomplaintuser.R;

public class HomeActivity extends AppCompatActivity {


    ImageButton home, call, listOccurrences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_home);

        home = (ImageButton) findViewById(R.id.imagebutton_home_id);
        call = (ImageButton) findViewById(R.id.imagebutton_call_id);
        listOccurrences = (ImageButton) findViewById(R.id.imagebutton_occurrences_id);

        home.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Toast.makeText(HomeActivity.this, "Você está na página inicial", Toast.LENGTH_LONG).show();
            }
        });

        call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, CallActivity.class);
                startActivity(intent);
            }
        });


        listOccurrences.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, ListOccurrencesActivity.class);
                startActivity(intent);
            }
        });

        FloatingActionButton floatingButton = findViewById(R.id.floatingbtn_registeroccurrences_id);
        floatingButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, RegisterOccurrenceActivity.class);
                startActivity(intent);
            }

        });
    }

}
