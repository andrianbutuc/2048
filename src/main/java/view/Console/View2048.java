package view.Console;

import model.Case;
import model.Direction;

import java.util.Scanner;

/**
 * This class represents a implementation of interface view .
 */
public class View2048 implements ViewConsole {

    @Override
    public void printBoard(Case[][] board) {
        for (Case[] cases : board) {
            for (Case case_ : cases) {
                System.out.printf("%5d", case_.getValue());
            }
            System.out.println();
        }
    }

    /**
     * Reads an integer to keyboard .
     * @param message a string .
     * @return an integer .
     */
    private int readInt(String message) {
        Scanner kbd = new Scanner(System.in);
        this.printMessage(message);
        while (!kbd.hasNextInt()) {
            kbd.next();
            this.printError("Vous n'avez pas saisie un nombre entier ");
        }
        return kbd.nextInt();
    }

    @Override
    public Direction askDirection() {
        int result = this.readInt("Choisissez la direction ");
        while (result < 1 || result > 4) {
            printError("Valeur pas comprise entre 1 et 4 ");
            result = this.readInt("Choisissez la direction ");
        }
        Direction direction;
        switch (result) {
            case 1:
                direction = Direction.TOP;
                break;
            case 2:
                direction = Direction.DOWN;
                break;
            case 3:
                direction = Direction.LEFT;
                break;
            case 4:
                direction = Direction.RIGHT;
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + result);
        }
        return direction;
    }

    @Override
    public void printMessage(String message) {
        System.out.println(message);
    }

    @Override
    public void printMenu() {
        this.printMessage("Entrez une direction :");
        this.printMessage("1 -> un mouvement en haut");
        this.printMessage("2 -> un mouvement en bas");
        this.printMessage("3 -> un mouvement à gauche");
        this.printMessage("4 -> un mouvement à droit");
    }

    /**
     * Prints a error message .
     *
     * @param message a string .
     */
    void printError(String message) {
        System.err.println(message);
    }

    @Override
    public void printScore(int score) {
        System.out.println("Score : " + score);
    }
}
