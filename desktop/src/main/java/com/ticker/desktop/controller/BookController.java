package com.ticker.desktop.controller;

import com.ticker.common.service.BookCalculator;
import com.ticker.desktop.model.ChoiceBoxItem;
import com.ticker.desktop.service.BookService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;


public abstract class BookController extends Controller implements IController, Initializable {

    @FXML
    private ChoiceBox<ChoiceBoxItem> areaChoiceBox;
    @FXML
    private TextField pageText;
    @FXML
    private TextField numberText;
    @FXML
    private ChoiceBox<ChoiceBoxItem> sizeChoiceBox;
    @FXML
    private ChoiceBox<ChoiceBoxItem> materialChoiceBox;
    @FXML
    private ChoiceBox<ChoiceBoxItem> weightChoiceBox;
    @FXML
    private CheckBox printCheckBox;
    @FXML
    private CheckBox laminateCheckBox;
    @FXML
    private CheckBox bindCheckBox;
    @FXML
    private ChoiceBox<ChoiceBoxItem> bindTypeChoiceBox;
    @FXML
    private ChoiceBox<ChoiceBoxItem> bindKeyChoiceBox;
    @FXML
    private TextField scaleText;

    public BookService service;

    @FXML
    public void printChecked(ActionEvent event) {

    }

    @FXML
    public void laminateChecked(ActionEvent event) {

    }

    @FXML
    public void bindChecked(ActionEvent event) {

    }

    @FXML
    public void ok(ActionEvent event) {
        BookCalculator calculator = new BookCalculator();
        calculator.setK(areaChoiceBox.getValue().getId());
        calculator.setPageNum(Integer.parseInt(pageText.getText()));
        calculator.setBookNum(Integer.parseInt(numberText.getText()));
        calculator.setSize(sizeChoiceBox.getValue().getId());
        calculator.setMaterial(materialChoiceBox.getValue().getId());
        calculator.setWeight(weightChoiceBox.getValue().getId());
        calculator.setPrint(printCheckBox.isSelected());
        calculator.setLaminate(laminateCheckBox.isSelected());

        calculator.setBind(bindCheckBox.isSelected());
        if (bindCheckBox.isSelected()) {
            calculator.setBindType(bindTypeChoiceBox.getValue().getId());
            calculator.setBindKey(bindKeyChoiceBox.getValue().getId());
        }
        calculator.setScale(Double.parseDouble(scaleText.getText()));
        double price = calculator.calculate();
        showResult(price);
    }

    @FXML
    public void back(ActionEvent event) {
        closeStage(event);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        setService();
        printCheckBox.setText(service.getPrint().getText());
        laminateCheckBox.setText(service.getLaminate().getText());
        bindCheckBox.setText(service.getBind().getText());
        bindCheckBox.setSelected(service.getBind().isChecked());
        areaChoiceBox.setItems(service.getAreaList());
        sizeChoiceBox.setItems(service.getSizeList());
        materialChoiceBox.setItems(service.getMaterialList());
        weightChoiceBox.setItems(service.getWeightList());
        bindTypeChoiceBox.setItems(service.getBindTypeList());
        addListener(areaChoiceBox, (observable, oldValue, newValue) -> {});
        addListener(sizeChoiceBox, (observable, oldValue, newValue) -> {});
        addListener(materialChoiceBox, (observable, oldValue, newValue) -> {});
        addListener(weightChoiceBox, (observable, oldValue, newValue) -> {});
        addListener(bindTypeChoiceBox, (observable, oldValue, newValue) -> {
            String id = ((ChoiceBoxItem)newValue).getId();
            bindKeyChoiceBox.setItems(service.getBindKey(id));
        });
        scaleText.setText("1.0");
    }
}
