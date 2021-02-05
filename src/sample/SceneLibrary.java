package sample;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public abstract class SceneLibrary {
    private static Stage primaryStage;

    private static Scene menuScene;
    private static Scene endlessScene;
    private static Scene campaignScene;

    public static void setPrimaryStage(Stage primaryStage) {
        SceneLibrary.primaryStage = primaryStage;
        primaryStage.setResizable(false);
        primaryStage.setTitle("Pokemon!");
    }

    public static void setMenuRoot(Parent root) {
        menuScene = new Scene(root, 245, 384);
    }

    public static void setEndlessRoot(Parent root) {
        endlessScene = new Scene(root, 245, 384);
    }

    public static void setCampaignRoot(Parent root) {
        campaignScene = new Scene(root, 245, 384);
    }

    public static void startEndless() {
        primaryStage.setScene(endlessScene);
    }

    public static void startCampaign() {
        primaryStage.setScene(campaignScene);
    }

    public static void startMenu() {
        primaryStage.setScene(menuScene);
    }
}
