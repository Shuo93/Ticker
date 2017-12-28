package com.ticker.desktop.service;

import com.ticker.common.model.Book;
import com.ticker.common.model.Price;
import com.ticker.common.service.Calculator;
import com.ticker.common.util.DataLoader;
import com.ticker.desktop.model.CheckBoxItem;
import com.ticker.desktop.model.ChoiceBoxItem;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

public class BookServiceImpl implements BookService {

    private ResourceBundle bundle;

    private Book.Menu menu;

    private Book book;

    public BookServiceImpl() {
        Locale locale = Locale.getDefault();
        bundle = ResourceBundle.getBundle("properties.message", locale);
        menu = DataLoader.getInstance().getMenu().getBook();
        book = DataLoader.getInstance().getProductInfo().getBook();
    }

    @Override
    public ObservableList<ChoiceBoxItem> getSizeList() {
        List<String> list = menu.getSize();
        ObservableList<ChoiceBoxItem> sizeList = FXCollections.observableArrayList();
        list.stream().map(size -> {
            String name = bundle.getString(size);
            return new ChoiceBoxItem(size, name, null);
        }).forEach(sizeList::add);
        return sizeList;
    }

    @Override
    public ObservableList<ChoiceBoxItem> getMaterialList() {
        List<String> list = menu.getMaterial();
        ObservableList<ChoiceBoxItem> sizeList = FXCollections.observableArrayList();
        list.stream().map(size -> {
            String name = bundle.getString(size);
            return new ChoiceBoxItem(size, name, null);
        }).forEach(sizeList::add);
        return sizeList;
    }

    @Override
    public ObservableList<ChoiceBoxItem> getWeightList() {
        List<String> list = menu.getWeight();
        ObservableList<ChoiceBoxItem> weightList = FXCollections.observableArrayList();
        list.stream().map(weight -> {
            String name = weight.substring(0, weight.length() - 1)
                    + bundle.getString(weight.substring(weight.length() - 1));
            return new ChoiceBoxItem(weight, name, null);
        }).forEach(weightList::add);
        return weightList;
    }

    @Override
    public ObservableList<ChoiceBoxItem> getAreaList() {
        List<String> list = menu.getK();
        ObservableList<ChoiceBoxItem> sizeList = FXCollections.observableArrayList();
        list.stream().map(area -> {
            String name = area.substring(0, area.length() -1)
                    + bundle.getString(area.substring(area.length() - 1));
            return new ChoiceBoxItem(area, name, null);
        }).forEach(sizeList::add);
        return sizeList;
    }

    @Override
    public ObservableList<ChoiceBoxItem> getBindTypeList() {
        List<String> list = menu.getBind();
        ObservableList<ChoiceBoxItem> bindList = FXCollections.observableArrayList();
        list.stream().map(type -> {
            String name = bundle.getString(type);
            int threshold = 0;
            if (type.equals("fold")) {
                threshold = book.getBind().getFold().getThreshold();
            } else if (type.equals("staple")) {
                threshold = book.getBind().getStaple().getThreshold();
            } else if (type.equals("glue")) {
                threshold = book.getBind().getGlue().getThreshold();
            }
            String display = name + " " + bundle.getString("start") + threshold + bundle.getString("yuan");
            return new ChoiceBoxItem(type, display, null);
        }).forEach(bindList::add);
        return bindList;
    }

    @Override
    public CheckBoxItem getPrint() {
        String id = "print";
        Price price = book.getProcess().getPrint();
        String text = price.getPrice() + bundle.getString(price.getUnit());
        CheckBoxItem item = new CheckBoxItem(id, text, price, false);
        return item;
    }

    @Override
    public CheckBoxItem getLaminate() {
        String id = "laminate";
        Price price = book.getProcess().getLaminate();
        String text = price.getPrice() + bundle.getString(price.getUnit());
        CheckBoxItem item = new CheckBoxItem(id, text, price, false);
        return item;
    }

    @Override
    public CheckBoxItem getBind() {
        String id = "bind";
        CheckBoxItem item = new CheckBoxItem(id, "", null, false);
        return item;
    }

    @Override
    public ObservableList<ChoiceBoxItem> getBindKey(String id) {
        List<String> list = menu.getBindKey().get(id);
        ObservableList<ChoiceBoxItem> bindList = FXCollections.observableArrayList();
        list.stream().map(type -> {
            String name = bundle.getString(type);
            double bindPrice = 0.0;
            int threshold = 0;
            String unit = "";
            if (id.equals("fold")) {
                bindPrice = book.getBind().getFold().getList().get(type);
                threshold = book.getBind().getFold().getThreshold();
                unit = book.getBind().getFold().getUnit();
            } else if (id.equals("staple")) {
                bindPrice = book.getBind().getStaple().getList().get(type);
                threshold = book.getBind().getStaple().getThreshold();
                unit = book.getBind().getStaple().getUnit();
            } else if (id.equals("glue")) {
                bindPrice = book.getBind().getGlue().getList().get(type);
                threshold = book.getBind().getGlue().getThreshold();
                unit = book.getBind().getGlue().getUnit();
            }
            String display = name + " " + bindPrice + bundle.getString(unit);
            return new ChoiceBoxItem(type, display, null);
        }).forEach(bindList::add);
        return bindList;
    }

    @Override
    public double calculate(Calculator calculator) {
        return calculator.calculate();
    }
}
