package br.ifal.app.diskwoman.daos;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import br.ifal.app.diskwoman.beans.Occurrences;

public class OccurrencesDAO {

    private ConnectionFactory connection;
    private String TABLE = "tb_occurrences";

    public OccurrencesDAO(Context context) {
        connection = new ConnectionFactory(context);
    }

    public void save(Occurrences occurrence) {
        SQLiteDatabase db = connection.getWritableDatabase();
        ContentValues data = getData(occurrence);

        db.insert(TABLE, null, data);
        db.close();
    }

    private ContentValues getData(Occurrences occurrence) {
        ContentValues data = new ContentValues();
        data.put("occu_title", occurrence.getTitle());
        data.put("occu_description", occurrence.getDescription());
        data.put("occu_image", occurrence.getImage());
        data.put("occu_date", occurrence.getDate());
        data.put("occu_address_cep", occurrence.getAddressCep());
        data.put("occu_address_number", occurrence.getAddressNumber());
        data.put("occu_address_complement", occurrence.getAddressComplement());

        return data;
    }

    public List<Occurrences> listOccurrences() {
        List<Occurrences> list = new ArrayList<>();
        String sql = "SELECT * FROM tb_occurrences";
        SQLiteDatabase db = connection.getWritableDatabase();

        Cursor cursor = db.rawQuery(sql, null);

        while (cursor.moveToNext()) {
            int id = cursor.getInt(cursor.getColumnIndex("occu_id"));
            String title = cursor.getString(cursor.getColumnIndex("occu_title"));
            String description = cursor.getString(cursor.getColumnIndex("occu_description"));
            String image = cursor.getString(cursor.getColumnIndex("occu_image"));
            String date = cursor.getString(cursor.getColumnIndex("occu_date"));
            String addressCep = cursor.getString(cursor.getColumnIndex("occu_address_cep"));
            String addressNumber = cursor.getString(cursor.getColumnIndex("occu_address_number"));
            String addressComplement = cursor.getString(cursor.getColumnIndex("occu_address_complement"));

            list.add(new Occurrences(
                    id, title, description, image, date, addressCep, addressNumber, addressComplement
            ));
        }

        cursor.close();
        db.close();

        return list;
    }

    public void delete(Occurrences occurrence) {
        SQLiteDatabase db = connection.getWritableDatabase();
        String [] parameters = { String.valueOf(occurrence.getId()) };

        db.delete(TABLE, "occu_id = ?", parameters);
        db.close();
    }

    public void update(Occurrences occurrence) {
        SQLiteDatabase db = connection.getWritableDatabase();
        ContentValues data = getData(occurrence);
        String [] parameters = { String.valueOf(occurrence.getId()) };

        db.update(TABLE, data, "occu_id = ?", parameters);
        db.close();
    }

}
