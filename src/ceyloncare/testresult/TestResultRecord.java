/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ceyloncare.testresult;

import ceyloncare.login.Connect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Wasura Dananjith
 */
public class TestResultRecord extends javax.swing.JFrame {
    Connection con = null;
    PreparedStatement pst = null;
    ResultSet rs =null;
    String choice="";// To identify from which mode the control flow was passed 
    int flag =0;// To identify from which form this form was called
    /**
     * Creates new form TestResultRecord
     * @param ch
     * @param n
     */
    public TestResultRecord(String ch,int n) {
        initComponents();
        setLocationRelativeTo(null);
        choice = ch;
        flag = n;
        
        // Get data for jTable1 when this form is loading 
        this.getData();
        
        // When this form is called from Admin/Laboratory/Doctor mode 
        if (!((choice.equals("Administrator")) || (choice.equals("Laboratory") || (choice.equals("Doctor"))))){
           // Set btnAdd invisible
           btnAdd.setVisible(false);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtSearch = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        btnAdd = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Test Results Records");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        txtSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSearchActionPerformed(evt);
            }
        });
        txtSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchKeyReleased(evt);
            }
        });

        jLabel1.setText("Search Patient");

        btnAdd.setText("Add to Form");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });
        btnAdd.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                btnAddKeyReleased(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Test Result ID", "Result", "Admission Number", "Patient ID", "Patient Name", "Test ID", "Test Name"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 277, Short.MAX_VALUE)
                .addComponent(btnAdd)
                .addGap(20, 20, 20))
            .addComponent(jScrollPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAdd))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSearchActionPerformed

    private void txtSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyReleased
        this.search();
    }//GEN-LAST:event_txtSearchKeyReleased

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        try{
            con=Connect.ConnectDB();
            
            // Select the particular row
            int row= jTable1.getSelectedRow();
            
            // Selecting data for a particular tr_id
            String table_click= jTable1.getModel().getValueAt(row, 0).toString();
            String query= "SELECT r.tr_id,r.tr_result_des,r.admit_id,p.patient_id,p.patient_name,t.test_id,t.test_name"
                    + " FROM patient p,admission a,test t,test_result r "
                    + "WHERE r.tr_id= '" + table_click +"' AND r.admit_id=a.admit_id AND p.patient_id=a.patient_id AND r.test_id=t.test_id";
            pst=con.prepareStatement(query);
            rs=  pst.executeQuery();
            
            // Add data to the required fields in the created Form Object
            if(rs.next()){
                if(flag==1 || flag==0){
                    this.hide();
                    // Create a new object from ManageTestResults Form Class
                    ManageTestResults frm = new ManageTestResults(choice,1);
                    frm.setVisible(true);

                    String addTRID=rs.getString("tr_id");
                    frm.txtTRID.setText(addTRID);

                    String addResult=rs.getString("tr_result_des");
                    frm.txtDes.setText(addResult);
                    
                    String addAdmitNo=rs.getString("admit_id");
                    frm.txtAdmitNo.setText(addAdmitNo);
                    
                    String addPatientID=rs.getString("patient_id");
                    frm.lbPatientID.setText(addPatientID);
                    
                    String addPatientName=rs.getString("patient_name");
                    frm.lbPatientName.setText(addPatientName);
                    
                    String addTestID=rs.getString("test_id");
                    frm.txtTestID.setText(addTestID);
                    
                    String addTestName=rs.getString("test_name");
                    frm.lbTestName.setText(addTestName);
                    
                    frm.btnSave.setEnabled(false);
                    frm.btnDelete.setEnabled(true);
                    frm.btnUpdate.setEnabled(true);
                }
                else{
                    this.hide();
                }
            }

        }catch(SQLException ex){
            JOptionPane.showMessageDialog(this,ex);
        }catch(ArrayIndexOutOfBoundsException ex){
            JOptionPane.showMessageDialog(this,"No row selected!");
        }
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnAddKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnAddKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAddKeyReleased

    
    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        this.hide();
        if (flag==1){
            // flag==1 means this form is called from ManageTestResults form, so will be redirected to the same form when window is closing
            ManageTestResults frm = new ManageTestResults(choice,1);
            frm.setVisible(true);
        }
    }//GEN-LAST:event_formWindowClosing

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
            java.util.logging.Logger.getLogger(TestResultRecord.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TestResultRecord.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TestResultRecord.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TestResultRecord.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TestResultRecord("",0).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables

    // Get data for jTable1 when this form is loading 
    private void getData() {
        con=Connect.ConnectDB();
        try{
            String query="SELECT r.tr_id,r.tr_result_des,r.admit_id,p.patient_id,p.patient_name,t.test_id,t.test_name"
                    + " FROM patient p,admission a,test t,test_result r "
                    + "WHERE r.admit_id=a.admit_id AND p.patient_id=a.patient_id AND r.test_id=t.test_id";
            pst=con.prepareStatement(query);
            rs= pst.executeQuery();
            DefaultTableModel registrationModel = (DefaultTableModel)jTable1.getModel();
            registrationModel.setRowCount(0);
            while(rs.next())
            {
                registrationModel.addRow(new Object[]{rs.getString(1),rs.getString(2),rs.getString(3),
                rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7)});
            }
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null, e);
        }
    }

    // Search patient, admission, test and test_result tables
    private void search() {
        try{
            con=Connect.ConnectDB();
            String query="SELECT r.tr_id,r.tr_result_des,r.admit_id,p.patient_id,p.patient_name,t.test_id,t.test_name"
                    + " FROM patient p,admission a,test t,test_result r "
                    + "WHERE (r.tr_id LIKE '%"+txtSearch.getText()+"%' OR r.tr_result_des LIKE '%"
                    +txtSearch.getText()+"%' OR r.admit_id LIKE '%"+txtSearch.getText()+"%' OR "
                    + "p.patient_id LIKE '%"+txtSearch.getText()+"%' OR "
                    +"p.patient_name LIKE '%"+ txtSearch.getText()+"%' OR "
                    +"t.test_id LIKE '%"+txtSearch.getText()+"%' OR "
                    +"t.test_name LIKE '%"+txtSearch.getText()+"%') AND "
                    + "r.admit_id=a.admit_id AND p.patient_id=a.patient_id AND r.test_id=t.test_id" ;
                    
            pst=con.prepareStatement(query);
            rs=pst.executeQuery();
            DefaultTableModel registrationModel = (DefaultTableModel)jTable1.getModel();
            registrationModel.setRowCount(0);
            while(rs.next())
            {
                registrationModel.addRow(new Object[]{rs.getString(1),rs.getString(2),rs.getString(3),
                rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7)});
            }
        } catch (SQLException e) {
           JOptionPane.showMessageDialog(null, e);
        }
    }
}