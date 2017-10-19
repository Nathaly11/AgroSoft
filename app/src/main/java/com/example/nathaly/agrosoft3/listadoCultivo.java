package com.example.nathaly.agrosoft3;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class listadoCultivo extends AppCompatActivity {
    ListView listcultivos;
    ArrayList<String> listado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listado_cultivo);
        listcultivos = (ListView) findViewById(R.id.listcultivos);

       CargarListado();

        Toast.makeText(this,"nathally chupa pene", Toast.LENGTH_SHORT).show();



    }

    private void CargarListado() {
        listado = ListarCultivos();
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, listado);
        listcultivos.setAdapter(adapter);

       /* Toast.makeText(this,"nathally chupa pene", Toast.LENGTH_SHORT).show();*/


    }

    private ArrayList<String> ListarCultivos(){
        ArrayList<String> datos = new ArrayList<String>();
        BaseHelper helper = new BaseHelper(this);
        SQLiteDatabase db = helper.getReadableDatabase();
        String sql = "select * from cultivos";
        Cursor c = db.rawQuery(sql,null);
        if (c.moveToFirst()){
            do {
                String linea = c.getInt(0)+ " "+c.getString(1);
                datos.add(linea);
            }while (c.moveToNext());
        }
        db.close();
        return datos;
    }
}


