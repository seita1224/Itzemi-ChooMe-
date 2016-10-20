package com.example.itzemi.DBController;

import android.graphics.Bitmap;

/**
 * Created by seita_v on 2016/10/21.
 */

//商品情報を扱うクラス
public class Goodsdata {
    //フィールド
    private String goods_name;
    private int goods_id;
    private Bitmap picture;

    //コンストラクタ
    public Goodsdata(){

    }

    //goods_name
    public String getGoods_name() {return goods_name;}
    public void setGoods_name(String goods_name) {this.goods_name = goods_name;}

    //goods_id
    public int getGoods_id() {return goods_id;}
    public void setGoods_id(int goods_id) {this.goods_id = goods_id;}

    //picture
    public Bitmap getPicture() {return picture;}
    public void setPicture(Bitmap picture) {this.picture = picture;}
}
