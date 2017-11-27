package com.ticker.desktop.service;

import com.ticker.desktop.model.CheckBoxItem;
import com.ticker.desktop.model.ChoiceBoxItem;
import javafx.collections.ObservableList;

public interface BoxService extends Service {

    ObservableList<ChoiceBoxItem> getSizeList();

    ObservableList<ChoiceBoxItem> getMaterialList();

    ObservableList<ChoiceBoxItem> getWeightList();

    ObservableList<ChoiceBoxItem> getGoldList();

    ObservableList<ChoiceBoxItem> getUvList();

    CheckBoxItem getKnife();

    CheckBoxItem getEmboss();

    CheckBoxItem getPrint();

    CheckBoxItem getCorrugate();

    CheckBoxItem getLaminate();

    CheckBoxItem getGold();

    CheckBoxItem getUv();
}
