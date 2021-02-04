package sample;

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
    private Random random = new Random();

    private ArrayList<Image> images;

    private Timeline startTimer = new Timeline();

    private POKEMON firePokemon = POKEMON.CHARMANDER;
    private POKEMON waterPokemon = POKEMON.SQUIRTLE;
    private POKEMON grassPokemon = POKEMON.BULBOSAUR;

    public Trainer(TRAINER TRAINER, boolean isEnemy) {

        this.images = TRAINER.getFrames();
        if (!isEnemy) {
            relocate(0, 63);
            generateStartTimer();
            setImage(images.get(0));
        } else {
            relocate(210, 30);
            setImage(TRAINER.getFrontImage());
        }

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

    public void generateStartTimer() {
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

    public void startTimer() {
        startTimer.play();
    }

    public Timeline getStartTimer() {
        return startTimer;
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
