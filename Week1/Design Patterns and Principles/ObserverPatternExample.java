// ObserverPatternExample.java

import java.util.ArrayList;
import java.util.List;

// Subject Interface
interface Stock {
    void registerObserver(Observer observer);
    void deregisterObserver(Observer observer);
    void notifyObservers();
}

// Concrete Subject
class StockMarket implements Stock {
    private List<Observer> observers = new ArrayList<>();
    private double price;

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void deregisterObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(price);
        }
    }

    public void setPrice(double price) {
        this.price = price;
        notifyObservers();
    }
}

// Observer Interface
interface Observer {
    void update(double price);
}

// Concrete Observer - MobileApp
class MobileApp implements Observer {
    private String name;

    public MobileApp(String name) {
        this.name = name;
    }

    @Override
    public void update(double price) {
        System.out.println(name + " received stock price update: $" + price);
    }
}

// Concrete Observer - WebApp
class WebApp implements Observer {
    private String name;

    public WebApp(String name) {
        this.name = name;
    }

    @Override
    public void update(double price) {
        System.out.println(name + " received stock price update: $" + price);
    }
}

// Test the Observer Pattern
public class ObserverPatternExample {
    public static void main(String[] args) {
        // Create stock market
        StockMarket stockMarket = new StockMarket();

        // Create observers
        Observer mobileApp = new MobileApp("MobileApp1");
        Observer webApp = new WebApp("WebApp1");

        // Register observers
        stockMarket.registerObserver(mobileApp);
        stockMarket.registerObserver(webApp);

        // Change stock price
        System.out.println("Updating stock price to $120.50");
        stockMarket.setPrice(120.50);

        // Deregister an observer
        stockMarket.deregisterObserver(mobileApp);

        // Change stock price
        System.out.println("Updating stock price to $125.75");
        stockMarket.setPrice(125.75);
    }
}
