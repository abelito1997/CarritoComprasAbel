package edu.galileo.android.moviemanager.adapters;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import edu.galileo.android.moviemanager.R;
import edu.galileo.android.moviemanager.activities.MusicaDetailActivity;
import edu.galileo.android.moviemanager.models.Instrumentos;

/**
 * Created by isabelpalomar.
 */

public class MovieRecyclerViewAdapter extends RecyclerView.Adapter<MovieRecyclerViewAdapter.ViewHolder> {

    List<Instrumentos> instrumentos;
    Context context;

    public MovieRecyclerViewAdapter(Context context, List<Instrumentos> instrumentos){
        this.instrumentos = instrumentos;
        this.context = context;

    }

    private Context getContext(){
        return context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_movie, parent, false);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        Instrumentos producto = instrumentos.get(position);
        holder.txtTitulo.setText(producto.getNombInstrumento());
        holder.txtDescripcion.setText(producto.getCategoria());
        holder.estrellas.setRating((float)producto.getRating());
        if(producto.getHayDescuento().contains("S")){
            /*holder.textOferta.setText("OFERTA");
            holder.textViewPrice_s2.setText("$");
            holder.txtPrecio.setText(String.valueOf(producto.getValorDescuento()));
            holder.textPrecioDescuento.setText(String.valueOf(producto.getPrecio()));
            holder.textViewPrice_s2.setTextColor(Color.parseColor("#c0c0c0"));
            holder.textPrecioDescuento.setTextColor(Color.parseColor("#c0c0c0"));
            holder.txtPrecio.setTextColor(Color.parseColor("#ff0000"));
            holder.txtPrecio.setTextColor(Color.parseColor("#ff0000"));*/

            holder.textOferta.setText("OFERTA");
            //Normal
            holder.txtPrecio.setText(String.valueOf(producto.getValorDescuento()));
           // holder.txtPrecio.setTextColor(Color.parseColor("#ff0000"));
            //Tachado
            holder.textPrecioDescuento.setPaintFlags(holder.textPrecioDescuento.getPaintFlags()|Paint.STRIKE_THRU_TEXT_FLAG);

            //descuesto
            holder.textViewPrice_s2.setText("$");
            holder.textViewPrice_s2.setTextColor(Color.parseColor("#c0c0c0"));
            holder.textPrecioDescuento.setText(String.valueOf(producto.getPrecio()));
           // holder.textPrecioDescuento.setTextColor(Color.parseColor("#c0c0c0"));
            //holder.txtPrecio.setTextColor(Color.parseColor("#ff0000"));


        }else{
            holder.txtPrecio.setText(String.valueOf(producto.getPrecio()));
        }

        if (producto.getUrl_Instrumento_image().isEmpty()) { //url.isEmpty()
            Picasso.with(context)
                    .load(R.drawable.notfound)
                    .placeholder(R.drawable.notfound)
                    .error(R.drawable.notfound)
                    .into(holder.imPortada);

        }else{
            Picasso.with(context)
                    .load(producto.getUrl_Instrumento_image())
                    .error(R.drawable.load)
                    .placeholder(R.drawable.load)
                    .into(holder.imPortada); //this is your ImageView
        }
/*
        holder.tvTitle.setText(movie.getNombInstrumento());
        holder.tvOverview.setText(movie.getCategoria());

        Picasso.with(getContext())
                //.load(movie.getUrl_Instrumento_image())
                //.into(holder.ivMovieImage);*/

    }

    @Override
    public int getItemCount() {
        return instrumentos.size();
    }

    public  class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
       /* @BindView(R.id.ivMovieImage)
        ImageView ivMovieImage;
        @BindView(R.id.tvTitle)
        TextView tvTitle;
        @BindView(R.id.tvOverview)
        TextView tvOverview;
        @BindView(R.id.cvMovie)
        CardView cvMovie;*/
       @BindView(R.id.ivMovieImage)
       ImageView imPortada;
        @BindView(R.id.textViewTitle)
        TextView txtTitulo;
        @BindView(R.id.textViewShortDesc)
        TextView txtDescripcion;
        @BindView(R.id.textViewPrice)
        TextView txtPrecio;
        @BindView(R.id.cvMovie)
        CardView cvMovie;
        @BindView(R.id.textPrecioDescuento)
        TextView textPrecioDescuento;
        @BindView(R.id.textOferta)
        TextView textOferta;
        @BindView(R.id.textViewPrice_s2)
        TextView textViewPrice_s2;
        @BindView(R.id.myRatingBar)
        RatingBar estrellas;





        ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
            view.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {

            Instrumentos instrumentos = MovieRecyclerViewAdapter.this.instrumentos.get(getAdapterPosition());

            Intent intent = new Intent(getContext(), MusicaDetailActivity.class);
            intent.putExtra("MOVIE", instrumentos);
            getContext().startActivity(intent);

        }
    }
}
