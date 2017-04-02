package org.androidtown.mop_lab2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText name;
    EditText age;
    Button addButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //xml파일에서 id 속성을 준 객체들을 findViewById로 불러옴.
        name = (EditText)findViewById(R.id.name);
        age = (EditText)findViewById(R.id.age);
        addButton=(Button)findViewById(R.id.addButton);

        //추가 버튼을 눌렀을 때 name과 age를 newActivity로 보내도록 Listener를 만들어줌.
        addButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                String Name=name.getText().toString();
                String Age=age.getText().toString();

                //intent를 통해서 newActivity에게 데이터를 넘긴다.
                Intent intent = new Intent(getApplicationContext(),NewActivity.class);
                intent.putExtra("loginName",Name);
                intent.putExtra("loginAge",Age);
                startActivity(intent);
            }
        });

    }

}
