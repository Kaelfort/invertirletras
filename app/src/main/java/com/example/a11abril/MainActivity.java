package com.example.a11abril;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    //atributos-variables
    private TextView txtResultado;
    private TextView txtAviso;
    private EditText etPalabra;
    private Button btnProcesar;

    private String palabra;

    //metodos - funciones

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inicializarVistas();
        /*
        al configurar un boton para decirle que este pendiente al evento clicj de ese boton en pantalla
        con el uso del metodo .setOnClickListener()
        Lo que ese mètodo esta esperando como parametro o argunmento es una funcion que serà
        la funciòn click que activara las funciones a realizar cuando se presione el boton.
        CuANDO SE PASA UNA FUNCION COMO PARAMENTRO ESTAS GENERALMENTE SON CONOCIDAD COMO FUNCINES ANONIMAS
        la idea es que esa funcion ejecute su proceimiento a partir del metodo que la recibe como parametro.
         */

        //this: ambito o contexto de la misma clase.  busca la respuesta en la clase

        btnProcesar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Este metodo onclick solo existe en el ambito del boton btnProcesar, lo que se haga a ca solo sirve para ese boton
                recibirInformacion();
                invertirPalabra();
            }
        });
    }

    private void invertirPalabra() {
        //Una anera directa de inveritr una cadena
        //Netamente codigo java
        //palabra = new StringBuilder(palabra).reverse().toString();
        String invertido="";

        String verific=this.palabra;
        //la cadena sra una array, donde la cadena de cada letra estara en un array
        //los strings tinene un metodo que les permite devolver una letra como si fuera la posiscion de un array
        for (int i = this.palabra.length()-1; i >=0 ; i--) {
            invertido += this.palabra.charAt(i);
            
        }
        txtAviso.setText(verific);
        if(this.palabra.equals(invertido))
        {
            txtAviso.setText("la palabra es palindroma");
        }else{
            txtAviso.setText("la palabra no es palindroma");
        }

        txtResultado.setText(invertido);

    }

    private void recibirInformacion() {

        palabra = etPalabra.getText().toString();
    }

    private void inicializarVistas() {
        txtResultado = findViewById(R.id.txtResultado);
        txtAviso = findViewById(R.id.txtaviso);
        etPalabra = findViewById(R.id.etPalabra);
        etPalabra = findViewById(R.id.etPalabra);
        btnProcesar = findViewById(R.id.btnProcesar);
    }


}