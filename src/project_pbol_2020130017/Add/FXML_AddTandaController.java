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
import project_pbol_2020130017.DB.TandaModel;
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
public class FXML_AddTandaController implements Initializable {

    @FXML
    private AnchorPane addPane;
    @FXML
    private TextField txtBuffHP;
    @FXML
    private TextField txtBuffPAtk;
    @FXML
    private TextField txtBuffPDef;
    @FXML
    private TextField txtBuffMAtk;
    @FXML
    private TextField txtBuffAtkS;
    @FXML
    private TextField txtBuffSta;
    @FXML
    private TextField txtBuffStaR;
    @FXML
    private TextField txtBuffMPR;
    @FXML
    private TextField txtBuffCrit;
    @FXML
    private TextField txtBuffMP;
    @FXML
    private Button btnBuffBirthsign;
    @FXML
    private Button btnExit;
    @FXML
    private TextField txtBirthsignID;
    @FXML
    private TextField txtBirthsignName;
    @FXML
    private TextField txtBuffMDef;
    @FXML
    private TextArea txtBirthsignDetail;

    private boolean editData = false;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void addBirthsignKlik(ActionEvent event) {
        TandaModel n = new TandaModel();
        
        n.setIDTanda(txtBirthsignID.getText());
        n.setNamaTanda(txtBirthsignName.getText());
        n.setDetilTanda(txtBirthsignDetail.getText());
        
        n.setBuffHP(Integer.parseInt(txtBuffHP.getText()));
        n.setBuffMP(Integer.parseInt(txtBuffMP.getText()));
        n.setBuffPAtk(Integer.parseInt(txtBuffPAtk.getText()));
        n.setBuffPDef(Integer.parseInt(txtBuffPDef.getText()));
        n.setBuffMAtk(Integer.parseInt(txtBuffMAtk.getText()));
        n.setBuffMDef(Integer.parseInt(txtBuffMDef.getText()));
        n.setBuffAtkS(Integer.parseInt(txtBuffAtkS.getText()));
        n.setBuffSta(Integer.parseInt(txtBuffSta.getText()));
        n.setBuffStaR(Integer.parseInt(txtBuffStaR.getText()));
        n.setBuffMPR(Integer.parseInt(txtBuffMPR.getText()));
        n.setBuffCrit(Integer.parseInt(txtBuffCrit.getText()));
        
        MainMenuController.dtTanda.setTandaModel(n);
        if(editData){
            if(MainMenuController.dtTanda.update()){
                Alert a = new Alert(Alert.AlertType.INFORMATION, "Birthsign data has been updated",ButtonType.OK);
                a.showAndWait();
                txtBirthsignID.setEditable(true);
                keluar();
            } else {
                Alert a = new Alert(Alert.AlertType.ERROR, "Birthsign hasn't been updated",ButtonType.OK);
            }
        } else if(MainMenuController.dtTanda.validasi(n.getIDTanda())<=0){
            if(MainMenuController.dtTanda.insert()){
                Alert a = new Alert(Alert.AlertType.INFORMATION,"New birthsign has been created!",ButtonType.OK);
                a.showAndWait();
                keluar();
            } else {
                Alert a = new Alert(Alert.AlertType.ERROR,"Birthsign creation has failed",ButtonType.OK);
                a.showAndWait();
            }
        } else {
            Alert a = new Alert(Alert.AlertType.ERROR,"Birthsign already exists",ButtonType.OK);
            a.showAndWait();
            txtBirthsignID.requestFocus();
        }
    }

    @FXML
    private void exitKlik(ActionEvent event) {
        Alert a = new Alert(Alert.AlertType.CONFIRMATION,"Go back to the Main Menu? All unsaved progress will be lost", ButtonType.YES,ButtonType.NO);
        a.showAndWait();
        if(a.getResult()==ButtonType.YES){
            keluar();
        }
    }
    
    private void keluar(){
        stageMenu.show();
        mediaPlayer.stop();

        music = new Media(getClass().getResource("/project_pbol_2020130017/Menu/Menu.mp4").toExternalForm()); 
        mediaPlayer = new MediaPlayer(music);
        mediaPlayer.setVolume(volume);
        mediaPlayer.play();

        Stage stage = (Stage) btnExit.getScene().getWindow();
        stage.close();
    }
    
    public void udahAda(TandaModel d){
        if(!d.getIDTanda().isEmpty()){
            editData=true;
            
            txtBirthsignID.setText(d.getIDTanda());
            txtBirthsignName.setText(d.getNamaTanda()); 
            txtBirthsignDetail.setText(d.getDetilTanda());
            txtBuffHP.setText(String.valueOf(d.getBuffHP()));
            txtBuffMP.setText(String.valueOf(d.getBuffMP()));
            txtBuffPAtk.setText(String.valueOf(d.getBuffPAtk()));
            txtBuffPDef.setText(String.valueOf(d.getBuffPDef()));
            txtBuffMAtk.setText(String.valueOf(d.getBuffMAtk()));
            txtBuffMDef.setText(String.valueOf(d.getBuffMDef()));
            txtBuffAtkS.setText(String.valueOf(d.getBuffAtkS()));
            txtBuffSta.setText(String.valueOf(d.getBuffSta()));
            txtBuffStaR.setText(String.valueOf(d.getBuffStaR()));
            txtBuffMPR.setText(String.valueOf(d.getBuffMPR()));
            txtBuffCrit.setText(String.valueOf(d.getBuffCrit()));
            
            txtBirthsignID.setEditable(false);
        }
    }
}
