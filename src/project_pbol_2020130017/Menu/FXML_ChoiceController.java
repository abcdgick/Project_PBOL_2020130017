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
import static project_pbol_2020130017.Menu.MainMenuController.mediaPlayer;

/**
 * FXML Controller class
 *
 * @author acer
 */
public class FXML_ChoiceController implements Initializable {

    @FXML
    private AnchorPane choicePane;
    @FXML
    private ImageView imageCreate;
    @FXML
    private ImageView imageAdd;
    @FXML
    private ImageView imageBack;
    @FXML
    private Button btnCreate;
    @FXML
    private Button btnAdd;
    @FXML
    private Button btnBack;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void createKlik(ActionEvent event) throws IOException {
        System.out.println("Create");
        
        mediaPlayer.stop();
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/project_pbol_2020130017/Create/FXML_CreateHero.fxml"));
        Parent root = loader.load();
        
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        
        String css = this.getClass().getResource("/project_pbol_2020130017/Create/Style2.css").toExternalForm();
        scene.getStylesheets().add(css);
        
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void addKlik(ActionEvent event) throws IOException {
        System.out.println("Add Awal");
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("FXML_ChoiceAdd.fxml"));
        Parent root = loader.load();
        
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        
        String css = this.getClass().getResource("Style.css").toExternalForm();
        scene.getStylesheets().add(css);
        
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void backKlik(ActionEvent event) {
        Stage stage = (Stage) btnBack.getScene().getWindow();
        stage.close();
    }
    
}
