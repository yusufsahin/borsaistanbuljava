package models;

import models.enums.StockType;

public class Stock {
    private final String symbol;
    private final double price;
    private final StockType sector;

    public Stock(String symbol, double price, StockType sector) {
        this.symbol = symbol;
        this.price = price;
        this.sector = sector;
    }

    public String getSymbol() {
        return symbol;
    }

    public double getPrice() {
        return price;
    }

    public StockType getSector() {
        return sector;
    }

    @Override
    public String toString() {
        return "Stock{" +
                "symbol='" + symbol + '\'' +
                ", price=" + price +
                ", sector=" + sector +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Stock stock = (Stock) o;
        return Double.compare(stock.price, price) == 0 && symbol.equals(stock.symbol) && sector == stock.sector;
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(symbol, price, sector);
    }
}
