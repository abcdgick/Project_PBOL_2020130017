/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package project_pbol_2020130017.Add;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import project_pbol_2020130017.DB.AgamaModel;
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
public class FXML_AddAgamaController implements Initializable {

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
    private Button btnAddReligion;
    @FXML
    private Button btnExit;
    @FXML
    private TextField txtReligionID;
    @FXML
    private TextField txtReligionName;
    @FXML
    private TextField txtBuffMDef;
    @FXML
    private TextArea txtReligionDetail;

    private boolean editData = false;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void addReligionKlik(ActionEvent event) {
        AgamaModel n = new AgamaModel();
        
        n.setIDAgama(txtReligionID.getText());
        n.setNamaAgama(txtReligionName.getText());
        n.setDetilAgama(txtReligionDetail.getText());
        
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
        
        MainMenuController.dtAgama.setAgamaModel(n);
        if(editData){
            if(MainMenuController.dtAgama.update()){
                Alert a = new Alert(Alert.AlertType.INFORMATION, "Religion data has been updated",ButtonType.OK);
                a.showAndWait();
                txtReligionID.setEditable(true);
                keluar();
            } else {
                Alert a = new Alert(Alert.AlertType.ERROR, "Religion hasn't been updated",ButtonType.OK);
            }
        } else if(MainMenuController.dtAgama.validasi(n.getIDAgama())<=0){
            if(MainMenuController.dtAgama.insert()){
                Alert a = new Alert(Alert.AlertType.INFORMATION,"New religion has been created!",ButtonType.OK);
                a.showAndWait();
                keluar();
                
            } else {
                Alert a = new Alert(Alert.AlertType.ERROR,"Religion creation has failed",ButtonType.OK);
                a.showAndWait();
            }
        } else {
            Alert a = new Alert(Alert.AlertType.ERROR,"Religion already exists",ButtonType.OK);
            a.showAndWait();
            txtReligionID.requestFocus();
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
    
    public void udahAda(AgamaModel d){
        if(!d.getIDAgama().isEmpty()){
            editData=true;
            
            txtReligionID.setText(d.getIDAgama());
            txtReligionName.setText(d.getNamaAgama()); 
            txtReligionDetail.setText(d.getDetilAgama());
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
            
            txtReligionID.setEditable(false);
        }
    }
    
}
