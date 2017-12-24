package com.ticker.common.service;

import com.ticker.common.model.Box;
import com.ticker.common.util.DataLoader;

public class BoxCalculator extends AbstractCalculator {

    private final Box box = DataLoader.getInstance().getProductInfo().getBox();

    private Area area;
    private int number;
    private int emboss;
    private String size;
    private String material;
    private String weight;
    private int print;
    private int corrugate;
    private int laminate;
    private int gold;
    private double goldArea;
    private String goldSize;
    private int uv;
    private double uvArea;
    private String uvSize;
    private double scale;

    public void setArea(Area area) {
        this.area = area;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setEmboss(int emboss) {
        this.emboss = emboss;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public void setPrint(int print) {
        this.print = print;
    }

    public void setCorrugate(int corrugate) {
        this.corrugate = corrugate;
    }

    public void setLaminate(int laminate) {
        this.laminate = laminate;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    public void setGoldArea(double goldArea) {
        this.goldArea = goldArea;
    }

    public void setGoldSize(String goldSize) {
        this.goldSize = goldSize;
    }

    public void setUv(int uv) {
        this.uv = uv;
    }

    public void setUvArea(double uvArea) {
        this.uvArea = uvArea;
    }

    public void setUvSize(String uvSize) {
        this.uvSize = uvSize;
    }

    public void setScale(double scale) {
        this.scale = scale;
    }

    @Override
    public double calculate() {
        double area = calculateArea();

        double result =0;
        return 0;
    }

    public double calculateArea() {
        return area.boxArea();
    }

    public Area getArea() {
        return area;
    }
}
