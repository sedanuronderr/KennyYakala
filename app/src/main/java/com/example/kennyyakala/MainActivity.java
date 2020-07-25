package com.example.kennyyakala;

import androidx.appcompat.app.AppCompatActivity;


import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
TextView textView;
TextView textView1;
Button button;
    ImageView imageView;
    ImageView imageView2;
    ImageView imageView3;
    ImageView imageView4;
    ImageView imageView5;
    ImageView imageView6;
    ImageView imageView7;
    ImageView imageView8;
    ImageView imageView9;
  ImageView[] imageArray;
    Handler handler;
    Runnable runnable;
int number;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView =findViewById(R.id.textView);
        textView1 =findViewById(R.id.textView2);
        button = findViewById(R.id.button);


        imageView =findViewById(R.id.imageView);
        imageView2=findViewById(R.id.imageView2);
        imageView3 =findViewById(R.id.imageView3);
        imageView4=findViewById(R.id.imageView4);
        imageView5 =findViewById(R.id.imageView5);
        imageView6 =findViewById(R.id.imageView6);
        imageView7 =findViewById(R.id.imageView7);
        imageView8 =findViewById(R.id.imageView8);
        imageView9 =findViewById(R.id.imageView9);

        imageArray = new ImageView[] {imageView,imageView2,imageView3,imageView4,imageView5,imageView6,imageView7,imageView8,imageView9};
hideArray();
        number=0;
        new CountDownTimer(10000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                textView.setText("Time:" + millisUntilFinished/1000);
            }

            @Override
            public void onFinish() {
             textView.setText("Time Finish");
             handler.removeCallbacks(runnable);
                for(ImageView image:imageArray) {
                    image.setVisibility(View.INVISIBLE);

                }

                AlertDialog.Builder alert = new AlertDialog.Builder(MainActivity.this);
                alert.setTitle("Restart Game");
                alert.setMessage("will you game again");
                alert.setPositiveButton("yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = getIntent();
                        finish();
                        startActivity(intent);
                    }
                });

                alert.setNegativeButton("no", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        for(ImageView image:imageArray) {
                            image.setVisibility(View.INVISIBLE);

                        }
                    }
                });
                alert.show();
            }
        }.start();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = getIntent();
                finish();
                startActivity(intent);
            }
        });





    }
public void score(View view){
textView1.setText("score"+number);
number++;

}
public void hideArray(){
        handler = new Handler();
        runnable = new Runnable() {
            @Override
            public void run() {
                for(ImageView image:imageArray) {
                    image.setVisibility(View.INVISIBLE);

                }
                    Random random = new Random();
                    int i= random.nextInt(9);
                    imageArray[i].setVisibility(View.VISIBLE);

                    handler.postDelayed(this,500);



            }
        };
  handler.post(runnable);


}



}