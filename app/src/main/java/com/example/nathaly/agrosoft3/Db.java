package com.example.nathaly.agrosoft3;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Herald Flores on 10/11/2017.
 */

public class Db extends SQLiteOpenHelper {
    public Db(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context,"BDCultivos", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    //metodo que valida si el usuario existe
    public Cursor consultarusuPas(String txtusu, String txtpas) throws SQLException {

        Cursor mcursor = this.getReadableDatabase().query("users", new String[]{"id", "nombre", "password"}
                , "nombre like'" + txtusu + "' and contrasenia like '" + txtpas + "'", null, null, null, null);
        return mcursor;

    }
}
