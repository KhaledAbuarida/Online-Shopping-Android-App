package com.example.e_commerce.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import android.os.Bundle;
import android.view.MenuItem;
import com.example.e_commerce.Fragment.CartFragment;
import com.example.e_commerce.Fragment.ProfileFragment;
import com.example.e_commerce.R;
import com.example.e_commerce.Fragment.SearchFragment;
import com.example.e_commerce.Fragment.UserCategoryFragment;
import com.example.e_commerce.Fragment.UserHomeFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class UserActivity extends AppCompatActivity {
    private NavigationStrategy navigationStrategy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        getSupportActionBar().hide();

        navigationStrategy = new UserHomeNavigationStrategy();

        BottomNavigationView bottomNav = findViewById(R.id.user_bottom_nav);
        bottomNav.setOnNavigationItemSelectedListener(navListener);
        getSupportFragmentManager().beginTransaction().replace(R.id.user_container, navigationStrategy.getFragment()).commit();
    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.user_nav_home:
                    navigationStrategy = new UserHomeNavigationStrategy();
                    break;
                case R.id.user_nav_category:
                    navigationStrategy = new UserCategoryNavigationStrategy();
                    break;
                case R.id.user_nav_search:
                    navigationStrategy = new SearchNavigationStrategy();
                    break;
                case R.id.user_nav_cart:
                    navigationStrategy = new CartNavigationStrategy();
                    break;
                case R.id.user_nav_profile:
                    navigationStrategy = new ProfileNavigationStrategy();
                    break;
            }
            getSupportFragmentManager().beginTransaction().replace(R.id.user_container, navigationStrategy.getFragment()).commit();
            return true;
        }
    };

    private interface NavigationStrategy {
        Fragment getFragment();
    }

    private static class UserHomeNavigationStrategy implements NavigationStrategy {
        @Override
        public Fragment getFragment() {
            return new UserHomeFragment();
        }
    }

    private static class UserCategoryNavigationStrategy implements NavigationStrategy {
        @Override
        public Fragment getFragment() {
            return new UserCategoryFragment();
        }
    }

    private static class SearchNavigationStrategy implements NavigationStrategy {
        @Override
        public Fragment getFragment() {
            return new SearchFragment();
        }
    }

    private static class CartNavigationStrategy implements NavigationStrategy {
        @Override
        public Fragment getFragment() {
            return new CartFragment();
        }
    }

    private static class ProfileNavigationStrategy implements NavigationStrategy {
        @Override
        public Fragment getFragment() {
            return new ProfileFragment();
        }
    }
}