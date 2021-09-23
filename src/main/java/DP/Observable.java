package DP;

/**
 * The interface Observable .
 */
public interface Observable {

    /**
     * Adds an observer to the set of the observers for this object ,provided that
     * if is not the same as some observer already in the set .The order in which
     * notifications will be delivered to multiple observers is not specified .
     * See the class comment .
     *
     * @param observer an observer to be added .
     * @throws NullPointerException if the parameter is null .
     */
    void addObserver(Observer observer);

    /**
     * Notify all of its observers .
     * <p>
     * Each observer has its {@code update} method called with two arguments :
     * this observable object and {@code null} .In other words, this method is
     * equivalent to :
     * <blockquote>{@code
     * notifyObservers(null)}*</blockquote>
     */
    void notifyObservers();

    /**
     * Notify all of its observers .
     * <p>
     * Each observer has its {@code update} method called with two arguments :
     * this observable object and the {@code arg} argument .
     *
     * @param arg any object .
     */
    void notifyObservers(Object arg);
}
