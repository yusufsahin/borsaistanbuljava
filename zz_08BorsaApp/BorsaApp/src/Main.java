import models.Portfolio;
import models.Stock;
import models.enums.StockType;
import services.MarketData;
import services.TransactionHistory;
import services.OrderBook;
import designpatterns.PriceCalculator;
import designpatterns.PriceStrategyFactory;
import designpatterns.StockBuilder;
import models.Order;
import models.enums.OrderType;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        MarketData marketData = MarketData.getInstance();

        // Builder ile hisse oluştur
        Stock apple = new StockBuilder().setSymbol("AAPL").setPrice(150.5).setSector(StockType.TEKNOLOJI).build();
        Stock google = new StockBuilder().setSymbol("GOOG").setPrice(2800.1).setSector(StockType.TEKNOLOJI).build();
        Stock tesla = new StockBuilder().setSymbol("TSLA").setPrice(720.3).setSector(StockType.ENERJI).build();

        // Hisse senetlerini ekle
        marketData.addStock(apple);
        marketData.addStock(google);
        marketData.addStock(tesla);

        // Portföy oluştur ve gözlemci olarak ekle
        Portfolio portfolio = new Portfolio("Ali");
        portfolio.addStock(apple, 10);
        portfolio.addStock(google, 5);
        marketData.addObserver(portfolio);

        // Portföyü görüntüle
        portfolio.displayPortfolio();
// Teknoloji sektöründeki hisse senetlerini filtrele
        System.out.println("Sağlık");
        portfolio.displayStocksBySector(StockType.SAGLIK);
        // Teknoloji sektöründeki hisse senetlerini filtrele
        System.out.println("Teknoloji");
        portfolio.displayStocksBySector(StockType.TEKNOLOJI);

        // Fiyat hesaplama (Strategy ve Factory Pattern)
        PriceCalculator calculator = new PriceCalculator();
        calculator.setStrategy(PriceStrategyFactory.getStrategy(apple));
        double applePrice = calculator.calculatePrice(apple, 100);
        System.out.println("Apple için 100 hisse fiyatı: " + applePrice);

        // Hisse fiyatını güncelle ve gözlemcileri bilgilendir
        marketData.updateStockPrice("AAPL", 160.0);

        // İşlem geçmişi
        TransactionHistory transactionHistory = new TransactionHistory();
        transactionHistory.addTransaction("AAPL için 100 hisse alındı.");
        transactionHistory.displayAllTransactionsParallel();
        }
    }
