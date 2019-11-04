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
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;


public class FragmentAltCatLeitores extends Fragment {
    BancoController crud;
    EditText codCategoria;
    RadioButton Estudante;
    RadioButton Professor;
    RadioButton Comum;
    RadioGroup rbTipoLeitor;
    EditText DiaEmprestimo;
    Button btnAlterar;
    Cursor cursor;
    String codigo;
    String id;
    String diasleitores;
    String descricao;


    public FragmentAltCatLeitores() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_alt_cat_leitores, container, false);
        codigo = this.getActivity().getIntent().getStringExtra("codigo");
        cursor = crud.carregaDadosCatLeitoresPorID(Integer.parseInt(codigo));

        crud = new BancoController(getActivity().getBaseContext());

        codCategoria = (EditText) v.findViewById(R.id.txtIDCatLeitor);
        Estudante = (RadioButton) v.findViewById((R.id.radioEstudante));
        Professor = (RadioButton) v.findViewById((R.id.radioProfessor));
        Comum = (RadioButton) v.findViewById((R.id.radioComum));
        rbTipoLeitor = (RadioGroup) v.findViewById(R.id.radioGroup);
        DiaEmprestimo = (EditText) v.findViewById(R.id.txtDiasEmprestimoLeitor);
        btnAlterar = (Button) v.findViewById(R.id.btnAlterarCatLeitores);
        btnAlterar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                altCatLeitores(v);
            }
        });

        return v;
    }

    public void altCatLeitores(View v) {
        id = codCategoria.getText().toString();
        diasleitores = DiaEmprestimo.getText().toString();

        int selectedID = rbTipoLeitor.getCheckedRadioButtonId();
        rbTipoLeitor = (RadioGroup) v.findViewById(selectedID);
        Toast.makeText(getActivity(), "Escolhido!", Toast.LENGTH_SHORT).show();
        descricao = rbTipoLeitor.toString();

        crud.alteraRegistroCatLeitores(Integer.parseInt(codigo), diasleitores, descricao);

        Intent intent = new Intent(getActivity(), MenuCatLeitores.class);
        startActivity(intent);
    }

}
