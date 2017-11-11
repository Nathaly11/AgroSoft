package com.example.nathaly.agrosoft3;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Nathaly on 18/10/2017.
 */

public class BaseHelper extends SQLiteOpenHelper  {

    String tabla;
    public BaseHelper(Context context, String tab) {
        super(context, "BDCultivos",null,1 );
        tabla=tab;
    }

    public BaseHelper(Context context) {
        super(context, "BDCultivos",null,1 );
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(tabla);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("drop table cultivos");
        db.execSQL(tabla);
    }


    public Cursor consulta(String user, String pass) throws  SQLException {



        Cursor curs = this.getReadableDatabase().query("users", new String[]{"_ID","nombre","password"}
                , "nombre like'" + user + "' and contrasenia like '" + pass + "'", null, null, null, null);

        return curs;


    }
}


