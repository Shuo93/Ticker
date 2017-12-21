package com.ticker.desktop.service;

import com.ticker.common.model.Label;
import com.ticker.common.util.DataLoader;
import com.ticker.desktop.model.ChoiceBoxItem;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;


public class LabelServiceImpl implements LabelService {
    @Override
    public ObservableList<ChoiceBoxItem> getTypeList() {
        Locale locale = Locale.getDefault();
        ResourceBundle bundle = ResourceBundle.getBundle("properties.message", locale);
        Label.Menu menu = DataLoader.getInstance().getMenu().getLabel();
        List<String> types = menu.getType();
        ObservableList<ChoiceBoxItem> typeList = FXCollections.observableArrayList();
        types.stream().map(type -> {
            String name = bundle.getString(type);
            double price = DataLoader.getInstance().getProductInfo().getLabel().getPrice().get(type);
            return new ChoiceBoxItem(type, name, price);
        }).forEach(typeList::add);
        return typeList;
    }
}
