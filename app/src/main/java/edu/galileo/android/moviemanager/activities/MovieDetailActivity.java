package edu.galileo.android.moviemanager.activities;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
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
import edu.galileo.android.moviemanager.models.Movie;

public class MovieDetailActivity extends AppCompatActivity {

    Movie movie;
    @BindView(R.id.ivMovieBackdrop)
    ImageView ivMovieBackdrop;
    @BindView(R.id.tvOverview)
    TextView tvOverview;
     static List<Movie> listaCarrito = new ArrayList<Movie>();

    public static List<Movie> getListaCarrito() {
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
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listaCarrito.add(movie);
                Context context = getApplicationContext();
                CharSequence text = "Instrumento fué agregado con éxito al carrito de compras!";
                int duration = Toast.LENGTH_SHORT;

                Toast toast = Toast.makeText(context, text, duration);
                toast.show();
               // Snackbar.make(view, "Instrumento fué agregado con éxito al carrito de compras", Snackbar.LENGTH_LONG)
                 //       .setAction("Action", null).show();
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            movie = (Movie) extras.getSerializable("MOVIE");
            this.setTitle(movie.getNombInstrumento());
            tvOverview.setText(movie.getCategoria());


            Picasso.with(this)
                    .load(movie.getUrl_Instrumento_poster())
                    .into(ivMovieBackdrop);

        }
    }
}
