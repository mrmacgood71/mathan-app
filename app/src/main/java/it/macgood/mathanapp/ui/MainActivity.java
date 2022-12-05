package it.macgood.mathanapp.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import it.macgood.mathanapp.R;
import it.macgood.mathanapp.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);

        BottomNavigationView bottomBar = binding.bottomNavigationBar;
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_guidebook, R.id.navigation_handbook)
                .build();

        MenuItem item = bottomBar.getMenu().findItem(R.id.navigation_guidebook);

        if (item != null) Log.d("!NULL_TAG", "onCreate: ");

        NavController navController = Navigation.findNavController(this, R.id.app_placeholder);
        NavigationUI.setupWithNavController(bottomBar, navController);

        
    }
}