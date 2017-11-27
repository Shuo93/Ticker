package com.ticker.desktop.controller;

import javafx.beans.value.ChangeListener;
import javafx.scene.control.ChoiceBox;

public class Controller {

    protected void addListener(ChoiceBox choiceBox, ChangeListener listener) {
        choiceBox.getSelectionModel()
                .selectedItemProperty()
                .addListener(listener);
    }
}
