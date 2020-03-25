package com.monayalexis.clubcervecero2.view;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.monayalexis.clubcervecero2.R;
import com.squareup.picasso.Picasso;

public class PictureDetailActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private String picture;
    private String name;
    private String likes;
    private TextView nameDetalle;
    private TextView likesDetalle;
    private ImageView pictureDetalle;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_picture_detail);

        toolbar = findViewById(R.id.toolbarDetalles);

        picture = getIntent().getStringExtra("picture");
        name = getIntent().getStringExtra("name");
        likes = getIntent().getStringExtra("likes");

        pictureDetalle = findViewById(R.id.imageHeader);
        nameDetalle = findViewById(R.id.userNameDetail);
        likesDetalle = findViewById(R.id.likesDetalle);

        Picasso.with(this).load(picture).error(R.drawable.ic_error_outline).into(pictureDetalle);
        nameDetalle.setText(name);
        likesDetalle.setText(likes);


        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });


    }
}
