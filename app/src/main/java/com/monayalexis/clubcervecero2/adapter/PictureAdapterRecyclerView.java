package com.monayalexis.clubcervecero2.adapter;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.monayalexis.clubcervecero2.LoginActivity;
import com.monayalexis.clubcervecero2.R;
import com.monayalexis.clubcervecero2.model.Picture;
import com.monayalexis.clubcervecero2.view.ContainerActivity;
import com.monayalexis.clubcervecero2.view.MapsActivity;
import com.monayalexis.clubcervecero2.view.PictureDetailActivity;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class PictureAdapterRecyclerView extends RecyclerView.Adapter<PictureAdapterRecyclerView.PictureViewHolder> {

    private ArrayList<Picture> pictures;
    private int resource;
    private Activity activity;

    public PictureAdapterRecyclerView(ArrayList<Picture> pictures, int resource, FragmentActivity activity) {

        this.pictures = pictures;
        this.resource = resource;
        this.activity = activity;

    }

    @NonNull
    @Override
    public PictureViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(resource, parent, false);

        PictureViewHolder pictureViewHolder = new PictureViewHolder(view);

        return pictureViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final PictureViewHolder holder, int position) {

        final Picture picture = pictures.get(position);

        holder.nameCard.setText(picture.getUserName());
        holder.timeCard.setText(picture.getTime());
        holder.likesCard.setText(picture.getLikesNumber());
        holder.likeCheckCard.setChecked(picture.getIsLike());

        //Picasso.get().load(picture.getPicture()).into(holder.pictureCard);
        Picasso.with(activity).load(picture.getPicture()).error(R.drawable.ic_error_outline).into(holder.pictureCard);
        // con la version 2.5.2 de picasso se usa with(activity) y no get()

        holder.pictureCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(activity, PictureDetailActivity.class);

                intent.putExtra("picture", picture.getPicture());
                intent.putExtra("name", picture.getUserName());
                intent.putExtra("likes", picture.getLikesNumber());

                activity.startActivity(intent);

            }
        });

        holder.shareCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(activity.getApplicationContext(), "Compartir", Toast.LENGTH_LONG).show();

            }
        });

        holder.placeCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(activity.getApplicationContext(), MapsActivity.class);

                intent.putExtra("title", picture.getUserName());
                intent.putExtra("lat", picture.getLat());
                intent.putExtra("lng", picture.getLng());
                intent.putExtra("direccion", picture.getDireccion());
                intent.putExtra("telefono", picture.getTelefono());
                intent.putExtra("horario", picture.getHorario());
                intent.putExtra("mensaje", picture.getMensaje());

                activity.startActivity(intent);

            }
        });

    }

    @Override
    public int getItemCount() {

        return pictures.size();

    }



    public class PictureViewHolder extends RecyclerView.ViewHolder {

        private ImageView pictureCard;
        private TextView nameCard;
        private TextView timeCard;
        private TextView likesCard;
        private CheckBox likeCheckCard;
        private ImageView shareCard;
        private ImageView placeCard;


        public PictureViewHolder(@NonNull View itemView) {
            super(itemView);

            pictureCard = itemView.findViewById(R.id.pictureCard);
            nameCard = itemView.findViewById(R.id.cardViewName);
            timeCard = itemView.findViewById(R.id.timeCard);
            likesCard = itemView.findViewById(R.id.likesCard);
            likeCheckCard = itemView.findViewById(R.id.likeCheckCard);
            shareCard = itemView.findViewById(R.id.shareCard);
            placeCard = itemView.findViewById(R.id.placeCard);

        }

    }
}
