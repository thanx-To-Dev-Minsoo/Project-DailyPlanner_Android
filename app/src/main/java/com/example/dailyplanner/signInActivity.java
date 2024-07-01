package com.example.dailyplanner;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class signInActivity extends AppCompatActivity {
    TextView sign;  // Corrected typo here
    Button loginButton;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {  // Changed to onCreate
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);

        // 회원가입 버튼
        sign = findViewById(R.id.signin);

        // 회원가입 버튼 클릭시, 회원가입 페이지로 이동
        sign.setOnClickListener(v -> {
            Intent intent = new Intent(this, signUpActivity.class);
            startActivity(intent);
        });

        // 로그인 버튼
        loginButton = findViewById(R.id.loginbutton);
        loginButton.setOnClickListener(v -> {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        });
    }
}