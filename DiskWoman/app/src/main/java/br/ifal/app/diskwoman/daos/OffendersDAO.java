package br.ifal.app.diskwoman.daos;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import br.ifal.app.diskwoman.beans.Offenders;
import br.ifal.app.diskwoman.beans.Sexes;

public class OffendersDAO {

    private ConnectionFactory connection;
    private String TABLE = "tb_offenders";

    public OffendersDAO(Context context) {
        connection = new ConnectionFactory(context);
    }

    public void save(Offenders offender) {
        SQLiteDatabase db = connection.getWritableDatabase();
        ContentValues data = getData(offender);

        db.insert(TABLE, null, data);
        db.close();
    }

    private ContentValues getData(Offenders offender) {
        ContentValues data = new ContentValues();
        data.put("offe_name", offender.getName());
        data.put("offe_age", offender.getAge());
        data.put("offe_apperance", offender.getAppearence());

        if (offender.getSex().equals("Feminino")) {
            data.put("offe_sex", true);
        } else {
            data.put("offe_sex", false);
        }

        return data;
    }

    public List<Offenders> listOffenders() {
        List<Offenders> list = new ArrayList<>();
        String sql = "SELECT * FROM tb_offenders";
        SQLiteDatabase db = connection.getWritableDatabase();

        Cursor cursor = db.rawQuery(sql, null);

        while (cursor.moveToNext()) {
            int id = cursor.getInt(cursor.getColumnIndex("offe_id"));
            String name = cursor.getString(cursor.getColumnIndex("offe_name"));
            String age = cursor.getString(cursor.getColumnIndex("offe_age"));
            String appearence = cursor.getString(cursor.getColumnIndex("offe_appearence"));
            int index = cursor.getInt(cursor.getColumnIndex("offe_sex"));

            String str = cursor.getString(index);
            boolean sex = Boolean.parseBoolean(str);

            if (sex == true) {
                Sexes fem = Sexes.FEMALE;
                list.add(new Offenders(
                        id, name, appearence, age, fem
                ));
            } else {
                Sexes male = Sexes.MALE;
                list.add(new Offenders(
                        id, name, appearence, age, male
                ));
            }
        }

        cursor.close();
        db.close();

        return list;
    }

    public void delete(Offenders offender) {
        SQLiteDatabase db = connection.getWritableDatabase();
        String [] parameters = { String.valueOf(offender.getId()) };

        db.delete(TABLE, "offe_id = ?", parameters);
        db.close();
    }

    public void update(Offenders offender) {
        SQLiteDatabase db = connection.getWritableDatabase();
        ContentValues data = getData(offender);
        String [] parameters = { String.valueOf(offender.getId()) };

        db.update(TABLE, data, "offe_id = ?", parameters);
        db.close();
    }

}
