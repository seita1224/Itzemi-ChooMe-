package com.example.itzemi.ServerConnectionController;

import android.graphics.Bitmap;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by seita on 2016/10/24.
 */

//Jsonデータをパース(解析)するクラス
public class JsonPase {
    //フィールド
    private JSONObject jo = null;
    private JSONArray ja = null;
    private StringBuilder sb = null;

    //コンストラクタ
    //JSONObject
    public JsonPase(JSONObject jo){this.jo = jo;}
    //JSONArray
    public JsonPase(JSONArray ja){this.ja = ja;}
    //StringBilder
    public JsonPase(StringBuilder sb){this.sb = sb;}


    //ランキングの文字列を返すメソッド
    public String RankingJson(){
        //Jsonの情報保存用変数
        sb = new StringBuilder();
        //JSONArrayを格納する
        for(int i = 0;i < ja.length();i++){
        }
        return null;
    }

    //ユーザーデータを返すメソッド
    public String UserJson(){
        StringBuilder sb = new StringBuilder();
        return null;
    }

    //商品のデータを返すメソッド
    public String GoodsJson(){
        //商品データ格納用StringBilder
        sb = new StringBuilder();

        return null;
    }

    //商品の写真を返すメソッド
    public Bitmap PictureData(){
        //商品写真格納用配列
        Bitmap bm[] = null;
        //Bitmap配列をJsonから生成し格納
        try {
            for (int i = 0;i < ja.length();i++){
                bm[i] = (Bitmap) ja.getJSONObject(i).get("picture");
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }

    //JSONObjectのgetter,setter
    public JSONObject getJo() {return jo;}
    public void setJo(JSONObject jo) {this.jo = jo;}

    //JSONArrayのgetter,setter
    public JSONArray getJa(){return ja;}
    public void setJa(JSONArray ja){this.ja = ja;}

    //StringBilderのgetter,setter
    public StringBuilder getSb() {return sb;}
    public void setSb(StringBuilder sb) {this.sb = sb;}

}
