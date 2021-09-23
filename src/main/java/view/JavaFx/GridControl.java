package view.JavaFx;

import DP.Observable;
import DP.Observer;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;

/**
 * The control part of view .
 */
public class GridControl extends GridPane implements Observer {
    private final Button restart;
    private final Label score;

    /**
     * Constructs the grid control .
     */
    GridControl() {
        this.restart = new Button("Restart");
        this.score = new Label("Score : 0 ");
        this.setStyle("-fx-padding: 5;" +
                "-fx-border-style: solid inside;" +
                "-fx-border-width: 2;" +
                "-fx-border-insets: 5;" +
                "-fx-border-radius: 5;" +
                "-fx-border-color: #292F33;" +
                "-fx-background-color: #CCD6DD;"+"-fx-padding : 10");
        this.add(restart,0 ,0);
        this.add(score,1,0);
        ColumnConstraints leftCol = new ColumnConstraints();
        leftCol.setHgrow(Priority.ALWAYS);
        this.getColumnConstraints().addAll(leftCol, new ColumnConstraints(), new ColumnConstraints());
    }

    /**
     * Returns the button restart .
     * @return a button .
     */
    Button getRestart() {
        return restart;
    }

    @Override
    public void update(Observable observable, Object arg) {
        int newScore = (int) arg;
        this.score.setText("Score : " + newScore);
    }
}
