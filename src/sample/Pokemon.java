package sample;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;
import sample.Selectors.PokemonSelector;

import java.util.Collection;

public class Pokemon extends ImageView {
    private final Image frontImageOne;
    private final Image frontImageTwo;

    private final Image backImageOne;
    private final Image backImageTwo;

    final Timeline backTimer = new Timeline();
    final Timeline frontTimer = new Timeline();

    public Pokemon(PokemonSelector pokemonSprites) {
        frontImageOne = pokemonSprites.getFrontImageOne();
        frontImageTwo = pokemonSprites.getFrontImageTwo();

        backImageOne = pokemonSprites.getBackImageOne();
        backImageTwo = pokemonSprites.getBackImageTwo();

        generateBackTimer();
        generateFrontTimer();
    }

    private void generateBackTimer() {
        backTimer.setCycleCount(1);
        backTimer.setAutoReverse(false);
        final Collection<KeyFrame> frames = backTimer.getKeyFrames();
        Duration frameGap = Duration.millis(256);
        Duration frameTime = Duration.ZERO;

        frameTime = frameTime.add(frameGap);
        frames.add(new KeyFrame(frameTime, e-> setImage(backImageTwo)));

        frameTime = frameTime.add(frameGap);
        frames.add(new KeyFrame(frameTime, e-> setImage(backImageOne)));
    }

    private void generateFrontTimer() {
        frontTimer.setCycleCount(1);
        frontTimer.setAutoReverse(false);
        final Collection<KeyFrame> frames = frontTimer.getKeyFrames();
        Duration frameGap = Duration.millis(256);
        Duration frameTime = Duration.ZERO;

        frameTime = frameTime.add(frameGap);
        frames.add(new KeyFrame(frameTime, e-> setImage(frontImageOne)));

        frameTime = frameTime.add(frameGap);
        frames.add(new KeyFrame(frameTime, e-> setImage(frontImageTwo)));

        frameTime = frameTime.add(frameGap);
        frames.add(new KeyFrame(frameTime, e-> setImage(frontImageOne)));
    }

    public void showFront() {
        setImage(frontImageOne);
    }

    public void showBack() {
        setImage(backImageOne);
    }

    public void startBackTimer() {
        backTimer.play();
    }

    public void startFrontTimer() {
        frontTimer.play();
    }

}
