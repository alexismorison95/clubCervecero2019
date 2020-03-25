package com.monayalexis.clubcervecero2.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;

import com.monayalexis.clubcervecero2.R;
import com.monayalexis.clubcervecero2.view.fragments.HomeFragment;
import com.monayalexis.clubcervecero2.view.fragments.ProfileFragment;
import com.monayalexis.clubcervecero2.view.fragments.SearchFragment;
import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnTabReselectListener;
import com.roughike.bottombar.OnTabSelectListener;

public class ContainerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_container);

        final BottomBar bottomBar = findViewById(R.id.bottombar);

        HomeFragment homeFragment = new HomeFragment();
        getSupportFragmentManager().beginTransaction().add(R.id.container, homeFragment).commit();

        bottomBar.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelected(int tabId) {

                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

                switch (tabId) {

                    case R.id.tab_home:

                        HomeFragment homeFragment = new HomeFragment();
                        transaction.replace(R.id.container, homeFragment, "home");
                        transaction.addToBackStack(null);
                        transaction.commit();
                        break;

                    case R.id.tab_profile:

                        ProfileFragment profileFragment = new ProfileFragment();
                        transaction.replace(R.id.container, profileFragment, "profile");
                        transaction.addToBackStack(null);
                        transaction.commit();
                        break;

                    case R.id.tab_search:

                        SearchFragment searchFragment = new SearchFragment();
                        transaction.replace(R.id.container, searchFragment, "search");
                        transaction.addToBackStack(null);
                        transaction.commit();
                        break;

                }
            }

        });

        getSupportFragmentManager().addOnBackStackChangedListener(new FragmentManager.OnBackStackChangedListener(){

            @Override
            public void onBackStackChanged() {

//                int backCount = getSupportFragmentManager().getBackStackEntryCount();
//                if (backCount == 0){
//                    // block where back has been pressed. since backstack is zero.
//                    int aux = bottomBar.getCurrentTabId();
//                    bottomBar.selectTabWithId(R.id.tab_home);
//                    ultimo_tab = aux;
//
//                }

            }
        });
    }
}
