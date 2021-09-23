package model;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 * This class represent the board of the game 2048 .
 */
class Board {
    private final static int HEIGHT = 4;
    private final static int WINNING_CASE_VALUE = 2048;
    private final Case[][] gameTable;
    private final Case[][] history;

    /**
     * Constructs a board with a non-empty case .
     */
    Board() {
        this.gameTable = new Case[HEIGHT][HEIGHT];
        this.history = new Case[HEIGHT][HEIGHT];
        this.initializeBoard();
    }

    /**
     * Constructs a board with given game table and his history .
     *
     * @param newBoard a 2D array of cases .
     * @param history  a 2D array of cases .
     */
    Board(Case[][] newBoard, Case[][] history) {
        if(newBoard == null || history == null){
            throw new IllegalArgumentException("New board or history is null ");
        }
        this.gameTable = newBoard;
        this.history = history;
    }

    /**
     * Constructs a copy of board .
     *
     * @param boardToCopy a board .
     */
    Board(Board boardToCopy) {
        if (boardToCopy == null) {
            throw new IllegalArgumentException("Board is null");
        }
        this.gameTable = new Case[HEIGHT][HEIGHT];
        this.history = new Case[HEIGHT][HEIGHT];
        for (int line = 0; line < HEIGHT; line++) {
            for (int column = 0; column < HEIGHT; column++) {
                this.gameTable[line][column] = new Case(line, column);
                this.gameTable[line][column].setValue(boardToCopy.gameTable[line][column].getValue());
                this.history[line][column] = new Case(line, column);
                this.history[line][column].setValue(boardToCopy.history[line][column].getValue());
            }
        }
    }

    /**
     * Moves the cases in the indicated direction .
     * @param direction a direction .
     * @return the score of move .
     */
    int move(Direction direction) {
        if(direction == null){
            throw new IllegalArgumentException("Unknown direction");
        }
        int scoreOfMove = 0;
        List<Case> caseToMerge = new LinkedList<>();
        this.saveHistory(gameTable);
        int line = 0;
        while (line < HEIGHT) {
            initList(direction, caseToMerge, line);
            scoreOfMove = scoreOfMove + merge(caseToMerge);
            line++;
            caseToMerge.clear();
        }
        return scoreOfMove;
    }

    /**
     * Updates the history of board with the given history .
     *
     * @param newHistory a 2D array of cases .
     */
    private void saveHistory(Case[][] newHistory) {
        if(newHistory == null){
            throw new IllegalArgumentException("New history is null ");
        }
        for (int line = 0; line < HEIGHT; line++) {
            for (int column = 0; column < HEIGHT; column++) {
                this.history[line][column].setValue(newHistory[line][column].getValue());
            }
        }
    }

    /**
     * Initializes a list of case to merge .
     *
     * @param direction   a direction .
     * @param caseToMerge a case list .
     * @param line        an integer .
     */
    private void initList(Direction direction, List<Case> caseToMerge, int line) {
        if(caseToMerge == null){
            throw new IllegalArgumentException("The list of case to merge is null ");
        }
        switch (direction) {
            case TOP:
                initListMoveDown(caseToMerge, line);
                Collections.reverse(caseToMerge);
                break;
            case DOWN:
                initListMoveDown(caseToMerge, line);
                break;
            case LEFT:
                initListMoveRight(caseToMerge, line);
                Collections.reverse(caseToMerge);
                break;
            case RIGHT:
                initListMoveRight(caseToMerge, line);
                break;
        }
    }

    /**
     * Searches the cases to merge ,merges them and update the game table .
     *
     * @param casesToMerge a case list .
     * @return the score of move .
     */
    private int merge(List<Case> casesToMerge) {
        if(casesToMerge == null){
            throw new IllegalArgumentException("The list of case to merge is null ");
        }
        LinkedList<Case> nonEmptyCases = new LinkedList<>();
        initListNonEmptyCase(casesToMerge, nonEmptyCases);
        int[] updatedValues = new int[HEIGHT];
        int scoreOfMerge = mergeListCase(updatedValues, nonEmptyCases);
        updateList(updatedValues, casesToMerge);
        return scoreOfMerge;
    }

    /**
     * Merges the case that can be merged and calculates the score of merged cases . Also initialises an array with
     * the updated values to modify in game table .
     *
     * @param updatedValues an integer array .
     * @param nonEmptyCases a linked list of cases .
     * @return the score of merged cases .
     */
    private int mergeListCase(int[] updatedValues, LinkedList<Case> nonEmptyCases) {
        if(nonEmptyCases == null){
            throw new IllegalArgumentException("The list of case to merge is null ");
        }
        if(updatedValues == null){
            throw new IllegalArgumentException("The array of updated values is null ");
        }
        int mergedScore = 0;
        int indexOfUpdatedValues = 0;
        while (!nonEmptyCases.isEmpty()) {
            Case current = nonEmptyCases.pollFirst();
            Case next = nonEmptyCases.peekFirst();
            if (next != null && current.merge(next)) {
                updatedValues[indexOfUpdatedValues] = (current.getValue() + next.getValue());
                mergedScore = mergedScore + updatedValues[indexOfUpdatedValues];
                nonEmptyCases.pollFirst();
            } else {
                updatedValues[indexOfUpdatedValues] = current.getValue();
                if (next != null) {
                    updatedValues[indexOfUpdatedValues + 1] = next.getValue();
                }
            }
            indexOfUpdatedValues++;
        }
        return mergedScore;
    }

    /**
     * Initializes a linkedList of non empty cases using a case list .
     *
     * @param cases         a case list .
     * @param nonEmptyCases a case linkedList .
     */
    private void initListNonEmptyCase(List<Case> cases, LinkedList<Case> nonEmptyCases) {
        if(cases == null || nonEmptyCases == null){
            throw new IllegalArgumentException("The list of case is null ");
        }
        for (Case aCase : cases) {
            if (!aCase.isEmpty()) {
                nonEmptyCases.add(aCase);
            }
        }
    }

    /**
     * Updates the list of case with the given updated values .
     *
     * @param updatedValues an integer array
     * @param caseToUpdate  a case list .
     */
    private void updateList(int[] updatedValues, List<Case> caseToUpdate) {
        if(caseToUpdate == null){
            throw new IllegalArgumentException("The list of case to update is null ");
        }
        if(updatedValues == null){
            throw new IllegalArgumentException("The array of updated values is null ");
        }
        for (int index = 0; index < updatedValues.length; index++) {
            Case c = caseToUpdate.get(index);
            gameTable[c.getLine()][c.getColumn()].setValue(updatedValues[index]);
        }
    }

    /**
     * Initializes a list with cases to merge for a down move .
     *
     * @param casesToMerge a case list .
     * @param column       a integer .
     */
    private void initListMoveDown(List<Case> casesToMerge, int column) {
        if(casesToMerge == null){
            throw new IllegalArgumentException("The list of cases to merge is null ");
        }
        for (int line = gameTable.length - 1; line >= 0; line--) {
            casesToMerge.add(gameTable[line][column]);
        }
    }

    /**
     * Initializes a list with cases to merge for a right move .
     *
     * @param casesToMerge a case list .
     * @param line         an integer .
     */
    private void initListMoveRight(List<Case> casesToMerge, int line) {
        if(casesToMerge == null){
            throw new IllegalArgumentException("The list of cases to merge is null ");
        }
        for (int column = gameTable[line].length - 1; column >= 0; column--) {
            casesToMerge.add(gameTable[line][column]);
        }
    }

    /**
     * Initializes the board with a random non-empty case.
     */
    private void initializeBoard() {
        for (int line = 0; line < HEIGHT; line++) {
            for (int column = 0; column < HEIGHT; column++) {
                this.gameTable[line][column] = new Case(line, column);
                this.history[line][column] = new Case(line, column);
            }
        }
        this.initializeRandomCase();
    }

    /**
     * Initializes a random empty case with the value 2 or 4 (the chance for a 2 is 90% and 10% for a 4).
     */
    void initializeRandomCase() {
        Random random = new Random();
        List<Case> listEmptyCase = new LinkedList<>();
        for (Case[] cases : this.gameTable) {
            for (Case aCase : cases) {
                if (aCase.isEmpty()) {
                    listEmptyCase.add(aCase);
                }
            }
        }
        double value = random.nextDouble();
        Case randomCase = listEmptyCase.get(random.nextInt(listEmptyCase.size()));
        this.gameTable[randomCase.getLine()][randomCase.getColumn()].setValue(value >= 0.9 ? 4 : 2);
    }

    /**
     * Checks if the game board is full with non-empty cases.
     *
     * @param gameBoard a 2D array of case.
     * @return true if game board is full ,false otherwise.
     */
    boolean isFull(Case[][] gameBoard) {
        if (gameBoard == null){
            throw new IllegalArgumentException("Game board is null");
        }
        for (Case[] cases : gameBoard) {
            for (Case aCase : cases) {
                if (aCase.isEmpty()) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Return a copy of gale table .
     *
     * @return the game table .
     */
    Case[][] getGameTable() {
        return new Board(this).gameTable;
    }

    /**
     * Compares the game table with his history and returns true if they are the same .
     *
     * @return true if game table is equal to his history ,false otherwise .
     */
    boolean compareBoard() {
        for (int line = 0; line < history.length; line++) {
            for (int column = 0; column < history[line].length; column++) {
                if (gameTable[line][column].getValue() != history[line][column].getValue()) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Checks if the board contains a case with winner value .
     *
     * @param boardToCheck a 2D array of case .
     * @return true if the board contains a case with winner value .
     */
    boolean containsWinnerValue(Case[][] boardToCheck) {
        if(boardToCheck == null){
            throw new IllegalArgumentException("Board to check  is null ");
        }
        int row = 0;
        int column = 0;
        while (row < boardToCheck.length) {
            while (column < boardToCheck[row].length) {
                if (boardToCheck[row][column].getValue() == WINNING_CASE_VALUE) {
                    return true;
                }
                column++;
            }
            column = 0;
            row++;
        }
        return false;
    }
}
