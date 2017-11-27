package com.ticker.desktop.service;

import com.ticker.desktop.model.ChoiceBoxItem;
import com.ticker.desktop.model.enums.Type;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.Locale;
import java.util.ResourceBundle;

public class HomeServiceImpl implements HomeService {
    @Override
    public ObservableList<ChoiceBoxItem> getTypeList() {
        ObservableList<ChoiceBoxItem> list = FXCollections.observableArrayList();
        Locale locale = Locale.getDefault();
        ResourceBundle bundle = ResourceBundle.getBundle("properties.message", locale);
        list.add(new ChoiceBoxItem(Type.BOX.toString(), bundle.getString(Type.BOX.toString()), Type.BOX));
        list.add(new ChoiceBoxItem(Type.POCKET.toString(), bundle.getString(Type.POCKET.toString()), Type.POCKET));
        list.add(new ChoiceBoxItem(Type.BOOK.toString(), bundle.getString(Type.BOOK.toString()), Type.BOOK));
        list.add(new ChoiceBoxItem(Type.LABEL.toString(), bundle.getString(Type.LABEL.toString()), Type.LABEL));
        return list;
    }
}
