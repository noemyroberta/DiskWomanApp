package br.ifal.app.diskwoman.activities;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import br.ifal.app.diskwoman.beans.Occurrences;
import br.ifal.app.diskwoman.services.QueryTask;
import br.ifal.app.diskwoman.R;

import br.ifal.app.diskwoman.daos.OccurrencesDAO;


public class RegisterOccurrenceActivity extends AppCompatActivity {

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


        OccurrencesDAO occDAO = new OccurrencesDAO(RegisterOccurrenceActivity.this);

        Intent intent = getIntent();
        if (intent.hasExtra("occurrences")) {
            Occurrences occurrences = (Occurrences) intent.getSerializableExtra("occurrences");
            occurrences.getCity();
            occurrences.getStreet();
            occurrences.getNeighborhood();
            occurrences.getTitle();
            occurrences.getDescription();
            occurrences.getImage();
            occurrences.getDate();
            occurrences.getAddressCep();
            occurrences.getAddressNumber();
            occurrences.getAddressComplement();

            occDAO.update(occurrences);
            System.out.println(occurrences.getId() + " " + occurrences.toString());


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

                    Intent intent = new Intent(RegisterOccurrenceActivity.this, StoreOccurrenceActivity.class);
                    startActivity(intent);
                }
            });
        }

    }
}
