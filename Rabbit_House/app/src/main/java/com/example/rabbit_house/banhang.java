package com.example.rabbit_house;

import java.io.Serializable;

public class banhang implements Serializable {
    private String TenMon;
    private String ten;
    private String Ngay;

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getTen() {
        return ten;
    }

    public banhang(String TenMon, String Ngay, String ten)
    {
        this.TenMon=TenMon;
        this.ten=ten;
        this.Ngay=Ngay;
    }
    public  banhang(){

    }
    public String getTenMon() {
        return TenMon;
    }



    public String getNgay() {
        return Ngay;
    }

    public void setTenMon(String tenMon) {
        TenMon = tenMon;
    }

    public void setNgay(String ngay) {
        Ngay = ngay;
    }

    @Override
    public String toString() {
        return this.TenMon + " "+this.Ngay+ " "+this.ten;
    }
}
