package br.ifal.app.diskwoman.daos;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class ConnectionFactory extends SQLiteOpenHelper {

    public ConnectionFactory(Context context) {
        super(context, "db_diskwoman", null, 2);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {

        String sqlWoman = "" +
                "CREATE TABLE tb_womans (" +
                "   woma_id INTEGER PRIMARY KEY," +
                "   woma_name TEXT," +
                "   woma_email TEXT" +
                ");";


        String sqlInvolved = "" +
                "CREATE TABLE tb_involved (" +
                "   invo_id INTEGER PRIMARY KEY," +
                "   invo_name TEXT NOT NULL," +
                "   invo_age VARCHAR(3)," +
                "   invo_sex BOOLEAN" +
                ");";


        String sqlOffenders = "" +
                "CREATE TABLE tb_offenders (" +
                "   offe_id INTEGER PRIMARY KEY," +
                "   offe_name TEXT," +
                "   offe_appearence TEXT NOT NULL," +
                "   offe_age VARCHAR(3)"+
                ");";

        String sqlOccurrences = "" +
                "CREATE TABLE tb_occurrences (" +
                "   occu_id INTEGER PRIMARY KEY," +
                "   occu_title TEXT NOT NULL," +
                "   occu_description TEXT NOT NULL," +
                "   occu_image TEXT," +
                "   occu_invo_id INT(11)," +
                "   occu_offe_id INT(11)," +
                "   occu_woma_id INT(11)," +
                "   occu_date DATE NOT NULL," +
                "   occu_address_cep VARCHAR(20) NOT NULL," +
                "   occu_address_number VARCHAR(10) NOT NULL," +
                "   occu_address_complement TEXT NOT NULL," +
                "   FOREIGN KEY (occu_invo_id)" +
                "   REFERENCES tb_involved (invo_id)," +
                "   FOREIGN KEY (occu_offe_id)" +
                "   REFERENCES tb_offenders (offe_id)," +
                "   FOREIGN KEY (occu_woma_id)" +
                "   REFERENCES tb_womans (woma_id)" +
                ");";


        db.execSQL(sqlWoman);
        db.execSQL(sqlInvolved);
        db.execSQL(sqlOffenders);
        db.execSQL(sqlOccurrences);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String sql = "DROP TABLE IF EXISTS db_diskwoman";

        db.execSQL(sql);
        onCreate(db);
    }
}
