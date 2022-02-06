/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fxmltry;

import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author wku-cslab1
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private Label label;
    @FXML
    private TextField usertext;
    @FXML
    private TextField passtext;
   ConnectionToDatabase cc = new ConnectionToDatabase();
    Connection conn = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    /**
     * Creates new form Login
     */
  
   
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void login(ActionEvent event) {
        
            try {
            conn = cc.connMethod();
            String sql = "SELECT username,password FROM login WHERE username=? AND password=?";
            pst = conn.prepareStatement(sql);
            pst.setString(1, usertext.getText());
            pst.setString(2, passtext.getText());
            rs = pst.executeQuery();
            clearData(); 
            if (rs.next()) {
                conn.close();
                JOptionPane.showMessageDialog(null, "Welcome " + usertext.getText());
              
               // MainPanel mp = new MainPanel();
               // mp.loggedInAsLbl.setText(passtext.getText());
                //  close();
               // mp.setVisible(true);
            } else {
                conn.close();
                JOptionPane.showMessageDialog(null, "Please check your username and password and try again!");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
       
        
    }
     public void clearData(){
         usertext.setText("");
         passtext.setText("");
      
        
    }  
    
}
