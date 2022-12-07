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
                    + "IDTanda,  IDKelas, IDRas, IDAgama, creationDate, "
                    + "namaTanda, namaKelas, namaRas, namaAgama "
                    + "from hero inner join tanda using (IDTanda) "
                    + "inner join kelas using (IDKelas) "
                    + "inner join ras using (IDRas) "
                    + "inner join agama using (IDAgama)");
            int i = 1;
            while(rs.next()){
                HeroModel d = new HeroModel();
                d.setIDHero(rs.getString("IDHero"));
                d.setNamaHero(rs.getString("namaHero"));
                d.setIDTanda(rs.getString("IDTanda"));
                d.setIDKelas(rs.getString("IDKelas"));
                d.setIDRas(rs.getString("IDRas"));
                d.setIDAgama(rs.getString("IDAgama"));
                d.setCreationDate(rs.getDate("creationDate"));
                
                d.setNamaTanda(rs.getString("namaTanda"));
                d.setNamaKelas(rs.getString("namaKelas"));
                d.setNamaRas(rs.getString("namaRas"));
                d.setNamaAgama(rs.getString("namaAgama"));
                
                tableData.add(d);
                i++;
            }
            con.tutupKoneksi();
            return tableData;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public HeroModel LoadOne(String IDHero){
        try {
            Koneksi con = new Koneksi();
            con.bukaKoneksi();
            con.statement = con.dbKoneksi.createStatement();
            ResultSet rs = con.statement.executeQuery("Select namaHero, "
                    + "namaTanda, namaKelas, namaRas, namaAgama, skill, "
                    + "addHP, addMP, addPAtk, addPDef, addMAtk, addMDef, addAtkS, addSta, addStaR, addMPR, addCrit, "
                    + "a.buffHP, a.buffMP, a.buffPAtk, a.buffPDef, a.buffMAtk, a.buffMDef, a.buffAtkS, a.buffSta, a.buffStaR, a.buffMPR, a.buffCrit, "
                    + "baseStr, baseAgi, baseDex, baseCon, baseInt, baseWis, baseLuck, "
                    + "t.buffHP, t.buffMP, t.buffPAtk, t.buffPDef, t.buffMAtk, t.buffMDef, t.buffAtkS, t.buffSta, t.buffStaR, t.buffMPR, t.buffCrit "
                    + "from hero inner join tanda as t using (IDTanda) "
                    + "inner join kelas as k using (IDKelas) "
                    + "inner join ras as r using (IDRas) "
                    + "inner join agama as a using (IDAgama) "
                    + "where IDHero = '"+IDHero+"'");
            
            rs.next();
            HeroModel d = new HeroModel();
            
            d.setNamaHero(rs.getString("namaHero"));

            d.setNamaTanda(rs.getString("namaTanda"));
            d.setNamaKelas(rs.getString("namaKelas"));
            d.setNamaRas(rs.getString("namaRas"));
            d.setNamaAgama(rs.getString("namaAgama"));
            d.setSkill(rs.getString("skill"));
            
            d.setBuffHP2(rs.getInt("a.buffHP"));
            d.setBuffMP2(rs.getInt("a.buffMP"));
            d.setBuffPAtk2(rs.getInt("a.buffPAtk"));
            d.setBuffPDef2(rs.getInt("a.buffPDef"));
            d.setBuffMAtk2(rs.getInt("a.buffMAtk"));
            d.setBuffMDef2(rs.getInt("a.buffMDef"));
            d.setBuffAtkS2(rs.getInt("a.buffAtkS"));
            d.setBuffSta2(rs.getInt("a.buffSta"));
            d.setBuffStaR2(rs.getInt("a.buffStaR"));
            d.setBuffMPR2(rs.getInt("a.buffMPR"));
            d.setBuffCrit2(rs.getInt("a.buffCrit"));
            
            d.setAddHP(rs.getInt("addHP"));
            d.setAddMP(rs.getInt("addMP"));
            d.setAddPAtk(rs.getInt("addPAtk"));
            d.setAddPDef(rs.getInt("addPDef"));
            d.setAddMAtk(rs.getInt("addMAtk"));
            d.setAddMDef(rs.getInt("addMDef"));
            d.setAddAtkS(rs.getInt("addAtkS"));
            d.setAddSta(rs.getInt("addSta"));
            d.setAddStaR(rs.getInt("addStaR"));
            d.setAddMPR(rs.getInt("addMPR"));
            d.setAddCrit(rs.getInt("addCrit"));
            
            d.setBaseStr(rs.getInt("baseStr"));
            d.setBaseAgi(rs.getInt("baseAgi"));
            d.setBaseDex(rs.getInt("baseDex"));
            d.setBaseCon(rs.getInt("baseCon"));
            d.setBaseInt(rs.getInt("baseInt"));
            d.setBaseWis(rs.getInt("baseWis"));
            d.setBaseLuck(rs.getInt("baseLuck"));
            
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
            
            con.tutupKoneksi();
            return d;
        } catch (Exception e) {
            e.printStackTrace();
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
    
    public int count(){
        int jumlah = 0;
        try {
            Koneksi con = new Koneksi();
            con.bukaKoneksi();
            con.statement = con.dbKoneksi.createStatement();
            ResultSet rs = con.statement.executeQuery("select count(*) as jml from hero");
            while(rs.next()) jumlah = rs.getInt("jml");
            con.tutupKoneksi();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jumlah;
    }
    
    public boolean insert(){
        boolean berhasil = true;
        Koneksi con = new Koneksi();
        try {
            con.bukaKoneksi();
            con.preparedStatement = con.dbKoneksi.prepareStatement("insert into hero("
                    + "IDHero, namaHero, "
                    + "IDTanda, IDKelas, IDRas, creationDate, IDAgama) "
                    + "values (?,?,?,?,?,?,?)");
            
            con.preparedStatement.setString(1, getHeroModel().getIDHero());
            con.preparedStatement.setString(2, getHeroModel().getNamaHero());
            con.preparedStatement.setString(3, getHeroModel().getIDTanda());
            con.preparedStatement.setString(4, getHeroModel().getIDKelas());
            con.preparedStatement.setString(5, getHeroModel().getIDRas());
            con.preparedStatement.setDate(6, getHeroModel().getCreationDate());
            con.preparedStatement.setString(7, getHeroModel().getIDAgama());
            
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
                    + "namaHero=?, IDTanda=?, IDKelas=?, IDRas=?, IDAgama=? "
                    + "where IDHero = ?");
            
            con.preparedStatement.setString(1, getHeroModel().getNamaHero());
            
            con.preparedStatement.setString(2, getHeroModel().getIDTanda());
            con.preparedStatement.setString(3, getHeroModel().getIDKelas());
            con.preparedStatement.setString(4, getHeroModel().getIDRas());
            con.preparedStatement.setString(5, getHeroModel().getIDAgama());
            con.preparedStatement.setString(6, getHeroModel().getIDHero());
            
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
