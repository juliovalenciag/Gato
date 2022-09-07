package com.example.gatojuliovalencia;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;

public class victoria extends Dialog {

    private final String mensaje;
    private final MainActivity mainActivity;
    public victoria(@NonNull Context context, String mensaje, MainActivity mainActivity) {
        super(context);
        this.mensaje = mensaje;
        this.mainActivity = mainActivity;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.win);

        final TextView mensajeTxt = findViewById(R.id.mensajeTxt);
        final Button volverbtn = findViewById(R.id.volverbtn);

        mensajeTxt.setText(mensaje);

        volverbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                mainActivity.restartMatch();
                dismiss();
            }
        });
    }
}
