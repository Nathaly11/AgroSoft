package com.example.nathaly.agrosoft3;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class Inicio extends AppCompatActivity {
    Button btncultivos, btncomunidad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);

        btncultivos = (Button) findViewById(R.id.btncultivo);

        btncultivos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Inicio.this, cultivos.class));
            }
        });

        btncomunidad = (Button) findViewById(R.id.btncomunidad);

        btncomunidad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Inicio.this, Asociados.class));
            }
        });
    }
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.commonmenus,menu);

        return super.onCreateOptionsMenu(menu);
    }

    public boolean onCreateOptionsItemSelected(MenuItem item){
        int id= item.getItemId();
        if (id == R.id.cultinav) {
            startActivity(new Intent(this, cultivos.class));
            // lo ideal aquí sería hacer un intent para abrir una nueva clase como lo siguiente
        }

        return super.onOptionsItemSelected(item);
    }

}
