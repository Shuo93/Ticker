package com.ticker.common.service;

import com.ticker.common.model.Book;
import com.ticker.common.util.DataLoader;

public class BookCalculator extends AbstractCalculator {

    private final Book label = DataLoader.getInstance().getProductInfo().getBook();

    private String area;
    private int pageNum;
    private int bookNum;
    private String size;
    private String material;
    private String weight;
    private int print;
    private int laminate;
    private int bind;
    private String bindType;
    private double scale;

    public void setArea(String area) {
        this.area = area;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public void setBookNum(int bookNum) {
        this.bookNum = bookNum;
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

    public void setLaminate(int laminate) {
        this.laminate = laminate;
    }

    public void setBind(int bind) {
        this.bind = bind;
    }

    public void setBindType(String bindType) {
        this.bindType = bindType;
    }

    public void setScale(double scale) {
        this.scale = scale;
    }

    @Override
    public double calculate() {
        return 0;
    }
}
