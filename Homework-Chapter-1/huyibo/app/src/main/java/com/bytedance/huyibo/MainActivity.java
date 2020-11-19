package com.bytedance.huyibo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       final TextView tv=findViewById(R.id.tv);
       final Button button =findViewById(R.id.btn1);
       button.setOnClickListener(new View.OnClickListener(){
           @Override
           public void onClick(View view){
               Log.d( "MainActivity", "clicked");
               tv.setText("clicked");
           }
       });
    }
}