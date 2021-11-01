package util;

import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;

public class Car extends Rectangle {
    private String image;

    public Car(String image, double x, double y, double sizeX, double sizeY) {
        super(x, y, sizeX, sizeY);
        this.image = image;
        graphicSetup();
    }

    private void graphicSetup(){
        Image car_image = new Image(this.image);
        ImagePattern car_pattern = new ImagePattern(car_image);
        this.setFill(car_pattern);
    }
}
