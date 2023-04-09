package com.sinhvien.orderdrinkapp.DTO;

public class LuongDTO {
    private int maLuong;
    private int luongThuong;
    private int luongPhat;
    private int soGio;
    private String ngayThang;
    private int maNhanvien;

    public LuongDTO() {
    }

    public LuongDTO(int luongThuong, int luongPhat, int soGio, String ngayThang, int maNhanvien) {
        this.luongThuong = luongThuong;
        this.luongPhat = luongPhat;
        this.soGio = soGio;
        this.ngayThang = ngayThang;
        this.maNhanvien = maNhanvien;
    }

    public LuongDTO(int maLuong, int luongThuong, int luongPhat, int soGio, String ngayThang) {
        this.maLuong = maLuong;
        this.luongThuong = luongThuong;
        this.luongPhat = luongPhat;
        this.soGio = soGio;
        this.ngayThang = ngayThang;
    }


    public int getMaLuong() {
        return maLuong;
    }

    public void setMaLuong(int maLuong) {
        this.maLuong = maLuong;
    }

    public int getLuongThuong() {
        return luongThuong;
    }

    public void setLuongThuong(int luongThuong) {
        this.luongThuong = luongThuong;
    }

    public int getLuongPhat() {
        return luongPhat;
    }

    public void setLuongPhat(int luongPhat) {
        this.luongPhat = luongPhat;
    }

    public int getSoGio() {
        return soGio;
    }

    public void setSoGio(int soGio) {
        this.soGio = soGio;
    }

    public String getNgayThang() {
        return ngayThang;
    }

    public void setNgayThang(String ngayThang) {
        this.ngayThang = ngayThang;
    }

    public int getMaNhanvien() {
        return maNhanvien;
    }

    public void setMaNhanvien(int maNhanvien) {
        this.maNhanvien = maNhanvien;
    }
}
