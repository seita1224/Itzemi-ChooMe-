package com.example.itzemi.ServerConnectionController;

import com.example.itzemi.DBController.Goodsdata;

import java.util.ArrayList;

/**
 * Created by seita on 2016/12/02.
 */

public interface ConnectionCallBack extends TestCallBack{
    void receiveJson(JsonPase jsonPase);

    void receiveJson(ArrayList<Goodsdata> goodsdatas);
}
