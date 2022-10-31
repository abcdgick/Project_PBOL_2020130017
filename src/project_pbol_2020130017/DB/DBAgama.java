/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project_pbol_2020130017.DB;

import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author acer
 */
public class DBAgama {
    private AgamaModel dt = new AgamaModel();
    
    public AgamaModel getAgamaModel(){
        return dt;
    }
    
    public void setAgamaModel(AgamaModel n){
        dt = n;
    }
    
    public ObservableList<AgamaModel> Load(){
        try {
            ObservableList<AgamaModel> tableData = FXCollections.observableArrayList();
            Koneksi con = new Koneksi();
            con.bukaKoneksi();
            con.statement = con.dbKoneksi.createStatement();
            ResultSet rs = con.statement.executeQuery("Select IDAgama, namaAgama, detilAgama, "
                    + "buffHP, buffMP, buffPAtk, buffPDef, buffMAtk, buffMDef, buffAtkS, buffSta, buffStaR, buffMPR, buffCrit "
                    + "from agama");
            int i = 1;
            while(rs.next()){
                AgamaModel d = new AgamaModel();
                d.setIDAgama(rs.getString("IDAgama"));
                d.setNamaAgama(rs.getString("namaAgama"));
                d.setDetilAgama(rs.getString("detilAgama"));
                
                d.setBuffHP(rs.getInt("buffHP"));
                d.setBuffMP(rs.getInt("buffMP"));
                d.setBuffPAtk(rs.getInt("buffPAtk"));
                d.setBuffPDef(rs.getInt("buffPDef"));
                d.setBuffMAtk(rs.getInt("buffMAtk"));
                d.setBuffMDef(rs.getInt("buffMDef"));
                d.setBuffAtkS(rs.getInt("buffAtkS"));
                d.setBuffSta(rs.getInt("buffSta"));
                d.setBuffStaR(rs.getInt("buffStaR"));
                d.setBuffMPR(rs.getInt("buffMPR"));
                d.setBuffCrit(rs.getInt("buffCrit"));
                
                tableData.add(d);
                i++;
            }
            con.tutupKoneksi();
            return tableData;
        } catch (Exception e) {
            return null;
        }
    }
    
    public ObservableList<String> getIDAgama(){
        try {
            ObservableList<String> listID = FXCollections.observableArrayList();
            Koneksi con = new Koneksi();
            con.bukaKoneksi();
            con.statement = con.dbKoneksi.createStatement();
            ResultSet rs = con.statement.executeQuery("Select IDAgama from agama");
            while(rs.next()){
                listID.add(rs.getString("IDAgama"));
            }
            con.tutupKoneksi();
            return listID;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }
    
    public int validasi(String ID){
        int val = 0;
        try {
            Koneksi con = new Koneksi();
            con.bukaKoneksi();
            con.statement = con.dbKoneksi.createStatement();
            ResultSet rs = con.statement.executeQuery("select count(*) as jml from agama where IDAgama = '" +ID+ "'");
            while(rs.next()) val = rs.getInt("jml");
            con.tutupKoneksi();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return val;
    }
    
    public boolean insert(){
        boolean berhasil = true;
        Koneksi con = new Koneksi();
        try {
            con.bukaKoneksi();
            con.preparedStatement = con.dbKoneksi.prepareStatement("insert into agama("
                    + "IDAgama, namaAgama, detilAgama, "
                    + "buffHP, buffMP, buffPAtk, buffPDef, buffMAtk, buffMDef, buffAtkS, buffSta, buffStaR, buffMPR, buffCrit) "
                    + "values (?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            
            con.preparedStatement.setString(1, getAgamaModel().getIDAgama());
            con.preparedStatement.setString(2, getAgamaModel().getNamaAgama());
            con.preparedStatement.setString(3, getAgamaModel().getDetilAgama());
            
            con.preparedStatement.setInt(4, getAgamaModel().getBuffHP());
            con.preparedStatement.setInt(5, getAgamaModel().getBuffMP());
            con.preparedStatement.setInt(6, getAgamaModel().getBuffPAtk());
            con.preparedStatement.setInt(7, getAgamaModel().getBuffPDef());
            con.preparedStatement.setInt(8, getAgamaModel().getBuffMAtk());
            con.preparedStatement.setInt(9, getAgamaModel().getBuffMDef());
            con.preparedStatement.setInt(10, getAgamaModel().getBuffAtkS());
            con.preparedStatement.setInt(11, getAgamaModel().getBuffSta());
            con.preparedStatement.setInt(12, getAgamaModel().getBuffStaR());
            con.preparedStatement.setInt(13, getAgamaModel().getBuffMPR());
            con.preparedStatement.setInt(14, getAgamaModel().getBuffCrit());
            
            con.preparedStatement.executeUpdate();
            berhasil = true;
        } catch (Exception e) {
            e.printStackTrace();
            berhasil = false;
        } finally{
            con.tutupKoneksi();
            return berhasil;
        }
    }
    
    public boolean delete(String ID){
        boolean berhasil = false;
        Koneksi con = new Koneksi();
        try {
            con.bukaKoneksi();
            con.preparedStatement = con.dbKoneksi.prepareStatement("delete from agama where IDAgama = ?");
            con.preparedStatement.setString(1, ID);
            con.preparedStatement.executeUpdate();
            berhasil = true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            con.tutupKoneksi();
            return berhasil;
        }
    }
    
    public boolean update(){
        boolean berhasil = false;
        Koneksi con = new Koneksi();
        
        try {
            con.bukaKoneksi();
            con.preparedStatement = con.dbKoneksi.prepareStatement("update agama set "
                    + "namaAgama=?, detilAgama=?, "
                    + "buffHP=?, buffMP=?, buffPAtk=?, buffPDef=?, buffMAtk=?, buffMDef=?, buffAtkS=?, buffSta=?, buffStaR=?, buffMPR=?, buffCrit=? "
                    + "where IDAgama = ?");
            
            con.preparedStatement.setString(1, getAgamaModel().getNamaAgama());
            con.preparedStatement.setString(2, getAgamaModel().getDetilAgama());
            
            con.preparedStatement.setInt(3, getAgamaModel().getBuffHP());
            con.preparedStatement.setInt(4, getAgamaModel().getBuffMP());
            con.preparedStatement.setInt(5, getAgamaModel().getBuffPAtk());
            con.preparedStatement.setInt(6, getAgamaModel().getBuffPDef());
            con.preparedStatement.setInt(7, getAgamaModel().getBuffMAtk());
            con.preparedStatement.setInt(8, getAgamaModel().getBuffMDef());
            con.preparedStatement.setInt(9, getAgamaModel().getBuffAtkS());
            con.preparedStatement.setInt(10, getAgamaModel().getBuffSta());
            con.preparedStatement.setInt(11, getAgamaModel().getBuffStaR());
            con.preparedStatement.setInt(12, getAgamaModel().getBuffMPR());
            con.preparedStatement.setInt(13, getAgamaModel().getBuffCrit());
            
            con.preparedStatement.setString(14, getAgamaModel().getIDAgama());
            
            con.preparedStatement.executeUpdate();
            berhasil = true;
        } catch (Exception e) {
            e.printStackTrace();
            berhasil = false;
        } finally{
            con.tutupKoneksi();
            return berhasil;
        }
    }
}
