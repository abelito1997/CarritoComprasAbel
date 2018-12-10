package edu.galileo.android.moviemanager.activities;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import edu.galileo.android.moviemanager.R;
import edu.galileo.android.moviemanager.models.Instrumentos;

public class MusicaDetailActivity extends AppCompatActivity {
Context context;
    Instrumentos instrumentos;
    @BindView(R.id.ivMovieBackdrop)
    ImageView ivMovieBackdrop;
    @BindView(R.id.tvOverview)
    TextView tvOverview;
    @BindView(R.id.imagenInstr)
    ImageView imageInstrumento;
     static List<Instrumentos> listaCarrito = new ArrayList<Instrumentos>();

    public static List<Instrumentos> getListaCarrito() {
        return listaCarrito;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detail);
        ButterKnife.bind(this);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        Bundle extras = getIntent().getExtras();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        if (extras != null) {
            instrumentos = (Instrumentos) extras.getSerializable("MOVIE");
            this.setTitle(instrumentos.getNombInstrumento());
            tvOverview.setText(instrumentos.getCategoria());


            ObtenerImagenes(context,imageInstrumento, instrumentos.getUrl_Instrumento_image());
            ObtenerImagenes(context,ivMovieBackdrop, instrumentos.getUrl_Instrumento_poster());

        }

        if( eliAddCarrito()){
            fab.setImageResource(R.mipmap.ic_launcher_delete);


        }else{
            fab.setImageResource(R.mipmap.ic_launcher_add);

        }

        fab.setOnClickListener(new View.OnClickListener() {
            Context context = getApplicationContext();
            int duration = Toast.LENGTH_SHORT;
            @Override
            public void onClick(View view) {


                if(eliAddCarrito()){

                    listaCarrito.remove(instrumentos);
                    CharSequence text = "Instrumento fué Removido del carrito de compras!";

                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                   // MiCarrito_fragment fragment = new MiCarrito_fragment();
                    //FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                    //ft.replace(R.id.fab,  fragment, "fragment_meters");
                    //ft.addToBackStack(null);
                    //ft.commit();



                }else{
                    listaCarrito.add(instrumentos);
                    CharSequence text = "Instrumento fué agregado con éxito al carrito de compras!";
                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                }
               // listaCarrito.add(instrumentos);
                //Context context = getApplicationContext();
                //CharSequence text = "Instrumento fué agregado con éxito al carrito de compras!";
                //int duration = Toast.LENGTH_SHORT;

               // Toast toast = Toast.makeText(context, text, duration);
                //toast.show();

                    // listaCarrito.add(producto);
                /*Snackbar.make(view, "Juego agrgado al carrito de compras", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                    if(listaCarrito.isEmpty()){
                        listaCarrito.add(instrumentos);
                        Snackbar.make(view, "Instrumento agregado al carrito de compras", Snackbar.LENGTH_LONG).setAction("Action", null).show();
                    }else{
                        for(Instrumentos miCarrito: MusicaDetailActivity.getListaCarrito()){
                            if(miCarrito.getNombInstrumento().equalsIgnoreCase(instrumentos.getNombInstrumento())){
                                listaCarrito.remove(miCarrito);
                                Snackbar.make(view, "Instrumento Eliminado del carrito de compras", Snackbar.LENGTH_LONG)
                                        .setAction("Action", null).show();
                            }else{
                                listaCarrito.add(miCarrito);
                                Snackbar.make(view, "Instrumento agregado al carrito de compras", Snackbar.LENGTH_LONG)
                                        .setAction("Action", null).show();

                            }

                        }
                    }*/


                }
               // Snackbar.make(view, "Instrumento fué agregado con éxito al carrito de compras", Snackbar.LENGTH_LONG)
                 //       .setAction("Action", null).show();
            }
        );
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

         extras = getIntent().getExtras();
        if (extras != null) {
            instrumentos = (Instrumentos) extras.getSerializable("MOVIE");
            this.setTitle(instrumentos.getNombInstrumento());
            tvOverview.setText(instrumentos.getCategoria());


            ObtenerImagenes(context,imageInstrumento, instrumentos.getUrl_Instrumento_image());
            ObtenerImagenes(context,ivMovieBackdrop, instrumentos.getUrl_Instrumento_poster());

        }
    }





    public boolean eliAddCarrito(){

        for(Instrumentos listaCar: listaCarrito){

            if(listaCar.getId()==(instrumentos.getId())){
                return true;

            }
        }
        return false;

    }



    public void ObtenerImagenes(Context contex,ImageView ivPoster,String recurso){
        if (recurso.isEmpty()) { //url.isEmpty()
            Picasso.with(context)
                    .load(R.drawable.notfound)
                    .placeholder(R.drawable.notfound)
                    .error(R.drawable.notfound)
                    .into(ivPoster);

        }else{
            Picasso.with(context)
                    .load(recurso)
                    .error(R.drawable.load)
                    .placeholder(R.drawable.load)
                    .into(ivPoster); //this is your ImageView
        }

    }

    private void showFragment(Class fragmentClass) {

        Fragment fragment = null;

        try {
            fragment = (Fragment) fragmentClass.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.flContent, fragment)
                .commit();

    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return false;
    }

}
