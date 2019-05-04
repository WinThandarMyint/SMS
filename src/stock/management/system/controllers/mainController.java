/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stock.management.system.controllers;

import stock.management.system.*;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import stock.management.system.dao.ProductDAO;

/**
 *
 * @author Win Thandar
 */
public class mainController implements Initializable {
    
   
    
    @FXML
    private BorderPane borderPane;
    @FXML
    private Button dashboardBtn;
    @FXML
    private Button productBtn;
    @FXML
    private HBox dashboardView;
    @FXML
    private Button inoutBtn;
    @FXML
    private Button lowStockBtn;
    @FXML
    private Button transactionBtn;
    @FXML
    private Label productLabel;
    @FXML
    private Label lowStockLabel;
    
    private ProductDAO productDAO;
    
        
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        dashboardBtn.setStyle(" -fx-background-color: #00acc1");
        productDAO=new ProductDAO();
        loadDashboardData();       
    }    

    @FXML
    private void showDashboardView(ActionEvent event) {        
        dashboardBtn.setStyle(" -fx-background-color: #00acc1");
        productBtn.setStyle(" -fx-background-color: transparent");
        inoutBtn.setStyle(" -fx-background-color: transparent");
        lowStockBtn.setStyle(" -fx-background-color: transparent");
        transactionBtn.setStyle(" -fx-background-color: transparent");
        
        borderPane.setCenter(dashboardView);
        loadDashboardData();
    }
         
    
    @FXML
    private void showProductView(ActionEvent event) throws IOException {
        productBtn.setStyle(" -fx-background-color: #00acc1");
        dashboardBtn.setStyle(" -fx-background-color: transparent");       
        inoutBtn.setStyle(" -fx-background-color: transparent");
        lowStockBtn.setStyle(" -fx-background-color: transparent");
        transactionBtn.setStyle(" -fx-background-color: transparent");
        
        Parent root = FXMLLoader.load(getClass().getResource("/stock/management/system/views/products.fxml"));
        
        borderPane.setCenter(root);
    }

    @FXML
    private void showinoutView(ActionEvent event) throws IOException {
        inoutBtn.setStyle(" -fx-background-color: #00acc1");
        dashboardBtn.setStyle(" -fx-background-color: transparent");
        productBtn.setStyle(" -fx-background-color: transparent");        
        lowStockBtn.setStyle(" -fx-background-color: transparent");
        transactionBtn.setStyle(" -fx-background-color: transparent");
        
        Parent root = FXMLLoader.load(getClass().getResource("/stock/management/system/views/inout.fxml"));
        
        borderPane.setCenter(root);
    }

    @FXML
    private void showLowStockView(ActionEvent event) throws IOException {
        lowStockBtn.setStyle(" -fx-background-color: #00acc1");
        dashboardBtn.setStyle(" -fx-background-color: transparent");
        productBtn.setStyle(" -fx-background-color: transparent");
        inoutBtn.setStyle(" -fx-background-color: transparent");        
        transactionBtn.setStyle(" -fx-background-color: transparent");
        
        Parent root = FXMLLoader.load(getClass().getResource("/stock/management/system/views/lowstock.fxml"));
        
        borderPane.setCenter(root);
    }

    @FXML
    private void showTransactionView(ActionEvent event) throws IOException {
        transactionBtn.setStyle(" -fx-background-color: #00acc1");
        dashboardBtn.setStyle(" -fx-background-color: transparent");
        productBtn.setStyle(" -fx-background-color: transparent");
        inoutBtn.setStyle(" -fx-background-color: transparent");
        lowStockBtn.setStyle(" -fx-background-color: transparent");
        
        Parent root = FXMLLoader.load(getClass().getResource("/stock/management/system/views/transactions.fxml"));       
        
        borderPane.setCenter(root);
    }

    private void loadDashboardData() {
        try {
            int productCount=productDAO.countProducts();
            int lowStockCount=productDAO.countLowStockProducts();
            productLabel.setText(String.valueOf(productCount));
            lowStockLabel.setText(String.valueOf(lowStockCount));
        } catch (SQLException ex) {
            Logger.getLogger(mainController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
