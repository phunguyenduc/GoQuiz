package com.example.goquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.goquiz.databinding.ActivityCategoriesBinding;

import java.util.ArrayList;

public class Categories extends AppCompatActivity {

    private ActivityCategoriesBinding binding;
    private ArrayList<CategoriesClass> categories;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCategoriesBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        ListView categoriesListView = findViewById(R.id.CategoriesListView);

        categories = new ArrayList<>();
        categories.add(new CategoriesClass("Địa lý", R.drawable.mongolia, "dia ly thoi"));
        categories.add(new CategoriesClass("Lịch sử", R.drawable.mongolia, "đưaăd"));
        categories.add(new CategoriesClass("Công nghệ", R.drawable.mongolia, "kahsod hco"));
        categories.add(new CategoriesClass("Sinh học", R.drawable.mongolia, "contrydsaide"));
        categories.add(new CategoriesClass("Thiên văn học", R.drawable.mongolia, "abc"));

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
        binding.QuestionsButton.setOnClickListener(v -> {
            Intent intent = new Intent(Categories.this, Questions.class);
            startActivity(intent);
        });
    }
}