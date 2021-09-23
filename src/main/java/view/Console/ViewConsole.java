package view.Console;

import model.Case;
import model.Direction;

/**
 * The interface to construct console view .
 */
public interface ViewConsole {
    /**
     * Prints the board of game 2048.
     *
     * @param board a 2D array of cases .
     */
    void printBoard(Case[][] board);

    /**
     * Asks a direction to player .
     *
     * @return a direction given by player .
     */
    Direction askDirection();

    /**
     * Prints the menu of game 2048.
     */
    void printMenu();

    /**
     * Prints the game score .
     *
     * @param score an integer .
     */
    void printScore(int score);

    /**
     * Prints the given message .
     *
     * @param message a string .
     */
    void printMessage(String message);

}
