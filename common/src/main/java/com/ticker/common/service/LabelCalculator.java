package com.ticker.common.service;

import com.ticker.common.model.Label;
import com.ticker.common.util.DataLoader;

public class LabelCalculator extends AbstractCalculator {

    private final Label label = DataLoader.getInstance().getProductInfo().getLabel();

    private String type;
    private double area;
    private double scale;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public double getScale() {
        return scale;
    }

    public void setScale(double scale) {
        this.scale = scale;
    }

    @Override
    public double calculate() {
        double typePrice = label.getPrice().get(type);
        double price = typePrice * area * scale;
        return price;
    }
}
