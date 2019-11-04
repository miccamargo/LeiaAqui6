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
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;


public class FragmentCatLivros extends Fragment {

    BancoController crud;
    EditText codCategoria;
    CheckBox Livro;
    CheckBox Periodico;
    CheckBox Revista;
    CheckBox Jornal;
    CheckBox Didatica;
    CheckBox Relatorio;
    CheckBox Tese;
    CheckBox Mestrado;
    EditText DiaEmprestimo;
    EditText TaxaMulta;
    String codigo;
    Cursor cursor;
    Button btnCadastrar;
    String DIAS_LIVROS;
    String ID_LIVROS;
    String TAXA_LIVROS;
    String DESCRICAO_LIVROS;
    String s;

    public FragmentCatLivros() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_cat_livros, container, false);

        codigo = this.getActivity().getIntent().getStringExtra("codigo");
        cursor = crud.carregaDadosCatLivrosPorID(Integer.parseInt(codigo));

        crud = new BancoController(getActivity().getBaseContext());

        codCategoria = (EditText) v.findViewById(R.id.txtIDCatLivro);
        Livro = (CheckBox) v.findViewById((R.id.checkCatLivro));
        Periodico = (CheckBox) v.findViewById((R.id.checkCatPeriodico));
        Revista = (CheckBox) v.findViewById((R.id.checkCatRevista));
        Jornal = (CheckBox) v.findViewById((R.id.checkCatJornal));
        Didatica = (CheckBox) v.findViewById((R.id.checkCatDidatica));
        Relatorio = (CheckBox) v.findViewById((R.id.checkCatRelatorio));
        Tese = (CheckBox) v.findViewById((R.id.checkCatTese));
        Mestrado = (CheckBox) v.findViewById((R.id.checkCatMestrado));
        DiaEmprestimo = (EditText) v.findViewById(R.id.txtDiasEmprestimo);
        TaxaMulta = (EditText) v.findViewById(R.id.txtTaxaMulta);
        btnCadastrar = (Button) v.findViewById(R.id.btnCadCatLivro);
        btnCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cadastrarCatLivro(v);
            }
        });

        return v;
    }

    public void cadastrarCatLivro(View v) {
        DIAS_LIVROS = DiaEmprestimo.getText().toString();
        TAXA_LIVROS = TaxaMulta.getText().toString();

        s = "";
        if (Livro.isChecked()) {
            s += "\n Livro";
        }
        if (Periodico.isChecked()) {
            s += "\n Periódico";
        }
        if (Revista.isChecked()) {
            s += "\n Revista";
        }
        if (Jornal.isChecked()) {
            s += "\n Jornal";
        }
        if (Didatica.isChecked()) {
            s += "\n Nota Didática";
        }
        if (Relatorio.isChecked()) {
            s += "\n Relatório Técnico";
        }
        if (Tese.isChecked()) {
            s += "\n Tese de Doutorado";
        }
        if (Mestrado.isChecked()) {
            s += "\n Dissertação de Mestrado";
        }

        DESCRICAO_LIVROS = s.toString();

        crud.insereDadosCatLivros(DIAS_LIVROS, DESCRICAO_LIVROS, TAXA_LIVROS);

        Intent intent = new Intent(getActivity(), MenuCatLivros.class);
        startActivity(intent);         

    }
}
