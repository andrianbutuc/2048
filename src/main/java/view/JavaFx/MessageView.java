package view.JavaFx;

import DP.Observable;
import DP.Observer;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ListView;
import model.State;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * This class represents a part of  main view ,more specifically the view with a string messages in different situation
 * of game .
 */
class MessageView extends ListView<String> implements Observer {
    private final ObservableList<String> data = FXCollections.observableArrayList();

    /**
     * Constructs a message view .
     */
    MessageView() {
        this.setItems(data);
        Date date = new Date();
        DateFormat format = new SimpleDateFormat("HH : mm");
        data.add(format.format(date) + " - " + "Bienvenue au 2048");
        this.setStyle("-fx-padding: 10;" +
                "-fx-border-style: solid inside;" +
                "-fx-border-width: 2;" +
                "-fx-border-insets: 5;" +
                "-fx-border-radius: 5;" +
                "-fx-border-color: #292F33;" +
                "-fx-background-color: #CCD6DD;");
        this.setFocusTraversable(false);
    }

    @Override
    public void update(Observable observable, Object arg) {
        State state = (State) arg;
        if (state != State.PLAYING) {
            Date date = new Date();
            DateFormat format = new SimpleDateFormat("HH : mm");
            data.add(format.format(date) + " - " + state.toString());
        }
    }
}