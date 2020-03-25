package com.monayalexis.clubcervecero2.view.fragments;


import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.monayalexis.clubcervecero2.R;
import com.monayalexis.clubcervecero2.adapter.PictureAdapterRecyclerView;
import com.monayalexis.clubcervecero2.model.Picture;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {

    androidx.appcompat.widget.Toolbar toolbar;

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_home, container, false);

        //toolbar = view.findViewById(R.id.toolbar);

        // mostrar toolbar con home
        //showToolbar("home", false, view);
        showToolbar("Inicio", view);

        RecyclerView picturesRecycler = view.findViewById(R.id.recyclerView);

        PictureAdapterRecyclerView pictureAdapterRecyclerView =
                new PictureAdapterRecyclerView(buildPictures(), R.layout.cardview_picture , getActivity());

        picturesRecycler.setAdapter(pictureAdapterRecyclerView);

        //pasar zona verde de contexto - linear layout manager
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(view.getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        picturesRecycler.setLayoutManager(linearLayoutManager);

        return view;

    }

    // metodo constructor de array pictures

    public ArrayList<Picture> buildPictures() {

        ArrayList<Picture> pictures = new ArrayList<>();

        pictures.add(new Picture("https://www.thebeertimes.com/wp-content/uploads/2018/06/Cerveza_artesanal.jpg",
                "7 Colinas Cervecería Artesanal", "Hace 4 minutos", "1 Me gusta", "Estrada 838",
                "03442 43-2811","Martes a Domingo de 19:30 a 2 Hs", "Child Friendly",
                false, -32.479900,-58.235322));

        pictures.add(new Picture("https://images.clarin.com/2019/01/15/actualmente-la-ciudad-cuenta-con___Lte01HS8K_1200x0__1.jpg",
                "Cerveza Artesanal Biguá", "Hace 1 hora", "10 Me gusta", "Juan Domingo Perón 34",
                "--","Lunes a Domingo de 19:30 a 00:30 Hs.", "LGBT Friendly",
                true, -32.485051, -58.231004));

        pictures.add(new Picture("https://www.cronista.com/__export/1536170691575/sites/diarioelcronista/img/2018/09/05/cerveza1.jpg_1866758231.jpg",
                "Drakkar cerveceria", "Hace 5 horas", "20 Me gusta", "Artusi 755",
                "03442 43-7805","Jueves a Domingo de 20:00 a 2 Hs", "Gay Friendly",
                true,-32.480557, -58.233931));

        pictures.add(new Picture("https://media.elpatagonico.com/adjuntos/193/imagenes/028/62'9/0028629938.jpg",
                "Cerveza Träctor", "Hace 5 horas", "10 Me gusta", "Artusi 998",
                "03442 15-53-9608", "Miercoles a Sabado de 20:00 a 3 Hs", "Pet Friendly",
                true,-32.481204, -58.237988));

        pictures.add(new Picture("https://images.clarin.com/2019/03/28/LqsIpI6FD_1256x620__1.jpg",
                "Cervecería Lagash", "Hace 6 horas", "30 Me gusta", "Calle Ruiz Moreno 657",
                "--","Martes a Domingo de 19:30 a 2 Hs","Gay Friendly",
                true,-32.477274, -58.248289));

        pictures.add(new Picture("https://images.clarin.com/2019/01/15/uH8yqnI9W_1256x620__1.jpg",
                "7 Colinas Cervecería Artesanal", "Hace 7 horas", "30 Me gusta", "Estrada 838",
                "03442 43-2811","Martes a Domingo de 19:30 a 2 Hs", "LGBT Friendly",
                true, -32.479900,-58.235322));

        pictures.add(new Picture("https://images.clarin.com/2019/01/15/entre-las-variedades-mas-buscadas___JBnsNc5S8_1200x0__1.jpg",
                "Cerveza Artesanal Biguá", "Hace 7 horas", "33 Me gusta", "Juan Domingo Perón 34",
                "--","Lunes a Domingo de 19:30 a 00:30 Hs.", "Pet Friendly",
                true, -32.485051, -58.231004));

        pictures.add(new Picture("https://www.cronista.com/export/sites/diarioelcronista/img/2018/08/03/cervezas_01_crop1533309198187.jpg_315635302.jpg",
                "Drakkar cerveceria", "Hace 8 horas", "35 Me gusta", "Artusi 755",
                "03442 43-7805","Jueves a Domingo de 20:00 a 2 Hs", "LGBT Friendly",
                false,-32.480557, -58.233931));

        pictures.add(new Picture("https://cdn.forbes.com.mx/2018/08/Cerveza-artesanal-640x360.jpg",
                "Cervecería Lagash", "Hace 8 horas", "50 Me gusta", "Calle Ruiz Moreno 657",
                "--","Martes a Domingo de 19:30 a 2 Hs","Gay Friendly",
                false,-32.477274, -58.248289));

        pictures.add(new Picture("https://ecocuyo.com/wp-content/uploads/2019/04/TAIPEI1-108-696x406.jpg",
                "Cerveza Träctor", "Hace 9 horas", "40 Me gusta", "Artusi 998",
                "03442 15-53-9608", "Miercoles a Sabado de 20:00 a 3 Hs", "LGBT Friendly",
                false,-32.481204, -58.237988));

        pictures.add(new Picture("https://static.wixstatic.com/media/b54170_cfd1966cf0ee42418f3a67a5337ed2f5~mv2.jpg/v1/fill/w_960,h_720,al_c,q_90/file.jpg",
                "7 Colinas Cervecería Artesanal", "Hace 15 horas", "50 Me gusta", "Estrada 838",
                "03442 43-2811","Martes a Domingo de 19:30 a 2 Hs", "Gay Friendly",
                false, -32.479900,-58.235322));

        return  pictures;
    }


    @SuppressLint("RestrictedApi")
    public void showToolbar(String titulo, View view) {

        Toolbar toolbar = view.findViewById(R.id.toolbar);

        toolbar.setTitle(titulo);

        toolbar.setNavigationIcon(null);

    }

}
