package br.ifal.app.diskwoman.activities;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import br.ifal.app.diskwoman.beans.Offenders;
import br.ifal.app.diskwoman.services.QueryTask;
import br.ifal.app.diskwoman.R;

import br.ifal.app.diskwoman.daos.OffendersDAO;


public class RegisterOffendersActivity extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    setContentView(R.layout.activity_register_offenders);

    Intent intent = getIntent();
    if(intent.hasExtra("offenders")){
        EditText editTextName = findViewById(R.id.edittext_offe_name_id);
        EditText editTextSex = findViewById(R.id.edittext_offe_sex_id);
        EditText editTextAppearence = findViewById(R.id.edittext_offe_appearence_id);
        EditText editTextAge = findViewById(R.id.edittext_offe_age_id);

        Offenders offenders = (Offenders) intent.getSerializableExtra("offenders");
        editTextName.setText(offenders.getName());
        editTextAppearence.setText(offenders.getAppearence());
        editTextAge.setText(offenders.getAge());
        


    }

    }
}
