/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cardsystem2;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

/**
 *
 * @author Tsunderella
 */
public class CardSystem2 extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        
    FXMLLoader loader = new FXMLLoader(getClass().getResource("MisaldoUI2.fxml"));
    
        Parent root = (Parent) loader.load();
        SaldoController controller = loader.getController();
        controller.setStage(stage);
        //FXMLDocumentController Doccontrol = new FXMLDocumentController();
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        scene.getStylesheets().add
 (CardSystem2.class.getResource("misaldoui.css").toExternalForm());
        stage.show();
        stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
       @Override
       public void handle(WindowEvent e) {
          Platform.exit();
          System.exit(0);
       }
    });
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
