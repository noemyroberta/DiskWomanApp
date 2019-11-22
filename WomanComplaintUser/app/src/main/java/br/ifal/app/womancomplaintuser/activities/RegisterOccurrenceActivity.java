package br.ifal.app.womancomplaintuser.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import br.ifal.app.womancomplaintuser.R;
import br.ifal.app.womancomplaintuser.beans.Addresses;
import br.ifal.app.womancomplaintuser.beans.Womans;
import br.ifal.app.womancomplaintuser.daos.AddressesDAO;
import br.ifal.app.womancomplaintuser.daos.WomansDAO;
import br.ifal.app.womancomplaintuser.services.QueryTask;

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

                Womans womans = new Womans(name, email);
                Addresses addresses = new Addresses(neighborhood, street, number, zipCode, city);

                WomansDAO.listWomans.add(womans);
                AddressesDAO.listAddresses.add(addresses);

                System.out.println(womans + "\n" + addresses);

                Intent intent = new Intent(RegisterOccurrenceActivity.this, StoreOccurrenceActivity.class);
                startActivity(intent);
            }
        });
    }

}
