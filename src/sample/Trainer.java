package sample;

import javafx.animation.FadeTransition;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;
import sample.Selectors.POKEMON;
import sample.Selectors.TRAINER;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Random;

public class Trainer extends ImageView {

    private int money = 0;
    private double health = 1;
    private boolean isEnemy;
    private TRAINER trainer;

    private Random random = new Random();

    private ArrayList<Image> images;

    private Timeline startTimer = new Timeline();
    private FadeTransition loseTimer = new FadeTransition();
    private FadeTransition spawnTimer = new FadeTransition();

    private POKEMON firePokemon = POKEMON.CHARMANDER;
    private POKEMON waterPokemon = POKEMON.SQUIRTLE;
    private POKEMON grassPokemon = POKEMON.BULBOSAUR;

    public Trainer(TRAINER TRAINER, boolean isEnemy) {

        this.trainer = TRAINER;
        this.isEnemy = isEnemy;

        this.images = TRAINER.getFrames();
        if (!isEnemy) {
            relocate(0, 63);
            generateStartTimer();
            setImage(images.get(0));
        } else {
            relocate(210, 30);
            setImage(TRAINER.getFrontImage());
        }

        generateLoseTimeline();
        generateSpawnTimeline();
    }

    public POKEMON getRandomPokemon() {
        int randomNum = random.nextInt(3);
        POKEMON pokemon;
        switch (randomNum) {
            case 0:
                return firePokemon;
            case 1:
                return grassPokemon;
            default:
                return waterPokemon;
        }
    }

    public void removeHealth(double health) {
        if (health > 1 || health < 0)
            return;
        this.health = this.health - health;
    }

    private void generateStartTimer() {
        startTimer.setCycleCount(1);
        startTimer.setAutoReverse(true);
        final Collection<KeyFrame> frames = startTimer.getKeyFrames();
        Duration frameGap = Duration.millis(100);
        Duration frameTime = Duration.ZERO;

        for (Image image : images) {
            frameTime = frameTime.add(frameGap);
            frames.add(new KeyFrame(frameTime, e-> setImage(image)));
        }

        frames.add(new KeyFrame(frameTime, e->setImage(images.get(0))));
    }

    private void generateLoseTimeline() {
        loseTimer.setNode(this);
        loseTimer.setDuration(new Duration(750));
        loseTimer.setFromValue(1);
        loseTimer.setToValue(0);
        loseTimer.setCycleCount(1);
        loseTimer.setAutoReverse(false);
        loseTimer.setDelay(Duration.millis(1000));
        loseTimer.setOnFinished(e -> startSpawnTimer());
    }

    private void generateSpawnTimeline() {
        spawnTimer.setNode(this);
        spawnTimer.setDuration(new Duration(750));
        spawnTimer.setFromValue(0);
        spawnTimer.setToValue(1);
        spawnTimer.setCycleCount(1);
        spawnTimer.setAutoReverse(false);
        spawnTimer.setDelay(Duration.millis(1000));
    }

    public void reset() {

        if (isEnemy) {
            this.trainer = TRAINER.getRandomTrainer();
            this.images = trainer.getFrames();
            generateStartTimer();
            setImage(trainer.getFrontImage());
        }

        health = 1;

    }

    public void startStartTimer() {
        startTimer.play();
    }

    public void startDespawnTimer() {
        loseTimer.play();
    }

    public void startSpawnTimer() {
        spawnTimer.play();
    }

    public Timeline getStartTimer() {
        return startTimer;
    }

    public FadeTransition getLoseTimer() {
        return loseTimer;
    }

    public FadeTransition getSpawnTimer() {
        return spawnTimer;
    }

    public POKEMON getFirePokemon() {
        return firePokemon;
    }

    public POKEMON getWaterPokemon() {
        return waterPokemon;
    }

    public POKEMON getGrassPokemon() {
        return grassPokemon;
    }

    public double getHealth() {
        return health;
    }
}
