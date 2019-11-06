package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class DashBoardController {
    public Button btnAdd;
    public Button btnDelete;
    public Button btnSearch;
    public Button btnUpdate;
    public AnchorPane mainForm;

    public void btnAdd_OnAction(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(this.getClass().getResource("/view/AddCustomerForm.fxml"));
        Scene subScene = new Scene(root);
        Stage primaryStage = (Stage) this.mainForm.getScene().getWindow();
        primaryStage.setScene(subScene);
        primaryStage.centerOnScreen();
    }

    public void btnDelete_OnAction(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(this.getClass().getResource("/view/AddCustomerForm.fxml"));
        Scene subScene = new Scene(root);
        Stage primaryStage = (Stage) this.mainForm.getScene().getWindow();
        primaryStage.setScene(subScene);
        primaryStage.centerOnScreen();
    }

    public void btnSearch_OnAction(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(this.getClass().getResource("/view/SearchCustomerForm.fxml"));
        Scene subScene = new Scene(root);
        Stage primaryStage = (Stage) this.mainForm.getScene().getWindow();
        primaryStage.setScene(subScene);
        primaryStage.centerOnScreen();
    }

    public void btnUpdate_OnAction(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(this.getClass().getResource("/view/AddCustomerForm.fxml"));
        Scene subScene = new Scene(root);
        Stage primaryStage = (Stage) this.mainForm.getScene().getWindow();
        primaryStage.setScene(subScene);
        primaryStage.centerOnScreen();
    }
}
