import javafx.application.Platform;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DialogPane;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.layout.Region;
import javafx.stage.Stage;
 
 
public class WinScreen{
    private Stage ps;
 
    public void start(Stage primaryStage){
        ps = primaryStage;
        showWinScreen();
    }
    
    public void showWinScreen(){
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
        alert.setResizable(true);
 
        DialogPane dialogPane = alert.getDialogPane();
        dialogPane.getStylesheets().add(
            getClass().getResource("win.css").toExternalForm());
        dialogPane.getStyleClass().add(".dialog-pane");
 
        alert.setTitle("Nice reflexes.");
        alert.setHeaderText("Hey, you won!");
        alert.setContentText("You were able to keep the ball in check. Good job! "+
                            "You're now a Ping Pong winner. Want to play again?");
    
        ButtonType buttonTypeCancel = new ButtonType("Cancel", ButtonData.CANCEL_CLOSE);
    
        alert.getButtonTypes().setAll(buttonTypeCancel);
    
       Platform.runLater(alert::showAndWait);
    }
 
}
 

