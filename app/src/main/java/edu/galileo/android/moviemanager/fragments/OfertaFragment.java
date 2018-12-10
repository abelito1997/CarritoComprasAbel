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
import edu.galileo.android.moviemanager.models.Instrumentos;

/**
 * A simple {@link Fragment} subclass.
 */
public class OfertaFragment extends Fragment {

    @BindView(R.id.rvMovies)
    RecyclerView rvMovies;
    private List<Instrumentos> instrumentos;


    public OfertaFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_upcoming, container, false);

        ButterKnife.bind(this, view);

        initializeData();

        LinearLayoutManager llm = new LinearLayoutManager(this.getContext());
        rvMovies.setHasFixedSize(true);
        rvMovies.setLayoutManager(llm);

        MovieRecyclerViewAdapter adapter = new MovieRecyclerViewAdapter(this.getContext(), instrumentos);
        rvMovies.setAdapter(adapter);

        return view;
    }


    private void initializeData() {
        instrumentos = new ArrayList<>();
        instrumentos.removeAll(instrumentos);
        for(Instrumentos listaJuegos: ContenidoGeneralFragment.getInstrumentos()){
            if(listaJuegos.getHayDescuento().contains("S")){
                listaJuegos.setValorDescuento(String.valueOf(listaJuegos.getPrecio()-(listaJuegos.getPrecio()*listaJuegos.getPorcDescuento()/100)));
                listaJuegos.setPorcDescuento(listaJuegos.getPorcDescuento()/100);
                instrumentos.add(listaJuegos);
            }

        }
       /*instrumentos.add(new Instrumentos("277834", "Rings", "Julia (Matilda Lutz) becomes worried about her boyfriend, Holt (Alex Roe) when he explores the dark urban legend of a mysterious videotape said to kill the watcher seven days after viewing. She sacrifices herself to save her boyfriend and in doing so makes a horrifying discovery: there is a \\\"movie within the movie\\\" that no one has ever seen before.", 0f, 0, "/uwNNLJULvTQfgc3PBZAY92EOJQO.jpg", "/91WPDonXsxRzi7AcfedKM3p3NFU.jpg"));
        instrumentos.add(new Instrumentos("121856", "The Great Wall", "The story of an elite force making a last stand for humanity on the world’s most iconic structure.", 0f, 0, "/hm0Z5tpRlSzPO97U5e2Q32Y0Xrb.jpg", "/yESCAoZkaxZ2AMiHojl9jYYd9zD.jpg"));
        instrumentos.add(new Instrumentos("330459", "Patriots Day", "An account of Boston Police Commissioner Ed Davis's actions in the events leading up to the 2013 Boston Marathon bombing and the aftermath, which includes the city-wide manhunt to find the terrorists behind it.", 0f, 0, "/gd4SDPZIdVRAxUolQ9ZCNXTkQUq.jpg", "/tiBL4PeaCPKGBz3qO4dJP2KzKop.jpg"));
        instrumentos.add(new Instrumentos("283366", "T2 Trainspotting", "First there was an opportunity......then there was a betrayal. Twenty years have gone by. Much has changed but just as much remains the same. ", 0f, 0, "/A84pxL5z86KbV9u8GAK2mVOoXK.jpg", "/dxJynNxoG6jRttYPoXOGx7OWJvq.jpg"));
*/
    }

}
