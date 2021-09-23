package model;

import DP.Observable;

/**
 * This interface provide the methods to implement the game 2048 .
 */
public interface Game extends Observable {
    /**
     * Return a copy of gale table .
     *
     * @return the game table .
     */
    Case[][] getBoard();

    /**
     * Returns the score of game .
     *
     * @return the score of game .
     */
    int getScore();

    /**
     * Initializes a random empty case with the value 2 or 4 (the chance for a 2 is 90% and 10% for a 4).
     */
    void initializeRandomCase();

    /**
     * Moves the cases in the indicated direction and update the score .
     *
     * @param direction a direction .
     */
    void move(Direction direction);

    /**
     * Checks if the game board is full with non-empty cases.
     *
     * @return true if game board is full ,false otherwise.
     */
    boolean boardIsFull();

    /**
     * Checks if the game is won .
     *
     * @return true if the game is won ,false otherwise.
     */
    boolean isWon();

    /**
     * Checks if the game is lost .
     *
     * @return true if the game is lost ,false otherwise.
     */
    boolean isLost();

    /**
     * Compares the game table with his history and returns true if they are the same .
     *
     * @return true if game table is equal to his history ,false otherwise .
     */
    boolean compareBoard();

    /**
     * Restarts the game .
     */
    void restart();
}
