/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cafemanager;

import control.Connect;
import control.ImagePanel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author ASUS
 */
public final class QuanLy extends javax.swing.JFrame {
    private NhanVien nhanVien;
    private Item mon;
    private int STT = 0;
    private final String ipAddress = "10.1.21.91";
    /**
     * Creates new form QuanLyU
     */
    
    private void addMoreGUI() {
        ImagePanel panel;
        panel = new ImagePanel(
                new ImageIcon("src\\image\\loginBackgroundRaw.jpg").getImage());
        setBounds(0, 0, 1366, 720);
        getContentPane().add(panel);
        setVisible(true);
    }
    
    public QuanLy() throws Exception {
        initComponents();
        addMoreGUI();
        txtMaNV.setEditable(false);
        btnSuaTTNV.setEnabled(false);
        btnXoaTTNV.setEnabled(false);
        btnSuaMon.setEnabled(false);
        btnXoaMon.setEnabled(false);
        nhanVien = new NhanVien();
        mon = new Item();
        STT = getSTT();
        if(STT==0){
            STT++;
           txtMaNV.setText(""+1);
        }else{
            STT++;
            txtMaNV.setText(""+STT);
        }
        loadDataNhanVien();
        loadDataMon();
    }
    
    public int getSTT(){
        int kq = 0;
        try{
            Connection con = (Connection) Connect.getConnect(ipAddress);
            String str = "select Max(MaNhanVien) from NhanVien";
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(str);            
            while(rs.next()){                
               kq = rs.getInt(1);
            }
        }catch(SQLException ex){  
        }
        return kq;
    }
      
    public void loadDataNhanVien(){
        try{
            try (Connection con = (Connection) control.Connect.getConnect(ipAddress)) {
                Statement stm = con.createStatement();
                String [] array = {"Mã nhân viên","Họ tên","Chức Vụ","Tài khoản","Mật khẩu","Địa chỉ","SĐT"};
                DefaultTableModel defaultTableModel =  new DefaultTableModel(array,0);
                String queryString = "select a.MaNhanVien,a.TenNhanVien,b.TenChucVu,a.TaiKhoan,a.MatKhau,"
                        + "a.DiaChi,a.SDT from NhanVien as a, ChucVu as b where a.MaChucVu = b.MaChucVu";
                ResultSet rs = stm.executeQuery(queryString);
                while(rs.next()){
                    Vector vector = new Vector();
                    vector.add(rs.getString("MaNhanVien"));
                    vector.add(rs.getString("TenNhanVien"));
                    vector.add(rs.getString("TenChucVu"));
                    vector.add(rs.getString("TaiKhoan"));
                    vector.add(rs.getString("MatKhau"));
                    vector.add(rs.getString("DiaChi"));
                    vector.add(rs.getString("SDT"));
                    defaultTableModel.addRow(vector);
                }
                tableQLNV.setModel(defaultTableModel);
            }
        }catch(SQLException ex){  
        }      
    }
    public void loadDataMon(){
        try{
            try (Connection con = (Connection) control.Connect.getConnect(ipAddress)) {
                Statement stm = con.createStatement();
                String [] array = {"Mã món","Tên món","Mô tả","Danh mục","Giá món"};
                DefaultTableModel defaultTableModel =  new DefaultTableModel(array,0);
                String queryString = "select a.MaMon, a.TenMon, a.MoTaMon, b.TenDanhMuc, a.GiaMon from Mon as a, DanhMuc as b where a.MaDanhMuc = b.MaDanhMuc";
                ResultSet rs = stm.executeQuery(queryString);
                while(rs.next()){
                    Vector vector = new Vector();
                    vector.add(rs.getString("MaMon"));
                    vector.add(rs.getString("TenMon"));
                    vector.add(rs.getString("MoTaMon"));
                    vector.add(rs.getString("TenDanhMuc"));
                    vector.add(rs.getString("GiaMon"));
                    defaultTableModel.addRow(vector);
                }
                tableQLM.setModel(defaultTableModel);
            }
        }catch(SQLException ex){  
        }      
        
    }
    
    public boolean IsEmpty(){
        
            return !txtHoTenNV.getText().equals("")
                    || !txtDiaChiNV.getText().equals("") || !txtSDTNV.getText().equals("") ||
                    !txtTaiKhoanNV.getText().equals("") || !txtMatKhauNV.getText().equals("");
        
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtMaNV = new javax.swing.JTextField();
        txtHoTenNV = new javax.swing.JTextField();
        txtTaiKhoanNV = new javax.swing.JTextField();
        txtMatKhauNV = new javax.swing.JTextField();
        cboChucVuNV = new javax.swing.JComboBox<>();
        txtDiaChiNV = new javax.swing.JTextField();
        txtSDTNV = new javax.swing.JTextField();
        btnThemTTNV = new javax.swing.JButton();
        btnSuaTTNV = new javax.swing.JButton();
        btnXoaTTNV = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableQLNV = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txtMaMon = new javax.swing.JTextField();
        txtTenMon = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtMoTa = new javax.swing.JTextPane();
        cboDanhMuc = new javax.swing.JComboBox<>();
        txtGiaMon = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableQLM = new javax.swing.JTable();
        btnThemMon = new javax.swing.JButton();
        btnSuaMon = new javax.swing.JButton();
        btnXoaMon = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Arial", 1, 22)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Mã nhân viên");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(40, 80, 187, 40);

        jLabel2.setFont(new java.awt.Font("Arial", 1, 22)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Họ tên nhân viên");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(40, 140, 190, 40);

        jLabel3.setFont(new java.awt.Font("Arial", 1, 22)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Tài khoản");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(40, 200, 187, 40);

        jLabel4.setFont(new java.awt.Font("Arial", 1, 22)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Mật khẩu");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(40, 260, 187, 40);

        jLabel5.setFont(new java.awt.Font("Arial", 1, 22)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Chức vụ");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(40, 320, 187, 40);

        jLabel6.setFont(new java.awt.Font("Arial", 1, 22)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Địa chỉ");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(40, 380, 187, 40);

        jLabel7.setFont(new java.awt.Font("Arial", 1, 22)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("Số điện thoại");
        jPanel1.add(jLabel7);
        jLabel7.setBounds(40, 440, 187, 40);

        txtMaNV.setFont(new java.awt.Font("Arial", 0, 22)); // NOI18N
        jPanel1.add(txtMaNV);
        txtMaNV.setBounds(250, 80, 201, 40);

        txtHoTenNV.setFont(new java.awt.Font("Arial", 0, 22)); // NOI18N
        jPanel1.add(txtHoTenNV);
        txtHoTenNV.setBounds(250, 140, 201, 40);

        txtTaiKhoanNV.setFont(new java.awt.Font("Arial", 0, 22)); // NOI18N
        jPanel1.add(txtTaiKhoanNV);
        txtTaiKhoanNV.setBounds(250, 200, 201, 40);

        txtMatKhauNV.setFont(new java.awt.Font("Arial", 0, 22)); // NOI18N
        jPanel1.add(txtMatKhauNV);
        txtMatKhauNV.setBounds(250, 260, 201, 40);

        cboChucVuNV.setFont(new java.awt.Font("Arial", 0, 22)); // NOI18N
        cboChucVuNV.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Quản lý", "Thu ngân", "Nhân viên bếp", "Phục vụ ", "Dọn dẹp", " " }));
        jPanel1.add(cboChucVuNV);
        cboChucVuNV.setBounds(250, 320, 201, 40);

        txtDiaChiNV.setFont(new java.awt.Font("Arial", 0, 22)); // NOI18N
        jPanel1.add(txtDiaChiNV);
        txtDiaChiNV.setBounds(250, 380, 201, 40);

        txtSDTNV.setFont(new java.awt.Font("Arial", 0, 22)); // NOI18N
        jPanel1.add(txtSDTNV);
        txtSDTNV.setBounds(250, 440, 201, 40);

        btnThemTTNV.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        btnThemTTNV.setText("Thêm");
        btnThemTTNV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemTTNVActionPerformed(evt);
            }
        });
        jPanel1.add(btnThemTTNV);
        btnThemTTNV.setBounds(50, 540, 90, 38);

        btnSuaTTNV.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        btnSuaTTNV.setText("Sửa");
        btnSuaTTNV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaTTNVActionPerformed(evt);
            }
        });
        jPanel1.add(btnSuaTTNV);
        btnSuaTTNV.setBounds(190, 540, 90, 38);

        btnXoaTTNV.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        btnXoaTTNV.setText("Xóa");
        btnXoaTTNV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaTTNVActionPerformed(evt);
            }
        });
        jPanel1.add(btnXoaTTNV);
        btnXoaTTNV.setBounds(330, 540, 90, 38);

        tableQLNV.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        tableQLNV.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tableQLNV.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableQLNVMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableQLNV);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(500, 80, 830, 490);

        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(jLabel8);
        jLabel8.setBounds(0, 0, 1400, 730);

        jTabbedPane1.addTab("Quản lý nhân viên", jPanel1);

        jPanel4.setLayout(null);

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 0, 0));
        jLabel9.setText("Mã món ");
        jPanel4.add(jLabel9);
        jLabel9.setBounds(77, 114, 169, 40);

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 0, 0));
        jLabel10.setText("Mô tả món");
        jPanel4.add(jLabel10);
        jLabel10.setBounds(77, 279, 169, 40);

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 0, 0));
        jLabel11.setText("Tên món ");
        jPanel4.add(jLabel11);
        jLabel11.setBounds(77, 196, 169, 40);

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 0, 0));
        jLabel12.setText("Danh mục món ");
        jPanel4.add(jLabel12);
        jLabel12.setBounds(77, 413, 169, 40);

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 0, 0));
        jLabel13.setText("Giá món");
        jPanel4.add(jLabel13);
        jLabel13.setBounds(77, 502, 169, 40);

        txtMaMon.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        jPanel4.add(txtMaMon);
        txtMaMon.setBounds(264, 114, 260, 40);

        txtTenMon.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        jPanel4.add(txtTenMon);
        txtTenMon.setBounds(264, 196, 260, 40);

        txtMoTa.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        jScrollPane3.setViewportView(txtMoTa);

        jPanel4.add(jScrollPane3);
        jScrollPane3.setBounds(264, 279, 260, 90);

        cboDanhMuc.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        cboDanhMuc.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Đồ uống", "Đồ ăn" }));
        jPanel4.add(cboDanhMuc);
        cboDanhMuc.setBounds(264, 413, 260, 40);

        txtGiaMon.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        jPanel4.add(txtGiaMon);
        txtGiaMon.setBounds(264, 502, 260, 40);

        tableQLM.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tableQLM.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableQLMMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tableQLM);

        jPanel4.add(jScrollPane2);
        jScrollPane2.setBounds(568, 114, 760, 500);

        btnThemMon.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnThemMon.setText("Thêm");
        btnThemMon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemMonActionPerformed(evt);
            }
        });
        jPanel4.add(btnThemMon);
        btnThemMon.setBounds(80, 590, 80, 35);

        btnSuaMon.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnSuaMon.setText("Sửa ");
        btnSuaMon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaMonActionPerformed(evt);
            }
        });
        jPanel4.add(btnSuaMon);
        btnSuaMon.setBounds(260, 590, 80, 35);

        btnXoaMon.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnXoaMon.setText("Xóa");
        btnXoaMon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaMonActionPerformed(evt);
            }
        });
        jPanel4.add(btnXoaMon);
        btnXoaMon.setBounds(440, 590, 80, 35);

        jLabel15.setBackground(new java.awt.Color(255, 255, 255));
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jPanel4.add(jLabel15);
        jLabel15.setBounds(0, 0, 1360, 730);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Quản lý món", jPanel2);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1361, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 729, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Thống kê doanh thu", jPanel3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void btnThemTTNVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemTTNVActionPerformed
        // TODO add your handling code here:
        
        nhanVien = new NhanVien(Integer.parseInt(txtMaNV.getText()),txtHoTenNV.getText(),cboChucVuNV.getItemAt(cboChucVuNV.getSelectedIndex()),
            txtDiaChiNV.getText(),txtSDTNV.getText(),txtTaiKhoanNV.getText(),txtMatKhauNV.getText());
        try{
            if(IsEmpty()){
                try (Connection con = (Connection) control.Connect.getConnect(ipAddress)) {
                    String queryString = "insert into NhanVien values (?,?,?,?,?,?,?)";
                    PreparedStatement statement = con.prepareStatement(queryString);
                    statement.setInt(1,nhanVien.getMaNVInt());
                    String maChucVu = cboChucVuNV.getItemAt(cboChucVuNV.getSelectedIndex());
                    switch (maChucVu) {
                        case "Bồi bàn":
                            statement.setString(2,"CV_1");
                            break;
                        case "Bếp":
                            statement.setString(2,"CV_2");
                            break;
                        case "Thu ngân":
                            statement.setString(2,"CV_3");
                            break;
                        case "Quản lý":
                            statement.setString(2,"CV_4");
                            break;
                        case "Chủ":
                            statement.setString(2,"CV_5");
                            break;
                    }
                    statement.setString(3,nhanVien.getTaiKhoanNVString());
                    statement.setString(4,nhanVien.getMatKhauNVString());
                    statement.setString(5,nhanVien.getHoTenNVString());
                    statement.setString(6,nhanVien.getDiaChiNVString());
                    statement.setString(7,nhanVien.getSdtNVString());
                    statement.executeUpdate();
                    loadDataNhanVien();
                }
                STT++;
                txtMaNV.setText(""+STT);
            }
                   
        }catch(SQLException ex){
            System.out.println(ex);
        }   
    }//GEN-LAST:event_btnThemTTNVActionPerformed

    private void btnSuaTTNVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaTTNVActionPerformed
        // TODO add your handling code here:    
        SuaNhanVien snv = new SuaNhanVien(Integer.parseInt(tableQLNV.getValueAt(tableQLNV.getSelectedRow(),0).toString()),tableQLNV.getValueAt(tableQLNV.getSelectedRow(),1).toString(),
        tableQLNV.getValueAt(tableQLNV.getSelectedRow(),3).toString(),tableQLNV.getValueAt(tableQLNV.getSelectedRow(),4).toString(),tableQLNV.getValueAt(tableQLNV.getSelectedRow(),6).toString(),
        tableQLNV.getValueAt(tableQLNV.getSelectedRow(),5).toString());
        snv.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnSuaTTNVActionPerformed

    private void btnXoaTTNVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaTTNVActionPerformed
        // TODO add your handling code here:
        try{
            try (Connection con = (Connection) control.Connect.getConnect(ipAddress)) {
                String queryString = "delete from NhanVien where MaNhanVien = '"+nhanVien.getMaNVInt()+""+"'";
                PreparedStatement statement = con.prepareStatement(queryString);
                statement.executeUpdate();
                loadDataNhanVien();
            }
        }catch(SQLException ex){
            System.out.println(ex);
        }

    }//GEN-LAST:event_btnXoaTTNVActionPerformed

    private void tableQLNVMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableQLNVMouseClicked
        // TODO add your handling code here:
        int i = tableQLNV.getSelectedRow();
        TableModel tableModel = tableQLNV.getModel();
        nhanVien.setMaNVInt(Integer.parseInt(tableModel.getValueAt(i,0).toString()));
        btnSuaTTNV.setEnabled(true);
        btnXoaTTNV.setEnabled(true);   
    }//GEN-LAST:event_tableQLNVMouseClicked

    private void btnThemMonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemMonActionPerformed
        // TODO add your handling code here:
        mon = new Item(txtMaMon.getText(),txtTenMon.getText(),txtMoTa.getText(),cboDanhMuc.getItemAt(cboDanhMuc.getSelectedIndex()),
            txtGiaMon.getText());
        try{
            try (Connection con = (Connection) control.Connect.getConnect(ipAddress)) {
                String queryString = "insert into Mon values (?,?,?,?,'',?)";
                PreparedStatement statement = con.prepareStatement(queryString);
                statement.setString(1,mon.getIdItem());
                String maDanhMuc = cboDanhMuc.getItemAt(cboDanhMuc.getSelectedIndex());       
                switch (maDanhMuc) {
                    case "Ăn sáng":
                        statement.setString(2,"DM_1");
                        break;
                    case "Ăn trưa":
                        statement.setString(2,"DM_2");
                        break;
                    case "Ăn tối":
                        statement.setString(2,"DM_3");
                        break;
                    case "Đồ ngọt":
                        statement.setString(2,"DM_4");
                        break;
                    case "Nước":
                        statement.setString(2,"DM_5");
                        break;
                } 
                statement.setString(3,mon.getItemName());
                statement.setString(4,mon.getExpressItem());
                statement.setString(5,mon.getPrice());
                statement.executeUpdate();
                loadDataMon();
            }
                     
        }catch(SQLException ex){
            System.out.println(ex);
        }
    }//GEN-LAST:event_btnThemMonActionPerformed

    private void btnSuaMonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaMonActionPerformed
        // TODO add your handling code here:
        SuaMon sm;
        sm = new SuaMon(tableQLM.getValueAt(tableQLM.getSelectedRow(),0).toString(),tableQLM.getValueAt(tableQLM.getSelectedRow(),1).toString(),tableQLM.getValueAt(tableQLM.getSelectedRow(),2).toString(),
                Float.parseFloat(tableQLM.getValueAt(tableQLM.getSelectedRow(),4).toString()));
        sm.setVisible(true);
        this.setVisible(false);
        
    }//GEN-LAST:event_btnSuaMonActionPerformed

    private void btnXoaMonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaMonActionPerformed
        // TODO add your handling code here:
        try{
            try (Connection con = (Connection)control.Connect.getConnect(ipAddress)) {
                String queryString = "delete from Mon where MaMon = '"+mon.getIdItem()+""+"'";
                PreparedStatement statement = con.prepareStatement(queryString);
                statement.executeUpdate();
                loadDataMon();
            }
        }catch(SQLException ex){
            System.out.println(ex);
        }
    }//GEN-LAST:event_btnXoaMonActionPerformed

    private void tableQLMMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableQLMMouseClicked
        // TODO add your handling code here:
         int i = tableQLM.getSelectedRow();
        TableModel tableModel = tableQLM.getModel();
        mon.setIdItem(tableModel.getValueAt(i,0).toString());
        btnSuaMon.setEnabled(true); 
        btnXoaMon.setEnabled(true);
    }//GEN-LAST:event_tableQLMMouseClicked

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
            java.util.logging.Logger.getLogger(QuanLy.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QuanLy.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QuanLy.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QuanLy.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            try {
                new QuanLy().setVisible(true);
            } catch (Exception ex) {
                Logger.getLogger(QuanLy.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSuaMon;
    private javax.swing.JButton btnSuaTTNV;
    private javax.swing.JButton btnThemMon;
    private javax.swing.JButton btnThemTTNV;
    private javax.swing.JButton btnXoaMon;
    private javax.swing.JButton btnXoaTTNV;
    private javax.swing.JComboBox<String> cboChucVuNV;
    private javax.swing.JComboBox<String> cboDanhMuc;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable tableQLM;
    private javax.swing.JTable tableQLNV;
    private javax.swing.JTextField txtDiaChiNV;
    private javax.swing.JTextField txtGiaMon;
    private javax.swing.JTextField txtHoTenNV;
    private javax.swing.JTextField txtMaMon;
    private javax.swing.JTextField txtMaNV;
    private javax.swing.JTextField txtMatKhauNV;
    private javax.swing.JTextPane txtMoTa;
    private javax.swing.JTextField txtSDTNV;
    private javax.swing.JTextField txtTaiKhoanNV;
    private javax.swing.JTextField txtTenMon;
    // End of variables declaration//GEN-END:variables
}
