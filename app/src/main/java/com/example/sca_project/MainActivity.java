package com.example.sca_project;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import static com.example.sca_project.R.id.menu_home;
import static com.example.sca_project.R.id.menu_alarm;
import static com.example.sca_project.R.id.menu_journal;
import static com.example.sca_project.R.id.menu_question;
import static com.example.sca_project.R.id.menu_user;



public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;
    HomeFragment homeFragment;
    alarmFragment alarmFragment;
    journalFragment journalFragment;
    questionFragment questionFragment;
    UserpageFragment userpageFragment;
    FloatingActionButton fab, fab_write, fab_status;
    Animation fab_open, fab_close;
    Boolean openFlag = false;
    Intent intent;

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
        fab_status=findViewById(R.id.main_fab_status);
        fab_write=findViewById(R.id.main_fab_write);
        fab_open = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fab_open);
        fab_close = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fab_close);


        //fab 숨김
        fab_write.startAnimation(fab_close);
        fab_status.startAnimation(fab_close);
        fab_write.setClickable(false);
        fab_status.setClickable(false);



        //실행시 home프래그먼트를 기본으로 띄움
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_place,homeFragment).commitAllowingStateLoss();
        fab.hide();
        animclose();
        //바텀네비 눌렀을 때 바꾸기
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()){

                    case menu_home:{
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_place,homeFragment).commitAllowingStateLoss();
                        fab.hide();
                        animclose();
                        return true;

                    }
                    case menu_alarm:{
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_place,alarmFragment).commitAllowingStateLoss();
                        fab.show();
                        animclose();
                        return true;
                    }
                    case menu_question:{
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_place,questionFragment).commitAllowingStateLoss();
                        fab.show();
                        animclose();
                        return true;
                    }

                    case menu_journal:{
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_place,journalFragment).commitAllowingStateLoss();
                        fab.show();
                        fab_status.show();
                        fab_write.show();
                        return true;
                    }
                    case menu_user:{
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_place,userpageFragment).commitAllowingStateLoss();
                        fab.hide();
                        animclose();
                        return true;
                    }

                    default:return false;
                }


            }
        });

        //fab 눌렀을때
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                System.out.println(bottomNavigationView.getMenu().findItem(bottomNavigationView.getSelectedItemId()));

                switch (bottomNavigationView.getMenu().findItem(bottomNavigationView.getSelectedItemId()).toString()){

                    case "alarm":
                        intent = new Intent(MainActivity.this,makealarmActivity.class);
                        startActivity(intent);
                        break;
                    case "question":
                        intent = new Intent(MainActivity.this,QuestionmakeActivity.class);
                        startActivity(intent);
                        break;
                    case "journal":
                        anim();
                        break;

                    default:break;
                }
            }
        });

        fab_write.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(MainActivity.this,JournalmakeActivity.class);
                startActivity(intent);
            }
        });

        fab_status.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(MainActivity.this,JournalreadActivity.class);
                startActivity(intent);
            }
        });



    }

    public void anim() {

        if (openFlag) {
            fab_status.startAnimation(fab_close);
            fab_write.startAnimation(fab_close);
            fab_status.setClickable(false);
            fab_write.setClickable(false);
            openFlag = false;
        } else {
            fab_status.startAnimation(fab_open);
            fab_write.startAnimation(fab_open);
            fab_status.setClickable(true);
            fab_write.setClickable(true);
            openFlag = true;
        }
    }

    public void animclose(){
        fab_status.hide();
        fab_write.hide();
        fab_status.setClickable(false);
        fab_write.setClickable(false);
    }

}