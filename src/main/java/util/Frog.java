package util;

import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

/**
 * This class represents the frog character controlled by the player.
 */
public class Frog extends GameElement {
    private String image;
    private double x, y, sizeX, sizeY;

    /**
     * Contructor with all parameters
     * @param image Path to the image file
     * @param x first initial coordinate
     * @param y second initial coordinate
     * @param sizeX size along the X axis
     * @param sizeY size along the Y axis
     */
    public Frog(String image, double x, double y, double sizeX, double sizeY) {
        super(x, y, sizeX, sizeY, image);
        this.image = image;
        this.x = x;
        this.y = y;
        this.sizeX = sizeX;
        this.sizeY = sizeY;
    }


}
