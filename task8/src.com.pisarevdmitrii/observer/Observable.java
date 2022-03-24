package observer;

/**
 * todo Document type Observable
 */
public interface Observable {

    void registerObserver(Observer o);

    void removeObserver(Observer o);

    void notifyObservers();
}
