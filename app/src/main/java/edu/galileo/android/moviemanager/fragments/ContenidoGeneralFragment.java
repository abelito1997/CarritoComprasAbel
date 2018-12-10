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
 */
public class ContenidoGeneralFragment extends Fragment {


    @BindView(R.id.rvMovies)
    RecyclerView rvMovies;
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

    public ContenidoGeneralFragment() {
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

        MovieRecyclerViewAdapter adapter = new MovieRecyclerViewAdapter(getContext(), imageInstrumentosArrayList2);
        rvMovies.setAdapter(adapter);

        return view;
    }

    private void initializeData() {

        instrumentos = new ArrayList<>();
        instrumentos.removeAll(getInstrumentos());
       instrumentos.add(
                new Instrumentos(
                        1,
                        "Guitarra Acustica Yamaha",
                        "Cuerda",
                        150.00,
                        "N",
                        0,
                        "",
                        "https://eckomusic.com/media/catalog/product/cache/1/thumbnail/140x160/9df78eab33525d08d6e5fb8d27136e95/0/0/008171.jpg",
                        "http://www.hdfondos.eu/pictures/2013/0112/1/guitars-musical-instrument-strings-pics-170542.jpg",
                        4));

        instrumentos.add(
                new Instrumentos(
                        2,
                        "Piano korg electrico key",
                        "Teclados",
                        150.00,
                        "S",
                        20,
                        "",
                        "https://eckomusic.com/media/catalog/product/cache/1/thumbnail/140x160/9df78eab33525d08d6e5fb8d27136e95/0/0/002154.jpg",
                        "https://www.buscarinstrumentos.com/wp-content/uploads/2017/01/Algunos-de-los-mejores-pianistas-de-la-historia.jpg",
                        4));

        instrumentos.add(
                new Instrumentos(
                        3,
                        "Timbales dadi plateados",
                        "Percusion",
                        150.00,
                        "N",
                        0,
                        "",
                        "https://eckomusic.com/media/catalog/product/cache/1/thumbnail/140x160/9df78eab33525d08d6e5fb8d27136e95/0/1/012218.jpg",
                        "http://1.bp.blogspot.com/-HLIoC3tM_NQ/VfYX31dyi4I/AAAAAAAAEwM/L5m3qHwnbXg/s1600/Adel%2BGonz%25C3%25A1lez%2B%252C%2Bpercusionista.jpg",
                        4));



        instrumentos.add(
                new Instrumentos(
                        4,
                        "Guitarra electrica ibaÑez/24 ",
                        "Cuerda",
                        450.00,
                        "S",
                        30,
                        "",
                        "https://eckomusic.com/media/catalog/product/cache/1/thumbnail/140x160/9df78eab33525d08d6e5fb8d27136e95/0/1/012067.jpg",
                        "http://www.hdfondos.eu/pictures/2013/0112/1/guitars-musical-instrument-strings-pics-170542.jpg",
                        4));



        instrumentos.add(
                new Instrumentos(
                        5,
                        "Bajo ibanez activo/4cuerdas/c. rojo ",
                        "Cuerda",
                        600.00,
                        "N",
                        0,
                        "",
                        "https://eckomusic.com/media/catalog/product/cache/1/thumbnail/140x160/9df78eab33525d08d6e5fb8d27136e95/0/0/001713.jpg",
                        "https://ghermansanchezonline.com/wp-content/uploads/2013/09/bass.jpg",
                        3));


        instrumentos.add(
                new Instrumentos(
                        6,
                        "Piano Casio",
                        "Teclados",
                        150.00,
                        "S",
                        15,
                        "",
                        "https://eckomusic.com/media/catalog/product/cache/1/thumbnail/140x160/9df78eab33525d08d6e5fb8d27136e95/0/0/008171.jpg",
                        "https://www.buscarinstrumentos.com/wp-content/uploads/2017/01/Algunos-de-los-mejores-pianistas-de-la-historia.jpg",
                        5));


        instrumentos.add(
                new Instrumentos(
                        7,
                        "Conga dadi (par) fibra vidrio/borde ",
                        "Percusion",
                        150.00,
                        "N",
                        0,
                        "",
                        "https://eckomusic.com/media/catalog/product/cache/1/thumbnail/140x160/9df78eab33525d08d6e5fb8d27136e95/0/0/004126.jpg",
                        "http://2.bp.blogspot.com/-EWW6QlmlU5Y/UWLwqY79J_I/AAAAAAAAABQ/LupjH0oa3qs/s1600/Giovanni+Hidalgo.jpg",
                        2));
        instrumentos.add(
        new Instrumentos(
                8,
                "SAXOFON JEAN PAUL ALTO C/CASE",
                "Viento",
                400.00,
                "S",
                50,
                "",
                "https://eckomusic.com/media/catalog/product/cache/1/thumbnail/140x160/9df78eab33525d08d6e5fb8d27136e95/0/0/006149.jpg",
                "https://www.lafactoriadelshow.com/full_55f1439cc0970_1374538867757745552.jpg",
        2));

        instrumentos.add(
                new Instrumentos(
                        9,
                        "Bateria yamaha electrica/4pads/99 ",
                        "Percusion",
                        1500.00,
                        "N",
                        10,
                        "",
                        "https://eckomusic.com/media/catalog/product/cache/1/thumbnail/140x160/9df78eab33525d08d6e5fb8d27136e95/0/0/005813.jpg",
                        "http://1.bp.blogspot.com/-HLIoC3tM_NQ/VfYX31dyi4I/AAAAAAAAEwM/L5m3qHwnbXg/s1600/Adel%2BGonz%25C3%25A1lez%2B%252C%2Bpercusionista.jpg",
                3));

/*
        instrumentos.add(
                new Instrumentos(
                        2,
                        "Guitarra",
                        "Cuerda",
                        300.00,
                        "S",
                        30,
                        "",
                        "https://eckomusic.com/media/catalog/product/cache/1/thumbnail/140x160/9df78eab33525d08d6e5fb8d27136e95/0/0/008171.jpg",
                        "http://www.hdfondos.eu/pictures/2013/0112/1/guitars-musical-instrument-strings-pics-170542.jpg"));


        instrumentos.add(
                new Instrumentos(
                        3,
                        "Piano Casio 7 Octavas",
                        "Teclados",
                        500.00,
                        "N",
                        10,
                        "",
                        "https://eckomusic.com/media/catalog/product/cache/1/thumbnail/140x160/9df78eab33525d08d6e5fb8d27136e95/0/1/011447.jpg",
                        "http://www.hdfondos.eu/pictures/2013/0112/1/guitars-musical-instrument-strings-pics-170542.jpg"));

        instrumentos.add(
                new Instrumentos(
                        4,
                        "Saxofon",
                        "Viento",
                        400.00,
                        "S",
                        50,
                        "",
                        "https://eckomusic.com/media/catalog/product/cache/1/thumbnail/140x160/9df78eab33525d08d6e5fb8d27136e95/0/0/006149.jpg",
                        "https://previews.123rf.com/images/ogolne/ogolne1101/ogolne110100010/8559856--clarinete-en-una-hoja-de-notas-de-m%C3%BAsica.jpg"));

        instrumentos.add(
                new Instrumentos(
                        5,
                        "Bateria Pearl",
                        "Percusion",
                        1500.00,
                        "N",
                        10,
                        "",
                        "https://eckomusic.com/media/catalog/product/cache/1/thumbnail/140x160/9df78eab33525d08d6e5fb8d27136e95/0/1/010025.jpg",
                        "http://www.hdfondos.eu/pictures/2013/0112/1/guitars-musical-instrument-strings-pics-170542.jpg"));

        instrumentos.add(
                new Instrumentos(
                        6,
                        "Bongos",
                        "Percusion",
                        670.00,
                        "N",
                        10,
                        "",
                        "https://eckomusic.com/media/catalog/product/cache/1/thumbnail/140x160/9df78eab33525d08d6e5fb8d27136e95/0/0/002040.jpg",
                        "http://www.hdfondos.eu/pictures/2013/0112/1/guitars-musical-instrument-strings-pics-170542.jpg"));


        instrumentos.add(
                new Instrumentos(
                        7,
                        "Bajo Electrico Ibañez",
                        "Cuerda",
                        450.00,
                        "N",
                        10,
                        "",
                        "https://eckomusic.com/media/catalog/product/cache/1/thumbnail/140x160/9df78eab33525d08d6e5fb8d27136e95/0/0/001713.jpg",
                        "http://www.hdfondos.eu/pictures/2013/0112/1/guitars-musical-instrument-strings-pics-170542.jpg"));

        instrumentos.add(
                new Instrumentos(
                        8,
                        "Violin",
                        "Cuerda",
                        700.00,
                        "S",
                        30,
                        "",
                        "https://eckomusic.com/media/catalog/product/cache/1/thumbnail/140x160/9df78eab33525d08d6e5fb8d27136e95/0/0/009737.jpg",
                        "http://www.hdfondos.eu/pictures/2013/0112/1/guitars-musical-instrument-strings-pics-170542.jpg"));

        instrumentos.add(
                new Instrumentos(
                        9,
                        "Melédica",
                        "Viento",
                        29.00,
                        "S",
                        10,
                        "",
                        "https://eckomusic.com/media/catalog/product/cache/1/thumbnail/140x160/9df78eab33525d08d6e5fb8d27136e95/0/0/007245.jpg",
                        "http://www.hdfondos.eu/pictures/2013/0112/1/guitars-musical-instrument-strings-pics-170542.jpg"));

        instrumentos.add(
                new Instrumentos(
                        10,
                        "Organo",
                        "Teclados",
                        3000.00,
                        "S",
                        30,
                        "",
                        "https://eckomusic.com/media/catalog/product/cache/1/thumbnail/140x160/9df78eab33525d08d6e5fb8d27136e95/0/0/002569.jpg",
                        "http://www.hdfondos.eu/pictures/2013/0112/1/guitars-musical-instrument-strings-pics-170542.jpg"));

        instrumentos.add(
                new Instrumentos(
                        1,
                        "",
                        "",
                        0.0,
                        "N",
                        0,
                        "",
                        "",
                        ""));
        instrumentos.add(
                new Instrumentos(
                        1,
                        "",
                        "",
                        0.0,
                        "N",
                        0,
                        "",
                        "",
                        ""));

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
