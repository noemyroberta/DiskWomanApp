package br.ifal.app.diskwoman.daos;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import br.ifal.app.diskwoman.beans.Women;

public class WomenDAO {

    private ConnectionFactory connection;
    private String TABLE = "tb_women";

    public WomenDAO(Context context) {
        connection = new ConnectionFactory(context);
    }

    public void save(Women women) {
        SQLiteDatabase db = connection.getWritableDatabase();
        ContentValues data = getData(women);

        db.insert(TABLE, null, data);
        db.close();
    }

    private ContentValues getData(Women women) {
        ContentValues data = new ContentValues();

        data.put("woma_name", women.getName());
        data.put("woma_email", women.getEmail());

        return data;
    }

    public List<Women> listWomen() {
        List<Women> list = new ArrayList<>();
        String sql = "SELECT * FROM tb_women";
        SQLiteDatabase db = connection.getWritableDatabase();

        Cursor cursor = db.rawQuery(sql, null);

        while (cursor.moveToNext()) {
            int id = cursor.getInt(cursor.getColumnIndex("women_id"));
            String name = cursor.getString(cursor.getColumnIndex("women_name"));
            String email = cursor.getString(cursor.getColumnIndex("women_email"));

            list.add(new Women(
                    id, name, email
            ));
        }
        cursor.close();
        db.close();

        return list;

    }

    public void delete(Women woman) {
        SQLiteDatabase db = connection.getWritableDatabase();
        String[] parameters = {String.valueOf(woman.getId())};

        db.delete(TABLE, "woma_id = ?", parameters);
        db.close();
    }

    public void update(Women women) {
        SQLiteDatabase db = connection.getWritableDatabase();
        ContentValues data = getData(women);
        String[] parameters = {String.valueOf(women.getId())};

        db.update(TABLE, data, "woma_id = ?", parameters);
        db.close();
    }
}
