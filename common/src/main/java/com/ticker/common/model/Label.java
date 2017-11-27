package com.ticker.common.model;

import java.util.List;
import java.util.Map;

public class Label extends AbstractProduct {

    private Map<String, Double> price;
    private String unit;
    private double scale;

    public Map<String, Double> getPrice() {
        return price;
    }

    public void setPrice(Map<String, Double> price) {
        this.price = price;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public double getScale() {
        return scale;
    }

    public void setScale(double scale) {
        this.scale = scale;
    }

    public static class Menu {
        private List<String> type;

        public List<String> getType() {
            return type;
        }

        public void setType(List<String> type) {
            this.type = type;
        }
    }
}
