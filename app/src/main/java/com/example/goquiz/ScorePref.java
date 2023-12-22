package com.example.goquiz;

import android.content.Context;
import android.content.SharedPreferences;

public class ScorePref {
    public static int saveScore(Context context) {
        SharedPreferences saveScore = context.getSharedPreferences("Score", Context.MODE_PRIVATE);
        return saveScore.getInt("score",0);
    }

    public static void updateScore(Context context, int score1play) {
        int diemSoHienTai = saveScore(context);
        diemSoHienTai += score1play;

        SharedPreferences.Editor editor = context.getSharedPreferences("Score", Context.MODE_PRIVATE).edit();
        editor.putInt("score", diemSoHienTai);
        editor.apply();
    }
}
