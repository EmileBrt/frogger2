package game.frogger2;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;
import util.ControlKeys;
import util.Frog;
import util.Road;
import game.frogger2.Controls;

public class Main extends Application {

    public Road road = new Road();

    public Controls control = new Controls(ControlKeys.ZQSD);

    static Frog frog = new Frog("file:src/main/java/image/frogg.png", 550, 555, 40.0d, 40.0d);

    Image car_img = new Image("file:src/main/java/image/redcar2.gif");
    ImagePattern car_pattern = new ImagePattern(car_img);

    Image road_img1 = new Image("file:src/main/java/image/road1.png");
    ImagePattern road_pattern1 = new ImagePattern(road_img1);

    Image road_img2 = new Image("file:src/main/java/image/road2.png");
    ImagePattern road_pattern2 = new ImagePattern(road_img2);

    @Override
    public void start(Stage primaryStage) {
        BorderPane root = new BorderPane();
        //Creating a scene object
        Scene scene = new Scene(root, 1200, 600);
        scene.setFill(Color.BLACK);


        // Fill lanes with roat_pattern
        for(int i=0;i< road.nbLanes;i++){
            if(i%2==1){road.lanes.get(i).setFill(road_pattern1);};
            if(i%2==0){road.lanes.get(i).setFill(road_pattern2);};
            road.lanes.get(0).setFill(Color.DARKGREEN);
            road.lanes.get(11).setFill(Color.DARKGREEN);
            // Fill Objects in lanes with car_pattern
            for(int j=0;j<road.lanes.get(i).objects.size();j++){road.lanes.get(i).objects.get(j).setFill(car_pattern);
                TranslateTransition transition = new TranslateTransition(
                        Duration.seconds(4000/road.lanes.get(i).getSpeed()),
                        road.lanes.get(i).objects.get(j) );
                transition.setByX(4000f);
                transition.play();
            }
        }

        // Moving the frog
        EventHandler<KeyEvent> keyListener = new EventHandler<>() {
            @Override

            public void handle(KeyEvent e) {
                control.moveFrog(e, frog);
            }
        };

        // Win or Lose Event
        Thread thread_win_lose = new Thread(() -> {
            while(true){
                if(road.Endgame(frog)){
                    System.out.println("PERDU");
                    break;
                }
                if(frog.getY()+frog.getTranslateY()<50){
                    System.out.println("GAGNE");
                    break;
                }
                try
                {
                    Thread.sleep(100);
                }
                catch(InterruptedException ex)
                {
                    Thread.currentThread().interrupt();
                }
            }
        });

        Thread thread_update = new Thread(() -> {
            while(true){
                if(road.update_need()) {
                    System.out.println("besoin d'une update");
                    road.update();
                }
                try
                {
                    Thread.sleep(100);
                }
                catch(InterruptedException ex)
                {
                    Thread.currentThread().interrupt();
                }
            }
        });

        // keypressed event
        scene.addEventHandler(KeyEvent.KEY_PRESSED,keyListener);

        thread_win_lose.start();
        thread_update.start();

        // add lanes and cars to root
        for(int i=0;i< road.lanes.size();i++){
            root.getChildren().add(road.lanes.get(i));
            for(int j=0;j<road.lanes.get(i).objects.size();j++){root.getChildren().add(road.lanes.get(i).objects.get(j));}
        }
        root.getChildren().add(frog);
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}