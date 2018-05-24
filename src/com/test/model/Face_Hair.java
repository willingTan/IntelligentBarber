package com.test.model;

public class Face_Hair {
    int identified_id;
    int fp_id;
    String hp_url;
    int love;
    int hate;
    String description;

    public Face_Hair(){}

    public Face_Hair(int identified_id,int hp_id,String hp_url,int love,int hate,String description){
        this.identified_id=identified_id;
        this.fp_id=hp_id;
        this.hp_url=hp_url;
        this.love=love;
        this.hate=hate;
        this.description=description;
    }

    public int getIdentified_id() {
        return identified_id;
    }

    public void setIdentified_id(int identified_id) {
        this.identified_id = identified_id;
    }

    public String getHp_url() {
        return hp_url;
    }

    public void setHp_url(String hp_url) {
        this.hp_url = hp_url;
    }

    public int getLove() {
        return love;
    }

    public void setLove(int love) {
        this.love = love;
    }

    public int getHate() {
        return hate;
    }

    public void setHate(int hate) {
        this.hate = hate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getFp_id() {
        return fp_id;
    }

    public void setFp_id(int hp_id) {
        this.fp_id = hp_id;
    }

}
