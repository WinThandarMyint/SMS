/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stock.management.system.controllers;

import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.HBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.converter.DoubleStringConverter;
import stock.management.system.dao.ProductDAO;
import stock.management.system.model.Product;
import stock.management.system.util.MessageBox;

/**
 * FXML Controller class
 *
 * @author Win Thandar
 */
public class ProductsController implements Initializable {

    @FXML
    private Button addBtn;
    @FXML
    private TableView<Product> productTable;
    @FXML
    private TableColumn<Product,Integer> idColumn;
    @FXML
    private TableColumn<Product,String> nameColumn;
    @FXML
    private TableColumn<Product,Double> priceColumn;
    @FXML
    private TableColumn<Product, Integer> stockColumn;
    
      
   @FXML
    private MenuItem deleteItem;
    
   private ProductDAO productDAO;
    @FXML
    private JFXTextField nameSearchField;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        productDAO=new ProductDAO();
        productTable.setEditable(true);
        nameColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        priceColumn.setCellFactory(TextFieldTableCell.forTableColumn(new DoubleStringConverter()));
        initColumns();
        loadProductWindow();
       
    }    

    @FXML
    private void loadNewProductWindow() throws IOException {
         
        Parent root = FXMLLoader.load(getClass().getResource("/stock/management/system/views/newproduct.fxml"));
        
        Scene scene = new Scene(root);
        Stage stage=new Stage();
        stage.initOwner(addBtn.getScene().getWindow());
        stage.initModality(Modality.WINDOW_MODAL);
        stage.setScene(scene);
        stage.showAndWait();
        loadProductWindow();
    }

    private void initColumns() {
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        priceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));
        stockColumn.setCellValueFactory(new PropertyValueFactory<>("stock"));
    }

    private void loadProductWindow() {  
        try {
            List<Product> products=productDAO.getProducts();
            productTable.getItems().setAll(products);
        } catch (SQLException ex) {
            Logger.getLogger(ProductsController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void deleteProduct(ActionEvent event) {
        //Get Selected Item
        Product selectedProduct=productTable.getSelectionModel().getSelectedItem();
        
        //Validating
        if(selectedProduct==null){

            MessageBox.showErrorMessage("Error", "Please select the item u want to delete");           
            
            return;
        }
            Alert alert=new Alert(Alert.AlertType.CONFIRMATION);
            alert.setContentText("Are u sure, u want to delete this item?");
            alert.setHeaderText(null);
            alert.setTitle("Confirmation");
            Optional<ButtonType> option=alert.showAndWait();
            
            if(option.get()==ButtonType.OK){
          try {
            //Delete
            productDAO.deleteProduct(selectedProduct.getId());
            productTable.getItems().remove(selectedProduct);
        } catch (SQLException ex) {
            Logger.getLogger(ProductsController.class.getName()).log(Level.SEVERE, null, ex);
        }
      
    }
   
    }
    @FXML
    private void updateProductName(TableColumn.CellEditEvent<Product, String> event) {
        Product product=event.getRowValue();
        product.setName(event.getNewValue());
        
        try {
            productDAO.updateProduct(product);
        } catch (SQLException ex) {
            Logger.getLogger(ProductsController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @FXML
    private void updateProductPrice(TableColumn.CellEditEvent<Product, Double> event) {
         Product product=event.getRowValue();
        product.setPrice(event.getNewValue());
        
        try {
            productDAO.updateProduct(product);
        } catch (SQLException ex) {
            Logger.getLogger(ProductsController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void searchProductByName(ActionEvent event) {
        String query=nameSearchField.getText();
        try {
            List<Product> products= productDAO.getProductByName(query);
            productTable.getItems().setAll(products);
        } catch (SQLException ex) {
            Logger.getLogger(ProductsController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

   
}
