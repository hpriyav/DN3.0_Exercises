

import java.util.ArrayList;
import java.util.List;


interface Stock {
    void registerObserver(Observer o);
    void deregisterObserver(Observer o);
    void notifyObservers();
}


class StockMarket implements Stock {
    private List<Observer> observers;
    private double stockPrice;

    public StockMarket() {
        this.observers = new ArrayList<>();
    }

    @Override
    public void registerObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void deregisterObserver(Observer o) {
        observers.remove(o);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(stockPrice);
        }
    }

    public void setStockPrice(double stockPrice) {
        this.stockPrice = stockPrice;
        notifyObservers();
    }
}


interface Observer {
    void update(double stockPrice);
}

class MobileApp implements Observer {
    @Override
    public void update(double stockPrice) {
        System.out.println("MobileApp: Stock price updated to " + stockPrice);
    }
}

class WebApp implements Observer {
    @Override
    public void update(double stockPrice) {
        System.out.println("WebApp: Stock price updated to " + stockPrice);
    }
}


public class ObserverPatternExample {
    public static void main(String[] args) {
        StockMarket stockMarket = new StockMarket();

        Observer mobileApp = new MobileApp();
        Observer webApp = new WebApp();

        stockMarket.registerObserver(mobileApp);
        stockMarket.registerObserver(webApp);

        stockMarket.setStockPrice(100.50);
        stockMarket.setStockPrice(102.75);

        stockMarket.deregisterObserver(webApp);
        stockMarket.setStockPrice(105.00);
    }
}
