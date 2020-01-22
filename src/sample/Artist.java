package sample;

import javafx.scene.paint.Color;
import javafx.scene.shape.Shape;

public class Artist {
    private Color currentColor;
    private javafx.scene.shape.Shape currentShape;

    public Artist(){

    }

    public Color getCurrentColor() {
        return currentColor;
    }

    public void setCurrentColor(Color currentColor) {
        this.currentColor = currentColor;
    }

    public Shape getCurrentShape() {
        return currentShape;
    }

    public void setCurrentShape(javafx.scene.shape.Shape shape) {
        this.currentShape = currentShape;
    }

}
