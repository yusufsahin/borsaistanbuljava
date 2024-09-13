package designpatterns;

import models.Stock;

public class EnergyPriceStrategy implements PriceCalculationStrategy {
    @Override
    public double calculatePrice(Stock stock, int quantity) {
        double commission = 0.03;
        return stock.getPrice() * quantity * (1 + commission);
    }
}

