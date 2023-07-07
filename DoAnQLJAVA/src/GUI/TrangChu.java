/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;

import CUSTOM.Auth;
import javax.swing.JOptionPane;

/**
 *
 * @author Dell
 */
public class TrangChu extends javax.swing.JFrame {

    /**
     * Creates new form TrangChu
     */
    public TrangChu() {
        initComponents();
        this.setLocationRelativeTo(null);
        phanQuyen();
    }

    void phanQuyen() {

        if (Auth.getNv().getMaCV().equals("NV")) {
            btn_QLNV.setVisible(false);
            btn_QLKH.setVisible(false);
            btn_QLMA.setVisible(false);
            
        } else {
            
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jRadioButtonMenuItem1 = new javax.swing.JRadioButtonMenuItem();
        btn_DatHang = new javax.swing.JPanel();
        btn_QLNV = new javax.swing.JButton();
        btn_QLKH = new javax.swing.JButton();
        btn_QLMA = new javax.swing.JButton();
        btn_THD = new javax.swing.JButton();
        btn_DangXuat = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        btn_QLDH = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();

        jRadioButtonMenuItem1.setSelected(true);
        jRadioButtonMenuItem1.setText("jRadioButtonMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btn_DatHang.setBackground(new java.awt.Color(204, 255, 204));

        btn_QLNV.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGE/nhanvienn.png"))); // NOI18N
        btn_QLNV.setText("QUẢN LÝ NHÂN VIÊN");
        btn_QLNV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_QLNVActionPerformed(evt);
            }
        });

        btn_QLKH.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGE/khachhang.png"))); // NOI18N
        btn_QLKH.setText("QUẢN LÝ KHÁCH HÀNG");
        btn_QLKH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_QLKHActionPerformed(evt);
            }
        });

        btn_QLMA.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGE/food.png"))); // NOI18N
        btn_QLMA.setText("QUẢN LÝ MÓN ĂN");
        btn_QLMA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_QLMAActionPerformed(evt);
            }
        });

        btn_THD.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGE/tao.png"))); // NOI18N
        btn_THD.setText("TẠO HÓA ĐƠN");
        btn_THD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_THDActionPerformed(evt);
            }
        });

        btn_DangXuat.setBackground(new java.awt.Color(255, 102, 102));
        btn_DangXuat.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_DangXuat.setText("Đăng xuất");
        btn_DangXuat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_DangXuatActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Dosis", 1, 48)); // NOI18N
        jLabel2.setText("Hanuri Hàn Quốc");

        btn_QLDH.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGE/dathang.png"))); // NOI18N
        btn_QLDH.setText("ĐẶT HÀNG");
        btn_QLDH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_QLDHActionPerformed(evt);
            }
        });

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGE/thongke.png"))); // NOI18N
        jButton2.setText("Thống kê hóa đơn");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon("E:\\imager_3_54539_700.jpg")); // NOI18N

        javax.swing.GroupLayout btn_DatHangLayout = new javax.swing.GroupLayout(btn_DatHang);
        btn_DatHang.setLayout(btn_DatHangLayout);
        btn_DatHangLayout.setHorizontalGroup(
            btn_DatHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_DatHangLayout.createSequentialGroup()
                .addComponent(btn_DangXuat, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(300, 300, 300)
                .addComponent(jLabel2)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(btn_DatHangLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(btn_DatHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(btn_DatHangLayout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(btn_DatHangLayout.createSequentialGroup()
                        .addComponent(btn_QLNV)
                        .addGap(18, 18, 18)
                        .addComponent(btn_QLKH)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                        .addComponent(btn_QLMA)
                        .addGap(18, 18, 18)
                        .addComponent(btn_QLDH, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton2)
                        .addGap(18, 18, 18)
                        .addComponent(btn_THD)
                        .addGap(33, 33, 33))))
        );
        btn_DatHangLayout.setVerticalGroup(
            btn_DatHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btn_DatHangLayout.createSequentialGroup()
                .addGroup(btn_DatHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(btn_DatHangLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btn_DangXuat, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(btn_DatHangLayout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jLabel2)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addGroup(btn_DatHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_QLNV)
                    .addComponent(btn_QLKH)
                    .addComponent(btn_QLMA)
                    .addComponent(btn_QLDH)
                    .addComponent(jButton2)
                    .addComponent(btn_THD))
                .addGap(30, 30, 30)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 789, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btn_DatHang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(btn_DatHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 14, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_QLNVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_QLNVActionPerformed
        new frmNhanVien().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btn_QLNVActionPerformed

    private void btn_QLKHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_QLKHActionPerformed
        new KhachHang().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btn_QLKHActionPerformed

    private void btn_QLMAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_QLMAActionPerformed
        new MonAn().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btn_QLMAActionPerformed

    private void btn_THDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_THDActionPerformed

    }//GEN-LAST:event_btn_THDActionPerformed

    private void btn_DangXuatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_DangXuatActionPerformed
        int n = JOptionPane.showConfirmDialog(this, "Bạn có muốn đăng xuất", "Thông báo!!", JOptionPane.YES_NO_OPTION);
        if (n == JOptionPane.NO_OPTION) {
            return;
        }
        new DangNhap().setVisible(true);
        this.setVisible(false);

    }//GEN-LAST:event_btn_DangXuatActionPerformed

    private void btn_QLDHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_QLDHActionPerformed
        new DatHang().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btn_QLDHActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        new ThongKe().setVisible(true);
        this.setVisible(false);        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(TrangChu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TrangChu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TrangChu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TrangChu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TrangChu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_DangXuat;
    private javax.swing.JPanel btn_DatHang;
    private javax.swing.JButton btn_QLDH;
    private javax.swing.JButton btn_QLKH;
    private javax.swing.JButton btn_QLMA;
    private javax.swing.JButton btn_QLNV;
    private javax.swing.JButton btn_THD;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JRadioButtonMenuItem jRadioButtonMenuItem1;
    // End of variables declaration//GEN-END:variables
}
