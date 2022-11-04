/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package project_pbol_2020130017.Menu;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import project_pbol_2020130017.Main;
import static project_pbol_2020130017.Menu.MainMenuController.mediaPlayer;

/**
 * FXML Controller class
 *
 * @author acer
 */
public class FXML_OptionController implements Initializable {

    @FXML
    private AnchorPane optionPane;
    @FXML
    private ImageView imageVolume;
    @FXML
    private Slider sliderVolume;
    @FXML
    private Label labelVolume;
    @FXML
    private ImageView imageBack;
    @FXML
    private Button btnBack;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        volume();
    }    

    @FXML
    private void backKlik(ActionEvent event) {
        Stage stage = (Stage) btnBack.getScene().getWindow();
        stage.close();
    }
    
    private void volume(){
        //Main.volume = sliderVolume.getValue()/100.0;
        labelVolume.setText(Integer.toString((int) (Main.volume * 4 * 100.0)));
        sliderVolume.setValue(Main.volume * 4 * 100.0);
        //System.out.println(Main.volume);
        //System.out.println(labelVolume.getText());
        
        sliderVolume.valueProperty().addListener(new ChangeListener<Number>(){
            @Override
            public void changed(ObservableValue<?extends Number>
                observable, Number oldValue, Number newValue){
                Main.volume = sliderVolume.getValue()/400;
                labelVolume.setText(Integer.toString((int)(Main.volume * 4 * 100.0)));
                mediaPlayer.setVolume(Main.volume);
            }
        });
    }
}
