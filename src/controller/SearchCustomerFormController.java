package controller;

import DB.DBConnection;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import util.CustomerTM;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class SearchCustomerFormController implements Initializable  {

    @FXML
    private TextField txtSearch;

    @FXML
    private TableView<CustomerTM> tblCustomer;

    @FXML
    private TableColumn<CustomerTM, String> colId;

    @FXML
    private TableColumn<CustomerTM, String> colName;

    @FXML
    private TableColumn<CustomerTM, String> colAddress;

    Connection connection;
    PreparedStatement psSelect;
    ResultSet rs;
    ObservableList<CustomerTM> customers;



    @Override
    public void initialize(URL location, ResourceBundle resources) {
        connection = DBConnection.getInstance().getConnection();
        tblCustomer.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("id"));
        tblCustomer.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("name"));
        tblCustomer.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("address"));
        customers = tblCustomer.getItems();

        loadTable();

        txtSearch.textProperty().addListener(new ChangeListener<String>() {
           @Override
           public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
               loadTable();
               System.out.println("rr");
           }
       });
    }

    public void loadTable(){

        try {
            psSelect = connection.prepareStatement("SELECT * FROM customer c WHERE c.id LIKE ? OR c.name LIKE ? OR c.address LIKE ?");
            psSelect.setString(1,"%"+txtSearch.getText()+"%");
            psSelect.setString(2,"%"+txtSearch.getText()+"%");
            psSelect.setString(3,"%"+txtSearch.getText()+"%");
            rs = psSelect.executeQuery();
            while (rs.next()){
                customers.add(new CustomerTM(rs.getString("id"),rs.getString("name"),rs.getString("address")));
            }
            tblCustomer.setItems(customers);
        } catch (SQLException e) {
            e.printStackTrace();
        }
       


    }
}
