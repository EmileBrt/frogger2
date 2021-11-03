package game.frogger2;

import javafx.event.Event;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import util.ControlKeys;
import util.Controls;
import util.Frog;
import util.Road;

/**
 * This class represents the game.
 */
public class Game {
    public Event winEvent, loseEvent;
    public boolean running;
    public int level;
    public Road road;
    public Controls controls;
    public Frog frog;

    public Scene gameScene;

    /**
     * Constructor
     */
    public Game(Event winEvent, Event loseEvent) {
        this.winEvent = winEvent;
        this.loseEvent = loseEvent;
        setupGame();
        setupScene();
    }

    /**
     * Sets up game elements ( creates objects ...)
     */
    private void setupGame(){
        road = new Road(winEvent, loseEvent);
        road.setGame(this);
        controls = new Controls(ControlKeys.ZQSD);
        frog = new Frog("file:src/main/java/image/frogg.png", 550, 555, 40.0d, 40.0d);
    }

    /**
     * Sets up the scene.
     */
    private void setupScene(){
        BorderPane root = new BorderPane();
        //Creating a scene object
        gameScene = new Scene(root, 1200, 600);
        gameScene.setFill(Color.BLACK);

        // add lanes and cars to root
        for(int i=0;i< road.lanes.size();i++){
            root.getChildren().add(road.lanes.get(i));
            for(int j = 0; j<road.lanes.get(i).cars.size(); j++){root.getChildren().add(road.lanes.get(i).cars.get(j));}
        }
        root.getChildren().add(frog);
    }
}
