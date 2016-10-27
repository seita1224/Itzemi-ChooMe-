package com.example.itzemi.DBController;

/**
 * Created by seita_v on 2016/10/21.
 */

//レビューを扱うクラス
public class Reviewdata {
    //フィールド
    private String comment;//コメント
    private int goods_id;//商品ID
    private int user_id;//ユーザーID
    private int rate;//評価(1～5)
    private int scene_id;//シーンID

    //コンストラクタ
    public Reviewdata(){

    }

    //goods_id
    public int getGoods_id() {return goods_id;}
    public void setGoods_id(int goods_id) {this.goods_id = goods_id;}

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
