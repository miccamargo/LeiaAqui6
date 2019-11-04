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


public class FragmentCatLeitores extends Fragment {

    BancoController crud;
    Button btnCadastrar;
    EditText codCategoria;
    RadioButton Estudante;
    RadioButton Professor;
    RadioButton Comum;
    RadioGroup rbTipoLeitor;
    EditText DiaEmprestimo;
    String DIAS_LEITORES;
    String DESCRICAO_LEITORES;
    String codigo;
    Cursor cursor;

    public FragmentCatLeitores() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_cat_leitores, container, false);

        codigo = this.getActivity().getIntent().getStringExtra("codigo");
        cursor = crud.carregaDadosCatLeitoresPorID(Integer.parseInt(codigo));

        crud = new BancoController(getActivity().getBaseContext());

        codCategoria = (EditText) v.findViewById(R.id.txtIDCatLeitor);
        Estudante = (RadioButton) v.findViewById((R.id.radioEstudante));
        Professor = (RadioButton) v.findViewById((R.id.radioProfessor));
        Comum = (RadioButton) v.findViewById((R.id.radioComum));
        rbTipoLeitor = (RadioGroup) v.findViewById(R.id.radioGroup);
        DiaEmprestimo = (EditText) v.findViewById(R.id.txtDiasEmprestimoLeitor);
        btnCadastrar = (Button) v.findViewById(R.id.btnCadastrarCatLeitores);
        btnCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cadastrarCatLeitor(v);
            }
        });

        return v;
    }

    public void cadastrarCatLeitor(View v) {
        DIAS_LEITORES = DiaEmprestimo.getText().toString();

        int selectedID = rbTipoLeitor.getCheckedRadioButtonId();
        rbTipoLeitor = (RadioGroup) v.findViewById(selectedID);
        Toast.makeText(getActivity(), "Escolhido!", Toast.LENGTH_SHORT).show();
        DESCRICAO_LEITORES = rbTipoLeitor.toString();

        crud.insereDadosCatLeitores(DIAS_LEITORES, DESCRICAO_LEITORES);

        Intent intent = new Intent(getActivity(), MenuCatLeitores.class);
        startActivity(intent);

    }

}
