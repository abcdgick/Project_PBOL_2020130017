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
public class DBTanda {
    private TandaModel dt = new TandaModel();
    
    public TandaModel getTandaModel(){
        return dt;
    }
    
    public void setTandaModel(TandaModel n){
        dt = n;
    }
    
    public ObservableList<TandaModel> Load(){
        try {
            ObservableList<TandaModel> tableData = FXCollections.observableArrayList();
            Koneksi con = new Koneksi();
            con.bukaKoneksi();
            con.statement = con.dbKoneksi.createStatement();
            ResultSet rs = con.statement.executeQuery("Select IDTanda, namaTanda, detilTanda, "
                    + "buffHP, buffMP, buffPAtk, buffPDef, buffMAtk, buffMDef, buffAtkS, buffSta, buffStaR, buffMPR, buffCrit "
                    + "from tanda");
            int i = 1;
            while(rs.next()){
                TandaModel d = new TandaModel();
                d.setIDTanda(rs.getString("IDTanda"));
                d.setNamaTanda(rs.getString("namaTanda"));
                d.setDetilTanda(rs.getString("detilTanda"));
                
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
    
    public ObservableList<String> getIDTanda(){
        try {
            ObservableList<String> listID = FXCollections.observableArrayList();
            Koneksi con = new Koneksi();
            con.bukaKoneksi();
            con.statement = con.dbKoneksi.createStatement();
            ResultSet rs = con.statement.executeQuery("Select IDTanda from tanda");
            while(rs.next()){
                listID.add(rs.getString("IDTanda"));
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
            ResultSet rs = con.statement.executeQuery("select count(*) as jml from tanda where IDTanda = '" +ID+ "'");
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
            con.preparedStatement = con.dbKoneksi.prepareStatement("insert into tanda("
                    + "IDTanda, namaTanda, detilTanda, "
                    + "buffHP, buffMP, buffPAtk, buffPDef, buffMAtk, buffMDef, buffAtkS, buffSta, buffStaR, buffMPR, buffCrit) "
                    + "values (?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            
            con.preparedStatement.setString(1, getTandaModel().getIDTanda());
            con.preparedStatement.setString(2, getTandaModel().getNamaTanda());
            con.preparedStatement.setString(3, getTandaModel().getDetilTanda());
            
            con.preparedStatement.setInt(4, getTandaModel().getBuffHP());
            con.preparedStatement.setInt(5, getTandaModel().getBuffMP());
            con.preparedStatement.setInt(6, getTandaModel().getBuffPAtk());
            con.preparedStatement.setInt(7, getTandaModel().getBuffPDef());
            con.preparedStatement.setInt(8, getTandaModel().getBuffMAtk());
            con.preparedStatement.setInt(9, getTandaModel().getBuffMDef());
            con.preparedStatement.setInt(10, getTandaModel().getBuffAtkS());
            con.preparedStatement.setInt(11, getTandaModel().getBuffSta());
            con.preparedStatement.setInt(12, getTandaModel().getBuffStaR());
            con.preparedStatement.setInt(13, getTandaModel().getBuffMPR());
            con.preparedStatement.setInt(14, getTandaModel().getBuffCrit());
            
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
            con.preparedStatement = con.dbKoneksi.prepareStatement("delete from tanda where IDTanda = ?");
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
            con.preparedStatement = con.dbKoneksi.prepareStatement("update tanda set "
                    + "namaTanda=?, detilTanda=?, "
                    + "buffHP=?, buffMP=?, buffPAtk=?, buffPDef=?, buffMAtk=?, buffMDef=?, buffAtkS=?, buffSta=?, buffStaR=?, buffMPR=?, buffCrit=? "
                    + "where IDTanda = ?");
            
            con.preparedStatement.setString(1, getTandaModel().getNamaTanda());
            con.preparedStatement.setString(2, getTandaModel().getDetilTanda());
            
            con.preparedStatement.setInt(3, getTandaModel().getBuffHP());
            con.preparedStatement.setInt(4, getTandaModel().getBuffMP());
            con.preparedStatement.setInt(5, getTandaModel().getBuffPAtk());
            con.preparedStatement.setInt(6, getTandaModel().getBuffPDef());
            con.preparedStatement.setInt(7, getTandaModel().getBuffMAtk());
            con.preparedStatement.setInt(8, getTandaModel().getBuffMDef());
            con.preparedStatement.setInt(9, getTandaModel().getBuffAtkS());
            con.preparedStatement.setInt(10, getTandaModel().getBuffSta());
            con.preparedStatement.setInt(11, getTandaModel().getBuffStaR());
            con.preparedStatement.setInt(12, getTandaModel().getBuffMPR());
            con.preparedStatement.setInt(13, getTandaModel().getBuffCrit());
            
            con.preparedStatement.setString(14, getTandaModel().getIDTanda());
            
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
