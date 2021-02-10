package sample.Selectors;

import javafx.scene.image.Image;

public enum BACKGROUND {

    GRASS("resources/images/backgrounds/battleBackgrounds/greenBackground.png"), GHOST("resources/images/backgrounds/battleBackgrounds/ghostBackground.png"), GROUND("resources/images/backgrounds/battleBackgrounds/groundBackground.png"),
    PSYCHIC("resources/images/backgrounds/battleBackgrounds/purpleBackground.png");

    private final Image backgroundImage;

    BACKGROUND(String imagePath) {
        backgroundImage = new Image(imagePath);
    }

    public Image getBackgroundImage() {
        return backgroundImage;
    }
}
