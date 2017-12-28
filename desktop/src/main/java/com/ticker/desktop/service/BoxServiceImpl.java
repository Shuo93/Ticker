package com.ticker.desktop.service;

import com.ticker.common.model.Box;
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
            String display = "";
            if (size.equals("big")) {
                double price = box.getProcess().getGold().getBig().getPrice();
                String unit = box.getProcess().getGold().getBig().getUnit();
                display = name + " " + String.valueOf(price) + bundle.getString(unit);
            } else if (size.equals("small")) {
                double price = box.getProcess().getGold().getSmall().getPrice();
                String unit = box.getProcess().getGold().getSmall().getUnit();
                double priceEx = box.getProcess().getGold().getExtra().getPrice();
                String unitEx = box.getProcess().getGold().getExtra().getUnit();
                display = name + " " + String.valueOf(price) + bundle.getString(unit) + " "
                        + bundle.getString("extra") + " " + String.valueOf(priceEx)
                        + bundle.getString(unitEx);
            }

            return new ChoiceBoxItem(size, display, null);
        }).forEach(sizeList::add);
        return sizeList;
    }

    @Override
    public ObservableList<ChoiceBoxItem> getUvList() {
        List<String> list = menu.getUv();
        ObservableList<ChoiceBoxItem> uvList = FXCollections.observableArrayList();
        list.stream().map(uv -> {
            String name = bundle.getString(uv);
            double price = 0.0;
            String unit = "";
            String display = "";
            if (uv.equals("big")) {
                price = box.getProcess().getUv().getBig().getPrice();
                unit = box.getProcess().getUv().getBig().getUnit();
            } else if (uv.equals("small")) {
                price = box.getProcess().getUv().getSmall().getPrice();
                unit = box.getProcess().getUv().getSmall().getUnit();
            }
            display = name + " " + String.valueOf(price) + bundle.getString(unit);
            return new ChoiceBoxItem(uv, display, null);
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
        int threshold = box.getProcess().getUv().getThreshold();
        String display = bundle.getString("start")
                + String.valueOf(threshold)
                + bundle.getString("yuan");
        CheckBoxItem item = new CheckBoxItem(id, display, null, false);
        return item;
    }

    @Override
    public double calculate(Calculator calculator) {
        return calculator.calculate();
    }
}
