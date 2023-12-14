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

        categories = new ArrayList<>();
        categories.add(new CategoriesClass("Toán học", R.drawable.math, "Các câu hỏi xoay quanh số học, hình học và giải tích"));
        categories.add(new CategoriesClass("Vật lý", R.drawable.physics, "Các câu hỏi về chuyển động, ánh sáng, và các lực tương tác"));
        categories.add(new CategoriesClass("Hóa học", R.drawable.chemistry, "Các câu hỏi xoay quanh cấu trúc của chất và các phản ứng hóa học"));
        categories.add(new CategoriesClass("Sinh học", R.drawable.biology, "Các câu hỏi về cấu trúc và chức năng của các hệ sinh thái và hệ cơ thể"));
        categories.add(new CategoriesClass("Lịch sử", R.drawable.history, "Các câu hỏi về sự phát triển của con người và các sự kiện lịch sử quan trọng"));
        categories.add(new CategoriesClass("Địa lý", R.drawable.geography,"Các câu hỏi xoay quanh địa hình, khí hậu, và dân cư các khu vực"));
        categories.add(new CategoriesClass("Công nghệ", R.drawable.technology,"Các câu hỏi về ứng dụng kiến thức khoa học để giải quyết vấn đề thực tế"));
        categories.add(new CategoriesClass("Thiên văn học", R.drawable.astronomy,"Các câu hỏi xoay quanh vật thể ngoài trái đất và cấu trúc của vũ trụ"));

        CategoriesAdapter adapter = new CategoriesAdapter(this, categories);
        //ListView categoriesListView = findViewById(R.id.CategoriesListView);
        binding.CategoriesListView.setAdapter(adapter);

        binding.CategoriesListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                CategoriesClass selected = categories.get(position);

                Intent intent = new Intent(Categories.this, Ingame.class);
                startActivity(intent);
            }
        });
        binding.QuestionsButton.setOnClickListener(v -> {
            Intent intent = new Intent(Categories.this, Questions.class);
            startActivity(intent);
        });
    }
}