package com.ticker.common.service;

public class Area {
    private double depth;
    private double width;
    private double height;

    public void setDepth(double depth) {
        this.depth = depth;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double boxArea() {
        return (depth * width) * 2
                + (width * height) * 2
                + (depth * height) * 2;
    }

    public double pocketArea() {
        return (depth * width)
                + (width * height) * 2
                + (depth * height) * 2;
    }

    public double getDepth() {
        return depth;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }
}