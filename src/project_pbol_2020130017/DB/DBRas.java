/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project_pbol_2020130017.DB;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author acer
 */
public class DBRas {
    private RasModel dt = new RasModel();
    private HashMap<String, DetilModel> dt2 = new HashMap<>();
    
    public RasModel getRasModel(){
        return dt;
    }
    
    public void setRasModel(RasModel n){
        dt = n;
    }
    
    public HashMap<String, DetilModel> getDetilModel(){
        return dt2;
    }
    
    public void setDetilModel(DetilModel d){
        dt2.put(d.getIDKelas(), d);
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
    
    public ObservableList<DetilModel> LoadDetil(){
        try {
            ObservableList<DetilModel> tableData = FXCollections.observableArrayList();
            Koneksi con = new Koneksi();
            con.bukaKoneksi();
            dt2.clear();
            con.statement = con.dbKoneksi.createStatement();
            ResultSet rs = con.statement.executeQuery("Select * from detil_ras_kelas join kelas using (IDKelas) where IDRas = '"+getRasModel().getIDRas()+"'");
            int i = 1;
            while(rs.next()){
                DetilModel d = new DetilModel();
                d.setIDRas(rs.getString("IDRas"));
                d.setIDKelas(rs.getString("IDKelas"));
                d.setBasedOf(rs.getString("basedOf"));
                d.setNamaKelas(rs.getString("namaKelas"));
                d.setKetKelas(rs.getString("ketKelas"));
                d.setSkill(rs.getString("skill"));
                d.setKetSkill(rs.getString("ketSkill"));
                
                d.setMinStr(rs.getInt("minStr"));
                d.setMinAgi(rs.getInt("minAgi"));
                d.setMinDex(rs.getInt("minDex"));
                d.setMinCon(rs.getInt("minCon"));
                d.setMinInt(rs.getInt("minInt"));
                d.setMinWis(rs.getInt("minWis"));
                d.setMinLuck(rs.getInt("minLuck"));
                
                d.setMaxStr(rs.getInt("maxStr"));
                d.setMaxAgi(rs.getInt("maxAgi"));
                d.setMaxDex(rs.getInt("maxDex"));
                d.setMaxCon(rs.getInt("maxCon"));
                d.setMaxInt(rs.getInt("maxInt"));
                d.setMaxWis(rs.getInt("maxWis"));
                d.setMaxLuck(rs.getInt("maxLuck"));
                
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
                
                tableData.add(d);
                setDetilModel(d);
                i++;
            }
            con.tutupKoneksi();
            return tableData;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public ObservableList<String> getIDRas(){
        try {
            ObservableList<String> listID = FXCollections.observableArrayList();
            Koneksi con = new Koneksi();
            con.bukaKoneksi();
            con.statement = con.dbKoneksi.createStatement();
            ResultSet rs = con.statement.executeQuery("Select IDRas from ras");
            while(rs.next()){
                listID.add(rs.getString("IDRas"));
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
            con.preparedStatement = con.dbKoneksi.prepareStatement("delete from detil_ras_kelas where IDRas = ?");
            con.preparedStatement.setString(1, ID);
            con.preparedStatement.executeUpdate();
            
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
    
    public ObservableList<DetilModel> CekDetil(){
        String query = "Select * from kelas where ('"+getRasModel().getBaseStr()+"' between minStr and maxStr) and "
                + "('"+getRasModel().getBaseAgi()+"' between minAgi and maxAgi) and "
                + "('"+getRasModel().getBaseDex()+"' between minDex and maxDex) and "
                + "('"+getRasModel().getBaseCon()+"' between minCon and maxCon) and "
                + "('"+getRasModel().getBaseInt()+"' between minInt and maxInt) and "
                + "('"+getRasModel().getBaseWis()+"' between minWis and maxWis) and "
                + "('"+getRasModel().getBaseLuck()+"' between minLuck and maxLuck) "
                + "and (basedOf is not null)";
        try {
            ObservableList<DetilModel> tableData = FXCollections.observableArrayList();
            Koneksi con = new Koneksi();
            con.bukaKoneksi();
            dt2.clear();
            con.statement = con.dbKoneksi.createStatement();
            ResultSet rs = con.statement.executeQuery(query);
            int i = 1;
            while(rs.next()){
                DetilModel d = new DetilModel();
                d.setIDRas(getRasModel().getIDRas());
                d.setIDKelas(rs.getString("IDKelas"));
                d.setBasedOf(rs.getString("basedOf"));
                d.setNamaKelas(rs.getString("namaKelas"));
                d.setKetKelas(rs.getString("ketKelas"));
                d.setSkill(rs.getString("skill"));
                d.setKetSkill(rs.getString("ketSkill"));
                
                d.setMinStr(rs.getInt("minStr"));
                d.setMinAgi(rs.getInt("minAgi"));
                d.setMinDex(rs.getInt("minDex"));
                d.setMinCon(rs.getInt("minCon"));
                d.setMinInt(rs.getInt("minInt"));
                d.setMinWis(rs.getInt("minWis"));
                d.setMinLuck(rs.getInt("minLuck"));
                
                d.setMaxStr(rs.getInt("maxStr"));
                d.setMaxAgi(rs.getInt("maxAgi"));
                d.setMaxDex(rs.getInt("maxDex"));
                d.setMaxCon(rs.getInt("maxCon"));
                d.setMaxInt(rs.getInt("maxInt"));
                d.setMaxWis(rs.getInt("maxWis"));
                d.setMaxLuck(rs.getInt("maxLuck"));
                
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
                
                tableData.add(d);
                setDetilModel(d);
                i++;
            }
            con.tutupKoneksi();
            return tableData;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public boolean saveAll(){
        boolean berhasil = false;
        Koneksi con = new Koneksi();
        try {
            con.bukaKoneksi();
            con.dbKoneksi.setAutoCommit(false);
            con.preparedStatement = con.dbKoneksi.prepareStatement("Delete from ras where IDRas = ?");
            con.preparedStatement.setString(1, getRasModel().getIDRas());
            con.preparedStatement.executeUpdate();
            
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
            
            con.preparedStatement = con.dbKoneksi.prepareStatement("Delete from detil_ras_kelas where IDRas=?");
            con.preparedStatement.setString(1, getRasModel().getIDRas());
            con.preparedStatement.executeUpdate();
            
            for(DetilModel sm:dt2.values()){
                con.preparedStatement = con.dbKoneksi.prepareStatement("Insert into detil_ras_kelas("
                    + "IDRas, IDKelas) values (?,?)");
                con.preparedStatement.setString(1, sm.getIDRas());
                con.preparedStatement.setString(2, sm.getIDKelas());
                
                con.preparedStatement.executeUpdate();
            }
            con.dbKoneksi.commit();
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
