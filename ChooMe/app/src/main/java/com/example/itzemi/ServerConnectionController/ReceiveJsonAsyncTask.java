package com.example.itzemi.ServerConnectionController;

import android.os.AsyncTask;
import android.util.Log;
import android.widget.TextView;

import com.example.itzemi.DBController.Userdata;

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

public class ReceiveJsonAsyncTask extends AsyncTask <Void,Void,JSONObject>{
    private URL url;    //接続するURL
    private StringBuilder result = new StringBuilder();
    private AsyncCallBack asyncCallBack;

    //---------------------------------コンスラクタ---------------------------------

    public ReceiveJsonAsyncTask(){  }

    public ReceiveJsonAsyncTask(URL url) {
        this.url = url;
    }

    //------------------------------------------------------------------------------

    //非同期処理(メソッド)
    @Override
    protected JSONObject doInBackground(Void... params) {
        HttpURLConnection httpc = null; //http通信コネクター
        JSONObject jo = null;

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
                    Log.d("ReceiveJso..._doInB...",line);
                }

                //取得データをJsonに変換
                jo = new JSONObject(result.toString());

                //読み込み作業終了
                IReader.close();
                BReader.close();
            }
        }catch (MalformedURLException e){
            Log.e("error",e.toString());
        } catch (IOException e) {
            Log.e("error",e.toString());
        } catch (JSONException e) {
            Log.e("error",e.toString());
        } finally {
            //接続破棄
            httpc.disconnect();
        }
        return jo;
    }

    @Override
    protected void onPostExecute(JSONObject jo) {
        super.onPostExecute(jo);
        //表示
        asyncCallBack.callBack( jo);
    }

    //コールバック処理セットメソッド
    public void setCallBack(AsyncCallBack cb){
        asyncCallBack = cb;
    }
}


