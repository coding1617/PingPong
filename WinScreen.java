import java.util.Optional;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.stage.Stage;


public class WinScreen{
    private Stage ps;

    public void start(Stage primaryStage){
        ps = primaryStage;
        showWinScreen();
    }
    
    public void showWinScreen(){
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Confirmation Dialog with Custom Actions");
        alert.setHeaderText("Look, a Confirmation Dialog with Custom Actions");
        alert.setContentText("Choose your option.");
    
        ButtonType playAgain = new ButtonType("Play Again");
        ButtonType buttonTypeCancel = new ButtonType("Cancel", ButtonData.CANCEL_CLOSE);
    
        alert.getButtonTypes().setAll(playAgain, buttonTypeCancel);
    
        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == playAgain){
            WelcomeScreen game = new WelcomeScreen(); 
            game.start(ps);
        } else {
            // ... user chose CANCEL or closed the dialog
        }
    }

}