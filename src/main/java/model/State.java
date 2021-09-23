package model;

/**
 * This enum represents the states of game .
 */
public enum State {

    PLAYING(""),

    LOST("Partie perdu"),

    WON("Partie gagné"),

    WRONGMOVE("Mouvement impossible"),

    RESTART("Partie recommencer");

    private final String value;

    /**
     * Constructs the state .
     * @param message a string .
     */
    State(String message) {
        this.value = message;
    }

    /**
     * Returns the message of game state .
     * @return a string .
     */
    @Override
    public String toString() {
        return value;
    }
}
