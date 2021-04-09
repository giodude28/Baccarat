package io.giodude.baccaratnhcaobil;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

import io.giodude.baccaratnhcaobil.View.HomeView;
import io.giodude.baccaratnhcaobil.View.RulesView;
import io.giodude.baccaratnhcaobil.View.SystemView;
import io.giodude.baccaratnhcaobil.View.TipsView;
import io.giodude.baccaratnhcaobil.View.VariationView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    boolean doubleBackToExitPressedOnce = false;
    DrawerLayout drawerLayout;
    ActionBarDrawerToggle actionBar;
    androidx.appcompat.widget.Toolbar toolbar;
    NavigationView navigationView;
    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MainActivity.this.setTitle("");
        init();


    }

    public void init(){
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawerLayout = findViewById(R.id.navMain);
        navigationView = findViewById(R.id.drawer);
        navigationView.setNavigationItemSelectedListener(this);

        actionBar = new ActionBarDrawerToggle(this, drawerLayout,toolbar,(R.string.Open), (R.string.Close));
        drawerLayout.addDrawerListener(actionBar);
        actionBar.setDrawerIndicatorEnabled(true);
        actionBar.syncState();

        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.fLayout,new HomeView());
        fragmentTransaction.commit();
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        switch(item.getItemId()){
            case R.id.home:
            {
                fragmentManager = getSupportFragmentManager();
                fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fLayout,new HomeView());
                fragmentTransaction.commit();
                drawerLayout.closeDrawer(GravityCompat.START);
                break;

            }
            case R.id.rule:
            {
                fragmentManager = getSupportFragmentManager();
                fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fLayout,new RulesView());
                fragmentTransaction.commit();
                drawerLayout.closeDrawer(GravityCompat.START);
                break;
            }
            case R.id.tip:
            {
                fragmentManager = getSupportFragmentManager();
                fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fLayout,new TipsView());
                fragmentTransaction.commit();
                drawerLayout.closeDrawer(GravityCompat.START);
                break;
            }
            case R.id.system:
            {
                fragmentManager = getSupportFragmentManager();
                fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fLayout,new SystemView());
                fragmentTransaction.commit();
                drawerLayout.closeDrawer(GravityCompat.START);
                break;
            }
            case R.id.variation:
            {
                fragmentManager = getSupportFragmentManager();
                fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fLayout,new VariationView());
                fragmentTransaction.commit();
                drawerLayout.closeDrawer(GravityCompat.START);
                break;
            }

        }return true;
    }
    @Override
    public void onBackPressed() {

        if (doubleBackToExitPressedOnce) {
            super.onBackPressed();
            return;
        }

        this.doubleBackToExitPressedOnce = true;
        Toast.makeText(this, "Nhấn Thêm Lần Nữa Để Thoátn!", Toast.LENGTH_SHORT).show();

        new Handler().postDelayed(() -> doubleBackToExitPressedOnce=false, 2000);

    }
}