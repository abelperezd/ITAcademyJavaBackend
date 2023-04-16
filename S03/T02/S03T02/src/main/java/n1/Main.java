package n1;

public class Main {

    public static void main(String[] args) {
        Stock s1 = new Stock("Stock A", 10);
        Stock s2 = new Stock("Stock B", 11);
        Stock s3 = new Stock("Stock C", 12);

        StockMarket stockMarket = new StockMarket();
        stockMarket.addStock(s1, s2, s3);

        StockAgentObservable stockAgentObservable = new StockAgentObservable();
        stockMarket.addObserver(stockAgentObservable);

        AgencyObserver agencyObserver1 = new AgencyObserver("Agency 1");
        stockMarket.addObserver(agencyObserver1);
        AgencyObserver agencyObserver2 = new AgencyObserver("Agency 2");
        stockMarket.addObserver(agencyObserver2);

        stockMarket.updateStockPrice("Stock A", 25);
        stockMarket.updateStockPrice("Stock B", 150);


    }
}
