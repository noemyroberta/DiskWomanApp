package br.ifal.app.diskwoman.activities;


import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.ArrayAdapter;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import android.provider.MediaStore;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.core.content.FileProvider;

import java.io.File;
import br.ifal.app.diskwoman.beans.Occurrences;
import br.ifal.app.diskwoman.BuildConfig;
import br.ifal.app.diskwoman.R;

import br.ifal.app.diskwoman.daos.OccurrencesDAO;

import android.content.pm.PackageManager;
import android.widget.ImageView;
import android.widget.Toast;

public class StoreOccurrenceActivity extends AppCompatActivity {

    private ArrayAdapter adapter;
    private Button storage, register;
    private String filePath;

    private static final int REQUEST_CODE = 100;

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        String zipCode = intent.getStringExtra("zipCode");
        String number = intent.getStringExtra("number");
        setIntent(intent);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store);

        storage = findViewById(R.id.btn_image_id);
        storage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

                filePath = getExternalFilesDir (null) + "/" + System.currentTimeMillis() + ".jpg";
                File file = new File(filePath);
                intent.putExtra(MediaStore.EXTRA_OUTPUT,
                        FileProvider.getUriForFile(
                                StoreOccurrenceActivity.this,
                                BuildConfig.APPLICATION_ID + ".provider",
                                file
                        ));

                startActivityForResult(intent, 100);

            }
        });


        register = findViewById(R.id.btn_register_id);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText editTextTitle = findViewById(R.id.edittext_title_id);
                EditText editTextDescription = findViewById(R.id.edittext_desc_id);
                EditText editTextDate = findViewById(R.id.edittext_date_id);

                String title = editTextTitle.getText().toString();
                String description = editTextDescription.getText().toString();
                String date = editTextDate.getText().toString();

                OccurrencesDAO occDAO = new OccurrencesDAO(StoreOccurrenceActivity.this);

                String zipCode = getIntent().getStringExtra("zipCode");
                String number = getIntent().getStringExtra("number");

                Intent intent = getIntent();
                if (intent.hasExtra("occurrences")) {

                    Occurrences occurrences = (Occurrences) intent.getSerializableExtra("occurrences");
                    editTextTitle.setText(occurrences.getTitle());
                    editTextDescription.setText(occurrences.getDescription());
                    editTextDate.setText(occurrences.getDate());

                } else {
                    /*Occurrences occurrences = new Occurrences(title, description, date, zipCode, number);
                    occDAO.save(occurrences);*/
                }

                finish();

            }

        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data){
        super.onActivityResult(requestCode, resultCode, data);
        setImage(filePath);
    }

    private void setImage(String foto){
        ImageView imageView = findViewById(R.id.form_ins_img);
        Bitmap bitmap = BitmapFactory.decodeFile(foto);
        imageView.setImageBitmap(bitmap);
        imageView.setTag(foto);
    }


    /*public void checkPermission(String permission, int requestCode) {

        if (ContextCompat.checkSelfPermission(StoreOccurrenceActivity.this, permission)
                == PackageManager.PERMISSION_GRANTED) {

            ActivityCompat.requestPermissions(StoreOccurrenceActivity.this, new String[]{permission},
                    requestCode);

        } else {

            Toast.makeText(StoreOccurrenceActivity.this, "Permissão já concedida",
                    Toast.LENGTH_SHORT).show();
        }

    }


    public void onRequestPermissionResult(int requestCode, String[] permissions,
                                          int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if (requestCode == REQUEST_CODE) {

            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {


                Toast.makeText(StoreOccurrenceActivity.this, "Permissão concedida",
                        Toast.LENGTH_SHORT).show();

            } else {

                Toast.makeText(StoreOccurrenceActivity.this, "Permissão não concedida",
                        Toast.LENGTH_SHORT).show();
            }
        }
    }*/

}


    /* String title = editTextTitle.getText().toString();
        String description = editTextDescription.getText().toString();
        String date = editTextDate.getText().toString();*/