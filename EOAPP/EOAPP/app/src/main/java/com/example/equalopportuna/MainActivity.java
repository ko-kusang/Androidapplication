package com.example.equalopportuna;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.Navigation;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.SearchView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import org.w3c.dom.Text;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private SearchView searchView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_nav_view);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                if (item.getItemId() == R.id.home_icon) {
                    // Navigate to AboutAppFragment using Navigation Component
                    Navigation.findNavController(MainActivity.this, R.id.NHFMain)
                            .navigate(R.id.mainPageFragment);
                    return true;
                }
                if (item.getItemId() == R.id.jobs_icon) {
                    // Navigate to AboutAppFragment using Navigation Component
                    Navigation.findNavController(MainActivity.this, R.id.NHFMain)
                            .navigate(R.id.jobOpeningsFragment);
                    return true;
                }
                if (item.getItemId() == R.id.stories_icon) {
                    // Navigate to AboutAppFragment using Navigation Component
                    Navigation.findNavController(MainActivity.this, R.id.NHFMain)
                            .navigate(R.id.storiesForumFragment);
                    return true;
                }
                if (item.getItemId() == R.id.courses_icon) {
                    // Navigate to AboutAppFragment using Navigation Component
                    Navigation.findNavController(MainActivity.this, R.id.NHFMain)
                            .navigate(R.id.courseListingFragment);
                    return true;
                }

                return false;
            }
        });
    }


}
