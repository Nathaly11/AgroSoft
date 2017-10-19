package com.example.nathaly.agrosoft3;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Nathaly on 18/10/2017.
 */

public class BaseHelper extends SQLiteOpenHelper  {
    String tabla="CREATE TABLE cultivos(id integer primary key autoincrement, cultivo text not null);";

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

}

