package edu.galileo.android.moviemanager.adapters;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import edu.galileo.android.moviemanager.R;
import edu.galileo.android.moviemanager.models.Instrumentos;

public class InstrumentoRecyclerViewAdapterFact extends RecyclerView.Adapter<InstrumentoRecyclerViewAdapterFact.ViewHolder> {


    List<Instrumentos> productos;
    Context context;
    //Array para el filtro
   /* public static ArrayList<Producto> imageModelArrayList= new ArrayList<Producto>();
    private ArrayList<Producto> arraylist;*/



    public InstrumentoRecyclerViewAdapterFact(Context context, List<Instrumentos> instrumentos){
        this.productos = instrumentos;
        this.context = context;

    }

    private Context getContext(){
        return context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_games_fact, parent, false);

        return new ViewHolder(v);
    }



    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        Instrumentos producto = productos.get(position);
        holder.txtTitulo.setText(producto.getNombInstrumento());
        if(producto.getHayDescuento().contains("S")){
            //Normal
            holder.txtPrecio.setText(String.valueOf(((Instrumentos) producto).getPorcDescuento()));
            holder.txtPrecio.setTextColor(Color.parseColor("#ff0000"));
            //Tachado
            holder.textPrecioDescuento.setPaintFlags(holder.textPrecioDescuento.getPaintFlags()|Paint.STRIKE_THRU_TEXT_FLAG);

            //descuesto
            holder.textViewPrice_s2.setText("$");
            holder.textViewPrice_s2.setTextColor(Color.parseColor("#c0c0c0"));
            holder.textPrecioDescuento.setText(String.valueOf(producto.getPrecio()));
            holder.textPrecioDescuento.setTextColor(Color.parseColor("#c0c0c0"));
            //holder.txtPrecio.setTextColor(Color.parseColor("#ff0000"));

        }else{
            holder.txtPrecio.setText(String.valueOf(producto.getPrecio()));
        }

        ObtenerImagenes(producto,holder);


    }



    //Obtener Imagenes
    public void ObtenerImagenes(Instrumentos producto, ViewHolder holder){
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

    }


    @Override
    public int getItemCount() {
        return productos.size();
    }

    public  class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.ivImagenJuego)
        ImageView imPortada;
        @BindView(R.id.textNombreJuego)
        TextView txtTitulo;
        @BindView(R.id.textViewPrices)
        TextView txtPrecio;
        @BindView(R.id.cvGamesFact)
        CardView cvFactura;
        @BindView(R.id.textPrecioDescuentos)
        TextView textPrecioDescuento;
        @BindView(R.id.textViewPrice_ss2)
        TextView textViewPrice_s2;

        ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
            //view.setOnClickListener(this);

        }

       /* @Override
        public void onClick(View v) {

            Producto movie = productos.get(getAdapterPosition());

            Intent intent = new Intent(getContext(), MusicaDetailActivity.class);
            intent.putExtra("MOVIE", movie);
            getContext().startActivity(intent);

        }*/
    }


}
