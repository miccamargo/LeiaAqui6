package com.example.leiaaqui;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class FragmentConsultaEspecificas extends Fragment {

    Button botaoConsultaEspec;
    Button botaoConsultaLivEmp;
    EditText TituloAutorEditora;
    RadioButton ConsultaTitulo;
    RadioButton ConsultaAutor;
    RadioButton ConsultaEditora;
    String TituloAutorEditoraString;
    BancoController crud;
    String resultado;

    public FragmentConsultaEspecificas() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_consulta_especificas, container, false);


        TituloAutorEditora = (EditText) v.findViewById(R.id.txtTituloAutorEditora);
        ConsultaTitulo = (RadioButton) v.findViewById(R.id.rbTitulo);
        ConsultaAutor = (RadioButton) v.findViewById(R.id.rbAutor);
        ConsultaEditora = (RadioButton) v.findViewById(R.id.rbEditora);
        botaoConsultaEspec = (Button) v.findViewById(R.id.btnConsultaEspec);
        botaoConsultaEspec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buscaEspec(v);
            }
        });
        botaoConsultaLivEmp = (Button) v.findViewById(R.id.btnConsultLivEmp);
        botaoConsultaLivEmp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buscaLivEmp(v);
            }
        });

        return v;
    }

    public void buscaEspec(View v) {
        TituloAutorEditoraString = TituloAutorEditora.getText().toString();

        if (ConsultaTitulo.isChecked()) {
            resultado = String.valueOf(crud.buscaporTitulo(TituloAutorEditoraString));

            Intent intent = new Intent(getActivity(), ConsultaDadosEspecificos.class);
            startActivity(intent);

        } else if (ConsultaAutor.isChecked()) {
            resultado = String.valueOf(crud.buscaporAutor(TituloAutorEditoraString));

            Intent intent = new Intent(getActivity(), ConsultaDadosEspecificos.class);
            startActivity(intent);

        } else if (ConsultaEditora.isChecked()) {
            resultado = String.valueOf(crud.buscaporEditora(TituloAutorEditoraString));

            Intent intent = new Intent(getActivity(), ConsultaDadosEspecificos.class);
            startActivity(intent);

        } else {
            Toast.makeText(getActivity().getApplicationContext(), "Escolha uma opção!", Toast.LENGTH_LONG).show();
        }

    }

    public void buscaLivEmp(View v) {

        crud.buscaLivroEmprestado();

        Intent intent = new Intent(getActivity(), ConsultaLivrosEspecs.class);
        startActivity(intent);

    }
}
