/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CreateUser;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author wku-cslab1
 */
public class UserController implements Initializable {
    connection cc = new connection();
Connection conn = null;
PreparedStatement pst = null;
ResultSet rs = null;
    @FXML
    private TextField nametext;
    @FXML
    private TextField agetext;
    @FXML
    private TextField addtext;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void adduser(ActionEvent event) {
              try{
                conn = cc.connMethod();
               String sql = "INSERT INTO users (name,age,address) VALUES (?,?,?)";
               pst = conn.prepareStatement(sql);
               pst.setString(1, nametext.getText());
               pst.setString(2, agetext.getText());
               pst.setString(3, addtext.getText());
        
               pst.execute();
               clearData();
               JOptionPane.showMessageDialog(null, "User has been added");
           }catch(Exception e){
               JOptionPane.showMessageDialog(null, e);
           }
    } 
           public void clearData(){
         nametext.setText("");
         agetext.setText("");
         addtext.setText("");
        
    }
    
        
    }

   
    

