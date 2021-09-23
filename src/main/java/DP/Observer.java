package DP;

/**
 * A class can implement the {@code Observer} interface when it wants to informed of changes
 * in observable objects .
 *
 * @author jlc .
 */
public interface Observer {
    /**
     * This method is called whenever the observed object is changed .An application calls an
     * {@code Observable} object's {@code notifyObservers} method to have all the objects observers
     * notified of the change .
     *
     * @param observable the observable object .
     * @param arg an argument passed to the {@code notifyObservers} method .
     */
    void update(Observable observable, Object arg);
}
