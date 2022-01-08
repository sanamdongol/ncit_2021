package com.ncit.navigationdraer;

import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.navigation.NavigationView;
import com.ncit.fragments.SettingsFragment;
import com.ncit.projectb.R;

public class NavigationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation);
        NavigationView navigationView = findViewById(R.id.nav_drawer);
        DrawerLayout drawerLayout = findViewById(R.id.drawer);
        View view = navigationView.getHeaderView(0);

        TextView title = view.findViewById(R.id.textView13);
        title.setText("ABCD");

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                if (id == R.id.item1) {
                    FragmentManager manager = getSupportFragmentManager();
                    FragmentTransaction transaction = manager.beginTransaction()
                            .setCustomAnimations(R.anim.fade_in, R.anim.zoom_out);
                    transaction.replace(R.id.fragment_container, new SettingsFragment());

                    transaction.addToBackStack("randome");
                    transaction.commit();
                    drawerLayout.closeDrawer(Gravity.LEFT);

                } else if (id == R.id.item9) {
                    Toast.makeText(NavigationActivity.this, "Hello Item 90", Toast.LENGTH_SHORT).show();
                }
                return false;
            }
        });
    }
}