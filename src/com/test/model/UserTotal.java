package com.test.model;

import java.util.List;

public class UserTotal {
    private String msg;//信息
    private int total; //用户数量
    private List<Users> data; //用户列表


    public UserTotal() {
    }
    public UserTotal(String msg,int total, List<Users> data) {
        this.msg=msg;
        this.total = total;
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }
    public void setMsg(String msg) {
        this.msg = msg;
    }
    public int getTotal() {
        return total;
    }
    public void setTotal(int total) {
        this.total = total;
    }
    public List<Users> getData() {
        return data;
    }
    public void setData(List<Users> data) {
        this.data = data;
    }
}
