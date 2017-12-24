package com.ticker.common.service;

import com.ticker.common.model.Book;
import com.ticker.common.model.Box;
import com.ticker.common.model.Label;
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
        if (product instanceof Label) {
            return new LabelCalculator();
        }
        return new AbstractCalculator() {
            @Override
            public double calculate() {
                return 0;
            }
        };
    }
}
