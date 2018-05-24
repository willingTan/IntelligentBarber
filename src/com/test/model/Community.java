package com.test.model;

public class Community {
    int content_id;
    int user_id;
    String user_name;
    int type;
    int down;
    int up;
    String content;
    String communityimageurl;

    public Community(){}

    public Community(int content_id,int user_id,String user_name, int type,int up,int down,String content,String communityimageurl){
        this.user_id=user_id;
        this.user_name=user_name;
        this.type=type;
        this.up=up;
        this.down=down;
        this.content=content;
        this.content_id=content_id;
        this.communityimageurl=communityimageurl;
    }

    public int getContent_id() {
        return content_id;
    }

    public void setContent_id(int content_id) {
        this.content_id = content_id;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
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

    public int getDown() {
        return down;
    }

    public void setDown(int down) {
        this.down = down;
    }

    public int getUp() {
        return up;
    }

    public void setUp(int up) {
        this.up = up;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCommunityimageurl() {
        return communityimageurl;
    }

    public void setCommunityimageurl(String communityimageurl) {
        this.communityimageurl = communityimageurl;
    }

}
