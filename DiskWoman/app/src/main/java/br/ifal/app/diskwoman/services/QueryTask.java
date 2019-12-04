package br.ifal.app.diskwoman.services;


import android.content.Context;
import android.os.AsyncTask;
import android.widget.EditText;

import org.json.JSONException;
import org.json.JSONObject;

import java.lang.ref.WeakReference;

import br.ifal.app.diskwoman.R;
import br.ifal.app.diskwoman.activities.RegisterOccurrenceActivity;

public class QueryTask extends AsyncTask<String, Object, String> {

    private WeakReference<RegisterOccurrenceActivity> reference;

    public QueryTask(Context context) {
        this.reference = new WeakReference<>((RegisterOccurrenceActivity) context);
    }

    protected String doInBackground(String... zipCodeList) {
        String zipCode = zipCodeList[0];

        WebUser user = new WebUser();
        String response = user.getZipCode(zipCode);

        return response;
    }

    protected void onPostExecute(String string) {
        super.onPostExecute(string);

        try {
            JSONObject jSon = new JSONObject(string);

            String street = jSon.getString("logradouro");
            String city = jSon.getString("localidade");
            String neighborhood = jSon.getString("bairro");

            EditText editTextStreet = reference.get().findViewById(R.id.edittext_street_id);
            EditText editTextCity = reference.get().findViewById(R.id.edittext_city_id);
            EditText editTextNeighborhood = reference.get().findViewById(R.id.edittext_neighborhood_id);

            editTextCity.setText(city);
            editTextStreet.setText(street);
            editTextNeighborhood.setText(neighborhood);
        } catch (JSONException exception) {
            exception.printStackTrace();
        }
    }

}
