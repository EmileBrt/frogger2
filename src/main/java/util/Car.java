package util;

import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;

/**
 * This class represents the cars that must be avoided by the player.
 */
public class Car extends GameElement {
    private String image;

    /**
     * Constructor
     * @param image Path to image file
     * @param x first initial coordinate
     * @param y second initial coordinate
     * @param sizeX size along the X axis
     * @param sizeY size along the Y axis
     */
    public Car(String image, double x, double y, double sizeX, double sizeY) {
        super(x, y, sizeX, sizeY, image);
        this.image = image;
    }

}
