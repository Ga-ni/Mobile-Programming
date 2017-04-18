package org.androidtown.lab4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TextView;

public class registerActivity extends AppCompatActivity {
    TextView nameVal;
    TextView genderVal;
    TextView receiveVal;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        //xml파일로부터 view객체들을 id로 읽어온다.
        nameVal=(TextView)findViewById(R.id.nameVal);
        genderVal=(TextView)findViewById(R.id.genderVal);
        receiveVal=(TextView)findViewById(R.id.receiveVal);
        button=(Button)findViewById(R.id.button);

        //Intent변수에 mainActivity에서 받은 intent를 넣어주고, Bundle객체에 intent에 들어있던 bundle을 넣어준다.
        Intent intent=getIntent();
        if(intent!=null){
            Bundle mybundle=intent.getExtras();
            //bundle객체에 들어있던 값들로 text를 update해준다.
            nameVal.setText("   :"+mybundle.getString("name"));
            genderVal.setText("   :"+mybundle.getString("gender"));
            receiveVal.setText(" :"+mybundle.getString("receive"));
        }

        //이전버튼을 누르면 mainActivity가 다시 나오도록 현재 Activity를 finish시킨다.
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
