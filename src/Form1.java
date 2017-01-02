
import java.util.*;
//import com.sun.istack.internal.logging.Logger;
import java.sql.*;
import net.proteanit.sql.DbUtils;

public class Form1 extends javax.swing.JFrame {

    private Connection con = null;
    private ResultSet rs = null;
    private PreparedStatement pst = null;

    public Form1() {
        initComponents();

        //Connect ฐานข้อมูลโดยเรียกใช้งาน Method ConnectDB ของ Class Connect
        con = Connect.ConnectDB();

    }

    //--------ดึงข้อมูลมาแสดงในตาราง-------------
    public void showDataToForm() {
        //สร้างชุดคำสั่ง SQL
        String sql = "select fname as 'Name',lname as 'LastName' from tbstudent";
        try {
            //ใช้งาน PreparedStatement 
            //กำหนดค่าให้ pst โดยใช้ Method preparedStatement ของ Connection
            pst = con.prepareStatement(sql);
            //
            rs = pst.executeQuery();

            tbstudent.setModel(DbUtils.resultSetToTableModel(rs));
            
            /*while (rs.next()){ 
                
            }
             */
        } catch (Exception ex) {
            //Logger.getLogger(Form1.class.getName()).log(Level.SERVERE,null,ex);
            ex.getStackTrace();
        }
    }
    //---------------------

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tbstudent = new javax.swing.JTable();
        btnShowData = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tbstudent.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbstudent.setColumnSelectionAllowed(false);
        tbstudent.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tbstudent);
        if (tbstudent.getColumnModel().getColumnCount() > 0) {
            tbstudent.getColumnModel().getColumn(0).setResizable(false);
            tbstudent.getColumnModel().getColumn(1).setResizable(false);
            tbstudent.getColumnModel().getColumn(2).setResizable(false);
            tbstudent.getColumnModel().getColumn(3).setResizable(false);
        }

        btnShowData.setText("ShowData");
        btnShowData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnShowDataActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(btnShowData, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(37, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(107, 107, 107)
                        .addComponent(btnShowData, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(205, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnShowDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnShowDataActionPerformed
        showDataToForm();
        
    }//GEN-LAST:event_btnShowDataActionPerformed

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
            java.util.logging.Logger.getLogger(Form1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Form1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Form1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Form1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Form1().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnShowData;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbstudent;
    // End of variables declaration//GEN-END:variables
}
