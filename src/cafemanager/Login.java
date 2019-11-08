/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cafemanager;

import control.ImagePanel;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Arrays;
import javax.swing.ImageIcon;

/**
 *
 * @author ASUS
 */
public class Login extends javax.swing.JFrame {

    String ipAddress ="192.168.43.88";
    /**
     * Creates new form Login
     */
    public Login() {
        initComponents();
        addMoreGUI();
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
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtTaiKhoan = new javax.swing.JTextField();
        txtMatKhau = new javax.swing.JPasswordField();
        btnDangNhap = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setMinimumSize(new java.awt.Dimension(1280, 720));
        jPanel1.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("ĐĂNG NHẬP");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(1040, 80, 261, 80);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Mật khẩu");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(1020, 350, 160, 44);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Tài khoản");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(1020, 230, 160, 44);

        txtTaiKhoan.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jPanel1.add(txtTaiKhoan);
        txtTaiKhoan.setBounds(1020, 280, 290, 40);

        txtMatKhau.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jPanel1.add(txtMatKhau);
        txtMatKhau.setBounds(1020, 400, 290, 40);

        btnDangNhap.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        btnDangNhap.setForeground(new java.awt.Color(0, 0, 0));
        btnDangNhap.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/loginCheckNew.png"))); // NOI18N
        btnDangNhap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDangNhapActionPerformed(evt);
            }
        });
        jPanel1.add(btnDangNhap);
        btnDangNhap.setBounds(1080, 490, 160, 160);

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/loginPaneBackground.png"))); // NOI18N
        jPanel1.add(jLabel4);
        jLabel4.setBounds(0, 0, 1370, 720);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1365, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 720, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnDangNhapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDangNhapActionPerformed
        // TODO add your handling code here:
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String dbUrl= "jdbc:sqlserver://"+ipAddress+"\\SQLEXPRESS:1433;databaseName=CAFE;user=sa;password=sa2017";
            Connection con=DriverManager.getConnection(dbUrl);
            Statement stm = con.createStatement();
            ResultSet rs;
            String queryString = "select a.MatKhau, b.MaChucVu from NhanVien as a, ChucVu as b where a.MaChucVu=b.MaChucVu and TaiKhoan ='"+txtTaiKhoan.getText().trim()+"'" ;
            rs = stm.executeQuery(queryString);
            int check = 0;
            String chucvu = "";
            while(rs.next()){
                char[] passwordTXT = txtMatKhau.getPassword();
                char[] passwordDB = rs.getString("MatKhau").trim().toCharArray();
                chucvu = rs.getString("MaChucVu").trim();
                if(Arrays.equals(passwordTXT,passwordDB)){
                    check = 1;
                    switch (chucvu) {
                        case "CV_1":
                        chucvu = "BB";
                        break;
                        case "CV_2":
                        chucvu = "B";
                        break;
                        case "CV_3":
                        chucvu = "TN";
                        break;
                        case "CV_4":
                        chucvu = "QL";
                        break;
                        case "CV_5":
                        chucvu = "C";
                        break;
                        default:
                        chucvu = "ERROR";
                        break;
                    }
                }
            }
            if(check == 1 && chucvu == "QL"){
                QuanLy quanLy =  new QuanLy();
                quanLy.setVisible(true);
                this.dispose();
            }
            if(check == 1 && chucvu == "B"){
                BillGUI billGUI =  new BillGUI();
                billGUI.setVisible(true);
                this.dispose();
            }
            if(check == 1 && chucvu == "TN"){
                BanGUI ban =  new BanGUI();
                ban.setVisible(true);
                this.dispose();
            }

        }catch(Exception ex){

        }
    }//GEN-LAST:event_btnDangNhapActionPerformed

    private void addMoreGUI() {
        this.btnDangNhap.setContentAreaFilled(false);
    }
    
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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDangNhap;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField txtMatKhau;
    private javax.swing.JTextField txtTaiKhoan;
    // End of variables declaration//GEN-END:variables
}