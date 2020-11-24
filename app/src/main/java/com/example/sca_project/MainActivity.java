package com.example.sca_project;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

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
    FloatingActionButton fab;


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
        fab = findViewById(R.id.main_fab);
        int selectedItemId = bottomNavigationView.getSelectedItemId();
        MenuItem selectedItem = bottomNavigationView.getMenu().findItem(selectedItemId);


        //실행시 home프래그먼트를 기본으로 띄움
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_place,homeFragment).commitAllowingStateLoss();
        //바텀네비 눌렀을 때 바꾸기
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()){

                    case menu_home:{
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_place,homeFragment).commitAllowingStateLoss();
                        fab.hide();
                        return true;

                    }
                    case menu_alarm:{
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_place,alarmFragment).commitAllowingStateLoss();
                        fab.show();
                        return true;
                    }
                    case menu_question:{
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_place,questionFragment).commitAllowingStateLoss();
                        fab.show();
                        return true;
                    }

                    case menu_journal:{
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_place,journalFragment).commitAllowingStateLoss();
                        fab.show();
                        return true;
                    }
                    case menu_user:{
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_place,userpageFragment).commitAllowingStateLoss();
                        fab.hide();
                        return true;
                    }

                    default:return false;
                }


            }
        });

        //fab버튼 눌렀을때
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,makealarmActivity.class);
                startActivity(intent);
            }
        });



    }
}