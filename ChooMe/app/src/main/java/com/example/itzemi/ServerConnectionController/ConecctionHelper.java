package com.example.itzemi.ServerConnectionController;

import android.os.Handler;
import android.os.Message;
import android.util.Log;

import com.example.itzemi.DBController.Goodsdata;
import com.example.itzemi.DBController.Userdata;
import com.example.itzemi.ServerConnectionController.ReceiveJsonAsyncTask.CallbackData;

import org.json.JSONObject;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by seita on 2016/10/31.
 */

//データを受信、送信できるよう処理をする中間クラス
public class ConecctionHelper {
    private SendJsonAsyncTask send = null;  //データ送信用の非同期処理クラス
    private ReceiveJsonAsyncTask receive = null;    //データ受信用の非同期処理クラス
    private URL url = null; //送受信先のURL
    private JSONObject json;
    private Userdata user;
    private Goodsdata goods;

    //このJsonオブジェクトには何も帰ってきてない
    public JSONObject jore(){
//        Log.d("ConecctionHelper_jore",json.toString());
        return json;
    }

    //-----------------------------受信-----------------------------
    //ユーザ情報受信
    public void receiveUserTask(){
        setUrl("");
        receive = new ReceiveJsonAsyncTask(url);
        receive.setOnCallBack(new CallbackData(){
            @Override
            public void callBack(JSONObject jo) {
                super.callBack(jo);
                Log.d("Conecction.._receiveU..",jo.toString());
                json = jo;
            }
        });
        receive.execute();
        Log.d("ConecctionHelper_json",json.toString());
    }

    //商品情報受信
    public void receiveGoods(){
        setUrl("");
        receive = new ReceiveJsonAsyncTask(url);
        receive.execute();
    }

    //ランキング情報の受信
    public void reciveRankingTask(){
        setUrl("");
        receive = new ReceiveJsonAsyncTask(url);
        receive.execute();
    }

    //レビュー情報の受信
    public void receiveReview(){
        setUrl("");
        receive = new ReceiveJsonAsyncTask(url);
        receive.execute();
    }


    //-----------------------------送信-----------------------------
    //ユーザ情報送信
    public void sendUserTask(){
        setUrl("");
        send = new SendJsonAsyncTask();
        send.execute();
    }

    //商品情報送信
    public void sendGoods(){
        setUrl("");
        send = new SendJsonAsyncTask();
        send.execute();
    }

    //ランキング情報の送信
    public void sendRankingTask(){
        setUrl("");
        send = new SendJsonAsyncTask();
        send.execute();
}

    //送受信用URLにURLをセット
    public void setUrl(String str){
        try {
            url = new URL(str);
        } catch (MalformedURLException e) {
            Log.e("ConecctionHelper",e.toString());
        }
    }
}
