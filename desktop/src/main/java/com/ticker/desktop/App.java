package com.ticker.desktop;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Hello world!
 *
 */
public class App extends Application
{
    public static void main( String[] args )
    {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader();
        Locale locale = Locale.getDefault();
        ResourceBundle bundle = ResourceBundle.getBundle("properties.message", locale);
        loader.setResources(bundle);
        ClassLoader classLoader = getClass().getClassLoader();
        Parent root = loader.load(classLoader.getResource("view/home.fxml").openStream());
        Scene scene = new Scene(root);
        primaryStage.setTitle("Ticker");
        primaryStage.setScene(scene);
        primaryStage.centerOnScreen();
        primaryStage.show();
    }
}
