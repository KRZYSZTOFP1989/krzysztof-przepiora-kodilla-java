package com.kodilla.testing.shape;

public class Square implements Shape {

    private double a;

    @Override
    public String getShapeName() {
        return "Square";
    }

    @Override
    public double getField() {
        return Math.pow(a, 2);
    }

}
