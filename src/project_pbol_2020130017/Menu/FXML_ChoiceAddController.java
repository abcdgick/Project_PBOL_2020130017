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
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import static project_pbol_2020130017.Main.stageMenu;
import static project_pbol_2020130017.Menu.MainMenuController.mediaPlayer;

/**
 * FXML Controller class
 *
 * @author acer
 */
public class FXML_ChoiceAddController implements Initializable {

    @FXML
    private AnchorPane choicePane;
    @FXML
    private ImageView imageRace;
    @FXML
    private ImageView imageClass;
    @FXML
    private ImageView imageTanda;
    @FXML
    private ImageView imageBack;
    @FXML
    private Button btnRace;
    @FXML
    private Button btnClass;
    @FXML
    private Button btnTanda;
    @FXML
    private Button btnBack;
    @FXML
    private Button btnAgama;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void raceKlik(ActionEvent event) throws IOException {
        stopMenu();
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/project_pbol_2020130017/Add/FXML_ListRas.fxml"));
        Parent root = loader.load();
        
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        
        String css = this.getClass().getResource("/project_pbol_2020130017/Add/Style3.css").toExternalForm();
        scene.getStylesheets().add(css);
        
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void classKlik(ActionEvent event) throws IOException {
        stopMenu();
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/project_pbol_2020130017/Add/FXML_ListKelas.fxml"));
        Parent root = loader.load();
        
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        
        String css = this.getClass().getResource("/project_pbol_2020130017/Add/Style3.css").toExternalForm();
        scene.getStylesheets().add(css);
        
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void tandaKlik(ActionEvent event) throws IOException {
        stopMenu();
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/project_pbol_2020130017/Add/FXML_ListTanda.fxml"));
        Parent root = loader.load();
        
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        
        String css = this.getClass().getResource("/project_pbol_2020130017/Add/Style3.css").toExternalForm();
        scene.getStylesheets().add(css);
        
        stage.setScene(scene);
        stage.show();
    }
    
    @FXML
    private void agamaKlik(ActionEvent event) throws IOException {
        stopMenu();
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/project_pbol_2020130017/Add/FXML_ListAgama.fxml"));
        Parent root = loader.load();
        
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        
        String css = this.getClass().getResource("/project_pbol_2020130017/Add/Style3.css").toExternalForm();
        scene.getStylesheets().add(css);
        
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void backKlik(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/project_pbol_2020130017/Menu/FXML_Choice.fxml"));
        Parent root = loader.load();
        
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        
        String css = this.getClass().getResource("/project_pbol_2020130017/Menu/Style.css").toExternalForm();
        scene.getStylesheets().add(css);
        
        stage.setScene(scene);
        stage.show();
    }

    private void stopMenu() {
        stageMenu.close();
        mediaPlayer.stop();
    }

}
