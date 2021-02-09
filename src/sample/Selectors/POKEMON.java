package sample.Selectors;

import javafx.scene.image.Image;

import java.util.ArrayList;

public enum POKEMON {

    VENOSAUR("resources/images/pokemon/hurt/venosaurOne.png", "resources/images/pokemon/hurt/venosaurTwo.png", "resources/images/pokemon/enemy/venosaurOne.png", "resources/images/pokemon/enemy/venosaurTwo.png", "resources/images/pokemon/player/venosaurOne.png", "resources/images/pokemon/player/venosaurTwo.png", TYPE.GRASS),
    CHARIZARD("resources/images/pokemon/hurt/charizardOne.png", "resources/images/pokemon/hurt/charizardTwo.png", "resources/images/pokemon/enemy/charizardOne.png", "resources/images/pokemon/enemy/charizardTwo.png", "resources/images/pokemon/player/charizardOne.png", "resources/images/pokemon/player/charizardTwo.png", TYPE.FIRE),
    BLASTOISE("resources/images/pokemon/hurt/blastoiseOne.png", "resources/images/pokemon/hurt/blastoiseTwo.png", "resources/images/pokemon/enemy/blastoiseOne.png", "resources/images/pokemon/enemy/blastoiseTwo.png", "resources/images/pokemon/player/blastoiseOne.png", "resources/images/pokemon/player/blastoiseTwo.png", TYPE.WATER),

    IVYSAUR("resources/images/pokemon/hurt/ivysaurOne.png", "resources/images/pokemon/hurt/ivysaurTwo.png", "resources/images/pokemon/enemy/ivysaurOne.png", "resources/images/pokemon/enemy/ivysaurTwo.png", "resources/images/pokemon/player/ivysaurOne.png", "resources/images/pokemon/player/ivysaurTwo.png", TYPE.GRASS, VENOSAUR),
    WARTORTLE("resources/images/pokemon/hurt/wartortleOne.png", "resources/images/pokemon/hurt/wartortleTwo.png", "resources/images/pokemon/enemy/wartortleOne.png", "resources/images/pokemon/enemy/wartortleTwo.png", "resources/images/pokemon/player/wartortleOne.png", "resources/images/pokemon/player/wartortleTwo.png", TYPE.WATER, BLASTOISE),
    CHARMELEON("resources/images/pokemon/hurt/charmeleonOne.png", "resources/images/pokemon/hurt/charmeleonTwo.png", "resources/images/pokemon/enemy/charmeleonOne.png", "resources/images/pokemon/enemy/charmeleonTwo.png", "resources/images/pokemon/player/charmeleonOne.png", "resources/images/pokemon/player/charmeleonTwo.png", TYPE.FIRE, CHARIZARD),


    BULBOSAUR("resources/images/pokemon/hurt/bulbosaurOne.png","resources/images/pokemon/hurt/bulbosaurTwo.png", "resources/images/pokemon/enemy/bulbosaurOne.png", "resources/images/pokemon/enemy/bulbosaurTwo.png", "resources/images/pokemon/player/bulbosaurOne.png", "resources/images/pokemon/player/bulbosaurTwo.png", TYPE.GRASS, IVYSAUR),
    CHARMANDER("resources/images/pokemon/hurt/charmanderOne.png", "resources/images/pokemon/hurt/charmanderTwo.png", "resources/images/pokemon/enemy/charmanderOne.png", "resources/images/pokemon/enemy/charmanderTwo.png", "resources/images/pokemon/player/charmanderOne.png", "resources/images/pokemon/player/charmanderTwo.png", TYPE.FIRE, CHARMELEON),
    SQUIRTLE("resources/images/pokemon/hurt/squirtleOne.png", "resources/images/pokemon/hurt/squirtleTwo.png", "resources/images/pokemon/enemy/squirtleOne.png", "resources/images/pokemon/enemy/squirtleTwo.png", "resources/images/pokemon/player/squirtleOne.png", "resources/images/pokemon/player/squirtleTwo.png", TYPE.WATER, WARTORTLE);


    private final ArrayList<Image> playerImages = new ArrayList<Image>();
    private final ArrayList<Image> enemyImages = new ArrayList<Image>();

    private final Image hurtEnemy;
    private final Image hurtPlayer;

    private POKEMON evolution;

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

    POKEMON(String hurtEnemy, String hurtPlayer, String enemyImageOne, String enemyImageTwo, String playerImageOne, String playerImageTwo, TYPE type, POKEMON evolution) {
        this(hurtEnemy, hurtPlayer, enemyImageOne, enemyImageTwo, playerImageOne, playerImageTwo, type);
        this.evolution = evolution;
    }

    public POKEMON getEvolution() {
        return evolution;
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
