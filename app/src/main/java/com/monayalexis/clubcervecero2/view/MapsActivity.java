package com.monayalexis.clubcervecero2.view;

import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.monayalexis.clubcervecero2.R;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private String title, direccion, telefono, horario, mensaje;
    private Double lat, lng;

    private TextView titleMaps, direccionMaps, telefonoMaps, horarioMaps, mensajeMaps;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);

        title = getIntent().getStringExtra("title");
        lat = getIntent().getDoubleExtra("lat", -32.484483);
        lng = getIntent().getDoubleExtra("lng", -58.232145);
        direccion = getIntent().getStringExtra("direccion");
        telefono = getIntent().getStringExtra("telefono");
        horario = getIntent().getStringExtra("horario");
        mensaje = getIntent().getStringExtra("mensaje");

        titleMaps = findViewById(R.id.titleMaps);
        direccionMaps = findViewById(R.id.direccionMaps);
        telefonoMaps = findViewById(R.id.telefonoMaps);
        horarioMaps = findViewById(R.id.horarioMaps);
        mensajeMaps = findViewById(R.id.mensajeMaps);

        titleMaps.setText(title);
        direccionMaps.setText(direccion);
        telefonoMaps.setText(telefono);
        horarioMaps.setText(horario);
        mensajeMaps.setText(mensaje);

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);

        mapFragment.getMapAsync(this);
    }


    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng lugar = new LatLng(lat, lng);
        mMap.addMarker(new MarkerOptions().position(lugar).title(title).snippet(direccion)).showInfoWindow();

        mMap.moveCamera(CameraUpdateFactory.newLatLng(lugar));

        CameraPosition cameraPosition = CameraPosition.builder().target(lugar).zoom(15).build();

        mMap.moveCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
    }
}
