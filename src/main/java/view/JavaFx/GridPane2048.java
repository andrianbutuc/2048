package view.JavaFx;

import javafx.scene.layout.GridPane;
import model.Case;

/**
 * The board representation of game 2048 .
 */
class GridPane2048 extends GridPane {
    private final Case2048[][] cases;

    /**
     * Constructs the board using cases .
     *
     * @param cases a 2D array of case .
     */
    GridPane2048(Case[][] cases) {
        this.cases = new Case2048[cases.length][cases.length];
        initialize(cases);
        this.setVgap(5);
        this.setHgap(5);
        this.setStyle("-fx-padding: 5;" +
                "-fx-border-style: solid inside;" +
                "-fx-border-width: 2;" +
                "-fx-border-insets: 5;" +
                "-fx-border-radius: 5;" +
                "-fx-border-color: #292F33;" +
                "-fx-background-color: #CCD6DD;");
    }

    /**
     * Initializes the cases of game .
     * @param cases a 2D array of case .
     */
    private void initialize(Case[][] cases) {
        for (int row = 0; row < cases.length; row++) {
            for (int column = 0; column < cases.length; column++) {
                this.cases[row][column] = new Case2048(String.valueOf(cases[row][column].getValue()));
                this.add(this.cases[row][column], row, column);

            }
        }
    }

    /**
     * Updates all game cases .
     * @param cases a 2D array of case .
     */
    void updateAll(Case[][] cases) {
        for (int row = 0; row < cases.length; row++) {
            for (int column = 0; column < cases[row].length; column++) {
                String stringValue = String.valueOf(cases[row][column].getValue());
                this.cases[row][column].updateCase(stringValue);
            }
        }
    }
}
