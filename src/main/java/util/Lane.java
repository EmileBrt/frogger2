package util;

import javafx.scene.shape.Rectangle;
import java.util.ArrayList;

/**
 * Cette classe correspond aux voies de la route.
 *
 * @author Corentin GOETGHEBEUR
 * @version 1.0
 */
public class Lane {
    private int speed;
    private int density;
    private Direction direction;
    private int length;
    public ArrayList<Rectangle> cars;

    /**
     * Constructeur de la classe Lane.
     * @param speed  Vitesse de circulation des voitures sur cette voie.
     * @param density Probabilite d'apparition d'une voiture sur cette voie.
     * @param direction Sens de circulation sur cette voie (Direction.left ou Direction.right).
     * @param length longueur de la voie.
     * @since 1.0
     */
    public Lane(int speed, int density, Direction direction, int length) {
        this.speed = speed;
        this.density = density;
        this.setDirection(direction);
        this.length = length;

    }

    /**
     * Retourne la vitesse de circulation sur cette voie.
     * @return speed
     * @since 1.0
     */
    public int getSpeed() {
        return speed;
    }

    /**
     * Met a jour la vitesse de circulation sur cette voie.
     * @param speed vitesse
     * @since 1.0
     */
    public void setSpeed(int speed) {
        this.speed = speed;
    }

    /**
     * Retourne la probabilité d'apparition d'une voiture sur cette voie.
     * @return density
     * @since 1.0
     */
    public int getDensity() {
        return density;
    }

    /**
     * Met a jour la probabilite d'apparition d'une voiture sur cette voie.
     * @param density probabilite
     * @since 1.0
     */
    public void setDensity(int density) {
        this.density = density;
    }

    /**
     * Retourne la direction de circulation sur cette voie.
     * @return direction
     * @since 1.0
     */
    public Direction getDirection() {
        return direction;
    }

    /**
     * Met a jour le sens de circulation des voitures sur la voie.
     * @param direction sens de circulation
     * @throws IllegalArgumentException La direction fournie pour la voie est incompatible (Direction.up ou Direction.down)
     * @since 1.0
     */
    public void setDirection(Direction direction) {
        if(direction == Direction.down || direction == Direction.up){
            throw(new IllegalArgumentException("Impossible de creer une voie dans cette direction"));
        }else {
            this.direction = direction;
        }
    }

    /**
     * Vérifier que la grenouille n'est pas entrée en collision sur cette voie
     * @param  frog
     * @throws boolean true si collision sinon false
     * @since 1.0
     */
    public boolean intersect(Rectangle frog){
        boolean collision = false;
        for(int i=0 ; i< this.cars.size(); i++){
            if (this.cars.get(i).intersects(frog.getX(),frog.getY(),frog.getWidth(),frog.getHeight()) == true){
                collision = true;
            }
        }
        return collision;
    }



}
