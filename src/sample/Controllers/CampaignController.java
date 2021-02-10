package sample.Controllers;

import javafx.animation.FadeTransition;
import javafx.animation.ParallelTransition;
import javafx.animation.PauseTransition;
import javafx.animation.SequentialTransition;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;
import sample.Player;
import sample.Pokemon;
import sample.SceneLibrary;
import sample.Selectors.ITEM;
import sample.Selectors.POKEMON;
import sample.Selectors.TRAINER;
import sample.Selectors.TYPE;
import sample.Trainer;

import javax.swing.*;

public class CampaignController {

    private final Group layout = new Group();

    private int level = 2;
    private boolean usedSpecial = false;

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

    @FXML
    private Pane topPane;

    @FXML
    private ProgressBar chargedAttackBar;
    private final DoubleProperty chargedValue = new SimpleDoubleProperty();
    private boolean hasChargedAttack = false;

    @FXML
    private ImageView fightButton;

    @FXML
    private ImageView chargeAttackButton;

    @FXML
    private ImageView runButton;

    @FXML
    private ImageView shopButton;

    @FXML
    private ImageView bagButton;

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
    private Label enemyLevel;

    @FXML
    private Label playerLevel;

    @FXML
    public void initialize() {

        generateProgressBar();

        enemyLevel.setText("" + level);
        playerLevel.setText("" + Player.getLevel());

        trainer = new Trainer(Player.getTrainerSprite(), false);
        enemyTrainer = new Trainer(TRAINER.getRandomTrainer(), true);

        friendlyPokemon = new Pokemon(POKEMON.BULBOSAUR, false);
        enemyPokemon = new Pokemon(POKEMON.BULBOSAUR, true);

        layout.getChildren().addAll(enemyTrainer, trainer, friendlyPokemon, enemyPokemon);
        topPane.getChildren().add(layout);

        changePlayerHealth(trainer.getHealth());
        changeEnemyHealth(enemyTrainer.getHealth());

        generateAnimations();

        generateEnemyTrainerLost();
        generateEnemyTrainerRespawn();
        generateFriendlyTrainerLost();
    }

    public void fight() {
        if (fightButton.isVisible()) {

            if (Player.getTrainerSprite() != trainer.getTrainer())
                trainer.changeTrainer(Player.getTrainerSprite());

            fightButton.setVisible(false);
            runButton.setVisible(false);
            bagButton.setVisible(false);
            shopButton.setVisible(false);

            fireButton.setVisible(true);
            waterButton.setVisible(true);
            grassButton.setVisible(true);
        }
    }

    public void chargeAttack() {
        if (chargedValue.get() >= 1) {
            hasChargedAttack = true;
            chargedAttackBar.setVisible(false);
            chargeAttackButton.setVisible(false);
            chargedValue.set(0);

            fight();
        }
    }

    public void fireClick() {
        if (fireButton.isVisible()) {
            fireButton.setVisible(false);
            waterButton.setVisible(false);
            grassButton.setVisible(false);
            chargedAttackBar.setVisible(false);
            chargeAttackButton.setVisible(false);

            friendlyPokemon.setPokemon(Player.getFireSprite());
            enemyPokemon.setPokemon(enemyTrainer.getRandomPokemon());

            checkPotion();
            textBoxLabel.setText("");
            battle.play();
        }
    }

    public void waterClick() {
        if (waterButton.isVisible()) {
            fireButton.setVisible(false);
            waterButton.setVisible(false);
            grassButton.setVisible(false);
            chargedAttackBar.setVisible(false);
            chargeAttackButton.setVisible(false);

            friendlyPokemon.setPokemon(Player.getWaterSprite());
            enemyPokemon.setPokemon(enemyTrainer.getRandomPokemon());

            checkPotion();
            textBoxLabel.setText("");
            battle.play();
        }
    }

    public void grassClick() {
        if (grassButton.isVisible()) {
            fireButton.setVisible(false);
            waterButton.setVisible(false);
            grassButton.setVisible(false);
            chargedAttackBar.setVisible(false);
            chargeAttackButton.setVisible(false);

            friendlyPokemon.setPokemon(Player.getGrassSprite());
            enemyPokemon.setPokemon(enemyTrainer.getRandomPokemon());

            checkPotion();
            textBoxLabel.setText("");
            battle.play();
        }
    }

    public void checkWin(TYPE player, TYPE enemy) {

        if ((player == TYPE.FIRE && enemy == TYPE.GRASS) || (player == TYPE.WATER && enemy == TYPE.FIRE) || (player == TYPE.GRASS && enemy == TYPE.WATER)) {

           playerWin(player, enemy);

        } else if ((player == TYPE.FIRE && enemy == TYPE.WATER) || (player == TYPE.GRASS && enemy == TYPE.FIRE) || (player == TYPE.WATER && enemy == TYPE.GRASS)) {

            enemyWin(player, enemy);

        } else {
            textBoxLabel.setText("Draw! Both you and your opponent played " + player + ".");
        }
    }

    public void playerWin(TYPE player, TYPE enemy) {
        double damage =  Player.calculateDamage(level, player);

        double critChance = .1;
        if (Player.isHasChoiceBand())
            critChance *= 2;

        if (Math.random() <= critChance) {
            damage = damage * 2;
            textBoxLabel.setText("You landed a critical hit and dealt extra damage!");
        } else {
            textBoxLabel.setText("You played " + player + ", while your opponent played " + enemy + ". You dealt damage.");
        }

        if (hasChargedAttack) {
            damage *= 3;
            hasChargedAttack = false;
        }

        enemyTrainer.removeHealth(damage);
        enemyPokemon.startHurtAnimation();
        changeEnemyHealth(enemyTrainer.getHealth());
    }

    public void enemyWin(TYPE player, TYPE enemy) {
        double damage = (double) 1 / level;

        double critChance = .1;
        if (level > 5)
            critChance *= 3;

        if (Math.random() <= critChance) {
            damage = damage * 2;
            textBoxLabel.setText("Your opponent landed a critical hit and dealt extra damage!");
        } else {
            textBoxLabel.setText("You played " + player + ", while your opponent played " + enemy + ". You took damage.");
        }

        trainer.removeHealth(damage);

        if (Player.isHasChoiceBand())
            chargedValue.set(chargedValue.get() + .5);
        else
            chargedValue.set(chargedValue.get() + .2);

        hasChargedAttack = false;
        friendlyPokemon.startHurtAnimation();
        changePlayerHealth(trainer.getHealth());
    }

    private void checkLost() {
        if (enemyTrainer.getHealth() <= 0) {
            int cash = enemyTrainer.generateCash(level);
            Player.addMoney(cash);
            textBoxLabel.setText("You have defeated the enemy trainer!\nEarned " + cash + " cash");
            enemyTrainer.startDespawnTimer();
            resetEnemy.play();

            level++;
            Player.increaseLevel();

            enemyLevel.setText("" + level);
            playerLevel.setText("" + Player.getLevel());

            Player.setHasUsedItem(false);

            return;
        }

        if (trainer.getHealth() <= 0) {
            friendlyTrainerLost.play();

            level = 2;
            enemyLevel.setText("" + level);
            chargedValue.set(0);
            Player.setHasUsedItem(false);
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

    public void generateAnimations() {
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
            bagButton.setVisible(true);
            shopButton.setVisible(true);
            chargedAttackBar.setVisible(true);
            chargeAttackButton.setVisible(true);
        });

        checkDamage.setOnFinished(e -> {
            checkWin(friendlyPokemon.getType(), enemyPokemon.getType());
            checkLost();
        });
    }

    public void generateProgressBar() {
        chargedAttackBar.setStyle("-fx-accent: orange;");
        chargedValue.setValue(0);
        chargedValue.addListener(new ChangeListener<Object>() {

            @Override
            public void changed(ObservableValue<?> observable, Object oldValue, Object newValue) {
                chargedAttackBar.progressProperty().bind(chargedValue);
            }
        });
    }

    public void generateEnemyTrainerLost() {
        enemyTrainerLost.setNode(topPane);
        enemyTrainerLost.setDuration(new Duration(500));
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
        friendlyTrainerLost.setToValue(1);
        friendlyTrainerLost.setCycleCount(1);
        friendlyTrainerLost.setAutoReverse(false);
        friendlyTrainerLost.setDelay(Duration.millis(1000));

        friendlyTrainerLost.setOnFinished(e -> {
            JOptionPane.showMessageDialog(null, "You blacked out");
            SceneLibrary.startMenu();
            trainer.reset();
            enemyTrainer.reset();
            changePlayerHealth(trainer.getHealth());
            changeEnemyHealth(trainer.getHealth());
            level = 1;
            textBoxLabel.setText("");
        });
    }

    public void checkPotion() {
        if (Player.getSelectedItem() == ITEM.POTION) {
            trainer.restoreHealth();
            changePlayerHealth(trainer.getHealth());
            Player.setSelectedItem(null);
        }
    }

    public void goToMenu() {
        SceneLibrary.startMenu();
    }

    public void goToShop() {
        SceneLibrary.startStore();
    }

    public void goToBag() {
        if (!Player.isHasUsedItem())
            SceneLibrary.startBag();
        else
            JOptionPane.showMessageDialog(null, "You have already activated an item for this round.");
    }

}
