/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ceyloncare.doctor;

import ceyloncare.user.DoctorUserRegistration;
import ceyloncare.doctor.Doctor;
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
public class DoctorRecord extends javax.swing.JFrame {
    Connection con = null;
    ResultSet rs = null;
    PreparedStatement pst = null;
    String type="";// To identify from which mode the control flow was passed 
    int flag=0;// To identify from which form this form was called
    /**
     * Creates new form DoctorRecord
     * @param t
     * @param n
     */
    public DoctorRecord(String t,int n) {
        initComponents();
        con= Connect.ConnectDB();
        
        // Get data for jTable1 when this form is loading 
        this.getData();
        
        setLocationRelativeTo(null);
        type=t;
        flag=n;
        // When this form is called from Admin/Receptionist mode or from the DoctorUserRegistration form
        if (!((type.equals("Administrator")) || (type.equals("Receptionist") || flag==2))){
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

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        txtSearchDoc = new javax.swing.JTextField();
        btnAdd = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Doctor Records");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Doc  ID", "Doc Name", "Doc NIC", "Gender", "Telephone", "Address", "Email Address", "Specialization", "Qualifications", "SLMC No", "Date Joined"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jLabel1.setText("Search Doctor");

        txtSearchDoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSearchDocActionPerformed(evt);
            }
        });
        txtSearchDoc.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchDocKeyReleased(evt);
            }
        });

        btnAdd.setText("Add to Form");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(txtSearchDoc, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 327, Short.MAX_VALUE)
                .addComponent(btnAdd)
                .addGap(20, 20, 20))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(17, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtSearchDoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAdd))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 335, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtSearchDocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSearchDocActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSearchDocActionPerformed

    // Add data to the Doctor/DoctorUserRegistration Form (when btnAdd button is clicked) based on the passed type
    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
       try{
            con=Connect.ConnectDB();
            
            // Select the particular row
            int row= jTable1.getSelectedRow();
            String table_click= jTable1.getModel().getValueAt(row, 0).toString();
            
            // Selecting data for a particular emp_id
            String query= "SELECT e.emp_id,e.emp_name,e.emp_nic,e.emp_gender,"
                    + "e.emp_tel,e.emp_address,e.emp_email,e.emp_salary,d.spec_name,"
                    + "d.doc_qualifications,d.doc_slmc_no,e.date_joined,d.doc_fee"
                    + " FROM employee e ,doctor d WHERE e.emp_id=d.emp_id AND e.emp_id= '" + table_click + "'";
            pst=con.prepareStatement(query);
            rs=  pst.executeQuery();
            
            // Add data to the required fields in the created Form Object
            if(rs.next()){
                switch (type) {
                    case "Administrator":
                    case "Receptionist":
                        {
                            this.hide();
                            // Create a new object from Doctor Form Class
                            Doctor frm = new Doctor(type);
                            frm.setVisible(true);
                            
                            String addID=rs.getString("emp_id");
                            frm.txtID.setText(addID);
                            
                            String addNIC=rs.getString("emp_nic");
                            frm.txtNIC.setText(addNIC);
                            
                            String addName=rs.getString("emp_name");
                            frm.txtName.setText(addName);
                            
                            String addSLMC=rs.getString("doc_slmc_no");
                            frm.txtSLMCNo.setText(addSLMC);
                            
                            String addContact=rs.getString("emp_tel");
                            frm.txtContact.setText(addContact);
                            
                            String addAddress=rs.getString("emp_address");
                            frm.txtAddress.setText(addAddress);
                            
                            String addEmail=rs.getString("emp_email");
                            frm.txtEmail.setText(addEmail);
                            
                            String addQual=rs.getString("doc_qualifications");
                            frm.txtQ.setText(addQual);
                            
                            String addGender=rs.getString("emp_gender");
                            frm.cmbGender.setSelectedItem(addGender);
                            
                            String addDate=rs.getString("date_joined");
                            frm.txtDate.setText(addDate);
                            
                            String addSpec=rs.getString("spec_name");
                            frm.txtSpecSearch.setText(addSpec);
                            
                            String addSalary=rs.getString("emp_salary");
                            frm.txtSalary.setText(addSalary);
                            
                            String addFee=rs.getString("doc_fee");
                            frm.txtFee.setText(addFee);
                            
                            frm.btnSave.setEnabled(false);
                            frm.btnDelete.setEnabled(true);
                            frm.btnUpdate.setEnabled(true);
                            break;
                        }
                    case "Doctor":
                        {
                            this.hide();
                            // Create a new object from DoctorUserRegistration Form Class
                            DoctorUserRegistration frm = new DoctorUserRegistration(type);
                            frm.setVisible(true);
                            String addID=rs.getString("emp_id");
                            frm.lbID.setText(addID);
                            String addName=rs.getString("emp_name");
                            frm.lbName.setText(addName);
                            break;
                        }
                    default:
                        this.hide();
                        break;
                }
            }
          
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(this,ex);
        }catch(ArrayIndexOutOfBoundsException ex){
            JOptionPane.showMessageDialog(this,"No row selected!");
        }
    }//GEN-LAST:event_btnAddActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        this.hide();
        // flag==1 means this form is called from Doctor form, so will be redirected to the same form when window is closing
        if (flag==1){
            Doctor frm = new Doctor(type);
            frm.setVisible(true);
        }
        // flag==2 means this form is called from DoctorUserRegistration form, so will be redirected to the same form when window is closing
        if (flag==2){
            DoctorUserRegistration frm = new DoctorUserRegistration(type);
            frm.setVisible(true);
        }
        
    }//GEN-LAST:event_formWindowClosing

    private void txtSearchDocKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchDocKeyReleased
        this.search();
    }//GEN-LAST:event_txtSearchDocKeyReleased

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
            java.util.logging.Logger.getLogger(DoctorRecord.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DoctorRecord.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DoctorRecord.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DoctorRecord.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DoctorRecord("",0).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField txtSearchDoc;
    // End of variables declaration//GEN-END:variables

    // Get data for jTable1 when this form is loading 
    private void getData() {
        con=Connect.ConnectDB();
        try{
            String query="SELECT e.emp_id,e.emp_name,e.emp_nic,e.emp_gender,"
                    + "e.emp_tel,e.emp_address,e.emp_email,d.spec_name,"
                    + "d.doc_qualifications,d.doc_slmc_no,e.date_joined"
                    + " FROM employee e ,doctor d WHERE e.emp_id=d.emp_id";
            pst=con.prepareStatement(query);
            rs= pst.executeQuery();
            DefaultTableModel registrationModel = (DefaultTableModel)jTable1.getModel();
            registrationModel.setRowCount(0);
            while(rs.next())
            {
                registrationModel.addRow(new Object[]{rs.getString(1),rs.getString(2),rs.getString(3),
                rs.getString(4),rs.getString(5),rs.getString(6),
                rs.getString(7),rs.getString(8),rs.getString(9),
                rs.getString(10),rs.getString(11)});
            }
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null, e);
        }
    }

    // Search doctor and employee tables
    private void search() {
        try{
            con=Connect.ConnectDB();
            String query="SELECT e.emp_id,e.emp_name,e.emp_nic,e.emp_gender,"
                    + "e.emp_tel,e.emp_address,e.emp_email,d.spec_name,"
                    + "d.doc_qualifications,d.doc_slmc_no,e.date_joined"
                    + " FROM employee e ,doctor d "
                    + "WHERE (e.emp_id LIKE '%"+txtSearchDoc.getText()+"%' OR e.emp_name LIKE '%"
                    +txtSearchDoc.getText()+"%' OR e.emp_nic LIKE '%"+txtSearchDoc.getText()+"%' OR "
                    + "e.emp_tel LIKE '%"+txtSearchDoc.getText()+"%' OR e.emp_address LIKE '%"+txtSearchDoc.getText()+"%' OR "
                    + "d.doc_qualifications LIKE '%"+txtSearchDoc.getText()+"%' OR "
                    + "d.spec_name LIKE '%"+txtSearchDoc.getText()+"%' OR e.date_joined LIKE '%"+txtSearchDoc.getText()+"%' OR "
                    + "e.emp_gender LIKE '%"+txtSearchDoc.getText()+"%' OR e.emp_email LIKE '%"+txtSearchDoc.getText()+"%' OR "
                    + "d.doc_slmc_no LIKE '%"+txtSearchDoc.getText()+"%') AND e.emp_id=d.emp_id";
            
            pst=con.prepareStatement(query);
            rs=pst.executeQuery();
            DefaultTableModel registrationModel = (DefaultTableModel)jTable1.getModel();
            registrationModel.setRowCount(0);
            while(rs.next())
            {
                registrationModel.addRow(new Object[]{rs.getString(1),rs.getString(2),rs.getString(3),
                rs.getString(4),rs.getString(5),rs.getString(6),
                rs.getString(7),rs.getString(8),rs.getString(9),
                rs.getString(10),rs.getString(11)});
            }
        } catch (SQLException e) {
           JOptionPane.showMessageDialog(null, e);
        }
    }
}