package game.frogger2;

import javafx.application.Application;
import javafx.geometry.Insets;
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
    public Application app;

    private VBox menu_vbox;
    private Label title_label;
    private Label description_label;
    private HBox button_box;
    private Button play_button, help_button, quit_button;


    public Menu() throws IOException {
        SceneSetup();

    }

    private void SceneSetup() throws IOException {

        // vbox setup
        menu_vbox = new VBox();
        menu_vbox.setPrefHeight(400);
        menu_vbox.setPrefWidth(600);
        menu_vbox.setSpacing(20);
        menu_vbox.setAlignment(Pos.CENTER);
        Insets menu_inset = new Insets(0, 20, 0, 20);
        menu_vbox.setPadding(menu_inset);

        //title setup
        title_label = new Label();
        title_label.setText("Frogger");
        Font title_font = new Font("Impact", 70);
        title_label.setFont(title_font);

        //description setup
        description_label = new Label();
        description_label.setText("Press play to start !");
        Font description_font = new Font(16);
        description_label.setFont(description_font);
        description_label.setWrapText(true);

        //button hbox setup
        button_box = new HBox();
        button_box.setAlignment(Pos.CENTER);
        button_box.setSpacing(50);

        //buttons setup
        play_button = new Button();
        play_button.setText("PLAY");

        help_button = new Button();
        help_button.setText("HELP");

        quit_button = new Button();
        quit_button.setText("QUIT");


        button_box.getChildren().addAll(quit_button, help_button, play_button);
        menu_vbox.getChildren().addAll(title_label, description_label, button_box);

        menu_scene = new Scene(menu_vbox);

    }

    /**
     * Sets up the actions for the buttons.
     */
    public void buttonActionSetup(Stage window, Scene scene, Application exec){
        this.game_scene = scene;
        this.window = window;
        this.app = exec;

        play_button.setOnAction(actionEvent -> onPlayButtonClick());
        help_button.setOnAction(actionEvent -> onHelpButtonClick());
        quit_button.setOnAction(actionEvent -> {
            try {
                onQuitButtonClick();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }


    /**
     * Méthode appelée en cas d'appui sur le bouton Play
     */
    public void onPlayButtonClick(){
        window.setScene(game_scene);
    }

    /**
     * Méthode appelée en cas d'appui sur le bouton quit.
     * @throws Exception
     */
    public void onQuitButtonClick() throws Exception {
        window.close();
        app.stop();
    }

    /**
     * Méthode appelée en cas d'appui sur le bouton Help.
     */
    public void onHelpButtonClick(){
        description_label.setText("After pressing play, you can move the frog using ZQSD on your keyboard. " +
                "(This version is made for AZERTY keyboards).\n" +
                "Try not to get hit by the cars !");
    }
}
