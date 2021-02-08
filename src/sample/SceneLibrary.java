package sample;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sample.Selectors.LOCATION;

public abstract class SceneLibrary {
    private static Stage primaryStage;

    private static Scene menuScene;
    private static Scene endlessScene;
    private static Scene campaignScene;
    private static Scene storeScene;
    private static Scene bagScene;

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

    public static void setStoreScene(Parent root) {
        storeScene = new Scene(root, 245, 384);
    }

    public static void setBagScene(Parent root) {
        bagScene = new Scene(root, 245, 384);
    }

    public static void startEndless() {
        Player.setLocation(LOCATION.ENDLESS);
        primaryStage.setScene(endlessScene);
    }

    public static void startCampaign() {
        Player.setLocation(LOCATION.CAMPAIGN);
        primaryStage.setScene(campaignScene);
    }

    public static void startMenu() {
        primaryStage.setScene(menuScene);
    }

    public static void startStore() {
        primaryStage.setScene(storeScene);
    }

    public static void startBag() {
        primaryStage.setScene(bagScene);
    }
}
