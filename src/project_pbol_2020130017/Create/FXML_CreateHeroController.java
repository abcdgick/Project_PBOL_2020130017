/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package project_pbol_2020130017.Create;

import java.io.File;
import java.net.URL;
import java.sql.Date;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import project_pbol_2020130017.DB.HeroModel;
import project_pbol_2020130017.DB.KelasModel;
import project_pbol_2020130017.DB.RasModel;
import project_pbol_2020130017.DB.TandaModel;
import static project_pbol_2020130017.Main.stageMenu;
import project_pbol_2020130017.Menu.MainMenuController;
import static project_pbol_2020130017.Menu.MainMenuController.dtHero;
import static project_pbol_2020130017.Menu.MainMenuController.mediaPlayer;
import static project_pbol_2020130017.Menu.MainMenuController.music;

/**
 * FXML Controller class
 *
 * @author acer
 */
public class FXML_CreateHeroController implements Initializable {

    @FXML
    private AnchorPane createPane;
    @FXML
    private ImageView imageView;
    @FXML
    private Button btnAdvClass2;
    @FXML
    private Button btnAdvClass1;
    @FXML
    private Button btnNextClass;
    @FXML
    private Button btnPrevClass;
    @FXML
    private Label txtNamaKelas;
    @FXML
    private TextField txtNamaHero;
    @FXML
    private Button btnCreateHero;
    @FXML
    private Button btnQuitHero;
    @FXML
    private Label txtNamaRas;
    @FXML
    private ProgressBar barHP;
    @FXML
    private ProgressBar barMP;
    @FXML
    private ProgressBar barPAtk;
    @FXML
    private ProgressBar barPDef;
    @FXML
    private ProgressBar barMDef;
    @FXML
    private ProgressBar barMAtk;
    @FXML
    private ProgressBar barMPR;
    @FXML
    private ProgressBar barStaR;
    @FXML
    private ProgressBar barSta;
    @FXML
    private ProgressBar barCrit;
    @FXML
    private Label statHP;
    @FXML
    private Label statMP;
    @FXML
    private Label statPAtk;
    @FXML
    private Label statPDef;
    @FXML
    private Label statMAtk;
    @FXML
    private Label statMDef;
    @FXML
    private Label statSta;
    @FXML
    private Label statStaR;
    @FXML
    private Label statMPR;
    @FXML
    private Label statCrit;
    @FXML
    private ProgressBar barAgi;
    @FXML
    private ProgressBar barStr;
    @FXML
    private Label statStr;
    @FXML
    private Label statAgi;
    @FXML
    private Label statCon;
    @FXML
    private Label statDex;
    @FXML
    private ProgressBar barDex;
    @FXML
    private ProgressBar barCon;
    @FXML
    private Label statWis;
    @FXML
    private Label statInt;
    @FXML
    private ProgressBar barInt;
    @FXML
    private ProgressBar barWis;
    @FXML
    private ProgressBar barLuck;
    @FXML
    private Label statLuck;
    @FXML
    private Button btnPrevRace;
    @FXML
    private Button btnNextRace;
    @FXML
    private ProgressBar barAtkS;
    @FXML
    private Label statAtkS;
    @FXML
    private Label txtTanda;
    @FXML
    private Button btnPrevTanda;
    @FXML
    private Button btnNextTanda;
    @FXML
    private Label txtSkill;

    private boolean editData = false;
    
    private HeroModel disHero;
    
    ObservableList<KelasModel> listKelasDasar, listKelasAdv;
    ObservableList<RasModel> listRas;
    ObservableList<TandaModel> listTanda;
    
    private int pilKelasDasar, pilRas, pilTanda, pilKelasAdv, kirikanan =0;
    
    private double HP, MP, PAtk, PDef, MAtk, MDef, AtkS, Sta, StaR, MPR, Crit;
    
    final String pPath = "src/project_pbol_2020130017/Assets/";
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }    

    //advClass1 -> kiri -> genap
    //advClass2 -> kanan -> ganjil
    @FXML
    private void advClass1Klik(ActionEvent event) {
        if(pilKelasAdv < listKelasAdv.size()){
            if(kirikanan == 0){
                pilKelasAdv = 0;
                ambilKelasAdv2();
                placeholder();
            }
            else if(kirikanan < 0) {
                pilKelasAdv += 2;
                ambilKelasAdv2();
                placeholder();
            } else {
                pilKelasAdv -= 2;
                if(pilKelasAdv == -1) {
                    ambilKelasDasar();
                    gantiImage();
                }
                else {
                    ambilKelasAdv2();
                    placeholder();
                }
            }
            kirikanan--;
            tampilKelas();
            System.out.println("Kirii");
            if(btnAdvClass2.isDisabled()) btnAdvClass2.setDisable(false);
        } else {
            btnAdvClass1.setDisable(true);
        }
    }

    @FXML
    private void advClass2Klik(ActionEvent event) {
        if(pilKelasAdv < listKelasAdv.size()-1){
            if(kirikanan == -1){
                pilKelasAdv = -1;
                ambilKelasDasar();
                gantiImage();
            }else if(kirikanan >= 0){
                pilKelasAdv += 2;
                ambilKelasAdv2();
                placeholder();
            }else{
                pilKelasAdv -= 2;
                ambilKelasAdv2();
                placeholder();
            }
            kirikanan++;
            tampilKelas();
            System.out.println("Kanann");
            if(btnAdvClass1.isDisabled()) btnAdvClass1.setDisable(false);
         } else{
            btnAdvClass2.setDisable(true);
        }
    }

    @FXML
    private void nextClassKlik(ActionEvent event) {
        pilKelasDasar++;
        if(pilKelasDasar > listKelasDasar.size() - 1) pilKelasDasar = 0;
        ambilKelasDasar();
        ambilKelasAdv(disHero.getIDKelas());
        gantiImage();
        pilKelasAdv = -1;
        kirikanan = 0;
        tampilKelas();
    }

    @FXML
    private void prevClassKlik(ActionEvent event) {
        pilKelasDasar--;
        if(pilKelasDasar < 0) pilKelasDasar = listKelasDasar.size() -1;
        ambilKelasDasar();
        ambilKelasAdv(disHero.getIDKelas());
        gantiImage();
        pilKelasAdv = -1;
        kirikanan = 0;
        tampilKelas();
    }

    @FXML
    private void createHeroKlik(ActionEvent event) {
        String nama = txtNamaHero.getText();
        System.out.print(disHero.getIDKelas());
        Alert b = new Alert(Alert.AlertType.CONFIRMATION,"Save your hero?", ButtonType.YES,ButtonType.NO);
        b.showAndWait();
        if(b.getResult()==ButtonType.YES){
            disHero.setNamaHero(nama);
            MainMenuController.dtHero.setHeroModel(disHero);
            System.out.println(disHero.getCreationDate());
            if(editData){
                if(MainMenuController.dtHero.update()){
                    Alert a = new Alert(Alert.AlertType.INFORMATION, "Hero data has been updated",ButtonType.OK);
                    a.showAndWait();
                } else {
                    Alert a = new Alert(Alert.AlertType.ERROR, "Hero data can't be updated",ButtonType.OK);
                    a.showAndWait();
                }
            } else if(MainMenuController.dtHero.validasi(disHero.getIDHero())<=0){
                disHero.setIDHero(disHero.getIDTanda() + disHero.getIDKelas() + disHero.getIDRas() + String.valueOf(dtHero.count()));
                if(MainMenuController.dtHero.insert()){
                    Alert a = new Alert(Alert.AlertType.INFORMATION,"Hero created!",ButtonType.OK);
                    a.showAndWait();
                } else {
                    Alert a = new Alert(Alert.AlertType.ERROR,"Hero creation failed",ButtonType.OK);
                    a.showAndWait();
                }
            } else {
                Alert a = new Alert(Alert.AlertType.ERROR,"Hero already exist",ButtonType.OK);
                a.showAndWait();
            }
        }
        
        
    }

    @FXML
    private void quitHeroKlik(ActionEvent event) {
        Alert a = new Alert(Alert.AlertType.CONFIRMATION,"Go back to the Main Menu? All unsaved progress will be lost", ButtonType.YES,ButtonType.NO);
        a.showAndWait();
        if(a.getResult()==ButtonType.YES){
            
            stageMenu.show();
            mediaPlayer.stop();
            
            music = new Media(getClass().getResource("/project_pbol_2020130017/Menu/Menu.mp4").toExternalForm()); 
            mediaPlayer = new MediaPlayer(music);
            mediaPlayer.play();
            
            Stage stage = (Stage) btnQuitHero.getScene().getWindow();
            stage.close();
        }
    }

    @FXML
    private void nextRaceKlik(ActionEvent event) {
        pilRas++;
        if(pilRas > listRas.size() - 1) pilRas = 0;
        ambilRas();
        if(pilKelasAdv != -1) placeholder();
        else gantiImage();
        tampilRas();
    }
    
    @FXML
    private void prevRaceKlik(ActionEvent event) {
        pilRas--;
        if(pilRas < 0) pilRas = listRas.size() - 1 ;
        ambilRas();
        if(pilKelasAdv != -1) placeholder();
        else gantiImage();
        tampilRas();
    }
    
    @FXML
    private void nextTandaKlik(ActionEvent event) {
        pilTanda++;
        if(pilTanda > listTanda.size() - 1) pilTanda = 0;
        ambilTanda();
        tampilTanda();
    }
    
    @FXML
    private void prevTandaKlik(ActionEvent event) {
        pilTanda--;
        if(pilTanda < 0) pilTanda = listTanda.size() - 1;
        ambilTanda();
        tampilTanda();
    }

    
    public void gantiImage(){
        File file = new File(pPath+"/"+disHero.getNamaKelas()+"/"+disHero.getNamaKelas()+" "+disHero.getNamaRas()+".png");
        System.out.println(file);
        Image image = new Image(file.toURI().toString());
        imageView.setImage(image);
    }
    
    //method sementara karena belum ada many-to-many
    public void placeholder(){
        File file = new File(pPath+"/Placeholder.jpg");
        Image image = new Image(file.toURI().toString());
        imageView.setImage(image);
    }
    
    public void buatBaru(String IDHero, String IDTanda, String IDKelas, String IDRas, String namaHero, Date creationDate){
        disHero = new HeroModel(IDHero, IDTanda, IDKelas, IDRas, namaHero, creationDate);
        pilRas = 0;
        pilKelasDasar = 0;
        pilTanda = 0;
        pilKelasAdv = -1;
        editData = false;
        txtNamaHero.setText(namaHero);
        
        pondasi();
        gantiImage();
    }
    
    public void udahAda(HeroModel d){
        disHero = d;
        editData = true;
        txtNamaHero.setText(d.getNamaHero());
        search();
        pondasi();
    }
    
    public void search(){
        ObservableList<String> listIDTanda = MainMenuController.dtTanda.getIDTanda();
        ObservableList<String> listIDKelas = MainMenuController.dtKelas.getIDKelas();
        ObservableList<String> listIDRas = MainMenuController.dtRas.getIDRas();
        
        String dasar = MainMenuController.dtKelas.isKelasDasar(disHero.getIDKelas());
        pilTanda = (byte) listIDTanda.indexOf(disHero.getIDTanda());
        //pilKelasDasar = (byte) listIDKelas.indexOf(disHero.getIDKelas());
        if("".equals(dasar)) {
            pilKelasDasar = (byte) listIDKelas.indexOf(disHero.getIDKelas());
            pilKelasAdv = -1;
            gantiImage();
        } else {
            ambilKelasAdv(dasar);
            for(int i = 0; i < listKelasAdv.size(); i++){
                if(disHero.getIDKelas().equals(listKelasAdv.get(i).getIDKelas())) pilKelasAdv = (byte) (i);
                placeholder();
                if(pilKelasAdv % 2 == 1)kirikanan = (pilKelasAdv + 1) / 2; 
                else kirikanan = pilKelasAdv/-2; 
            }
        }
        pilRas = (byte) listIDRas.indexOf(disHero.getIDRas());
    }
    
    public void pondasi(){
        listRas = MainMenuController.dtRas.Load();
        ambilRas();
        
        listKelasDasar = MainMenuController.dtKelas.basedOf("is null");
        ambilKelasDasar();
        
        ambilKelasAdv(disHero.getIDKelas());
        
        listTanda = MainMenuController.dtTanda.Load();
        ambilTanda();
        
        //gantiImage();
        tampilTanda();
        tampilRas();
        tampilKelas();
    }
    
    public void ambilRas(){
        if(listRas != null){
            disHero.setIDRas(listRas.get(pilRas).getIDRas());
            disHero.setNamaRas(listRas.get(pilRas).getNamaRas());
            disHero.setBaseStr(listRas.get(pilRas).getBaseStr());
            disHero.setBaseAgi(listRas.get(pilRas).getBaseAgi());
            disHero.setBaseDex(listRas.get(pilRas).getBaseDex());
            disHero.setBaseCon(listRas.get(pilRas).getBaseCon());
            disHero.setBaseInt(listRas.get(pilRas).getBaseInt());
            disHero.setBaseWis(listRas.get(pilRas).getBaseWis());
            disHero.setBaseLuck(listRas.get(pilRas).getBaseLuck());
        } else {
            Alert a = new Alert(Alert.AlertType.ERROR, "Data Ras Kosong", ButtonType.OK);
            a.showAndWait();
            txtNamaHero.getScene().getWindow().hide();
        }
    }
    
    public void ambilKelasDasar(){
        if(listKelasDasar != null){
            disHero.setIDKelas(listKelasDasar.get(pilKelasDasar).getIDKelas());
            disHero.setBasedOf(listKelasDasar.get(pilKelasDasar).getBasedOf());
            disHero.setNamaKelas(listKelasDasar.get(pilKelasDasar).getNamaKelas());
            disHero.setKetKelas(listKelasDasar.get(pilKelasDasar).getKetKelas());
            disHero.setSkill(listKelasDasar.get(pilKelasDasar).getSkill());
            disHero.setKetSkill(listKelasDasar.get(pilKelasDasar).getKetSkill());

            disHero.setAddHP(listKelasDasar.get(pilKelasDasar).getAddHP());
            disHero.setAddMP(listKelasDasar.get(pilKelasDasar).getAddMP());
            disHero.setAddPAtk(listKelasDasar.get(pilKelasDasar).getAddPAtk());
            disHero.setAddPDef(listKelasDasar.get(pilKelasDasar).getAddPDef());
            disHero.setAddMAtk(listKelasDasar.get(pilKelasDasar).getAddMAtk());
            disHero.setAddMDef(listKelasDasar.get(pilKelasDasar).getAddMDef());
            disHero.setAddAtkS(listKelasDasar.get(pilKelasDasar).getAddAtkS());
            disHero.setAddSta(listKelasDasar.get(pilKelasDasar).getAddSta());
            disHero.setAddStaR(listKelasDasar.get(pilKelasDasar).getAddStaR());
            disHero.setAddMPR(listKelasDasar.get(pilKelasDasar).getAddMPR());
            disHero.setAddCrit(listKelasDasar.get(pilKelasDasar).getAddCrit());
        } else {
            Alert a = new Alert(Alert.AlertType.ERROR, "Data Kelas Kosong", ButtonType.OK);
            a.showAndWait();
            txtNamaHero.getScene().getWindow().hide();
        }
        
        ambilKelasAdv(disHero.getIDKelas());
    }
    
    public void ambilKelasAdv(String id){
        listKelasAdv = MainMenuController.dtKelas.basedOf("= '" +id+"'");
    }
    
    public void ambilKelasAdv2(){
        if(listKelasAdv != null){
            disHero.setIDKelas(listKelasAdv.get(pilKelasAdv).getIDKelas());
            System.out.print(disHero.getIDKelas());
            disHero.setBasedOf(listKelasAdv.get(pilKelasAdv).getBasedOf());
            disHero.setNamaKelas(listKelasAdv.get(pilKelasAdv).getNamaKelas());
            disHero.setKetKelas(listKelasAdv.get(pilKelasAdv).getKetKelas());
            disHero.setSkill(listKelasAdv.get(pilKelasAdv).getSkill());
            disHero.setKetSkill(listKelasAdv.get(pilKelasAdv).getKetSkill());

            disHero.setAddHP(listKelasAdv.get(pilKelasAdv).getAddHP());
            disHero.setAddMP(listKelasAdv.get(pilKelasAdv).getAddMP());
            disHero.setAddPAtk(listKelasAdv.get(pilKelasAdv).getAddPAtk());
            disHero.setAddPDef(listKelasAdv.get(pilKelasAdv).getAddPDef());
            disHero.setAddMAtk(listKelasAdv.get(pilKelasAdv).getAddMAtk());
            disHero.setAddMDef(listKelasAdv.get(pilKelasAdv).getAddMDef());
            disHero.setAddAtkS(listKelasAdv.get(pilKelasAdv).getAddAtkS());
            disHero.setAddSta(listKelasAdv.get(pilKelasAdv).getAddSta());
            disHero.setAddStaR(listKelasAdv.get(pilKelasAdv).getAddStaR());
            disHero.setAddMPR(listKelasAdv.get(pilKelasAdv).getAddMPR());
            disHero.setAddCrit(listKelasAdv.get(pilKelasAdv).getAddCrit());
        } else {
            Alert a = new Alert(Alert.AlertType.ERROR, "Data Kelas Advance Kosong", ButtonType.OK);
            a.showAndWait();
            txtNamaHero.getScene().getWindow().hide();
        }
    }
    
    public void ambilTanda(){
        if(listTanda != null){
            disHero.setIDTanda(listTanda.get(pilTanda).getIDTanda());
            disHero.setNamaTanda(listTanda.get(pilTanda).getNamaTanda());
            disHero.setDetilTanda(listTanda.get(pilTanda).getDetilTanda());

            disHero.setBuffHP(listTanda.get(pilTanda).getBuffHP());
            disHero.setBuffMP(listTanda.get(pilTanda).getBuffMP());
            disHero.setBuffPAtk(listTanda.get(pilTanda).getBuffPAtk());
            disHero.setBuffPDef(listTanda.get(pilTanda).getBuffPDef());
            disHero.setBuffMAtk(listTanda.get(pilTanda).getBuffMAtk());
            disHero.setBuffMDef(listTanda.get(pilTanda).getBuffMDef());
            disHero.setBuffAtkS(listTanda.get(pilTanda).getBuffAtkS());
            disHero.setBuffSta(listTanda.get(pilTanda).getBuffSta());
            disHero.setBuffStaR(listTanda.get(pilTanda).getBuffStaR());
            disHero.setBuffMPR(listTanda.get(pilTanda).getBuffMPR());
            disHero.setBuffCrit(listTanda.get(pilTanda).getBuffCrit());
        } else {
            Alert a = new Alert(Alert.AlertType.ERROR, "Data Tanda Kosong", ButtonType.OK);
            a.showAndWait();
            txtNamaHero.getScene().getWindow().hide();
        }
    }
    
    private void tampilTanda(){
        txtTanda.setText(disHero.getNamaTanda());
        kalkulasi();
    }
    
    private void tampilRas(){
        txtNamaRas.setText(disHero.getNamaRas());
        kalkulasi();
    }
    
    private void tampilKelas(){
        txtNamaKelas.setText(disHero.getNamaKelas());
        kalkulasi();
    }
    
    private void kalkulasi(){
        HP = 0.6 * ((8 * disHero.getBaseCon() + 2 * disHero.getBaseStr())/0.15);
        MP = 0.6 * ((8 *disHero.getBaseInt() + 2 * disHero.getBaseWis())/0.15);
        PAtk = 0.6 * (disHero.getBaseStr()/0.15);
        PDef = 0.6 * (disHero.getBaseCon()/0.15);
        MAtk = 0.6 * (disHero.getBaseInt()/0.15);
        MDef = 0.6 * (disHero.getBaseWis()/0.15);
        AtkS = 0.6 * (disHero.getBaseAgi()/0.15);
        Sta = 0.6 * ((4 * disHero.getBaseAgi() + 4 * disHero.getBaseDex() + 2 * disHero.getBaseStr())/0.15);
        StaR = 0.6 * ((6 * disHero.getBaseAgi() + 4 * disHero.getBaseDex())/1.5);
        MPR =  0.6 * ((7 *disHero.getBaseInt() + 3 * disHero.getBaseWis())/1.5);
        Crit =  0.3 * ((6 *disHero.getBaseDex() + 4 * disHero.getBaseLuck())/1.5);
        
        HP = Math.round(HP + HP * (disHero.getAddHP()/100.0) + HP * (disHero.getBuffHP()/100.0));
        MP = Math.round(MP + MP * (disHero.getAddMP()/100.0) + MP * (disHero.getBuffMP()/100.0));
        PAtk = Math.round((PAtk + PAtk * (disHero.getAddPAtk()/100.0) + PAtk * (disHero.getBuffPAtk()/100.0))* 10)/10;
        PDef = Math.round((PDef + PDef * (disHero.getAddPDef()/100.0) + PDef * (disHero.getBuffPDef()/100.0))* 10)/10;
        MAtk = Math.round((MAtk + MAtk * (disHero.getAddMAtk()/100.0) + MAtk * (disHero.getBuffMAtk()/100.0))* 10)/10;
        MDef = Math.round((MDef + MDef * (disHero.getAddMDef()/100.0) + MDef * (disHero.getBuffMDef()/100.0))* 10)/10;
        AtkS = Math.round((AtkS + AtkS * (disHero.getAddAtkS()/100.0) + AtkS * (disHero.getBuffAtkS()/100.0))* 10)/10;
        Sta = Math.round((Sta + Sta * (disHero.getAddSta()/100.0) + Sta * (disHero.getBuffSta()/100.0))* 10)/10;
        StaR = Math.round((StaR + StaR * (disHero.getAddStaR()/100.0) + StaR * (disHero.getBuffStaR()/100.0))* 10)/10;
        MPR = Math.round((MPR + MPR * (disHero.getAddMPR()/100.0) + MPR * (disHero.getBuffMPR()/100.0))* 10)/10;
        Crit = Math.round((Crit + Crit * (disHero.getAddCrit()/100.0) + Crit * (disHero.getBuffCrit()/100.0))* 10)/10;
        
        tampilStat();
    }
    
    private void tampilStat(){
        barHP.setProgress(HP/700);
        statHP.setText(String.valueOf(HP));
        
        barMP.setProgress(MP/700);
        statMP.setText(String.valueOf(MP));
        
        barPAtk.setProgress(PAtk/100.0);
        statPAtk.setText(String.valueOf(PAtk));
        
        barPDef.setProgress(PDef/100.0);
        statPDef.setText(String.valueOf(PDef));
        
        barMAtk.setProgress(MAtk/100.0);
        statMAtk.setText(String.valueOf(MAtk)); 

        barMDef.setProgress(MDef/100.0);
        statMDef.setText(String.valueOf(MDef)); 
        
        barAtkS.setProgress(AtkS/100.0);
        statAtkS.setText(String.valueOf(AtkS)); 

        barSta.setProgress(Sta/700);
        statSta.setText(String.valueOf(Sta)); 

        barStaR.setProgress(StaR/100.0);
        statStaR.setText(String.valueOf(StaR)); 

        barMPR.setProgress(MPR/100.0);
        statMPR.setText(String.valueOf(MPR)); 

        barCrit.setProgress(Crit/100.0);
        statCrit.setText(String.valueOf(Crit)); 

        barStr.setProgress(disHero.getBaseStr()/15.0);
        statStr.setText(String.valueOf(disHero.getBaseStr())); 

        barAgi.setProgress(disHero.getBaseAgi()/15.0);
        statAgi.setText(String.valueOf(disHero.getBaseAgi()));  

        barDex.setProgress(disHero.getBaseDex()/15.0);
        statDex.setText(String.valueOf(disHero.getBaseDex()));  

        barCon.setProgress(disHero.getBaseCon()/15.0);
        statCon.setText(String.valueOf(disHero.getBaseCon()));  

        barInt.setProgress(disHero.getBaseInt()/15.0);
        statInt.setText(String.valueOf(disHero.getBaseInt()));  

        barWis.setProgress(disHero.getBaseWis()/15.0);
        statWis.setText(String.valueOf(disHero.getBaseWis()));  

        barLuck.setProgress(disHero.getBaseLuck()/15.0);
        statLuck.setText(String.valueOf(disHero.getBaseLuck()));  
    }
}
