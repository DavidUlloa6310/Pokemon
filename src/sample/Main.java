package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent menuRoot = FXMLLoader.load(getClass().getResource("FXMLfiles/menu.fxml"));
        Parent battleRoot = FXMLLoader.load(getClass().getResource("FXMLfiles/battle.fxml"));

        SceneLibrary.setPrimaryStage(primaryStage);
        SceneLibrary.setMenuRoot(menuRoot);
        SceneLibrary.setBattleRoot(battleRoot);

        SceneLibrary.startBattle();
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
