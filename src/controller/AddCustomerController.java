package controller;

import DB.DBConnection;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AddCustomerController {
    public TextField txtId;
    public TextField txtName;
    public TextField txtAddress;
    public Button btnSave;
    public Button btnHome;


    public void btnSave_OnAction(ActionEvent actionEvent) {
        Connection connection = DBConnection.getInstance().getConnection();

        try {
            PreparedStatement insertQuery = connection.prepareStatement("INSERT INTO customer VALUES(?,?,?)");
            insertQuery.setString(1,txtId.getText());
            insertQuery.setString(2,txtName.getText());
            insertQuery.setString(3,txtAddress.getText());
            int affectedRow = insertQuery.executeUpdate();
            if(affectedRow>0){
                new Alert(Alert.AlertType.INFORMATION,"New Customer Added Successfully...").show();
                txtAddress.clear();
                txtId.clear();
                txtName.clear();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    public void btnHome_OnAction(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(this.getClass().getResource("/view/DashBoardForm.fxml"));
        Scene subScene = new Scene(root);
        Stage primaryStage = (Stage) this.btnSave.getScene().getWindow();
        primaryStage.setScene(subScene);
        primaryStage.centerOnScreen();
    }
}
