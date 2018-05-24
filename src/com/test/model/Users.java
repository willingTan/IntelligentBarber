package com.test.model;

public class Users {
    private int user_id;
    private String user_name;
    private String user_birthday;
    private String user_sex;
    private String user_address;
    private String user_password;
    private String user_image;

    public Users(int user_id,String user_name,String user_birthday,String user_sex,String user_address,String user_password,String user_image){
        this.user_id=user_id;
        this.user_name=user_name;
        this.user_birthday=user_birthday;
        this.user_sex=user_sex;
        this.user_address=user_address;
        this.user_password=user_password;
        this.user_image=user_image;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_birthday() {
        return user_birthday;
    }

    public void setUser_birthday(String user_birthday) {
        this.user_birthday = user_birthday;
    }

    public String getUser_sex() {
        return user_sex;
    }

    public void setUser_sex(String user_sex) {
        this.user_sex = user_sex;
    }

    public String getUser_address() {
        return user_address;
    }

    public void setUser_address(String user_address) {
        this.user_address = user_address;
    }

    public String getUser_password() {
        return user_password;
    }

    public void setUser_password(String user_password) {
        this.user_password = user_password;
    }

    public String getUser_image() {
        return user_image;
    }

    public void setUser_image(String user_image) {
        this.user_image = user_image;
    }

}
