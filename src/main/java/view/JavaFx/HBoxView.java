package view.JavaFx;

import javafx.scene.layout.HBox;
import model.Case;

/**
 * The HBox with the board and the message view of the game .
 */
class HBoxView extends HBox {
    private final GridPane2048 gameTable;
    private final MessageView messageView;

    /**
     * Constructs the board and message view using cases .
     *
     * @param cases a 2D array of case .
     */
    HBoxView(Case[][] cases) {
        gameTable = new GridPane2048(cases);
        messageView = new MessageView();
        this.getChildren().addAll(gameTable, messageView);
    }

    /**
     * Updates all cases of board .
     * @param cases a 2D array of case .
     */
    void updateCases(Case[][] cases) {
        gameTable.updateAll(cases);
    }

    /**
     * Returns the messageView .
     * @return messageView .
     */
    MessageView getMessageView() {
        return messageView;
    }

}
