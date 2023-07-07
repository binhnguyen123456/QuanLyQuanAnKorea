package GUI;

import DAO.clsConnectDB;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import POJO.Nhanvien;

/**
 *
 * @author Dell
 */
public class frmNhanVien extends javax.swing.JFrame {

    DefaultTableModel dtm = new DefaultTableModel();
    public PreparedStatement ps;
    public static ResultSet rs = null;
    public Statement st;
    clsConnectDB db = new clsConnectDB();
    ArrayList<Nhanvien> list = new ArrayList<>();

    public frmNhanVien() {
        initComponents();
        db.open();
        LoadData();
        disableJTEXT();
        this.setLocationRelativeTo(null);

//        txt_MaNV.disable();
    }

    private void LoadData() {
        clsConnectDB connection = new clsConnectDB();
        connection.open();
        try {
            rs = connection.GetDataNhanVien("NHANVIEN");
            tbl_NhanVien.removeAll();
            String[] tieude = {"Mã nhân viên", "Tên nhân viên", "Ngày sinh", "Giới tính", "Số điện thoại", "Địa chỉ", "Ngày vào làm", "Mã chức vụ", "Mật khẩu cung cấp"};
            DefaultTableModel dtm = new DefaultTableModel(tieude, 0);
            while (rs.next()) {
                Vector vec = new Vector();
                vec.add(rs.getString("MANV"));
                vec.add(rs.getString("TENNV"));
                vec.add(rs.getString("NGAYSINH"));
                vec.add(rs.getString("GIOITINH"));
                vec.add(rs.getString("SDT"));
                vec.add(rs.getString("DIACHI"));
                vec.add(rs.getString("NGAYVAOLAM"));
                vec.add(rs.getString("MACV"));
                vec.add(rs.getString("MATKHAU"));
                dtm.addRow(vec);
                tbl_NhanVien.setModel(dtm);

            }
            tbl_NhanVien.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
                @Override
                public void valueChanged(ListSelectionEvent e) {
                    if (tbl_NhanVien.getSelectedRow() >= 0) {
                        txt_MaNV.setText(tbl_NhanVien.getValueAt(tbl_NhanVien.getSelectedRow(), 0) + "");
                        txt_TenNV.setText(tbl_NhanVien.getValueAt(tbl_NhanVien.getSelectedRow(), 1) + "");
                        txt_NgaySinh.setText(tbl_NhanVien.getValueAt(tbl_NhanVien.getSelectedRow(), 2) + "");
                        Boolean GioiTinh = (String.valueOf(tbl_NhanVien.getValueAt(tbl_NhanVien.getSelectedRow(), 3)) == "Nam") ? true : false;
                        String a = tbl_NhanVien.getValueAt(tbl_NhanVien.getSelectedRow(), 3).toString();
                        if (GioiTinh) {
                            rb_Nam.setSelected(true);
                        } else {
                            rb_Nu.setSelected(true);
                        }

                        txt_SDT.setText(tbl_NhanVien.getValueAt(tbl_NhanVien.getSelectedRow(), 4) + "");
                        txt_DiaChi.setText(tbl_NhanVien.getValueAt(tbl_NhanVien.getSelectedRow(), 5) + "");
                        txt_NgayVaoLam.setText(tbl_NhanVien.getValueAt(tbl_NhanVien.getSelectedRow(), 6) + "");
                        cbo_ChucVu.setSelectedItem(tbl_NhanVien.getValueAt(tbl_NhanVien.getSelectedRow(), 7) + "");
                        txt_MatKhau.setText(tbl_NhanVien.getValueAt(tbl_NhanVien.getSelectedRow(), 8) + "");
                    }
                }
            });

        } catch (SQLException ex) {

        }
    }

    public void loadCombobox() {

        try {
            db.open();
            ps = db.connection.prepareStatement("SELECT MACV FROM NHANVIEN GROUP BY MACV");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                cbo_ChucVu.addItem(rs.getString("MACV"));
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

    private boolean kiemTraMaTrung(String ma) {
        String sql = "select * from NHANVIEN where MANV = ?";
        try {
            ps = db.connection.prepareStatement(sql);
            ps.setString(1, txt_MaNV.getText());
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

    private void findNhanVienBySearch() {
        //Truy vấn rda
        dtm.setRowCount(0);
        String whereTK = " ";
        if (rdaTenNV.isSelected()) {
            whereTK = " TenNV like N'%" + txt_TimKiem.getText() + "%'";
        } else if (rdaNgaySinh.isSelected()) {
            whereTK = " NgaySinh= '" + txt_TimKiem.getText() + "'";
        }
        String cautruyvan = "select * from nhanvien where" + whereTK;
        String tv = cautruyvan;
        ResultSet rs = db.ExcuteQueryGetTable(tv);

        String[] tieude = {"Mã nhân viên", "Tên nhân viên", "Ngày sinh", "Giới tính", "Số điện thoại", "Địa chỉ", "Ngày vào làm", "Mã chức vụ", "Mật khẩu cung cấp"};
        DefaultTableModel dtm = new DefaultTableModel(tieude, 0);
        tbl_NhanVien.setModel(dtm);
        try {
            while (rs.next()) {
                Vector vec = new Vector();
                vec.add(rs.getString("MANV"));
                vec.add(rs.getString("TENNV"));
                vec.add(rs.getString("NGAYSINH"));
                vec.add(rs.getString("GIOITINH"));
                vec.add(rs.getString("SDT"));
                vec.add(rs.getString("DIACHI"));
                vec.add(rs.getString("NGAYVAOLAM"));
                vec.add(rs.getString("MACV"));
                vec.add(rs.getString("MATKHAU"));
                dtm.addRow(vec);

            }
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
    }

    private void disableJTEXT() {
        txt_MaNV.setEnabled(false);
        txt_TenNV.setEnabled(false);
        txt_NgaySinh.setEnabled(false);
        txt_SDT.setEnabled(false);
        txt_DiaChi.setEnabled(false);
        txt_NgayVaoLam.setEnabled(false);
        txt_MatKhau.setEnabled(false);
        cbo_ChucVu.setEnabled(false);
        rb_Nam.setEnabled(false);
        rb_Nu.setEnabled(false);
    }

    private void enableJText() {
        txt_MaNV.setEnabled(true);
        txt_TenNV.setEnabled(true);
        txt_NgaySinh.setEnabled(true);
        txt_SDT.setEnabled(true);
        txt_DiaChi.setEnabled(true);
        txt_NgayVaoLam.setEnabled(true);
        txt_MatKhau.setEnabled(true);
        cbo_ChucVu.setEnabled(true);
        rb_Nam.setEnabled(true);
        rb_Nu.setEnabled(true);
    }

    private void clearJtext() {
        txt_MaNV.setText("");
        txt_TenNV.setText("");
        txt_NgaySinh.setText("");
        txt_SDT.setText("");
        txt_DiaChi.setText("");
        txt_NgayVaoLam.setText("");
        txt_MatKhau.setText("");
        rda_GT.clearSelection();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        rda_GT = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        rb_Nam = new javax.swing.JRadioButton();
        jLabel4 = new javax.swing.JLabel();
        rb_Nu = new javax.swing.JRadioButton();
        jLabel6 = new javax.swing.JLabel();
        txt_MaNV = new javax.swing.JTextField();
        txt_TenNV = new javax.swing.JTextField();
        txt_SDT = new javax.swing.JTextField();
        txt_NgaySinh = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txt_DiaChi = new javax.swing.JTextField();
        cbo_ChucVu = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        txt_MatKhau = new javax.swing.JTextField();
        txt_NgayVaoLam = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        btn_LamMoi = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        btn_Sua = new javax.swing.JButton();
        btn_Them = new javax.swing.JButton();
        btn_Xoa = new javax.swing.JButton();
        btn_Luu = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        txt_TimKiem = new javax.swing.JTextField();
        btn_TimKiem = new javax.swing.JButton();
        rdaTenNV = new javax.swing.JRadioButton();
        rdaNgaySinh = new javax.swing.JRadioButton();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_NhanVien = new javax.swing.JTable();
        btn_QuayLai = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(153, 255, 153));

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thông tin nhân viên", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 2, 14))); // NOI18N
        jPanel1.setToolTipText("");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("Mã nhân viên");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Tên nhận viên");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Số điện thoại");

        rda_GT.add(rb_Nam);
        rb_Nam.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        rb_Nam.setText("Nam");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("Giới tính ");

        rda_GT.add(rb_Nu);
        rb_Nu.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        rb_Nu.setText("Nữ");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setText("Ngày sinh");

        txt_MaNV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_MaNVActionPerformed(evt);
            }
        });

        txt_NgaySinh.setHorizontalAlignment(javax.swing.JTextField.LEFT);

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setText("Địa chỉ");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setText("Chức vụ");

        txt_DiaChi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_DiaChiActionPerformed(evt);
            }
        });

        cbo_ChucVu.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "QL", "NV", " ", " " }));
        cbo_ChucVu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbo_ChucVuActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel11.setText("Ngày vào làm");

        txt_MatKhau.setHorizontalAlignment(javax.swing.JTextField.LEFT);

        txt_NgayVaoLam.setHorizontalAlignment(javax.swing.JTextField.LEFT);

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel12.setText("Mật khẩu cung cấp");

        btn_LamMoi.setBackground(new java.awt.Color(204, 204, 255));
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
                .addGap(60, 60, 60)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txt_SDT, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(txt_MaNV, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(txt_TenNV, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 77, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(28, 28, 28)
                        .addComponent(rb_Nam)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(rb_Nu))
                    .addComponent(jLabel6)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(26, 26, 26)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbo_ChucVu, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_NgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(56, 56, 56)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11)
                    .addComponent(jLabel7)
                    .addComponent(jLabel12))
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txt_MatKhau, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_LamMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_DiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_NgayVaoLam, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(40, 40, 40))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txt_MaNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(23, 23, 23)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txt_TenNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(21, 21, 21)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txt_SDT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8)
                            .addComponent(cbo_ChucVu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(rb_Nam)
                            .addComponent(rb_Nu))
                        .addGap(23, 23, 23)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txt_NgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_DiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_LamMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(42, 42, 42))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(txt_NgayVaoLam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_MatKhau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12))
                        .addGap(85, 85, 85))))
        );

        jPanel2.setBackground(new java.awt.Color(204, 204, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Chức năng", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 2, 14))); // NOI18N

        btn_Sua.setBackground(new java.awt.Color(153, 153, 255));
        btn_Sua.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_Sua.setText("Sửa");
        btn_Sua.setPreferredSize(new java.awt.Dimension(84, 27));
        btn_Sua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_SuaActionPerformed(evt);
            }
        });

        btn_Them.setBackground(new java.awt.Color(204, 255, 204));
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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(btn_Them, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_Xoa, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(90, 90, 90)
                .addComponent(btn_Sua, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(70, 70, 70)
                .addComponent(btn_Luu, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_Them)
                    .addComponent(btn_Xoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_Sua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_Luu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(50, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(204, 204, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tìm kiếm", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 2, 14))); // NOI18N
        jPanel3.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setText("Tìm kiếm nhân viên");

        txt_TimKiem.setPreferredSize(new java.awt.Dimension(104, 27));

        btn_TimKiem.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_TimKiem.setText("Tìm Kiếm");
        btn_TimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_TimKiemActionPerformed(evt);
            }
        });

        rdaTenNV.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        rdaTenNV.setText("Tên nhân viên");

        rdaNgaySinh.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        rdaNgaySinh.setText("Ngày sinh");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jLabel9)
                        .addGap(18, 18, 18)
                        .addComponent(txt_TimKiem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(btn_TimKiem))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(95, 95, 95)
                        .addComponent(rdaTenNV)
                        .addGap(95, 95, 95)
                        .addComponent(rdaNgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 88, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rdaNgaySinh)
                    .addComponent(rdaTenNV))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txt_TimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_TimKiem))
                .addGap(19, 19, 19))
        );

        jLabel10.setFont(new java.awt.Font("Times New Roman", 1, 26)); // NOI18N
        jLabel10.setText("QUẢN LÝ NHÂN VIÊN");

        tbl_NhanVien.setBackground(new java.awt.Color(204, 204, 255));
        tbl_NhanVien.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã nhân viên", "Tên nhân viên", "Ngày sinh", "Giới tính", "Số điện thoại", "Địa chỉ", "Ngày vào làm", "Mã chức vụ", "Mật khẩu cung cấp"
            }
        ));
        jScrollPane1.setViewportView(tbl_NhanVien);

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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btn_QuayLai, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(408, 408, 408)
                        .addComponent(jLabel10))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1306, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(15, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_QuayLai, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(11, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_TimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_TimKiemActionPerformed
        txt_TimKiem.getText().trim();
        findNhanVienBySearch();
    }//GEN-LAST:event_btn_TimKiemActionPerformed

    private void btn_XoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_XoaActionPerformed
        try {
            db.open();
            ps = db.connection.prepareStatement("DELETE NHANVIEN WHERE MANV=?");
            ps.setString(1, tbl_NhanVien.getValueAt(tbl_NhanVien.getSelectedRow(), 0).toString());
            if (JOptionPane.showConfirmDialog(this, "DELETE THIS NHANVIEN?", "Confirm",
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
        if (txt_MaNV.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn dòng cần sửa !!!");
            txt_MaNV.requestFocus();
            return;
        } else
        enableJText();
    }//GEN-LAST:event_btn_SuaActionPerformed

    private void btn_ThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ThemActionPerformed
        enableJText();
        clearJtext();
    }//GEN-LAST:event_btn_ThemActionPerformed

    private void cbo_ChucVuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbo_ChucVuActionPerformed
        
    }//GEN-LAST:event_cbo_ChucVuActionPerformed

    private void txt_MaNVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_MaNVActionPerformed

    }//GEN-LAST:event_txt_MaNVActionPerformed

    private void btn_QuayLaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_QuayLaiActionPerformed
        new TrangChu().setVisible(true);
        this.setVisible(false);

    }//GEN-LAST:event_btn_QuayLaiActionPerformed

    private void txt_DiaChiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_DiaChiActionPerformed

    }//GEN-LAST:event_txt_DiaChiActionPerformed

    private void btn_LuuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_LuuActionPerformed
        if (txt_MaNV.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Mã không được để trống!!");
            txt_MaNV.requestFocus();
            return;
        }
        //Mã trùng

        if (kiemTraMaTrung(txt_MaNV.getText()) == true) {
            int n = JOptionPane.showConfirmDialog(this, "Mã đã tồn tại!! Bạn có muốn cập nhật dữ liệu??", "Thông báo!!", JOptionPane.YES_NO_OPTION);
            if (n == JOptionPane.NO_OPTION) {
                return;
            } else {
                try {
                    db.open();
                    String sqlUpdate = "update NHANVIEN set TENNV=?, NGAYSINH=?, GIOITINH=?, SDT=?, DIACHI=?, NGAYVAOLAM=?, MACV=?, MATKHAU=? WHERE MANV=?";
                    ps = db.connection.prepareStatement(sqlUpdate);
                    ps.setString(1, txt_TenNV.getText());
                    ps.setString(2, txt_NgaySinh.getText());
                    String gt;
                    if (rb_Nam.isSelected()) {
                        gt = "Nam";
                        ps.setString(3, rb_Nam.getText());
                    } else {
                        gt = "Nữ";
                        ps.setString(3, rb_Nu.getText());
                    }
                    ps.setString(4, txt_SDT.getText());
                    ps.setString(5, txt_DiaChi.getText());
                    ps.setString(6, txt_NgayVaoLam.getText());
                    ps.setString(7, cbo_ChucVu.getSelectedItem().toString());
                    ps.setString(8, txt_MatKhau.getText());
                    ps.setString(9, txt_MaNV.getText());

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
            String sql = "insert into NHANVIEN values(?,?,?,?,?,?,?,?,?)";
            try {
                ps = db.connection.prepareStatement(sql);
                ps.setString(1, txt_MaNV.getText());
                ps.setString(2, txt_TenNV.getText());
                ps.setString(3, txt_NgaySinh.getText());
                String gt;
                if (rb_Nam.isSelected()) {
                    gt = "Nam";
                    ps.setString(4, rb_Nam.getText());
                } else {
                    gt = "Nữ";
                    ps.setString(4, rb_Nu.getText());
                }
                ps.setString(5, txt_SDT.getText());
                ps.setString(6, txt_DiaChi.getText());
                ps.setString(7, txt_NgayVaoLam.getText());
                ps.setString(8, cbo_ChucVu.getSelectedItem().toString());
                ps.setString(9, txt_MatKhau.getText());
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
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmNhanVien().setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_LamMoi;
    private javax.swing.JButton btn_Luu;
    private javax.swing.JButton btn_QuayLai;
    private javax.swing.JButton btn_Sua;
    private javax.swing.JButton btn_Them;
    private javax.swing.JButton btn_TimKiem;
    private javax.swing.JButton btn_Xoa;
    private javax.swing.JComboBox<String> cbo_ChucVu;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton rb_Nam;
    private javax.swing.JRadioButton rb_Nu;
    private javax.swing.JRadioButton rdaNgaySinh;
    private javax.swing.JRadioButton rdaTenNV;
    private javax.swing.ButtonGroup rda_GT;
    private javax.swing.JTable tbl_NhanVien;
    private javax.swing.JTextField txt_DiaChi;
    private javax.swing.JTextField txt_MaNV;
    private javax.swing.JTextField txt_MatKhau;
    private javax.swing.JTextField txt_NgaySinh;
    private javax.swing.JTextField txt_NgayVaoLam;
    private javax.swing.JTextField txt_SDT;
    private javax.swing.JTextField txt_TenNV;
    private javax.swing.JTextField txt_TimKiem;
    // End of variables declaration//GEN-END:variables
}
