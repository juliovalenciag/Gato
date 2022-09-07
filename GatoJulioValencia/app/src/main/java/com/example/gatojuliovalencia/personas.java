package com.example.gatojuliovalencia;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class personas extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personas);

        final EditText jugador1 = findViewById(R.id.jugador1nom);
        final EditText jugador2 = findViewById(R.id.jugador2nom);
        final Button btnempezar = findViewById(R.id.btnempezar);


        btnempezar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final String nombrejugador1 = jugador1.getText().toString();
                final String nombrejugador2 = jugador2.getText().toString();

                if(nombrejugador1.isEmpty() || nombrejugador2.isEmpty()){
                    Toast.makeText(personas.this,"Introduce los nombres", Toast.LENGTH_SHORT).show();
                }
                else{
                    Intent intent = new Intent(personas.this, MainActivity.class);
                    intent.putExtra("jugador1", nombrejugador1);
                    intent.putExtra("jugador2", nombrejugador2);
                    startActivity(intent);
                }
            }
        });
    }
}