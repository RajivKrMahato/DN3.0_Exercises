public class Main {
    public static void main(String[] args) {
        StockMarket stockMarket = new StockMarket("TechCorp", 100.00);
        Observer mobileApp = new MobileApp();
        Observer webApp = new WebApp();

        stockMarket.registerObserver(mobileApp);
        stockMarket.registerObserver(webApp);

        System.out.println("Updating stock price...");
        stockMarket.setStockPrice(210);

        System.out.println("Updating stock price again...");
        stockMarket.setStockPrice(220);

        stockMarket.deregisterObserver(mobileApp);
        System.out.println("Updating stock price after deregistering mobile app...");
        stockMarket.setStockPrice(225);
    }
}
