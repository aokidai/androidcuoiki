package com.example.rabbit_house;

import java.io.Serializable;

public class banhang implements Serializable {
    private String TenMon;
    private String Gia;
    private String Ngay;
    public banhang(String TenMon,String Ngay)
    {
        this.TenMon=TenMon;

        this.Ngay=Ngay;
    }
    public  banhang(){

    }
    public String getTenMon() {
        return TenMon;
    }

    public String getGia() {
        return Gia;
    }

    public String getNgay() {
        return Ngay;
    }

    public void setTenMon(String tenMon) {
        TenMon = tenMon;
    }

    public void setGia(String gia) {
        Gia = gia;
    }

    public void setNgay(String ngay) {
        Ngay = ngay;
    }

    @Override
    public String toString() {
        return this.TenMon + " "+this.Ngay;
    }
}
