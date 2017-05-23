package org.androidtown.db;

import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity {
    EditText txtData;
    Button btn1, btn2, btn3, btn4;
    File file;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtData=(EditText)findViewById(R.id.txtData);
        btn1=(Button)findViewById(R.id.btn1);
        btn2=(Button)findViewById(R.id.btn2);
        btn3=(Button)findViewById(R.id.btn3);
        btn4=(Button)findViewById(R.id.btn4);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                FileOutputStream fOut= new FileOutputStream(file);
                    OutputStreamWriter osw=new OutputStreamWriter(fOut);
                    osw.write(txtData.getText().toString());
                    osw.close();
                }catch (java.io.FileNotFoundException e){}
                catch(java.io.IOException e){}

                Toast.makeText(getApplicationContext(),"save data in SD card",Toast.LENGTH_LONG).show();
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtData.setText("");
                Toast.makeText(getApplicationContext(),"Text cleared",Toast.LENGTH_LONG).show();
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                FileInputStream fIn=new FileInputStream(file);
                    if(fIn!=null){
                        BufferedReader reader= new BufferedReader(new InputStreamReader (fIn));
                        String str="";
                        StringBuffer buf= new StringBuffer();
                        while((str=reader.readLine())!=null){
                            Log.d("tag",""+str);
                            buf.append(str+"\n");
                        }
                        fIn.close();
                        txtData.setText(buf.toString());
                    }
                }catch (java.io.FileNotFoundException e){}
                catch(java.io.IOException e){ }
                Toast.makeText(getApplicationContext(),"read text from SD card",Toast.LENGTH_LONG).show();
            }
            });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                Toast.makeText(getApplicationContext(),"finish APP",Toast.LENGTH_LONG).show();
            }
        });

        File sdCard= Environment.getExternalStorageDirectory();
        File directory=new File(sdCard.getAbsolutePath()+"/MyFiles");
        directory.mkdirs();
        file = new File(directory, "textfile.txt");

    }

}








