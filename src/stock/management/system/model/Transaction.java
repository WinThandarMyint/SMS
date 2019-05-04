/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stock.management.system.model;

import java.sql.Date;

/**
 *
 * @author Win Thandar
 */
public class Transaction {
    private int id;
    private String type;
    private int productId;
    private String productName;
    private int quantity; 
    private String remark;
    private String dateTime;

    public Transaction(int id, String type, String productName, int quantity, String remark, String dateTime) {
        this.id = id;
        this.type = type;
        this.productName = productName;
        this.quantity = quantity;
        this.remark = remark;
        this.dateTime = dateTime;
    }
    
    

    public Transaction(String type, int productId, int quantity, String remark) {
        this.type = type;
        this.productId = productId;
        this.quantity = quantity;
        this.remark = remark;
    }   
    
    public Transaction(int id, String type, int productId, int quantity, String remark, String dateTime) {
        this.id = id;
        this.type = type;
        this.productId = productId;
        this.quantity = quantity;
        this.remark = remark;
        this.dateTime = dateTime;
    }    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }
    
    


    
    

  
}
