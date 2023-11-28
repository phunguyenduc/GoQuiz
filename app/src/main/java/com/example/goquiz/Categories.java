package com.example.goquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class Categories extends AppCompatActivity {
    private ArrayList<CategoriesClass> categories;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categories);

        ListView categoriesListView = findViewById(R.id.CategoriesListView);

        categories = new ArrayList<>();
        categories.add(new CategoriesClass("Địa lý", R.drawable.mongolia, "dia ly thoi"));
        categories.add(new CategoriesClass("Lịch sử", R.drawable.mongolia, "đưaăd"));
        categories.add(new CategoriesClass("Khoa học", R.drawable.mongolia, "kahsod hco"));
        categories.add(new CategoriesClass("Nghệ thuật", R.drawable.mongolia, "contrydsaide"));

        CategoriesAdapter adapter = new CategoriesAdapter(this, categories);
        categoriesListView.setAdapter(adapter);

        categoriesListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                CategoriesClass selected = categories.get(position);
                /*
                Intent intent = new Intent(this, AttractionDetailActivity.class);
                intent.putExtra("attraction", selected);
                startActivity(intent);*/
            }
        });
    }
}