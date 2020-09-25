package com.juborajsarker.spinnerassignment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.juborajsarker.spinnerassignment.adapter.CustomAdapter;
import com.juborajsarker.spinnerassignment.helper.BikeHelper;
import com.juborajsarker.spinnerassignment.helper.GridSpacingItemDecoration;
import com.juborajsarker.spinnerassignment.model.Bike;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    Spinner spBrand;
    Button btnSearchBike;
    TextView tvMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
    }

    private void init() {
        spBrand = (Spinner) findViewById(R.id.sp_brand);
        btnSearchBike = (Button) findViewById(R.id.btn_searchBike);

        tvMessage = (TextView) findViewById(R.id.tv_message);

        btnSearchBike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (spBrand.getSelectedItemPosition() == 0){
                    Toast.makeText(MainActivity.this, "Please select a valid bike brand", Toast.LENGTH_SHORT).show();
                }else {

                    String brand = spBrand.getSelectedItem().toString();
                    Intent intent = new Intent(MainActivity.this, DetailsActivity.class);
                    intent.putExtra("brand", brand);
                    startActivity(intent);

                }
            }
        });
    }
}