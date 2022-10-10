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
import project_pbol_2020130017.DB.RasModel;
import static project_pbol_2020130017.Main.stageMenu;
import static project_pbol_2020130017.Menu.MainMenuController.dtRas;
import static project_pbol_2020130017.Menu.MainMenuController.mediaPlayer;
import static project_pbol_2020130017.Menu.MainMenuController.music;

/**
 * FXML Controller class
 *
 * @author acer
 */
public class FXML_ListRasController implements Initializable {

    @FXML
    private AnchorPane addPane;
    @FXML
    private Button btnNew;
    @FXML
    private Button btnEdit;
    @FXML
    private Button btnExit;
    @FXML
    private TableView<RasModel> listRas;
    @FXML
    private Button btnDelete;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       showData();
       playAudio();
    }    

    @FXML
    private void newKlik(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("FXML_AddRas.fxml"));
            Parent root = (Parent)loader.load();
            FXML_AddRasController isidt = (FXML_AddRasController)loader.getController();
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
            RasModel s = new RasModel();
            s=listRas.getSelectionModel().getSelectedItem();
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("FXML_AddRas.fxml"));
                Parent root = (Parent)loader.load();
                FXML_AddRasController isidt = (FXML_AddRasController)loader.getController();
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
            Alert a = new Alert(Alert.AlertType.ERROR,"You haven't select a race to edit", ButtonType.OK);
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
            mediaPlayer.play();
            
            Stage stage = (Stage) btnExit.getScene().getWindow();
            stage.close();
        }
    }

    @FXML
    private void deleteKlik(ActionEvent event) {
        try {
            RasModel s = listRas.getSelectionModel().getSelectedItem();
            Alert a = new Alert(Alert.AlertType.CONFIRMATION,"Delete this race? This action is irrevesable", ButtonType.YES,ButtonType.NO);
            a.showAndWait();
            if(a.getResult()==ButtonType.YES){
                if(dtRas.delete(s.getIDRas())){
                    Alert b = new Alert(Alert.AlertType.INFORMATION, "Race has been deleted", ButtonType.OK);
                    b.showAndWait();
                } else {
                    Alert b = new Alert(Alert.AlertType.ERROR, "Race deletion failed", ButtonType.OK);
                    b.showAndWait();
                }
                showData();
            }
        } catch (Exception e) {
            Alert a = new Alert(Alert.AlertType.ERROR,"You haven't select a race to delete", ButtonType.OK);
            a.showAndWait();
        }
    }
    
    
    
    private void showData(){
        ObservableList<RasModel> data = dtRas.Load();
        if(data!=null){
            listRas.getColumns().clear();
            listRas.getItems().clear();
            System.out.println("Jalan");
            TableColumn col = new TableColumn("Race ID");
            col.setCellValueFactory(new PropertyValueFactory<RasModel, String>("IDRas"));
            listRas.getColumns().addAll(col);
            col = new TableColumn("Race Name");
            col.setCellValueFactory(new PropertyValueFactory<RasModel, String>("namaRas"));
            listRas.getColumns().addAll(col);
            col = new TableColumn("Base Strength");
            col.setCellValueFactory(new PropertyValueFactory<RasModel, Integer>("baseStr"));
            listRas.getColumns().addAll(col);
            col = new TableColumn("Base Agility");
            col.setCellValueFactory(new PropertyValueFactory<RasModel, Integer>("baseAgi"));
            listRas.getColumns().addAll(col);
            col = new TableColumn("Base Dexterity");
            col.setCellValueFactory(new PropertyValueFactory<RasModel, Integer>("baseDex"));
            listRas.getColumns().addAll(col);
            col = new TableColumn("Base Constitution");
            col.setCellValueFactory(new PropertyValueFactory<RasModel, Integer>("baseCon"));
            listRas.getColumns().addAll(col);
            col = new TableColumn("Base Intelligence");
            col.setCellValueFactory(new PropertyValueFactory<RasModel, Integer>("baseInt"));
            listRas.getColumns().addAll(col);
            col = new TableColumn("Base Wisdom");
            col.setCellValueFactory(new PropertyValueFactory<RasModel, Integer>("baseWis"));
            listRas.getColumns().addAll(col);
            col = new TableColumn("Base Luck");
            col.setCellValueFactory(new PropertyValueFactory<RasModel, Integer>("baseLuck"));
            listRas.getColumns().addAll(col);
            
            listRas.setItems(data);

        } else {
            Alert a = new Alert(Alert.AlertType.ERROR, "There's No Race Yet", ButtonType.OK);
            a.showAndWait();
            //listRas.getScene().getWindow().hide();
        }
    }
    
    private void playAudio(){
        music = new Media(getClass().getResource("Add.mp4").toExternalForm()); 
        mediaPlayer = new MediaPlayer(music);
        mediaPlayer.play();
    }
}
