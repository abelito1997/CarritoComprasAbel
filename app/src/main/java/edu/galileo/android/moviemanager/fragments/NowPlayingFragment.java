package edu.galileo.android.moviemanager.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import edu.galileo.android.moviemanager.R;
import edu.galileo.android.moviemanager.adapters.MovieRecyclerViewAdapter;
import edu.galileo.android.moviemanager.models.Movie;

/**
 * A simple {@link Fragment} subclass.
 */
public class NowPlayingFragment extends Fragment {


    @BindView(R.id.rvMovies)
    RecyclerView rvMovies;
    public static ArrayList<Movie>movies= new ArrayList<Movie>();

    public static ArrayList<Movie> imageMovieArrayList2= new ArrayList<Movie>();

    public static ArrayList<Movie> getMovies() {
        return movies;
    }

    public void CargarLista(){
        imageMovieArrayList2.removeAll(imageMovieArrayList2);
        for(Movie lista:NowPlayingFragment.getMovies()){
            if(lista.getHayDescuento().contains("N")) {
                imageMovieArrayList2.add(lista);
            }
        }
    }

    public NowPlayingFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_now_playing, container, false);
        ButterKnife.bind(this, view);

        initializeData();

        LinearLayoutManager llm = new LinearLayoutManager(this.getContext());

        rvMovies.setHasFixedSize(true);
        rvMovies.setLayoutManager(llm);

        MovieRecyclerViewAdapter adapter = new MovieRecyclerViewAdapter(getContext(), imageMovieArrayList2);
        rvMovies.setAdapter(adapter);

        return view;
    }

    private void initializeData() {

        movies = new ArrayList<>();
       movies.add(
                new Movie(
                        1,
                        "Guitarra",
                        "Cuerda",
                        150.00,
                        "N",
                        0,
                        "",
                        "https://eckomusic.com/media/catalog/product/cache/1/thumbnail/140x160/9df78eab33525d08d6e5fb8d27136e95/0/0/008171.jpg",
                        "http://www.hdfondos.eu/pictures/2013/0112/1/guitars-musical-instrument-strings-pics-170542.jpg"));

        movies.add(
                new Movie(
                        1,
                        "Guitarra",
                        "Cuerda",
                        150.00,
                        "S",
                        30,
                        "",
                        "https://eckomusic.com/media/catalog/product/cache/1/thumbnail/140x160/9df78eab33525d08d6e5fb8d27136e95/0/0/008171.jpg",
                        "http://www.hdfondos.eu/pictures/2013/0112/1/guitars-musical-instrument-strings-pics-170542.jpg"));


        movies.add(
                new Movie(
                        1,
                        "Piano",
                        "Teclados",
                        150.00,
                        "N",
                        10,
                        "",
                        "https://eckomusic.com/media/catalog/product/cache/1/thumbnail/140x160/9df78eab33525d08d6e5fb8d27136e95/0/0/008171.jpg",
                        "http://www.hdfondos.eu/pictures/2013/0112/1/guitars-musical-instrument-strings-pics-170542.jpg"));

        movies.add(
                new Movie(
                        1,
                        "Saxofon",
                        "Viento",
                        300.00,
                        "S",
                        50,
                        "",
                        "https://eckomusic.com/media/catalog/product/cache/1/thumbnail/140x160/9df78eab33525d08d6e5fb8d27136e95/0/0/006149.jpg",
                        "https://previews.123rf.com/images/ogolne/ogolne1101/ogolne110100010/8559856--clarinete-en-una-hoja-de-notas-de-m%C3%BAsica.jpg"));


        /*movies.add(
                new Movie(
                        1,
                        "",
                        "",
                        0.0,
                        "N",
                        0,
                        "",
                        "",
                        ""));
        movies.add(
                new Movie(
                        1,
                        "",
                        "",
                        0.0,
                        "N",
                        0,
                        "",
                        "",
                        ""));

*//*
        movies.add(new Movie("277834", "Moana", "In Ancient Polynesia, when a terrible curse incurred by Maui reaches an impetuous Chieftain's daughter's island, she answers the Ocean's call to seek out the demigod to set things right.", 6.5f, 854, "/z4x0Bp48ar3Mda8KiPD1vwSY3D8.jpg", "/1qGzqGUd1pa05aqYXGSbLkiBlLB.jpg"));
        movies.add(new Movie("121856", "Passengers", "A spacecraft traveling to a distant colony planet and transporting thousands of people has a malfunction in its sleep chambers. As a result, two passengers are awakened 90 years early.", 6.2f, 745, "/5gJkVIVU7FDp7AfRAbPSvvdbre2.jpg", "/5EW4TR3fWEqpKsWysNcBMtz9Sgp.jpg"));
        movies.add(new Movie("330459", "Assassin's Creed", "Lynch discovers he is a descendant of the secret Assassins society through unlocked genetic memories that allow him to relive the adventures of his ancestor, Aguilar, in 15th Century Spain. After gaining incredible knowledge and skills he’s poised to take on the oppressive Knights Templar in the present day.", 5.3f, 691, "/tIKFBxBZhSXpIITiiB5Ws8VGXjt.jpg", "/5EW4TR3fWEqpKsWysNcBMtz9Sgp.jpg"));
        movies.add(new Movie("283366", "Rogue One: A Star Wars Story", "A rogue band of resistance fighters unite for a mission to steal the Death Star plans and bring a new hope to the galaxy.", 7.2f, 1802, "/qjiskwlV1qQzRCjpV0cL9pEMF9a.jpg", "/tZjVVIYXACV4IIIhXeIM59ytqwS.jpg"));
        movies.add(new Movie("313369", "La La Land", "Mia, an aspiring actress, serves lattes to movie stars in between auditions and Sebastian, a jazz musician, scrapes by playing cocktail party gigs in dingy bars, but as success mounts they are faced with decisions that begin to fray the fragile fabric of their love affair, and the dreams they worked so hard to maintain in each other threaten to rip them apart.", 8, 396, "/ylXCdC106IKiarftHkcacasaAcb.jpg", "/nadTlnTE6DdgmYsN4iWc2a2wiaI.jpg"));

    }*/
        CargarLista();


    }
}
