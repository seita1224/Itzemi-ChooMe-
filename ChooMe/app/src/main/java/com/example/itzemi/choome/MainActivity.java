package com.example.itzemi.choome;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.itzemi.ServerConnectionController.AsyncCallBack;
import com.example.itzemi.ServerConnectionController.ConnectionCallBack;
import com.example.itzemi.ServerConnectionController.ConnectionHelper;
import com.example.itzemi.ServerConnectionController.ReceiveJsonAsyncTask;

import org.json.JSONObject;

import java.net.MalformedURLException;
import java.net.URL;


public class MainActivity extends AppCompatActivity {

    Button bu = null;
    TextView tv = null;

    ConnectionHelper ch = new ConnectionHelper();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bu = (Button)findViewById(R.id.button);
        tv = (TextView)findViewById(R.id.textView);


//        final String RANKING_URL = "http://choome.itsemi.net/api/1.0/ranking/?pattern=(パターンid)&key=XXXXXXXXXXXXXXXXXX"; //ランキング取得URL
//        final String USER_URL = "http://choome.itsemi.net/api/1.0/profile/?_token=XXXXXXXXXXXXXX&key=XXXXXXXXXXXXXXXXXX; //ユーザー情報取得URL


        ch.setUrl("http://weather.livedoor.com/forecast/webservice/json/v1?city=200010");

        bu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ch.setConnectionCallBack(new ConnectionCallBack() {
                    @Override
                    public void receiveJson(JSONObject jo) {
                        tv.setText(jo.toString());
                        Log.d("MainActivity",jo.toString());
                    }
                });
                ch.receiveUserTask();
            }
        });
    }
}
