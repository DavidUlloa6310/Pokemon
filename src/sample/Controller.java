package sample;

import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.text.Font;

import java.util.TimerTask;

public class Controller {

    private final Group layout = new Group();

    private final Point playerTrainerPos = new Point(0, 63);
    private final Point playerTrainerPokemon =  new Point(55, 63);

    private final Point enemyTrainerPos = new Point(210, 30);
    private final Point enemyTrainerPokemon = new Point(140, 20);

    @FXML
    private Pane topPane;

    @FXML
    private ImageView fightButton;

    @FXML
    private ImageView fireButton;

    @FXML
    private ImageView waterButton;

    @FXML
    private ImageView grassButton;

    @FXML
    private Label textBoxLabel;

    @FXML
    public void initialize() {

        ImageView trainer = new ImageView(new Image("resources/images/trainers/maleTrainer.png"));
        ImageView pokemon = new ImageView(new Image("resources/images/pokemon/back/bulbosaur_1.png"));


        ImageView enemyTrainer = new ImageView(new Image("resources/images/trainers/maleTrainerFront.png"));
        ImageView enemyPokemon = new ImageView(new Image("resources/images/pokemon/front/venosaur_1.png"));

        trainer.relocate(0, 63);
        pokemon.relocate(55, 63);
        enemyPokemon.relocate(140, 20);
        enemyTrainer.relocate(210, 30);

        layout.getChildren().addAll(enemyTrainer, trainer, pokemon, enemyPokemon);
        topPane.getChildren().add(layout);
    }

    public void fight() {
        if (fightButton.isVisible()) {
            fightButton.setVisible(false);
            fireButton.setVisible(true);
            waterButton.setVisible(true);
            grassButton.setVisible(true);
        }
    }

    public void fireClick() {
        if (fireButton.isVisible()) {
            fireButton.setVisible(false);
            waterButton.setVisible(false);
            grassButton.setVisible(false);
            fightButton.setVisible(true);
        }
    }

    public void waterClick() {
        if (waterButton.isVisible()) {
            fireButton.setVisible(false);
            waterButton.setVisible(false);
            grassButton.setVisible(false);
            fightButton.setVisible(true);
        }
    }

    public void grassClick() {
        if (grassButton.isVisible()) {
            fireButton.setVisible(false);
            waterButton.setVisible(false);
            grassButton.setVisible(false);
            fightButton.setVisible(true);
        }
    }

}
