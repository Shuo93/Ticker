package com.ticker.common.model;

import java.util.List;
import java.util.Map;

public class Book extends AbstractProduct {

    private Size bigSize;
    private Size smallSize;
    private PriceList priceList;
    private Process process;
    private Bind bind;

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

    public Bind getBind() {
        return bind;
    }

    public void setBind(Bind bind) {
        this.bind = bind;
    }

    public static final class Process {
        private Price print;
        private Price laminate;

        public Price getPrint() {
            return print;
        }

        public void setPrint(Price print) {
            this.print = print;
        }

        public Price getLaminate() {
            return laminate;
        }

        public void setLaminate(Price laminate) {
            this.laminate = laminate;
        }
    }

    public static final class Bind {

        private BindPrice fold;
        private BindPrice staple;
        private BindPrice glue;

        public BindPrice getFold() {
            return fold;
        }

        public void setFold(BindPrice fold) {
            this.fold = fold;
        }

        public BindPrice getStaple() {
            return staple;
        }

        public void setStaple(BindPrice staple) {
            this.staple = staple;
        }

        public BindPrice getGlue() {
            return glue;
        }

        public void setGlue(BindPrice glue) {
            this.glue = glue;
        }
    }

    public static final class BindPrice {
        private Map<String, Double> list;
        private String unit;
        private int threshold;

        public Map<String, Double> getList() {
            return list;
        }

        public void setList(Map<String, Double> list) {
            this.list = list;
        }

        public String getUnit() {
            return unit;
        }

        public void setUnit(String unit) {
            this.unit = unit;
        }

        public int getThreshold() {
            return threshold;
        }

        public void setThreshold(int threshold) {
            this.threshold = threshold;
        }
    }

    public static class Menu {
        List<String> k;
        List<String> size;
        List<String> material;
        List<String> bind;
        List<String> weight;
        Map<String, List<String>> bindKey;

        public Map<String, List<String>> getBindKey() {
            return bindKey;
        }

        public void setBindKey(Map<String, List<String>> bindKey) {
            this.bindKey = bindKey;
        }

        public List<String> getK() {
            return k;
        }

        public void setK(List<String> k) {
            this.k = k;
        }

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

        public List<String> getBind() {
            return bind;
        }

        public void setBind(List<String> bind) {
            this.bind = bind;
        }

        public List<String> getWeight() {
            return weight;
        }

        public void setWeight(List<String> weight) {
            this.weight = weight;
        }
    }
}
