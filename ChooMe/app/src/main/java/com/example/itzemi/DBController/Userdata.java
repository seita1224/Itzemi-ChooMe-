package com.example.itzemi.DBController;

/**
 * Created by seita_v on 2016/10/21.
 */

//ユーザー情報を扱うクラス
public class Userdata {
    //フィールド
    private String e_mail;//メールアドレス
    private String name;//名前
    private String sex;//性別
    private String hobbies;//趣味
    private int id;//ユーザーID
    private int Age;//年齢

    //コンストラクタ
    public Userdata(){

    }

    //ID
    public int getId() {return id;}
    public void setId(int id) {this.id = id;}

    //e-Mail
    public String getEmail() {return e_mail;}
    public void setEmail(String email) {this.e_mail = email;}

    //name
    public String getName() {return name;}
    public void setName(String name) {this.name = name;}

    //age
    public int getAge() {return Age;}
    public void setAge(int age) {Age = age;}

    //sex
    public String getSex() {return sex;}
    public void setSex(String sex) {this.sex = sex;}

    //hobbies
    public String getHobbies() {return hobbies;}
    public void setHobby(String hobbies) {this.hobbies = hobbies;}
}
