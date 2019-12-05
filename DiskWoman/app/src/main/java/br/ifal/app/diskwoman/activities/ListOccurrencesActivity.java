package br.ifal.app.diskwoman.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import androidx.fragment.app.Fragment;;
import br.ifal.app.diskwoman.R;
import br.ifal.app.diskwoman.beans.Occurrences;
import br.ifal.app.diskwoman.daos.OccurrencesDAO;

public class ListOccurrencesActivity extends Fragment {

    private Occurrences occurrences;
    private OccurrencesDAO occDAO;
    private  AdapterOccurrences adaptador;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_list_occurrences, null, false);
        occDAO = new OccurrencesDAO(getContext());

        adaptador = new AdapterOccurrences(occDAO.listOccurrences(), getContext());

        ListView listView = view.findViewById(R.id.listview_occurrences_id);
        listView.setAdapter(adaptador);

        registerForContextMenu(listView);

        return view;
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getActivity().getMenuInflater().inflate(R.menu.menu_item_list, menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {

        AdapterView.AdapterContextMenuInfo contextMenuInfo = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        occurrences = (Occurrences) adaptador.getItem(contextMenuInfo.position);

        if (item.getItemId() == R.id.menu_update) {
            Intent i = new Intent(getActivity(), RegisterOccurrenceActivity.class);
            i.putExtra("occurrences", occurrences);
            startActivity(i);
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

        List<Occurrences> list = new OccurrencesDAO(getContext()).listOccurrences();

        adaptador.update(list);
    }
}