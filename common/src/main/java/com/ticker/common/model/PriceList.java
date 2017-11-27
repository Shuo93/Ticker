package com.ticker.common.model;

import java.util.Map;

public class PriceList {

    private Map<String, Map<String, Map<String, Double>>> price;
    private String unit;

    public Map<String, Map<String, Map<String, Double>>> getPrice() {
        return price;
    }

    public void setPrice(Map<String, Map<String, Map<String, Double>>> price) {
        this.price = price;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }
}
