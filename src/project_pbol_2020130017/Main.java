/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML.java to edit this template
 */
package project_pbol_2020130017;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;

/**
 *
 * @author acer
 */
public class Main extends Application {
    
    public static double volume = 0.3;
    public static Stage stageMenu;
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("Menu/MainMenu.fxml"));
        
        Scene scene = new Scene(root);
        
        String css = this.getClass().getResource("Menu/Style.css").toExternalForm();
        scene.getStylesheets().add(css);
        
        
        stage.setScene(scene);
        stage.show();
        stageMenu = stage;
        stage.setOnCloseRequest(event -> {
            event.consume();
            quit(stage);
        });
    }
    
    private void quit(Stage stage) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Quit");
        alert.setHeaderText("You're going to quit the game");
        alert.setContentText("All unsaved progress will be lost!");
        
        if(alert.showAndWait().get() == ButtonType.OK){
            System.out.println("Come Again!");
            stage.close();
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
