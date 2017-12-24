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
            return new ChoiceBoxItem(type, name, null);
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
    public double calculate(Calculator calculator) {
        return calculator.calculate();
    }
}
