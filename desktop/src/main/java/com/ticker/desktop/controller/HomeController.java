package com.ticker.desktop.controller;

import com.ticker.desktop.model.ChoiceBoxItem;
import com.ticker.desktop.model.enums.Type;
import com.ticker.desktop.service.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;

public class HomeController extends Controller implements Initializable {

    @FXML
    private ChoiceBox<ChoiceBoxItem> typeChoiceBox;

    private HomeService service = new HomeServiceImpl();

    private ResourceBundle bundle;

    @FXML
    public void ok(ActionEvent event) throws IOException {
        Type type = (Type) typeChoiceBox.getValue().getValue();
        Stage stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
        Stage nextStage = new Stage();
        String fxmlName;
        if (Type.POCKET == type) {
            fxmlName = "view/" + Type.BOX + ".fxml";
        } else {
            fxmlName = "view/" + type + ".fxml";
        }
        ClassLoader classLoader = getClass().getClassLoader();
        FXMLLoader loader = new FXMLLoader(classLoader.getResource(fxmlName));
        loader.setResources(bundle);
        loader.setControllerFactory(param -> {
            switch (type) {
                case BOOK:
                    return new BookController() {
                        @Override
                        public void setService() {
                            this.service = new BookServiceImpl();
                        }
                    };
                case POCKET:
                    return new BoxController() {
                        @Override
                        public void setService() {
                            this.service = new BoxServiceImpl();
                        }

                        @Override
                        public void setType(Type type) {
                            super.setType(Type.POCKET);
                        }
                    };
                case BOX:
                    return new BoxController() {
                        @Override
                        public void setService() {
                            this.service = new BoxServiceImpl();
                        }

                        @Override
                        public void setType(Type type) {
                            super.setType(Type.BOX);
                        }
                    };
                case LABEL:
                    return new LabelController() {
                        @Override
                        public void setService() {
                            this.service = new LabelServiceImpl();
                        }
                    };
                default:
                    try {
                        return param.newInstance();
                    } catch (InstantiationException | IllegalAccessException e) {
                        throw new RuntimeException(e);
                    }
            }
        });
        Parent root = loader.load();
        Scene scene = new Scene(root);
        nextStage.setScene(scene);
        String title = bundle.getString(type.toString());
        nextStage.setTitle(title);
        nextStage.initOwner(stage);
        nextStage.centerOnScreen();
        nextStage.initModality(Modality.APPLICATION_MODAL);
        nextStage.show();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        bundle = resources;
        typeChoiceBox.setItems(service.getTypeList());
        addListener(typeChoiceBox, (observable, oldValue, newValue) -> {});
    }
}
