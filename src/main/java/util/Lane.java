package util;


import java.lang.reflect.Array;
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
    private ArrayList<Case> cases;

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
        this.cases = this.init_cases();

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
     * Retourne la liste des cases de la voie.
     * @return cases
     * @since 1.0
     */
    public ArrayList<Case> getCases() {
        return cases;
    }

    /**
     * Methode de creation de la liste des cases pour la voie.
     * @since 1.0
     */
    public ArrayList<Case> init_cases(){
        ArrayList<Case> cases = new ArrayList<>();
        for(int i = 0; i < this.length; i++){
            Case new_case = new Case();
            cases.add(new_case);

        }
        return cases;
    }

    @Override
    public String toString() {
        String s = "";
        for(int i = 0; i < this.length; i++){
            s += this.cases.get(i).toString();
        }

        switch(this.direction){
            case left:
                s = "<-" + s;
                break;
            case right:
                s += "->";
        }
        return s;
    }

    /**
     * Methode d'execution des tests de la classe Lane.
     * @param args args
     * @since 1.0
     */
    public static void main(String[] args) {
        int length = 10;
        int speed = 2;
        int density = 5;

        Lane lane = new Lane(speed, density, Direction.left, length);
        System.out.println(lane.getCases());
        System.out.println(lane);
    }
}
