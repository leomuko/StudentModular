package com.example.modularstudent.Main;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.modularstudent.Class.SelectClass;
import com.example.modularstudent.Main.UI.Account.AccountFragment;
import com.example.modularstudent.Main.UI.Files.FilesFragment;
import com.example.modularstudent.Main.UI.Links.LinksFragment;
import com.example.modularstudent.Models.ClassModel;
import com.example.modularstudent.R;
import com.example.modularstudent.School.SelectSchool;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView mBottomNavigationView;
    private ClassModel mMyClass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mBottomNavigationView = findViewById(R.id.bottomNav);
        mBottomNavigationView.setOnNavigationItemSelectedListener(navListener);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        mMyClass = getIntent().getParcelableExtra("class");
        getSupportActionBar().setTitle(mMyClass.getClassTitle());


        getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment,
                new FilesFragment()).commit();
    }
    private BottomNavigationView.OnNavigationItemSelectedListener navListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                    Fragment selectedFragment = null;

                    switch (menuItem.getItemId()){
                        case R.id.navigation_files:
                            selectedFragment = new FilesFragment();
                            break;
                        case R.id.navigation_links:
                            selectedFragment = new LinksFragment();
                            break;
                        case R.id.navigation_account:
                            selectedFragment = new AccountFragment();
                            break;
                    }
                    getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment,
                            selectedFragment).commit();

                    return true;
                }
            };
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == android.R.id.home) {
            Intent intent = new Intent(this, SelectClass.class);
            intent.putExtra("SchoolId", mMyClass.getAssignedSchool());
            startActivity(intent);
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
