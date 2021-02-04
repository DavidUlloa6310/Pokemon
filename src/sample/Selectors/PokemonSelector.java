package sample.Selectors;

import javafx.scene.image.Image;

import java.util.ArrayList;

public enum PokemonSelector {
    BULBOSAUR("resources/images/pokemon/enemy/bulbosaurOne.png", "resources/images/pokemon/enemy/bulbosaurTwo.png", "resources/images/pokemon/player/bulbosaurOne.png", "resources/images/pokemon/player/bulbosaurTwo.png");

    private final ArrayList<Image> playerImages = new ArrayList<Image>();
    private final ArrayList<Image> enemyImages = new ArrayList<Image>();

    PokemonSelector(String enemyImageOne, String enemyImageTwo, String playerImageOne, String playerImageTwo) {
        enemyImages.add(new Image(enemyImageOne));
        enemyImages.add(new Image(enemyImageTwo));
        playerImages.add(new Image(playerImageOne));
        playerImages.add(new Image(playerImageTwo));
    }

    public ArrayList<Image> getPlayerImages() {
        return playerImages;
    }

    public ArrayList<Image> getEnemyImages() {
        return enemyImages;
    }
}
