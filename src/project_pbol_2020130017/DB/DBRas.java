/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project_pbol_2020130017.DB;

import java.sql.ResultSet;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author acer
 */
public class DBRas {
    private RasModel dt = new RasModel();
    
    public RasModel getRasModel(){
        return dt;
    }
    
    public void setRasModel(RasModel n){
        dt = n;
    }
    
    public ObservableList<RasModel> Load(){
        try {
            ObservableList<RasModel> tableData = FXCollections.observableArrayList();
            Koneksi con = new Koneksi();
            con.bukaKoneksi();
            con.statement = con.dbKoneksi.createStatement();
            ResultSet rs = con.statement.executeQuery("Select IDRas, namaRas, "
                    + "baseStr, baseAgi, baseDex, baseCon, baseInt, baseWis, baseLuck "
                    + "from ras");
            int i = 1;
            while(rs.next()){
                RasModel d = new RasModel();
                d.setIDRas(rs.getString("IDRas"));
                d.setNamaRas(rs.getString("namaRas"));
                
                d.setBaseStr(rs.getInt("baseStr"));
                d.setBaseAgi(rs.getInt("baseAgi"));
                d.setBaseDex(rs.getInt("baseDex"));
                d.setBaseCon(rs.getInt("baseCon"));
                d.setBaseInt(rs.getInt("baseInt"));
                d.setBaseWis(rs.getInt("baseWis"));
                d.setBaseLuck(rs.getInt("baseLuck"));
                
                tableData.add(d);
                i++;
            }
            con.tutupKoneksi();
            return tableData;
        } catch (Exception e) {
            return null;
        }
    }
    
    public int validasi(String ID){
        int val = 0;
        try {
            Koneksi con = new Koneksi();
            con.bukaKoneksi();
            con.statement = con.dbKoneksi.createStatement();
            ResultSet rs = con.statement.executeQuery("select count(*) as jml from ras where IDRas = '" +ID+ "'");
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
            con.preparedStatement = con.dbKoneksi.prepareStatement("insert into ras("
                    + "IDRas, namaRas, "
                    + "baseStr, baseAgi, baseDex, baseCon, baseInt, baseWis, baseLuck) "
                    + "values (?,?,?,?,?,?,?,?,?)");
            
            con.preparedStatement.setString(1, getRasModel().getIDRas());
            con.preparedStatement.setString(2, getRasModel().getNamaRas());
            
            con.preparedStatement.setInt(3, getRasModel().getBaseStr());
            con.preparedStatement.setInt(4, getRasModel().getBaseAgi());
            con.preparedStatement.setInt(5, getRasModel().getBaseDex());
            con.preparedStatement.setInt(6, getRasModel().getBaseCon());
            con.preparedStatement.setInt(7, getRasModel().getBaseInt());
            con.preparedStatement.setInt(8, getRasModel().getBaseWis());
            con.preparedStatement.setInt(9, getRasModel().getBaseLuck());
            
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
            con.preparedStatement = con.dbKoneksi.prepareStatement("delete from ras where IDRas = ?");
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
            con.preparedStatement = con.dbKoneksi.prepareStatement("update ras set "
                    + "namaRas=?, "
                    + "baseStr=?, baseAgi=?, baseDex=?, baseCon=?, baseInt=?, baseWis=?, baseLuck=? "
                    + "where IDRas = ?");
            
            con.preparedStatement.setString(1, getRasModel().getNamaRas());
            
            con.preparedStatement.setInt(2, getRasModel().getBaseStr());
            con.preparedStatement.setInt(3, getRasModel().getBaseAgi());
            con.preparedStatement.setInt(4, getRasModel().getBaseDex());
            con.preparedStatement.setInt(5, getRasModel().getBaseCon());
            con.preparedStatement.setInt(6, getRasModel().getBaseInt());
            con.preparedStatement.setInt(7, getRasModel().getBaseWis());
            con.preparedStatement.setInt(8, getRasModel().getBaseLuck());
            
            con.preparedStatement.setString(9, getRasModel().getIDRas());
            
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
