/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package project_pbol_2020130017.Add;

import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Modality;
import javafx.stage.Stage;
import project_pbol_2020130017.DB.KelasModel;
import static project_pbol_2020130017.Main.stageMenu;
import static project_pbol_2020130017.Main.volume;
import project_pbol_2020130017.Menu.MainMenuController;
import static project_pbol_2020130017.Menu.MainMenuController.mediaPlayer;
import static project_pbol_2020130017.Menu.MainMenuController.music;


/**
 * FXML Controller class
 *
 * @author acer
 */
public class FXML_AddKelasController implements Initializable {

    @FXML
    private AnchorPane addPane;
    @FXML
    private TextField txtAddHP;
    @FXML
    private TextField txtAddPAtk;
    @FXML
    private TextField txtAddPDef;
    @FXML
    private TextField txtAddMAtk;
    @FXML
    private TextField txtAddAtkS;
    @FXML
    private TextField txtAddSta;
    @FXML
    private TextField txtAddStaR;
    @FXML
    private TextField txtAddMPR;
    @FXML
    private TextField txtAddCrit;
    @FXML
    private TextField txtAddMP;
    @FXML
    private TextField txtMinAgi;
    @FXML
    private TextField txtMinLuck;
    @FXML
    private TextField txtMinWis;
    @FXML
    private TextField txtMinInt;
    @FXML
    private TextField txtMinCon;
    @FXML
    private TextField txtMinDex;
    @FXML
    private TextField txtMinStr;
    @FXML
    private TextField txtMaxStr;
    @FXML
    private TextField txtMaxDex;
    @FXML
    private TextField txtMaxCon;
    @FXML
    private TextField txtMaxInt;
    @FXML
    private TextField txtMaxWis;
    @FXML
    private TextField txtMaxLuck;
    @FXML
    private TextField txtMaxAgi;
    @FXML
    private Button btnAddClass;
    @FXML
    private Button btnExit;
    @FXML
    private TextField txtClassID;
    @FXML
    private TextField txtClassName;
    @FXML
    private TextField txtAddMDef;
    @FXML
    private TextArea txtClassDetail;
    @FXML
    private TextArea txtSkillDetail;
    @FXML
    private TextField txtSkill;
        
    private boolean editData = false;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void addClassKlik(ActionEvent event) {
        KelasModel n = new KelasModel();
        
        n.setIDKelas(txtClassID.getText());
        n.setNamaKelas(txtClassName.getText());
        n.setKetKelas(txtClassDetail.getText());
        n.setSkill(txtSkill.getText());
        n.setKetSkill(txtSkillDetail.getText());

        n.setMinStr(Integer.parseInt(txtMinStr.getText()));
        n.setMinAgi(Integer.parseInt(txtMinAgi.getText()));
        n.setMinDex(Integer.parseInt(txtMinDex.getText()));
        n.setMinCon(Integer.parseInt(txtMinCon.getText()));
        n.setMinInt(Integer.parseInt(txtMinInt.getText()));
        n.setMinWis(Integer.parseInt(txtMinWis.getText()));
        n.setMinLuck(Integer.parseInt(txtMinLuck.getText()));

        n.setMaxStr(Integer.parseInt(txtMaxStr.getText()));
        n.setMaxAgi(Integer.parseInt(txtMaxAgi.getText()));
        n.setMaxDex(Integer.parseInt(txtMaxDex.getText()));
        n.setMaxCon(Integer.parseInt(txtMaxCon.getText()));
        n.setMaxInt(Integer.parseInt(txtMaxInt.getText()));
        n.setMaxWis(Integer.parseInt(txtMaxWis.getText()));
        n.setMaxLuck(Integer.parseInt(txtMaxLuck.getText()));

        n.setAddHP(Integer.parseInt(txtAddHP.getText()));
        n.setAddMP(Integer.parseInt(txtAddMP.getText()));
        n.setAddPAtk(Integer.parseInt(txtAddPAtk.getText()));
        n.setAddPDef(Integer.parseInt(txtAddPDef.getText()));
        n.setAddMAtk(Integer.parseInt(txtAddMAtk.getText()));
        n.setAddMDef(Integer.parseInt(txtAddMDef.getText()));
        n.setAddAtkS(Integer.parseInt(txtAddAtkS.getText()));
        n.setAddSta(Integer.parseInt(txtAddSta.getText()));
        n.setAddStaR(Integer.parseInt(txtAddStaR.getText()));
        n.setAddMPR(Integer.parseInt(txtAddMPR.getText()));
        n.setAddCrit(Integer.parseInt(txtAddCrit.getText()));
                
        
        MainMenuController.dtKelas.setKelasModel(n);
        if(editData){
            if(MainMenuController.dtKelas.update()){
                Alert a = new Alert(Alert.AlertType.INFORMATION, "Class data has been updated",ButtonType.OK);
                a.showAndWait();
                txtClassID.setEditable(true);
            } else {
                Alert a = new Alert(Alert.AlertType.ERROR, "Class hasn't been updated",ButtonType.OK);
            }
        } else if(MainMenuController.dtKelas.validasi(n.getIDKelas())<=0){
            if(MainMenuController.dtKelas.insert()){
                Alert a = new Alert(Alert.AlertType.INFORMATION,"New class has been created!",ButtonType.OK);
                a.showAndWait();
            } else {
                Alert a = new Alert(Alert.AlertType.ERROR,"Class creation has failed",ButtonType.OK);
                a.showAndWait();
            }
        } else {
            Alert a = new Alert(Alert.AlertType.ERROR,"Class already exists",ButtonType.OK);
            a.showAndWait();
            txtClassID.requestFocus();
        }
    }

    @FXML
    private void exitKlik(ActionEvent event) {
        Alert a = new Alert(Alert.AlertType.CONFIRMATION,"Go back to the Main Menu? All unsaved progress will be lost", ButtonType.YES,ButtonType.NO);
        a.showAndWait();
        if(a.getResult()==ButtonType.YES){
            
            stageMenu.show();
            mediaPlayer.stop();
            
            music = new Media(getClass().getResource("/project_pbol_2020130017/Menu/Menu.mp4").toExternalForm()); 
            mediaPlayer.setVolume(volume);
            mediaPlayer = new MediaPlayer(music);
            mediaPlayer.setVolume(volume);
            mediaPlayer.play();
            
            Stage stage = (Stage) btnExit.getScene().getWindow();
            stage.close();
        }
    }
    
    public void udahAda(KelasModel d){
        if(!d.getIDKelas().isEmpty()){
            editData=true;
            
            txtClassID.setText(d.getIDKelas());
            txtClassName.setText(d.getNamaKelas()); 
            txtClassDetail.setText(d.getKetKelas());
            txtAddHP.setText(String.valueOf(d.getAddHP()));
            txtAddMP.setText(String.valueOf(d.getAddMP()));
            txtAddPAtk.setText(String.valueOf(d.getAddPAtk()));
            txtAddPDef.setText(String.valueOf(d.getAddPDef()));
            txtAddMAtk.setText(String.valueOf(d.getAddMAtk()));
            txtAddMDef.setText(String.valueOf(d.getAddMDef()));
            txtAddAtkS.setText(String.valueOf(d.getAddAtkS()));
            txtAddSta.setText(String.valueOf(d.getAddSta()));
            txtAddStaR.setText(String.valueOf(d.getAddStaR()));
            txtAddMPR.setText(String.valueOf(d.getAddMPR()));
            txtAddCrit.setText(String.valueOf(d.getAddCrit()));

            txtMinStr.setText(String.valueOf(d.getMinStr()));
            txtMinAgi.setText(String.valueOf(d.getMinAgi()));
            txtMinDex.setText(String.valueOf(d.getMinDex()));
            txtMinCon.setText(String.valueOf(d.getMinCon()));
            txtMinInt.setText(String.valueOf(d.getMinInt()));
            txtMinWis.setText(String.valueOf(d.getMinWis()));
            txtMinLuck.setText(String.valueOf(d.getMinLuck()));


            txtMaxStr.setText(String.valueOf(d.getMaxStr()));
            txtMaxAgi.setText(String.valueOf(d.getMaxAgi()));
            txtMaxDex.setText(String.valueOf(d.getMaxDex()));
            txtMaxCon.setText(String.valueOf(d.getMaxCon()));
            txtMaxInt.setText(String.valueOf(d.getMaxInt()));
            txtMaxWis.setText(String.valueOf(d.getMaxWis()));
            txtMaxLuck.setText(String.valueOf(d.getMaxLuck()));

            txtSkill.setText(String.valueOf(d.getSkill()));
            txtSkillDetail.setText(String.valueOf(d.getKetSkill()));
            
            
            txtClassID.setEditable(false);
        }
    }
}
