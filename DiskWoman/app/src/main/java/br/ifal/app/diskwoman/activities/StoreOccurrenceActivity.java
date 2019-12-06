package br.ifal.app.diskwoman.activities;


import android.widget.ArrayAdapter;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import br.ifal.app.diskwoman.beans.Occurrences;
import br.ifal.app.diskwoman.beans.Women;
import br.ifal.app.diskwoman.services.QueryTask;
import br.ifal.app.diskwoman.R;

import br.ifal.app.diskwoman.daos.OccurrencesDAO;

public class StoreOccurrenceActivity extends AppCompatActivity {

    private ArrayAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_store);


        Intent intent = getIntent();
        if (intent.hasExtra("occurrences")) {

            EditText editTextTitle = findViewById(R.id.edittext_title_id);
            EditText editTextDescription = findViewById(R.id.edittext_desc_id);
            EditText editTextDate = findViewById(R.id.edittext_date_id);

            Occurrences occurrences = (Occurrences) intent.getSerializableExtra("occurrences");
            editTextTitle.setText(occurrences.getTitle());
            editTextDescription.setText(occurrences.getDescription());
            editTextDate.setText(occurrences.getDate());
        }



        Button btnImage = findViewById(R.id.btn_image_id);
        Button btnRegister = findViewById(R.id.btn_register_id);

        String title = editTextTitle.getText().toString();
        String description = editTextDescription.getText().toString();
        String date = editTextDate.getText().toString();

    }


    private void pickFromGallery(){

        Intent intent = new Intent(Intent.ACTION_PICK);
        // Sets the type as image/*. This ensures only components of type image are selected
        intent.setType("image/*");
        //We pass an extra array with the accepted mime types. This will ensure only components with these MIME types as targeted.
        String[] mimeTypes = {"image/jpeg", "image/png"};
        intent.putExtra(Intent.EXTRA_MIME_TYPES,mimeTypes);
        // Launching the Intent
        startActivityForResult(intent,GALLERY_REQUEST_CODE);

    }





    /*@Override
    protected void onNewIntent(Intent intent) {

        String zipCode = intent.getStringExtra("zipCode");
        String number = intent.getDoubleExtra("number", -1);

        if(zipCode != null)
            carro.add( new Desejo(texto,numero));
        carroAdapter  = new ArrayAdapter<Carro>(this, android.R.layout.simple_list_item_1,carro );
        listaCarro.setAdapter(carroAdapter);*/






    }
}

