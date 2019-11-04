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


public class FragmentMenuClientes extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_menu_clientes, container, false);

        Button cadCliente = (Button) v.findViewById(R.id.btnCadCliente);
        cadCliente.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent it = new Intent(getActivity(), Clientes.class);
                startActivity(it);
            }
        });

        Button altCliente = (Button) v.findViewById(R.id.btnAltCliente);
        altCliente.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent it = new Intent(getActivity(), AltClientes.class);
                startActivity(it);
            }
        });

        Button exCliente = (Button) v.findViewById(R.id.btnExCliente);
        exCliente.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent it = new Intent(getActivity(), ExClientes.class);
                startActivity(it);
            }
        });

        return v;
    }
}
