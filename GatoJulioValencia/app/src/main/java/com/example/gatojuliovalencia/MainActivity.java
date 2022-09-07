package com.example.gatojuliovalencia;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private final List<int[]> combinationsList = new ArrayList<>();

    private int [] posiciones = {0,0,0,0,0,0,0,0,0};

    private int jugadorturno = 1;

    private int seleccion = 1;

    private LinearLayout jugador1layout, jugador2layout;
    private TextView jugador1nom, jugador2nom;
    private ImageView img1, img2, img3, img4, img5, img6, img7, img8, img9;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView jugador1nom = findViewById(R.id.jugador1nom);
        TextView jugador2nom = findViewById(R.id.jugador2nom);

        LinearLayout jugador1layout = findViewById(R.id.jugador1layout);
        LinearLayout jugador2layout = findViewById(R.id.jugador2layout);

        img1 = findViewById(R.id.img1);
        img2 = findViewById(R.id.img2);
        img3 = findViewById(R.id.img3);
        img4 = findViewById(R.id.img4);
        img5 = findViewById(R.id.img5);
        img6 = findViewById(R.id.img6);
        img7 = findViewById(R.id.img7);
        img8 = findViewById(R.id.img8);
        img9 = findViewById(R.id.img9);

        combinationsList.add(new int[]{0,1,2});
        combinationsList.add(new int[]{3,4,5});
        combinationsList.add(new int[]{6,7,8});
        combinationsList.add(new int[]{0,3,6});
        combinationsList.add(new int[]{1,4,7});
        combinationsList.add(new int[]{2,5,8});
        combinationsList.add(new int[]{2,4,6});
        combinationsList.add(new int[]{0,4,8});

        final String nombrejugador1 = getIntent().getStringExtra("jugador1");
        final String nombrejugador2 = getIntent().getStringExtra("jugador2");

        jugador1nom.setText(nombrejugador1);
        jugador2nom.setText(nombrejugador2);

        img1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (isBoxSelectable(0)){

                    performAction((ImageView)view,0);
                }
            }
        });

        img2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (isBoxSelectable(1)){

                    performAction((ImageView)view,1);
                }
            }
        });

        img3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (isBoxSelectable(2)){

                    performAction((ImageView)view,2);
                }
            }
        });

        img4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (isBoxSelectable(3)){

                    performAction((ImageView)view,3);
                }
            }
        });

        img5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (isBoxSelectable(4)){

                    performAction((ImageView)view,4);
                }
            }
        });

        img6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (isBoxSelectable(5)){

                    performAction((ImageView)view,5);
                }
            }
        });

        img7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (isBoxSelectable(6)){

                    performAction((ImageView)view,6);
                }
            }
        });

        img8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (isBoxSelectable(7)){

                    performAction((ImageView)view,7);
                }
            }
        });

        img9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (isBoxSelectable(8)){

                    performAction((ImageView)view,8);
                }
            }
        });
        }

        private void performAction(ImageView imageView, int selectedposicion){

            posiciones[selectedposicion] = jugadorturno;
            jugador1nom = findViewById(R.id.jugador1nom);
            jugador2nom = findViewById(R.id.jugador2nom);

            if (jugadorturno == 1){
                imageView.setImageResource(R.drawable.tache);

                if (checkPlayerWIN()){
                    victoria Victoria = new victoria(MainActivity.this, jugador1nom.getText().toString() + " ha ganado el juego", MainActivity.this);
                    Victoria.setCancelable(false);
                    Victoria.show();
                }
                else if(seleccion == 9){
                    victoria Victoria = new victoria(MainActivity.this, "Es un empate", MainActivity.this);
                    Victoria.setCancelable(false);
                    Victoria.show();
                }

                else{
                    cambiarturno(2);

                    seleccion++;
                }
            }
            else{

                imageView.setImageResource(R.drawable.circulo);

                if(checkPlayerWIN()){

                    victoria Victoria = new victoria(MainActivity.this, jugador2nom.getText().toString() + " ha ganado el juego", MainActivity.this);
                    Victoria.setCancelable(false);
                    Victoria.show();
                }

                else if(selectedposicion == 9){

                    victoria Victoria = new victoria(MainActivity.this, "Es un empate", MainActivity.this);
                    Victoria.setCancelable(false);
                    Victoria.show();

                }

                else{

                    cambiarturno(1);

                    seleccion++;
                }
            }
        }
        private void cambiarturno(int turnoactivo){

            jugadorturno = turnoactivo;
            jugador1layout = findViewById(R.id.jugador1layout);
            jugador2layout = findViewById(R.id.jugador2layout);

            if(jugadorturno == 1){
                jugador1layout.setBackground(getDrawable(R.drawable.fondotablero));
                jugador2layout.setBackground(getDrawable(R.drawable.iconosfondo));
            }
            else{
                jugador2layout.setBackground(getDrawable(R.drawable.fondotablero));
                jugador1layout.setBackground(getDrawable(R.drawable.iconosfondo));
            }
        }

        private boolean checkPlayerWIN(){
            boolean response = false;

            for (int i=0;i<combinationsList.size();i++){
                final int [] combinacion = combinationsList.get(i);

                if(posiciones[combinacion[0]] == jugadorturno && posiciones[combinacion[1]] == jugadorturno && posiciones[combinacion[2]] == jugadorturno){
                    response = true;
                }
            }
            return response;
        }
        private boolean isBoxSelectable(int posicion){

            boolean response = false;

            if (posiciones[posicion] == 0){
                response = true;
            }
            return response;
        }

        public void restartMatch(){
            posiciones = new int[]{0,0,0,0,0,0,0,0,0,};

            jugadorturno = 1;

            seleccion = 1;

            img1.setImageResource(R.drawable.transparenteimg);
            img2.setImageResource(R.drawable.transparenteimg);
            img3.setImageResource(R.drawable.transparenteimg);
            img4.setImageResource(R.drawable.transparenteimg);
            img5.setImageResource(R.drawable.transparenteimg);
            img6.setImageResource(R.drawable.transparenteimg);
            img7.setImageResource(R.drawable.transparenteimg);
            img8.setImageResource(R.drawable.transparenteimg);
            img9.setImageResource(R.drawable.transparenteimg);
        }
    }
