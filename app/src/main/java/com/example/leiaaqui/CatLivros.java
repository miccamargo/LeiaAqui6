package com.example.leiaaqui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class CatLivros extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cat_livros);
        //Button cadCatLivros = (Button) findViewById(R.id.btnCadastrarCatLivros);
        /*
        cadCatLivros.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //String resultado = crud.insereDadosCatLivros(DIAS_LIVROS, DESCRICAO_LIVROS, TAXA_LIVROS);
                //Toast.makeText(getApplicationContext(), resultado, Toast.LENGTH_LONG).show();
            }
        });
        cadCatLivros.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CatLivros.this, MenuCatLivros.class);
                startActivity(intent);
            }
        });
    } */

}}
