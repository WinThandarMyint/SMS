/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stock.management.system;

import java.io.IOException;
import java.sql.SQLException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import stock.management.system.database.Database;

/**
 *
 * @author Win Thandar
 */
public class StockManagementSystem extends Application {
    
    
    
    @Override
    public void start(Stage stage) throws IOException, SQLException{
        
       Database db=Database.getInstance();
        db.createDatabase();
        db.createTable();
        
        
        Parent root = FXMLLoader.load(getClass().getResource("/stock/management/system/views/main.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
        
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)  {
        
        launch(args);
    }
    
}
