package game.frogger2;
import javafx.application.Application;
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
    public Scene game_scene, menu_scene;

    public Thread thread_update, thread_win_lose;

    public EventType EndEventType;
    public Event winEvent, loseEvent;
    public Game game;
    public Main() throws IOException {

    }

    @Override
    public void start(Stage primaryStage) {

        //Creation des event winlose
        this.EndEventType = new EventType("WinEvent");
        this.winEvent = new Event(EndEventType);
        this.loseEvent = new Event(EndEventType);

        // attribution d'une valeur à game
        this.game = new Game(winEvent, loseEvent);


        // attribution des valeurs
        this.game_scene = game.gameScene;
        this.window = primaryStage;
        this.menu_scene = menu.menu_scene;
        this.menu.game_scene = game_scene;

        //
        this.menu.buttonActionSetup(window, game, this);


        // Moving the frog
        EventHandler<KeyEvent> keyListener = e -> game.controls.moveFrog(e, game.frog);

        EventHandler<Event> WinLoseListener = new EventHandler<Event>() {


            @Override
            public void handle(Event event) {
                System.out.println("Event !!");
                if (EndEventType.equals(event.getEventType())) {

                    window.setScene(game_scene);

                }
            }
        };

        // Win or Lose Event
        this.thread_win_lose = new Thread(() -> {
            while(true){
                if(game.road.Endgame(game.frog)){
                    System.out.println("PERDU");
                    this.winEvent = new Event(EndEventType);
                    Event.fireEvent(game.gameScene, winEvent);
                    break;
                }
                if(game.frog.getY() + game.frog.getTranslateY() < 50){
                    System.out.println("GAGNE");
                    window.setScene(menu_scene);
                    menu.display_win();
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

        this.thread_update = new Thread(() -> {
            while(true){
                game.road.update();
                try
                {
                    Thread.sleep(10);
                }
                catch(InterruptedException ex)
                {
                    Thread.currentThread().interrupt();
                }
            }
        });



        game.gameScene.addEventHandler(EndEventType, WinLoseListener);
        // keypressed event
        game.gameScene.addEventHandler(KeyEvent.KEY_PRESSED,keyListener);

        thread_win_lose.start();
        thread_update.start();


        window.setScene(menu_scene);
        window.setResizable(false);
        window.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}