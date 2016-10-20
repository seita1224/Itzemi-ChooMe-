package MaikinngSoceFolder;

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

public class ReceiveJsonAsyncTask extends AsyncTask <Object,Void,JSONObject>{
    private URL url;    //接続するURL
    private StringBuilder result = new StringBuilder(); //JSONにする前の文字列を保存するためのStringBuilder
    private TextView mTextView = null;  //MainActivityのTextView

    //---------------------------------コンスラクタ---------------------------------

    public ReceiveJsonAsyncTask(){  }

    public ReceiveJsonAsyncTask(URL url, TextView mTextView) {
        this.url = url;
        this.mTextView = mTextView;
    }

    //------------------------------------------------------------------------------

    //非同期処理(メソッド)
    @Override
    protected JSONObject doInBackground(Object[] params) {
        HttpURLConnection httpc = null; //http通信コネクター
        JSONObject json = null; //JSONオブジェクト

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
                json = new JSONObject(result.toString());

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
        }

        //接続破棄
        httpc.disconnect();

        return json;
    }

    @Override
    protected void onPostExecute(JSONObject j) {
        super.onPostExecute(j);
        //表示
        Log.d("debug",j.toString());
        mTextView.setText(j.toString());
    }
}
