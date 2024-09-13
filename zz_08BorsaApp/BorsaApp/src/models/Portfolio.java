package models;

import designpatterns.Observer;
import models.enums.StockType;

import java.util.HashMap;
import java.util.Map;

public class Portfolio implements Observer {
    private final String user;
    private final Map<Stock, Integer> stocks;

    public Portfolio(String user) {
        this.user = user;
        this.stocks = new HashMap<>();
    }

    public void addStock(Stock stock, int quantity) {
        stocks.put(stock, stocks.getOrDefault(stock, 0) + quantity);
    }

    @Override
    public void update(Stock stock) {
        if (stocks.containsKey(stock)) {
            System.out.println(user + " portföyü için güncellenen hisse: " + stock);
        }
    }

    public void displayPortfolio() {
        stocks.forEach((stock, quantity) -> System.out.println(stock + " - Adet: " + quantity));
    }

    public void displayStocksBySector(StockType sector) {
        stocks.keySet().stream()
                .filter(stock -> stock.getSector() == sector)
                .forEach(System.out::println);
    }

    public double calculateTotalValue() {
        return stocks.entrySet().stream()
                .parallel()
                .mapToDouble(entry -> entry.getKey().getPrice()
                        * entry.getValue())
                .sum();
    }
}
