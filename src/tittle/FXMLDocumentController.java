/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tittle;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.util.Callback;

/**
 *
 * @author wku-cslab1
 */
public class FXMLDocumentController implements Initializable {
   // private TableView table = new TableView<Table1>();
     private ObservableList<ObservableList> data;
     @FXML
    private TextField txtName;

    @FXML
    private TextField txtAge;

    @FXML
    private TextField txtAddress;

    @FXML
    private Button txtbtn1;

    @FXML
    private Button txtbtn2;

    @FXML
    private TableView<Table1> table;

    @FXML
    private TableColumn<Table1, String> textName;

    @FXML
    private TableColumn<Table1, Integer> texAge;

    @FXML
    private TableColumn<Table1, String> textAddress;

    @FXML
    void add(ActionEvent event) {
        
 dbconnectionclass  ne = new dbconnectionclass();
                String sql = "Insert into registration (Name, Age, Address ) Values (?,?,?)";
                String nt = textName.getText();
                String ag = txtAge.getText();
                String ad = txtAddress.getText();
             
                try {
                    Connection con = ne.connMethod();

                    PreparedStatement pre;
                    try {
                        pre = con.prepareStatement(sql);
                        pre.setString(1, nt);
                        pre.setString(2, ag);
                        pre.setString(3, ad);
                       
                        int i = pre.executeUpdate();
                        if (i == 1) {

                            //AlertDialog.("info","Data Inserted succsecfully");
                            System.out.println("Data Inserted succsecfully");
                        }

                    } catch (SQLException ex) {
                        java.util.logging.Logger.getLogger(FXMLDocumentController.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                    }

//throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                } catch (ClassNotFoundException ex) {
                    java.util.logging.Logger.getLogger(FXMLDocumentController.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
                }
    }

    @FXML
    void view(ActionEvent event) throws SQLException {
        
        
        Connection con;
        ResultSet rs;
        data = FXCollections.observableArrayList();
        try {

           // table.setStyle("-fx-background-color:red; -fx-font-color:green ");
        dbconnectionclass ne = new dbconnectionclass();
            
            con = ne.connMethod();
                String SQL = "SELECT*FROM registration";
                rs = con.createStatement().executeQuery(SQL);
               for (int i = 0; i < rs.getMetaData().getColumnCount(); i++) {
               final int j = i;
                TableColumn col = new TableColumn(rs.getMetaData().getColumnName(i + 1));
                col.setCellValueFactory((Callback<TableColumn.CellDataFeatures<ObservableList, String>,
                   ObservableValue<String>>) param -> new SimpleStringProperty(param.getValue().get(j).toString()));

                table.getColumns().addAll(col);
                System.out.println("Column [" + i + "] ");

            }


            while (rs.next()) {
                ObservableList<String> row = FXCollections.observableArrayList();
                for (int i = 1; i <= rs.getMetaData().getColumnCount(); i++) {
                row.add(rs.getString(i));
                }
               System.out.println("Row[1]added " + row);
                data.add(row);

            }


           //able.setItems(data);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error ");
        }
            

 
};



    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
