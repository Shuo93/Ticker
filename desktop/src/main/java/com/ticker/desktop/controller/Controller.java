package com.ticker.desktop.controller;

import javafx.beans.value.ChangeListener;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.stage.Stage;

import java.math.BigDecimal;

public class Controller {

    protected void addListener(ChoiceBox choiceBox, ChangeListener listener) {
        choiceBox.getSelectionModel()
                .selectedItemProperty()
                .addListener(listener);
    }

    protected void closeStage(ActionEvent event) {
        Stage stage = (Stage) ((Button)event.getSource()).getScene().getWindow();
        stage.close();
    }

    protected void showResult(double price) {
        BigDecimal bd = new BigDecimal(price);
        String result = bd.setScale(2, BigDecimal.ROUND_HALF_UP).toString();
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("结果");
        alert.setHeaderText(result);
        alert.setContentText("计算完成");
        alert.showAndWait();
    }
}
