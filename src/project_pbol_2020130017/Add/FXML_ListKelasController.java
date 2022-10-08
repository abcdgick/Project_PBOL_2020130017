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
import project_pbol_2020130017.DB.KelasModel;
import static project_pbol_2020130017.Main.stageMenu;
import static project_pbol_2020130017.Menu.MainMenuController.dtKelas;
import static project_pbol_2020130017.Menu.MainMenuController.dtRas;
import static project_pbol_2020130017.Menu.MainMenuController.mediaPlayer;
import static project_pbol_2020130017.Menu.MainMenuController.music;

/**
 * FXML Controller class
 *
 * @author acer
 */
public class FXML_ListKelasController implements Initializable {

    @FXML
    private AnchorPane addPane;
    @FXML
    private Button btnNew;
    @FXML
    private Button btnEdit;
    @FXML
    private Button btnExit;
    @FXML
    private TableView<KelasModel> listKelas;
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
            FXMLLoader loader = new FXMLLoader(getClass().getResource("FXML_AddKelas.fxml"));
            Parent root = (Parent)loader.load();
            FXML_AddKelasController isidt = (FXML_AddKelasController)loader.getController();
            Scene scene = new Scene(root);
            Stage stg = new Stage();
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
        KelasModel s = new KelasModel();
        s=listKelas.getSelectionModel().getSelectedItem();
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("FXML_AddKelas.fxml"));
            Parent root = (Parent)loader.load();
            FXML_AddKelasController isidt = (FXML_AddKelasController)loader.getController();
            isidt.udahAda(s);
            Scene scene = new Scene(root);
            Stage stg = new Stage();
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
    private void exitKlik(ActionEvent event) {
        Alert a = new Alert(Alert.AlertType.CONFIRMATION,"Go back to the Main Menu? All unsaved progress will be lost", ButtonType.YES,ButtonType.NO);
        a.showAndWait();
        if(a.getResult()==ButtonType.YES){
            
            stageMenu.show();
            mediaPlayer.stop();
            
            music = new Media(getClass().getResource("/project_pbol_2020130017/Menu/Menu.mp4").toExternalForm()); 
            mediaPlayer = new MediaPlayer(music);
            mediaPlayer.play();
            
            Stage stage = (Stage) btnExit.getScene().getWindow();
            stage.close();
        }
    }

    @FXML
    private void deleteKlik(ActionEvent event) {
        KelasModel s = listKelas.getSelectionModel().getSelectedItem();
        Alert a = new Alert(Alert.AlertType.CONFIRMATION,"Delete this class? This action is irrevesable", ButtonType.YES,ButtonType.NO);
        a.showAndWait();
        if(a.getResult()==ButtonType.YES){
            if(dtKelas.delete(s.getIDKelas())){
                Alert b = new Alert(Alert.AlertType.INFORMATION, "Class has been deleted", ButtonType.OK);
                b.showAndWait();
            } else {
                Alert b = new Alert(Alert.AlertType.ERROR, "Class deletion failed", ButtonType.OK);
                b.showAndWait();
            }
            showData();
        }
    }
    
    private void showData(){
        ObservableList<KelasModel> data = dtKelas.Load();
        if(data!=null){
            listKelas.getColumns().clear();
            listKelas.getItems().clear();
            System.out.println("Jalan");
            TableColumn col = new TableColumn("Class ID");
            col.setCellValueFactory(new PropertyValueFactory<KelasModel, String>("IDKelas"));
            listKelas.getColumns().addAll(col);
            col = new TableColumn("Based Of");
            col.setCellValueFactory(new PropertyValueFactory<KelasModel, String>("basedOf"));
            listKelas.getColumns().addAll(col);
            col = new TableColumn("Class Name");
            col.setCellValueFactory(new PropertyValueFactory<KelasModel, String>("namaKelas"));
            listKelas.getColumns().addAll(col);
            col = new TableColumn("Class Detail");
            col.setCellValueFactory(new PropertyValueFactory<KelasModel, String>("ketKelas"));
            listKelas.getColumns().addAll(col);
            
            col = new TableColumn("Min Str");
            col.setCellValueFactory(new PropertyValueFactory<KelasModel, Integer>("minStr"));
            listKelas.getColumns().addAll(col);
            col = new TableColumn("Min Agi");
            col.setCellValueFactory(new PropertyValueFactory<KelasModel, Integer>("minAgi"));
            listKelas.getColumns().addAll(col);
            col = new TableColumn("Min Dex");
            col.setCellValueFactory(new PropertyValueFactory<KelasModel, Integer>("minDex"));
            listKelas.getColumns().addAll(col);
            col = new TableColumn("Min Con");
            col.setCellValueFactory(new PropertyValueFactory<KelasModel, Integer>("minCon"));
            listKelas.getColumns().addAll(col);
            col = new TableColumn("Min Int");
            col.setCellValueFactory(new PropertyValueFactory<KelasModel, Integer>("minInt"));
            listKelas.getColumns().addAll(col);
            col = new TableColumn("Min Wis");
            col.setCellValueFactory(new PropertyValueFactory<KelasModel, Integer>("minWis"));
            listKelas.getColumns().addAll(col);
            col = new TableColumn("Min Luck");
            col.setCellValueFactory(new PropertyValueFactory<KelasModel, Integer>("minLuck"));
            listKelas.getColumns().addAll(col);
            
            col = new TableColumn("Max Str");
            col.setCellValueFactory(new PropertyValueFactory<KelasModel, Integer>("maxStr"));
            listKelas.getColumns().addAll(col);
            col = new TableColumn("Max Agi");
            col.setCellValueFactory(new PropertyValueFactory<KelasModel, Integer>("maxAgi"));
            listKelas.getColumns().addAll(col);
            col = new TableColumn("Max Dex");
            col.setCellValueFactory(new PropertyValueFactory<KelasModel, Integer>("maxDex"));
            listKelas.getColumns().addAll(col);
            col = new TableColumn("Max Con");
            col.setCellValueFactory(new PropertyValueFactory<KelasModel, Integer>("maxCon"));
            listKelas.getColumns().addAll(col);
            col = new TableColumn("Max Int");
            col.setCellValueFactory(new PropertyValueFactory<KelasModel, Integer>("maxInt"));
            listKelas.getColumns().addAll(col);
            col = new TableColumn("Max Wis");
            col.setCellValueFactory(new PropertyValueFactory<KelasModel, Integer>("maxWis"));
            listKelas.getColumns().addAll(col);
            col = new TableColumn("Max Luck");
            col.setCellValueFactory(new PropertyValueFactory<KelasModel, Integer>("maxLuck"));
            listKelas.getColumns().addAll(col);
            
            col = new TableColumn("HP Add");
            col.setCellValueFactory(new PropertyValueFactory<KelasModel, Integer>("addHP"));
            listKelas.getColumns().addAll(col);
            col = new TableColumn("MP Add");
            col.setCellValueFactory(new PropertyValueFactory<KelasModel, Integer>("addMP"));
            listKelas.getColumns().addAll(col);
            col = new TableColumn("Physical Attack Add");
            col.setCellValueFactory(new PropertyValueFactory<KelasModel, Integer>("addPAtk"));
            listKelas.getColumns().addAll(col);
            col = new TableColumn("Physical Defence Add");
            col.setCellValueFactory(new PropertyValueFactory<KelasModel, Integer>("addPDef"));
            listKelas.getColumns().addAll(col);
            col = new TableColumn("Magical Attack Add");
            col.setCellValueFactory(new PropertyValueFactory<KelasModel, Integer>("addMAtk"));
            listKelas.getColumns().addAll(col);
            col = new TableColumn("Magical Defence Add");
            col.setCellValueFactory(new PropertyValueFactory<KelasModel, Integer>("addMDef"));
            listKelas.getColumns().addAll(col);
            col = new TableColumn("Attack Speed Add");
            col.setCellValueFactory(new PropertyValueFactory<KelasModel, Integer>("addAtkS"));
            listKelas.getColumns().addAll(col);
            col = new TableColumn("Stamina Add");
            col.setCellValueFactory(new PropertyValueFactory<KelasModel, Integer>("addSta"));
            listKelas.getColumns().addAll(col);
            col = new TableColumn("Stamina Regen Add");
            col.setCellValueFactory(new PropertyValueFactory<KelasModel, Integer>("addStaR"));
            listKelas.getColumns().addAll(col);
            col = new TableColumn("MP Regen Add");
            col.setCellValueFactory(new PropertyValueFactory<KelasModel, Integer>("addMPR"));
            listKelas.getColumns().addAll(col);
            col = new TableColumn("Critical Chance Add");
            col.setCellValueFactory(new PropertyValueFactory<KelasModel, Integer>("addCrit"));
            listKelas.getColumns().addAll(col);
            
            listKelas.setItems(data);

        } else {
            Alert a = new Alert(Alert.AlertType.ERROR, "There's No Class Yet", ButtonType.OK);
            a.showAndWait();
            //listKelas.getScene().getWindow().hide();
        }
    }
        
    private void playAudio(){
        music = new Media(getClass().getResource("Add.mp4").toExternalForm()); 
        mediaPlayer = new MediaPlayer(music);
        mediaPlayer.play();
    }
}
