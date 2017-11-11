package com.example.nathaly.agrosoft3;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Registro extends AppCompatActivity {
    EditText txtusuario, txtpassword;
    Button Guardar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        txtusuario= (EditText) findViewById(R.id.etnombre);
        txtpassword= (EditText) findViewById(R.id.etpass);
       /* usuario=(EditText) findViewById(R.id.nombre);
        password=(EditText) findViewById(R.id.password);*/

        Guardar=(Button) findViewById(R.id.btnregister);

        Guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Toast.makeText(this,"Registro con éxito", Toast.LENGTH_SHORT).show();

               guardar(txtusuario.getText().toString(), txtpassword.getText().toString());
            }
        });
       /* Guardar.setOnClickListener(View);*/

    }

    String tabla="CREATE TABLE users(id integer primary key autoincrement, nombre text not null, password text not null);";

    private void guardar(String Usuario, String pass) {
        BaseHelper helper = new BaseHelper(this,tabla);
        SQLiteDatabase db = helper.getWritableDatabase();
        try{
            ContentValues c = new ContentValues();
            c.put("nombre", Usuario);
            c.put("password", pass);
            db.insert("users",null,c);
            db.close();
            Toast.makeText(this,"Registro con éxito", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(Registro.this, Acceder.class));
        }
        catch (Exception e){
            Toast.makeText(this,"Error:"+ e.getMessage(),Toast.LENGTH_SHORT).show();
        }
    }

}
