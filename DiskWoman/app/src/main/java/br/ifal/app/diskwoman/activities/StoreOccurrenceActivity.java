package br.ifal.app.diskwoman.activities;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;

import br.ifal.app.womancomplaintuser.R;
import br.ifal.app.diskwoman.beans.Occurrences;

public class StoreOccurrenceActivity extends AppCompatActivity {

    private ArrayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_store);

        EditText editTextTitle = findViewById(R.id.edittext_title_id);
        EditText editTextDescription = findViewById(R.id.edittext_desc_id);
        EditText editTextDate = findViewById(R.id.edittext_date_id);

        Button btnImage = findViewById(R.id.btn_image_id);
        Button btnRegister = findViewById(R.id.btn_register_id);

        String title = editTextTitle.getText().toString();
        String description = editTextDescription.getText().toString();
        String date = editTextDate.getText().toString();

        Occurrences occurrences = new Occurrences(title, description, date, false);




    }
}
