/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stock.management.system.util;

import javafx.scene.control.Alert;

/**
 *
 * @author Win Thandar
 */
public class MessageBox {
    public static void showInformationMessage(String title,String message){
        Alert alert=new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(null);
        alert.setTitle(title);
        alert.setContentText(message);        
        alert.show();
    }
    
     public static void showErrorMessage(String title,String message){
        Alert alert=new Alert(Alert.AlertType.ERROR);
        alert.setHeaderText(null);
        alert.setTitle(title);
        alert.setContentText(message);        
        alert.show();
    }
}
