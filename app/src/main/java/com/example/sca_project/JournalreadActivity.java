package com.example.sca_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class JournalreadActivity extends AppCompatActivity {

    String jtitle;
    TextView jrtitle, jrmain;
    ImageView jrimg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_journalread);

        TextView jrday=findViewById(R.id.journalread_day);
        jrtitle=findViewById(R.id.journalread_title);
        jrmain=findViewById(R.id.journalread_main);
        jrimg=findViewById(R.id.journalread_img);

        //오늘 날짜
        Calendar today = Calendar.getInstance ( );
        SimpleDateFormat Format = new SimpleDateFormat("yyyy/MM/dd");
        Date date = today.getTime ( );
        String time = Format.format(date);
        jrday.setText(time);

        //저장된 일지 제목
        SimpleDateFormat format2 =new SimpleDateFormat("yyyyMMdd");
        String numtoday = format2.format(date);
        String txttitle = "_journal";
        jtitle = numtoday+txttitle;


        SharedPreferences spjournal = getSharedPreferences(jtitle, Context.MODE_PRIVATE);
        String dbtitle = spjournal.getString("title", "nodata");
        jrtitle.setText(dbtitle);
        String dbjournal = spjournal.getString("journal_main", "일지가 없습니다");
        jrmain.setText(dbjournal);
    }
}