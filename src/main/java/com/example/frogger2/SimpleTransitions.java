package com.example.frogger2;

import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class SimpleTransitions extends Application {

    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) {
        BorderPane root = new BorderPane();
        //Creating a scene object
        Scene scene = new Scene(root, 600, 300);
        scene.setFill(Color.WHITE);

        // Creating the frog
        Rectangle rec = new Rectangle(50.0d, 50.0d, 50.0d, 50.0d);
        Image img = new Image("file:src/main/java/image/frogg.png");
        ImagePattern image_pattern = new ImagePattern(img);
        rec.setFill(image_pattern);

        // Creating a car
        Rectangle car = new Rectangle(200.0d, 200.0d, 150.0d, 50.0d);
        Image img2 = new Image("file:src/main/java/image/voiture.jpg");
        ImagePattern image_pattern2 = new ImagePattern(img2);
        car.setFill(image_pattern2);

        // Moving the frog
        EventHandler<KeyEvent> keyListener = new EventHandler<>() {
            @Override
            public void handle(KeyEvent e) {
                switch (e.getCode()){
                    case LEFT :
                        System.out.println("LEFT");
                        rec.setX(rec.getX() - 50);
                        rec.setRotate(270);
                        break;
                    case RIGHT:
                        System.out.println("RIGHT");
                        rec.setX(rec.getX() + 50);
                        rec.setRotate(90);
                        break;
                    case DOWN:
                        System.out.println("DOWN");
                        rec.setY(rec.getY() + 50);
                        rec.setRotate(180);
                        break;
                    case UP:
                        System.out.println("UP");
                        rec.setY(rec.getY() - 50);
                        rec.setRotate(0);
                        break;
                }
            }
        };

        // EventHandler afficher une collision entre la voiture et la grenouille




        // Show content
        scene.addEventHandler(KeyEvent.KEY_PRESSED,keyListener);
        root.getChildren().add(rec);
        root.getChildren().add(car);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}