package com.example.ph13373;

public class SinhVien extends Lop{
    private String tenSV;
    private String ngaySinh;


    public SinhVien() {
    }

    public SinhVien(String maLop, String tenLop, String tenSV, String ngaySinh) {
        super(maLop, tenLop);
        this.tenSV = tenSV;
        this.ngaySinh = ngaySinh;
    }

    public String getTenSV() {
        return tenSV;
    }

    public void setTenSV(String tenSV) {
        this.tenSV = tenSV;
    }

    public String getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(String ngaySinh) {
        this.ngaySinh = ngaySinh;
    }
}
