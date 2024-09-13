package designpatterns;

import models.Stock;
import models.enums.StockType;

public class StockBuilder {
    private String symbol;
    private double price;
    private StockType sector;

    public StockBuilder setSymbol(String symbol) {
        this.symbol = symbol;
        return this;
    }

    public StockBuilder setPrice(double price) {
        this.price = price;
        return this;
    }

    public StockBuilder setSector(StockType sector) {
        this.sector = sector;
        return this;
    }

    public Stock build() {
        return new Stock(symbol, price, sector);
    }
}

