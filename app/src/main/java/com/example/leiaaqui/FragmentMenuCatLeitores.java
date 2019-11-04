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

public class FragmentMenuCatLeitores extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_menu_cat_leitores, container, false);

        Button cadCatLeitor = (Button) v.findViewById(R.id.btnCadCatLeitor);
        cadCatLeitor.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent it = new Intent(getActivity(),CatLeitores.class);
                startActivity(it);
            }
        } );

        Button altCatLeitor = (Button) v.findViewById(R.id.btnAltCatLeitor);
        altCatLeitor.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent it = new Intent(getActivity(),AltCatLeitores.class);
                startActivity(it);
            }
        } );

        Button exCatLeitor = (Button) v.findViewById(R.id.btnExCatLeitor);
        exCatLeitor.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent it = new Intent(getActivity(),ExCatLeitores.class);
                startActivity(it);
            }
        } );
        return v;
    }


}
