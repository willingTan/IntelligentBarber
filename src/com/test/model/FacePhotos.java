package com.test.model;

public class FacePhotos {
    int fp_id;
    String fp_url;
    int fp_type;
    String fp_description;

    public FacePhotos(int fp_id,String fp_url,int fp_type,String fp_description){
        this.fp_id=fp_id;
        this.fp_url=fp_url;
        this.fp_type=fp_type;
        this.fp_description=fp_description;
    }


    public String getFp_description() {
        return fp_description;
    }

    public void setFp_description(String fp_description) {
        this.fp_description = fp_description;
    }

    public int getFp_type() {
        return fp_type;
    }

    public void setFp_type(int fp_type) {
        this.fp_type = fp_type;
    }

    public int getFp_id() {
        return fp_id;
    }

    public void setFp_id(int fp_id) {
        this.fp_id = fp_id;
    }

    public String getFp_url() {
        return fp_url;
    }

    public void setFp_url(String fp_url) {
        this.fp_url = fp_url;
    }
}
