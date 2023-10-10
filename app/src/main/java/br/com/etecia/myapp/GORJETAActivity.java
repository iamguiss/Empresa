package br.com.etecia.myapp;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class GORJETAActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gorjetaactivity);

        Spinner spinner = (Spinner) findViewById(R.id.planets_spinner);
    }

}