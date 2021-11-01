package util;

import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

/**
 * This class represents the frog character controlled by the player.
 */
public class Frog extends Rectangle {
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
        super(x, y, sizeX, sizeY);
        this.image = image;
        this.x = x;
        this.y = y;
        this.sizeX = sizeX;
        this.sizeY = sizeY;
        graphicSetup();
    }

    /**
     * Constructor with only the image specified.
     * @param image
     */
    public Frog(String image) {
        this.image = image;
        this.x = 550;
        this.y = 555;
        this.sizeX = 40.0d;
        this.sizeY = 40.0d;
        graphicSetup();
    }

    /**
     * Sets up the image for the frog.
     */
    private void graphicSetup(){
        Image frog_image = new Image(this.image);
        ImagePattern frog_pattern = new ImagePattern(frog_image);
        this.setFill(frog_pattern);
    }
}
