/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project_pbol_2020130017.DB;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
/**
 *
 * @author acer
 */
public class DBKelas {
    private KelasModel dt = new KelasModel();
    private HashMap<String, DetilModel> dt2 = new HashMap<>();
    
    public KelasModel getKelasModel(){
        return dt;
    }
    
    public void setKelasModel(KelasModel n){
        dt = n;
    }
    
    public HashMap<String, DetilModel> getDetilModel(){
        return dt2;
    }
    
    public void setDetilModel(DetilModel d){
        dt2.put(d.getIDRas(), d);
    }
    
    public ObservableList<KelasModel> Load(){
        try {
            ObservableList<KelasModel> tableData = FXCollections.observableArrayList();
            Koneksi con = new Koneksi();
            con.bukaKoneksi();
            con.statement = con.dbKoneksi.createStatement();
            ResultSet rs = con.statement.executeQuery("Select IDKelas, basedOf, namaKelas, ketKelas, skill, ketSkill, "
                    + "minStr, minAgi, minDex, minCon, minInt, minWis, minLuck, "
                    + "maxStr, maxAgi, maxDex, maxCon, maxInt, maxWis, maxLuck, "
                    + "addHP, addMP, addPAtk, addPDef, addMAtk, addMDef, addAtkS, addSta, addStaR, addMPR, addCrit "
                    + "from kelas");
            int i = 1;
            while(rs.next()){
                KelasModel d = new KelasModel();
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
                i++;
            }
            con.tutupKoneksi();
            return tableData;
        } catch (Exception e) {
            return null;
        }
    }
    
    public ObservableList<String> getIDKelas(){
        try {
            ObservableList<String> listID = FXCollections.observableArrayList();
            Koneksi con = new Koneksi();
            con.bukaKoneksi();
            con.statement = con.dbKoneksi.createStatement();
            ResultSet rs = con.statement.executeQuery("Select IDKelas from kelas");
            while(rs.next()){
                listID.add(rs.getString("IDKelas"));
            }
            con.tutupKoneksi();
            return listID;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }
    
    public ObservableList<String> getIDKelasDasar(){
        try {
            ObservableList<String> listID = FXCollections.observableArrayList();
            Koneksi con = new Koneksi();
            con.bukaKoneksi();
            con.statement = con.dbKoneksi.createStatement();
            ResultSet rs = con.statement.executeQuery("Select IDKelas from kelas where basedOf is null");
            while(rs.next()){
                listID.add(rs.getString("IDKelas"));
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
            ResultSet rs = con.statement.executeQuery("select count(*) as jml from kelas where IDKelas = '" +ID+ "'");
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
            con.preparedStatement = con.dbKoneksi.prepareStatement("insert into kelas("
                    + "IDKelas, basedOf, namaKelas, ketKelas, skill, ketSkill, "
                    + "minStr, minAgi, minDex, minCon, minInt, minWis, minLuck, "
                    + "maxStr, maxAgi, maxDex, maxCon, maxInt, maxWis, maxLuck, "
                    + "addHP, addMP, addPAtk, addPDef, addMAtk, addMDef, addAtkS, addSta, addStaR, addMPR, addCrit) "
                    + "values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            
            con.preparedStatement.setString(1, getKelasModel().getIDKelas());
            con.preparedStatement.setString(2, getKelasModel().getBasedOf());
            con.preparedStatement.setString(3, getKelasModel().getNamaKelas());
            con.preparedStatement.setString(4, getKelasModel().getKetKelas());
            con.preparedStatement.setString(5, getKelasModel().getSkill());
            con.preparedStatement.setString(6, getKelasModel().getKetSkill());
            
            con.preparedStatement.setInt(7, getKelasModel().getMinStr());
            con.preparedStatement.setInt(8, getKelasModel().getMinAgi());
            con.preparedStatement.setInt(9, getKelasModel().getMinDex());
            con.preparedStatement.setInt(10, getKelasModel().getMinCon());
            con.preparedStatement.setInt(11, getKelasModel().getMinInt());
            con.preparedStatement.setInt(12, getKelasModel().getMinWis());
            con.preparedStatement.setInt(13, getKelasModel().getMinLuck());
            
            con.preparedStatement.setInt(14, getKelasModel().getMaxStr());
            con.preparedStatement.setInt(15, getKelasModel().getMaxAgi());
            con.preparedStatement.setInt(16, getKelasModel().getMaxDex());
            con.preparedStatement.setInt(17, getKelasModel().getMaxCon());
            con.preparedStatement.setInt(18, getKelasModel().getMaxInt());
            con.preparedStatement.setInt(19, getKelasModel().getMaxWis());
            con.preparedStatement.setInt(20, getKelasModel().getMaxLuck());
            
            con.preparedStatement.setInt(21, getKelasModel().getAddHP());
            con.preparedStatement.setInt(22, getKelasModel().getAddMP());
            con.preparedStatement.setInt(23, getKelasModel().getAddPAtk());
            con.preparedStatement.setInt(24, getKelasModel().getAddPDef());
            con.preparedStatement.setInt(25, getKelasModel().getAddMAtk());
            con.preparedStatement.setInt(26, getKelasModel().getAddMDef());
            con.preparedStatement.setInt(27, getKelasModel().getAddAtkS());
            con.preparedStatement.setInt(28, getKelasModel().getAddSta());
            con.preparedStatement.setInt(29, getKelasModel().getAddStaR());
            con.preparedStatement.setInt(30, getKelasModel().getAddMPR());
            con.preparedStatement.setInt(31, getKelasModel().getAddCrit());
            
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
            
            con.preparedStatement = con.dbKoneksi.prepareStatement("delete from detil_ras_kelas where IDKelas = ?");
            con.preparedStatement.setString(1, ID);
            con.preparedStatement.executeUpdate();
            
            con.preparedStatement = con.dbKoneksi.prepareStatement("delete from kelas where IDKelas = ?");
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
            con.preparedStatement = con.dbKoneksi.prepareStatement("update kelas set "
                    + "basedOf=?, namaKelas=?, ketKelas=?, skill=?, ketSkill=?, "
                    + "minStr=?, minAgi=?, minDex=?, minCon=?, minInt=?, minWis=?, minLuck=?, "
                    + "maxStr=?, maxAgi=?, maxDex=?, maxCon=?, maxInt=?, maxWis=?, maxLuck=?, "
                    + "addHP=?, addMP=?, addPAtk=?, addPDef=?, addMAtk=?, addMDef=?, addAtkS=?, addSta=?, addStaR=?, addMPR=?, addCrit=? "
                    + "where IDKelas = ?");
            
            con.preparedStatement.setString(1, getKelasModel().getBasedOf());
            con.preparedStatement.setString(2, getKelasModel().getNamaKelas());
            con.preparedStatement.setString(3, getKelasModel().getKetKelas());
            con.preparedStatement.setString(4, getKelasModel().getSkill());
            con.preparedStatement.setString(5, getKelasModel().getKetSkill());
            
            con.preparedStatement.setInt(6, getKelasModel().getMinStr());
            con.preparedStatement.setInt(7, getKelasModel().getMinAgi());
            con.preparedStatement.setInt(8, getKelasModel().getMinDex());
            con.preparedStatement.setInt(9, getKelasModel().getMinCon());
            con.preparedStatement.setInt(10, getKelasModel().getMinInt());
            con.preparedStatement.setInt(11, getKelasModel().getMinWis());
            con.preparedStatement.setInt(12, getKelasModel().getMinLuck());
            
            con.preparedStatement.setInt(13, getKelasModel().getMaxStr());
            con.preparedStatement.setInt(14, getKelasModel().getMaxAgi());
            con.preparedStatement.setInt(15, getKelasModel().getMaxDex());
            con.preparedStatement.setInt(16, getKelasModel().getMaxCon());
            con.preparedStatement.setInt(17, getKelasModel().getMaxInt());
            con.preparedStatement.setInt(18, getKelasModel().getMaxWis());
            con.preparedStatement.setInt(19, getKelasModel().getMaxLuck());
            
            con.preparedStatement.setInt(20, getKelasModel().getAddHP());
            con.preparedStatement.setInt(21, getKelasModel().getAddMP());
            con.preparedStatement.setInt(22, getKelasModel().getAddPAtk());
            con.preparedStatement.setInt(23, getKelasModel().getAddPDef());
            con.preparedStatement.setInt(24, getKelasModel().getAddMAtk());
            con.preparedStatement.setInt(25, getKelasModel().getAddMDef());
            con.preparedStatement.setInt(26, getKelasModel().getAddAtkS());
            con.preparedStatement.setInt(27, getKelasModel().getAddSta());
            con.preparedStatement.setInt(28, getKelasModel().getAddStaR());
            con.preparedStatement.setInt(29, getKelasModel().getAddMPR());
            con.preparedStatement.setInt(30, getKelasModel().getAddCrit());
            
            con.preparedStatement.setString(31, getKelasModel().getIDKelas());
            
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
        String query = "Select * from ras where (baseStr between '"+getKelasModel().getMinStr()+"' and '"+getKelasModel().getMaxStr()+"') and "
                + "(baseAgi between '"+getKelasModel().getMinAgi()+"' and '"+getKelasModel().getMaxAgi()+"') and "
                + "(baseDex between '"+getKelasModel().getMinDex()+"' and '"+getKelasModel().getMaxDex()+"') and "
                + "(baseCon between '"+getKelasModel().getMinCon()+"' and '"+getKelasModel().getMaxCon()+"') and "
                + "(baseInt between '"+getKelasModel().getMinInt()+"' and '"+getKelasModel().getMaxInt()+"') and "
                + "(baseWis between '"+getKelasModel().getMinWis()+"' and '"+getKelasModel().getMaxWis()+"') and "
                + "(baseLuck between '"+getKelasModel().getMinLuck()+"' and '"+getKelasModel().getMaxLuck()+"')";
        
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
                d.setIDKelas(getKelasModel().getIDKelas());
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
    
    //nanti panggilnya, pake = contoh: "= 'dis'"
    public ObservableList<KelasModel> basedOf(String based){
        try {
            ObservableList<KelasModel> tableData = FXCollections.observableArrayList();
            Koneksi con = new Koneksi();
            con.bukaKoneksi();
            con.statement = con.dbKoneksi.createStatement();
            ResultSet rs = con.statement.executeQuery("Select IDKelas, basedOf, namaKelas, ketKelas, skill, ketSkill, "
                    + "minStr, minAgi, minDex, minCon, minInt, minWis, minLuck, "
                    + "maxStr, maxAgi, maxDex, maxCon, maxInt, maxWis, maxLuck, "
                    + "addHP, addMP, addPAtk, addPDef, addMAtk, addMDef, addAtkS, addSta, addStaR, addMPR, addCrit "
                    + "from kelas where basedOf "+based);
            int i = 1;
            while(rs.next()){
                KelasModel d = new KelasModel();
                d.setIDKelas(rs.getString("IDKelas"));
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
                
                d.setBasedOf(rs.getString("basedOf"));
                
                tableData.add(d);
                i++;
            }
            con.tutupKoneksi();
            return tableData;
        } catch (Exception e) {
            return null;
        }
    }
    
    public boolean saveAll(){
        boolean berhasil = false;
        Koneksi con = new Koneksi();
        try {
            con.bukaKoneksi();
            con.dbKoneksi.setAutoCommit(false);
            con.preparedStatement = con.dbKoneksi.prepareStatement("Delete from kelas where IDKelas = ?");
            con.preparedStatement.setString(1, getKelasModel().getIDKelas());
            con.preparedStatement.executeUpdate();

            con.preparedStatement = con.dbKoneksi.prepareStatement("insert into kelas("
                    + "IDKelas, basedOf, namaKelas, ketKelas, skill, ketSkill, "
                    + "minStr, minAgi, minDex, minCon, minInt, minWis, minLuck, "
                    + "maxStr, maxAgi, maxDex, maxCon, maxInt, maxWis, maxLuck, "
                    + "addHP, addMP, addPAtk, addPDef, addMAtk, addMDef, addAtkS, addSta, addStaR, addMPR, addCrit) "
                    + "values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");

            con.preparedStatement.setString(1, getKelasModel().getIDKelas());
            con.preparedStatement.setString(2, getKelasModel().getBasedOf());
            con.preparedStatement.setString(3, getKelasModel().getNamaKelas());
            con.preparedStatement.setString(4, getKelasModel().getKetKelas());
            con.preparedStatement.setString(5, getKelasModel().getSkill());
            con.preparedStatement.setString(6, getKelasModel().getKetSkill());

            con.preparedStatement.setInt(7, getKelasModel().getMinStr());
            con.preparedStatement.setInt(8, getKelasModel().getMinAgi());
            con.preparedStatement.setInt(9, getKelasModel().getMinDex());
            con.preparedStatement.setInt(10, getKelasModel().getMinCon());
            con.preparedStatement.setInt(11, getKelasModel().getMinInt());
            con.preparedStatement.setInt(12, getKelasModel().getMinWis());
            con.preparedStatement.setInt(13, getKelasModel().getMinLuck());

            con.preparedStatement.setInt(14, getKelasModel().getMaxStr());
            con.preparedStatement.setInt(15, getKelasModel().getMaxAgi());
            con.preparedStatement.setInt(16, getKelasModel().getMaxDex());
            con.preparedStatement.setInt(17, getKelasModel().getMaxCon());
            con.preparedStatement.setInt(18, getKelasModel().getMaxInt());
            con.preparedStatement.setInt(19, getKelasModel().getMaxWis());
            con.preparedStatement.setInt(20, getKelasModel().getMaxLuck());

            con.preparedStatement.setInt(21, getKelasModel().getAddHP());
            con.preparedStatement.setInt(22, getKelasModel().getAddMP());
            con.preparedStatement.setInt(23, getKelasModel().getAddPAtk());
            con.preparedStatement.setInt(24, getKelasModel().getAddPDef());
            con.preparedStatement.setInt(25, getKelasModel().getAddMAtk());
            con.preparedStatement.setInt(26, getKelasModel().getAddMDef());
            con.preparedStatement.setInt(27, getKelasModel().getAddAtkS());
            con.preparedStatement.setInt(28, getKelasModel().getAddSta());
            con.preparedStatement.setInt(29, getKelasModel().getAddStaR());
            con.preparedStatement.setInt(30, getKelasModel().getAddMPR());
            con.preparedStatement.setInt(31, getKelasModel().getAddCrit());


            con.preparedStatement.executeUpdate();
            
            con.preparedStatement = con.dbKoneksi.prepareStatement("Delete from detil_ras_kelas where IDKelas=?");
            con.preparedStatement.setString(1, getKelasModel().getIDKelas());
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
    
    public String isKelasDasar(String ID){
        try {
            Koneksi con = new Koneksi();
            con.bukaKoneksi();
            con.statement = con.dbKoneksi.createStatement();
            ResultSet rs = con.statement.executeQuery("select basedOf from kelas where IDKelas = '" +ID+ "'");
            while(rs.next()) {
                return rs.getString("basedOf");
            }
            con.tutupKoneksi();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }
}
