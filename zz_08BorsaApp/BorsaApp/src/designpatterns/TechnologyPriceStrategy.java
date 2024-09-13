package designpatterns;

import models.Stock;

public class TechnologyPriceStrategy implements PriceCalculationStrategy {
    @Override
    public double calculatePrice(Stock stock, int quantity) {
        double commission = 0.02;
        return stock.getPrice() * quantity * (1 + commission);
    }
}
