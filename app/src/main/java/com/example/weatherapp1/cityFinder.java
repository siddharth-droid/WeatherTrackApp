package com.example.weatherapp1;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class cityFinder extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_city_finder);
        final EditText editText = findViewById(R.id.searchcity);
        ImageView backbutton = findViewById(R.id.backbutton);

        backbutton.setOnClickListener(v -> finish());

        editText.setOnEditorActionListener((v, actionId, event) -> {
            String newCity = editText.getText().toString();
            Intent intent = new Intent(cityFinder.this,MainActivity.class);
            intent.putExtra("City", newCity);
            startActivity(intent);
            return false;
        });
    }
}