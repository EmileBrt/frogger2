package game.frogger2;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.IOException;


public class Menu {
    public Scene menu_scene, game_scene;
    public Stage window;
    private VBox menu_vbox;
    private Label title_label;
    private Label descritption_label;
    private HBox button_box;
    private Button play_button, help_button, quit_button;


    public Menu() throws IOException {
        SceneSetup();

    }

    private void SceneSetup() throws IOException {

        menu_vbox = new VBox();
        menu_vbox.setPrefHeight(400);
        menu_vbox.setPrefWidth(600);
        menu_vbox.setSpacing(20);
        menu_vbox.setAlignment(Pos.CENTER);

        title_label = new Label();
        title_label.setText("Frogger");
        Font title_font = new Font("Impact", 70);
        title_label.setFont(title_font);

        descritption_label = new Label();
        descritption_label.setText("Press play to start !");
        Font description_font = new Font(16);
        descritption_label.setFont(description_font);

        button_box = new HBox();
        button_box.setAlignment(Pos.CENTER);
        button_box.setSpacing(50);

        play_button = new Button();
        play_button.setText("PLAY");

        help_button = new Button();
        help_button.setText("HELP");

        quit_button = new Button();
        quit_button.setText("QUIT");


        button_box.getChildren().addAll(quit_button, help_button, play_button);
        menu_vbox.getChildren().addAll(title_label, descritption_label, button_box);

        menu_scene = new Scene(menu_vbox);

    }

    /**
     * Sets up the actions for the buttons.
     */
    public void buttonActionSetup(Stage window, Scene scene){
        this.game_scene = scene;
        this.window = window;
        play_button.setOnAction(actionEvent -> onPlayButtonClick());
    }

    public void onPlayButtonClick(){
        window.setScene(game_scene);
    }
}
