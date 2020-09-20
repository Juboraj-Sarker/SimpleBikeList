package com.juborajsarker.spinnerassignment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

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
    RecyclerView rvBikeList;
    TextView tvMessage;
    List<Bike> bikeList = new ArrayList<>();
    BikeHelper bikeHelper = new BikeHelper(this);
    CustomAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
    }

    private void init() {
        spBrand = (Spinner) findViewById(R.id.sp_brand);
        btnSearchBike = (Button) findViewById(R.id.btn_searchBike);
        rvBikeList = (RecyclerView) findViewById(R.id.rv_bike_list);
        tvMessage = (TextView) findViewById(R.id.tv_message);

        btnSearchBike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (spBrand.getSelectedItemPosition() == 0){
                    Toast.makeText(MainActivity.this, "Please select a valid bike brand", Toast.LENGTH_SHORT).show();
                }else {
                    bikeList.clear();
                    tvMessage.setVisibility(View.GONE);
                    String brand = spBrand.getSelectedItem().toString();
                    bikeList = bikeHelper.getBikeListWithBrand(brand);

                    adapter = new CustomAdapter(MainActivity.this, bikeList, rvBikeList);
                    RecyclerView.LayoutManager layoutManager = new GridLayoutManager(MainActivity.this, 1);
                    rvBikeList.setLayoutManager(layoutManager);
                    rvBikeList.addItemDecoration(new GridSpacingItemDecoration(1, 0, true));
                    rvBikeList.setItemAnimator(new DefaultItemAnimator());

                    rvBikeList.setAdapter(adapter);
                    adapter.notifyDataSetChanged();

                }
            }
        });
    }
}