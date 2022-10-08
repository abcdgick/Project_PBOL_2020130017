/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package project_pbol_2020130017.Menu;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Modality;
import javafx.stage.Stage;
import project_pbol_2020130017.DB.DBHero;
import project_pbol_2020130017.DB.DBKelas;
import project_pbol_2020130017.DB.DBRas;
import project_pbol_2020130017.DB.DBTanda;

/**
 * FXML Controller class
 *
 * @author acer
 */
public class MainMenuController implements Initializable {

    public static Media music;
    public static MediaPlayer mediaPlayer;
    
    @FXML
    private AnchorPane menuPane;
    @FXML
    private MediaView mediaView;
    @FXML
    private ImageView imageStart;
    @FXML
    private ImageView imageOption;
    @FXML
    private ImageView imageExit;
    @FXML
    private Button btnStart;
    @FXML
    private Button btnOption;
    @FXML
    private Button btnExit;
    
    public static DBKelas dtKelas = new DBKelas();
    public static DBRas dtRas = new DBRas();
    public static DBTanda dtTanda = new DBTanda();
    public static DBHero dtHero = new DBHero();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        justPlayAudio();
    }

    @FXML
    private void startKlik(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("FXML_Choice.fxml"));
            Parent root = (Parent)loader.load();
            FXML_ChoiceController isidt = (FXML_ChoiceController)loader.getController();
            Scene scene = new Scene(root);
            Stage stg = new Stage();
            
            String css = this.getClass().getResource("Style.css").toExternalForm();
            scene.getStylesheets().add(css);
            
            stg.initModality(Modality.APPLICATION_MODAL);
            stg.setResizable(false);
            stg.setIconified(false);
            stg.setScene(scene);
            stg.showAndWait();
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    @FXML
    private void optionKlik(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("FXML_Option.fxml"));
            Parent root = (Parent)loader.load();
            FXML_OptionController isidt = (FXML_OptionController)loader.getController();
            Scene scene = new Scene(root);
            Stage stg = new Stage();
            
            String css = this.getClass().getResource("Style.css").toExternalForm();
            scene.getStylesheets().add(css);
            
            stg.initModality(Modality.APPLICATION_MODAL);
            stg.setResizable(false);
            stg.setIconified(false);
            stg.setScene(scene);
            stg.showAndWait();
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    @FXML
    private void exitKlik(ActionEvent event) {
        System.out.println("Quit");
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Quit");
        alert.setHeaderText("You're going to quit the game");
        alert.setContentText("All unsaved progress will be lost!");
        
        if(alert.showAndWait().get() == ButtonType.OK){
            Stage stage = (Stage) menuPane.getScene().getWindow();
            System.out.println("Come Again!");
            stage.close();
        }
    }
    
    private void justPlayAudio(){
        music = new Media(getClass().getResource("Menu.mp4").toExternalForm()); 
        
        mediaPlayer = new MediaPlayer(music);
        
        mediaPlayer.setAutoPlay(true);
        mediaView.setMediaPlayer(mediaPlayer);
    }
    
}
