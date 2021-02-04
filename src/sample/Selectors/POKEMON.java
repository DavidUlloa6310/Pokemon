package sample.Selectors;

import javafx.scene.image.Image;

import java.util.ArrayList;

public enum POKEMON {
    BULBOSAUR("resources/images/pokemon/hurt/bulbosaurOne.png","resources/images/pokemon/hurt/bulbosaurTwo.png", "resources/images/pokemon/enemy/bulbosaurOne.png", "resources/images/pokemon/enemy/bulbosaurTwo.png", "resources/images/pokemon/player/bulbosaurOne.png", "resources/images/pokemon/player/bulbosaurTwo.png", TYPE.GRASS),
    CHARMANDER("resources/images/pokemon/hurt/charmanderOne.png", "resources/images/pokemon/hurt/charmanderTwo.png", "resources/images/pokemon/enemy/charmanderOne.png", "resources/images/pokemon/enemy/charmanderTwo.png", "resources/images/pokemon/player/charmanderOne.png", "resources/images/pokemon/player/charmanderTwo.png", TYPE.FIRE),
    SQUIRTLE("resources/images/pokemon/hurt/squirtleOne.png", "resources/images/pokemon/hurt/squirtleTwo.png", "resources/images/pokemon/enemy/squirtleOne.png", "resources/images/pokemon/enemy/squirtleTwo.png", "resources/images/pokemon/player/squirtleOne.png", "resources/images/pokemon/player/squirtleTwo.png", TYPE.WATER);


    private final ArrayList<Image> playerImages = new ArrayList<Image>();
    private final ArrayList<Image> enemyImages = new ArrayList<Image>();

    private final Image hurtEnemy;
    private final Image hurtPlayer;

    private final TYPE type;

    POKEMON(String hurtEnemy, String hurtPlayer, String enemyImageOne, String enemyImageTwo, String playerImageOne, String playerImageTwo, TYPE type) {
        enemyImages.add(new Image(enemyImageOne));
        enemyImages.add(new Image(enemyImageTwo));
        playerImages.add(new Image(playerImageOne));
        playerImages.add(new Image(playerImageTwo));

        this.hurtEnemy = new Image(hurtEnemy);
        this.hurtPlayer = new Image(hurtPlayer);

        this.type = type;
    }

    public ArrayList<Image> getPlayerImages() {
        return playerImages;
    }

    public ArrayList<Image> getEnemyImages() {
        return enemyImages;
    }

    public Image getHurtEnemy() {
        return hurtEnemy;
    }

    public Image getHurtPlayer() {
        return hurtPlayer;
    }

    public TYPE getType() {
        return type;
    }
}
