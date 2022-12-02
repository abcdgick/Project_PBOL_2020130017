/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project_pbol_2020130017.DB;

/**
 *
 * @author acer
 */
public class DetilModel {
    private String IDRas, IDKelas, basedOf, namaKelas, namaRas, ketKelas, skill, ketSkill;
    private int minStr, minAgi, minDex, minCon, minInt, minWis, minLuck;
    private int maxStr, maxAgi, maxDex, maxCon, maxInt, maxWis, maxLuck;
    private int addHP, addMP, addPAtk, addPDef, addMAtk, addMDef, addAtkS, addSta, addStaR, addMPR, addCrit;
    private int baseStr, baseAgi, baseDex, baseCon, baseInt, baseWis, baseLuck;

    public DetilModel() {
    }

    public DetilModel(String IDRas, String IDKelas, String basedOf, String namaKelas, String ketKelas, String skill, String ketSkill, int minStr, int minAgi, int minDex, int minCon, int minInt, int minWis, int minLuck, int maxStr, int maxAgi, int maxDex, int maxCon, int maxInt, int maxWis, int maxLuck, int addHP, int addMP, int addPAtk, int addPDef, int addMAtk, int addMDef, int addAtkS, int addSta, int addStaR, int addMPR, int addCrit) {
        this.IDRas = IDRas;
        this.IDKelas = IDKelas;
        this.basedOf = basedOf;
        this.namaKelas = namaKelas;
        this.ketKelas = ketKelas;
        this.skill = skill;
        this.ketSkill = ketSkill;
        this.minStr = minStr;
        this.minAgi = minAgi;
        this.minDex = minDex;
        this.minCon = minCon;
        this.minInt = minInt;
        this.minWis = minWis;
        this.minLuck = minLuck;
        this.maxStr = maxStr;
        this.maxAgi = maxAgi;
        this.maxDex = maxDex;
        this.maxCon = maxCon;
        this.maxInt = maxInt;
        this.maxWis = maxWis;
        this.maxLuck = maxLuck;
        this.addHP = addHP;
        this.addMP = addMP;
        this.addPAtk = addPAtk;
        this.addPDef = addPDef;
        this.addMAtk = addMAtk;
        this.addMDef = addMDef;
        this.addAtkS = addAtkS;
        this.addSta = addSta;
        this.addStaR = addStaR;
        this.addMPR = addMPR;
        this.addCrit = addCrit;
    }

    public String getIDRas() {
        return IDRas;
    }

    public void setIDRas(String IDRas) {
        this.IDRas = IDRas;
    }

    public String getIDKelas() {
        return IDKelas;
    }

    public void setIDKelas(String IDKelas) {
        this.IDKelas = IDKelas;
    }
    
    public String getNamaRas() {
        return namaRas;
    }

    public String getBasedOf() {
        return basedOf;
    }

    public void setBasedOf(String basedOf) {
        this.basedOf = basedOf;
    }

    public String getNamaKelas() {
        return namaKelas;
    }

    public void setNamaKelas(String namaKelas) {
        this.namaKelas = namaKelas;
    }

    public String getKetKelas() {
        return ketKelas;
    }

    public void setKetKelas(String ketKelas) {
        this.ketKelas = ketKelas;
    }

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }

    public String getKetSkill() {
        return ketSkill;
    }

    public void setKetSkill(String ketSkill) {
        this.ketSkill = ketSkill;
    }

    public int getMinStr() {
        return minStr;
    }

    public void setMinStr(int minStr) {
        this.minStr = minStr;
    }

    public int getMinAgi() {
        return minAgi;
    }

    public void setMinAgi(int minAgi) {
        this.minAgi = minAgi;
    }

    public int getMinDex() {
        return minDex;
    }

    public void setMinDex(int minDex) {
        this.minDex = minDex;
    }

    public int getMinCon() {
        return minCon;
    }

    public void setMinCon(int minCon) {
        this.minCon = minCon;
    }

    public int getMinInt() {
        return minInt;
    }

    public void setMinInt(int minInt) {
        this.minInt = minInt;
    }

    public int getMinWis() {
        return minWis;
    }

    public void setMinWis(int minWis) {
        this.minWis = minWis;
    }

    public int getMinLuck() {
        return minLuck;
    }

    public void setMinLuck(int minLuck) {
        this.minLuck = minLuck;
    }

    public int getMaxStr() {
        return maxStr;
    }

    public void setMaxStr(int maxStr) {
        this.maxStr = maxStr;
    }

    public int getMaxAgi() {
        return maxAgi;
    }

    public void setMaxAgi(int maxAgi) {
        this.maxAgi = maxAgi;
    }

    public int getMaxDex() {
        return maxDex;
    }

    public void setMaxDex(int maxDex) {
        this.maxDex = maxDex;
    }

    public int getMaxCon() {
        return maxCon;
    }

    public void setMaxCon(int maxCon) {
        this.maxCon = maxCon;
    }

    public int getMaxInt() {
        return maxInt;
    }

    public void setMaxInt(int maxInt) {
        this.maxInt = maxInt;
    }

    public int getMaxWis() {
        return maxWis;
    }

    public void setMaxWis(int maxWis) {
        this.maxWis = maxWis;
    }

    public int getMaxLuck() {
        return maxLuck;
    }

    public void setMaxLuck(int maxLuck) {
        this.maxLuck = maxLuck;
    }

    public int getAddHP() {
        return addHP;
    }

    public void setAddHP(int addHP) {
        this.addHP = addHP;
    }

    public int getAddMP() {
        return addMP;
    }

    public void setAddMP(int addMP) {
        this.addMP = addMP;
    }

    public int getAddPAtk() {
        return addPAtk;
    }

    public void setAddPAtk(int addPAtk) {
        this.addPAtk = addPAtk;
    }

    public int getAddPDef() {
        return addPDef;
    }

    public void setAddPDef(int addPDef) {
        this.addPDef = addPDef;
    }

    public int getAddMAtk() {
        return addMAtk;
    }

    public void setAddMAtk(int addMAtk) {
        this.addMAtk = addMAtk;
    }

    public int getAddMDef() {
        return addMDef;
    }

    public void setAddMDef(int addMDef) {
        this.addMDef = addMDef;
    }

    public int getAddAtkS() {
        return addAtkS;
    }

    public void setAddAtkS(int addAtkS) {
        this.addAtkS = addAtkS;
    }

    public int getAddSta() {
        return addSta;
    }

    public void setAddSta(int addSta) {
        this.addSta = addSta;
    }

    public int getAddStaR() {
        return addStaR;
    }

    public void setAddStaR(int addStaR) {
        this.addStaR = addStaR;
    }

    public int getAddMPR() {
        return addMPR;
    }

    public void setAddMPR(int addMPR) {
        this.addMPR = addMPR;
    }

    public int getAddCrit() {
        return addCrit;
    }

    public void setAddCrit(int addCrit) {
        this.addCrit = addCrit;
    }

    public void setNamaRas(String namaRas) {
        this.namaRas = namaRas;
    }

    public int getBaseStr() {
        return baseStr;
    }

    public void setBaseStr(int baseStr) {
        this.baseStr = baseStr;
    }

    public int getBaseAgi() {
        return baseAgi;
    }

    public void setBaseAgi(int baseAgi) {
        this.baseAgi = baseAgi;
    }

    public int getBaseDex() {
        return baseDex;
    }

    public void setBaseDex(int baseDex) {
        this.baseDex = baseDex;
    }

    public int getBaseCon() {
        return baseCon;
    }

    public void setBaseCon(int baseCon) {
        this.baseCon = baseCon;
    }

    public int getBaseInt() {
        return baseInt;
    }

    public void setBaseInt(int baseInt) {
        this.baseInt = baseInt;
    }

    public int getBaseWis() {
        return baseWis;
    }

    public void setBaseWis(int baseWis) {
        this.baseWis = baseWis;
    }

    public int getBaseLuck() {
        return baseLuck;
    }

    public void setBaseLuck(int baseLuck) {
        this.baseLuck = baseLuck;
    }
    
    
}
