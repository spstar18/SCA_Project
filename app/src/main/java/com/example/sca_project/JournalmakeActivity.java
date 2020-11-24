package com.example.sca_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class JournalmakeActivity extends AppCompatActivity {

    String jtitle;
    EditText title_edt, main_edt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_journalmake);

        TextView jday=findViewById(R.id.journalmake_day);
        Button btn_jsave=findViewById(R.id.journalmake_btn_save);
        title_edt=findViewById(R.id.journalmake_title);
        main_edt=findViewById(R.id.journalmake_maintxt);

        //오늘날짜 호출
        Calendar today = Calendar.getInstance ( );
        SimpleDateFormat Format = new SimpleDateFormat("yyyy/MM/dd");
        Date date = today.getTime ( );
        String time = Format.format(date);
        jday.setText(time);

        //저장 되는 일지 제목
        SimpleDateFormat format2 =new SimpleDateFormat("yyyyMMdd");
        String numtoday = format2.format(date);
        String txttitle = "_journal";
        jtitle = numtoday+txttitle;

        //수정시 데이터 가져오기
        SharedPreferences spjournal = getSharedPreferences(jtitle, Context.MODE_PRIVATE);
        String dbtitle = spjournal.getString("title", "");
        title_edt.setText(dbtitle);
        String dbjournal = spjournal.getString("journal_main", "");
        main_edt.setText(dbjournal);


        //저장버튼 누를 시
        btn_jsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //메인액티비티로 이동
                Intent intent=new Intent(JournalmakeActivity.this,MainActivity.class);
                startActivity(intent);

                //제목 저장
                SharedPreferences sptitle = getSharedPreferences(jtitle, MODE_PRIVATE);
                SharedPreferences.Editor edtitle = sptitle.edit();
                edtitle.putString("title", title_edt.getText().toString());
                edtitle.putString("journal_main", main_edt.getText().toString());
                edtitle.apply();


            }
        });

    }
}