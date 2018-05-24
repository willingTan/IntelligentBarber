package com.test.model;

import java.util.List;

public class CheckTotal {
    private String msg;//信息
    private int total; //数量
    private List<Check> data; //列表


    public CheckTotal() {
    }
    public CheckTotal(String msg,int total, List<Check> data) {
        this.msg=msg;
        this.total = total;
        this.data = data;
    }
    public String getMsg(){
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
    public List<Check> getData() {
        return data;
    }
    public void setData(List<Check> data) {
        this.data = data;
    }
}
