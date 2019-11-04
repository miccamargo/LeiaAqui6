package com.example.leiaaqui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CadastroFunc extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_func);

        Button btnCadastrar = (Button)findViewById(R.id.btnCadastrarFunc);

        btnCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BancoController crud = new BancoController(getBaseContext());
                EditText txtEmail = (EditText)findViewById(R.id.txtEmail);
                EditText txtMatricula = (EditText)findViewById(R.id.txtMatricula);
                EditText txtSenha = (EditText)findViewById(R.id.txtSenha);
                String EMAIL_FUNC = txtEmail.getText().toString();
                String MATRICULA_FUNC = txtMatricula.getText().toString();
                String SENHA_FUNC = txtSenha.getText().toString();

                String resultado;

                resultado = crud.CadastroFunc(EMAIL_FUNC,MATRICULA_FUNC, SENHA_FUNC);

                Toast.makeText(getApplicationContext(), resultado, Toast.LENGTH_LONG).show();
            }
        } );

        btnCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CadastroFunc.this, ConsultaEspecificas.class);
                startActivity(intent);
            }
        });
    }
}
