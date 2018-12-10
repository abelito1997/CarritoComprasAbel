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
public class guitarrasFragment extends Fragment {
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

    public guitarrasFragment() {
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
                        17,
                        "Guitarra electrica ibanez/22 ",
                        "Cuerdas",
                        350.00,
                        "N",
                        0,
                        "",
                        "https://eckomusic.com/media/catalog/product/cache/1/thumbnail/140x160/9df78eab33525d08d6e5fb8d27136e95/0/1/012061.jpg",
                        "http://www.hdfondos.eu/pictures/2013/0112/1/guitars-musical-instrument-strings-pics-170542.jpg",
                        4));

        instrumentos.add(
                new Instrumentos(
                        18,
                        "Guitarra eko electroacustica ",
                        "Cuerda",
                        300.00,
                        "S",
                        30,
                        "",
                        "https://eckomusic.com/media/catalog/product/cache/1/thumbnail/140x160/9df78eab33525d08d6e5fb8d27136e95/0/1/012251.jpg",
                        "http://www.hdfondos.eu/pictures/2013/0112/1/guitars-musical-instrument-strings-pics-170542.jpg",1));


        instrumentos.add(
                new Instrumentos(
                        19,
                        "Bajo electrico ",
                        "Cuerdas",
                        500.00,
                        "N",
                        10,
                        "",
                        "https://eckomusic.com/media/catalog/product/cache/1/thumbnail/140x160/9df78eab33525d08d6e5fb8d27136e95/0/1/012070.jpg",
                        "http://www.hdfondos.eu/pictures/2013/0112/1/guitars-musical-instrument-strings-pics-170542.jpg",3));

        instrumentos.add(
                new Instrumentos(
                        20,
                        "Bajo ibanez activo/4cuerdas/c. rojo ",
                        "cuerdas",
                        400.00,
                        "S",
                        50,
                        "",
                        "https://eckomusic.com/media/catalog/product/cache/1/thumbnail/140x160/9df78eab33525d08d6e5fb8d27136e95/0/0/001713.jpg",
                        "https://previews.123rf.com/images/ogolne/ogolne1101/ogolne110100010/8559856--clarinete-en-una-hoja-de-notas-de-m%C3%BAsica.jpg",4));

        instrumentos.add(
                new Instrumentos(
                        21,
                        "Ukelele crusader 21",
                        "Cuerdas",
                        1500.00,
                        "N",
                        0,
                        "",
                        "https://eckomusic.com/media/catalog/product/cache/1/thumbnail/140x160/9df78eab33525d08d6e5fb8d27136e95/0/1/011295.jpg",
                        "http://www.hdfondos.eu/pictures/2013/0112/1/guitars-musical-instrument-strings-pics-170542.jpg",3));

        instrumentos.add(
                new Instrumentos(
                        22,
                        "Ukelele crusader 26",
                        "Cuerdas",
                        670.00,
                        "N",
                        0,
                        "",
                        "https://eckomusic.com/media/catalog/product/cache/1/thumbnail/140x160/9df78eab33525d08d6e5fb8d27136e95/0/1/011298.jpg",
                        "http://www.hdfondos.eu/pictures/2013/0112/1/guitars-musical-instrument-strings-pics-170542.jpg",2));



        CargarLista();


    }
}
