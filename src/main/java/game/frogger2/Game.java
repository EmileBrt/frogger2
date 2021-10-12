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
import util.Road;

public class Game extends Application {

    static Road road = new Road();

    static Rectangle frog = new Rectangle(550, 555, 40.0d, 40.0d);
    Image frog_img = new Image("file:src/main/java/image/frogg.png");
    ImagePattern frog_pattern = new ImagePattern(frog_img);

    Image car_img = new Image("file:src/main/java/image/redcar2.gif");
    ImagePattern car_pattern = new ImagePattern(car_img);

    Image road_img1 = new Image("file:src/main/java/image/road1.png");
    ImagePattern road_pattern1 = new ImagePattern(road_img1);

    Image road_img2 = new Image("file:src/main/java/image/road2.png");
    ImagePattern road_pattern2 = new ImagePattern(road_img2);

    @Override
    public void start(Stage primaryStage) {
        //Creating a BroderPane
        BorderPane root = new BorderPane();
        //Creating a scene object
        Scene scene = new Scene(root, 1200, 600);
        scene.setFill(Color.BLACK);

        // Fill frog with car frog
        frog.setFill(frog_pattern);

        // Fill lanes with DARKGREEN
        for(int i=0;i< road.nbLanes;i++){
            if(i%2==1){road.lanes.get(i).setFill(road_pattern1);};
            if(i%2==0){road.lanes.get(i).setFill(road_pattern2);};
            road.lanes.get(0).setFill(Color.DARKGREEN);
            road.lanes.get(11).setFill(Color.DARKGREEN);
            // Fill Objects in lanes with car_pattern
            for(int j=0;j<road.lanes.get(i).objects.size();j++){road.lanes.get(i).objects.get(j).setFill(car_pattern);
                TranslateTransition transition = new TranslateTransition(
                        Duration.seconds(2000/road.lanes.get(i).getSpeed()),
                        road.lanes.get(i).objects.get(j) );
                transition.setByX(2000f);
                transition.play();
            }
        }
        // Moving the frog
        EventHandler<KeyEvent> keyListener = new EventHandler<>() {
            @Override
            public void handle(KeyEvent e) {
                TranslateTransition transition = new TranslateTransition(Duration.seconds(0.10),frog);
                switch (e.getCode()){
                    case Q :
                        System.out.println("LEFT");
                        frog.setRotate(270);
                        transition.setByX(-50);
                        transition.play();
                        System.out.println("X:"+(frog.getX()+frog.getTranslateX())+"Y:"+(frog.getY()+frog.getTranslateY()));
                        break;
                    case D:
                        System.out.println("RIGHT");
                        frog.setRotate(90);
                        transition.setByX(+50);
                        transition.play();
                        frog.localToParentTransformProperty();
                        System.out.println("X:"+(frog.getX()+frog.getTranslateX())+"Y:"+(frog.getY()+frog.getTranslateY()));
                        break;
                    case S :
                        System.out.println("DOWN");
                        frog.setRotate(180);
                        transition.setByY(+50);
                        transition.play();
                        System.out.println("X:"+(frog.getX()+frog.getTranslateX())+"Y:"+(frog.getY()+frog.getTranslateY()));
                        break;
                    case Z:
                        System.out.println("UP");
                        frog.setRotate(0);
                        transition.setByY(-50);
                        transition.play();
                        System.out.println("X:"+(frog.getX()+frog.getTranslateX())+"Y:"+(frog.getY()+frog.getTranslateY()));
                        break;
                }
                // update car
                road.update();
                // To Do Stop Condition
                if (road.Endgame(frog)==true){
                    System.out.println("Tu as perdu");
                }
                // To Do Win Condition To_Do
                if(frog.getY()+frog.getTranslateY()<70){
                    System.out.println("Tu as gagné");
                }
            }
        };

        // keypressed event
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