package com.example.tessthihii;

import java.io.Serializable;

public class SinhVien implements Serializable {
    private String MaSv,HoTen,Lop,DiaChi,Sdt;

    public String getMaSv() {
        return MaSv;
    }

    public void setMaSv(String maSv) {
        MaSv = maSv;
    }

    public String getHoTen() {
        return HoTen;
    }

    public void setHoTen(String hoTen) {
        HoTen = hoTen;
    }

    public String getLop() {
        return Lop;
    }

    public void setLop(String lop) {
        Lop = lop;
    }

    public String getDiaChi() {
        return DiaChi;
    }

    public void setDiaChi(String diaChi) {
        DiaChi = diaChi;
    }

    public String getSdt() {
        return Sdt;
    }

    public void setSdt(String sdt) {
        Sdt = sdt;
    }

    public SinhVien() {
    }

    public SinhVien(String maSv, String hoTen, String lop, String diaChi, String sdt) {
        MaSv = maSv;
        HoTen = hoTen;
        Lop = lop;
        DiaChi = diaChi;
        Sdt = sdt;
    }

    public SinhVien(String hoTen, String lop, String diaChi, String sdt) {
        HoTen = hoTen;
        Lop = lop;
        DiaChi = diaChi;
        Sdt = sdt;
    }

    @Override
    public String toString() {
        return "SinhVien{" +
                "MaSv='" + MaSv + '\'' +
                ", HoTen='" + HoTen + '\'' +
                ", Lop='" + Lop + '\'' +
                ", DiaChi='" + DiaChi + '\'' +
                ", Sdt='" + Sdt + '\'' +
                '}';
    }
}
