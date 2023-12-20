package com.example.goquiz;

import java.io.Serializable;
import java.util.List;

public class QuestionClass implements Serializable {
    private int stt;
    private String category;
    private String questionText;
    private List<String> answerOptions;
    private int correctAnswerIndex;
    private int difficultyLevel;

    public QuestionClass(int stt, String category, String questionText, List<String> answerOptions, int correctAnswerIndex, int difficultyLevel) {
        this.stt = stt;
        this.questionText = questionText;
        this.answerOptions = answerOptions;
        this.correctAnswerIndex = correctAnswerIndex;
        this.difficultyLevel = difficultyLevel;
        this.category = category;
    }
    public int getStt(){
        return stt;
    }
    public String getQuestionText() {
        return questionText;
    }

    public List<String> getAnswerOptions() {
        return answerOptions;
    }

    public int getCorrectAnswerIndex() {
        return correctAnswerIndex;
    }

    public int getDifficultyLevel() {
        return difficultyLevel;
    }

    public String getCategory() {
        return category;
    }
}

