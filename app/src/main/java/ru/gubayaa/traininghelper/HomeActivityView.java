package ru.gubayaa.traininghelper;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

public class HomeActivityView extends AppCompatActivity {

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        FragmentTransaction fragTrans = getSupportFragmentManager().beginTransaction();
        fragTrans.replace(R.id.frameHome, new FragmentHome());
        fragTrans.commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        FragmentTransaction fragTrans = getSupportFragmentManager().beginTransaction();

        switch (menuItem.getItemId()) {
            case R.id.itemHome:
                fragTrans.replace(R.id.frameHome, new FragmentHome());
                fragTrans.commit();
                break;
        }

        return super.onOptionsItemSelected(menuItem);
    }

    public void onclickCalc(View v) {
        FragmentTransaction fragTrans = getSupportFragmentManager().beginTransaction();
        fragTrans.replace(R.id.frameHome, new FragmentCalcView());
        fragTrans.commit();
    }

    public void onclickHistory(View v) {
        FragmentTransaction fragTrans = getSupportFragmentManager().beginTransaction();
        fragTrans.replace(R.id.frameHome, new FragmentHistory());
        fragTrans.commit();
    }
}
