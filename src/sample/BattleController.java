package sample;

import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import sample.Selectors.PokemonSelector;
import sample.Selectors.TrainerSelector;

public class BattleController {

    private final Group layout = new Group();

    private final Point playerTrainerPos = new Point(0, 63);
    private final Point playerTrainerPokemon =  new Point(55, 63);

    private Pokemon friendlyPokemon;
    private Pokemon enemyPokemon;

    private Trainer trainer;
    private Trainer enemyTrainer;

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
    private ImageView playerHealthBar;

    @FXML
    private ImageView enemyHealthBar;

    @FXML
    public void initialize() {

        trainer = new Trainer(TrainerSelector.FEMALE_TRAINER, false);
        enemyTrainer = new Trainer(TrainerSelector.FEMALE_TRAINER, true);

        friendlyPokemon = new Pokemon(PokemonSelector.BULBOSAUR, false);
        enemyPokemon = new Pokemon(PokemonSelector.BULBOSAUR, true);

        layout.getChildren().addAll(enemyTrainer, trainer, friendlyPokemon, enemyPokemon);
        topPane.getChildren().add(layout);

        changePlayerHealth(1);
        changeEnemyHealth(.2);
    }

    public void fight() {
        if (fightButton.isVisible()) {
            fightButton.setVisible(false);
            fireButton.setVisible(true);
            waterButton.setVisible(true);
            grassButton.setVisible(true);
            friendlyPokemon.startAttackTimer();
            trainer.startTimer();
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

    public void changePlayerHealth(double amountPercent) {

        if (amountPercent > 1 || amountPercent < 0)
            return;

        int amount = (int) (amountPercent * 45);

        Color color;

        if (amountPercent >= .66) {
            color = Color.DARKGREEN;
        } else if (amountPercent >= .33) {
            color = Color.GOLD;
        } else {
            color = Color.RED;
        }

        Rectangle health = new Rectangle(195, 124, amount, 2);
        health.setFill(color);
        topPane.getChildren().add(health);
    }

    public void changeEnemyHealth(double amountPercent) {

        if (amountPercent > 1 || amountPercent < 0)
            return;

        int amount = (int) (amountPercent * 46);

        Color color;

        if (amountPercent >= .66) {
            color = Color.DARKGREEN;
        } else if (amountPercent >= .33) {
            color = Color.GOLD;
        } else {
            color = Color.RED;
        }

        Rectangle health = new Rectangle(26, 47, amount, 2);
        health.setFill(color);
        topPane.getChildren().add(health);
    }

}
