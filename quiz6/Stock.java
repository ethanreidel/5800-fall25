public class Stock {
    private String symbol;
    private double price;
    private Observer observer;

    public Stock(String symbol, double price) {
        this.symbol = symbol; //something like DOW?
        this.price = price; 
    }
    
    public void setObserver(Observer observer) {
        this.observer = observer;
        if (observer != null) {
            observer.update(symbol, price);
        }
    }
    public String getSymbol() {
        return symbol;
    }
    public double getPrice() {
        return price;
    }

    public void setPrice(double newPrice) {
        if (newPrice != this.price) {
            this.price = newPrice;
            observer.update(symbol, price);
        }
    }

}
