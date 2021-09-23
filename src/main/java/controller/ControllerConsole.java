package controller;

import model.Game;
import model.Game2048;
import view.Console.ViewConsole;
import view.Console.View2048;

/**
 * This class represents the controller of game 2048.
 */
public class ControllerConsole {
    private final ViewConsole view;
    private final Game game;

    /**
     * Constructs a controller of game 2048
     */
    public ControllerConsole() {
        this.view = new View2048();
        this.game = new Game2048();
    }

    /**
     * Plays the game 2048 .
     */
    public void play() {
        boolean play = true;
        while (play) {
            this.view.printMessage("Le game board 2048");
            this.view.printBoard(this.game.getBoard());
            this.view.printScore(this.game.getScore());
            this.view.printMenu();
            try {
                this.game.move(this.view.askDirection());
            } catch (Exception e) {
                this.view.printMessage(e.getMessage());
            }
            if (!this.game.boardIsFull() && !this.game.compareBoard()) {
                this.game.initializeRandomCase();
            }
            if (this.game.isWon() || this.game.isLost()) {
                play = false;
            }
        }
        if (this.game.isWon()) {
            this.view.printMessage("Le joueur a gagné ");
        } else {
            this.view.printMessage("Le joueur a perdu ");
        }
    }
}