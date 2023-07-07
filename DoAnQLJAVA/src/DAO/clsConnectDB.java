/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

/**
 *
 * @author Dell
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Windows 10 Version 2
 */
public class clsConnectDB {

    public Connection connection = null;
    Statement statement = null;
    ResultSet resultset = null;

    public clsConnectDB() {
        open();
    }

    public void open() {
        String strServer = "DESKTOP-IS0QQ33";
        String strDatabase = "QuanLyQuanAnKorea";
        String strUser = "sa";
        String strPassword = "123";
        String strDriver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
        try {
            Class.forName(strDriver);
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }

        String connectionURL = "jdbc:sqlserver://" + strServer
                + ":1433;databaseName=" + strDatabase
                + ";user=" + strUser
                + ";password=" + strPassword
                + ";encrypt=true;trustServerCertificate=true";

        try {
            connection = (Connection) DriverManager.getConnection(connectionURL);
            if (connection != null) {
                System.out.println("Ket noi thanh cong!!");
            } else {
                System.out.println("Ket noi that bai");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void close() {
        try {
            this.connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(clsConnectDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ResultSet executeQuery(String sql) {
        ResultSet rs = null;
        try {
            Statement sm = connection.createStatement();
            rs = sm.executeQuery(sql);
        } catch (SQLException e) {
        }
        return rs;
    }

    public int executeUpdate(String sql) {
        int n = -1;
        try {
            Statement sm = connection.createStatement();
            n = sm.executeUpdate(sql);
        } catch (SQLException e) {
        }
        return n;
    }

    public ResultSet ExcuteQueryGetTable(String cauTruyVanSQL) {
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(cauTruyVanSQL);
            return rs;
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }

        return null;
    }

    public void ExcuteQueryUpdateDB(String cauTruyVanSQL) {

        try {
            Statement stmt = connection.createStatement();
            stmt.executeUpdate(cauTruyVanSQL);
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
    }

    public static void main(String[] args) {
        new clsConnectDB();
    }

    public ResultSet GetDataNhanVien(String tbl_NhanVien) throws SQLException {
        ResultSet kq = null;
        Statement st = connection.createStatement();
        String sql = " SELECT * FROM NHANVIEN";
        kq = st.executeQuery(sql);
        return kq;
    }

    public ResultSet GetDataMonAn(String tbl_MonAn) throws SQLException {
        ResultSet kq = null;
        Statement st = connection.createStatement();
        String sql = " SELECT * FROM MONAN";
        kq = st.executeQuery(sql);
        return kq;
    }

    public ResultSet GetDataKH(String tbl_KhachHang) throws SQLException {
        ResultSet kq = null;
        Statement st = connection.createStatement();
        String sql = " SELECT * FROM KHACHHANG";
        kq = st.executeQuery(sql);
        return kq;
    }

    public ResultSet GetDataHD(String tbl_HoaDon) throws SQLException {
        ResultSet kq = null;
        Statement st = connection.createStatement();
        String sql = " SELECT * FROM HOADON";
        kq = st.executeQuery(sql);
        return kq;
    }

    public ResultSet GetDataCTHD(String tbl_CTHD) throws SQLException {
        ResultSet kq = null;
        Statement st = connection.createStatement();
        String sql = " SELECT * FROM CHITIETHD";
        kq = st.executeQuery(sql);
        return kq;
    }

        public ResultSet GetDataMONAN(String tbl_SanPham) throws SQLException{
        ResultSet kq = null;
        Statement st = connection.createStatement();
        String sql = " SELECT * FROM MONAN";
        kq = st.executeQuery(sql);
        return kq;
    }
    public ResultSet GetDataHDMONAN(String tbl_DatHang) throws SQLException{
        ResultSet kq = null;
        Statement st = connection.createStatement();
        String sql = " select * from MONAN";
        kq = st.executeQuery(sql);
        return kq;
    }
}
