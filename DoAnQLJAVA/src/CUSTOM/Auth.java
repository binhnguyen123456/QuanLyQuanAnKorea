/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CUSTOM;

import POJO.Nhanvien;

/**
 *
 * @author Dell
 */
public class Auth {
    static Nhanvien nv = new Nhanvien();

    public static Nhanvien getNv() {
        return nv;
    }

    public static void setNv(Nhanvien nv) {
        Auth.nv = nv;
    }
    // authen sử dụng toàn bộ project
}
