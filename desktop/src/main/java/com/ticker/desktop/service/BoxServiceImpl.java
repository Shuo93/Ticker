package com.ticker.desktop.service;

import com.ticker.common.model.Box;
import com.ticker.common.model.Price;
import com.ticker.common.util.DataLoader;
import com.ticker.desktop.model.CheckBoxItem;
import com.ticker.desktop.model.ChoiceBoxItem;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

public class BoxServiceImpl implements BoxService {

    private ResourceBundle bundle;

    private Box.Menu menu;

    private Box box;

    public BoxServiceImpl() {
        Locale locale = Locale.getDefault();
        bundle = ResourceBundle.getBundle("properties.message", locale);
        menu = DataLoader.getInstance().getMenu().getBox();
        box = DataLoader.getInstance().getProductInfo().getBox();
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
    public ObservableList<ChoiceBoxItem> getGoldList() {
        List<String> list = menu.getGold();
        ObservableList<ChoiceBoxItem> sizeList = FXCollections.observableArrayList();
        list.stream().map(size -> {
            String name = bundle.getString(size);
            return new ChoiceBoxItem(size, name, null);
        }).forEach(sizeList::add);
        return sizeList;
    }

    @Override
    public ObservableList<ChoiceBoxItem> getUvList() {
        List<String> list = menu.getUv();
        ObservableList<ChoiceBoxItem> uvList = FXCollections.observableArrayList();
        list.stream().map(uv -> {
            String name = bundle.getString(uv);
            return new ChoiceBoxItem(uv, name, null);
        }).forEach(uvList::add);
        return uvList;
    }

    @Override
    public CheckBoxItem getKnife() {
        String id = "knife";
        Price price = box.getKnife();
        String text = price.getPrice() + bundle.getString(price.getUnit());
        CheckBoxItem item = new CheckBoxItem(id, text, price, true);
        return item;
    }

    @Override
    public CheckBoxItem getEmboss() {
        String id = "emboss";
        Price price = box.getProcess().getEmboss();
        String text = price.getPrice() + bundle.getString(price.getUnit());
        CheckBoxItem item = new CheckBoxItem(id, text, price, false);
        return item;
    }

    @Override
    public CheckBoxItem getPrint() {
        String id = "print";
        Price price = box.getProcess().getPrint();
        String text = price.getPrice() + bundle.getString(price.getUnit());
        CheckBoxItem item = new CheckBoxItem(id, text, price, false);
        return item;
    }

    @Override
    public CheckBoxItem getCorrugate() {
        String id = "corrugate";
        Price price = box.getProcess().getCorrugate();
        String text = price.getPrice() + bundle.getString(price.getUnit());
        CheckBoxItem item = new CheckBoxItem(id, text, price, false);
        return item;
    }

    @Override
    public CheckBoxItem getLaminate() {
        String id = "laminate";
        Price price = box.getProcess().getLaminate();
        String text = price.getPrice() + bundle.getString(price.getUnit());
        CheckBoxItem item = new CheckBoxItem(id, text, price, false);
        return item;
    }

    @Override
    public CheckBoxItem getGold() {
        String id = "gold";
        CheckBoxItem item = new CheckBoxItem(id, "", null, false);
        return item;
    }

    @Override
    public CheckBoxItem getUv() {
        String id = "uv";
        CheckBoxItem item = new CheckBoxItem(id, "", null, false);
        return item;
    }
}
