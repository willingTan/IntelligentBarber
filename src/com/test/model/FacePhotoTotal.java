package com.test.model;

import java.util.List;

public class FacePhotoTotal {
    private String msg;//信息
    private int total; //人脸数量
    private List<FacePhotos> data; //人脸列表


    public FacePhotoTotal() {
    }
    public FacePhotoTotal(String msg,int total, List<FacePhotos> data) {
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
    public List<FacePhotos> getRows() {
        return data;
    }
    public void setRows(List<FacePhotos> data) {
        this.data = data;
    }
}
