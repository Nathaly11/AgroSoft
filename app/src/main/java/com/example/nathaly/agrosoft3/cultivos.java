package com.example.nathaly.agrosoft3;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class cultivos extends AppCompatActivity {
    EditText txtcultivo;
    Button btnguardar, btnmostrar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cultivos);
        txtcultivo = (EditText) findViewById(R.id.txtcultivo);

        btnguardar = (Button) findViewById(R.id.btnguardar);
        btnmostrar = (Button) findViewById(R.id.btnmostrar);

        btnguardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                guardar(txtcultivo.getText().toString());
            }
        });

        btnmostrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(cultivos.this, listadoCultivo.class));
            }
        });
    }
    private void guardar(String Cultivo) {
        BaseHelper helper = new BaseHelper(this);
        SQLiteDatabase db = helper.getWritableDatabase();
        try{
            ContentValues c = new  ContentValues();
            c.put("cultivo", Cultivo);
            db.insert("cultivos",null,c);
            db.close();
            Toast.makeText(this,"Registro con éxito", Toast.LENGTH_SHORT).show();
        }
        catch (Exception e){
            Toast.makeText(this,"Error:"+ e.getMessage(),Toast.LENGTH_SHORT).show();
        }
    }
}

