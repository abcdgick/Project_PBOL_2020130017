/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package project_pbol_2020130017.Create;

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
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Modality;
import javafx.stage.Stage;
import project_pbol_2020130017.DB.HeroModel;
import static project_pbol_2020130017.Main.stageMenu;
import static project_pbol_2020130017.Menu.MainMenuController.dtHero;
import static project_pbol_2020130017.Menu.MainMenuController.mediaPlayer;
import static project_pbol_2020130017.Menu.MainMenuController.music;

/**
 * FXML Controller class
 *
 * @author acer
 */
public class FXML_ListHeroController implements Initializable {

    @FXML
    private AnchorPane createPane;
    @FXML
    private TableView<HeroModel> listHero;
    @FXML
    private Button btnNew;
    @FXML
    private Button btnEdit;
    @FXML
    private Button btnExitHero;
    @FXML
    private Button btnDelete;

    //private ArrayList <Image> imageList;
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
            java.sql.Date sqlDate = new java.sql.Date(new java.util.Date().getTime());
            String id = "APARDB" + String.valueOf(dtHero.count());
            FXMLLoader loader = new FXMLLoader(getClass().getResource("FXML_CreateHero.fxml"));
            Parent root = (Parent)loader.load();
            FXML_CreateHeroController isidt = (FXML_CreateHeroController)loader.getController();
            isidt.buatBaru(id, "AP", "AR", "DB", "Hero", sqlDate);
            Scene scene = new Scene(root);
            Stage stg = new Stage();
            stg.initModality(Modality.APPLICATION_MODAL);
            stg.setResizable(false);
            stg.setIconified(false);
            stg.setScene(scene);
            stg.show();
            Stage stage = (Stage) btnExitHero.getScene().getWindow();
            stage.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        showData();
    }

    @FXML
    private void editKlik(ActionEvent event) {
        try {
            HeroModel s = new HeroModel();
            s=listHero.getSelectionModel().getSelectedItem();
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("FXML_CreateHero.fxml"));
                Parent root = (Parent)loader.load();
                FXML_CreateHeroController isidt = (FXML_CreateHeroController)loader.getController();
                isidt.udahAda(s);
                Scene scene = new Scene(root);
                Stage stg = new Stage();
                stg.initModality(Modality.APPLICATION_MODAL);
                stg.setResizable(false);
                stg.setIconified(false);
                stg.setScene(scene);
                stg.show();
                Stage stage = (Stage) btnExitHero.getScene().getWindow();
                stage.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            showData();
        } catch (Exception e) {
            Alert a = new Alert(Alert.AlertType.ERROR,"You haven't select a hero to edit", ButtonType.OK);
            a.showAndWait();
        }
    }
    
    @FXML
    private void deleteKlik(ActionEvent event) {
        try {
            HeroModel s=listHero.getSelectionModel().getSelectedItem();
            Alert a = new Alert(Alert.AlertType.CONFIRMATION,"Delete this hero? This action is irrevesable", ButtonType.YES,ButtonType.NO);
            a.showAndWait();
            if(a.getResult()==ButtonType.YES){
                if(dtHero.delete(s.getIDHero())){
                    Alert b = new Alert(Alert.AlertType.INFORMATION, "Hero has been deleted", ButtonType.OK);
                    b.showAndWait();
                } else {
                    Alert b = new Alert(Alert.AlertType.ERROR, "Hero deletion failed", ButtonType.OK);
                    b.showAndWait();
                }
                showData();
            }
        } catch (Exception e) {
            Alert a = new Alert(Alert.AlertType.ERROR,"You haven't select a hero to delete", ButtonType.OK);
            a.showAndWait();
        }
    }
    
    @FXML
    private void exitHeroKlik(ActionEvent event) {
        Alert a = new Alert(Alert.AlertType.CONFIRMATION,"Go back to the Main Menu? All unsaved progress will be lost", ButtonType.YES,ButtonType.NO);
        a.showAndWait();
        if(a.getResult()==ButtonType.YES){
            stageMenu.show();
            mediaPlayer.stop();
            
            music = new Media(getClass().getResource("/project_pbol_2020130017/Menu/Menu.mp4").toExternalForm()); 
            mediaPlayer = new MediaPlayer(music);
            mediaPlayer.play();
            
            Stage stage = (Stage) btnExitHero.getScene().getWindow();
            stage.close();
        }
    }
    
    private void showData(){
        ObservableList<HeroModel> data = dtHero.Load();
        if(data!=null){
            listHero.getColumns().clear();
            listHero.getItems().clear();
            System.out.println("Jalan");
            TableColumn col = new TableColumn("Hero ID");
            col.setCellValueFactory(new PropertyValueFactory<HeroModel, String>("IDHero"));
            listHero.getColumns().addAll(col);
            col = new TableColumn("Hero Name");
            col.setCellValueFactory(new PropertyValueFactory<HeroModel, String>("namaHero"));
            listHero.getColumns().addAll(col);
            col = new TableColumn("Class ID");
            col.setCellValueFactory(new PropertyValueFactory<HeroModel, String>("IDKelas"));
            listHero.getColumns().addAll(col);
            col = new TableColumn("Class Name");
            col.setCellValueFactory(new PropertyValueFactory<HeroModel, String>("namaKelas"));
            listHero.getColumns().addAll(col);
            col = new TableColumn("Race ID");
            col.setCellValueFactory(new PropertyValueFactory<HeroModel, String>("IDRas"));
            listHero.getColumns().addAll(col);
            col = new TableColumn("Race Name");
            col.setCellValueFactory(new PropertyValueFactory<HeroModel, String>("namaRas"));
            listHero.getColumns().addAll(col);
            col = new TableColumn("Creation Date");
            col.setCellValueFactory(new PropertyValueFactory<HeroModel, Date>("creationDate"));
            listHero.getColumns().addAll(col);
            listHero.setItems(data);

        } else {
            Alert a = new Alert(Alert.AlertType.ERROR, "There's No Hero Yet", ButtonType.OK);
            a.showAndWait();
            //listHero.getScene().getWindow().hide();
        }
    }
    
    private void playAudio(){
        music = new Media(getClass().getResource("Create.mp4").toExternalForm()); 
        mediaPlayer = new MediaPlayer(music);
        mediaPlayer.play();
    }
}
