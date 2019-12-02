package ru.gubayaa.traininghelper;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    final String LOG_TAG = "myLogs";

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void clickStart(View clickableView) {
        Intent goHome = new Intent(MainActivity.this, HomeActivityView.class);
        startActivity(goHome);
    }
}
