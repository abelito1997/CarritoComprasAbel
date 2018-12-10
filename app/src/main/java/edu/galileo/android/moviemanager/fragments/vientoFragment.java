package edu.galileo.android.moviemanager.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import edu.galileo.android.moviemanager.R;
import edu.galileo.android.moviemanager.adapters.MovieRecyclerViewAdapter;
import edu.galileo.android.moviemanager.models.Instrumentos;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the

 * to handle interaction events.

 * create an instance of this fragment.
 */
public class vientoFragment extends Fragment {

    @BindView(R.id.rvMviento)
    RecyclerView rvVientos;
    public static ArrayList<Instrumentos> instrumentos = new ArrayList<Instrumentos>();

    public static ArrayList<Instrumentos> imageInstrumentosArrayList2 = new ArrayList<Instrumentos>();

    public static ArrayList<Instrumentos> getInstrumentos() {
        return instrumentos;
    }

    public void CargarLista(){
        imageInstrumentosArrayList2.removeAll(imageInstrumentosArrayList2);
        for(Instrumentos lista:ContenidoGeneralFragment.getInstrumentos()){
            if(lista.getHayDescuento().contains("N")) {
                imageInstrumentosArrayList2.add(lista);
            }
        }
    }

    public vientoFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_viento, container, false);
        ButterKnife.bind(this, view);

        initializeData();

        LinearLayoutManager llm = new LinearLayoutManager(this.getContext());

        rvVientos.setHasFixedSize(true);
        rvVientos.setLayoutManager(llm);

        MovieRecyclerViewAdapter adapter = new MovieRecyclerViewAdapter(getContext(), instrumentos);
        rvVientos.setAdapter(adapter);

        return view;
    }

    private void initializeData() {

        instrumentos = new ArrayList<>();
        instrumentos.add(
                new Instrumentos(
                        23,
                        "Flauta yamaha dulce/tres piezas",
                        "viento",
                        50.00,
                        "N",
                        0,
                        "",
                        "https://eckomusic.com/media/catalog/product/cache/1/thumbnail/140x160/9df78eab33525d08d6e5fb8d27136e95/0/0/002234.jpg",
                        "https://image.freepik.com/foto-gratis/un-saxofonista-en-un-fondo-oscuro_41418-1913.jpg",
                        4));

        instrumentos.add(
                new Instrumentos(
                        24,
                        "Flauta plastica verde",
                        "Viento",
                        30.00,
                        "S",
                        30,
                        "",
                        "https://eckomusic.com/media/catalog/product/cache/1/thumbnail/140x160/9df78eab33525d08d6e5fb8d27136e95/0/0/002935.jpg",
                        "https://image.freepik.com/foto-gratis/un-saxofonista-en-un-fondo-oscuro_41418-1913.jpg",2));


        instrumentos.add(
                new Instrumentos(
                        25,
                        "Clarinete jean paul/17 ",
                        "Viento",
                        500.00,
                        "N",
                        10,
                        "",
                        "https://eckomusic.com/media/catalog/product/cache/1/thumbnail/140x160/9df78eab33525d08d6e5fb8d27136e95/0/0/006148.jpg",
                        "http://www.hdfondos.eu/pictures/2013/0112/1/guitars-musical-instrument-strings-pics-170542.jpg",3));

        instrumentos.add(
                new Instrumentos(
                        26,
                        "Saxofon jean paul alto c/case",
                        "Viento",
                        400.00,
                        "S",
                        50,
                        "",
                        "https://eckomusic.com/media/catalog/product/cache/1/thumbnail/140x160/9df78eab33525d08d6e5fb8d27136e95/0/0/006149.jpg",
                        "https://previews.123rf.com/images/ogolne/ogolne1101/ogolne110100010/8559856--clarinete-en-una-hoja-de-notas-de-m%C3%BAsica.jpg",2));

        instrumentos.add(
                new Instrumentos(
                        27,
                        "Harmonica suzuki pure harp",
                        "Viento",
                        112.00,
                        "N",
                        10,
                        "",
                        "https://eckomusic.com/media/catalog/product/cache/1/thumbnail/140x160/9df78eab33525d08d6e5fb8d27136e95/0/0/002040.jpg",
                        "http://www.hdfondos.eu/pictures/2013/0112/1/guitars-musical-instrument-strings-pics-170542.jpg",4));

        instrumentos.add(
                new Instrumentos(
                        28,
                        "Harmonica suzuki fire breath",
                        "Viento",
                        70.00,
                        "N",
                        10,
                        "",
                        "https://eckomusic.com/media/catalog/product/cache/1/thumbnail/140x160/9df78eab33525d08d6e5fb8d27136e95/0/0/006469.jpg",
                        "http://www.hdfondos.eu/pictures/2013/0112/1/guitars-musical-instrument-strings-pics-170542.jpg",1));


        instrumentos.add(
                new Instrumentos(
                        29,
                        "Acordeon 72 bajos/34 teclas/negro",
                        "Viento",
                        450.00,
                        "N",
                        10,
                        "",
                        "https://eckomusic.com/media/catalog/product/cache/1/small_image/270x320/9df78eab33525d08d6e5fb8d27136e95/0/1/012736.jpg",
                        "http://www.hdfondos.eu/pictures/2013/0112/1/guitars-musical-instrument-strings-pics-170542.jpg",2));

        instrumentos.add(
                new Instrumentos(
                        30,
                        "Acordeon 48 bajos/34 teclas/negro",
                        "Viento",
                        732.00,
                        "N",
                        30,
                        "",
                        "https://eckomusic.com/media/catalog/product/cache/1/thumbnail/140x160/9df78eab33525d08d6e5fb8d27136e95/0/1/012738.jpg",
                        "http://www.hdfondos.eu/pictures/2013/0112/1/guitars-musical-instrument-strings-pics-170542.jpg",3));

        instrumentos.add(
                new Instrumentos(
                        31,
                        "Melodica bandleader 27k azul",
                        "Viento",
                        29.00,
                        "N",
                        0,
                        "",
                        "https://eckomusic.com/media/catalog/product/cache/1/thumbnail/140x160/9df78eab33525d08d6e5fb8d27136e95/0/0/007245.jpg",
                        "http://www.hdfondos.eu/pictures/2013/0112/1/guitars-musical-instrument-strings-pics-170542.jpg",3));



      /*
        instrumentos.add(new Instrumentos("277834", "Moana", "In Ancient Polynesia, when a terrible curse incurred by Maui reaches an impetuous Chieftain's daughter's island, she answers the Ocean's call to seek out the demigod to set things right.", 6.5f, 854, "/z4x0Bp48ar3Mda8KiPD1vwSY3D8.jpg", "/1qGzqGUd1pa05aqYXGSbLkiBlLB.jpg"));
        instrumentos.add(new Instrumentos("121856", "Passengers", "A spacecraft traveling to a distant colony planet and transporting thousands of people has a malfunction in its sleep chambers. As a result, two passengers are awakened 90 years early.", 6.2f, 745, "/5gJkVIVU7FDp7AfRAbPSvvdbre2.jpg", "/5EW4TR3fWEqpKsWysNcBMtz9Sgp.jpg"));
        instrumentos.add(new Instrumentos("330459", "Assassin's Creed", "Lynch discovers he is a descendant of the secret Assassins society through unlocked genetic memories that allow him to relive the adventures of his ancestor, Aguilar, in 15th Century Spain. After gaining incredible knowledge and skills he’s poised to take on the oppressive Knights Templar in the present day.", 5.3f, 691, "/tIKFBxBZhSXpIITiiB5Ws8VGXjt.jpg", "/5EW4TR3fWEqpKsWysNcBMtz9Sgp.jpg"));
        instrumentos.add(new Instrumentos("283366", "Rogue One: A Star Wars Story", "A rogue band of resistance fighters unite for a mission to steal the Death Star plans and bring a new hope to the galaxy.", 7.2f, 1802, "/qjiskwlV1qQzRCjpV0cL9pEMF9a.jpg", "/tZjVVIYXACV4IIIhXeIM59ytqwS.jpg"));
        instrumentos.add(new Instrumentos("313369", "La La Land", "Mia, an aspiring actress, serves lattes to movie stars in between auditions and Sebastian, a jazz musician, scrapes by playing cocktail party gigs in dingy bars, but as success mounts they are faced with decisions that begin to fray the fragile fabric of their love affair, and the dreams they worked so hard to maintain in each other threaten to rip them apart.", 8, 396, "/ylXCdC106IKiarftHkcacasaAcb.jpg", "/nadTlnTE6DdgmYsN4iWc2a2wiaI.jpg"));

    }*/
        CargarLista();


    }
}
