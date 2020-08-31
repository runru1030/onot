package com.example.onot;

import android.content.ClipData;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import androidx.appcompat.app.AppCompatActivity;

public class Write extends AppCompatActivity {

    //UI
    ImageView image1, image2, image3, image4;

    //constant
    final int PICTURE_REQUEST_CODE = 100;
    Bitmap bitmap;
    Button writebtn, heart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.write);
        ImageView btnImage;
        //UI
        image1 = (ImageView)findViewById(R.id.imageView2);
        image2 = (ImageView)findViewById(R.id.imageView3);
        image3 = (ImageView)findViewById(R.id.imageView4);
        image4 = (ImageView) findViewById(R.id.imageView5);
        heart = (Button) findViewById(R.id.heart);

        writebtn = findViewById(R.id.write);
        btnImage = findViewById(R.id.imageView);
        btnImage.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Audio.Media.EXTERNAL_CONTENT_URI);
                //사진을 여러개 선택할수 있도록 한다
                intent.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true);
                intent.setType("image/*");
                startActivityForResult(Intent.createChooser(intent, "Select Picture"),  PICTURE_REQUEST_CODE);
            }
        });

        //마켓 버튼 이벤트
        Button marketB = (Button)findViewById(R.id.cloth);
        marketB.setOnClickListener(new View.OnClickListener() {
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
        //랭킹 버튼 이벤트
        Button rankB = (Button)findViewById(R.id.ranking);
        rankB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), RankActivity.class);
                startActivity(intent);
            }
        });
        //마이페이지 버튼 이벤트
        Button myB = (Button)findViewById(R.id.mypage);
        myB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MyActivity.class);
                startActivity(intent);
            }
        });
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == PICTURE_REQUEST_CODE)
        {
            if (resultCode == RESULT_OK)
            {

                //기존 이미지 지우기
                image1.setImageResource(0);
                image2.setImageResource(0);
                image3.setImageResource(0);
                image4.setImageResource(0);

                //ClipData 또는 Uri를 가져온다
                Uri uri = data.getData();
                ClipData clipData = data.getClipData();

                //이미지 URI 를 이용하여 이미지뷰에 순서대로 세팅한다.
                if(clipData!=null)
                {

                    for(int i = 0; i < 4; i++)
                    {
                        if(i<clipData.getItemCount()){
                            Uri urione =  clipData.getItemAt(i).getUri();
                            switch (i){
                                case 0:
                                    image1.setImageURI(urione);
                                    try {
                                        bitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), urione);
                                    } catch (IOException e) {
                                        e.printStackTrace();
                                    }
                                    break;
                                case 1:
                                    image2.setImageURI(urione);
                                    break;
                                case 2:
                                    image3.setImageURI(urione);
                                    break;
                                case 3:
                                    image4.setImageURI(urione);
                                    break;
                            }
                        }
                    }
                }
                else if(uri != null)
                {
                    image1.setImageURI(uri);
                }
            }
        }
    }
}



