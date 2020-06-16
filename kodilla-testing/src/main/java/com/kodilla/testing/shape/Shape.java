package com.kodilla.testing.shape;

import java.util.ArrayList;
import java.util.List;

public interface Shape {

    String getShapeName();
    double getField();

}

class Square implements Shape {

    public String getShapeName(); {
        return "Square";

    }

    public double getField() {
        return 10;

    }

}

class Circle implements Shape {

    public String getShapeName() {
        return "Circle";

    }

    public int getField() {
        return 15;

    }

}

class Triangle implements Shape {

    public String getShapeName() {
        return "Triangle";

    }

    public double getField() {
        return 12;

    }

}

class ShapeCollector {

    private List<Shape> shapeCollection = new ArrayList<>();

    public List<Shape> getShapeCollection() {
        return shapeCollection;
    }

    public void addFigure(Shape shape) {

    }

    public boolean removeFigure(Shape shape) {

        return false;
    }

    public void getFigure(int n) {

    }

    public void showFigures () {

    }

}