package sample;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;
import sample.Selectors.PokemonSelector;

import java.util.ArrayList;
import java.util.Collection;

public class Pokemon extends ImageView {

    private ArrayList<Image> images = new ArrayList<Image>();

    final Timeline attackAnimation = new Timeline();

    public Pokemon(PokemonSelector pokemonSprites, boolean isEnemy) {

        if (isEnemy) {
            images = pokemonSprites.getEnemyImages();
            relocate(140, 30);
        } else {
            images = pokemonSprites.getPlayerImages();
            relocate(55, 63);
        }

        setImage(images.get(0));

        generateAttackTimer();
    }

    private void generateAttackTimer() {
        attackAnimation.setCycleCount(1);
        attackAnimation.setAutoReverse(false);
        final Collection<KeyFrame> frames = attackAnimation.getKeyFrames();
        Duration frameGap = Duration.millis(256);
        Duration frameTime = Duration.ZERO;

        for (Image image : images) {
            frameTime = frameTime.add(frameGap);
            frames.add(new KeyFrame(frameTime, e-> setImage(image)));
        }

        frameTime = frameTime.add(frameGap);
        frames.add(new KeyFrame(frameTime, e-> setImage(images.get(0))));
    }

    public void startAttackTimer() {
        attackAnimation.play();
    }

}
