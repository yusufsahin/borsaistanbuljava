package designpatterns;

import models.Stock;

public interface PriceCalculationStrategy {
    double calculatePrice(Stock stock, int quantity);
}

