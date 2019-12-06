package br.ifal.app.diskwoman.daos;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import br.ifal.app.diskwoman.beans.Involved;
import br.ifal.app.diskwoman.beans.Sexes;

public class InvolvedDAO {

    private ConnectionFactory connection;
    private String TABLE = "tb_involved";

    public InvolvedDAO(Context context) {
        connection = new ConnectionFactory(context);
    }

    public void save(Involved involved) {
        SQLiteDatabase db = connection.getWritableDatabase();
        ContentValues data = getData(involved);

        db.insert(TABLE, null, data);
        db.close();
    }

    private ContentValues getData(Involved involved) {
        ContentValues data = new ContentValues();

        data.put("invo_name", involved.getName());
        data.put("invo_age", involved.getAge());

        if (involved.getSex().equals("Feminino")) {
            data.put("invo_sex", true);
        } else {
            data.put("invo_sex", false);
        }

        return data;
    }

    public List<Involved> listInvolved() {
        List<Involved> list = new ArrayList<>();
        String sql = "SELECT * FROM tb_involved";
        SQLiteDatabase db = connection.getWritableDatabase();

        Cursor cursor = db.rawQuery(sql, null);

        while (cursor.moveToNext()) {
            int id = cursor.getInt(cursor.getColumnIndex("invo_id"));
            String name = cursor.getString(cursor.getColumnIndex("invo_name"));
            String age = cursor.getString(cursor.getColumnIndex("invo_age"));
            int index = cursor.getInt(cursor.getColumnIndex("invo_sex"));

            String str = cursor.getString(index);
            boolean sex = Boolean.parseBoolean(str);

            if (sex == true) {
                Sexes fem = Sexes.FEMALE;
                list.add(new Involved(
                    id, name, age, fem
                ));
            } else {
                Sexes male = Sexes.MALE;
                list.add(new Involved(
                    id, name, age, male
                ));
            }

        }

        cursor.close();
        db.close();

        return list;
    }

    public void delete(Involved involved) {
        SQLiteDatabase db = connection.getWritableDatabase();
        String [] parameters = { String.valueOf(involved.getId()) };

        db.delete(TABLE, "invo_id = ?", parameters);
        db.close();
    }

    public void update(Involved involved) {
        SQLiteDatabase db = connection.getWritableDatabase();
        ContentValues data = getData(involved);
        String [] parameters = { String.valueOf(involved.getId()) };

        db.update(TABLE, data, "invo_id = ?", parameters);
        db.close();
    }

}
