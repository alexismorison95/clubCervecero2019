package com.monayalexis.clubcervecero2.view.fragments;


import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.monayalexis.clubcervecero2.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class SearchFragment extends Fragment {

    androidx.appcompat.widget.Toolbar toolbar;


    public SearchFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_search, container, false);

        showToolbar("Buscar", view);

        return view;

    }


    @SuppressLint("RestrictedApi")
    public void showToolbar(String titulo, View view) {

        Toolbar toolbar = view.findViewById(R.id.toolbar);

        toolbar.setTitle(titulo);

        toolbar.setNavigationIcon(null);

    }


}
