package com.ticker.desktop.service;

import com.ticker.desktop.model.ChoiceBoxItem;
import javafx.collections.ObservableList;

public interface HomeService {

    ObservableList<ChoiceBoxItem> getTypeList();
}
