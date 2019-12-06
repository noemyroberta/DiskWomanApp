package br.ifal.app.diskwoman.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import br.ifal.app.diskwoman.R;
import br.ifal.app.diskwoman.beans.Occurrences;
import br.ifal.app.diskwoman.daos.OccurrencesDAO;

public class ListOccurrencesActivity extends AppCompatActivity {

    private Occurrences occurrences;
    private OccurrencesDAO occDAO = new OccurrencesDAO(this);
    private AdapterOccurrences adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_occurrences);

        adapter = new AdapterOccurrences(occDAO.listOccurrences(), this);

        ListView listView = findViewById(R.id.listview_occurrences_id);
        listView.setAdapter(adapter);

        registerForContextMenu(listView);

        FloatingActionButton fabBack = findViewById(R.id.fab_back_id);
        fabBack.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent i = new Intent(ListOccurrencesActivity.this, MainActivity.class);
                startActivity(i);
            }
        });
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        getMenuInflater().inflate(R.menu.menu_item_list, menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {

        AdapterView.AdapterContextMenuInfo contextMenuInfo = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        occurrences = (Occurrences) adapter.getItem(contextMenuInfo.position);

        if (item.getItemId() == R.id.menu_update) {
            Intent intent = new Intent(ListOccurrencesActivity.this, RegisterOccurrenceActivity.class);
            intent.putExtra("occurrences", occurrences);
            startActivity(intent);
        }

        if (item.getItemId() == R.id.menu_delete) {
            occDAO.delete(occurrences);
            onResume();
        }
        return super.onContextItemSelected(item);
    }

    @Override
    public void onResume() {
        super.onResume();

        List<Occurrences> list = new OccurrencesDAO(this).listOccurrences();

        adapter.update(list);
    }
}