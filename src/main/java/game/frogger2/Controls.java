package game.frogger2;
import javafx.animation.TranslateTransition;
import javafx.scene.input.KeyEvent;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;
import util.ControlKeys;

import java.security.Key;


/**
 * This class is used to control the movements of the frog.
 */
public class Controls {
    private ControlKeys keyset;

    public Controls(ControlKeys keyset) {
        this.keyset = keyset;
    }

    public ControlKeys getKeyset() {
        return keyset;
    }

    public void setKeyset(ControlKeys keyset) {
        this.keyset = keyset;
    }

    /**
     * Detects key pressed to move the frog.
     * @param e (KeyEvent) Key Pressed
     */
    public void moveFrog(KeyEvent e, Rectangle frog){
        switch (this.getKeyset()){
            case ZQSD:
                this.moveFrog_ZQSD(e, frog);
                break;
            case Arrows:
                this.moveFrog_Arrows(e);
                break;
        }

    }

    /**
     * Moves frog according to the key pressed if the keyset used is ZQSD.
     * @param e key pressed
     */
    private void moveFrog_ZQSD(KeyEvent e, Rectangle frog){
        TranslateTransition transition = new TranslateTransition(Duration.seconds(0.10),frog);
        switch (e.getCode()){
            case Q :
                System.out.println("LEFT");
                frog.setRotate(270);
                transition.setByX(-50);
                transition.play();
                System.out.println("X:"+(frog.getX()+frog.getTranslateX())+"Y:"+(frog.getY()+frog.getTranslateY()));
                break;
            case D:
                System.out.println("RIGHT");
                frog.setRotate(90);
                transition.setByX(+50);
                transition.play();
                frog.localToParentTransformProperty();
                System.out.println("X:"+(frog.getX()+frog.getTranslateX())+"Y:"+(frog.getY()+frog.getTranslateY()));
                break;
            case S :
                System.out.println("DOWN");
                frog.setRotate(180);
                transition.setByY(+50);
                transition.play();
                System.out.println("X:"+(frog.getX()+frog.getTranslateX())+"Y:"+(frog.getY()+frog.getTranslateY()));
                break;
            case Z:
                System.out.println("UP");
                frog.setRotate(0);
                transition.setByY(-50);
                transition.play();
                System.out.println("X:"+(frog.getX()+frog.getTranslateX())+"Y:"+(frog.getY()+frog.getTranslateY()));
                break;
        }
    }

    /**
     * Moves frog according to the key pressed if the keyset is arrows
     * @param e key pressed
     */
    private void moveFrog_Arrows(KeyEvent e){

    }
}
