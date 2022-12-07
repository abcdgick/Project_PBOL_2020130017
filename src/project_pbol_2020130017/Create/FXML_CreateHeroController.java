/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package project_pbol_2020130017.Create;

import java.io.File;
import java.net.URL;
import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
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
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import project_pbol_2020130017.DB.AgamaModel;
import project_pbol_2020130017.DB.DetilModel;
import project_pbol_2020130017.DB.HeroModel;
import project_pbol_2020130017.DB.KelasModel;
import project_pbol_2020130017.DB.RasModel;
import project_pbol_2020130017.DB.TandaModel;
import static project_pbol_2020130017.Main.stageMenu;
import static project_pbol_2020130017.Main.volume;
import project_pbol_2020130017.Menu.MainMenuController;
import static project_pbol_2020130017.Menu.MainMenuController.dtHero;
import static project_pbol_2020130017.Menu.MainMenuController.dtRas;
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
    @FXML
    private Button btnNextAgama;
    @FXML
    private Button btnPrevAgama;
    @FXML
    private Label txtAgama;
    @FXML
    private Label txtWhatSkill;
    @FXML
    private Label txtWhatTanda;
    @FXML
    private Label txtWhat;

    private boolean editData = false, boleh = true;
    
    private HeroModel disHero;
    
    ObservableList<KelasModel> listKelasDasar, listKelasAdv;
    HashMap<KelasModel, String> listKelasAdv2 = new HashMap<>();
    ObservableList<RasModel> listRas;
    ObservableList<TandaModel> listTanda;
    ObservableList<AgamaModel> listAgama;
    ObservableList<DetilModel> listBoleh;
    
    private int pilKelasDasar, pilRas, pilTanda, pilAgama, pilKelasAdv;
    
    private double HP, MP, PAtk, PDef, MAtk, MDef, AtkS, Sta, StaR, MPR, Crit;
    
    final String pPath = "src/project_pbol_2020130017/Assets/";
    @FXML
    private Label txtWhatKelas;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }    

    //advClass1 -> kiri
    //advClass2 -> kanan
    @FXML
    private void advClass1Klik(ActionEvent event) {
        pilKelasAdv--;
        if(pilKelasAdv < -1) pilKelasAdv = listKelasAdv.size() - 1;
        rest();
    }

    @FXML
    private void advClass2Klik(ActionEvent event) {
        pilKelasAdv++;
        if(pilKelasAdv > listKelasAdv.size() - 1) pilKelasAdv = -1;
        rest();
    }

    @FXML
    private void nextClassKlik(ActionEvent event) {
        pilKelasDasar++;
        if(pilKelasDasar > listKelasDasar.size() - 1) pilKelasDasar = 0;
        
        pilKelasAdv = -1;
        opKelas();
    }

    @FXML
    private void prevClassKlik(ActionEvent event) {
        pilKelasDasar--;
        if(pilKelasDasar < 0) pilKelasDasar = listKelasDasar.size() -1;
        pilKelasAdv = -1;
        opKelas();
    }

    @FXML
    private void createHeroKlik(ActionEvent event) {
        if(!boleh){
            Alert a = new Alert(Alert.AlertType.ERROR, "The selected race cannot be assign to this class",ButtonType.OK);
            a.showAndWait();
            return;
        }
        String nama = txtNamaHero.getText();
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Are You Sure?");
        alert.setHeaderText("The data that you selected will be recorded");
        alert.setContentText("This action will also close this window");
        alert.showAndWait();
        if(alert.getResult()==ButtonType.OK){
            disHero.setNamaHero(nama);
            MainMenuController.dtHero.setHeroModel(disHero);
            System.out.println(disHero.getCreationDate());
            if(editData){
                if(MainMenuController.dtHero.update()){
                    Alert a = new Alert(Alert.AlertType.INFORMATION, "Hero data has been updated",ButtonType.OK);
                    a.showAndWait();
                    goBack();
                } else {
                    Alert a = new Alert(Alert.AlertType.ERROR, "Hero data can't be updated",ButtonType.OK);
                    a.showAndWait();
                }
            } else if(MainMenuController.dtHero.validasi(disHero.getIDHero())<=0){
                disHero.setIDHero(disHero.getIDTanda() + disHero.getIDKelas() + disHero.getIDRas() + String.valueOf(dtHero.count()));
                if(MainMenuController.dtHero.insert()){
                    Alert a = new Alert(Alert.AlertType.INFORMATION,"Hero created!",ButtonType.OK);
                    a.showAndWait();
                    goBack();
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
            goBack();
        }
    }

    @FXML
    private void nextRaceKlik(ActionEvent event) {
        pilRas++;
        if(pilRas > listRas.size() - 1) pilRas = 0;
        ambilRas();
        ambilBoleh();
        if(pilKelasAdv != -1) ambilKelasAdv2();
        gantiImage();
        tampilRas();
    }
    
    @FXML
    private void prevRaceKlik(ActionEvent event) {
        pilRas--;
        if(pilRas < 0) pilRas = listRas.size() - 1 ;
        ambilRas();
        ambilBoleh();
        if(pilKelasAdv != -1) ambilKelasAdv2();
        gantiImage();
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

    @FXML
    private void nextAgamaKlik(ActionEvent event) {
        pilAgama++;
        if(pilAgama > listAgama.size() - 1) pilAgama = 0;
        System.out.println(pilAgama);
        ambilAgama();
        tampilAgama();
    }

    @FXML
    private void prevAgamaKlik(ActionEvent event) {
        pilAgama--;
        if(pilAgama < 0) pilAgama = listAgama.size() - 1;
        ambilAgama();
        tampilAgama();
    }
    
    @FXML
    private void disKetSkill(MouseEvent event) {
        String dis = disHero.getKetSkill();
        showInfo("Skill", dis);
    }

    @FXML
    private void disKetTanda(MouseEvent event) {
        String dis = disHero.getDetilTanda();
        showInfo("Birthsign", dis);
    }

    @FXML
    private void disKetAgama(MouseEvent event) {
        String dis = disHero.getDetilAgama();
        showInfo("Religion", dis);
    }
    
    @FXML
    private void disKetKelas(MouseEvent event) {
        String dis = disHero.getKetKelas();
        showInfo("Class", dis);
    }
    
    public void gantiImage(){
        File file;
        if(boleh){    
            file = new File(pPath+"/"+disHero.getNamaKelas()+"/"+disHero.getNamaKelas()+" "+disHero.getNamaRas()+".png");

            if(!file.exists()) {
                file = new File(pPath+"/Placeholder.jpg");
            }
        } else{
            file = new File(pPath+"/X.png");
        }
        Image image = new Image(file.toURI().toString());
        imageView.setImage(image);
    }
    
    
    public void buatBaru(String IDHero, String IDTanda, String IDKelas, String IDRas, String namaHero, Date creationDate, String IDAgama){
        disHero = new HeroModel(IDHero, IDTanda, IDKelas, IDRas, namaHero, creationDate, IDAgama);
        pilRas = 0;
        pilKelasDasar = 0;
        pilTanda = 0;
        pilAgama = 0;
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
        ObservableList<String> listIDKD = MainMenuController.dtKelas.getIDKelasDasar();
        ObservableList<String> listIDRas = MainMenuController.dtRas.getIDRas();
        ObservableList<String> listIDAgama = MainMenuController.dtAgama.getIDAgama();
        
        String dasar = MainMenuController.dtKelas.isKelasDasar(disHero.getIDKelas());
        pilTanda = (byte) listIDTanda.indexOf(disHero.getIDTanda());
        pilAgama = (byte) listIDAgama.indexOf(disHero.getIDAgama());
        pilRas = (byte) listIDRas.indexOf(disHero.getIDRas());

        if(dasar == null) {
            pilKelasDasar = (byte) listIDKD.indexOf(disHero.getIDKelas());
            pilKelasAdv = -1;
            gantiImage();
        } else {
            dtRas.getRasModel().setIDRas(disHero.getIDRas());
            listBoleh =  dtRas.LoadDetil();
            ambilKelasAdv(dasar);
            for(int i = 0; i < listKelasAdv.size(); i++){
                if(disHero.getIDKelas().equals(listKelasAdv.get(i).getIDKelas())) {
                    pilKelasAdv = (byte) (i); 
                    break;
                } 
            }
            ambilKelasAdv2();
            pilKelasDasar = (byte) listIDKD.indexOf(disHero.getBasedOf());
            gantiImage();
        }
        pilRas = (byte) listIDRas.indexOf(disHero.getIDRas());
    }
    
    public void pondasi(){
        listKelasDasar = MainMenuController.dtKelas.basedOf("is null");
        if(pilKelasAdv == -1) ambilKelasDasar();
        
        ambilBoleh();
        
        listTanda = MainMenuController.dtTanda.Load();
        ambilTanda();
        
        listAgama = MainMenuController.dtAgama.Load();
        ambilAgama();
        
        listRas = MainMenuController.dtRas.Load();
        ambilRas();
        
        tampilTanda();
        tampilRas();
        tampilKelas();
        tampilAgama();
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
            ambilKelasAdv(disHero.getIDKelas());
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
    }
    
    public void ambilKelasAdv(String id){
        listKelasAdv = MainMenuController.dtKelas.basedOf("= '" +id+"'");
        for(KelasModel dis:listKelasAdv){
            int p = -1;
            String adv = "false";
            for(int i = 0; i < listBoleh.size(); i++){
                if(listBoleh.get(i).getIDKelas().equalsIgnoreCase(dis.getIDKelas())) p = i;
                if(p>=0) adv = "true";
                listKelasAdv2.put(dis, adv);
            }
        }
    }
    
    public void ambilKelasAdv2(){
        if(!listKelasAdv.isEmpty() && !listKelasAdv2.isEmpty()){
            disHero.setIDKelas(listKelasAdv.get(pilKelasAdv).getIDKelas());
            disHero.setBasedOf(listKelasAdv.get(pilKelasAdv).getBasedOf());
            disHero.setNamaKelas(listKelasAdv.get(pilKelasAdv).getNamaKelas());
            disHero.setKetKelas(listKelasAdv.get(pilKelasAdv).getKetKelas());
            disHero.setSkill(listKelasAdv.get(pilKelasAdv).getSkill());
            disHero.setKetSkill(listKelasAdv.get(pilKelasAdv).getKetSkill());
            
            if("true".equals(listKelasAdv2.get(listKelasAdv.get(pilKelasAdv)))){
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
                
                boleh = true;
            } else{
                disHero.setAddHP(0);
                disHero.setAddMP(0);
                disHero.setAddPAtk(0);
                disHero.setAddPDef(0);
                disHero.setAddMAtk(0);
                disHero.setAddMDef(0);
                disHero.setAddAtkS(0);
                disHero.setAddSta(0);
                disHero.setAddStaR(0);
                disHero.setAddMPR(0);
                disHero.setAddCrit(0);
                boleh = false;
            }
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
    
    public void ambilAgama(){
        if(listAgama != null){
            disHero.setIDAgama(listAgama.get(pilAgama).getIDAgama());
            disHero.setNamaAgama(listAgama.get(pilAgama).getNamaAgama());
            disHero.setDetilAgama(listAgama.get(pilAgama).getDetilAgama());

            disHero.setBuffHP2(listAgama.get(pilAgama).getBuffHP());
            disHero.setBuffMP2(listAgama.get(pilAgama).getBuffMP());
            disHero.setBuffPAtk2(listAgama.get(pilAgama).getBuffPAtk());
            disHero.setBuffPDef2(listAgama.get(pilAgama).getBuffPDef());
            disHero.setBuffMAtk2(listAgama.get(pilAgama).getBuffMAtk());
            disHero.setBuffMDef2(listAgama.get(pilAgama).getBuffMDef());
            disHero.setBuffAtkS2(listAgama.get(pilAgama).getBuffAtkS());
            disHero.setBuffSta2(listAgama.get(pilAgama).getBuffSta());
            disHero.setBuffStaR2(listAgama.get(pilAgama).getBuffStaR());
            disHero.setBuffMPR2(listAgama.get(pilAgama).getBuffMPR());
            disHero.setBuffCrit2(listAgama.get(pilAgama).getBuffCrit());
        } else {
            Alert a = new Alert(Alert.AlertType.ERROR, "Data Agama Kosong", ButtonType.OK);
            a.showAndWait();
            txtNamaHero.getScene().getWindow().hide();
        }
    }
    
    private void tampilAgama(){
        txtAgama.setText(disHero.getNamaAgama());
        if(boleh) kalkulasi();
        else resetStatKiri();
    }

    private void tampilTanda(){
        txtTanda.setText(disHero.getNamaTanda());
        if(boleh) kalkulasi();
        else resetStatKiri();
    }
    
    private void tampilRas(){
        txtNamaRas.setText(disHero.getNamaRas());
        if(boleh) kalkulasi();
        else resetStatKiri();
        tampilStatKanan();
    }
    
    private void tampilKelas(){
        txtNamaKelas.setText(disHero.getNamaKelas());
        if(boleh) kalkulasi();
        else resetStatKiri();
        setSkill();
        System.out.println(boleh);
    }
    
    private void goBack(){
        stageMenu.show();
        mediaPlayer.stop();

        music = new Media(getClass().getResource("/project_pbol_2020130017/Menu/Menu.mp4").toExternalForm()); 
        mediaPlayer = new MediaPlayer(music);
        mediaPlayer.setVolume(volume * 0.8);
        mediaPlayer.play();

        Stage stage = (Stage) btnQuitHero.getScene().getWindow();
        stage.close();
    }
    
    private void setSkill(){
        if(disHero.getSkill() != null) txtSkill.setText(disHero.getSkill());
        else txtSkill.setText("NONE");
    }
    
    private void opKelas(){
        ambilKelasDasar();
        ambilKelasAdv(disHero.getIDKelas());
        gantiImage();
        tampilKelas();
    }
    
    private void rest(){
        if(pilKelasAdv == -1) {
            ambilKelasDasar();
            boleh = true;
        }
        else {
            ambilKelasAdv2();
        }
        tampilKelas();
        gantiImage();
    }
    
    private void ambilBoleh(){
        boleh = true;
        dtRas.getRasModel().setIDRas(disHero.getIDRas());
        listBoleh =  dtRas.LoadDetil();
        ambilKelasAdv(listKelasDasar.get(pilKelasDasar).getIDKelas());
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
        Crit =  0.4 * ((6 *disHero.getBaseDex() + 4 * disHero.getBaseLuck())/1.5);
        
        HP = HP + HP * (disHero.getAddHP()/100.0) + HP * (disHero.getBuffHP()/100.0) + HP * (disHero.getBuffHP2()/100.0);
        MP = MP + MP * (disHero.getAddMP()/100.0) + MP * (disHero.getBuffMP()/100.0) + MP * (disHero.getBuffMP2()/100.0);
        PAtk = PAtk + PAtk * (disHero.getAddPAtk()/100.0) + PAtk * (disHero.getBuffPAtk()/100.0) + PAtk * (disHero.getBuffPAtk2()/100.0);
        PDef = PDef + PDef * (disHero.getAddPDef()/100.0) + PDef * (disHero.getBuffPDef()/100.0) + PDef * (disHero.getBuffPDef2()/100.0);
        MAtk = MAtk + MAtk * (disHero.getAddMAtk()/100.0) + MAtk * (disHero.getBuffMAtk()/100.0) + MAtk * (disHero.getBuffMAtk2()/100.0);
        MDef = MDef + MDef * (disHero.getAddMDef()/100.0) + MDef * (disHero.getBuffMDef()/100.0) + MDef * (disHero.getBuffMDef2()/100.0);
        AtkS = AtkS + AtkS * (disHero.getAddAtkS()/100.0) + AtkS * (disHero.getBuffAtkS()/100.0) + AtkS * (disHero.getBuffAtkS2()/100.0);
        Sta = Sta + Sta * (disHero.getAddSta()/100.0) + Sta * (disHero.getBuffSta()/100.0) + Sta * (disHero.getBuffSta2()/100.0);
        StaR = StaR + StaR * (disHero.getAddStaR()/100.0) + StaR * (disHero.getBuffStaR()/100.0) + StaR * (disHero.getBuffStaR2()/100.0);
        MPR = MPR + MPR * (disHero.getAddMPR()/100.0) + MPR * (disHero.getBuffMPR()/100.0) + MPR * (disHero.getBuffMPR2()/100.0);
        Crit = Crit + Crit * (disHero.getAddCrit()/100.0) + Crit * (disHero.getBuffCrit()/100.0) + Crit * (disHero.getBuffCrit2()/100.0);
        
        tampilStatKiri();
    }
    
    private void showInfo(String type, String dis){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(type+" Info");
        if(dis == null) alert.setContentText("No Data");
        else alert.setContentText(dis);
        alert.showAndWait();
    }
    
    private void tampilStatKiri(){
        barHP.setProgress(HP/800);
        statHP.setText(String.valueOf((int)HP));
        
        barMP.setProgress(MP/800);
        statMP.setText(String.valueOf((int)MP));
        
        barPAtk.setProgress(PAtk/110.0);
        statPAtk.setText(String.valueOf((int)PAtk));
        
        barPDef.setProgress(PDef/110.0);
        statPDef.setText(String.valueOf((int)PDef));
        
        barMAtk.setProgress(MAtk/110.0);
        statMAtk.setText(String.valueOf((int)MAtk)); 

        barMDef.setProgress(MDef/110.0);
        statMDef.setText(String.valueOf((int)MDef)); 
        
        barAtkS.setProgress(AtkS/110.0);
        statAtkS.setText(String.valueOf((int)AtkS)); 

        barSta.setProgress(Sta/750);
        statSta.setText(String.valueOf((int)Sta));

        barStaR.setProgress(StaR/110.0);
        statStaR.setText(String.valueOf((int)StaR)); 

        barMPR.setProgress(MPR/110.0);
        statMPR.setText(String.valueOf((int)MPR)); 

        barCrit.setProgress(Crit/110.0);
        statCrit.setText(String.valueOf((int)Crit)); 
    }
    
    private void resetStatKiri(){
        barHP.setProgress(0);
        statHP.setText("0");
        
        barMP.setProgress(0);
        statMP.setText("0");
        
        barPAtk.setProgress(0);
        statPAtk.setText("0");
        
        barPDef.setProgress(0);
        statPDef.setText("0");
        
        barMAtk.setProgress(0);
        statMAtk.setText("0"); 

        barMDef.setProgress(0);
        statMDef.setText("0"); 
        
        barAtkS.setProgress(0);
        statAtkS.setText("0"); 

        barSta.setProgress(0);
        statSta.setText("0");

        barStaR.setProgress(0);
        statStaR.setText("0"); 

        barMPR.setProgress(0);
        statMPR.setText("0"); 

        barCrit.setProgress(0);
        statCrit.setText("0"); 
    }
    
    private void tampilStatKanan(){
        barStr.setProgress(disHero.getBaseStr()/15.0);
        statStr.setText(String.valueOf((int)disHero.getBaseStr())); 

        barAgi.setProgress(disHero.getBaseAgi()/15.0);
        statAgi.setText(String.valueOf((int)disHero.getBaseAgi()));  

        barDex.setProgress(disHero.getBaseDex()/15.0);
        statDex.setText(String.valueOf((int)disHero.getBaseDex()));  

        barCon.setProgress(disHero.getBaseCon()/15.0);
        statCon.setText(String.valueOf((int)disHero.getBaseCon()));  

        barInt.setProgress(disHero.getBaseInt()/15.0);
        statInt.setText(String.valueOf((int)disHero.getBaseInt())); 

        barWis.setProgress(disHero.getBaseWis()/15.0);
        statWis.setText(String.valueOf((int)disHero.getBaseWis())); 

        barLuck.setProgress(disHero.getBaseLuck()/15.0);
        statLuck.setText(String.valueOf((int)disHero.getBaseLuck())); 
    }
    
}
