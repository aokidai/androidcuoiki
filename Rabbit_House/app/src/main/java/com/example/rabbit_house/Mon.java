package com.example.rabbit_house;

import java.io.Serializable;

public class Mon implements Serializable {
    private String loai;
    private String name;

    public Mon(String loai, String name) {
        this.loai = loai;
        this.name = name;
    }

    public String getLoai() {
        return loai;
    }

    public void setLoai(String loai) {
        this.loai = loai;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
      return this.loai + " - "+ this.name;
    }
}
