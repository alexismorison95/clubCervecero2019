package com.monayalexis.clubcervecero2.model;

public class Picture {

    private String picture, userName, time, likesNumber, direccion, telefono, horario, mensaje;
    private Boolean isLike;
    private Double lat, lng;

    public Picture(String picture, String userName, String time, String likesNumber, String direccion,
                   String telefono, String horario, String mensaje, Boolean isLike, Double lat, Double lng) {

        this.picture = picture;
        this.userName = userName;
        this.time = time;
        this.likesNumber = likesNumber;
        this.direccion = direccion;
        this.telefono = telefono;
        this.horario = horario;
        this.mensaje = mensaje;
        this.isLike = isLike;
        this.lat = lat;
        this.lng = lng;

    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getLikesNumber() {
        return likesNumber;
    }

    public void setLikesNumber(String likesNumber) {
        this.likesNumber = likesNumber;
    }

    public Boolean getIsLike() {
        return isLike;
    }

    public void setIsLike(Boolean isLike) {
        this.isLike = isLike;
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Double getLng() {
        return lng;
    }

    public void setLng(Double lng) {
        this.lng = lng;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
}
