package com.example.sca_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import static com.example.sca_project.R.id.menu_user;

public class AmendActivity extends AppCompatActivity {

    UserpageFragment userpageFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_amendprofile);


        Button btnamend = findViewById(R.id.amendprofile_btn);

        userpageFragment = new UserpageFragment();


        btnamend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AmendActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}