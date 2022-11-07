/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project_pbol_2020130017.DB;

import java.sql.Date;

/**
 *
 * @author acer
 */
public class HeroModel {
    private String IDHero, IDTanda, IDKelas, IDRas, IDAgama, namaHero, namaTanda, namaKelas, namaRas, namaAgama;
    private String basedOf,ketKelas, skill, ketSkill, detilTanda, detilAgama;
    private Date creationDate;
    private int baseStr, baseAgi, baseDex, baseCon, baseInt, baseWis, baseLuck;
    private int addHP, addMP, addPAtk, addPDef, addMAtk, addMDef, addAtkS, addSta, addStaR, addMPR, addCrit;
    private int buffHP, buffMP, buffPAtk, buffPDef, buffMAtk, buffMDef, buffAtkS, buffSta, buffStaR, buffMPR, buffCrit;
    private int buffHP2, buffMP2, buffPAtk2, buffPDef2, buffMAtk2, buffMDef2, buffAtkS2, buffSta2, buffStaR2, buffMPR2, buffCrit2;

    public HeroModel(){
    }
    
    public HeroModel(String IDHero, String IDTanda, String IDKelas, String IDRas, String namaHero, Date creationDate, String IDAgama) {
        this.IDHero = IDHero;
        this.IDTanda = IDTanda;
        this.IDKelas = IDKelas;
        this.IDRas = IDRas;
        this.IDAgama = IDAgama;
        this.namaHero = namaHero;
        this.creationDate = creationDate;
    }
    
    public String getIDHero() {
        return IDHero;
    }

    public void setIDHero(String IDHero) {
        this.IDHero = IDHero;
    }

    public String getIDTanda() {
        return IDTanda;
    }

    public void setIDTanda(String IDTanda) {
        this.IDTanda = IDTanda;
    }

    public String getIDKelas() {
        return IDKelas;
    }

    public void setIDKelas(String IDKelas) {
        this.IDKelas = IDKelas;
    }

    public String getIDRas() {
        return IDRas;
    }

    public void setIDRas(String IDRas) {
        this.IDRas = IDRas;
    }

    public String getNamaHero() {
        return namaHero;
    }

    public void setNamaHero(String namaHero) {
        this.namaHero = namaHero;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }
    
    public String getNamaTanda() {
        return namaTanda;
    }

    public void setNamaTanda(String namaTanda) {
        this.namaTanda = namaTanda;
    }

    public String getNamaKelas() {
        return namaKelas;
    }

    public void setNamaKelas(String namaKelas) {
        this.namaKelas = namaKelas;
    }

    public String getNamaRas() {
        return namaRas;
    }

    public void setNamaRas(String namaRas) {
        this.namaRas = namaRas;
    }
    
    public String getDetilTanda() {
        return detilTanda;
    }

    public void setDetilTanda(String detilTanda) {
        this.detilTanda = detilTanda;
    }

    public String getBasedOf() {
        return basedOf;
    }

    public void setBasedOf(String basedOf) {
        this.basedOf = basedOf;
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

    public int getBuffHP() {
        return buffHP;
    }

    public void setBuffHP(int buffHP) {
        this.buffHP = buffHP;
    }

    public int getBuffMP() {
        return buffMP;
    }

    public void setBuffMP(int buffMP) {
        this.buffMP = buffMP;
    }

    public int getBuffPAtk() {
        return buffPAtk;
    }

    public void setBuffPAtk(int buffPAtk) {
        this.buffPAtk = buffPAtk;
    }

    public int getBuffPDef() {
        return buffPDef;
    }

    public void setBuffPDef(int buffPDef) {
        this.buffPDef = buffPDef;
    }

    public int getBuffMAtk() {
        return buffMAtk;
    }

    public void setBuffMAtk(int buffMAtk) {
        this.buffMAtk = buffMAtk;
    }

    public int getBuffMDef() {
        return buffMDef;
    }

    public void setBuffMDef(int buffMDef) {
        this.buffMDef = buffMDef;
    }

    public int getBuffAtkS() {
        return buffAtkS;
    }

    public void setBuffAtkS(int buffAtkS) {
        this.buffAtkS = buffAtkS;
    }

    public int getBuffSta() {
        return buffSta;
    }

    public void setBuffSta(int buffSta) {
        this.buffSta = buffSta;
    }

    public int getBuffStaR() {
        return buffStaR;
    }

    public void setBuffStaR(int buffStaR) {
        this.buffStaR = buffStaR;
    }

    public int getBuffMPR() {
        return buffMPR;
    }

    public void setBuffMPR(int buffMPR) {
        this.buffMPR = buffMPR;
    }

    public int getBuffCrit() {
        return buffCrit;
    }

    public void setBuffCrit(int buffCrit) {
        this.buffCrit = buffCrit;
    }

    public String getIDAgama() {
        return IDAgama;
    }

    public void setIDAgama(String IDAgama) {
        this.IDAgama = IDAgama;
    }

    public String getNamaAgama() {
        return namaAgama;
    }

    public void setNamaAgama(String namaAgama) {
        this.namaAgama = namaAgama;
    }

    public String getDetilAgama() {
        return detilAgama;
    }

    public void setDetilAgama(String detilAgama) {
        this.detilAgama = detilAgama;
    }
    
    public int getBuffHP2() {
        return buffHP2;
    }

    public void setBuffHP2(int buffHP2) {
        this.buffHP2 = buffHP2;
    }

    public int getBuffMP2() {
        return buffMP2;
    }

    public void setBuffMP2(int buffMP2) {
        this.buffMP2 = buffMP2;
    }

    public int getBuffPAtk2() {
        return buffPAtk2;
    }

    public void setBuffPAtk2(int buffPAtk2) {
        this.buffPAtk2 = buffPAtk2;
    }

    public int getBuffPDef2() {
        return buffPDef2;
    }

    public void setBuffPDef2(int buffPDef2) {
        this.buffPDef2 = buffPDef2;
    }

    public int getBuffMAtk2() {
        return buffMAtk2;
    }

    public void setBuffMAtk2(int buffMAtk2) {
        this.buffMAtk2 = buffMAtk2;
    }

    public int getBuffMDef2() {
        return buffMDef2;
    }

    public void setBuffMDef2(int buffMDef2) {
        this.buffMDef2 = buffMDef2;
    }

    public int getBuffAtkS2() {
        return buffAtkS2;
    }

    public void setBuffAtkS2(int buffAtkS2) {
        this.buffAtkS2 = buffAtkS2;
    }

    public int getBuffSta2() {
        return buffSta2;
    }

    public void setBuffSta2(int buffSta2) {
        this.buffSta2 = buffSta2;
    }

    public int getBuffStaR2() {
        return buffStaR2;
    }

    public void setBuffStaR2(int buffStaR2) {
        this.buffStaR2 = buffStaR2;
    }

    public int getBuffMPR2() {
        return buffMPR2;
    }

    public void setBuffMPR2(int buffMPR2) {
        this.buffMPR2 = buffMPR2;
    }

    public int getBuffCrit2() {
        return buffCrit2;
    }

    public void setBuffCrit2(int buffCrit2) {
        this.buffCrit2 = buffCrit2;
    }

    
}
