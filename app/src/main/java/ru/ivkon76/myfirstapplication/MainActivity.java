package ru.ivkon76.myfirstapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    private BeerExpert expert = new BeerExpert();

    public void onClickFindBeer(View view){

        TextView brands = (TextView) findViewById(R.id.brands);
        Spinner color = (Spinner) findViewById(R.id.color);
        String color_string = String.valueOf(color.getSelectedItem());
        List<String> brandsList = expert.getBrands(color_string);
        StringBuilder brandsFormatted = new StringBuilder();
        for (String brand: brandsList){
            brandsFormatted.append(brand).append('\n');
        }
        brands.setText(brandsFormatted);
    }
}