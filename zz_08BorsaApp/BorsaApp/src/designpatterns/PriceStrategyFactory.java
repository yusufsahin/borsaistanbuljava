package designpatterns;

import models.Stock;

public class PriceStrategyFactory {
    public static PriceCalculationStrategy getStrategy(Stock stock) {
        return switch (stock.getSector()) {
            case TEKNOLOJI -> new TechnologyPriceStrategy();
            case ENERJI -> new EnergyPriceStrategy();
            default -> (stockItem, quantity) -> stockItem.getPrice() * quantity;
        };
    }
}
