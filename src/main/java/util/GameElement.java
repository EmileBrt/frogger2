package util;

import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;

/**
 * This is the parent class of the graphical elements in the game.
 */
public class GameElement extends Rectangle {
    private String image;

    /**
     * Constructor
     * @param v X coordinate
     * @param v1 Y coordinate
     * @param v2 X size
     * @param v3 Y size
     * @param image path to image file
     */
    public GameElement(double v, double v1, double v2, double v3, String image) {
        super(v, v1, v2, v3);
        this.image = image;
        graphicSetup();
    }

    /**
     * Sets up the image.
     */
    public void graphicSetup(){
        Image img = new Image(this.image);
        ImagePattern pattern = new ImagePattern(img);
        this.setFill(pattern);
    }
}
