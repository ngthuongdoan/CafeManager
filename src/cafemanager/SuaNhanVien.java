/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cafemanager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author ASUS
 */
public class SuaNhanVien extends javax.swing.JFrame {
    
    NhanVien nhanVien;
    private final String ipAddress = "192.168.43.88";
    private static int maNV;
    private static String hoTenNV;
    private static String taiKhoanNV;
    private static String matKhauNV;
    private static String sDTNV;
    private static String diaChiNV;
    /**
     * Creates new form SuaNhanVien
     */
    public SuaNhanVien(int maNV, String hoTenNV, String taiKhoanNV, String matKhauNV, String sDTNV, String diaChiNV) {
        this.maNV = maNV;
        this.hoTenNV = hoTenNV;
        this.taiKhoanNV = taiKhoanNV;
        this.matKhauNV = matKhauNV;
        this.sDTNV = sDTNV;
        this.diaChiNV = diaChiNV;
        initComponents();     
        loadData();
    }

    
    public void loadData(){
        txtMaNV.setEnabled(false);
        txtMaNV.setText(maNV+"");
        txtHoTenNV.setText(hoTenNV);
        txtTaiKhoanNV.setText(taiKhoanNV);
        txtMatKhauNV.setText(matKhauNV);
        txtSDTNV.setText(sDTNV);
        txtDiaChiNV.setText(diaChiNV);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtMaNV = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtHoTenNV = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtTaiKhoanNV = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtMatKhauNV = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        cboChucVuNV = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        txtDiaChiNV = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtSDTNV = new javax.swing.JTextField();
        btnXacNhan = new javax.swing.JButton();
        btnHuyBo = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(500, 600));

        jPanel1.setPreferredSize(new java.awt.Dimension(500, 600));
        jPanel1.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Arial", 1, 22)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Mã nhân viên");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(40, 50, 187, 26);

        txtMaNV.setFont(new java.awt.Font("Arial", 0, 22)); // NOI18N
        jPanel1.add(txtMaNV);
        txtMaNV.setBounds(250, 50, 201, 34);

        jLabel2.setFont(new java.awt.Font("Arial", 1, 22)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Họ tên nhân viên");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(40, 110, 190, 26);

        txtHoTenNV.setFont(new java.awt.Font("Arial", 0, 22)); // NOI18N
        jPanel1.add(txtHoTenNV);
        txtHoTenNV.setBounds(250, 110, 201, 34);

        jLabel3.setFont(new java.awt.Font("Arial", 1, 22)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Tài khoản");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(40, 170, 187, 26);

        txtTaiKhoanNV.setFont(new java.awt.Font("Arial", 0, 22)); // NOI18N
        jPanel1.add(txtTaiKhoanNV);
        txtTaiKhoanNV.setBounds(250, 170, 201, 34);

        jLabel4.setFont(new java.awt.Font("Arial", 1, 22)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Mật khẩu");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(40, 230, 187, 26);

        txtMatKhauNV.setFont(new java.awt.Font("Arial", 0, 22)); // NOI18N
        jPanel1.add(txtMatKhauNV);
        txtMatKhauNV.setBounds(250, 230, 201, 34);

        jLabel5.setFont(new java.awt.Font("Arial", 1, 22)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Chức vụ");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(40, 290, 187, 26);

        cboChucVuNV.setFont(new java.awt.Font("Arial", 0, 22)); // NOI18N
        cboChucVuNV.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Quản lý", "Thu ngân", "Nhân viên bếp", "Nhân viên phục vụ", "Nhân viên dọn dẹp" }));
        jPanel1.add(cboChucVuNV);
        cboChucVuNV.setBounds(250, 290, 201, 36);

        jLabel6.setFont(new java.awt.Font("Arial", 1, 22)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Địa chỉ");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(40, 350, 187, 26);

        txtDiaChiNV.setFont(new java.awt.Font("Arial", 0, 22)); // NOI18N
        jPanel1.add(txtDiaChiNV);
        txtDiaChiNV.setBounds(250, 350, 201, 34);

        jLabel7.setFont(new java.awt.Font("Arial", 1, 22)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("Số điện thoại");
        jPanel1.add(jLabel7);
        jLabel7.setBounds(40, 410, 187, 26);

        txtSDTNV.setFont(new java.awt.Font("Arial", 0, 22)); // NOI18N
        jPanel1.add(txtSDTNV);
        txtSDTNV.setBounds(250, 410, 201, 34);

        btnXacNhan.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnXacNhan.setText("Xác nhận");
        btnXacNhan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXacNhanActionPerformed(evt);
            }
        });
        jPanel1.add(btnXacNhan);
        btnXacNhan.setBounds(110, 490, 110, 38);

        btnHuyBo.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnHuyBo.setText("Hủy bỏ");
        jPanel1.add(btnHuyBo);
        btnHuyBo.setBounds(270, 490, 110, 38);

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/QL.jpg"))); // NOI18N
        jPanel1.add(jLabel8);
        jLabel8.setBounds(0, 0, 500, 600);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnXacNhanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXacNhanActionPerformed
        // TODO add your handling code here:
        nhanVien = new NhanVien(Integer.parseInt(txtMaNV.getText()),txtHoTenNV.getText(),cboChucVuNV.getItemAt(cboChucVuNV.getSelectedIndex()),
            txtDiaChiNV.getText(),txtSDTNV.getText(),txtTaiKhoanNV.getText(),txtMatKhauNV.getText());
        try{
            
            try (java.sql.Connection con = (java.sql.Connection) control.Connect.getConnect(ipAddress)) {
                String queryString = "update NhanVien set TenNhanVien =? ,TaiKhoan =?, MaChucVu =? ,MatKhau =? ,DiaChi =? ,SDT = ? where MaNhanVien ="+"'"+maNV+"'";
                PreparedStatement statement = con.prepareStatement(queryString);
                statement.setString(1,nhanVien.getHoTenNVString());
                statement.setString(2,nhanVien.getTaiKhoanNVString());
                String chucVu = nhanVien.getChucVuNVString();
                switch (chucVu) {
                    case "Bồi bàn":
                        statement.setString(3,"CV_1");
                        break;
                    case "Bếp":
                        statement.setString(3,"CV_2");
                        break;
                    case "Thu ngân":
                        statement.setString(3,"CV_3");
                        break;
                    case "Quản lý":
                        statement.setString(3,"CV_4");
                        break;
                    case "Chủ":
                        statement.setString(3,"CV_5");
                        break;
                } 
                
                statement.setString(4,nhanVien.getMatKhauNVString());
                statement.setString(5,nhanVien.getDiaChiNVString());
                statement.setString(6,nhanVien.getSdtNVString());
                statement.executeUpdate();
            }               
                           
        }catch(SQLException ex){
            System.out.println(ex);
        }
        QuanLy quanLy = null;
        try {
            quanLy = new QuanLy();
        } catch (Exception ex) {
            Logger.getLogger(SuaNhanVien.class.getName()).log(Level.SEVERE, null, ex);
        }
        quanLy.loadDataNhanVien();
        quanLy.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnXacNhanActionPerformed

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
            java.util.logging.Logger.getLogger(SuaNhanVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SuaNhanVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SuaNhanVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SuaNhanVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new SuaNhanVien(maNV, hoTenNV, taiKhoanNV,matKhauNV,sDTNV,diaChiNV).setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnHuyBo;
    private javax.swing.JButton btnXacNhan;
    private javax.swing.JComboBox<String> cboChucVuNV;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txtDiaChiNV;
    private javax.swing.JTextField txtHoTenNV;
    private javax.swing.JTextField txtMaNV;
    private javax.swing.JTextField txtMatKhauNV;
    private javax.swing.JTextField txtSDTNV;
    private javax.swing.JTextField txtTaiKhoanNV;
    // End of variables declaration//GEN-END:variables
}
