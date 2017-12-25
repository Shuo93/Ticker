package com.ticker.common.service;

import com.ticker.common.model.Box;
import com.ticker.common.util.DataLoader;

public class BoxCalculator extends AbstractCalculator {

    private final Box box = DataLoader.getInstance().getProductInfo().getBox();

    private Area area;
    private int number;
    private boolean emboss;
    private String size;
    private String material;
    private String weight;
    private boolean print;
    private boolean corrugate;
    private boolean laminate;
    private boolean gold;
    private double goldArea;
    private String goldSize;
    private boolean uv;
    private double uvArea;
    private String uvSize;
    private double scale;

    public void setArea(Area area) {
        this.area = area;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setEmboss(boolean emboss) {
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

    public void setPrint(boolean print) {
        this.print = print;
    }

    public void setCorrugate(boolean corrugate) {
        this.corrugate = corrugate;
    }

    public void setLaminate(boolean laminate) {
        this.laminate = laminate;
    }

    public void setGold(boolean gold) {
        this.gold = gold;
    }

    public void setGoldArea(double goldArea) {
        this.goldArea = goldArea;
    }

    public void setGoldSize(String goldSize) {
        this.goldSize = goldSize;
    }

    public void setUv(boolean uv) {
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
        double page = 0;
        if (size.equals("small")) {
            page = area * 10 * 10 / (box.getSmallSize().getLength() * box.getSmallSize().getWidth());
        } else if (size.equals("big")) {
            page = area * 10 * 10 / (box.getBigSize().getLength() * box.getBigSize().getWidth());
        }
        area /= 10000;
        double fixPrice = box.getKnife().getPrice();
        double basePrice = box.getPriceList().getPrice().get(size).get(material).get(weight) * page * number;
        double processPrice = (print ? box.getProcess().getPrint().getPrice() * page * number : 0)
                + (emboss ? box.getProcess().getEmboss().getPrice() *  number : 0)
                + (corrugate ? box.getProcess().getCorrugate().getPrice() * area * number : 0)
                + (laminate ? box.getProcess().getLaminate().getPrice() * area * number : 0);

        double goldPrice = gold ? ((goldSize.equals("big") ? 1 : 0)
                * box.getProcess().getGold().getBig().getPrice() * goldArea * number
                + (goldSize.equals("small") ? 1 : 0)
                * (box.getProcess().getGold().getSmall().getPrice() * goldArea / 10000 * number
                + box.getProcess().getGold().getExtra().getPrice() * page)) : 0;

        double uvPrice = uv ? ((uvSize.equals("big") ? 1 : 0)
                * box.getProcess().getUv().getBig().getPrice() * uvArea / 10000 * number
                + (uvSize.equals("small") ? 1 : 0)
                * box.getProcess().getUv().getSmall().getPrice() * page) : 0;
        uvPrice = (uvPrice != 0)
                ? (uvPrice > 300 ? uvPrice : 300)
                : 0;

        double result = (fixPrice + basePrice + processPrice + goldPrice + uvPrice) * scale;
        return result;
    }

    public double calculateArea() {
        return area.boxArea();
    }

    public Area getArea() {
        return area;
    }
}
