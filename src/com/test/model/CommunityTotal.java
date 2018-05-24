package com.test.model;

import java.util.List;

public class CommunityTotal {
    private String msg;//信息
    private int total; //数量
    private List<Community> data; //列表


    public CommunityTotal() {
    }
    public CommunityTotal(String msg,int total, List<Community> data) {
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
    public List<Community> getData() {
        return data;
    }
    public void setData(List<Community> data) {
        this.data = data;
    }
}
