package com.ticker.desktop.controller;

import com.ticker.desktop.service.LabelService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;


public abstract class LabelController extends Controller implements IController, Initializable {

    @FXML
    private TextField areaText;
    @FXML
    private ChoiceBox typeChoiceBox;
    @FXML
    private TextField scaleText;

    public LabelService service;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        typeChoiceBox.setItems(service.getTypeList());
        addListener(typeChoiceBox, (observable, oldValue, newValue) -> {});
    }

    @FXML
    public void ok(ActionEvent event) {

    }

    @FXML
    public void back(ActionEvent event) {

    }
}
