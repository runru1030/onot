package com.example.onot;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.*;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.EditText;
import android.content.Context;


public class billActivity extends AppCompatActivity {
    EditText [] id=new EditText[4];
    boolean fill=true;
    final Context context = this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bill);
        id[0]=findViewById(R.id.name2);
        id[1]=findViewById(R.id.phone2);
        id[2]=findViewById(R.id.addr2);
        id[3]=findViewById(R.id.detail2);

        Button button = findViewById(R.id.order);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for(int i=0;i<4;i++){
                    String get=id[i].getText().toString();
                    if(get.getBytes().length<=0)
                        fill=false;
                }
                if(fill==true) {
                    Intent intent = new Intent(getApplicationContext(), billSubActivity.class);//주문확인화면전환
                    startActivity(intent);
                }
                else{
                    AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);

                    alertDialogBuilder
                            .setTitle("알림")
                            .setMessage("배송 정보를 확인해주십시오.")
                            .setCancelable(true)
                            .setPositiveButton("확인", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                }
                            });
                    AlertDialog dialog = alertDialogBuilder.create();
                    dialog.show();}
            }
        });
        Button button2 = findViewById(R.id.cancle);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), JoinActivity.class);//이전화면
                startActivity(intent);

            }
        });


    }
}


