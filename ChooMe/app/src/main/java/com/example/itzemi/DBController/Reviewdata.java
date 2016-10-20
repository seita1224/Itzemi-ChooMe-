package com.example.itzemi.DBController;

/**
 * Created by seita_v on 2016/10/21.
 */

//レビューを扱うクラス
public class Reviewdata {
    //フィールド
    private String goos_id,comment;
    private int goods_id,user_id,rate,scene_id;

    //コンストラクタ
    public Reviewdata(){

    }

    //goods_id
    public String getGoos_id() {return goos_id;}
    public void setGoos_id(String goos_id) {this.goos_id = goos_id;}

    //user_id
    public int getUser() {return user_id;}
    public void setUser(int user_id) {this.user_id = user_id;}

    //comment
    public String getComment() {return comment;}
    public void setComment(String comment) {this.comment = comment;}

    //rate
    public int getRate() {return rate;}
    public void setRate(int rate) {this.rate = rate;}

    //scene_id
    public int getScene_id() {return scene_id;}
    public void setScene_id(int scene_id) {this.scene_id = scene_id;}
}
