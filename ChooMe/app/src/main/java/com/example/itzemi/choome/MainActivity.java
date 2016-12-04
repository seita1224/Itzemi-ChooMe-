package com.example.itzemi.choome;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.itzemi.DBController.Goodsdata;
import com.example.itzemi.ServerConnectionController.ConnectionCallBack;
import com.example.itzemi.ServerConnectionController.ConnectionHelper;
import com.example.itzemi.ServerConnectionController.JsonPase;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

//     final String RANKING_URL = "http://choome.itsemi.net/api/1.0/ranking/?pattern=(パターンid)&key=XXXXXXXXXXXXXXXXXX"; //ランキング取得URL
//     final String USER_URL = "http://choome.itsemi.net/api/1.0/profile/?_token=XXXXXXXXXXXXXX&key=XXXXXXXXXXXXXXXXXX; //ユーザー情報取得URL

    Button bu = null;
    TextView tv = null;

    ConnectionHelper ch = new ConnectionHelper();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bu = (Button)findViewById(R.id.button);
        tv = (TextView)findViewById(R.id.textView);

        ch.setUrl("http://choome.itsemi.net/api/1.0/ranking/?pattern=1&goodstype=1&key=pcdEhBroxNohtmKoek8iE34hQ6FZYbp");

        bu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ch.setConnectionCallBack(new ConnectionCallBack() {
                    @Override
                    public void testMethod() {

                    }

                    @Override
                    public void receiveJson(JsonPase jsonPase) {
                        ArrayList<Goodsdata> rank = jsonPase.RankingJson();
                        Log.d("MainActivity",rank.get(0).getGoods_name());
                        for(Goodsdata gd:rank){
                            tv.setText(tv.getText() + "\n" +gd.getGoods_name());
                        }
                    }

                    @Override
                    public void receiveJson(ArrayList<Goodsdata> goodsdatas) {

                    }
                });
                ch.reciveRankingTask();
            }
        });
    }
}
