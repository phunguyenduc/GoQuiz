package com.example.goquiz;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.goquiz.databinding.ActivityIngameBinding;

import java.util.ArrayList;

public class Ingame extends AppCompatActivity {
    private ActivityIngameBinding binding;
    private ArrayList<Question> filteredQuestions;

    private int questionIndex = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityIngameBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        Intent intent = getIntent();
        String category = intent.getStringExtra("category");
        int level = intent.getIntExtra("level",0);

        QuestionList.questionList();
        // Hàm để lấy danh sách câu hỏi dựa trên chủ đề và độ khó
        filteredQuestions = getQuestionsByCategoryAndDifficulty(category, level);
        displayQuestion();
    }
    private ArrayList<Question> getQuestionsByCategoryAndDifficulty(String category, int level){
        ArrayList<Question> filteredQuestions = new ArrayList<>();
        for (Question ques : QuestionList.questionList){
            if(ques.getCategory().equals(category) && ques.getDifficultyLevel() == level){
                filteredQuestions.add(ques);
            }
        }
        return filteredQuestions;
    }
    private void displayQuestion(){
        if(questionIndex < filteredQuestions.size()){
            Question currentQuestion = filteredQuestions.get(questionIndex);
            // Hiển thị câu hỏi và các tùy chọn
            binding.Question.setText(currentQuestion.getQuestionText());
            binding.AnswerA.setText(currentQuestion.getAnswerOptions().get(0));
            binding.AnswerB.setText(currentQuestion.getAnswerOptions().get(1));
            binding.AnswerC.setText(currentQuestion.getAnswerOptions().get(2));
            binding.AnswerD.setText(currentQuestion.getAnswerOptions().get(3));

            // Sự kiện cho nút trả lời
            binding.AnswerButton.setOnClickListener(v -> {
                // Xử lý khi người dùng trả lời
                handleAnswer(currentQuestion);
            });
        }else{
            // Hết câu hỏi
            finish();
        }
    }
    // Hàm xử lý câu trả lời của người chơi
    private void handleAnswer(Question currentQuestion){
        questionIndex++;
        displayQuestion();
    }
}