package game.frogger2;
import javafx.animation.Animation;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.io.IOException;

public class Main extends Application {


    public Menu menu = new Menu();
    public Stage window;

    public EventType WinEventType, LoseEventType, resetEventType;
    public Event winEvent, loseEvent, resetEvent;
    public Game game;

    public Main() throws IOException {

    }

    @Override
    public void start(Stage primaryStage) {

        //Creation des event winlose
        this.WinEventType = new EventType("WinEvent");
        this.LoseEventType = new EventType("LoseEvent");
        this.winEvent = new Event(WinEventType);
        this.loseEvent = new Event(LoseEventType);

        //Creation des event de reset
        this.resetEventType = new EventType("resetEvent");
        this.resetEvent = new Event(resetEventType);


        // attribution d'une valeur à game
        this.game = new Game(winEvent, loseEvent, resetEvent);


        // attribution des valeurs

        this.window = primaryStage;
        this.menu.game.gameScene = game.gameScene;

        //
        this.menu.buttonActionSetup(window, game, this);

        // Moving the frog
        EventHandler<KeyEvent> keyListener = e -> game.controls.moveFrog(e, game.frog);

        EventHandler<Event> WinListener = event -> {
            if (WinEventType.equals(event.getEventType()))
                menu.display_win();
                window.setScene(menu.menu_scene);
            };

        EventHandler<Event> LoseListener = event -> {
            if (LoseEventType.equals(event.getEventType())){
                menu.display_lost();
                window.setScene(menu.menu_scene);
            }
        };

        EventHandler<Event> ResetListener = event -> {
            game = new Game(winEvent, loseEvent, resetEvent);
            this.menu.game.gameScene = game.gameScene;
        };

        // keypressed event
        game.gameScene.addEventHandler(KeyEvent.KEY_PRESSED,keyListener);
        //Endgame event
        game.gameScene.addEventHandler(WinEventType, WinListener);
        game.gameScene.addEventHandler(LoseEventType, LoseListener);
        game.gameScene.addEventHandler(resetEventType, ResetListener);

        window.setScene(menu.menu_scene);
        window.setResizable(false);
        window.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}