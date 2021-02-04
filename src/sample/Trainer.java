package sample;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;
import sample.Selectors.TrainerSelector;

import java.util.ArrayList;
import java.util.Collection;

public class Trainer extends ImageView {

    private int money = 0;

    private ArrayList<Image> images;

    private Timeline startTimer = new Timeline();

    private Pokemon firePokemon;
    private Pokemon waterPokemon;
    private Pokemon grassPokemon;

    public Trainer(TrainerSelector trainerSelector, boolean isEnemy) {

        this.images = trainerSelector.getFrames();
        if (!isEnemy) {
            relocate(0, 63);
            generateStartTimer();
            setImage(images.get(0));
        } else {
            relocate(210, 30);
            setImage(trainerSelector.getFrontImage());
        }

    }

    public void generateStartTimer() {
        startTimer.setCycleCount(1);
        startTimer.setAutoReverse(false);
        final Collection<KeyFrame> frames = startTimer.getKeyFrames();
        Duration frameGap = Duration.millis(150);
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
}
