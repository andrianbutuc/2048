package model;

import DP.Observable;
import DP.Observer;

import java.util.ArrayList;
import java.util.List;

/**
 * This class represent a implementation of interface game .
 */
public class Game2048 implements Game, Observable {
    private Board board;
    private int score;
    private final List<Observer> observers;

    /**
     * Constructs a game .
     */
    public Game2048() {
        this.board = new Board();
        this.score = 0;
        observers = new ArrayList<>();
    }

    /**
     * Constructs a game with a given board and score .
     *
     * @param board a board .
     * @param score an integer .
     */
    Game2048(Board board, int score) {
        if (board == null) {
            throw new IllegalArgumentException("Board null");
        }
        this.board = board;
        this.score = score;
        observers = new ArrayList<>();
    }

    /**
     * Updates the score of game .
     *
     * @param number an integer .
     */
    void updateScore(int number) {
        if (number < 0) {
            throw new IllegalArgumentException("The number to update score is negative ");
        }
        this.score += number;
    }

    @Override
    public Case[][] getBoard() {
        return board.getGameTable();
    }


    @Override
    public int getScore() {
        return score;
    }


    @Override
    public void initializeRandomCase() {
        this.board.initializeRandomCase();
    }


    @Override
    public void move(Direction direction) {
        if (direction == null) {
            throw new IllegalArgumentException("Unknown direction");
        }
        int scoreOfMove = this.board.move(direction);
        this.updateScore(scoreOfMove);
        State state = State.PLAYING;

        if (this.isWon()) {
            state = State.WON;
        }
        if (this.compareBoard()) {
            state =  State.WRONGMOVE;
        }
        if (this.isLost()) {
            state = State.LOST;
        }
        if (!this.boardIsFull() && !this.compareBoard()) {
            this.initializeRandomCase();
        }
        notifyObservers(new GameState(this.getBoard(), score, state));
    }

    @Override
    public boolean boardIsFull() {
        return this.board.isFull(this.getBoard());
    }

    /**
     * Checks if the board has at least one pair of case to merge .
     *
     * @return true if the board has at least one pair of case to merge ,false otherwise .
     */
    boolean haveCaseToMerge() {
        return horizontalMerge() || verticalMerge();
    }

    /**
     * Checks if the board has at least one horizontal merge possible .
     *
     * @return true if the board has a horizontal merge possible .
     */
    private boolean horizontalMerge() {
        for (Case[] cases : this.getBoard()) {
            for (int column = 0; column < cases.length - 1; column++) {
                Case current = cases[column];
                Case next = cases[column + 1];
                if (current.merge(next)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Checks if the board has at least one vertical merge possible .
     *
     * @return true if the board has a vertical merge possible .
     */
    private boolean verticalMerge() {
        Case[][] boardToCheck = this.getBoard();
        for (int row = 0; row < boardToCheck.length - 1; row++) {
            for (int column = 0; column < boardToCheck[row].length; column++) {
                Case current = boardToCheck[row][column];
                Case next = boardToCheck[row + 1][column];
                if (current.merge(next)) {
                    return true;
                }
            }
        }
        return false;
    }


    @Override
    public boolean isWon() {
        return board.containsWinnerValue(getBoard());
    }


    @Override
    public boolean isLost() {
        return boardIsFull() && !haveCaseToMerge();
    }

    @Override
    public boolean compareBoard() {
        return this.board.compareBoard();
    }

    @Override
    public void restart(){
        this.board = new Board();
        this.score = 0 ;
        notifyObservers(new GameState(this.getBoard(), score, State.RESTART));
    }

    @Override
    public void addObserver(Observer observer) {
        if (observer == null) {
            throw new IllegalArgumentException("Observer null");
        }
        observers.add(observer);
    }

    @Override
    public void notifyObservers() {
        notifyObservers(null);
    }

    @Override
    public void notifyObservers(Object arg) {
        for (Observer observer : observers) {
            observer.update(this, arg);
        }
    }
}