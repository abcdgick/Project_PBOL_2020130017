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
import project_pbol_2020130017.DB.TandaModel;
import static project_pbol_2020130017.Main.stageMenu;
import static project_pbol_2020130017.Menu.MainMenuController.dtTanda;
import static project_pbol_2020130017.Menu.MainMenuController.mediaPlayer;
import static project_pbol_2020130017.Menu.MainMenuController.music;


/**
 * FXML Controller class
 *
 * @author acer
 */
public class FXML_ListTandaController implements Initializable {

    @FXML
    private AnchorPane addPane;
    @FXML
    private Button btnNew;
    @FXML
    private Button btnEdit;
    @FXML
    private Button btnExit;
    @FXML
    private TableView<TandaModel> listTanda;
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
            FXMLLoader loader = new FXMLLoader(getClass().getResource("FXML_AddTanda.fxml"));
            Parent root = (Parent)loader.load();
            FXML_AddTandaController isidt = (FXML_AddTandaController)loader.getController();
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
            TandaModel s = new TandaModel();
            s=listTanda.getSelectionModel().getSelectedItem();
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("FXML_AddTanda.fxml"));
                Parent root = (Parent)loader.load();
                FXML_AddTandaController isidt = (FXML_AddTandaController)loader.getController();
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
            Alert a = new Alert(Alert.AlertType.ERROR,"You haven't select a birthsign to edit", ButtonType.OK);
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
            TandaModel s = listTanda.getSelectionModel().getSelectedItem();
            Alert a = new Alert(Alert.AlertType.CONFIRMATION,"Delete this birthsign? This action is irrevesable", ButtonType.YES,ButtonType.NO);
            a.showAndWait();
            if(a.getResult()==ButtonType.YES){
                if(dtTanda.delete(s.getIDTanda())){
                    Alert b = new Alert(Alert.AlertType.INFORMATION, "Birthsign has been deleted", ButtonType.OK);
                    b.showAndWait();
                } else {
                    Alert b = new Alert(Alert.AlertType.ERROR, "Birthsign deletion failed", ButtonType.OK);
                    b.showAndWait();
                }
                showData();
            }
        } catch (Exception e) {
            Alert a = new Alert(Alert.AlertType.ERROR,"You haven't select a birthsign to delete", ButtonType.OK);
            a.showAndWait();
        }
    }
    
    private void showData(){
        ObservableList<TandaModel> data = dtTanda.Load();
        if(data!=null){
            listTanda.getColumns().clear();
            listTanda.getItems().clear();
            System.out.println("Jalan");
            TableColumn col = new TableColumn("Birthsign ID");
            col.setCellValueFactory(new PropertyValueFactory<TandaModel, String>("IDTanda"));
            listTanda.getColumns().addAll(col);
            col = new TableColumn("Birthsign Name");
            col.setCellValueFactory(new PropertyValueFactory<TandaModel, String>("namaTanda"));
            listTanda.getColumns().addAll(col);
            col = new TableColumn("Birthsign Detail");
            col.setCellValueFactory(new PropertyValueFactory<TandaModel, String>("detilTanda"));
            listTanda.getColumns().addAll(col);
            col = new TableColumn("HP Buff");
            col.setCellValueFactory(new PropertyValueFactory<TandaModel, Integer>("buffHP"));
            listTanda.getColumns().addAll(col);
            col = new TableColumn("MP Buff");
            col.setCellValueFactory(new PropertyValueFactory<TandaModel, Integer>("buffMP"));
            listTanda.getColumns().addAll(col);
            col = new TableColumn("Physical Attack Buff");
            col.setCellValueFactory(new PropertyValueFactory<TandaModel, Integer>("buffPAtk"));
            listTanda.getColumns().addAll(col);
            col = new TableColumn("Physical Defence Buff");
            col.setCellValueFactory(new PropertyValueFactory<TandaModel, Integer>("buffPDef"));
            listTanda.getColumns().addAll(col);
            col = new TableColumn("Magical Attack Buff");
            col.setCellValueFactory(new PropertyValueFactory<TandaModel, Integer>("buffMAtk"));
            listTanda.getColumns().addAll(col);
            col = new TableColumn("Magical Defence Buff");
            col.setCellValueFactory(new PropertyValueFactory<TandaModel, Integer>("buffMDef"));
            listTanda.getColumns().addAll(col);
            col = new TableColumn("Attack Speed Buff");
            col.setCellValueFactory(new PropertyValueFactory<TandaModel, Integer>("buffAtkS"));
            listTanda.getColumns().addAll(col);
            col = new TableColumn("Stamina Buff");
            col.setCellValueFactory(new PropertyValueFactory<TandaModel, Integer>("buffSta"));
            listTanda.getColumns().addAll(col);
            col = new TableColumn("Stamina Regen Buff");
            col.setCellValueFactory(new PropertyValueFactory<TandaModel, Integer>("buffStaR"));
            listTanda.getColumns().addAll(col);
            col = new TableColumn("MP Regen Buff");
            col.setCellValueFactory(new PropertyValueFactory<TandaModel, Integer>("buffMPR"));
            listTanda.getColumns().addAll(col);
            col = new TableColumn("Critical Chance Buff");
            col.setCellValueFactory(new PropertyValueFactory<TandaModel, Integer>("buffCrit"));
            listTanda.getColumns().addAll(col);
            
            listTanda.setItems(data);

        } else {
            Alert a = new Alert(Alert.AlertType.ERROR, "There's No Birthsign Yet", ButtonType.OK);
            a.showAndWait();
            //listTanda.getScene().getWindow().hide();
        }
    }
    
    private void playAudio(){
        music = new Media(getClass().getResource("Add.mp4").toExternalForm()); 
        mediaPlayer = new MediaPlayer(music);
        mediaPlayer.play();
    }
}
