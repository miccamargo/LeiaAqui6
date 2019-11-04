package com.example.leiaaqui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.Button;
import android.widget.EditText;
import android.content.Intent;

public class Clientes extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long l) {
        String text = parent.getItemAtPosition(position).toString();
        Toast.makeText(parent.getContext(), text, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clientes);
/*

        cadCliente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                resultado = crud.insereDadosCliente(NOME_CLIENTE, ENDERECO_CLIENTE, CELULAR_CLIENTE,
                        EMAIL_CLIENTE, CPF_CLIENTE, DATANASC_CLIENTE,
                        Integer.parseInt(IDCATEGORIALEITOR_FK);
                Toast.makeText(getApplicationContext(), resultado, Toast.LENGTH_LONG).show();
            }
        });
        cadCliente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Clientes.this, MenuClientes.class);
                startActivity(intent);
            }
        });
    }*/
}}


