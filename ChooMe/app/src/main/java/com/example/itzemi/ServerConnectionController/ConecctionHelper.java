package com.example.itzemi.ServerConnectionController;

import android.os.Handler;
import android.os.Message;
import android.util.Log;

import com.example.itzemi.DBController.Goodsdata;
import com.example.itzemi.DBController.Userdata;

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
    private Userdata user;
    private Goodsdata goods;
    //データ受け渡し用のハンドラー
    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            user = (Userdata)msg.obj;
        }
    };

    //ユーザ情報受信
    public void receiveUserTask(){
        setUrl("");
        receive = new ReceiveJsonAsyncTask(url,"user");
        receive.execute();
    }

    //商品情報受信
    public void receiveGoods(){
        setUrl("");
        receive = new ReceiveJsonAsyncTask(url,"goods");
        receive.execute();
    }

    //ランキング情報の受信
    public void reciveRankingTask(){
        setUrl("");
        receive = new ReceiveJsonAsyncTask(url,"ranking");
        receive.execute();
    }

    //レビュー情報の受信
    public void receiveReview(){
        setUrl("");
        receive = new ReceiveJsonAsyncTask(url,"review");
        receive.execute();
    }

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
    private void setUrl(String str){
        try {
            url = new URL(str);
        } catch (MalformedURLException e) {
            Log.e("ConecctionHelper",e.toString());
        }
    }
}
