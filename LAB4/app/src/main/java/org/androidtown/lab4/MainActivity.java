package org.androidtown.lab4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {
    EditText editText;
    RadioGroup radioGroup;
    RadioButton radMan;
    RadioButton radWoman;
    CheckBox chkSms;
    CheckBox chkE_mail;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //xml파일로부터 view객체들을 id로 받아온다.
        editText = (EditText) findViewById(R.id.editText);
        radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        radMan = (RadioButton) findViewById(R.id.man);
        radWoman = (RadioButton) findViewById(R.id.woman);
        chkSms = (CheckBox) findViewById(R.id.sms);
        chkE_mail = (CheckBox) findViewById(R.id.e_mail);
        button = (Button) findViewById(R.id.button);

        //등록버튼을 누르면 registerActivity를 부르면서 값을 넘겨주도록 intent에 bundle객체를 넣어서 보내준다.
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent객체와 Bundle객체를 만든다.
                Intent intent= new Intent(getApplicationContext(),registerActivity.class);
                Bundle mybundle=new Bundle();
                //bundle에 editText로부터 받은 값을 name이라는 이름의 String변수에 넣어서 put한다.
                mybundle.putString("name",editText.getText().toString());

                //bundle에 선택된 radiobutton으로부터 받은 값을 gender라는 이름의 String변수에 넣어서 put한다.
                int radioId=radioGroup.getCheckedRadioButtonId();
                if(radMan.getId()==radioId){
                    mybundle.putString("gender", radMan.getText().toString());
                }
                if(radWoman.getId()==radioId){
                    mybundle.putString("gender",radWoman.getText().toString());
                }

                //bundle에 선택된 checkbox로부터 받은 값을 receive라는 이름의 String변수에 넣어서 put한다.
                if(chkSms.isChecked()){
                    mybundle.putString("receive",chkSms.getText().toString());
                }
                if(chkE_mail.isChecked()){
                    mybundle.putString("receive",chkE_mail.getText().toString());
                }

                //intent에 앞에서 만든 bundle객에를 넣어주고 activity를 실행시킨다.
                intent.putExtras(mybundle);
                startActivity(intent);

            }
        });


    }
}
