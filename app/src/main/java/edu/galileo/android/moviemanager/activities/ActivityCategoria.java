package edu.galileo.android.moviemanager.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import butterknife.BindView;
import edu.galileo.android.moviemanager.R;

public class ActivityCategoria extends AppCompatActivity {

    @BindView(R.id.imageV)
    ImageView vient;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cate);
    }

    public void llamar(View view){

    }
}
