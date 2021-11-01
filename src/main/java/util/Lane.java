package util;

import javafx.scene.shape.Rectangle;
import java.util.ArrayList;

/**
 * Cette classe correspond aux voies de la route.
 *
 * @author Corentin GOETGHEBEUR
 * @version 1.0
 */
public class Lane extends Rectangle {
    private String image;
    private int speed;
    private double density; // number between 0 and 1
    private Direction direction;
    private int length;
    public ArrayList<Rectangle> cars = new ArrayList<>();
    public int lane_type; // type de voie (0: safe, 1: voie)



    /**
     * Constructeur de la classe Lane.
     *
     * @param speed     Vitesse de circulation des voitures sur cette voie.
     * @param density   Probabilite d'apparition d'une voiture sur cette voie.
     * @param direction Sens de circulation sur cette voie (Direction.left ou Direction.right).
     * @param length    longueur de la voie.
     * @since 1.0
     */
    public Lane(double x, double y, double weight, double height, int speed, double density, Direction direction, int length,int lane_type) {
        super(x, y, weight, height);
        this.speed = speed;
        this.density = density;
        this.setDirection(direction);
        this.length = length;
        this.lane_type = lane_type;
        carsSetup();
    }

    /**
     * Sets up the cars in the lane.
     */
    public void carsSetup(){
        if (lane_type != 0) {
            for (int j = 0; j < 12; j++) {
                if (Math.random() < density) {
                    cars.add(new Rectangle(100 * j, getY()+2, 95, 45));
                }
            }
        }
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public ArrayList<Rectangle> getCars() {
        return cars;
    }

    public void setCars(ArrayList<Rectangle> cars) {
        this.cars = cars;
    }

    public int getLane_type() {
        return lane_type;
    }

    public void setLane_type(int lane_type) {
        this.lane_type = lane_type;
    }

    /**
     * Retourne la vitesse de circulation sur cette voie.
     *
     * @return speed
     * @since 1.0
     */
    public int getSpeed() {
        return speed;
    }

    /**
     * Met a jour la vitesse de circulation sur cette voie.
     *
     * @param speed vitesse
     * @since 1.0
     */
    public void setSpeed(int speed) {
        this.speed = speed;
    }

    /**
     * Retourne la probabilité d'apparition d'une voiture sur cette voie.
     *
     * @return density
     * @since 1.0
     */
    public double getDensity() {
        return density;
    }

    /**
     * Met a jour la probabilite d'apparition d'une voiture sur cette voie.
     *
     * @param density probabilite
     * @since 1.0
     */
    public void setDensity(double density) {
        this.density = density;
    }

    /**
     * Retourne la direction de circulation sur cette voie.
     *
     * @return direction
     * @since 1.0
     */
    public Direction getDirection() {
        return direction;
    }

    /**
     * Met a jour le sens de circulation des voitures sur la voie.
     *
     * @param direction sens de circulation
     * @throws IllegalArgumentException La direction fournie pour la voie est incompatible (Direction.up ou Direction.down)
     * @since 1.0
     */
    public void setDirection(Direction direction) {
        if (direction == Direction.down || direction == Direction.up) {
            throw (new IllegalArgumentException("Impossible de creer une voie dans cette direction"));
        } else {
            this.direction = direction;
        }
    }

    /**
     * Vérifier que la grenouille n'est pas entrée en collision sur cette voie
     *
     * @param frog
     * @throws boolean true si collision sinon false
     * @since 1.0
     */

    public boolean intersect(Rectangle frog) {
        boolean collision = false;
        for (int i = 0; i < this.cars.size(); i++) {
            Rectangle rec = new Rectangle(this.cars.get(i).getX()+this.cars.get(i).getTranslateX(), this.cars.get(i).getY()+this.cars.get(i).getTranslateY(), this.cars.get(i).getWidth(), this.cars.get(i).getHeight());
            if (rec.intersects(frog.getX()+frog.getTranslateX(), frog.getY()+frog.getTranslateY(), frog.getWidth(), frog.getHeight()) == true) {
                collision = true;
            }
        }
        return collision;
    }

    public boolean out(){
        boolean oufofmap = false;
        for(int i = 0; i< this.cars.size(); i++){
            if((this.cars.get(i).getX()+this.cars.get(i).getTranslateX())> 1200){
                oufofmap = true;
            }
        }
        return oufofmap;
    }

    public void update(){
        for(int i = 0; i< this.cars.size(); i++){
            if((this.cars.get(i).getX()+this.cars.get(i).getTranslateX())> 1200){
                this.cars.remove(i);
                this.cars.add(new Rectangle(0, getY()+2, 95, 45));
            }
        }
    }
}

