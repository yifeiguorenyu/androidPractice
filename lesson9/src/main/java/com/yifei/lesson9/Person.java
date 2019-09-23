package com.yifei.lesson9;

import java.io.Serializable;

public class Person implements Serializable {
    private String name;
    private String num;
    private int imgId;

    public Person(String name, String num, int imgId) {
        this.name = name;
        this.num = num;
        this.imgId = imgId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public int getImgId() {
        return imgId;
    }

    public void setImgId(int imgId) {
        this.imgId = imgId;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", num='" + num + '\'' +
                ", imgId=" + imgId +
                '}';
    }
}
