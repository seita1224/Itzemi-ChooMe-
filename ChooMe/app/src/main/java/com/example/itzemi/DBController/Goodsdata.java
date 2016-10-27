package com.example.itzemi.DBController;

import android.graphics.Bitmap;

/**
 * Created by seita_v on 2016/10/21.
 */

//商品情報を扱うクラス
public class Goodsdata{
    //フィールド
    private String goods_name;//商品の名前
    private int goods_id;//商品ID
    private int valuation;//評価
    private Bitmap picture;//画像
    private String comment;//コメント
    private String genre;//ジャンル
    private String scene;//シーン
    private String hobbies;//趣味


    //コンストラクタ
    public Goodsdata(){

    }

    //goods_name
    public String getGoods_name() {return goods_name;}
    public void setGoods_name(String goods_name) {this.goods_name = goods_name;}

    //goods_id
    public int getGoods_id() {return goods_id;}
    public void setGoods_id(int goods_id) {this.goods_id = goods_id;}

    //Valuation
    public int getValuation() {return valuation;}
    public void setValuation(int valuation) {this.valuation = valuation;}

    //picture
    public Bitmap getPicture() {return picture;}
    public void setPicture(Bitmap picture) {this.picture = picture;}

    //comment
    public String getComment() {return comment;}
    public void setComment(String comment) {this.comment = comment;}

    //genre
    public String getGenre() {return genre;}
    public void setGenre(String genre) {this.genre = genre;}

    //scene
    public String getScene() {return scene;}
    public void setScene(String scene) {this.scene = scene;}

    //getHobby
    public String getHobbies() {return hobbies;}
    public void setHobbies(String hobbies) {this.hobbies = hobbies;}
}
