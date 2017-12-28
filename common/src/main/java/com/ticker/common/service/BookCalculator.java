package com.ticker.common.service;

import com.ticker.common.model.Book;
import com.ticker.common.util.DataLoader;

public class BookCalculator extends AbstractCalculator {

    private final Book book = DataLoader.getInstance().getProductInfo().getBook();

    private String k;
    private int pageNum;
    private int bookNum;
    private String size;
    private String material;
    private String weight;
    private boolean print;
    private boolean laminate;
    private boolean bind;
    private String bindType;
    private String bindKey;
    private double scale;

    public void setK(String k) {
        this.k = k;
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

    public void setPrint(boolean print) {
        this.print = print;
    }

    public void setLaminate(boolean laminate) {
        this.laminate = laminate;
    }

    public void setBind(boolean bind) {
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
        double page = pageNum * bookNum / Double.parseDouble(k.substring(0, k.length() - 1));
        double area = 0;
        if (size.equals("big")) {
            area = page * (book.getBigSize().getLength() / 1000 * book.getBigSize().getWidth() / 1000);
        } else if (size.equals("small")) {
            area = page * (book.getSmallSize().getLength() / 1000 * book.getSmallSize().getWidth() / 1000);
        }
        double basePrice = book.getPriceList().getPrice().get(size).get(material).get(weight) * page;
        double processPrice = (laminate ? book.getProcess().getLaminate().getPrice() * area : 0)
                + (print ? book.getProcess().getPrint().getPrice() * page : 0);
        double bindPrice = 0;
        if (bind) {
            double threshold = 0;
            if (bindType.equals("fold")) {
                bindPrice = book.getBind().getFold().getList().get(bindKey) * bookNum;
                threshold = book.getBind().getFold().getThreshold();

            } else if (bindType.equals("staple")) {
                bindPrice = book.getBind().getStaple().getList().get(bindKey) * pageNum * bookNum;
                threshold = book.getBind().getStaple().getThreshold();
            } else if (bindType.equals("glue")) {
                bindPrice = book.getBind().getGlue().getList().get(bindKey) * bookNum;
                threshold = book.getBind().getGlue().getThreshold();
            }
            bindPrice = (bindPrice > threshold) ? bindPrice : threshold;
        }
        double result = (basePrice + processPrice + bindPrice) * scale;
        return result;
    }

    public void setBindKey(String bindKey) {
        this.bindKey = bindKey;
    }
}
