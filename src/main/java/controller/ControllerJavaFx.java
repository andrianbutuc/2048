package controller;

import model.Direction;
import model.Game;
import view.JavaFx.MainView;

/**
 * The controller of game with javafx view .
 */
public class ControllerJavaFx {
    private final MainView view;
    private final Game game;

    /**
     * Constructs the javafx controller .
     * @param view a MainView .
     * @param game a Game .
     */
    public ControllerJavaFx(MainView view, Game game) {
        this.view = view;
        this.game = game;
    }

    /**
     * Makes a move in the indicated direction ,if an error appeared print a error message .
     * @param directionMove a direction .
     */
    public void makeMove(Direction directionMove) {
        try {
            this.game.move(directionMove);
        } catch (IllegalArgumentException e) {
            view.printError(e.getMessage());
            e.printStackTrace();
        }
    }

    /**
     * Restarts the game .
     */
    public void restart() {
        this.game.restart();
        this.view.addEvents();
    }
}

