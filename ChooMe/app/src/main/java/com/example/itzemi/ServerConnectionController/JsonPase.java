package com.example.itzemi.ServerConnectionController;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 * Created by seita on 2016/10/24.
 */

//Jsonデータをパース(解析)するクラス
public class JsonPase {
    //フィールド
    JSONObject jo = null;
    JSONArray ja = null;
    Object o = null;

    //コンストラクタ
    public JsonPase(Object o){this.o = o;}


    public void rankingJson(){
        ja = (JSONArray)o;

        for(int i = 0;i < ja.length();i++){

        }
    }

}
