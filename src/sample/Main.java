package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent menuRoot = FXMLLoader.load(getClass().getResource("FXMLfiles/menu.fxml"));
        Parent endlessRoot = FXMLLoader.load(getClass().getResource("FXMLfiles/endless.fxml"));
        Parent campaignRoot = FXMLLoader.load(getClass().getResource("FXMLfiles/campaign.fxml"));

        SceneLibrary.setPrimaryStage(primaryStage);
        SceneLibrary.setMenuRoot(menuRoot);
        SceneLibrary.setCampaignRoot(campaignRoot);
        SceneLibrary.setEndlessRoot(endlessRoot);

        SceneLibrary.startMenu();
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
