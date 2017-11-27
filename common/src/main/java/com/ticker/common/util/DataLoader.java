package com.ticker.common.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.ticker.common.model.Menu;
import com.ticker.common.model.Test;

import java.io.IOException;

public class DataLoader {
    private static DataLoader ourInstance = new DataLoader();

    private ObjectMapper mapper;

    public static DataLoader getInstance() {
        return ourInstance;
    }

    private DataLoader() {
        mapper = new ObjectMapper(new YAMLFactory());
        ClassLoader classLoader = getClass().getClassLoader();
        Test test = null;
        Menu menu = null;
        try {
            test = mapper.readValue(classLoader.getResource("product.yaml"), Test.class);
            menu = mapper.readValue(classLoader.getResource("product_menu.yaml"), Menu.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("HI" + test + menu);
    }

    public static void main(String[] args) {

    }


}
