package com.ticker.desktop.controller;

import com.ticker.common.service.Calculator;
import com.ticker.common.service.LabelCalculator;
import com.ticker.desktop.model.ChoiceBoxItem;
import com.ticker.desktop.service.LabelService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public abstract class LabelController extends Controller implements IController, Initializable {

    @FXML
    private TextField areaText;
    @FXML
    private ChoiceBox<ChoiceBoxItem> typeChoiceBox;
    @FXML
    private TextField scaleText;

    public LabelService service;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        setService();
        areaText.setPromptText("平方米");
        typeChoiceBox.setItems(service.getTypeList());
        addListener(typeChoiceBox, (observable, oldValue, newValue) -> {});
        scaleText.setText("1.0");
    }

    @FXML
    public void ok(ActionEvent event) {
        LabelCalculator calculator = new LabelCalculator();
        calculator.setArea(Double.parseDouble(areaText.getText()));
        calculator.setType(typeChoiceBox.getValue().getId());
        calculator.setScale(Double.parseDouble(scaleText.getText()));
        double price = service.calculate(calculator);
        showResult(price);
    }

    @FXML
    public void back(ActionEvent event) throws IOException {
        closeStage(event);
    }

}
