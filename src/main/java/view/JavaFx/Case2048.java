package view.JavaFx;

import javafx.scene.control.Label;

/**
 * The case representation of game 2048 .
 */
class Case2048 extends Label {
    /**
     * Constructs a case with a value inside .
     * @param value a string .
     */
    Case2048(String value) {
        this.setText(value);
        this.updateColor(value);
        this.setPrefSize(100, 100);
    }

    /**
     * Updates the case value and color .
     * @param newValue a string
     */
    void updateCase(String newValue) {
        this.setText(newValue);
        this.updateColor(newValue);
    }

    /**
     * Updates the color of the case depending of his value .
     * @param value a string .
     */
    private void updateColor(String value) {
        switch (value) {
            case "2":
                this.setStyle(" -fx-font-size: 30;" +
                        "-fx-alignment:center;" +
                        "-fx-background-color:rgb(238,228,218)");
                break;
            case "4":
                this.setStyle(" -fx-font-size: 30;" +
                        "-fx-alignment:center;" +
                        "-fx-background-color:rgb(237,224,200)");
                break;
            case "8":
                this.setStyle(" -fx-font-size: 30;" +
                        "-fx-alignment:center;" +
                        "-fx-background-color:rgb(242,177,121)");
                break;
            case "16":
                this.setStyle(" -fx-font-size: 30;" +
                        "-fx-alignment:center;" +
                        "-fx-background-color:rgb(245,149,99)");
                break;
            case "32":

                this.setStyle(" -fx-font-size: 30;" +
                        "-fx-alignment:center;" +
                        "-fx-background-color:rgb(246,124,95)");
                break;
            case "64":

                this.setStyle(" -fx-font-size: 30;" +
                        "-fx-alignment:center;" +
                        "-fx-background-color:rgb(246,94,59)");
                break;
            case "128":
                this.setStyle(" -fx-font-size: 30;" +
                        "-fx-alignment:center;" +
                        "-fx-background-color:rgb(237,207,114)");
                break;
            case "256":
                this.setStyle(" -fx-font-size: 30;" +
                        "-fx-alignment:center;" +
                        "-fx-background-color:rgb(237,204,97)");
                break;
            case "512":
                this.setStyle(" -fx-font-size: 30;" +
                        "-fx-alignment:center;" +
                        "-fx-background-color:rgb(237,200,80)");
                break;
            case "1024":
                this.setStyle(" -fx-font-size: 30;" +
                        "-fx-alignment:center;" +
                        "-fx-background-color:rgb(237,197,63)");
                break;
            case "2048":
                this.setStyle(" -fx-font-size: 30;" +
                        "-fx-alignment:center;" +
                        "-fx-background-color:rgb(237,194,46)");
                break;
            default:
                this.setStyle(" -fx-font-size: 30;" +
                        "-fx-alignment:center;" + "-fx-background-color: #E1E8ED;");
        }
    }
}
