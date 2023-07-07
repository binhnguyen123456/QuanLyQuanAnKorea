package GUI;

import DAO.clsConnectDB;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author Dell
 */
public class MonAn extends javax.swing.JFrame {

    DefaultTableModel dtm = new DefaultTableModel();
    public PreparedStatement ps;
    public static ResultSet rs = null;
    public Statement st;
    clsConnectDB db = new clsConnectDB();

    /**
     * Creates new form ThucDOn
     */
    public MonAn() {
        initComponents();
        this.setLocationRelativeTo(null);
        db.open();
        disableJTEXT();
        LoadData();

    }

    private void LoadData() {
        clsConnectDB connection = new clsConnectDB();
        connection.open();
        try {
            rs = connection.GetDataMonAn("MONAN");
            tbl_MonAn.removeAll();
            String[] tieude = {"Mã món ăn", "Tên món ăn", "Số lượng", "Loại", "Đơn giá"};
            DefaultTableModel dtm = new DefaultTableModel(tieude, 0);
            while (rs.next()) {
                Vector vec = new Vector();
                vec.add(rs.getString("MAMONAN"));
                vec.add(rs.getString("TENMONAN"));
                vec.add(rs.getString("SOLUONG"));
                vec.add(rs.getString("MALOAIMONAN"));
                vec.add(rs.getFloat("DONGIA"));
                dtm.addRow(vec);
                tbl_MonAn.setModel(dtm);

            }
            tbl_MonAn.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
                @Override
                public void valueChanged(ListSelectionEvent e) {
                    if (tbl_MonAn.getSelectedRow() >= 0) {
                        txt_MaMon.setText(tbl_MonAn.getValueAt(tbl_MonAn.getSelectedRow(), 0) + "");
                        txt_TenMon.setText(tbl_MonAn.getValueAt(tbl_MonAn.getSelectedRow(), 1) + "");
                        txt_SoLuongMonAn.setText(tbl_MonAn.getValueAt(tbl_MonAn.getSelectedRow(), 2) + "");
                        cbo_Loai.setSelectedItem(tbl_MonAn.getValueAt(tbl_MonAn.getSelectedRow(), 3) + "");
                        txt_DonGia.setText(tbl_MonAn.getValueAt(tbl_MonAn.getSelectedRow(), 4) + "");

                    }
                }
            });

        } catch (SQLException ex) {

        }
    }

    public void loadCombobox() {

        try {
            db.open();
            ps = db.connection.prepareStatement("SELECT MALOAIMONAN FROM MONAN GROUP BY MALOAIMONAN");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                cbo_Loai.addItem(rs.getString("MALOAIMONAN"));
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

    private boolean kiemTraMaTrung(String ma) {
        String sql = "select * from MONAN where MAMONAN = ?";
        try {
            ps = db.connection.prepareStatement(sql);
            ps.setString(1, txt_MaMon.getText());
            rs = ps.executeQuery();
            if (rs.next()) {
                return true;
            } else {
                return false;
            }

        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
        return false;
    }

    private void SearchMonAn(String str) {
        dtm = (DefaultTableModel) tbl_MonAn.getModel();
        TableRowSorter<DefaultTableModel> trs = new TableRowSorter(dtm);
        tbl_MonAn.setRowSorter(trs);
        trs.setRowFilter(RowFilter.regexFilter(str));
    }

// ĐÓNG DỮ LIỆU 
    private void disableJTEXT() {
        txt_MaMon.setEnabled(false);
        txt_TenMon.setEnabled(false);
        txt_SoLuongMonAn.setEnabled(false);
        cbo_Loai.setEnabled(false);
        txt_DonGia.setEnabled(false);

    }
// MỞ DỮ LIỆU 
    private void enableJText() {
        txt_MaMon.setEnabled(true);
        txt_TenMon.setEnabled(true);
        txt_SoLuongMonAn.setEnabled(true);
        cbo_Loai.setEnabled(true);
        txt_DonGia.setEnabled(true);

    }

    private void clearJtext() {
        txt_MaMon.setText("");
        txt_TenMon.setText("");
        txt_SoLuongMonAn.setText("");
        txt_DonGia.setText("");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Scroll = new javax.swing.JScrollPane();
        tbl_MonAn = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtSearch = new javax.swing.JTextField();
        btn_TimKiemMA = new javax.swing.JButton();
        btn_QuayLai = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        cbo_Loai = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txt_MaMon = new javax.swing.JTextField();
        txt_TenMon = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txt_DonGia = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txt_SoLuongMonAn = new javax.swing.JTextField();
        btn_LamMoi = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        btn_Them = new javax.swing.JButton();
        btn_Xoa = new javax.swing.JButton();
        btn_Sua = new javax.swing.JButton();
        btn_Luu = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 102, 102));

        Scroll.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Scroll.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        Scroll.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        Scroll.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        Scroll.setRowHeaderView(null);

        tbl_MonAn.setBackground(new java.awt.Color(204, 255, 204));
        tbl_MonAn.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Mã món", "Tên món", "Số lượng", "Loại", "Đơn giá"
            }
        ));
        tbl_MonAn.setRowSelectionAllowed(false);
        tbl_MonAn.setShowGrid(true);
        Scroll.setViewportView(tbl_MonAn);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 26)); // NOI18N
        jLabel1.setText("QUẢN LÝ MÓN ĂN");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Tìm kiếm:");

        txtSearch.setPreferredSize(new java.awt.Dimension(104, 27));

        btn_TimKiemMA.setText("Tìm Kiếm");
        btn_TimKiemMA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_TimKiemMAActionPerformed(evt);
            }
        });

        btn_QuayLai.setBackground(new java.awt.Color(0, 255, 0));
        btn_QuayLai.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_QuayLai.setText("Quay lại");
        btn_QuayLai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_QuayLaiActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(204, 255, 204));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thông tin món ăn", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 2, 14))); // NOI18N

        cbo_Loai.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "L01", "L02", "L03", "L04", "L05", " " }));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setText("Số lượng:");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Mã món:");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("Tên món:");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setText("Giá thành:");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setText("Loại món ăn:");

        btn_LamMoi.setBackground(new java.awt.Color(204, 255, 204));
        btn_LamMoi.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_LamMoi.setIcon(new javax.swing.ImageIcon("E:\\LAMMOI.png")); // NOI18N
        btn_LamMoi.setBorder(null);
        btn_LamMoi.setPreferredSize(new java.awt.Dimension(84, 27));
        btn_LamMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_LamMoiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_SoLuongMonAn))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_TenMon, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(30, 30, 30)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txt_MaMon)
                            .addComponent(txt_DonGia, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(199, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbo_Loai, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_LamMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txt_TenMon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(txt_DonGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(cbo_Loai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txt_SoLuongMonAn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(txt_MaMon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_LamMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
        );

        jPanel2.setBackground(new java.awt.Color(204, 255, 204));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Chức năng", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 2, 14))); // NOI18N

        btn_Them.setBackground(new java.awt.Color(204, 255, 153));
        btn_Them.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_Them.setText("Thêm");
        btn_Them.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ThemActionPerformed(evt);
            }
        });

        btn_Xoa.setBackground(new java.awt.Color(255, 153, 153));
        btn_Xoa.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_Xoa.setText("Xóa");
        btn_Xoa.setPreferredSize(new java.awt.Dimension(84, 27));
        btn_Xoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_XoaActionPerformed(evt);
            }
        });

        btn_Sua.setBackground(new java.awt.Color(153, 153, 255));
        btn_Sua.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btn_Sua.setText("Sửa");
        btn_Sua.setPreferredSize(new java.awt.Dimension(84, 27));
        btn_Sua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_SuaActionPerformed(evt);
            }
        });

        btn_Luu.setBackground(new java.awt.Color(153, 153, 0));
        btn_Luu.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_Luu.setText("Lưu");
        btn_Luu.setPreferredSize(new java.awt.Dimension(84, 27));
        btn_Luu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_LuuActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_Them, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_Sua, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btn_Xoa, javax.swing.GroupLayout.DEFAULT_SIZE, 133, Short.MAX_VALUE)
                    .addComponent(btn_Luu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(40, 40, 40))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_Them)
                    .addComponent(btn_Xoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_Sua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_Luu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(41, 41, 41))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(btn_QuayLai, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(327, 327, 327)
                        .addComponent(jLabel1)))
                .addContainerGap(18, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_TimKiemMA)
                .addGap(326, 326, 326))
            .addComponent(Scroll)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_QuayLai, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_TimKiemMA)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Scroll, javax.swing.GroupLayout.DEFAULT_SIZE, 219, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_ThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ThemActionPerformed
        enableJText();
        clearJtext();
    }//GEN-LAST:event_btn_ThemActionPerformed

    private void btn_XoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_XoaActionPerformed
        try {
            db.open();
            ps = db.connection.prepareStatement("DELETE MONAN WHERE MAMONAN=?");
            ps.setString(1, tbl_MonAn.getValueAt(tbl_MonAn.getSelectedRow(), 0).toString());
            if (JOptionPane.showConfirmDialog(this, "Bạn có muốn xóa dòng ???", "Confirm",
                    JOptionPane.YES_NO_CANCEL_OPTION) == JOptionPane.YES_OPTION) {
                ps.executeUpdate();
                dtm.setRowCount(0);
                LoadData();
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        clearJtext();
    }//GEN-LAST:event_btn_XoaActionPerformed

    private void btn_SuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_SuaActionPerformed
        if (txt_MaMon.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn dòng cần sửa !!!");
            txt_MaMon.requestFocus();
            return;
        } else {
            enableJText();
        }

    }//GEN-LAST:event_btn_SuaActionPerformed

    private void btn_TimKiemMAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_TimKiemMAActionPerformed
        String timkiem = txtSearch.getText();
        SearchMonAn(timkiem);
    }//GEN-LAST:event_btn_TimKiemMAActionPerformed

    private void btn_QuayLaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_QuayLaiActionPerformed
        new TrangChu().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btn_QuayLaiActionPerformed

    private void btn_LuuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_LuuActionPerformed
        if (txt_MaMon.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Mã không được để trống!!");
            txt_MaMon.requestFocus();
            return;
        }
        //Mã trùng

        if (kiemTraMaTrung(txt_MaMon.getText()) == true) {
            int n = JOptionPane.showConfirmDialog(this, "Mã đã tồn tại!! Bạn có muốn cập nhật dữ liệu??", "Thông báo!!", JOptionPane.YES_NO_OPTION);
            if (n == JOptionPane.NO_OPTION) {
                return;
            } else {
                try {
                    db.open();
                    String sqlUpdate = "update MONAN set TENMONAN=?, SOLUONG=?, MALOAIMONAN=?, DONGIA=? WHERE MAMONAN=?";
                    ps = db.connection.prepareStatement(sqlUpdate);
                    ps.setString(1, txt_TenMon.getText());
                    ps.setString(2, txt_SoLuongMonAn.getText());
                    ps.setString(3, cbo_Loai.getSelectedItem().toString());
                    ps.setString(4, txt_DonGia.getText());
                    ps.setString(5, txt_MaMon.getText());
                    int x = ps.executeUpdate();
                    if (x > 0) {
                        JOptionPane.showMessageDialog(this, "Cập nhật thành công!!");
                        LoadData();
                    }
                } catch (SQLException ex) {
                    System.out.println(ex.toString());
                }

            }
        } else {
            String sql = "insert into MONAN values(?,?,?,?,?)";
            try {
                ps = db.connection.prepareStatement(sql);
                ps.setString(1, txt_MaMon.getText());
                ps.setString(2, txt_TenMon.getText());
                ps.setString(3, txt_SoLuongMonAn.getText());
                ps.setString(4, cbo_Loai.getSelectedItem().toString());
                ps.setString(5, txt_DonGia.getText());

                int x = ps.executeUpdate();
                if (x > 0) {
                    JOptionPane.showMessageDialog(this, "Thêm thành công!!");
                    LoadData();
                }
            } catch (SQLException ex) {
                System.out.println(ex.toString());
            }
        }
        disableJTEXT();
    }//GEN-LAST:event_btn_LuuActionPerformed

    private void btn_LamMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_LamMoiActionPerformed
        clearJtext();
        enableJText();
    }//GEN-LAST:event_btn_LamMoiActionPerformed

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
            java.util.logging.Logger.getLogger(MonAn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MonAn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MonAn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MonAn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MonAn().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane Scroll;
    private javax.swing.JButton btn_LamMoi;
    private javax.swing.JButton btn_Luu;
    private javax.swing.JButton btn_QuayLai;
    private javax.swing.JButton btn_Sua;
    private javax.swing.JButton btn_Them;
    private javax.swing.JButton btn_TimKiemMA;
    private javax.swing.JButton btn_Xoa;
    private javax.swing.JComboBox<String> cbo_Loai;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTable tbl_MonAn;
    private javax.swing.JTextField txtSearch;
    private javax.swing.JTextField txt_DonGia;
    private javax.swing.JTextField txt_MaMon;
    private javax.swing.JTextField txt_SoLuongMonAn;
    private javax.swing.JTextField txt_TenMon;
    // End of variables declaration//GEN-END:variables
}
