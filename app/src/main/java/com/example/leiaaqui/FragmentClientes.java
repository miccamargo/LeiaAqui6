package com.example.leiaaqui;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;


public class FragmentClientes extends Fragment implements AdapterView.OnItemSelectedListener {

    Cursor cursor;
    String codigo;
    BancoController crud;
    EditText nome;
    EditText CPF;
    EditText Email;
    EditText Endereco;
    EditText DataNasc;
    EditText Celular;
    Spinner CatCliente;
    Button btnCadastrar;
    String NOME_CLIENTE;
    String ENDERECO_CLIENTE;
    String CELULAR_CLIENTE;
    String EMAIL_CLIENTE;
    String CPF_CLIENTE;
    String DATANASC_CLIENTE;
    String IDCATEGORIALEITOR_FK;

    public FragmentClientes() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_clientes, container, false);

        codigo = this.getActivity().getIntent().getStringExtra("codigo");
        cursor = crud.carregaDadosClienteporID(Integer.parseInt(codigo));

        crud = new BancoController(getActivity().getBaseContext());

        Spinner spinner = v.findViewById(R.id.txtCategoriaCliente);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getActivity().getBaseContext(), R.array.catLeitores, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        nome = (EditText) v.findViewById(R.id.txtNomeCliente);
        Email = (EditText) v.findViewById((R.id.txtEmailCliente));
        CPF = (EditText) v.findViewById(R.id.txtCPFCliente);
        Endereco = (EditText) v.findViewById(R.id.txtEnderecoCliente);
        Celular = (EditText) v.findViewById(R.id.txtCelularCliente);
        DataNasc = (EditText) v.findViewById(R.id.txtDataNascCliente);
        CatCliente = (Spinner) v.findViewById(R.id.txtCategoriaCliente);
        btnCadastrar = (Button) v.findViewById(R.id.btnCadCliente);
        btnCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cadClientes(v);
            }
        });

        return v;
    }

    public void cadClientes(View v) {
        NOME_CLIENTE = nome.getText().toString();
        ENDERECO_CLIENTE = Endereco.getText().toString();
        CELULAR_CLIENTE = Celular.getText().toString();
        EMAIL_CLIENTE = Email.getText().toString();
        CPF_CLIENTE = CPF.getText().toString();
        DATANASC_CLIENTE = DataNasc.getText().toString();
        IDCATEGORIALEITOR_FK = CatCliente.getSelectedItem().toString();

        crud.insereDadosCliente(NOME_CLIENTE, ENDERECO_CLIENTE, CELULAR_CLIENTE,
                EMAIL_CLIENTE, CPF_CLIENTE, DATANASC_CLIENTE,
                IDCATEGORIALEITOR_FK);

        Intent intent = new Intent(getActivity(), MenuClientes.class);
        startActivity(intent);
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
