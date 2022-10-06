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
    private String IDHero, IDTanda, IDKelas, IDRas, namaHero;
    private Date creationDate;

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
}
