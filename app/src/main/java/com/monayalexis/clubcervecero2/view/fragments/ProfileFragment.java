package com.monayalexis.clubcervecero2.view.fragments;


import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.monayalexis.clubcervecero2.LoginActivity;
import com.monayalexis.clubcervecero2.R;
import com.monayalexis.clubcervecero2.adapter.PictureAdapterRecyclerView;
import com.monayalexis.clubcervecero2.model.Picture;
import com.monayalexis.clubcervecero2.view.ContainerActivity;
import com.monayalexis.clubcervecero2.view.CreateAccountActivity;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * A simple {@link Fragment} subclass.
 */
public class ProfileFragment extends Fragment implements View.OnClickListener {

    private CircleImageView imagen;
    private Toolbar toolbar;
    private ImageView exitButton;

    private FirebaseAuth mAuth;


    public ProfileFragment() {
        // Required empty public constructor
    }


    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_profile, container, false);

        imagen = view.findViewById(R.id.fotoPerfil);
        toolbar = view.findViewById(R.id.toolbarProfile);
        exitButton = view.findViewById(R.id.exitButton);
        mAuth = FirebaseAuth.getInstance();

        exitButton.setOnClickListener(this);

        RecyclerView recyclerView = view.findViewById(R.id.picturesPerfilRecycler);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        PictureAdapterRecyclerView pictureAdapterRecyclerView =
                new PictureAdapterRecyclerView(buildPictures(), R.layout.cardview_picture, getActivity());

        recyclerView.setLayoutManager(linearLayoutManager);

        recyclerView.setAdapter(pictureAdapterRecyclerView);

        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if (user != null) {

            // Name, email address, and profile photo Url
            String name = user.getDisplayName();

            Uri photoUrl = user.getPhotoUrl();

            toolbar.setTitle(name);

            Picasso.with(view.getContext()).load(photoUrl)
                    .placeholder(R.drawable.ic_person).error(R.drawable.ic_person).into(imagen);

        }

        return view;

    }


    public ArrayList<Picture> buildPictures() {

        ArrayList<Picture> pictures = new ArrayList<>();

        pictures.add(new Picture("https://images.clarin.com/2019/03/28/LqsIpI6FD_1256x620__1.jpg",
                "Cervecería Lagash", "Hace 6 horas", "30 Me gusta", "Calle Ruiz Moreno 657",
                "--","Martes a Domingo de 19:30 a 2 Hs","Gay Friendly",
                true,-32.477274, -58.248289));

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
                "03442 15-53-9608", "Miercoles a Ssabado de 20:00 a 3 Hs", "Gay Friendly",
                true,-32.481204, -58.237988));

        pictures.add(new Picture("https://images.clarin.com/2019/01/15/uH8yqnI9W_1256x620__1.jpg",
                "7 Colinas Cervecería Artesanal", "Hace 7 horas", "30 Me gusta", "Estrada 838",
                "03442 43-2811","Martes a Domingo de 19:30 a 2 Hs", "Child Friendly",
                true, -32.479900,-58.235322));

        pictures.add(new Picture("https://images.clarin.com/2019/01/15/entre-las-variedades-mas-buscadas___JBnsNc5S8_1200x0__1.jpg",
                "Cerveza Artesanal Biguá", "Hace 7 horas", "33 Me gusta", "Juan Domingo Perón 34",
                "--","Lunes a Domingo de 19:30 a 00:30 Hs.", "Pet Friendly",
                true, -32.485051, -58.231004));


        return  pictures;
    }


    @Override
    public void onClick(View view) {

        mAuth.signOut();
        Toast.makeText(ProfileFragment.super.getContext(), "Sesion finalizada.", Toast.LENGTH_SHORT).show();
        ProfileFragment.super.getActivity().finish();
        //Intent intent = new Intent(ProfileFragment.super.getContext(), LoginActivity.class);
        //startActivity(intent);
    }
}
