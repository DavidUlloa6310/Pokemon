package sample;

import javafx.animation.ParallelTransition;
import javafx.animation.PauseTransition;
import javafx.animation.SequentialTransition;
import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import sample.Selectors.POKEMON;
import sample.Selectors.TRAINER;
import sample.Selectors.TYPE;

public class BattleController {

    private final Group layout = new Group();

    private final Point playerTrainerPos = new Point(0, 63);
    private final Point playerTrainerPokemon =  new Point(55, 63);

    private Pokemon friendlyPokemon;
    private Pokemon enemyPokemon;

    private Trainer trainer;
    private Trainer enemyTrainer;

    private final SequentialTransition sequentialTransition = new SequentialTransition();
    private final ParallelTransition despawnPokemon = new ParallelTransition();
    private final PauseTransition showPokemon = new PauseTransition();
    private final PauseTransition checkDamage = new PauseTransition();

    private Rectangle playerHealth;
    private Rectangle enemyHealth;

    private final Point enemyTrainerPos = new Point(210, 30);
    private final Point enemyTrainerPokemon = new Point(140, 20);

    @FXML
    private Pane topPane;

    @FXML
    private ImageView fightButton;

    @FXML
    private ImageView runButton;

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

        trainer = new Trainer(TRAINER.MALE_TRAINER, false);
        enemyTrainer = new Trainer(TRAINER.FEMALE_TRAINER, true);

        friendlyPokemon = new Pokemon(POKEMON.BULBOSAUR, false);
        enemyPokemon = new Pokemon(POKEMON.BULBOSAUR, true);

        layout.getChildren().addAll(enemyTrainer, trainer, friendlyPokemon, enemyPokemon);
        topPane.getChildren().add(layout);

        changePlayerHealth(trainer.getHealth());
        changeEnemyHealth(enemyTrainer.getHealth());

        showPokemon.setOnFinished(e -> {
            friendlyPokemon.setVisible(true);
            enemyPokemon.setVisible(true);
        });

        despawnPokemon.getChildren().addAll(friendlyPokemon.getDespawnTransition(), enemyPokemon.getDespawnTransition());

        sequentialTransition.getChildren().addAll(trainer.getStartTimer(), showPokemon, friendlyPokemon.getSpawnTransition(), friendlyPokemon.getAttackAnimation(), enemyPokemon.getSpawnTransition(), enemyPokemon.getAttackAnimation(), checkDamage, despawnPokemon);

        sequentialTransition.setOnFinished(e -> {
            fightButton.setVisible(true);
            runButton.setVisible(true);
        });

        checkDamage.setOnFinished(e -> {
            checkWin(friendlyPokemon.getType(), enemyPokemon.getType());
        });
    }

    public void fight() {
        if (fightButton.isVisible()) {
            fightButton.setVisible(false);
            runButton.setVisible(false);
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

            friendlyPokemon.setPokemon(trainer.getFirePokemon());
            enemyPokemon.setPokemon(enemyTrainer.getRandomPokemon());

            sequentialTransition.play();
        }
    }

    public void waterClick() {
        if (waterButton.isVisible()) {
            fireButton.setVisible(false);
            waterButton.setVisible(false);
            grassButton.setVisible(false);

            friendlyPokemon.setPokemon(trainer.getWaterPokemon());
            enemyPokemon.setPokemon(enemyTrainer.getRandomPokemon());

            sequentialTransition.play();
        }
    }

    public void grassClick() {
        if (grassButton.isVisible()) {
            fireButton.setVisible(false);
            waterButton.setVisible(false);
            grassButton.setVisible(false);

            friendlyPokemon.setPokemon(trainer.getGrassPokemon());
            enemyPokemon.setPokemon(enemyTrainer.getRandomPokemon());

            sequentialTransition.play();
        }
    }

    public void checkWin(TYPE player, TYPE enemy) {
        if ((player == TYPE.FIRE && enemy == TYPE.GRASS) || (player == TYPE.WATER && enemy == TYPE.FIRE) || (player == TYPE.GRASS && enemy == TYPE.WATER)) {
            enemyTrainer.removeHealth(.25);
            enemyPokemon.startHurtAnimation();
            changeEnemyHealth(enemyTrainer.getHealth());
        } else if ((player == TYPE.FIRE && enemy == TYPE.WATER) || (player == TYPE.GRASS && enemy == TYPE.FIRE) || (player == TYPE.WATER && enemy == TYPE.GRASS)) {
            trainer.removeHealth(.25);
            friendlyPokemon.startHurtAnimation();
            changePlayerHealth(trainer.getHealth());

        }
    }

    public void changePlayerHealth(double amountPercent) {

        topPane.getChildren().remove(playerHealth);

        if (amountPercent > 1 || amountPercent < 0)
            return;

        int amount = (int) (amountPercent * 45);

        Color color;

        if (amountPercent >= .66) {
            color = Color.DARKGREEN;
        } else if (amountPercent >= .33) {
            color = Color.GOLD;
        } else {
            color = Color.DARKRED;
        }

        playerHealth = new Rectangle(195, 124, amount, 2);
        playerHealth.setFill(color);
        topPane.getChildren().add(playerHealth);
    }

    public void changeEnemyHealth(double amountPercent) {

        topPane.getChildren().remove(enemyHealth);

        if (amountPercent > 1 || amountPercent < 0)
            return;

        int amount = (int) (amountPercent * 46);

        Color color;

        if (amountPercent >= .66) {
            color = Color.DARKGREEN;
        } else if (amountPercent >= .33) {
            color = Color.GOLD;
        } else {
            color = Color.DARKRED;
        }

        enemyHealth = new Rectangle(26, 47, amount, 2);
        enemyHealth.setFill(color);
        topPane.getChildren().add(enemyHealth);
    }

}
