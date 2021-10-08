package com.example.frogger2;

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

    static Rectangle frog = new Rectangle(50.0d, 50.0d, 40.0d, 40.0d);
    Image frog_img = new Image("file:src/main/java/image/frogg.png");
    ImagePattern frog_pattern = new ImagePattern(frog_img);

    static Rectangle car = new Rectangle(200.0d, 200.0d, 150.0d, 50.0d);
    Image car_img = new Image("file:src/main/java/image/voiture.jpg");
    ImagePattern car_pattern = new ImagePattern(car_img);

    @Override
    public void start(Stage primaryStage) {
        BorderPane root = new BorderPane();
        //Creating a scene object
        Scene scene = new Scene(root, 600, 300);
        scene.setFill(Color.BLACK);

        // Fill frog with car frog
        frog.setFill(frog_pattern);

        // Fill car with car image
        car.setFill(car_pattern);

        // Fill lanes with DARKGREEN
        for(int i=0;i< road.nbLanes;i++){
            road.lanes.get(i).setFill(Color.DARKGREEN);
        }

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

                // Stop Condition

                if (frog.intersects(car.getX(),car.getY(),car.getWidth(),car.getHeight())) {
                    System.out.println("Stop");
                }
            }
        };

        // Show content
        scene.addEventHandler(KeyEvent.KEY_PRESSED,keyListener);
        root.getChildren().add(frog);
        root.getChildren().add(car);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}