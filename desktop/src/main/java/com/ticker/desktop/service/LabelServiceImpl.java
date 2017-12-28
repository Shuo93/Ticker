package com.ticker.desktop.service;

import com.ticker.common.model.Label;
import com.ticker.common.service.Calculator;
import com.ticker.common.util.DataLoader;
import com.ticker.desktop.model.ChoiceBoxItem;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;


public class LabelServiceImpl implements LabelService {

    private Label label = DataLoader.getInstance().getProductInfo().getLabel();
    @Override
    public ObservableList<ChoiceBoxItem> getTypeList() {
        Locale locale = Locale.getDefault();
        ResourceBundle bundle = ResourceBundle.getBundle("properties.message", locale);
        Label.Menu menu = DataLoader.getInstance().getMenu().getLabel();
        List<String> types = menu.getType();
        ObservableList<ChoiceBoxItem> typeList = FXCollections.observableArrayList();
        types.stream().map(type -> {
            String name = bundle.getString(type);
            double price = label.getPrice().get(type);
            String unit = label.getUnit();
            String display = name + " " + String.valueOf(price) + bundle.getString(unit);
            return new ChoiceBoxItem(type, display, price);
        }).forEach(typeList::add);
        return typeList;
    }

    @Override
    public double calculate(Calculator calculator) {
        return calculator.calculate();
    }
}
