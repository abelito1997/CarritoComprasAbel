package edu.galileo.android.moviemanager.models;


import java.io.Serializable;

public class Movie implements Serializable{
    int id;
    String nombInstrumento;
    String categoria;
    double precio;
    String HayDescuento;
    int porcDescuento;
    String valorDescuento;
    String url_Instrumento_image;
    String url_Instrumento_poster;

    public Movie(int id, String nombInstrumento, String categoria, double precio, String hayDescuento, int porcDescuento, String valorDescuento, String url_Instrumento_image, String url_Instrumento_poster) {
        this.id = id;
        this.nombInstrumento = nombInstrumento;
        this.categoria = categoria;
        this.precio = precio;
        HayDescuento = hayDescuento;
        this.porcDescuento = porcDescuento;
        this.valorDescuento = valorDescuento;
        this.url_Instrumento_image = url_Instrumento_image;
        this.url_Instrumento_poster = url_Instrumento_poster;
    }

    public int getId() {
        return id;
    }

    public String getNombInstrumento() {
        return nombInstrumento;
    }

    public String getCategoria() {
        return categoria;
    }

    public double getPrecio() {
        return precio;
    }

    public String getHayDescuento() {
        return HayDescuento;
    }

    public int getPorcDescuento() {
        return porcDescuento;
    }

    public String getValorDescuento() {
        return valorDescuento;
    }

    public String getUrl_Instrumento_image() {
        return url_Instrumento_image;
    }

    public String getUrl_Instrumento_poster() {
        return url_Instrumento_poster;
    }

    //setter

    public void setPorcDescuento(int porcDescuento) {
        this.porcDescuento = porcDescuento;
    }

    public void setValorDescuento(String valorDescuento) {
        this.valorDescuento = valorDescuento;
    }

/*
    String id;
    String title;
    String overview;
    float voteAverage;
    float voteCount;
    String posterPath;
    String backdropPath;




    public Movie(String id, String title, String overview, float voteAverage, float voteCount, String posterPath, String backdropPath) {
        this.id = id;
        this.title = title;
        this.overview = overview;
        this.voteAverage = voteAverage;
        this.voteCount = voteCount;
        this.posterPath = posterPath;
        this.backdropPath = backdropPath;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public float getVoteAverage() {
        return voteAverage;
    }

    public void setVoteAverage(float voteAverage) {
        this.voteAverage = voteAverage;
    }

    public float getVoteCount() {
        return voteCount;
    }

    public void setVoteCount(float voteCount) {
        this.voteCount = voteCount;
    }

    public String getPosterPath() {
        return String.format("https://image.tmdb.org/t/p/w342%s", posterPath);
    }

    public void setPosterPath(String posterPath) {
        this.posterPath = posterPath;
    }

    public String getBackdropPath() {
        return String.format("https://image.tmdb.org/t/p/w780%s", backdropPath);
    }

    public void setBackdropPath(String backdropPath) {
        this.backdropPath = backdropPath;
    }*/

}
