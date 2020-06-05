import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.text.Font; 
import javafx.stage.Stage;
import javafx.util.Duration; 

public class Clock extends HBox{
    private final Integer startTime = 60; 
    private Integer seconds = startTime; 
    private Label label; 
    
    public void start(Stage windows) throws Exception { //extends pane
        
        //Group root = new Group(); 
        label = new Label();
        Stop[] stops = new Stop[] { 
            new Stop(0, Color.DODGERBLUE),  
            new Stop(1, Color.RED)
        };  
        LinearGradient linearGradient = new LinearGradient(0, 0, 1, 0, true, CycleMethod.NO_CYCLE, stops); 
        //label.setFill(linearGradient); 
        label.setFont(Font.font ("Phosphate",50)); 
        label.setTextFill(linearGradient); 
        // HBox layout = new HBox(5); 
        this.getChildren().add(label);
        // layout.setLayoutX(10);
        //root.getChildren().add(layout);
        doTime();
        
    }

    private void doTime(){
        Timeline time = new Timeline();
        time.setCycleCount(Timeline.INDEFINITE);
            if(time!=null){
                time.stop();
            }
        KeyFrame frame = new KeyFrame(Duration.seconds(1), new EventHandler<ActionEvent>(){

            @Override
            public void handle(ActionEvent event) {
                seconds --;
                label.setText("Countdown: " + seconds.toString());
                    if(seconds<=0){
                        time.stop();
                    }
            }
        });
        time.getKeyFrames().add(frame);
        time.playFromStart();
    }
}