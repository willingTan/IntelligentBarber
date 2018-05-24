package com.test.model;

import java.util.List;

public class HairPhotoTotal {
    private String msg;
    private int total; //发型数量
    private List<HairPhotos> rows; //发型列表


    public HairPhotoTotal() {
    }
    public HairPhotoTotal(String msg,int total, List<HairPhotos> rows) {
        this.msg=msg;
        this.total = total;
        this.rows = rows;
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
    public List<HairPhotos> getRows() {
        return rows;
    }
    public void setRows(List<HairPhotos> rows) {
        this.rows = rows;
    }
}
