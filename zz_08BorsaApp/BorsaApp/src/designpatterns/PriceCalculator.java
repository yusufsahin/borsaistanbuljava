package designpatterns;

import models.Stock;

public class PriceCalculator {
    private PriceCalculationStrategy strategy;

    public void setStrategy(PriceCalculationStrategy strategy) {
        this.strategy = strategy;
    }

    public double calculatePrice(Stock stock, int quantity) {
        return strategy.calculatePrice(stock, quantity);
    }
}
