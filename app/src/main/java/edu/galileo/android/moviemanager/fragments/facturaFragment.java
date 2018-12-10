package edu.galileo.android.moviemanager.fragments;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import edu.galileo.android.moviemanager.R;
import edu.galileo.android.moviemanager.activities.MusicaDetailActivity;
import edu.galileo.android.moviemanager.adapters.InstrumentoRecyclerViewAdapterFact;
import edu.galileo.android.moviemanager.adapters.MovieRecyclerViewAdapter;
import edu.galileo.android.moviemanager.models.Instrumentos;

public class facturaFragment extends Fragment {


    /*

    @BindView(R.id.rvMovies)
    RecyclerView rvMovies;


    private MovieRecyclerViewAdapter adapter;
    // private List<Instrumentos> instrumentos;
    //public static ArrayList<Producto> imageInstrumentosArrayList2= new ArrayList<Producto>();


    public facturaFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_factura, container, false);
        ButterKnife.bind(this, view);
        //ProductoRepository.initializeData();
        LinearLayoutManager llm = new LinearLayoutManager(this.getContext());
        rvMovies.setHasFixedSize(true);
        rvMovies.setLayoutManager(llm);
        adapter = new MovieRecyclerViewAdapter(getContext(), MusicaDetailActivity.getListaCarrito());
        rvMovies.setAdapter(adapter);


        return view;
    }*/

    @BindView(R.id.rvJuegos)
    RecyclerView rvJuegos;
    @BindView(R.id.txtTotal)
    TextView txtTotal;
    @BindView(R.id.txtDesceuntos)
    TextView txtDesceuntos;
    @BindView(R.id.txtTotalPagar)
    TextView txtTotalPagar;
    @BindView(R.id.idNitems)
    TextView idNitems;


   /* @BindView(R.id.search)
    SearchView searchView;*/

    private MovieRecyclerViewAdapter adapter;
    // private List<Instrumentos> instrumentos;
    public static ArrayList<Instrumentos> imageInstrumentosArrayList2 = new ArrayList<Instrumentos>();

    /*public void CargarLista(){
        imageInstrumentosArrayList2.removeAll(imageInstrumentosArrayList2);
        for(Producto lista:ProductoRepository.getImageMovieArrayList()){
            if(lista.getOferta().contains("N")) {
                imageInstrumentosArrayList2.add(lista);
            }
        }
    }*/

    public facturaFragment() {
        // Required empty public constructor
    }

    // @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_factura, container, false);
        ButterKnife.bind(this, view);

        LinearLayoutManager llm = new LinearLayoutManager(this.getContext());
        rvJuegos.setHasFixedSize(true);
        rvJuegos.setLayoutManager(llm);

        InstrumentoRecyclerViewAdapterFact adapter = new InstrumentoRecyclerViewAdapterFact(this.getContext(), MusicaDetailActivity.getListaCarrito());
        rvJuegos.setAdapter(adapter);

        idNitems.setText(String.valueOf(MusicaDetailActivity.getListaCarrito().size()));
        txtTotal.setText(Obtener_SubTotal());
        txtDesceuntos.setText("- "+Obtener_TotalDescuestos());
        txtDesceuntos.setTextColor(Color.parseColor("#ff0000"));
        txtTotalPagar.setText(Obtener_TotalFactura());

        return view;
    }

    //Calcula la factura
    public String Obtener_TotalFactura() {
        DecimalFormat formateador = new DecimalFormat("####.##");
        String result = "";
        double total = 0.0;
        for (Instrumentos listaJuegos : MusicaDetailActivity.getListaCarrito()) {
            if (listaJuegos.getHayDescuento().contains("N")) {
                total = total + listaJuegos.getPrecio();
            } else {
                total = total + Double.parseDouble(listaJuegos.getValorDescuento());
            }
        }
        return result=(String.valueOf(total));
    }

    //Calcula la factura
    public String Obtener_TotalDescuestos() {
        String result = "";
        String results = "";
        double descuestos=0.0;
        DecimalFormat formateador = new DecimalFormat("###.##");
        try {

            for (Instrumentos listaJuegos : MusicaDetailActivity.getListaCarrito()) {
                if (listaJuegos.getHayDescuento().contains("S")) {
                    descuestos = descuestos + ( listaJuegos.getPrecio()-Double.parseDouble(listaJuegos.getValorDescuento()));

                }
            }
            result=String.valueOf(descuestos);
            descuestos = formateador.parse(result).doubleValue();
        } catch (ParseException e) {
            // Error. El usuario ha escrito algo que no se puede convertir
            // a número.
        }

        return results=String.valueOf(descuestos);
    }

    //Calcula la factura
    public String Obtener_SubTotal() {
        String result = "";
        double total = 0.0;
        String results = "";
        DecimalFormat formateador = new DecimalFormat("###.##");
        try {

            for (Instrumentos listaJuegos : MusicaDetailActivity.getListaCarrito()) {
                total = total + listaJuegos.getPrecio();
            }
            result=String.valueOf(total);
            total = formateador.parse(result).doubleValue();
        } catch (ParseException e) {
            // Error. El usuario ha escrito algo que no se puede convertir
            // a número.
        }

        return results=String.valueOf(total);
    }



}
