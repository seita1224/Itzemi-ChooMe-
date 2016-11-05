package com.example.itzemi.ServerConnectionController;

import android.os.AsyncTask;
import android.util.Log;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by seita on 2016/10/20.
 */

public class ReceiveJsonAsyncTask extends AsyncTask <Void,Void,JsonPase>{
    private URL url;    //接続するURL
    private StringBuilder result = new StringBuilder(); //JSONにする前の文字列を保存するためのStringBuilder

    //---------------------------------コンスラクタ---------------------------------

    public ReceiveJsonAsyncTask(){  }

    public ReceiveJsonAsyncTask(URL url) {this.url = url;}

    //------------------------------------------------------------------------------

    //非同期処理(メソッド)
    @Override
    protected JsonPase doInBackground(Void... params) {
        HttpURLConnection httpc = null; //http通信コネクター
        JsonPase jp = null; //JSONオブジェクト

        try {
            //指定されたURLにコネクション開始
            httpc = (HttpURLConnection)url.openConnection();
            httpc.connect();
        } catch (MalformedURLException e) {
            Log.e("error",e.toString());
        } catch (IOException e) {
            Log.e("error",e.toString());
        }
        try {
            //コネクションの結果を格納
            int status = httpc.getResponseCode();
            //コネクションに成功した時
            if(status == HttpURLConnection.HTTP_OK){
                //コネクターから取得データの取り出し
                InputStreamReader IReader = new InputStreamReader(httpc.getInputStream());
                BufferedReader BReader = new BufferedReader(IReader);
                String line = null;
                //取得データの変換(1行ずつStringBuilderに格納)
                while((line = BReader.readLine()) != null) {
                    result.append(line);
                    Log.d("debug",line);
                }

                //取得データをJsonに変換
                jp = new JsonPase(result);

                //読み込み作業終了
                IReader.close();
                BReader.close();
            }
        }catch (MalformedURLException e){
            Log.e("error",e.toString());
        } catch (IOException e) {
            Log.e("error",e.toString());
        }finally {
            //接続破棄
            httpc.disconnect();
        }

        return jp;
    }

    @Override
    protected void onPostExecute(JsonPase jp) {
        super.onPostExecute(jp);
        //表示
        Log.d("debug",jp.getJa().toString());

    }
}
