/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cafemanager;

import java.awt.Color;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import control.Connect;
import control.IPAddress;
import control.ImagePanel;
import java.text.SimpleDateFormat;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import java.util.Date;

/**
 *
 * @author TanKy
 */
public class MonGUI extends javax.swing.JFrame {

    BanGUI ban;
    boolean status = false;
    int STTBan_Mon;
    int tongTien = 0;

    String[] header = {"Tên Món", "Giá Bán"};
    Object[] data = new Object[3];
    DefaultTableModel table;

    private String ip = "10.1.21.91";
    String port = "1433";
    String dbName = "CAFE";
    String userName = "sa";
    String passWord = "sa2017";
    String tenDanhMuc = "";

    private void addmoreGUI() {
        ImagePanel panel;
        panel = new ImagePanel(
                new ImageIcon("src\\image\\loginBackgroundRaw.jpg").getImage());
        setBounds(0, 0, 1366, 720);
        getContentPane().add(panel);
        setVisible(true);
        this.btnDatMon.setContentAreaFilled(false);
        this.btnHuy.setContentAreaFilled(false);
        this.btnXoa.setContentAreaFilled(false);
        this.btnGetData.setContentAreaFilled(false);
    }

    public MonGUI() throws Exception {
        this.ip = ip;
        initComponents();
        addmoreGUI();
        table = new DefaultTableModel();
        table.setColumnIdentifiers(header);
        jTable1.setModel(table);
    }

    public void setSTTBan(int STTBan) {
        txtSTTBan.setText("Table_#" + STTBan);
        this.STTBan_Mon = STTBan;

//        setMaHoaDon();
    }

//    SAI
    public void setMaHoaDon() {
        String query = "SELECT MAX(MaHoaDon) as a from HoaDon";
        String MAX_MaHD = "";
        try {
            ResultSet rs = control.Connect.ConnectQuery(ip, port, dbName, userName, passWord, query);
            while (rs.next()) {
                try {
                    MAX_MaHD = rs.getString("a");
                } catch (NumberFormatException e) {
                    System.out.println("Loi");
                }
                System.out.println("Max_MHD: " + rs.getInt("a"));

            }
        } catch (SQLException ex) {
            Logger.getLogger(MonGUI.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MonGUI.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void setTRANGTHAI(BanGUI ban, int STTBan) {
        status = ban.ban_Model.get(STTBan).isStatus();
        this.ban = ban;
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
        txtTenMon = new javax.swing.JLabel();
        txtGiaBan = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();
        btnGetData = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        btnDatMon = new javax.swing.JButton();
        btnHuy = new javax.swing.JButton();
        txtSTTBan = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtMaHoaDon = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtSoLuong = new javax.swing.JLabel();
        txtTongTien = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        btnXoa = new javax.swing.JButton();
        txtSTTXoaHang = new javax.swing.JTextField();
        btnThanhToan = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        txtDanhMuc2 = new javax.swing.JLabel();
        txtDanhMuc3 = new javax.swing.JLabel();
        txtDanhMuc1 = new javax.swing.JLabel();
        txtDanhMuc5 = new javax.swing.JLabel();
        txtDanhMuc4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        txtTenMon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtTenMon.setText("Ten Mon");
        txtTenMon.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        txtGiaBan.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtGiaBan.setText("Gia Ban");
        txtGiaBan.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jComboBox1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox1ItemStateChanged(evt);
            }
        });
        jComboBox1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jComboBox1MouseClicked(evt);
            }
        });
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        btnGetData.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8-ok-24.png"))); // NOI18N
        btnGetData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGetDataActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtGiaBan, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTenMon, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 332, Short.MAX_VALUE)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnGetData, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtTenMon, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnGetData, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(55, 55, 55)))
                .addGap(36, 36, 36)
                .addComponent(txtGiaBan)
                .addContainerGap(546, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.setForeground(new java.awt.Color(255, 255, 255));

        btnDatMon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/loginCheck100px.png"))); // NOI18N
        btnDatMon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDatMonActionPerformed(evt);
            }
        });

        btnHuy.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8-cancel-100.png"))); // NOI18N
        btnHuy.setText("HUY");
        btnHuy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHuyActionPerformed(evt);
            }
        });

        txtSTTBan.setText("#");

        jLabel1.setText("--------------------------------------------------------");

        jLabel2.setText("------------------------------------------------------------------------------");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setText("Bill:");

        txtMaHoaDon.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txtMaHoaDon.setText("#");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel6.setText("Total");

        txtSoLuong.setText("So Luong");

        txtTongTien.setText("Tong Tien");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null}
            },
            new String [] {
                "Title 1", "Title 2"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        btnXoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8-minus-64.png"))); // NOI18N
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        btnThanhToan.setText("Thanh Toan");
        btnThanhToan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThanhToanActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 315, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtSoLuong)
                        .addGap(37, 37, 37))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtMaHoaDon))
                            .addComponent(txtTongTien)
                            .addComponent(txtSTTBan, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(btnDatMon, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtSTTXoaHang, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnHuy, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btnThanhToan)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtMaHoaDon))
                .addGap(43, 43, 43)
                .addComponent(txtSTTBan)
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtSoLuong))
                .addGap(26, 26, 26)
                .addComponent(txtTongTien)
                .addGap(44, 44, 44)
                .addComponent(btnThanhToan)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtSTTXoaHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnDatMon, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnHuy, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(15, 15, 15))
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        txtDanhMuc2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        txtDanhMuc2.setText("Lunch");
        txtDanhMuc2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtDanhMuc2MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                txtDanhMuc2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                txtDanhMuc2MouseExited(evt);
            }
        });

        txtDanhMuc3.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        txtDanhMuc3.setText("Dinner");
        txtDanhMuc3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtDanhMuc3MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                txtDanhMuc3MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                txtDanhMuc3MouseExited(evt);
            }
        });

        txtDanhMuc1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        txtDanhMuc1.setText("Breakfast");
        txtDanhMuc1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtDanhMuc1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                txtDanhMuc1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                txtDanhMuc1MouseExited(evt);
            }
        });

        txtDanhMuc5.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        txtDanhMuc5.setText("Drinks");
        txtDanhMuc5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtDanhMuc5MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                txtDanhMuc5MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                txtDanhMuc5MouseExited(evt);
            }
        });

        txtDanhMuc4.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        txtDanhMuc4.setText("Desserts");
        txtDanhMuc4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtDanhMuc4MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                txtDanhMuc4MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                txtDanhMuc4MouseExited(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtDanhMuc2, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDanhMuc3, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDanhMuc4, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDanhMuc1, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDanhMuc5, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(28, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addComponent(txtDanhMuc1)
                .addGap(93, 93, 93)
                .addComponent(txtDanhMuc2)
                .addGap(93, 93, 93)
                .addComponent(txtDanhMuc3)
                .addGap(92, 92, 92)
                .addComponent(txtDanhMuc4)
                .addGap(92, 92, 92)
                .addComponent(txtDanhMuc5)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnDatMonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDatMonActionPerformed
        if (table.getRowCount() != 0) {
            ban.ban_Model.get(STTBan_Mon - 1).setStatus(true);
            this.hide();
            ban.show();
            SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd HH:mm:ss");
            Date d = new Date();
//            System.out.println();
            Bill b = new Bill();
            b.setIdBill(this.txtMaHoaDon.getText());
            b.setDate((String) formatter.format(d));
            b.setIdTable(this.txtSTTBan.getText());
            b.setTotal(this.jPanel2.toString());
            for (int i = 0; i < this.table.getRowCount(); i++) {
//                getmon
            }
            String queryInsertBill = "";

        } else {
            JOptionPane.showMessageDialog(null, "Khong the tao hoa don trong");
        }


    }//GEN-LAST:event_btnDatMonActionPerformed

    private void btnHuyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHuyActionPerformed

        ban.ban_Model.get(STTBan_Mon - 1).setStatus(false);
        this.hide();
        ban.show();

    }//GEN-LAST:event_btnHuyActionPerformed

    private void txtDanhMuc2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtDanhMuc2MouseEntered
        txtDanhMuc2.setForeground(Color.blue);
    }//GEN-LAST:event_txtDanhMuc2MouseEntered

    private void txtDanhMuc2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtDanhMuc2MouseExited
        // TODO add your handling code here:
        txtDanhMuc2.setForeground(Color.black);
    }//GEN-LAST:event_txtDanhMuc2MouseExited

    private void txtDanhMuc3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtDanhMuc3MouseEntered
        // TODO add your handling code here:
        txtDanhMuc3.setForeground(Color.blue);
    }//GEN-LAST:event_txtDanhMuc3MouseEntered

    private void txtDanhMuc3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtDanhMuc3MouseExited
        // TODO add your handling code here:
        txtDanhMuc3.setForeground(Color.black);
    }//GEN-LAST:event_txtDanhMuc3MouseExited

    private void txtDanhMuc1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtDanhMuc1MouseEntered
        // TODO add your handling code here:
        txtDanhMuc1.setForeground(Color.blue);
    }//GEN-LAST:event_txtDanhMuc1MouseEntered

    private void txtDanhMuc1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtDanhMuc1MouseExited
        txtDanhMuc1.setForeground(Color.black);
    }//GEN-LAST:event_txtDanhMuc1MouseExited

    private void txtDanhMuc5MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtDanhMuc5MouseEntered
        // TODO add your handling code here:
        txtDanhMuc5.setForeground(Color.blue);
    }//GEN-LAST:event_txtDanhMuc5MouseEntered

    private void txtDanhMuc5MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtDanhMuc5MouseExited
        // TODO add your handling code here:
        txtDanhMuc5.setForeground(Color.blue);
    }//GEN-LAST:event_txtDanhMuc5MouseExited

    private void txtDanhMuc4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtDanhMuc4MouseEntered
        // TODO add your handling code here:
        txtDanhMuc4.setForeground(Color.blue);
    }//GEN-LAST:event_txtDanhMuc4MouseEntered

    private void txtDanhMuc4MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtDanhMuc4MouseExited
        // TODO add your handling code here:
        txtDanhMuc4.setForeground(Color.black);
    }//GEN-LAST:event_txtDanhMuc4MouseExited

    public void addDanhMucMon(String tenDanhMuc) {
        jComboBox1.removeAllItems();
        String query = "select a.TenMon, a.GiaMon from Mon AS a, DanhMuc AS b WHERE b.TenDanhMuc = N'" + tenDanhMuc + "' AND b.MaDanhMuc = a.MaDanhMuc";

        try {
            ResultSet rs = Connect.ConnectQuery(ip, port, dbName, userName, passWord, query);
            while (rs.next()) {
                jComboBox1.addItem(rs.getString("TenMon"));
            }

        } catch (SQLException ex) {
            Logger.getLogger(MonGUI.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MonGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    private void txtDanhMuc1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtDanhMuc1MouseClicked
        String danhMucMon = "Ăn sáng";
        addDanhMucMon(danhMucMon);
    }//GEN-LAST:event_txtDanhMuc1MouseClicked

    private void txtDanhMuc2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtDanhMuc2MouseClicked
        String tenDanhMucMon = "Ăn trưa";
        addDanhMucMon(tenDanhMucMon);
    }//GEN-LAST:event_txtDanhMuc2MouseClicked

    private void txtDanhMuc5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtDanhMuc5MouseClicked
        String danhMucMon = "Nước";
        addDanhMucMon(danhMucMon);
    }//GEN-LAST:event_txtDanhMuc5MouseClicked

    private void jComboBox1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox1ItemStateChanged

        String tenMon = jComboBox1.getSelectedItem().toString();
        String query = "select GiaMon from Mon WHERE TenMon =N'" + tenMon + "'";
        try {
            ResultSet rs = control.Connect.ConnectQuery(ip, port, dbName, userName, passWord, query);

            while (rs.next()) {
                txtTenMon.setText((jComboBox1.getSelectedItem().toString()));
                txtGiaBan.setText(rs.getString("GiaMon"));

            }

        } catch (SQLException ex) {
            Logger.getLogger(MonGUI.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MonGUI.class.getName()).log(Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_jComboBox1ItemStateChanged

    private void jComboBox1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jComboBox1MouseClicked
    }//GEN-LAST:event_jComboBox1MouseClicked

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void btnGetDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGetDataActionPerformed
        String tenMon = jComboBox1.getSelectedItem().toString();
        System.out.println(tenMon);

        String query = "select GiaMon from Mon WHERE TenMon =N'" + tenMon + "'";
        try {
            ResultSet rs = Connect.ConnectQuery(ip, port, dbName, userName, passWord, query);

            while (rs.next()) {
                data[0] = jComboBox1.getSelectedItem().toString();
                data[1] = rs.getString("GiaMon");
                table.addRow(data);
                jTable1.setModel(table);
                txtSoLuong.setText(String.valueOf(table.getRowCount()));

                System.out.println("Gia Mon: " + rs.getString("GiaMon"));

                tongTien += rs.getInt("GiaMon");

                txtTongTien.setText(String.valueOf(tongTien));
            }
        } catch (SQLException ex) {
            Logger.getLogger(MonGUI.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MonGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnGetDataActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed

        int stt = Integer.valueOf(txtSTTXoaHang.getText());

        tongTien -= Integer.parseInt((table.getValueAt(stt - 1, 1).toString().trim()));

        if (table.getRowCount() > stt - 1) {
            table.removeRow(stt - 1);
            jTable1.setModel(table);
            txtSoLuong.setText(String.valueOf(table.getRowCount()));

            txtTongTien.setText(String.valueOf(tongTien));
        }
    }//GEN-LAST:event_btnXoaActionPerformed

    private void txtDanhMuc3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtDanhMuc3MouseClicked
        String danhMucMon = "Ăn tối";
        addDanhMucMon(danhMucMon);

    }//GEN-LAST:event_txtDanhMuc3MouseClicked

    private void txtDanhMuc4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtDanhMuc4MouseClicked
        String danhMucMon = "Đồ ngọt";
        addDanhMucMon(danhMucMon);

    }//GEN-LAST:event_txtDanhMuc4MouseClicked

    public void setJcomboBoxToEnable(boolean status) {

        jComboBox1.setEnabled(status);

    }


    private void btnThanhToanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThanhToanActionPerformed

        ban.ban_Model.get(STTBan_Mon - 1).setStatus(false);
        this.hide();
        ban.show();

    }//GEN-LAST:event_btnThanhToanActionPerformed

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
            java.util.logging.Logger.getLogger(MonGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MonGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MonGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MonGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new MonGUI().setVisible(true);
                } catch (Exception ex) {
                    Logger.getLogger(MonGUI.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDatMon;
    private javax.swing.JButton btnGetData;
    private javax.swing.JButton btnHuy;
    private javax.swing.JButton btnThanhToan;
    private javax.swing.JButton btnXoa;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel txtDanhMuc1;
    private javax.swing.JLabel txtDanhMuc2;
    private javax.swing.JLabel txtDanhMuc3;
    private javax.swing.JLabel txtDanhMuc4;
    private javax.swing.JLabel txtDanhMuc5;
    private javax.swing.JLabel txtGiaBan;
    private javax.swing.JLabel txtMaHoaDon;
    private javax.swing.JLabel txtSTTBan;
    private javax.swing.JTextField txtSTTXoaHang;
    private javax.swing.JLabel txtSoLuong;
    private javax.swing.JLabel txtTenMon;
    private javax.swing.JLabel txtTongTien;
    // End of variables declaration//GEN-END:variables
}
