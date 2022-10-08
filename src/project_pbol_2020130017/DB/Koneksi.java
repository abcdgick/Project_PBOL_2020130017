/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project_pbol_2020130017.DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

/**
 *
 * @author acer
 */
public class Koneksi {
    public Connection dbKoneksi;
    public Statement statement;
    public PreparedStatement preparedStatement;
    
    public Koneksi(){
        this.dbKoneksi = null;
    }
    
    public void bukaKoneksi(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            dbKoneksi = DriverManager.getConnection("jdbc:mysql://localhost:3306/project?user=root&password=root");
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    
    public void tutupKoneksi() {
        try{
            if(statement != null) statement.close();
            if(preparedStatement != null) preparedStatement.close();
            if(dbKoneksi != null) dbKoneksi.close();
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
