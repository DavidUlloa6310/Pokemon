package sample;

import javafx.animation.FadeTransition;
import javafx.animation.ParallelTransition;
import javafx.animation.PauseTransition;
import javafx.animation.SequentialTransition;
import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;
import sample.Selectors.POKEMON;
import sample.Selectors.TRAINER;
import sample.Selectors.TYPE;

import javax.swing.*;

public class CampaignController {

    private final Group layout = new Group();

    private final Point playerTrainerPos = new Point(0, 63);
    private final Point playerTrainerPokemon =  new Point(55, 63);

    private Pokemon friendlyPokemon;
    private Pokemon enemyPokemon;

    private Trainer trainer;
    private Trainer enemyTrainer;

    private final SequentialTransition battle = new SequentialTransition();

    private final ParallelTransition despawnPokemon = new ParallelTransition();
    private final ParallelTransition spawnPokemon = new ParallelTransition();
    private final ParallelTransition attack = new ParallelTransition();

    private final PauseTransition showPokemon = new PauseTransition();
    private final PauseTransition checkDamage = new PauseTransition();

    private final FadeTransition enemyTrainerLost = new FadeTransition();
    private final FadeTransition enemyTrainerRespawn = new FadeTransition();
    private final SequentialTransition resetEnemy = new SequentialTransition(enemyTrainerLost, enemyTrainerRespawn);

    private final FadeTransition friendlyTrainerLost = new FadeTransition();

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

        //ANIMATIONS

        showPokemon.setOnFinished(e -> {
            friendlyPokemon.setVisible(true);
            enemyPokemon.setVisible(true);
        });

        despawnPokemon.getChildren().addAll(friendlyPokemon.getDespawnTransition(), enemyPokemon.getDespawnTransition());
        spawnPokemon.getChildren().addAll(friendlyPokemon.getSpawnTransition(), enemyPokemon.getSpawnTransition());
        attack.getChildren().addAll(friendlyPokemon.getAttackAnimation(), enemyPokemon.getAttackAnimation());

        battle.getChildren().addAll(trainer.getStartTimer(), showPokemon, spawnPokemon, attack, checkDamage, despawnPokemon);

        battle.setOnFinished(e -> {
            fightButton.setVisible(true);
            runButton.setVisible(true);
        });

        checkDamage.setOnFinished(e -> {
            checkWin(friendlyPokemon.getType(), enemyPokemon.getType());
        });

        generateEnemyTrainerLost();
        generateEnemyTrainerRespawn();
        generateFriendlyTrainerLost();
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

            battle.play();
        }
    }

    public void waterClick() {
        if (waterButton.isVisible()) {
            fireButton.setVisible(false);
            waterButton.setVisible(false);
            grassButton.setVisible(false);

            friendlyPokemon.setPokemon(trainer.getWaterPokemon());
            enemyPokemon.setPokemon(enemyTrainer.getRandomPokemon());

            battle.play();
        }
    }

    public void grassClick() {
        if (grassButton.isVisible()) {
            fireButton.setVisible(false);
            waterButton.setVisible(false);
            grassButton.setVisible(false);

            friendlyPokemon.setPokemon(trainer.getGrassPokemon());
            enemyPokemon.setPokemon(enemyTrainer.getRandomPokemon());

            battle.play();
        }
    }

    public void checkWin(TYPE player, TYPE enemy) {
        if ((player == TYPE.FIRE && enemy == TYPE.GRASS) || (player == TYPE.WATER && enemy == TYPE.FIRE) || (player == TYPE.GRASS && enemy == TYPE.WATER)) {
            enemyTrainer.removeHealth(1);
            enemyPokemon.startHurtAnimation();
            changeEnemyHealth(enemyTrainer.getHealth());
            if (enemyTrainer.getHealth() <= 0) {
                enemyTrainer.startDespawnTimer();
                resetEnemy.play();
            }
        } else if ((player == TYPE.FIRE && enemy == TYPE.WATER) || (player == TYPE.GRASS && enemy == TYPE.FIRE) || (player == TYPE.WATER && enemy == TYPE.GRASS)) {
            trainer.removeHealth(1);
            friendlyPokemon.startHurtAnimation();
            changePlayerHealth(trainer.getHealth());
            if (trainer.getHealth() <= 0) {
                friendlyTrainerLost.play();
            }
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

    public void generateEnemyTrainerLost() {
        enemyTrainerLost.setNode(topPane);
        enemyTrainerLost.setDuration(new Duration(750));
        enemyTrainerLost.setFromValue(1);
        enemyTrainerLost.setToValue(0);
        enemyTrainerLost.setCycleCount(1);
        enemyTrainerLost.setAutoReverse(false);
        enemyTrainerLost.setDelay(Duration.millis(1000));

        enemyTrainerLost.setOnFinished(e -> {
            enemyTrainer.reset();
            changeEnemyHealth(enemyTrainer.getHealth());
        });
    }

    public void generateEnemyTrainerRespawn() {
        enemyTrainerRespawn.setNode(topPane);
        enemyTrainerRespawn.setDuration(new Duration(750));
        enemyTrainerRespawn.setFromValue(0);
        enemyTrainerRespawn.setToValue(1);
        enemyTrainerRespawn.setCycleCount(1);
        enemyTrainerRespawn.setAutoReverse(false);
        enemyTrainerRespawn.setDelay(Duration.millis(1000));

        enemyTrainerRespawn.setOnFinished(e -> {
            enemyTrainer.startSpawnTimer();
        });
    }

    public void generateFriendlyTrainerLost() {
        friendlyTrainerLost.setNode(topPane);
        friendlyTrainerLost.setDuration(new Duration(750));
        friendlyTrainerLost.setFromValue(1);
        friendlyTrainerLost.setToValue(0);
        friendlyTrainerLost.setCycleCount(1);
        friendlyTrainerLost.setAutoReverse(false);
        friendlyTrainerLost.setDelay(Duration.millis(1000));

        friendlyTrainerLost.setOnFinished(e -> {
            JOptionPane.showMessageDialog(null, "You blacked out");
            SceneLibrary.startMenu();
        });
    }

}
