package com.test.model;

public class HairPhotos {
    int hp_id;
    int hp_type;
    String hp_url;

    public HairPhotos(int hp_id,int hp_type,String hp_url) {
        this.hp_id = hp_id;
        this.hp_type = hp_type;
        this.hp_url = hp_url;
    }
    public int getHp_id() {
        return hp_id;
    }

    public void setHp_id(int hp_id) {
        this.hp_id = hp_id;
    }

    public int getHp_type() {
        return hp_type;
    }

    public void setHp_type(int hp_type) {
        this.hp_type = hp_type;
    }

    public String getHp_url() {
        return hp_url;
    }

    public void setHp_url(String hp_url) {
        this.hp_url = hp_url;
    }
}
