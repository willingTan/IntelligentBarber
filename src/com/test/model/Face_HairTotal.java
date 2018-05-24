package com.test.model;

import java.util.List;

public class Face_HairTotal {
    private String msg;//信息
    private int total; //发型匹配数量
    private List<Face_Hair> data; //发型匹配列表


    public Face_HairTotal() {
    }
    public Face_HairTotal(String msg,int total, List<Face_Hair> data) {
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
    public List<Face_Hair> getData() {
        return data;
    }
    public void setData(List<Face_Hair> data) {
        this.data = data;
    }
}