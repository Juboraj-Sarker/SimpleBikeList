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

import com.juborajsarker.spinnerassignment.adapter.CustomAdapter;
import com.juborajsarker.spinnerassignment.helper.BikeHelper;
import com.juborajsarker.spinnerassignment.helper.GridSpacingItemDecoration;
import com.juborajsarker.spinnerassignment.model.Bike;

import java.util.ArrayList;
import java.util.List;

public class DetailsActivity extends AppCompatActivity {

    String brand = "";
    RecyclerView rvBikeList;
    List<Bike> bikeList = new ArrayList<>();
    BikeHelper bikeHelper = new BikeHelper(this);
    CustomAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        brand = getIntent().getStringExtra("brand");

        init(brand);
    }

    private void init(String brand) {
        rvBikeList = (RecyclerView) findViewById(R.id.rv_bike_list);

        bikeList.clear();

        bikeList = bikeHelper.getBikeListWithBrand(brand);

        adapter = new CustomAdapter(DetailsActivity.this, bikeList, rvBikeList);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(DetailsActivity.this, 1);
        rvBikeList.setLayoutManager(layoutManager);
        rvBikeList.addItemDecoration(new GridSpacingItemDecoration(1, 0, true));
        rvBikeList.setItemAnimator(new DefaultItemAnimator());

        rvBikeList.setAdapter(adapter);
        adapter.notifyDataSetChanged();

    }
}