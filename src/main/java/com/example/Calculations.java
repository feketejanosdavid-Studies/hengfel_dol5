package com.example;

public class Calculations {
    private double height;
    private double radius;
    private double surface;

    public Calculations(double height, double radius, double surface) {
        this.height = height;
        this.radius = radius;
        this.surface = surface;
    }

    public double getHeight() {
        return height;
    }

    public double getRadius() {
        return radius;
    }

    public double getSurface() {
        return surface;
    }
}
