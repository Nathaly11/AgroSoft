package com.example.nathaly.agrosoft3;

import android.content.Intent;
import android.database.Cursor;
import android.database.SQLException;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import static com.example.nathaly.agrosoft3.R.id.btnacceder;

public class Acceder extends AppCompatActivity {
    Button btnregister, btnlogin, btnpru;
    EditText txtuser, txtpass;
    BaseHelper helper=new BaseHelper(this);

    Db h= new Db(this,"BDCultivos",null,1);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acceder);

        btnregister = (Button) findViewById(R.id.btnregistro);

        btnregister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Acceder.this, Registro.class));
            }
        });


        btnlogin=(Button) findViewById(R.id.button6);

        btnpru=(Button) findViewById(btnacceder);

        btnpru.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Acceder.this,Inicio.class));
                Toast.makeText(getApplicationContext(), "Bienvenido", Toast.LENGTH_LONG).show();
            }
        });

        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txtuser=(EditText) findViewById(R.id.usuario);
                txtpass=(EditText) findViewById(R.id.contrasenia);

                try{

                    Cursor cursor= h.consultarusuPas(txtuser.getText().toString(),txtpass.getText().toString());

                    if(cursor.getCount()>0){
                        startActivity(new Intent(Acceder.this, Inicio.class));
                    }else {
                        Toast.makeText(getApplicationContext(), "Usuario o contraseña incorrecto", Toast.LENGTH_LONG).show();
                    }
                    txtpass.setText("");
                    txtuser.setText("");
                }catch (SQLException e){
                    e.printStackTrace();
                }
            }
        });

    }
}
