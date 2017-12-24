package com.ticker.common.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.ticker.common.model.Menu;
import com.ticker.common.model.ProductInfo;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;

public class DataLoader {

//    private static final Logger logger = LogManager.getLogger(DataLoader.class);

    private static DataLoader ourInstance = new DataLoader();

    private final ObjectMapper mapper;

    private ProductInfo productInfo;

    private Menu menu;

    public static DataLoader getInstance() {
        return ourInstance;
    }

    private DataLoader() {
        mapper = new ObjectMapper(new YAMLFactory());
        ClassLoader classLoader = getClass().getClassLoader();
        try {
            productInfo = mapper.readValue(classLoader.getResource("product.yaml"), ProductInfo.class);
            menu = mapper.readValue(classLoader.getResource("product_menu.yaml"), Menu.class);
        } catch (IOException e) {
//            logger.error("Read YAML file failed!" + e.getMessage());
        }
    }

    public ProductInfo getProductInfo() {
        return productInfo;
    }

    public Menu getMenu() {
        return menu;
    }
}
