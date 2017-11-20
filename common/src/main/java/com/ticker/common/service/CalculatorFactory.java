package com.ticker.common.service;

import com.ticker.common.model.Book;
import com.ticker.common.model.Box;
import com.ticker.common.model.Pocket;
import com.ticker.common.model.Product;

public class CalculatorFactory {

    public static Calculator createCalculator(Product product) {
        if (product instanceof Box) {
            return new BoxCalculator();
        }
        if (product instanceof Book) {
            return new BookCalculator();
        }
        if (product instanceof Pocket) {
            return new PocketCalculator();
        }
        return new AbstractCalculator();
    }
}
