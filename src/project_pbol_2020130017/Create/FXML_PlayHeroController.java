/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package project_pbol_2020130017.Create;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import project_pbol_2020130017.DB.HeroModel;
import static project_pbol_2020130017.Main.stageMenu;
import static project_pbol_2020130017.Main.volume;
import static project_pbol_2020130017.Menu.MainMenuController.dtHero;
import static project_pbol_2020130017.Menu.MainMenuController.mediaPlayer;
import static project_pbol_2020130017.Menu.MainMenuController.music;

/**
 * FXML Controller class
 *
 * @author acer
 */
public class FXML_PlayHeroController implements Initializable {

    @FXML
    private AnchorPane playPane;
    @FXML
    private Button btnFight;
    @FXML
    private Button btnSkill;
    @FXML
    private Button btnItem;
    @FXML
    private Button btnKabur;
    @FXML
    private ProgressBar barHP;
    @FXML
    private Label textNama;
    @FXML
    private Label textMP;
    @FXML
    private ProgressBar barMP;
    @FXML
    private ProgressBar barEnemy;
    @FXML
    private Label textDialog;
    @FXML
    private Label textKet;
    @FXML
    private ImageView imgEnemy;
    
    private int dis = 0;
    private double HP, HPawal, MP, PAtk, PDef, MAtk, MDef, Atk, Def, Sta, StaR, MPR, Crit;
    private double EHP, EMP, EAtk, EDef, ECrit;
    private ArrayList<String> dialog = new ArrayList<>();
    private String name, skill, enemy;
    private final String ling1 = "The dummy stands menacingly", ling2 = "The wind is howling";
    private final String ket1 = "Press enter to continue", ket2 = "Select any option";
    private final String landmark1 = "Dummy has been defeated!\n\nYou won the battle!!";
    private final String landmark2 = "In the dungeon, you lay sight on the figure you swore to defeat";
    private final String over = "";
    private String textDmg;
    private boolean pause = false, used=false, used2=false;
    
    /**
     * Initializes the controller class.
     */
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        imgEnemy.setVisible(false);
        barEnemy.setVisible(false);
        playAudio("/project_pbol_2020130017/Create/OST1.mp4");
        btnFight.setDisable(true);
        btnSkill.setDisable(true);
        btnItem.setDisable(true);
        textKet.setText(ket1);
    }    

    @FXML
    private void fightKlik(ActionEvent event) {
        pause = false;
        freeze(ket1, true);
        textDmg = String.format("%.2f", Atk);
        dialog.add(name+" attack "+enemy+"\n\n"+enemy+" lost "+textDmg+" HP");
        nextDialog();
        serang(Atk);
        eturn(EAtk);
    }

    @FXML
    private void skillKlik(ActionEvent event) {
        if(skill.isEmpty()){
            textDialog.setText(name+" doesn't have any skill!");
        } else if(used){
            textDialog.setText(name+" had already used their skill!");
        }else{
            pause = false;
            freeze(ket1, true);
            textDmg = String.format("%.2f", Atk*3);
            dialog.add(name+" uses "+skill+"\n\n"+enemy+" lost "+textDmg+" HP");
            nextDialog();
            serang(Atk*3);
            used = true;
            eturn(EAtk);
        }
    }

    @FXML
    private void itemKlik(ActionEvent event) {
        if(barHP.getProgress() == 1){
            textDialog.setText("You're at full HP\n\nHealing item isn't used");
        } else{
            textDialog.setText(name+" used healing item!\n\n500 HP restored!");
            if(HP + 500 > HPawal){
                HP = HPawal;
                barHP.setProgress(1);
            } else{
                HP = HP + 500;
                barHP.setProgress(HP/HPawal);
            }
        }
    }

    @FXML
    private void kaburKlik(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Are You Sure?");
        alert.setHeaderText("Go back to the main menu?");
        alert.setContentText("All unsaved progress will be lost");
        alert.showAndWait();
        if(alert.getResult()==ButtonType.OK){
            gameOver();
        }
    }
    
    @FXML
    private void kyb(KeyEvent event) {
        if(event.getCode() == KeyCode.ENTER && !pause){
            nextDialog();
        }
    }
    
    private void serang(double dmg){
        double sisa = barEnemy.getProgress() - dmg/EHP;
        if(sisa < 0){
            barEnemy.setProgress(0);
            EHP = 0;
            dialog.add(enemy+" has been defeated!\n\nYou won the battle!!");
            if("Dummy".equals(enemy)) siapinText2();
            else {
                dialog.add("That's it!\n\nThank you for playing the game!");
                dialog.add("");
            }
        } else{
            barEnemy.setProgress(sisa);
            EHP -= dmg;
        }
    }
    
    private void eturn(double EAtk){
        if(EHP > 0){
            double dmg = EAtk - Def;
            if(dmg < 0) dmg = 0;
            textDmg = String.format("%.2f", dmg);
            dialog.add(enemy+" attack "+name+"\n\n"+name+" lost "+textDmg+" HP");
            double sisa = HP - dmg;
            if(sisa < 0){
                barHP.setProgress(0);
                HP = 0;
                dialog.add("You have been defeated, try again next time");
                dialog.add("");
            }else{
                barHP.setProgress(sisa/HPawal);
                HP -= dmg;
                if("Dummy".equals(enemy))dialog.add(ling1);
                else dialog.add(ling2);
            }
        }
    }

    private void nextDialog(){
        if(!pause){
            dis++;
            textDialog.setText(dialog.get(dis));
            switch (dialog.get(dis)) {
                case ling1:
                case ling2:
                    idk(ket2, true);
                    break;
                case landmark1:
                    idk(ket1, false);
                    break;
                case landmark2:
                    siapinEnemy();
                    break;
                case over:
                    gameOver();
                    break;
                default:
                    break;
            }
        }
    }
    
    
    private void idk(String text, boolean pause){
        this.pause = pause;
        imgEnemy.setVisible(pause);
        barEnemy.setVisible(pause);
        freeze(text, !pause);
    }
    
    private void freeze(String text, boolean pause){
        System.out.println("Freeze!");
        textKet.setText(text);
        btnFight.setDisable(pause);
        btnSkill.setDisable(pause);
        btnItem.setDisable(pause);
    }
    
    private void gameOver(){
        stageMenu.show();
        mediaPlayer.stop();

        music = new Media(getClass().getResource("/project_pbol_2020130017/Menu/Menu.mp4").toExternalForm()); 
        mediaPlayer = new MediaPlayer(music);
        mediaPlayer.setVolume(volume * 0.8);
        mediaPlayer.play();

        Stage stage = (Stage) btnFight.getScene().getWindow();
        stage.close();
    }

    public void transfer(HeroModel h){
        HeroModel disHero = dtHero.LoadOne(h.getIDHero());
        
        HP = 0.6 * ((8 * disHero.getBaseCon() + 2 * disHero.getBaseStr())/0.15);
        MP = 0.6 * ((8 *disHero.getBaseInt() + 2 * disHero.getBaseWis())/0.15);
        PAtk = 0.6 * (disHero.getBaseStr()/0.15);
        PDef = 0.6 * (disHero.getBaseCon()/0.15);
        MAtk = 0.6 * (disHero.getBaseInt()/0.15);
        MDef = 0.6 * (disHero.getBaseWis()/0.15);
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
        Sta = Sta + Sta * (disHero.getAddSta()/100.0) + Sta * (disHero.getBuffSta()/100.0) + Sta * (disHero.getBuffSta2()/100.0);
        StaR = StaR + StaR * (disHero.getAddStaR()/100.0) + StaR * (disHero.getBuffStaR()/100.0) + StaR * (disHero.getBuffStaR2()/100.0);
        MPR = MPR + MPR * (disHero.getAddMPR()/100.0) + MPR * (disHero.getBuffMPR()/100.0) + MPR * (disHero.getBuffMPR2()/100.0);
        Crit = Crit + Crit * (disHero.getAddCrit()/100.0) + Crit * (disHero.getBuffCrit()/100.0) + Crit * (disHero.getBuffCrit2()/100.0);
  
        Atk = PAtk + MAtk;
        Def = PDef + MDef;
        
        if(PAtk > MAtk && PDef > MDef){
            textMP.setText("Stamina");
            barMP.setStyle("-fx-accent: orange");
        }
        
        name = disHero.getNamaHero();
        skill = disHero.getSkill();
        textNama.setText(name);
        barHP.setProgress(1);
        HPawal = HP;
        barMP.setProgress(1);
        
        siapinText1();
        textDialog.setText(dialog.get(dis));
        
    }
    
    private void playAudio(String src){
        mediaPlayer.stop();
            
        music = new Media(getClass().getResource(src).toExternalForm()); 
        mediaPlayer = new MediaPlayer(music);
        mediaPlayer.setCycleCount(10);
        mediaPlayer.setVolume(volume);
        mediaPlayer.play();
    }
    
    private void siapinText1(){
        dialog.add(name+" has only one goal: to kill Undyne the Undying\n\nTo beat her, "+name+" must first prove him/herself");
        dialog.add("Prove yourself worthy!");
        enemy = "Dummy";
        EHP = 300;
        EAtk = 0;
        dialog.add(ling1);
    }
    
    private void siapinText2(){
        dialog.add("You have successfully defeated the dummy, now you march to the dungeon where she belongs");
        dialog.add("In the dungeon, you lay sight on the figure you swore to defeat");
        dialog.add("Now... fight!!!");
    }
    
    private void siapinEnemy(){
        System.out.println("Prepared");
        imgEnemy.setVisible(true);
        barEnemy.setVisible(true);
        File file = new File("src/project_pbol_2020130017/Create/Undyne3.gif");
        Image image = new Image(file.toURI().toString());
        imgEnemy.setImage(image);
        enemy = "Undyne the Undying";
        EHP = 1000;
        barHP.setProgress(1);
        barMP.setProgress(1);
        barEnemy.setProgress(1);
        used = false;
        used2 = false;
        HP = HPawal;
        EAtk = 150;
        dialog.add(ling2);
        playAudio("/project_pbol_2020130017/Create/OST3.mp4");
    }
}
