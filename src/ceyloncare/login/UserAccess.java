/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ceyloncare.login;

import ceyloncare.home.AdminHome;
import ceyloncare.home.DoctorHome;
import ceyloncare.home.LaboratoryHome;
import ceyloncare.home.ReceptionistHome;

/**
 *
 * @author Wasura Dananjith
 */

// Directs to the correct home based on the user type
class UserAccess {

    void grantAccess(String type,String username) {
        switch (type) {
            case "Administrator":
                AdminHome adminhome = new AdminHome(username);
                adminhome.setVisible(true);
                break;
            case "Receptionist":
                ReceptionistHome receptionisthome = new ReceptionistHome(username);
                receptionisthome.setVisible(true);
                break;
            case "Doctor":
                DoctorHome doctorhome = new DoctorHome(username);
                doctorhome.setVisible(true);
                break;
            case "Laboratory":
                LaboratoryHome laboratoryhome = new LaboratoryHome(username);
                laboratoryhome.setVisible(true);
                break;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            default:
                break;
        }
    }
}
