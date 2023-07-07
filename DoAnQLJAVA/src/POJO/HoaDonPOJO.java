/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package POJO;

/**
 *
 * @author Dell
 */
public class HoaDonPOJO {

    private String MaHD;
    private String MANV;
    private String MAKH;
    private String NGAYLAPHD;
    private String TONGTIEN;

    public HoaDonPOJO(String MaHD, String MANV, String MAKH, String NGAYLAPHD, String TONGTIEN) {
        this.MaHD = MaHD;
        this.MANV = MANV;
        this.MAKH = MAKH;
        this.NGAYLAPHD = NGAYLAPHD;
        this.TONGTIEN = TONGTIEN;
    }

    public String getMaHD() {
        return MaHD;
    }

    public void setMaHD(String MaHD) {
        this.MaHD = MaHD;
    }

    public String getMANV() {
        return MANV;
    }

    public void setMANV(String MANV) {
        this.MANV = MANV;
    }

    public String getMAKH() {
        return MAKH;
    }

    public void setMAKH(String MAKH) {
        this.MAKH = MAKH;
    }

    public String getNGAYLAPHD() {
        return NGAYLAPHD;
    }

    public void setNGAYLAPHD(String NGAYLAPHD) {
        this.NGAYLAPHD = NGAYLAPHD;
    }

    public String getTONGTIEN() {
        return TONGTIEN;
    }

    public void setTONGTIEN(String TONGTIEN) {
        this.TONGTIEN = TONGTIEN;
    }

}
