package game.frogger2;

import javafx.application.Application;
import javafx.event.Event;
import javafx.event.EventType;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {


    public Menu menu = new Menu();
    public Stage window;


    public Main() throws IOException {

    }

    @Override
    public void start(Stage primaryStage) {

        this.window = primaryStage;
        this.menu.buttonActionSetup(window, this);



        window.setScene(menu.menu_scene);
        window.setResizable(false);
        window.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}