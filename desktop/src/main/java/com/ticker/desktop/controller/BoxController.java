package com.ticker.desktop.controller;

import com.ticker.common.service.Area;
import com.ticker.common.service.BoxCalculator;
import com.ticker.common.service.PocketCalculator;
import com.ticker.desktop.model.CheckBoxItem;
import com.ticker.desktop.model.ChoiceBoxItem;
import com.ticker.desktop.model.enums.Type;
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

    private Type type;

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
    private ChoiceBox<ChoiceBoxItem> sizeChoiceBox;
    @FXML
    private ChoiceBox<ChoiceBoxItem> materialChoiceBox;
    @FXML
    private ChoiceBox<ChoiceBoxItem> weightChoiceBox;
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
    private ChoiceBox<ChoiceBoxItem> goldChoiceBox;
    @FXML
    private CheckBox uvCheckBox;
    @FXML
    private TextField uvAreaText;
    @FXML
    private ChoiceBox<ChoiceBoxItem> uvChoiceBox;
    @FXML
    private TextField scaleText;

    public BoxService service;

    private ResourceBundle bundle;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        bundle = resources;
        setService();
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
        BoxCalculator calculator;
        switch (type) {
            case BOX:
                calculator = new BoxCalculator();
                break;
            case POCKET:
                calculator = new PocketCalculator();
                break;
            default:
                calculator = new BoxCalculator();
                break;
        }
        Area area = new Area();
        area.setHeight(Double.parseDouble(heightText.getText()));
        area.setWidth(Double.parseDouble(widthText.getText()));
        area.setDepth(Double.parseDouble(lengthText.getText()));
        calculator.setArea(area);
        calculator.setNumber(Integer.parseInt(numberText.getText()));
        calculator.setEmboss(embossCheckBox.isSelected() ? 1 : 0);
        calculator.setSize(sizeChoiceBox.getValue().getId());
        calculator.setMaterial(materialChoiceBox.getValue().getId());
        calculator.setWeight(weightChoiceBox.getValue().getId());

        calculator.setCorrugate(corrugateCheckBox.isSelected() ? 1 : 0);
        calculator.setLaminate(laminateCheckBox.isSelected() ? 1 : 0);

        calculator.setPrint(printCheckBox.isSelected() ? 1 : 0);

        calculator.setGold(goldCheckBox.isSelected() ? 1 : 0);
        calculator.setGoldArea(Double.parseDouble(goldAreaText.getText()));
        calculator.setGoldSize(goldChoiceBox.getValue().getId());

        calculator.setUv(uvCheckBox.isSelected() ? 1 : 0);
        calculator.setUvSize(uvChoiceBox.getValue().getId());
        calculator.setUvArea(Double.parseDouble(uvAreaText.getText()));

        calculator.setScale(Double.parseDouble(scaleText.getText()));
        double price = calculator.calculate();
        showResult(price);
    }

    @FXML
    public void back(ActionEvent event) {
        closeStage(event);
    }

    public void setType(Type type) {
        this.type = type;
    }
}
