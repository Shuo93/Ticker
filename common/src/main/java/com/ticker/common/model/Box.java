package com.ticker.common.model;

import java.util.List;

public class Box extends AbstractBox {

    private Price knife;
    private Size bigSize;
    private Size smallSize;
    private PriceList priceList;
    private Process process;
    private double scale;

    public Price getKnife() {
        return knife;
    }

    public void setKnife(Price knife) {
        this.knife = knife;
    }

    public PriceList getPriceList() {
        return priceList;
    }

    public void setPriceList(PriceList priceList) {
        this.priceList = priceList;
    }

    public Process getProcess() {
        return process;
    }

    public void setProcess(Process process) {
        this.process = process;
    }

    public Size getBigSize() {
        return bigSize;
    }

    public void setBigSize(Size bigSize) {
        this.bigSize = bigSize;
    }

    public Size getSmallSize() {
        return smallSize;
    }

    public void setSmallSize(Size smallSize) {
        this.smallSize = smallSize;
    }

    public double getScale() {
        return scale;
    }

    public void setScale(double scale) {
        this.scale = scale;
    }

    public static class Process {
        private Price emboss;
        private Price print;
        private Price corrugate;
        private Price laminate;
        private Gold gold;
        private Uv uv;

        public Price getEmboss() {
            return emboss;
        }

        public void setEmboss(Price emboss) {
            this.emboss = emboss;
        }

        public Price getPrint() {
            return print;
        }

        public void setPrint(Price print) {
            this.print = print;
        }

        public Price getCorrugate() {
            return corrugate;
        }

        public void setCorrugate(Price corrugate) {
            this.corrugate = corrugate;
        }

        public Price getLaminate() {
            return laminate;
        }

        public void setLaminate(Price laminate) {
            this.laminate = laminate;
        }

        public Gold getGold() {
            return gold;
        }

        public void setGold(Gold gold) {
            this.gold = gold;
        }

        public Uv getUv() {
            return uv;
        }

        public void setUv(Uv uv) {
            this.uv = uv;
        }
    }

    public static class Gold {
        private Price big;
        private Price small;
        private Price extra;

        public Price getBig() {
            return big;
        }

        public void setBig(Price big) {
            this.big = big;
        }

        public Price getSmall() {
            return small;
        }

        public void setSmall(Price small) {
            this.small = small;
        }

        public Price getExtra() {
            return extra;
        }

        public void setExtra(Price extra) {
            this.extra = extra;
        }
    }

    public static class Uv {
        private Price big;
        private Price small;
        private int threshold;

        public Price getBig() {
            return big;
        }

        public void setBig(Price big) {
            this.big = big;
        }

        public Price getSmall() {
            return small;
        }

        public void setSmall(Price small) {
            this.small = small;
        }

        public int getThreshold() {
            return threshold;
        }

        public void setThreshold(int threshold) {
            this.threshold = threshold;
        }
    }

    public static class Menu {
        private List<String> size;
        private List<String> material;
        private List<String> weight;
        private List<String> gold;
        private List<String> uv;

        public List<String> getSize() {
            return size;
        }

        public void setSize(List<String> size) {
            this.size = size;
        }

        public List<String> getMaterial() {
            return material;
        }

        public void setMaterial(List<String> material) {
            this.material = material;
        }

        public List<String> getWeight() {
            return weight;
        }

        public void setWeight(List<String> weight) {
            this.weight = weight;
        }

        public List<String> getGold() {
            return gold;
        }

        public void setGold(List<String> gold) {
            this.gold = gold;
        }

        public List<String> getUv() {
            return uv;
        }

        public void setUv(List<String> uv) {
            this.uv = uv;
        }
    }

}
