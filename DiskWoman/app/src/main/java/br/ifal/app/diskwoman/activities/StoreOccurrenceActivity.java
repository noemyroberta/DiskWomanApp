package br.ifal.app.diskwoman.activities;


import android.Manifest;
import android.widget.ArrayAdapter;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import br.ifal.app.diskwoman.beans.Occurrences;
import br.ifal.app.diskwoman.beans.Women;
import br.ifal.app.diskwoman.services.QueryTask;
import br.ifal.app.diskwoman.R;

import br.ifal.app.diskwoman.daos.OccurrencesDAO;

import android.content.pm.PackageManager;
import android.widget.Toast;

public class StoreOccurrenceActivity extends AppCompatActivity {

    private ArrayAdapter adapter;
    private Button storage, register;

    private static final int STORAGE_PERMISSION_CODE = 100;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store);

        register = findViewById(R.id.btn_register_id);
        register.setOnClickListener(new view.onClickListenet() {


            public void onClick(View v) {

                EditText editTextTitle = findViewById(R.id.edittext_title_id);
                EditText editTextDescription = findViewById(R.id.edittext_desc_id);
                EditText editTextDate = findViewById(R.id.edittext_date_id);

                String title = editTextTitle.getText().toString();
                String description = editTextDescription.getDescription().toString();
                String date = editTextDate.getDate().toString();

                OccurrencesDAO occDAO = new OccurrencesDAO(StoreOccurrenceActivity.this);


                Intent intent = getIntent();
                if (intent.hasExtra("occurrences")) {

                    EditText editTextTitle = findViewById(R.id.edittext_title_id);
                    EditText editTextDescription = findViewById(R.id.edittext_desc_id);
                    EditText editTextDate = findViewById(R.id.edittext_date_id);

                    Occurrences occurrences = (Occurrences) intent.getSerializableExtra("occurrences");
                    editTextTitle.setText(occurrences.getTitle());
                    editTextDescription.setText(occurrences.getDescription());
                    editTextDate.setText(occurrences.getDate());

                } else {

                    Occurrences occurrences = new Occurrences(title, description, date);
                    occDAO.save(occurrences);

                }

                finish();

            }

        });

        storage = findViewById(R.id.btn_image_id);
        storage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkPermission(Manifest.permission.READ_EXTERNAL_STORAGE);
            }
        });


        public void checkPermission (String Manifest.permission.READ_EXTERNAL_STORAGE,int requestCode){

            if (ContextCompat.checkSelfPermission(StoreOccurrenceActivity.this, Manifest.permission.READ_EXTERNAL_STORAGE)
                    != PackageManager.PERMISSION_GRANTED){

                ActivityCompat.requestPermissions(StoreOccurrenceActivity.this, new String[]{permission},
                        requestCode);
            } else {

                Toast.makeText(StoreOccurrenceActivity.this, "Permissão já concedida",
                        Toast.LENGTH_SHORT).show();
            }

        }
    }

        public void onRequestPermissionResult ( int requestCode, String[] permissions,
        int[] grantResults){

            super.onRequestPermissionsResult(requestCode, permissions, grantResults);

            if (requestCode == STORAGE_PERMISSION_CODE) {

                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                    Toast.makeText(StoreOccurrenceActivity.this, "Permissão concedida",
                            Toast.LENGTH_SHORT).show();

                } else {

                    Toast.makeText(StoreOccurrenceActivity.this, "Permissão não concedida",
                            Toast.LENGTH_SHORT).show();

                }

            }


        }


    }



       /* String title = editTextTitle.getText().toString();
        String description = editTextDescription.getText().toString();
        String date = editTextDate.getText().toString();*/






    /*@Override
    protected void onNewIntent(Intent intent) {

        String zipCode = intent.getStringExtra("zipCode");
        String number = intent.getDoubleExtra("number", -1);

        if(zipCode != null)
            carro.add( new Desejo(texto,numero));
        carroAdapter  = new ArrayAdapter<Carro>(this, android.R.layout.simple_list_item_1,carro );
        listaCarro.setAdapter(carroAdapter);*/