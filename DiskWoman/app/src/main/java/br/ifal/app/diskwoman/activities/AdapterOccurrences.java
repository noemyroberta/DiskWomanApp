package br.ifal.app.diskwoman.activities;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

import br.ifal.app.diskwoman.R;
import br.ifal.app.diskwoman.beans.Occurrences;

public class AdapterOccurrences extends BaseAdapter {

    private List<Occurrences> listOccurrences;
    private Context context;

    public AdapterOccurrences(List<Occurrences> listOccurrences, Context context) {
        this.listOccurrences = listOccurrences;
        this.context = context;
    }

    @Override
    public int getCount() {
        return listOccurrences.size();
    }

    @Override
    public Occurrences getItem(int position) {
        return listOccurrences.get(position);
    }

    @Override
    public long getItemId(int position) {
        return listOccurrences.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View view = LayoutInflater.from(context).inflate(R.layout.activity_item_occurrences,
                parent, false);

        Occurrences occu = listOccurrences.get(position);

        TextView textViewTitle = view.findViewById(R.id.title_of_occurrence);
        TextView textViewDate= view.findViewById(R.id.date_of_occurrence);

        textViewTitle.setText(occu.getTitle());
        textViewDate.setText(occu.getDate());

        return view;
    }

    public void update(List<Occurrences> occurrence) {
        listOccurrences.clear();
        listOccurrences.addAll(occurrence);
        notifyDataSetChanged();
    }

    public void delete(Occurrences occurrence) {
        listOccurrences.remove(occurrence);
    }

}