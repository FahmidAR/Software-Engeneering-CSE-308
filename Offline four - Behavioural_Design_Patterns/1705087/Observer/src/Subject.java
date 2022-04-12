import java.io.IOException;

public interface Subject{

    public void subscribe(Observer observer);

    public void unsubscribe(Observer observer);

    public void notifyObservers(String message) throws IOException;

    public String showDetailsToObservers();

}