package view.JavaFx;

import controller.ControllerJavaFx;

/**
 * The interface to construct javaFx view .
 */
public interface ViewJavaFx {

    /**
     * Creates the events to control the game .
     * @param controller a ControllerJavaFx.
     */
    void createEvents(ControllerJavaFx controller);

    /**
     * Adds events to the view .
     */
    void addEvents();

    /**
     * Deletes events to the view .
     */
    void deleteEvents();

    /**
     * Prints the error message for the developer and an instruction for user .
     * @param message a string .
     */
    void printError(String message);
}
