package com.example.apidemoretrofit;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.apidemoretrofit.Fragments.DashboardFragment;
import com.example.apidemoretrofit.Fragments.ProfileFragment;
import com.example.apidemoretrofit.Fragments.UserFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class HomeActivity extends AppCompatActivity {
BottomNavigationView bottomNavigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        bottomNavigationView=findViewById(R.id.bottomnav);
        loadfragment(new DashboardFragment());
        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment fragment=null;
                switch (item.getItemId())
                {
                    case R.id.dashboard:
                        fragment=new DashboardFragment();
                        break;
                    case R.id.users:
                        fragment=new UserFragment();
                        break;
                    case R.id.profile:
                        fragment=new ProfileFragment();
                        break;
                }
                if(fragment!=null) {
                    loadfragment(fragment);
                }
                return true;
            }
        });
    }
    void loadfragment(Fragment fragment)
    {
        getSupportFragmentManager().beginTransaction().replace(R.id.relativelayout_frag,fragment).commit();
    }


}