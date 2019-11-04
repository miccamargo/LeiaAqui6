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


public class FragmentExCatLeitores extends Fragment {
    BancoController crud;
    EditText codCategoria;
    RadioButton Estudante;
    RadioButton Professor;
    RadioButton Comum;
    RadioGroup rbTipoLeitor;
    EditText DiaEmprestimo;
    Button btnExcluir;
    Cursor cursor;
    String codigo;
    String id;
    String diasleitores;
    String descricao;

    public FragmentExCatLeitores() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_ex_cat_leitores, container, false);

        codigo = this.getActivity().getIntent().getStringExtra("codigo");
        cursor = crud.carregaDadosCatLeitoresPorID(Integer.parseInt(codigo));

        crud = new BancoController(getActivity().getBaseContext());

        codCategoria = (EditText) v.findViewById(R.id.txtIDCatLeitor);
        Estudante = (RadioButton) v.findViewById((R.id.radioEstudante));
        Professor = (RadioButton) v.findViewById((R.id.radioProfessor));
        Comum = (RadioButton) v.findViewById((R.id.radioComum));
        rbTipoLeitor = (RadioGroup) v.findViewById(R.id.radioGroup);
        DiaEmprestimo = (EditText) v.findViewById(R.id.txtDiasEmprestimoLeitor);
        btnExcluir = (Button) v.findViewById(R.id.btnExcluirCatLeitores);
        btnExcluir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                exCatLeitores(v);
            }
        });

        return v;
    }

    public void exCatLeitores(View v) {
        id = codCategoria.getText().toString();
        diasleitores = DiaEmprestimo.getText().toString();

        int selectedID = rbTipoLeitor.getCheckedRadioButtonId();
        rbTipoLeitor = (RadioGroup) v.findViewById(selectedID);
        Toast.makeText(getActivity(), "Escolhido!", Toast.LENGTH_SHORT).show();
        descricao = rbTipoLeitor.toString();

        crud.deletaCategoriaLeitores(Integer.parseInt(codigo));

        Intent intent = new Intent(getActivity(), MenuCatLeitores.class);
        startActivity(intent);
    }

}
