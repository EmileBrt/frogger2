package util;

import game.frogger2.Game;
import javafx.event.Event;
import javafx.event.EventType;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import java.util.ArrayList;
import java.util.Random;

/**
 * Cette classe correspond à la route.
 *
 * @author Corentin GOETGHEBEUR
 * @version 1.0
 */
public class Road {

    public Event winEvent, loseEvent;
    public Game game;
    public int nbLanes = 12;
    public int length;
    public ArrayList<Lane> lanes = new ArrayList<Lane>();
    private String image;
    private String road_img1 = "file:src/main/java/image/road1.png";
    private String road_img2 = "file:src/main/java/image/road2.png";

    public Road(Event winEvent, Event loseEvent) {
        this.winEvent = winEvent;
        this.loseEvent = loseEvent;
        laneSetup();
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public void startCars(){
        for(int i=0; i < nbLanes; i++){
            lanes.get(i).startCars();
        }
    }

    /**
     * Adds lanes to the road.
     */
    public void laneSetup(){
        //First lane is safe
        Lane startLane = new Lane(Color.DARKGREEN,0,0*50,1200,49,1,0.25,Direction.left,600,0);
        lanes.add(startLane);

        for (int i = 1; i < nbLanes -1; i++){

            // détermination des paramètres
            String image;
            if (i % 2 == 1){
                image = road_img1;
            }else{
                image = road_img2;
            }
            int x = 0;
            int y = i * 50;
            int width = 1200;
            int height = 49;
            int length = 600;

            Random random = new Random();
            int speed = random.nextInt(100) + 100; // valeur aléatoire entre 100 et 300

            int dir = random.nextInt(2); // 0 ou 1
            Direction direction;
            if (dir == 1){
                direction = Direction.left;
            }else{
                direction = Direction.right;
            }

            int type = random.nextInt(20); // 1 chance sur 20 d'avoir une voie sans voiture
            if (type != 0){
                type = 1;
            }
            float density = random.nextFloat() / 2;
            // instanciation
            Lane lane = new Lane(image, x, y, width, height, speed, density, direction, length, type);
            lanes.add(lane);
        }

        //Last lane is safe
        Lane lastLane = new Lane(Color.DARKGREEN,0,(nbLanes-1)*50,1200,49,1,0.25,Direction.left,600,0);
        lanes.add(lastLane);
    }



    public int getNbLanes() {
        return nbLanes;
    }

    public void setNbLanes(int nbLanes) {
        this.nbLanes = nbLanes;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public ArrayList<Lane> getCases() {
        return lanes;
    }

    public void setCases(ArrayList<Lane> cases) {
        this.lanes = cases;
    }
    /**
     * Vérifier que la grenouille n'est pas entrée en collision sur aucune des voies de la partie
     * @param  frog
     * @throws boolean true si collision sinon false
     * @since 1.0
     */
    public boolean Endgame(Rectangle frog){
        boolean end_collision = false;
        for(int i=0 ; i< this.lanes.size() - 1 ; i++){
            if (this.lanes.get(i).intersect(frog) == true){
                System.out.println("Collision");

                end_collision = true;
            }
        }
        if(end_collision){
            Event.fireEvent(game.gameScene, loseEvent);
        }
        return end_collision;
    }

    public void update(){
        for(int i=0;i<this.lanes.size();i++){
            this.lanes.get(i).update();
        }
    }
}
