package com.example.sca_project;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import static com.example.sca_project.R.id.menu_home;
import static com.example.sca_project.R.id.menu_alarm;
import static com.example.sca_project.R.id.menu_journal;
import static com.example.sca_project.R.id.menu_question;
import static com.example.sca_project.R.id.menu_journal;
import static com.example.sca_project.R.id.menu_user;



public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;
    HomeFragment homeFragment;
    alarmFragment alarmFragment;
    journalFragment journalFragment;
    questionFragment questionFragment;
    UserpageFragment userpageFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.navigation);
        homeFragment = new HomeFragment();
        alarmFragment = new alarmFragment();
        journalFragment = new journalFragment();
        questionFragment = new questionFragment();
        userpageFragment = new UserpageFragment();


        //실행시 home프래그먼트를 기본으로 띄움
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_place,homeFragment).commitAllowingStateLoss();
        //바텀네비 눌렀을 때 바꾸기
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()){

                    case menu_home:{
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_place,homeFragment).commitAllowingStateLoss();
                        return true;

                    }
                    case menu_alarm:{

                        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_place,alarmFragment).commitAllowingStateLoss();
                        return true;
                    }
                    case menu_question:{
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_place,questionFragment).commitAllowingStateLoss();
                        return true;
                    }

                    case menu_journal:{
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_place,journalFragment).commitAllowingStateLoss();
                        return true;
                    }
                    case menu_user:{
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_place,userpageFragment).commitAllowingStateLoss();
                        return true;
                    }

                    default:return false;
                }


            }
        });

    }
}