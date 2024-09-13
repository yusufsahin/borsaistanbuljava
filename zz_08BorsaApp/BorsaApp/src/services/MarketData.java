package services;

import designpatterns.Subject;
import models.Stock;

import java.util.HashMap;
import java.util.Map;

public class MarketData extends Subject {
    private static MarketData instance;
    private final Map<String, Stock> stockPrices;

    private MarketData() {
        this.stockPrices = new HashMap<>();
    }

    public static MarketData getInstance() {
        if (instance == null) {
            synchronized (MarketData.class) {
                if (instance == null) {
                    instance = new MarketData();
                }
            }
        }
        return instance;
    }

    public void addStock(Stock stock) {
        stockPrices.put(stock.getSymbol(), stock);
        notifyObservers(stock);
    }

    public void updateStockPrice(String symbol, double newPrice) {
        Stock stock = stockPrices.get(symbol);
        if (stock != null) {
            Stock updatedStock = new Stock(symbol, newPrice, stock.getSector());
            stockPrices.put(symbol, updatedStock);
            notifyObservers(updatedStock);
        }
    }

    public void displayPrices() {
        stockPrices.values().forEach(System.out::println);
    }
}
