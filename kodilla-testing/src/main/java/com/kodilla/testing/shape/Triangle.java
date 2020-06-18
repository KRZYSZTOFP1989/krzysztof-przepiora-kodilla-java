package com.kodilla.testing.shape;

public class Triangle implements Shape {

    private double lengthA;
    private double lengthB;
    private double lengthC;

    public Triangle(double lengthA, double lengthB, double lengthC) {
        this.lengthA = lengthA;
        this.lengthB = lengthB;
        this.lengthC = lengthC;
    }

    @Override
    public String getShapeName() {
        return "Triangle";
    }

    @Override
    public double getField() {
        return  Math.sqrt((lengthA + lengthB + lengthC)*(lengthA + lengthB - lengthC)*(lengthA - lengthB + lengthC)*(-lengthA + lengthB + lengthC) / 4);
    }

}