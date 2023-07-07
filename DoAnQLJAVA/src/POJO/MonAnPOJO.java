/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package POJO;

/**
 *
 * @author Dell
 */
public class MonAnPOJO {

    private String MAMONAN;
    private String TENMONAN;
    private int SOLUONG;
    private String MALOAIMONAN;


    public MonAnPOJO(String MAMONAN, String TENMONAN, int SOLUONG, String MALOAIMONAN) {
        this.MAMONAN = MAMONAN;
        this.TENMONAN = TENMONAN;
        this.SOLUONG = SOLUONG;
        this.MALOAIMONAN = MALOAIMONAN;
    }
    public String getMAMONAN() {
        return MAMONAN;
    }

    public void setMAMONAN(String MAMONAN) {
        this.MAMONAN = MAMONAN;
    }

    public String getTENMONAN() {
        return TENMONAN;
    }

    public void setTENMONAN(String TENMONAN) {
        this.TENMONAN = TENMONAN;
    }

    public int getSOLUONG() {
        return SOLUONG;
    }

    public void setNgaySinh(int SOLUONG) {
        this.SOLUONG = SOLUONG;
    }

    public String getMALOAIMONAN() {
        return MALOAIMONAN;
    }

    public void setMALOAIMONAN(String MALOAIMONAN) {
        this.MALOAIMONAN = MALOAIMONAN;
    }

}
