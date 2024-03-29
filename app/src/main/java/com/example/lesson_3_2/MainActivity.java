package com.example.lesson_3_2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.lesson_3_2.Fragment.FirstFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.fragment_container_view, new FirstFragment())
                .commit();

    }
}