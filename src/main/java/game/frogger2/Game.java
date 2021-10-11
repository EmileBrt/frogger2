package game.frogger2;

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
import util.Road;

public class Game extends Application {

    static Road road = new Road();

    static Rectangle frog = new Rectangle(550, 555, 40.0d, 40.0d);
    Image frog_img = new Image("file:src/main/java/image/frogg.png");
    ImagePattern frog_pattern = new ImagePattern(frog_img);

    Image car_img = new Image("file:src/main/java/image/redcar2.gif");
    ImagePattern car_pattern = new ImagePattern(car_img);

    @Override
    public void start(Stage primaryStage) {
        BorderPane root = new BorderPane();
        //Creating a scene object
        Scene scene = new Scene(root, 1200, 600);
        scene.setFill(Color.BLACK);

        // Fill frog with car frog
        frog.setFill(frog_pattern);

        // Fill lanes with DARKGREEN
        for(int i=0;i< road.nbLanes;i++){
            road.lanes.get(i).setFill(Color.DARKGREEN);
            // Fill Objects in lanes with car_pattern
            for(int j=0;j<road.lanes.get(i).objects.size();j++){road.lanes.get(i).objects.get(j).setFill(car_pattern);}
        }

        //Create Translate Transition
        //TranslateTransition transition = new TranslateTransition(Duration.seconds(0.50), rec);transition.setByX(20f);

        // Moving the frog
        EventHandler<KeyEvent> keyListener = new EventHandler<>() {
            @Override
            public void handle(KeyEvent e) {
                switch (e.getCode()){
                    case LEFT :
                        System.out.println("LEFT");
                        frog.setX(frog.getX() - 50);
                        frog.setRotate(270);
                        break;
                    case RIGHT:
                        System.out.println("RIGHT");
                        frog.setX(frog.getX() + 50);
                        frog.setRotate(90);
                        break;
                    case DOWN:
                        System.out.println("DOWN");
                        frog.setY(frog.getY() + 50);
                        frog.setRotate(180);
                        break;
                    case UP:
                        System.out.println("UP");
                        frog.setY(frog.getY() - 50);
                        frog.setRotate(0);
                        break;
                }

                // To Do Stop Condition
                // To Do Win Condition To_Do
            }
        };

        // Show content
        scene.addEventHandler(KeyEvent.KEY_PRESSED,keyListener);

        // Add lanes (To_do: and object of lanes to root)
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