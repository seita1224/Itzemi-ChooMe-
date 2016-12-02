package com.example.itzemi.choome;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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

    Button bu = null,bu2 = null;
    TextView tv = null;

    ReceiveJsonAsyncTask mReceive;
    JSONObject json = null;
    URL url = null;

    ConnectionHelper ch = new ConnectionHelper();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bu = (Button)findViewById(R.id.button);
        bu2 = (Button)findViewById(R.id.button2);
        tv = (TextView)findViewById(R.id.textView);


//        final String RANKING_URL = "http://choome.itsemi.net/api/1.0/ranking/?pattern=(パターンid)&key=XXXXXXXXXXXXXXXXXX"; //ランキング取得URL
//        final String USER_URL = "http://choome.itsemi.net/api/1.0/profile/?_token=XXXXXXXXXXXXXX&key=XXXXXXXXXXXXXXXXXX; //ユーザー情報取得URL

        try {
            url = new URL("http://weather.livedoor.com/forecast/webservice/json/v1?city=200010");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        bu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ch.setConnectionCallBack(new ConnectionCallBack() {
                    @Override
                    public void receiveJson(JSONObject jo) {
                        tv.setText(jo.toString());
                    }
                });
            }
        });
        bu2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv.setText(json.toString());
            }
        });
    }

    public void receive(){
        mReceive = new ReceiveJsonAsyncTask(url);
        mReceive.setCallBack(new AsyncCallBack() {
            @Override
            public void callBack(JSONObject jo) {
                tv.setText(jo.toString());
            }
        });
        mReceive.execute();
    }
}
