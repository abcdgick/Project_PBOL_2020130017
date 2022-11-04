/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package project_pbol_2020130017.Add;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Modality;
import javafx.stage.Stage;
import project_pbol_2020130017.DB.AgamaModel;
import static project_pbol_2020130017.Main.stageMenu;
import static project_pbol_2020130017.Main.volume;
import static project_pbol_2020130017.Menu.MainMenuController.dtAgama;
import static project_pbol_2020130017.Menu.MainMenuController.mediaPlayer;
import static project_pbol_2020130017.Menu.MainMenuController.music;

/**
 * FXML Controller class
 *
 * @author acer
 */
public class FXML_ListAgamaController implements Initializable {

    @FXML
    private AnchorPane addPane;
    @FXML
    private Button btnNew;
    @FXML
    private Button btnEdit;
    @FXML
    private Button btnExit;
    @FXML
    private TableView<AgamaModel> listAgama;
    @FXML
    private Button btnDelete;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        playAudio();
        showData();
    }    

    @FXML
    private void newKlik(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("FXML_AddAgama.fxml"));
            Parent root = (Parent)loader.load();
            FXML_AddAgamaController isidt = (FXML_AddAgamaController)loader.getController();
            Scene scene = new Scene(root);
            Stage stg = new Stage();
            
            String css = this.getClass().getResource("Style3.css").toExternalForm();
            scene.getStylesheets().add(css);
            
            stg.initModality(Modality.APPLICATION_MODAL);
            stg.setResizable(false);
            stg.setIconified(false);
            stg.setScene(scene);
            stg.show();
            Stage stage = (Stage) btnExit.getScene().getWindow();
            stage.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        showData();
    }

    @FXML
    private void editKlik(ActionEvent event) {
        try {
            AgamaModel s =listAgama.getSelectionModel().getSelectedItem();
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("FXML_AddAgama.fxml"));
                Parent root = (Parent)loader.load();
                FXML_AddAgamaController isidt = (FXML_AddAgamaController)loader.getController();
                isidt.udahAda(s);
                Scene scene = new Scene(root);
                Stage stg = new Stage();
                
                String css = this.getClass().getResource("Style3.css").toExternalForm();
                scene.getStylesheets().add(css);
                
                stg.initModality(Modality.APPLICATION_MODAL);
                stg.setResizable(false);
                stg.setIconified(false);
                stg.setScene(scene);
                stg.show();
                Stage stage = (Stage) btnExit.getScene().getWindow();
                stage.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        showData();
        } catch (Exception e) {
            Alert a = new Alert(Alert.AlertType.ERROR,"You haven't select a religion to edit", ButtonType.OK);
            a.showAndWait();
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

    @FXML
    private void deleteKlik(ActionEvent event) {
        try {
            AgamaModel s = listAgama.getSelectionModel().getSelectedItem();
            Alert a = new Alert(Alert.AlertType.CONFIRMATION,"Delete this religion? This action is irrevesable", ButtonType.YES,ButtonType.NO);
            a.showAndWait();
            if(a.getResult()==ButtonType.YES){
                if(dtAgama.delete(s.getIDAgama())){
                    Alert b = new Alert(Alert.AlertType.INFORMATION, "Religion has been deleted", ButtonType.OK);
                    b.showAndWait();
                } else {
                    Alert b = new Alert(Alert.AlertType.ERROR, "Religion deletion failed", ButtonType.OK);
                    b.showAndWait();
                }
                showData();
            }
        } catch (Exception e) {
            Alert a = new Alert(Alert.AlertType.ERROR,"You haven't select a religion to delete", ButtonType.OK);
            a.showAndWait();
        }
    }
    
    private void showData(){
        ObservableList<AgamaModel> data = dtAgama.Load();
        if(data!=null){
            listAgama.getColumns().clear();
            listAgama.getItems().clear();
            System.out.println("Jalan");
            TableColumn col = new TableColumn("Religion ID");
            col.setCellValueFactory(new PropertyValueFactory<AgamaModel, String>("IDAgama"));
            listAgama.getColumns().addAll(col);
            col = new TableColumn("Religion Name");
            col.setCellValueFactory(new PropertyValueFactory<AgamaModel, String>("namaAgama"));
            listAgama.getColumns().addAll(col);
            col = new TableColumn("Religion Detail");
            col.setCellValueFactory(new PropertyValueFactory<AgamaModel, String>("detilAgama"));
            listAgama.getColumns().addAll(col);
            col = new TableColumn("HP Buff");
            col.setCellValueFactory(new PropertyValueFactory<AgamaModel, Integer>("buffHP"));
            listAgama.getColumns().addAll(col);
            col = new TableColumn("MP Buff");
            col.setCellValueFactory(new PropertyValueFactory<AgamaModel, Integer>("buffMP"));
            listAgama.getColumns().addAll(col);
            col = new TableColumn("Physical Attack Buff");
            col.setCellValueFactory(new PropertyValueFactory<AgamaModel, Integer>("buffPAtk"));
            listAgama.getColumns().addAll(col);
            col = new TableColumn("Physical Defence Buff");
            col.setCellValueFactory(new PropertyValueFactory<AgamaModel, Integer>("buffPDef"));
            listAgama.getColumns().addAll(col);
            col = new TableColumn("Magical Attack Buff");
            col.setCellValueFactory(new PropertyValueFactory<AgamaModel, Integer>("buffMAtk"));
            listAgama.getColumns().addAll(col);
            col = new TableColumn("Magical Defence Buff");
            col.setCellValueFactory(new PropertyValueFactory<AgamaModel, Integer>("buffMDef"));
            listAgama.getColumns().addAll(col);
            col = new TableColumn("Attack Speed Buff");
            col.setCellValueFactory(new PropertyValueFactory<AgamaModel, Integer>("buffAtkS"));
            listAgama.getColumns().addAll(col);
            col = new TableColumn("Stamina Buff");
            col.setCellValueFactory(new PropertyValueFactory<AgamaModel, Integer>("buffSta"));
            listAgama.getColumns().addAll(col);
            col = new TableColumn("Stamina Regen Buff");
            col.setCellValueFactory(new PropertyValueFactory<AgamaModel, Integer>("buffStaR"));
            listAgama.getColumns().addAll(col);
            col = new TableColumn("MP Regen Buff");
            col.setCellValueFactory(new PropertyValueFactory<AgamaModel, Integer>("buffMPR"));
            listAgama.getColumns().addAll(col);
            col = new TableColumn("Critical Chance Buff");
            col.setCellValueFactory(new PropertyValueFactory<AgamaModel, Integer>("buffCrit"));
            listAgama.getColumns().addAll(col);
            
            listAgama.setItems(data);

        } else {
            Alert a = new Alert(Alert.AlertType.ERROR, "There's No Religion Yet", ButtonType.OK);
            a.showAndWait();
            //listAgama.getScene().getWindow().hide();
        }
    }
    
    private void playAudio(){
        music = new Media(getClass().getResource("Add.mp4").toExternalForm()); 
        mediaPlayer = new MediaPlayer(music);
        mediaPlayer.setVolume(volume);
        mediaPlayer.play();
    }
}
