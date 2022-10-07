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
public class DBHero {
    private HeroModel dt = new HeroModel();
    
    public HeroModel getHeroModel(){
        return dt;
    }
    
    public void setHeroModel(HeroModel n){
        dt = n;
    }
    
    public ObservableList<HeroModel> Load(){
        try {
            ObservableList<HeroModel> tableData = FXCollections.observableArrayList();
            Koneksi con = new Koneksi();
            con.bukaKoneksi();
            con.statement = con.dbKoneksi.createStatement();
            ResultSet rs = con.statement.executeQuery("Select IDHero, namaHero, "
                    + "IDTanda, IDKelas, IDRas, creationDate "
                    + "from hero");
            int i = 1;
            while(rs.next()){
                HeroModel d = new HeroModel();
                d.setIDHero(rs.getString("IDHero"));
                d.setNamaHero(rs.getString("namaHero"));
                d.setIDTanda(rs.getString("IDTanda"));
                d.setIDKelas(rs.getString("IDKelas"));
                d.setIDRas(rs.getString("IDRas"));
                d.setCreationDate(rs.getDate("creationDate"));
                
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
            ResultSet rs = con.statement.executeQuery("select count(*) as jml from hero where IDHero = '" +ID+ "'");
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
            con.preparedStatement = con.dbKoneksi.prepareStatement("insert into hero("
                    + "IDHero, namaHero, "
                    + "IDTanda, IDKelas, IDRas, creationDate) "
                    + "values (?,?,?,?,?,?,?)");
            
            con.preparedStatement.setString(1, getHeroModel().getIDHero());
            con.preparedStatement.setString(2, getHeroModel().getNamaHero());
            con.preparedStatement.setString(3, getHeroModel().getIDTanda());
            con.preparedStatement.setString(4, getHeroModel().getIDKelas());
            con.preparedStatement.setString(5, getHeroModel().getIDRas());
            con.preparedStatement.setDate(6, getHeroModel().getCreationDate());
            
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
            con.preparedStatement = con.dbKoneksi.prepareStatement("delete from hero where IDHero = ?");
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
            con.preparedStatement = con.dbKoneksi.prepareStatement("update hero set "
                    + "namaHero=?, IDTanda=?, IDKelas=?, IDRas=?"
                    + "where IDHero = ?");
            
            con.preparedStatement.setString(1, getHeroModel().getNamaHero());
            
            con.preparedStatement.setString(2, getHeroModel().getIDTanda());
            con.preparedStatement.setString(3, getHeroModel().getIDKelas());
            con.preparedStatement.setString(4, getHeroModel().getIDRas());
            con.preparedStatement.setString(5, getHeroModel().getIDHero());
            
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
