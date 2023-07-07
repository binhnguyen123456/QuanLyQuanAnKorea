/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;

import DAO.clsConnectDB;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Dell
 */
public class ThongKe extends javax.swing.JFrame {

    clsConnectDB db = new clsConnectDB();
    private DefaultTableModel df;

    public ThongKe() {
        initComponents();
        this.setLocationRelativeTo(null);
        df = (DefaultTableModel) tbl_ThongKe.getModel();
        thongkeTB();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        grRda_timkiem = new javax.swing.ButtonGroup();
        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        rdaTenNV = new javax.swing.JRadioButton();
        rdaNgay = new javax.swing.JRadioButton();
        txtTimKiem = new javax.swing.JTextField();
        rdaTenKH = new javax.swing.JRadioButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_ThongKe = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jlbTongTien = new javax.swing.JLabel();
        btn_QuayLai = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel1.setText("THỐNG KÊ DOANH THU");

        grRda_timkiem.add(rdaTenNV);
        rdaTenNV.setText("Tên nhân viên");

        grRda_timkiem.add(rdaNgay);
        rdaNgay.setText("Ngày");

        txtTimKiem.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTimKiemKeyReleased(evt);
            }
        });

        grRda_timkiem.add(rdaTenKH);
        rdaTenKH.setText("Tên Khách Hàng");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(218, 218, 218)
                        .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 422, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(210, 210, 210)
                        .addComponent(rdaTenNV)
                        .addGap(79, 79, 79)
                        .addComponent(rdaNgay, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(69, 69, 69)
                        .addComponent(rdaTenKH)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rdaTenNV)
                    .addComponent(rdaNgay)
                    .addComponent(rdaTenKH))
                .addGap(24, 24, 24)
                .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        tbl_ThongKe.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Mã hóa đơn", "Khách hàng", "Nhân viên", "Ngày lập hóa đơn", "Tổng tiền"
            }
        ));
        jScrollPane1.setViewportView(tbl_ThongKe);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setText("TỔNG DANH THU: ");

        jlbTongTien.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jlbTongTien.setText("0");

        btn_QuayLai.setBackground(new java.awt.Color(102, 255, 0));
        btn_QuayLai.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_QuayLai.setText("Quay lại");
        btn_QuayLai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_QuayLaiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btn_QuayLai, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(113, 113, 113)
                        .addComponent(jLabel1)
                        .addGap(0, 248, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(184, 184, 184)
                .addComponent(jLabel2)
                .addGap(40, 40, 40)
                .addComponent(jlbTongTien)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(btn_QuayLai, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jlbTongTien))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtTimKiemKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTimKiemKeyReleased
        txtTimKiem.getText().trim();
        thongkeTB();
    }//GEN-LAST:event_txtTimKiemKeyReleased

    private void btn_QuayLaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_QuayLaiActionPerformed
        new TrangChu().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btn_QuayLaiActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ThongKe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ThongKe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ThongKe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ThongKe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ThongKe().setVisible(true);
            }
        });
    }

    private void thongkeTB() {
        df.setRowCount(0);
        int tongtien = 0;
        String whereTK = " ";
        if (rdaTenNV.isSelected()) {
            whereTK = " and TenNV like N'%" + txtTimKiem.getText() + "%'";
        } else if (rdaTenKH.isSelected()) {
            whereTK = " and TenKH like N'%" + txtTimKiem.getText() + "%'";
        } else if (rdaNgay.isSelected()) {
            whereTK = " and NgayLapHD= '" + txtTimKiem.getText() + "'";
        }

        String cautruyvan = "set dateformat dmy select Mahd,KhachHang.TenKH "
                + "as TenKH,NhanVien.TenNv,TongTien,NgayLapHd "
                + "from HoaDon,KhachHang,NhanVien  "
                + "where HoaDon.MaKh =KhachHang.MaKh "
                + "and HoaDon.Manv=NhanVien.MANV  "
                + whereTK;
        String tv = cautruyvan;

        ResultSet rs = db.ExcuteQueryGetTable(tv);
        String[] tieude = {"Mã hóa đơn", "Khách Hàng ", "Nhân viên", "Ngày lập hóa dơn", "tổng tiền"};
        DefaultTableModel tableModel = new DefaultTableModel(tieude, 0);
        tbl_ThongKe.setModel(tableModel);
        try {
            while (rs.next()) {
                Object[] item = new Object[5];
                tongtien = tongtien + rs.getInt("TongTien");
                item[0] = rs.getString("MaHd");
                item[1] = rs.getString("TenKH");
                item[2] = rs.getString("TenNV");
                item[3] = rs.getString("NgayLapHD");
                item[4] = rs.getInt("TongTien");
                tableModel.addRow(item);
            }
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
        jlbTongTien.setText(String.valueOf(tongtien));
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_QuayLai;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup grRda_timkiem;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel jlbTongTien;
    private javax.swing.JRadioButton rdaNgay;
    private javax.swing.JRadioButton rdaTenKH;
    private javax.swing.JRadioButton rdaTenNV;
    private javax.swing.JTable tbl_ThongKe;
    private javax.swing.JTextField txtTimKiem;
    // End of variables declaration//GEN-END:variables

//    
}
