package br.ifal.app.diskwoman.activities;

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
import br.ifal.app.diskwoman.daos.WomenDAO;

public class RegisterOccurrenceActivity  extends  AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_register);

        Button btnZipCode = findViewById(R.id.btn_zipcode_id);
        btnZipCode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText editTextZipCode = findViewById(R.id.edittext_zipcode_id);
                String zipCode = editTextZipCode.getText().toString();

                QueryTask query = new QueryTask(RegisterOccurrenceActivity.this);
                query.execute(zipCode);
            }
        });

        Intent intent = getIntent();
        if (intent.hasExtra("occurrences") && intent.hasExtra("women")) {

            EditText editTextName = findViewById(R.id.edittext_name_id);
            EditText editTextEmail = findViewById(R.id.edittext_email_id);
            EditText editTextStreet = findViewById(R.id.edittext_street_id);
            EditText editTextCity = findViewById(R.id.edittext_city_id);
            EditText editTextNeighborhood = findViewById(R.id.edittext_neighborhood_id);
            EditText editTextNumber = findViewById(R.id.edittext_number_id);
            EditText editTextZipCode = findViewById(R.id.edittext_zipcode_id);


            Occurrences occurrences = (Occurrences) intent.getSerializableExtra("occurrences");
            editTextCity.setText(occurrences.getCity());
            editTextStreet.setText(occurrences.getStreet());
            editTextNeighborhood.setText(occurrences.getNeighborhood());
            editTextZipCode.setText(occurrences.getAddressCep());
            editTextNumber.setText(occurrences.getAddressNumber());

            Women women = (Women) intent.getSerializableExtra("women");
            editTextName.setText(women.getName());
            editTextEmail.setText(women.getEmail());

        }

        Button btnSend = findViewById(R.id.btn_send_id);
        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText editTextName = findViewById(R.id.edittext_name_id);
                EditText editTextEmail = findViewById(R.id.edittext_email_id);
                EditText editTextStreet = findViewById(R.id.edittext_street_id);
                EditText editTextCity = findViewById(R.id.edittext_city_id);
                EditText editTextNeighborhood = findViewById(R.id.edittext_neighborhood_id);
                EditText editTextNumber = findViewById(R.id.edittext_number_id);
                EditText editTextZipCode = findViewById(R.id.edittext_zipcode_id);

                String name = editTextName.getText().toString();
                String email = editTextEmail.getText().toString();
                String street = editTextStreet.getText().toString();
                String city = editTextCity.getText().toString();
                String neighborhood = editTextNeighborhood.getText().toString();
                String number = editTextNumber.getText().toString();
                String zipCode = editTextZipCode.getText().toString();

                WomenDAO womDAO = new WomenDAO(RegisterOccurrenceActivity.this);
                OccurrencesDAO occDAO = new OccurrencesDAO(RegisterOccurrenceActivity.this);

                Intent intent = getIntent() ;
                if (intent.hasExtra("occurrences") && intent.hasExtra("women")) {
                    Occurrences occurrences = (Occurrences) intent.getSerializableExtra("occurrences");
                    occurrences.setAddressCep(zipCode);
                    occurrences.setAddressNumber(number);

                    Women women = (Women) intent.getSerializableExtra("women");
                    women.setName(name);
                    women.setEmail(email);

                    occDAO.update(occurrences);
                    womDAO.update(women);



                } else {
                    Intent it = new Intent(RegisterOccurrenceActivity.this, StoreOccurrenceActivity.class);
                    it.putExtra("zipCode", zipCode);
                    it.putExtra("number", number);
                    it.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
                    startActivity(it);



                    Women women = new Women(name, email);
                    womDAO.save(women);


                }
                finish();
            }


        });
    }
}
