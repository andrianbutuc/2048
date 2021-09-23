package Main;

import controller.ControllerJavaFx;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.Game;
import model.Game2048;
import view.JavaFx.MainView;

public class Main2048JavaFx extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage)  {
        primaryStage.setTitle(" Game 2048");
        primaryStage.centerOnScreen();
        Game game = new Game2048();
        MainView root = new MainView(game.getBoard());

        ControllerJavaFx controllerJavaFx = new ControllerJavaFx(root,game);
        root.createEvents(controllerJavaFx);
        root.addEvents();

        game.addObserver(root);
        root.setMaxWidth(1000);
        root.setMaxHeight(750);

        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();

    }
}
