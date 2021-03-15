package com.example.rabbit_house;

import java.io.Serializable;

public class khach implements Serializable {
    private String Ten;
    private String sdt;

    public khach(String ten, String sdt) {
        Ten = ten;
        this.sdt = sdt;
    }

    public String getTen() {
        return Ten;
    }

    public String getSdt() {
        return sdt;
    }

    public void setTen(String ten) {
        Ten = ten;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    @Override
    public String toString() {
        return this.Ten + " - "+ this.sdt;
    }
}
