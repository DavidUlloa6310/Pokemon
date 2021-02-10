package sample.Selectors;

import javafx.scene.image.Image;

public enum BACKGROUND {

    GRASS("grass"),
    GHOST("ghost"),
    GROUND("ground"),
    PSYCHIC("psychic"),
    DARK_GRASS("darkGrass"),
    DESERT("desert"),
    MUD("mud"),
    NORMAL("normal"),
    SNOW("snow"),
    UNDERGROUND("underground"),
    WATER("water");

    private final Image backgroundImage;

    BACKGROUND(String name) {
        backgroundImage = new Image("resources/images/backgrounds/battleBackgrounds/" + name + "Background.png");
    }

    public Image getBackgroundImage() {
        return backgroundImage;
    }
}
