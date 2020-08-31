package com.example.onot;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
public class MyActivity extends AppCompatActivity {
    int total = 2000;
    String name = "눈송이";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);

        //기부 금액
        TextView nowDon = (TextView)findViewById(R.id.donation);
        nowDon.setText(total+"");

        //사용자 이름
        TextView tName = (TextView)findViewById(R.id.textProfile);
        tName.setText(name+" 님");

        //회원정보 수정
        Button chgB = (Button)findViewById(R.id.changeInfo);
       chgB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ChangeInfoActivity.class);
                startActivity(intent);
            }
        });
        Button BckB = (Button)findViewById(R.id.buyingList);
        BckB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), BuyCheckActivity.class);
                startActivity(intent);
            }
        });
        Button SellB = (Button)findViewById(R.id.sellingList);
        SellB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), SellActivity.class);
                startActivity(intent);
            }
        });
        //마켓 버튼 이벤트
        Button marketB = (Button)findViewById(R.id.cloth);
        marketB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });

        //활동 버튼 이벤트
        Button heartB = (Button)findViewById(R.id.heart);
        heartB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), DonationActivity.class);
                startActivity(intent);
            }
        });
        //글쓰기 버튼 이벤트
        Button writeB = (Button)findViewById(R.id.plus);
        writeB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Write.class);
                startActivity(intent);
            }
        });
        //랭킹 버튼 이벤트
        Button rankB = (Button)findViewById(R.id.ranking);
        rankB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), RankActivity.class);
                startActivity(intent);
            }
        });
    }
}

//마켓 버튼 이벤트
//활동 버튼 이벤트
//글쓰기 버튼 이벤트
//랭킹 버튼 이벤트
//마이페이지 버튼 이벤트
