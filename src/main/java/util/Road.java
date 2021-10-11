package util;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import java.util.ArrayList;

/**
 * Cette classe correspond à la route.
 *
 * @author Corentin GOETGHEBEUR
 * @version 1.0
 */
public class Road {
    public int nbLanes = 12;
    public int length;
    public ArrayList<Lane> lanes = new ArrayList<Lane>();

    public Road() {
        for(int i=0;i<this.nbLanes-1;i++){
            lanes.add(new Lane(0,i*50,1200,49,1,0.25,Direction.left,600,1));
            }
        lanes.add(new Lane(0,11*50,1200,49,1,0.25,Direction.left,600,0));
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
                end_collision = true;
            }
        }
        return end_collision;
    }
}
