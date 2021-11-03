package game.frogger2;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class test_menu extends Application {
    public Game game = new Game();
    public Menu menu = new Menu();
    public Stage window;
    public Scene game_scene, menu_scene;

    public test_menu() throws IOException {
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        this.game_scene = game.gameScene;
        this.window = primaryStage;
        this.menu_scene = menu.menu_scene;
        this.menu.game_scene = game_scene;

        this.menu.buttonActionSetup(window, game_scene);

        window.setScene(menu_scene);
        window.setResizable(false);
        window.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
