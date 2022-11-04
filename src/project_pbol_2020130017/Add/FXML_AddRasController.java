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
import project_pbol_2020130017.DB.RasModel;
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
public class FXML_AddRasController implements Initializable {

    @FXML
    private AnchorPane addPane;
    @FXML
    private TextField txtBaseStr;
    @FXML
    private TextField txtBaseDex;
    @FXML
    private TextField txtBaseCon;
    @FXML
    private TextField txtBaseInt;
    @FXML
    private TextField txtBaseWis;
    @FXML
    private TextField txtBaseLuck;
    @FXML
    private TextField txtBaseAgi;
    @FXML
    private Button btnAddRace;
    @FXML
    private Button btnExit;
    @FXML
    private TextField txtRaceID;
    @FXML
    private TextField txtRaceName;

    private boolean editData = false;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void addRaceKlik(ActionEvent event) {
        RasModel n = new RasModel();
        
        n.setIDRas(txtRaceID.getText());
        n.setNamaRas(txtRaceName.getText());
        
        n.setBaseStr(Integer.parseInt(txtBaseStr.getText()));
        n.setBaseAgi(Integer.parseInt(txtBaseAgi.getText()));
        n.setBaseDex(Integer.parseInt(txtBaseDex.getText()));
        n.setBaseCon(Integer.parseInt(txtBaseCon.getText()));
        n.setBaseInt(Integer.parseInt(txtBaseInt.getText()));
        n.setBaseWis(Integer.parseInt(txtBaseWis.getText()));
        n.setBaseLuck(Integer.parseInt(txtBaseLuck.getText()));
        
        MainMenuController.dtRas.setRasModel(n);
        if(editData){
            if(MainMenuController.dtRas.update()){
                Alert a = new Alert(Alert.AlertType.INFORMATION, "Race data has been updated",ButtonType.OK);
                a.showAndWait();
                txtRaceID.setEditable(true);
            } else {
                Alert a = new Alert(Alert.AlertType.ERROR, "Race hasn't been updated",ButtonType.OK);
            }
        } else if(MainMenuController.dtRas.validasi(n.getIDRas())<=0){
            if(MainMenuController.dtRas.insert()){
                Alert a = new Alert(Alert.AlertType.INFORMATION,"New race has been created!",ButtonType.OK);
                a.showAndWait();
            } else {
                Alert a = new Alert(Alert.AlertType.ERROR,"Race creation has failed",ButtonType.OK);
                a.showAndWait();
            }
        } else {
            Alert a = new Alert(Alert.AlertType.ERROR,"Race already exists",ButtonType.OK);
            a.showAndWait();
            txtRaceID.requestFocus();
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
            mediaPlayer = new MediaPlayer(music);
            mediaPlayer.setVolume(volume);
            mediaPlayer.play();
            
            Stage stage = (Stage) btnExit.getScene().getWindow();
            stage.close();
        }
    }
        
    public void udahAda(RasModel d){
            if(!d.getIDRas().isEmpty()){
                editData=true;
            
                txtRaceID.setText(d.getIDRas());
                txtRaceName.setText(d.getNamaRas()); 
                
                txtBaseStr.setText(String.valueOf(d.getBaseStr()));
                txtBaseAgi.setText(String.valueOf(d.getBaseAgi()));
                txtBaseDex.setText(String.valueOf(d.getBaseDex()));
                txtBaseCon.setText(String.valueOf(d.getBaseCon()));
                txtBaseInt.setText(String.valueOf(d.getBaseInt()));
                txtBaseWis.setText(String.valueOf(d.getBaseWis()));
                txtBaseLuck.setText(String.valueOf(d.getBaseLuck()));

            
                txtRaceID.setEditable(false);
            }
        
    }
    
}
