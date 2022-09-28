package com.bmlmunjal.groceryhome;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.bmlmunjal.groceryhome.CartFragment;
import com.bmlmunjal.groceryhome.CategoriesFragment;
import com.bmlmunjal.groceryhome.HomeFragment;
import com.bmlmunjal.groceryhome.MyOrderFragment;
import com.bmlmunjal.groceryhome.ProfileFragment;
import com.bmlmunjal.groceryhome.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class HomeActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;
    HomeFragment homeFragment= new HomeFragment();
    CartFragment cartFragment= new CartFragment();
    CategoriesFragment categoriesFragment= new CategoriesFragment();
    MyOrderFragment myOrderFragment= new MyOrderFragment();
    ProfileFragment profileFragment= new ProfileFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        bottomNavigationView=findViewById(R.id.bottomNavigationView3);

        replaceFragment(homeFragment);
        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case (R.id.homeNavBar):
                        replaceFragment(homeFragment);
                        return true;
                    case (R.id.cartNavBar):
//                        replaceFragment(navigationFragment);
                        //need to add navigation map
                        replaceFragment(categoriesFragment);
                        return true;
                    case (R.id.categoriesNavBar):
                        replaceFragment(cartFragment);
                        return true;
                    case (R.id.myOrderNavBar):
                        replaceFragment(myOrderFragment);
                        return true;
                    case (R.id.profileNavBar):
                        replaceFragment(profileFragment);
                        return true;
                }
                return false;
            }
        });
    }
    private void replaceFragment(Fragment fragment){
        FragmentManager fragmentManager= getSupportFragmentManager();
        FragmentTransaction fragmentTransaction= fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frameLayoutHomeActivity,fragment);
        fragmentTransaction.commit();
    }
}