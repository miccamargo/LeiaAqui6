package com.example.leiaaqui;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class FragmentMenuCatLivros extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_menu_cat_livros, container, false);

        Button cadCatLivro = (Button) v.findViewById(R.id.btnCadCatLivro);
        cadCatLivro.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent it = new Intent(getActivity(), CatLivros.class);
                startActivity(it);
            }
        });

        Button altCatLivro = (Button) v.findViewById(R.id.btnAltCatLivro);
        altCatLivro.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent it = new Intent(getActivity(), AltCatLivros.class);
                startActivity(it);
            }
        });

        Button exCatLivro = (Button) v.findViewById(R.id.btnExCatLivro);
        exCatLivro.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent it = new Intent(getActivity(), ExCatLivros.class);
                startActivity(it);
            }
        });

        return v;
    }
}
