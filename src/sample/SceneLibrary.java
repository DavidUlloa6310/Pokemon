package sample;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public abstract class SceneLibrary {
    private static Stage primaryStage;
    private static Parent menuRoot;
    private static Parent battleRoot;

    public static void setPrimaryStage(Stage primaryStage) {
        SceneLibrary.primaryStage = primaryStage;
        primaryStage.setResizable(false);
        primaryStage.setTitle("Pokemon!");
    }

    public static void setMenuRoot(Parent root) {
        SceneLibrary.menuRoot = root;
    }

    public static void setBattleRoot(Parent root) {
        SceneLibrary.battleRoot = root;
    }

    public static void startBattle() {
        primaryStage.setScene(new Scene(battleRoot, 245, 384));
    }

    public static void startMenu() {
        primaryStage.setScene(new Scene(menuRoot, 245, 384));
    }
}
