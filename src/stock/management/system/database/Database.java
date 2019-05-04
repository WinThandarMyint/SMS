/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stock.management.system.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Win Thandar
 */
public class Database {
    private String url="jdbc:mysql://localhost:3306/";
    private String user="root";
    private String password="";
    private static Database db;
    private Connection conn;
    
    private Database() throws SQLException{connect();}
    
    public static Database getInstance() throws SQLException{
        if(db==null){db=new Database();}
        return db;
    }
    
    public boolean connect() throws SQLException{
        conn=DriverManager.getConnection(url, user, password);
        return true;
    }
    
    public Connection getConnection(){
        return conn;
    }
    
    public void createDatabase() throws SQLException{
        Statement stmt=conn.createStatement();
        String sql="create database if not exists smsdb;";
        stmt.execute(sql);
    }
    
    public void createTable() throws SQLException{
        Statement stmt1=conn.createStatement();
        String sql1="create table if not exists smsdb.products (id int primary key, name varchar(60), price double, stock int);";
        stmt1.execute(sql1);
        
        Statement stmt2=conn.createStatement();
        String sql2="create table if not exists smsdb.transactions (id int primary key auto_increment, type varchar(20), product_id int, quantity int, remark varchar(255), date timestamp,foreign key (product_id) references products(id));";
        stmt2.execute(sql2);
    }
    
}
