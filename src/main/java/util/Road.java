package util;

import javafx.scene.shape.Rectangle;

import java.util.ArrayList;

/**
 * Cette classe correspond à la route.
 *
 * @author Corentin GOETGHEBEUR
 * @version 1.0
 */
public class Road {
    private int nbLanes;
    private int length;
    private ArrayList<Lane> lanes;

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
                end_collision = true;
            }
        }
        return end_collision;
    }

}
