package com.ticker.desktop.controller;

import com.ticker.desktop.service.BoxService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public abstract class BoxController extends Controller implements Initializable, IController {

    @FXML
    private TextField lengthText;
    @FXML
    private TextField widthText;
    @FXML
    private TextField heightText;
    @FXML
    private TextField numberText;
    @FXML
    private CheckBox knifeCheckBox;
    @FXML
    private CheckBox embossCheckBox;
    @FXML
    private ChoiceBox sizeChoiceBox;
    @FXML
    private ChoiceBox materialChoiceBox;
    @FXML
    private ChoiceBox weightChoiceBox;
    @FXML
    private CheckBox printCheckBox;
    @FXML
    private CheckBox corrugateCheckBox;
    @FXML
    private CheckBox laminateCheckBox;
    @FXML
    private CheckBox goldCheckBox;
    @FXML
    private TextField goldAreaText;
    @FXML
    private ChoiceBox goldChoiceBox;
    @FXML
    private CheckBox uvCheckBox;
    @FXML
    private TextField uvAreaText;
    @FXML
    private ChoiceBox uvChoiceBox;
    @FXML
    private TextField scaleText;

    public BoxService service;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        knifeCheckBox.setText(service.getKnife().getText());
        knifeCheckBox.setSelected(service.getKnife().isChecked());
        knifeCheckBox.setAllowIndeterminate(false);
        embossCheckBox.setText(service.getEmboss().getText());
        printCheckBox.setText(service.getPrint().getText());
        corrugateCheckBox.setText(service.getCorrugate().getText());
        laminateCheckBox.setText(service.getLaminate().getText());
        goldCheckBox.setText(service.getGold().getText());
        uvCheckBox.setText(service.getUv().getText());
        sizeChoiceBox.setItems(service.getSizeList());
        materialChoiceBox.setItems(service.getMaterialList());
        weightChoiceBox.setItems(service.getWeightList());
        goldChoiceBox.setItems(service.getGoldList());
        uvChoiceBox.setItems(service.getUvList());
        addListener(sizeChoiceBox, (observable, oldValue, newValue) -> {

        });
        addListener(materialChoiceBox, (observable, oldValue, newValue) -> {

        });
        addListener(weightChoiceBox, (observable, oldValue, newValue) -> {

        });
        addListener(goldChoiceBox, (observable, oldValue, newValue) -> {});
        addListener(uvChoiceBox, (observable, oldValue, newValue) -> {});
    }

    @FXML
    public void knifeChecked(ActionEvent event) {

    }

    @FXML
    public void embossChecked(ActionEvent event) {

    }

    @FXML
    public void printChecked(ActionEvent event) {

    }

    @FXML
    public void corrugateChecked(ActionEvent event) {

    }

    @FXML
    public void laminateChecked(ActionEvent event) {

    }

    @FXML
    public void goldChecked(ActionEvent event) {

    }

    @FXML
    public void uvChecked(ActionEvent event) {

    }

    @FXML
    public void ok(ActionEvent event) {

    }

    @FXML
    public void back(ActionEvent event) {

    }
}
