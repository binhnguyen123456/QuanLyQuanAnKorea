/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package POJO;

/**
 *
 * @author Dell
 */
public class KhachHangPOJO1 {

    private String MaKH;
    private String TenKH;
    private String NgaySinh;
    private boolean GioiTinh;
    private String SDT;
    private String DiaChi;
    private String MaLKH;

    public KhachHangPOJO1(String MaKH, String TenKH, String NgaySinh, boolean GioiTinh, String SDT, String DiaChi, String MaLKH) {
        this.MaKH = MaKH;
        this.TenKH = TenKH;
        this.NgaySinh = NgaySinh;
        this.GioiTinh = GioiTinh;
        this.SDT = SDT;
        this.DiaChi = DiaChi;
        this.MaLKH = MaLKH;
    }

    public String getMaKH() {
        return MaKH;
    }

    public void setMaKH(String MaKH) {
        this.MaKH = MaKH;
    }

    public String getTenKH() {
        return TenKH;
    }

    public void setTenKH(String TenKH) {
        this.TenKH = TenKH;
    }

    public String getNgaySinh() {
        return NgaySinh;
    }

    public void setNgaySinh(String NgaySinh) {
        this.NgaySinh = NgaySinh;
    }

    public boolean isGioiTinh() {
        return GioiTinh;
    }

    public void setGioiTinh(boolean GioiTinh) {
        this.GioiTinh = GioiTinh;
    }

    public String getSDT() {
        return SDT;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

    public String getDiaChi() {
        return DiaChi;
    }

    public void setDiaChi(String DiaChi) {
        this.DiaChi = DiaChi;
    }

    public String getMaLKH() {
        return MaLKH;
    }

    public void setMaLKH(String MaLKH) {
        this.MaLKH = MaLKH;
    }

}
