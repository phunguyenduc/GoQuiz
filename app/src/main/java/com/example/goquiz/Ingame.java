package com.example.goquiz;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.goquiz.databinding.ActivityIngameBinding;

public class Ingame extends AppCompatActivity {
    private ActivityIngameBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityIngameBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);


    }
}