package view.JavaFx;

import DP.Observable;
import DP.Observer;
import controller.ControllerJavaFx;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.VBox;
import model.Case;
import model.Direction;
import model.GameState;
import model.State;

/**
 * The main view of game 2048 version JavaFx .
 */
public class MainView extends VBox implements Observer, ViewJavaFx {

    private final HBoxView view;
    private final GridControl elementsControl;
    private EventHandler<KeyEvent> keyHandler;

    /**
     * Constructs the main view using board cases .
     *
     * @param cases a 2D array of case .
     */
    public MainView(Case[][] cases) {
        view = new HBoxView(cases);
        elementsControl = new GridControl();
        this.getChildren().addAll(view, elementsControl);
    }

    @Override
    public void createEvents(ControllerJavaFx controller) {
        keyHandler = event -> {
            if (event.getCode() == KeyCode.UP) {
                controller.makeMove(Direction.LEFT);
            } else if (event.getCode() == KeyCode.RIGHT) {
                controller.makeMove(Direction.DOWN);
            } else if (event.getCode() == KeyCode.DOWN) {
                controller.makeMove(Direction.RIGHT);
            } else if (event.getCode() == KeyCode.LEFT) {
                controller.makeMove(Direction.TOP);
            }
        };
        this.elementsControl.getRestart().addEventHandler(ActionEvent.ACTION, event -> controller.restart());
    }

    @Override
    public void addEvents() {
        if (keyHandler == null) {
            throw new IllegalArgumentException("Le gestionnaire n'est pas créé");
        }
        this.setOnKeyReleased(keyHandler);
    }

    @Override
    public void deleteEvents() {
        this.setOnKeyReleased(null);
    }

    @Override
    public void update(Observable observable, Object arg) {
        GameState gameState = (GameState) arg;
        if (gameState.getState() == State.LOST || gameState.getState() == State.WON) {
            deleteEvents();
        }
        view.updateCases(gameState.getBoard());
        MessageView messageView = this.view.getMessageView();
        messageView.update(observable, gameState.getState());
        elementsControl.update(observable, gameState.getScore());
    }

    @Override
    public void printError(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR, "Restart game if problem doesn't disappear");
        alert.setHeaderText("Game error");
        alert.setTitle("Game error");
        alert.showAndWait();

        System.err.println(message);
    }
}