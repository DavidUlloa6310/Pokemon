package sample;

import javafx.animation.FadeTransition;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;
import sample.Selectors.POKEMON;
import sample.Selectors.TYPE;

import java.util.ArrayList;
import java.util.Collection;

public class Pokemon extends ImageView {

    TYPE type;
    boolean isEnemy;

    POKEMON pokemon;

    //ANIMATIONS
    private ArrayList<Image> images = new ArrayList<Image>();

    final Timeline attackAnimation = new Timeline();
    final Timeline hurtAnimation = new Timeline();
    final FadeTransition fadeTransition = new FadeTransition();
    final FadeTransition deathTransition = new FadeTransition();

    public Pokemon(POKEMON pokemonSprites, boolean isEnemy) {
        this.isEnemy = isEnemy;

        setPokemon(pokemonSprites);

        setVisible(false);

        generateAttackAnimation();
        generateSpawnAnimation();
        generateHurtAnimation();
    }

    private void generateAttackAnimation() {
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

    private void generateSpawnAnimation() {
        fadeTransition.setNode(this);
        fadeTransition.setDuration(new Duration(1000));
        fadeTransition.setFromValue(0);
        fadeTransition.setToValue(1);
        fadeTransition.setCycleCount(1);
        fadeTransition.setAutoReverse(false);
    }

    private void generateHurtAnimation() {
        hurtAnimation.setCycleCount(2);
        hurtAnimation.setAutoReverse(false);
        final Collection<KeyFrame> frames = hurtAnimation.getKeyFrames();
        Duration frameGap = Duration.millis(256);
        Duration frameTime = Duration.ZERO;

        if (isEnemy) {
            frameTime = frameTime.add(frameGap);
            frames.add(new KeyFrame(frameTime, e-> setImage(pokemon.getHurtEnemy())));
        } else {
            frameTime = frameTime.add(frameGap);
            frames.add(new KeyFrame(frameTime, e-> setImage(pokemon.getHurtPlayer())));
        }

        frameTime = frameTime.add(frameGap);
        frames.add(new KeyFrame(frameTime, e-> setImage(images.get(0))));

    }

    public void setPokemon(POKEMON pokemonSprites) {
        if (isEnemy) {
            images = pokemonSprites.getEnemyImages();
            relocate(140, 30);
        } else {
            images = pokemonSprites.getPlayerImages();
            relocate(55, 63);
        }

        type = pokemonSprites.getType();
        pokemon = pokemonSprites;

        generateAttackAnimation();
        generateSpawnAnimation();

        setImage(images.get(0));
    }

    public void startAttackTimer() {
        attackAnimation.play();
    }

    public void startSpawnAnimation() {
        fadeTransition.play();
    }

    public void startHurtAnimation() {
        hurtAnimation.play();
    }

    public Timeline getAttackAnimation() {
        return attackAnimation;
    }

    public FadeTransition getFadeTransition() {
        return fadeTransition;
    }

    public Timeline getHurtAnimation() {
        return hurtAnimation;
    }

    public TYPE getType() {
        return type;
    }
}
