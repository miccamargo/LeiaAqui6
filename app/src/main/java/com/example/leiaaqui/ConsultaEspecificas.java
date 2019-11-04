package com.example.leiaaqui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class ConsultaEspecificas extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consulta_especificas);

        Button botaoConsultaEspec = (Button)findViewById(R.id.btnConsultaEspec);
        Button botaoConsultaLivEmp = (Button)findViewById(R.id.btnConsultLivEmp);

        botaoConsultaEspec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BancoController crud = new BancoController(getBaseContext());
               
                EditText TituloAutorEditora = (EditText) findViewById(R.id.txtTituloAutorEditora);
                RadioButton ConsultaTitulo = (RadioButton) findViewById(R.id.rbTitulo);
                RadioButton ConsultaAutor = (RadioButton) findViewById(R.id.rbAutor);
                RadioButton ConsultaEditora = (RadioButton) findViewById(R.id.rbEditora);
                String TituloAutorEditoraString = TituloAutorEditora.getText().toString();
                String resultado;

                if (ConsultaTitulo.isChecked()) {
                    resultado = String.valueOf(crud.buscaporTitulo(TituloAutorEditoraString));

                    Intent intent = new Intent(ConsultaEspecificas.this, ConsultaDadosEspecificos.class);
                    startActivity(intent);

                } else if (ConsultaAutor.isChecked()) {
                    resultado = String.valueOf(crud.buscaporAutor(TituloAutorEditoraString));

                    Intent intent = new Intent(ConsultaEspecificas.this, ConsultaDadosEspecificos.class);
                    startActivity(intent);

                } else if (ConsultaEditora.isChecked()) {
                    resultado = String.valueOf(crud.buscaporEditora(TituloAutorEditoraString));

                    Intent intent = new Intent(ConsultaEspecificas.this, ConsultaDadosEspecificos.class);
                    startActivity(intent);

                } else {
                    Toast.makeText(getApplicationContext(), "Escolha uma opção!", Toast.LENGTH_LONG).show();
                }
            }
        });

        botaoConsultaLivEmp.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                BancoController crud = new BancoController(getBaseContext());

                crud.buscaLivroEmprestado();

                Intent intent = new Intent(ConsultaEspecificas.this, ConsultaLivrosEspecs.class);
                startActivity(intent);
            }
        });
    }
}
