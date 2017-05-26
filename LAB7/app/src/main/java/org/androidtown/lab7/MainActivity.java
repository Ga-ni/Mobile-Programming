package org.androidtown.lab7;

import android.graphics.Color;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {
    RelativeLayout layout1;
    RelativeLayout layout2;
    private MediaPlayer mp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        layout1=(RelativeLayout)findViewById(R.id.layout1);
        layout2=(RelativeLayout)findViewById(R.id.layout2);

        //layout1에 리스너를 세팅해준다.
        layout1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mp!=null)  //이미 재생되고 있는 음악이 있는지 없는지 확인하고 있으면 종료시킨다.
                    mp.release();
                mp = mp.create(layout1.getContext(),R.raw.music1);//raw폴더에있는 music1을 mp에 할당해 준다.
                mp.start();   //음악을 실행시킨다.
                layout2.setBackgroundColor(Color.WHITE);//layout2의 배경을 흰색으로 바꿔준다.
                layout1.setBackgroundColor(Color.GRAY);//layout1의 배경을 회색으로 바꿔준다.
            }
        });
        //layout2에 리스너를 세팅해준다.
        layout2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mp!=null)  //이미 재생되고 있는 음악이 있는지 없는지 확인하고 있으면 종료시킨다.
                    mp.release();
                mp=mp.create(layout2.getContext(),R.raw.music2);//raw폴더에있는 music2을 mp에 할당해 준다.
                mp.start();   //음악을 실행시킨다.
                layout1.setBackgroundColor(Color.WHITE);//layout1의 배경을 흰색으로 바꿔준다.
                layout2.setBackgroundColor(Color.GRAY);//layout2의 배경을 회색으로 바꿔준다.
            }
        });

    }
    //어플이 종료되면 음악도 종료 되도록 onDestroy method를 override해준다.
    protected void onDestroy(){
        super.onDestroy();
        if(mp!=null)
            mp.release();
    }


}
