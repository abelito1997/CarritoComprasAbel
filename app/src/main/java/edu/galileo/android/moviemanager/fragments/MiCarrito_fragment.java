package edu.galileo.android.moviemanager.fragments;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
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
import edu.galileo.android.moviemanager.activities.InstrumentoDetailActivity;
import edu.galileo.android.moviemanager.activities.MusicaDetailActivity;
import edu.galileo.android.moviemanager.adapters.MovieRecyclerViewAdapter;
import edu.galileo.android.moviemanager.models.Instrumentos;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the

 * to handle interaction events.

 * create an instance of this fragment.
 */
public class MiCarrito_fragment extends Fragment {

    @BindView(R.id.rvMovies)
    RecyclerView rvCarrito;
    private List<Instrumentos> instrumentos;
    @BindView(R.id.my_fabdolar)
    FloatingActionButton my_fab;

    public MiCarrito_fragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_mi_carrito_fragment, container, false);

        ButterKnife.bind(this, view);

        //carga los datos
        initializeData();

        if(verificarListaVacia()){
            my_fab.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.background_black)));
            my_fab.setImageResource(R.drawable.ic_print);
            // definimos el color
            int color = Color.parseColor("#333333");

// instanciamos el drawable
            Drawable icon = ContextCompat.getDrawable(getContext(),R.drawable.ic_print);

// definimos filtro
            icon.mutate().setColorFilter(color, PorterDuff.Mode.SRC_ATOP);
        }else{
            my_fab.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorAma)));
            my_fab.setImageResource(R.drawable.ic_print);

        }

        LinearLayoutManager llm = new LinearLayoutManager(this.getContext());
        rvCarrito.setHasFixedSize(true);
        rvCarrito.setLayoutManager(llm);

        MovieRecyclerViewAdapter adapter = new MovieRecyclerViewAdapter(this.getContext(), instrumentos);
        rvCarrito.setAdapter(adapter);

        //Botón flotante
        my_fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(MusicaDetailActivity.getListaCarrito().isEmpty()){
                  //  my_fab.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.background_black)));
                //    my_fab.setImageResource(R.drawable.ic_print);
                    Snackbar.make(view, "No existe articulos agregado a su carrito",
                            Snackbar.LENGTH_LONG).setAction("Action", null).show();

                }else{
                    /*Snackbar.make(view, "Factura: "+Obtener_factura(),
                            Snackbar.LENGTH_LONG).setAction("Action", null).show();*/
                    my_fab.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorAma)));
                    Intent intent = new Intent(getContext(), InstrumentoDetailActivity.class);
                    getContext().startActivity(intent);


                }
            }
        });
        return view;
    }

    @Override
    public void onResume() {

        super.onResume();
        this.onCreate(null);
    }

    //verificarListaCompra
    public boolean verificarListaVacia(){
        if(MusicaDetailActivity.getListaCarrito().isEmpty()){
            return true;
        }
        return false;
    }

    private void initializeData() {
        instrumentos = new ArrayList<>();
        for(Instrumentos listaJuegos: MusicaDetailActivity.getListaCarrito()){

            instrumentos.add(listaJuegos);
        }
       /*instrumentos.add(new Instrumentos("277834", "Rings", "Julia (Matilda Lutz) becomes worried about her boyfriend, Holt (Alex Roe) when he explores the dark urban legend of a mysterious videotape said to kill the watcher seven days after viewing. She sacrifices herself to save her boyfriend and in doing so makes a horrifying discovery: there is a \\\"movie within the movie\\\" that no one has ever seen before.", 0f, 0, "/uwNNLJULvTQfgc3PBZAY92EOJQO.jpg", "/91WPDonXsxRzi7AcfedKM3p3NFU.jpg"));
        instrumentos.add(new Instrumentos("121856", "The Great Wall", "The story of an elite force making a last stand for humanity on the world’s most iconic structure.", 0f, 0, "/hm0Z5tpRlSzPO97U5e2Q32Y0Xrb.jpg", "/yESCAoZkaxZ2AMiHojl9jYYd9zD.jpg"));
        instrumentos.add(new Instrumentos("330459", "Patriots Day", "An account of Boston Police Commissioner Ed Davis's actions in the events leading up to the 2013 Boston Marathon bombing and the aftermath, which includes the city-wide manhunt to find the terrorists behind it.", 0f, 0, "/gd4SDPZIdVRAxUolQ9ZCNXTkQUq.jpg", "/tiBL4PeaCPKGBz3qO4dJP2KzKop.jpg"));
        instrumentos.add(new Instrumentos("283366", "T2 Trainspotting", "First there was an opportunity......then there was a betrayal. Twenty years have gone by. Much has changed but just as much remains the same. ", 0f, 0, "/A84pxL5z86KbV9u8GAK2mVOoXK.jpg", "/dxJynNxoG6jRttYPoXOGx7OWJvq.jpg"));
*/
    }


}
