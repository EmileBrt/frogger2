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
import javafx.stage.Stage;
import javafx.util.Duration;
import util.ControlKeys;
import util.Frog;
import util.Road;

public class Main extends Application {

    public Game game = new Game();

    @Override
    public void start(Stage primaryStage) {


        // Moving the frog
        EventHandler<KeyEvent> keyListener = new EventHandler<>() {
            @Override
            public void handle(KeyEvent e) {
                game.controls.moveFrog(e, game.frog);
            }
        };

        // Win or Lose Event
        Thread thread_win_lose = new Thread(() -> {
            while(true){
                if(game.road.Endgame(game.frog)){
                    System.out.println("PERDU");
                    break;
                }
                if(game.frog.getY() + game.frog.getTranslateY() < 50){
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

        // keypressed event
        game.gameScene.addEventHandler(KeyEvent.KEY_PRESSED,keyListener);

        thread_win_lose.start();
        thread_update.start();


        primaryStage.setScene(game.gameScene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}