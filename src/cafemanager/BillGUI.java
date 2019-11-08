/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cafemanager;

import control.ImagePanel;
import control.IPAddress;
import control.Connect;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;

import javax.swing.JTextPane;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;

/**
 *
 * @author BlackVernon
 */
public class BillGUI extends javax.swing.JFrame {

    private ArrayList<Bill> billList;
    private String ipAddress = "10.1.21.91";

    /**
     * Creates new form BillGUI
     *
     * @return
     */
    private void addMoreGUI() {
        ImagePanel panel;
        panel = new ImagePanel(
                new ImageIcon("src\\image\\loginBackgroundRaw.jpg").getImage());
        setBounds(0, 0, 1366, 720);
        getContentPane().add(panel);
        setVisible(true);
        billPanel1.setEditable(false);
        billPanel2.setEditable(false);
        billPanel3.setEditable(false);
        doneBtnBillPanel1.setContentAreaFilled(false);
        doneBtnBillPanel2.setContentAreaFilled(false);
        doneBtnBillPanel3.setContentAreaFilled(false);
    }

    public static void append(String s, JTextPane jtp) {
        try {
            Document doc = jtp.getDocument();
            doc.insertString(doc.getLength(), s, null);
        } catch (BadLocationException exc) {
            exc.printStackTrace();
        }
    }

    public void showBill() throws Exception {
        billList = new ArrayList<>();
        clearPane();
        String billquery, monquery;
        billquery = "select a.MaHoaDon, a.MaBan "
                + "from HoaDon as a, TrangThai as b "
                + "where "
                + "b.TrangThaiHD=0 and "
                + "b.MaHoaDon=a.MaHoaDon";
        ResultSet resultBill = Connect.ConnectQuery(ipAddress, "1433", "CAFE", "sa", "sa2017", billquery);
        while (resultBill.next()) {
            Bill tempBill = new Bill();
            tempBill.setIdBill(resultBill.getString("MaHoaDon"));
            tempBill.setIdTable(resultBill.getString("MaBan"));
            monquery = "select a.TenMon, b.SoLuongMon from Mon as a, ChiTietMon as b \n"
                    + "where"
                    + "	b.MaHoaDon='"
                    + resultBill.getString("MaHoaDon")
                    + "' AND"
                    + "	b.MaMon = a.MaMon";
            ResultSet resultMon = Connect.ConnectQuery(ipAddress, "1433", "CAFE", "sa", "sa2017", monquery);
            while (resultMon.next()) {
                tempBill.setMon(resultMon.getString("TenMon"), Integer.valueOf(resultMon.getString("SoLuongMon")));
            }
            billList.add(tempBill);
        }
        for (int i = 0; i < billList.size(); i++) {
            if (!this.billPanel1.getText().isEmpty()) {
                if (!this.billPanel2.getText().isEmpty()) {
                    if (!this.billPanel3.getText().isEmpty()) {
                    } else {
                        this.billPanel3.setText(billList.get(i).toString());
                    }
                } else {
                    this.billPanel2.setText(billList.get(i).toString());
                }
            } else {
                this.billPanel1.setText(billList.get(i).toString());
            }
        }
    }

    private void clearPane() {
        this.billPanel1.setText("");
        this.billPanel2.setText("");
        this.billPanel3.setText("");
    }

    public BillGUI() throws SQLException, ClassNotFoundException, Exception {
        initComponents();
        addMoreGUI();

        new Timer().scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                try {
                    if (billPanel1.getText().isEmpty()|billPanel2.getText().isEmpty()|billPanel3.getText().isEmpty()) {
                        showBill();
                    }
                } catch (Exception ex) {
                    Logger.getLogger(BillGUI.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }, 0, 5000);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        billPanel3 = new javax.swing.JTextPane();
        jScrollPane4 = new javax.swing.JScrollPane();
        billPanel1 = new javax.swing.JTextPane();
        jScrollPane5 = new javax.swing.JScrollPane();
        billPanel2 = new javax.swing.JTextPane();
        doneBtnBillPanel1 = new javax.swing.JButton();
        doneBtnBillPanel2 = new javax.swing.JButton();
        doneBtnBillPanel3 = new javax.swing.JButton();

        jButton1.setText("jButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        setSize(new java.awt.Dimension(1366, 720));

        billPanel3.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        jScrollPane3.setViewportView(billPanel3);

        billPanel1.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        jScrollPane4.setViewportView(billPanel1);

        billPanel2.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        jScrollPane5.setViewportView(billPanel2);

        doneBtnBillPanel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/loginCheck100px.png"))); // NOI18N
        doneBtnBillPanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                doneBtnBillPanel1MouseClicked(evt);
            }
        });

        doneBtnBillPanel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/loginCheck100px.png"))); // NOI18N
        doneBtnBillPanel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                doneBtnBillPanel2MouseClicked(evt);
            }
        });

        doneBtnBillPanel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/loginCheck100px.png"))); // NOI18N
        doneBtnBillPanel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                doneBtnBillPanel3MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(83, 83, 83)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(147, 147, 147)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 154, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(82, 82, 82))
            .addGroup(layout.createSequentialGroup()
                .addGap(201, 201, 201)
                .addComponent(doneBtnBillPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(367, 367, 367)
                .addComponent(doneBtnBillPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(doneBtnBillPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(180, 180, 180))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 550, Short.MAX_VALUE)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4))
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(doneBtnBillPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(doneBtnBillPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(doneBtnBillPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(44, Short.MAX_VALUE))
        );

        setSize(new java.awt.Dimension(1382, 759));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void doneBtnBillPanel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_doneBtnBillPanel1MouseClicked
        // TODO add your handling code here:
        String updateStateQuery;
        try {
            String mahoadon = billPanel1.getText().split("\n")[0];
            mahoadon = mahoadon.substring(7);

            updateStateQuery = "UPDATE TrangThai"
                    + " SET TrangThaiHD=1"
                    + " where MaHoaDon='"
                    + mahoadon + "'";

            Connect.ConnectUpdate(ipAddress, "1433", "CAFE", "sa", "sa2017", updateStateQuery);
            showBill();
        } catch (Exception ex) {
            //Do Nothing
        }
    }//GEN-LAST:event_doneBtnBillPanel1MouseClicked

    private void doneBtnBillPanel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_doneBtnBillPanel3MouseClicked
        // TODO add your handling code here:
        String updateStateQuery;
        try {
            String mahoadon = billPanel3.getText().split("\n")[0];
            mahoadon = mahoadon.substring(7);

            updateStateQuery = "UPDATE TrangThai"
                    + " SET TrangThaiHD=1"
                    + " where MaHoaDon='"
                    + mahoadon + "'";

            Connect.ConnectUpdate(ipAddress, "1433", "CAFE", "sa", "sa2017", updateStateQuery);
            showBill();
        } catch (Exception ex) {
            //Do Nothing
        }
    }//GEN-LAST:event_doneBtnBillPanel3MouseClicked

    private void doneBtnBillPanel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_doneBtnBillPanel2MouseClicked
        // TODO add your handling code here:
        String updateStateQuery;
        try {
            String mahoadon = billPanel2.getText().split("\n")[0];
            mahoadon = mahoadon.substring(7);

            updateStateQuery = "UPDATE TrangThai"
                    + " SET TrangThaiHD=1"
                    + " where MaHoaDon='"
                    + mahoadon + "'";

            Connect.ConnectUpdate(ipAddress, "1433", "CAFE", "sa", "sa2017", updateStateQuery);
            showBill();
        } catch (Exception ex) {
            //Do Nothing
        }
    }//GEN-LAST:event_doneBtnBillPanel2MouseClicked

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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BillGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            try {
                new BillGUI().setVisible(true);
            } catch (Exception ex) {
                Logger.getLogger(BillGUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextPane billPanel1;
    private javax.swing.JTextPane billPanel2;
    private javax.swing.JTextPane billPanel3;
    private javax.swing.JButton doneBtnBillPanel1;
    private javax.swing.JButton doneBtnBillPanel2;
    private javax.swing.JButton doneBtnBillPanel3;
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    // End of variables declaration//GEN-END:variables
}
