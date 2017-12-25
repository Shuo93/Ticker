package com.ticker.desktop.service;

import com.ticker.desktop.model.CheckBoxItem;
import com.ticker.desktop.model.ChoiceBoxItem;
import javafx.collections.ObservableList;

public interface BookService extends Service {

    ObservableList<ChoiceBoxItem> getSizeList();

    ObservableList<ChoiceBoxItem> getMaterialList();

    ObservableList<ChoiceBoxItem> getWeightList();

    ObservableList<ChoiceBoxItem> getAreaList();

    ObservableList<ChoiceBoxItem> getBindTypeList();

    CheckBoxItem getPrint();

    CheckBoxItem getLaminate();

    CheckBoxItem getBind();

    ObservableList<ChoiceBoxItem> getBindKey(String id);
}
