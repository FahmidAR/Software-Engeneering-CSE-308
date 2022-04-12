import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;

public class Stock implements Subject {

    private String stockName;
    private int stockNo;
    private float stockPrice;
    PrintStream cout;

    private ArrayList<Observer> subscribers;

    public Stock(String stockName, int stockNo, float stockPrice) {

        this.stockName = stockName;
        this.stockNo = stockNo;
        this.stockPrice = stockPrice;

        subscribers = new ArrayList<Observer>();

    }

    @Override
    public String showDetailsToObservers() {

        return stockName+" "+stockNo+" "+stockPrice;
    }

    @Override

    public void subscribe(Observer observer) {
        subscribers.add(observer);
    }


    @Override

    public void unsubscribe(Observer observer) {
        subscribers.remove(observer);
    }


    @Override

    public void notifyObservers(String change) throws IOException {
        for (Observer subscriber : subscribers) {

            String temp = subscriber.update(stockName, change);
            cout=new PrintStream(subscriber.getSk().getOutputStream());
            cout.println(temp);
        }
    }


    public void incStockPrice(float value) throws IOException {

        this.stockPrice = this.stockPrice + value ;
        String message =stockName + " price has increased to " + this.stockPrice + " in this update " ;

        System.out.println(message);

        notifyObservers(message);

    }
    public void decStockPrice(float value) throws IOException {

        this.stockPrice = this.stockPrice - value ;
        String message =stockName + " price has decreased to " + this.stockPrice + "in this update " ;

        System.out.println(message);

        notifyObservers(message);

    }
    public void incStockCount(int value) throws IOException {

        this.stockNo = this.stockNo + value ;
        String message =stockName + " count has increased to " + this.stockNo + " in this update " ;

        System.out.println(message);

        notifyObservers(message);

    }
}