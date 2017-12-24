package com.ticker.common.service;

public class PocketCalculator extends BoxCalculator {
    @Override
    public double calculateArea() {
        return getArea().pocketArea();
    }
}
