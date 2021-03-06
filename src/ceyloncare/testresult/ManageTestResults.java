/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ceyloncare.testresult;

import ceyloncare.login.Connect;
import java.awt.HeadlessException;
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
public class ManageTestResults extends javax.swing.JFrame {
    Connection con = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    String choice = "";// To identify from which mode the control flow was passed 
    int flag = 0;// To identify from which form this form was called
    int testCount = 0; // To generate new test_id
    /**
     * Creates new form ManageTestResults
     * @param ch
     * @param n
     */
    public ManageTestResults(String ch,int n) {
        initComponents();
        setLocationRelativeTo(null);
        choice = ch;
        flag = n;
        
        // Generates new tr_id for each new test_result record
        this.generateID();
        
        // Get data for jTable1 when this form is loading 
        this.getData1();
        
        // Get data for jTable2 when this form is loading 
        this.getData2();
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
        jLabel7 = new javax.swing.JLabel();
        txtTRID = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtDes = new javax.swing.JTextArea();
        jPanel3 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtTestID = new javax.swing.JTextField();
        lbTestName = new javax.swing.JLabel();
        btnGetTest = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        btnGetPatient = new javax.swing.JButton();
        lbPatientName = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtAdmitNo = new javax.swing.JTextField();
        lbPatientID = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        btnNew = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnGetData = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Manage Test Results");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Test Result Details"));

        jLabel1.setText("Test Result ID");

        jLabel7.setText("Results");

        txtDes.setColumns(20);
        txtDes.setRows(5);
        jScrollPane1.setViewportView(txtDes);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 64, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1)
                    .addComponent(txtTRID))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtTRID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Test Details"));

        jLabel5.setText("Test ID");

        jLabel6.setText("Test Name");

        txtTestID.setText("Search here");
        txtTestID.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTestIDKeyReleased(evt);
            }
        });

        btnGetTest.setText("Get Details");
        btnGetTest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGetTestActionPerformed(evt);
            }
        });

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Test ID", "Test Name"
            }
        ));
        jScrollPane3.setViewportView(jTable2);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnGetTest)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))
                        .addGap(84, 84, 84)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtTestID, javax.swing.GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE)
                            .addComponent(lbTestName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 368, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtTestID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(lbTestName, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                .addComponent(btnGetTest))
            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Patient Details"));

        jLabel8.setText("Patient ID");

        jLabel2.setText("Patient Name");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Admission Number", "Patient ID", "Patient Name"
            }
        ));
        jScrollPane2.setViewportView(jTable1);

        btnGetPatient.setText("Get Details");
        btnGetPatient.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGetPatientActionPerformed(evt);
            }
        });

        jLabel9.setText("Admission No");

        txtAdmitNo.setText("Search here");
        txtAdmitNo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAdmitNoActionPerformed(evt);
            }
        });
        txtAdmitNo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtAdmitNoKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnGetPatient)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanel4Layout.createSequentialGroup()
                                    .addComponent(jLabel8)
                                    .addGap(34, 34, 34)))
                            .addComponent(jLabel9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 68, Short.MAX_VALUE)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lbPatientID, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtAdmitNo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE)
                            .addComponent(lbPatientName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 362, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtAdmitNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(lbPatientID, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(lbPatientName, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnGetPatient)
                .addGap(23, 23, 23))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        btnNew.setText("New");
        btnNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewActionPerformed(evt);
            }
        });

        btnSave.setText("Save");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        btnDelete.setText("Delete");
        btnDelete.setEnabled(false);
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnUpdate.setText("Update");
        btnUpdate.setEnabled(false);
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnGetData.setText("Get Data");
        btnGetData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGetDataActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(30, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnGetData, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnNew, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnSave, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnDelete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnUpdate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(28, 28, 28))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnNew)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSave)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnDelete)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnUpdate)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnGetData)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(88, 88, 88)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGetPatientActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGetPatientActionPerformed
        try{
            con=Connect.ConnectDB();
            
            // Select the particular row
            int row= jTable1.getSelectedRow();
            String table_click= jTable1.getModel().getValueAt(row, 0).toString();

            // Get data for particular admit_id
            String query= "SELECT a.admit_id,a.patient_id,p.patient_name "
            + "FROM admission a,patient p WHERE a.admit_id= '" + table_click + "' "
            + "AND a.patient_id=p.patient_id";
            pst=con.prepareStatement(query);
            rs=  pst.executeQuery();
            
            // Add data to the required fields
            if(rs.next()){
                String addNo=rs.getString("admit_id");
                this.txtAdmitNo.setText(addNo);

                String addPatientID=rs.getString("patient_id");
                this.lbPatientID.setText(addPatientID);

                String addPatientName=rs.getString("patient_name");
                this.lbPatientName.setText(addPatientName);
            }
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(this,ex);
        }catch(ArrayIndexOutOfBoundsException ex){
            JOptionPane.showMessageDialog(this,"No row selected!");
        }
    }//GEN-LAST:event_btnGetPatientActionPerformed

    private void txtAdmitNoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAdmitNoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAdmitNoActionPerformed

    private void txtAdmitNoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAdmitNoKeyReleased
        this.search1();
    }//GEN-LAST:event_txtAdmitNoKeyReleased

    private void btnGetTestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGetTestActionPerformed
        try{
            con=Connect.ConnectDB();
            
            // Select the particular row
            int row= jTable2.getSelectedRow();
            String table_click= jTable2.getModel().getValueAt(row, 0).toString();

            // Get data for particular test_id
            String query= "SELECT * FROM test WHERE test_id= '" + table_click + "'";
            pst=con.prepareStatement(query);
            rs=  pst.executeQuery();
            
            // Add data to the required fields
            if(rs.next()){
                String addNo=rs.getString("test_id");
                this.txtTestID.setText(addNo);

                String addName=rs.getString("test_name");
                this.lbTestName.setText(addName);
            }
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(this,ex);
        }catch(ArrayIndexOutOfBoundsException ex){
            JOptionPane.showMessageDialog(this,"No row selected!");
        }
    }//GEN-LAST:event_btnGetTestActionPerformed

    private void btnNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewActionPerformed
        this.clear();
    }//GEN-LAST:event_btnNewActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        try{
            con=Connect.ConnectDB();
            String resultsID,des,admitID,testID;
            resultsID=txtTRID.getText();
            des=txtDes.getText();
            admitID=txtAdmitNo.getText();
            testID=txtTestID.getText();

            // Checking whether the necessary fields are empty before inserting data
            if (resultsID.equals("")) {
                JOptionPane.showMessageDialog( this, "Please enter Test Results ID","Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            if (des.equals("")) {
                JOptionPane.showMessageDialog( this, "Please enter Results Description","Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            if (admitID.equals("") || admitID.equals("Search here")) {
                JOptionPane.showMessageDialog( this, "Please enter Admission Number","Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            if (testID.equals("") || testID.equals("Search here")) {
                JOptionPane.showMessageDialog( this, "Please enter Test ID","Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
  
            // Checking whether the entered tr_id is already in the table
            String query1="SELECT tr_id FROM test_result WHERE tr_id='"+resultsID+"';";
            pst=con.prepareStatement(query1);
            rs=pst.executeQuery(query1);

            if(rs.next()){
                JOptionPane.showMessageDialog( this, "Test Result ID already exists","Error", JOptionPane.ERROR_MESSAGE);
                txtTRID.setText("");
                txtTRID.requestDefaultFocus();
                return;
            }

            // Query to insert data into test_result table
            String query2= "INSERT INTO test_result "
            + "VALUES('"+ resultsID + "','"
            + admitID + "','" + testID + "','"+ des+ "')";

            pst=con.prepareStatement(query2);
            pst.execute();

            JOptionPane.showMessageDialog(this,"Successfully Inserted","Success",JOptionPane.INFORMATION_MESSAGE);
            btnSave.setEnabled(false);

        } catch (HeadlessException | SQLException ex){
            JOptionPane.showMessageDialog(this,ex);
        }
    }//GEN-LAST:event_btnSaveActionPerformed

    // To delete a particular record regarding a test_result
    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed

        try {
            int x = JOptionPane.showConfirmDialog(null," Are you sure want to delete ?","Confirm",JOptionPane.YES_NO_OPTION);
            if (x==0)
            {
                con=Connect.ConnectDB();

                String query1= "DELETE FROM test_result WHERE tr_id = '" + txtTRID.getText() + "'";
                pst=con.prepareStatement(query1);
                pst.execute();

                JOptionPane.showMessageDialog(this,"Successfully Deleted","Success",JOptionPane.INFORMATION_MESSAGE);
                this.clear();
            }
        }catch(HeadlessException | SQLException ex){
            JOptionPane.showMessageDialog(this,ex);
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    // To update details regarding a particular test_result 
    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        try {
            con=Connect.ConnectDB();
            
            String query1= "UPDATE test_result "
            + "SET tr_id='" + txtTRID.getText() + "',admit_id='" + txtAdmitNo.getText()
            + "',test_id='" + txtTestID.getText()+"',tr_result_des='" + txtDes.getText()
            + "' WHERE tr_id='" + txtTRID.getText() + "'";

            pst=con.prepareStatement(query1);
            pst.execute();

            JOptionPane.showMessageDialog(this,"Successfully Updated","Success",JOptionPane.INFORMATION_MESSAGE);
            btnUpdate.setEnabled(false);

        }catch(HeadlessException | SQLException ex){
            JOptionPane.showMessageDialog(this,ex);
        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnGetDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGetDataActionPerformed
        this.hide();
        // Load TestResultRecord form to select already inserted doctor details
        TestResultRecord frm = new TestResultRecord(choice,1);
        frm.setVisible(true);
    }//GEN-LAST:event_btnGetDataActionPerformed

    private void txtTestIDKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTestIDKeyReleased
        this.search2();
    }//GEN-LAST:event_txtTestIDKeyReleased

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        this.hide();
    }//GEN-LAST:event_formWindowClosing

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowClosed

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
            java.util.logging.Logger.getLogger(ManageTestResults.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ManageTestResults.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ManageTestResults.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ManageTestResults.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ManageTestResults(null,0).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnDelete;
    private javax.swing.JButton btnGetData;
    private javax.swing.JButton btnGetPatient;
    private javax.swing.JButton btnGetTest;
    private javax.swing.JButton btnNew;
    public javax.swing.JButton btnSave;
    public javax.swing.JButton btnUpdate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
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
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    public javax.swing.JLabel lbPatientID;
    public javax.swing.JLabel lbPatientName;
    public javax.swing.JLabel lbTestName;
    public javax.swing.JTextField txtAdmitNo;
    public javax.swing.JTextArea txtDes;
    public javax.swing.JTextField txtTRID;
    public javax.swing.JTextField txtTestID;
    // End of variables declaration//GEN-END:variables

    // Get data for jTable1 when this form is loading 
    private void getData1() {
        con=Connect.ConnectDB();
        try{
            String query="SELECT a.admit_id,p.patient_id,p.patient_name FROM patient p,admission a"
                    + " WHERE p.patient_id=a.patient_id";
            pst=con.prepareStatement(query);
            rs= pst.executeQuery();
            DefaultTableModel registrationModel = (DefaultTableModel)jTable1.getModel();
            registrationModel.setRowCount(0);
            while(rs.next())
            {
                registrationModel.addRow(new Object[]{rs.getString(1),rs.getString(2),rs.getString(3)});
            }
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null, e);
        }
    }

    // Get data for jTable2 when this form is loading 
    private void getData2() {
        con=Connect.ConnectDB();
        try{
            String query="SELECT * FROM test";
            pst=con.prepareStatement(query);
            rs= pst.executeQuery();
            DefaultTableModel registrationModel = (DefaultTableModel)jTable2.getModel();
            registrationModel.setRowCount(0);
            while(rs.next())
            {
                registrationModel.addRow(new Object[]{rs.getString(1),rs.getString(2)});
            }
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null, e);
        }
    }

    // Search patient and admission tables
    private void search1() {
        try{
            con=Connect.ConnectDB();
            String query="SELECT a.admit_id,p.patient_id,p.patient_name FROM patient p,admission a"
                    + " WHERE (a.admit_id LIKE '%"+txtAdmitNo.getText()+"%' OR p.patient_id LIKE '%"
                    +txtAdmitNo.getText()+"%' OR p.patient_name LIKE '%"
                    +txtAdmitNo.getText()+"%') AND p.patient_id=a.patient_id";
            
            pst=con.prepareStatement(query);
            rs=pst.executeQuery();
            DefaultTableModel registrationModel = (DefaultTableModel)jTable1.getModel();
            registrationModel.setRowCount(0);
            while(rs.next())
            {
                registrationModel.addRow(new Object[]{rs.getString(1),rs.getString(2),rs.getString(3)});
            }
        } catch (SQLException e) {
           JOptionPane.showMessageDialog(null, e);
        }
    }

    // Search test table
    private void search2() {
        try{
            con=Connect.ConnectDB();
            String query="SELECT * FROM test "
                    + "WHERE test_id LIKE '%"+txtTestID.getText()+"%' OR test_name LIKE '%"
                    +txtTestID.getText()+"%'";
            pst=con.prepareStatement(query);
            rs=pst.executeQuery();
            DefaultTableModel registrationModel = (DefaultTableModel)jTable2.getModel();
            registrationModel.setRowCount(0);
            while(rs.next())
            {
                registrationModel.addRow(new Object[]{rs.getString(1),rs.getString(2),
                    rs.getString(3)});
            }
        } catch (SQLException e) {
           JOptionPane.showMessageDialog(null, e);
        }
    }

    // Reset all the fields
    private void clear() {
        this.generateID();
        txtDes.setText("");
        lbPatientName.setText("");
        txtTestID.setText("Search here");
        lbTestName.setText("");
        txtAdmitNo.setText("Search here");
        lbPatientID.setText("");
        
        btnUpdate.setEnabled(false);
        btnSave.setEnabled(true);
        btnDelete.setEnabled(false);
        lbPatientID.requestDefaultFocus();
    }

    // Generates new tr_id for each new test_result record
    private void generateID() {
        try{
            con = Connect.ConnectDB();
            String query = "SELECT tr_id FROM test_result ORDER BY tr_id";
            pst=con.prepareStatement(query);
            rs=pst.executeQuery();
            rs.last();
            testCount = Integer.parseInt(rs.getString(1))+1;
            txtTRID.setText(Integer.toString(testCount));
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(this,ex);
        }
    }

}
