package com.example.itzemi.choome;

import android.support.v4.media.MediaBrowserCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.itzemi.DBController.Goodsdata;
import com.example.itzemi.DBController.Reviewdata;
import com.example.itzemi.DBController.Userdata;
import com.example.itzemi.ServerConnectionController.ConecctionHelper;
import com.example.itzemi.ServerConnectionController.ReceiveJsonAsyncTask;


public class MainActivity extends AppCompatActivity {

    Button bu = null;
    TextView tv = null;

    ConecctionHelper ch = new ConecctionHelper();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bu = (Button)findViewById(R.id.button);
        tv = (TextView)findViewById(R.id.textView);

        ch.setUrl("http://weather.livedoor.com/forecast/webservice/json/v1?city=400040");

        bu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ch.receiveUserTask();
//                //tv.setText(ch.jore().toString());
                if(ch.jore() == null){
                    tv.setText("このオブジェクトはありません");
                }

            }
        });
    }
}
