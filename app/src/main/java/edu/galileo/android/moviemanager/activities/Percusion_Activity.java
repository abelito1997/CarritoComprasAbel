package edu.galileo.android.moviemanager.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import edu.galileo.android.moviemanager.R;

public class Percusion_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_percusion_);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return false;
    }
}
