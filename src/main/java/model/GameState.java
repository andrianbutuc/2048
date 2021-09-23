package model;

/**
 * This class represents a state of game at a certain time .
 */
public final class GameState {
    private final Case[][] board;
    private final int score;
    private final State state;
    /**
     * Constructs a the game state .
     *
     * @param board a 2D array of cases .
     * @param score an integer .
     * @param state a state enum .
     */
    GameState(Case[][] board, int score, State state) {
        if (board == null){
            throw new IllegalArgumentException("Board is null");
        }
        if (state == null){
            throw new IllegalArgumentException("State is null");
        }
        this.board = board;
        this.score = score;
        this.state = state;
    }

    /**
     * Gets the state .
     *
     * @return a state .
     */
    public State getState() {
        return state;
    }

    /**
     * Return the board .
     *
     * @return the board  .
     */
    public Case[][] getBoard() {
        return board;
    }

    /**
     * Returns the score of game .
     *
     * @return the score of game .
     */
    public int getScore() {
        return score;
    }

}
