package com.example.onot;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ViewFlipper;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

public class MainActivity extends AppCompatActivity {
    Activity act = this;
    ViewFlipper v_flipper;
    GridView gridView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        int images[] = {
                R.drawable.one,
                R.drawable.two,
                R.drawable.three
        };
        //ViewFlipper 객체참조
        v_flipper = findViewById(R.id.image_slide);
        Animation showIn = AnimationUtils.loadAnimation(this, android.R.anim.slide_in_left);

        //ViewFlipper에게 등장 애니메이션 적용
        v_flipper.setInAnimation(showIn);
        v_flipper.setOutAnimation(this, android.R.anim.slide_out_right);
        v_flipper.setFlipInterval(1000);//플리핑 간격(1000ms)
        v_flipper.setAutoStart(true);//자동 Flipping 시작

        //활동 버튼 이벤트
        Button heartB = (Button) findViewById(R.id.heart);
        heartB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), DonationActivity.class);
                startActivity(intent);
            }
        });
        //글쓰기 버튼 이벤트
        Button writeB = (Button) findViewById(R.id.plus);
        writeB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Write.class);
                startActivity(intent);
            }
        });
        //랭킹 버튼 이벤트
        Button rankB = (Button) findViewById(R.id.ranking);
        rankB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), RankActivity.class);
                startActivity(intent);
            }
        });
        //마이페이지 버튼 이벤트
        Button myB = (Button) findViewById(R.id.mypage);
        myB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MyActivity.class);
                startActivity(intent);
            }
        });

    }
}











