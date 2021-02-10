package sample.Selectors;

import javafx.scene.image.Image;

import java.util.ArrayList;

public enum POKEMON {

    VENOSAUR("resources/images/pokemon/hurt/Starters/venosaurOne.png", "resources/images/pokemon/hurt/Starters/venosaurTwo.png", "resources/images/pokemon/enemy/Starters/venosaurOne.png", "resources/images/pokemon/enemy/Starters/venosaurTwo.png", "resources/images/pokemon/player/Starters/venosaurOne.png", "resources/images/pokemon/player/Starters/venosaurTwo.png", TYPE.GRASS),
    CHARIZARD("resources/images/pokemon/hurt/Starters/charizardOne.png", "resources/images/pokemon/hurt/Starters/charizardTwo.png", "resources/images/pokemon/enemy/Starters/charizardOne.png", "resources/images/pokemon/enemy/Starters/charizardTwo.png", "resources/images/pokemon/player/Starters/charizardOne.png", "resources/images/pokemon/player/Starters/charizardTwo.png", TYPE.FIRE),
    BLASTOISE("resources/images/pokemon/hurt/Starters/blastoiseOne.png", "resources/images/pokemon/hurt/Starters/blastoiseTwo.png", "resources/images/pokemon/enemy/Starters/blastoiseOne.png", "resources/images/pokemon/enemy/Starters/blastoiseTwo.png", "resources/images/pokemon/player/Starters/blastoiseOne.png", "resources/images/pokemon/player/Starters/blastoiseTwo.png", TYPE.WATER),

    IVYSAUR("resources/images/pokemon/hurt/Starters/ivysaurOne.png", "resources/images/pokemon/hurt/Starters/ivysaurTwo.png", "resources/images/pokemon/enemy/Starters/ivysaurOne.png", "resources/images/pokemon/enemy/Starters/ivysaurTwo.png", "resources/images/pokemon/player/Starters/ivysaurOne.png", "resources/images/pokemon/player/Starters/ivysaurTwo.png", TYPE.GRASS, VENOSAUR),
    WARTORTLE("resources/images/pokemon/hurt/Starters/wartortleOne.png", "resources/images/pokemon/hurt/Starters/wartortleTwo.png", "resources/images/pokemon/enemy/Starters/wartortleOne.png", "resources/images/pokemon/enemy/Starters/wartortleTwo.png", "resources/images/pokemon/player/Starters/wartortleOne.png", "resources/images/pokemon/player/Starters/wartortleTwo.png", TYPE.WATER, BLASTOISE),
    CHARMELEON("resources/images/pokemon/hurt/Starters/charmeleonOne.png", "resources/images/pokemon/hurt/Starters/charmeleonTwo.png", "resources/images/pokemon/enemy/Starters/charmeleonOne.png", "resources/images/pokemon/enemy/Starters/charmeleonTwo.png", "resources/images/pokemon/player/Starters/charmeleonOne.png", "resources/images/pokemon/player/Starters/charmeleonTwo.png", TYPE.FIRE, CHARIZARD),


    BULBOSAUR("resources/images/pokemon/hurt/Starters/bulbosaurOne.png", "resources/images/pokemon/hurt/Starters/bulbosaurTwo.png", "resources/images/pokemon/enemy/Starters/bulbosaurOne.png", "resources/images/pokemon/enemy/Starters/bulbosaurTwo.png", "resources/images/pokemon/player/Starters/bulbosaurOne.png", "resources/images/pokemon/player/Starters/bulbosaurTwo.png", TYPE.GRASS, IVYSAUR),
    CHARMANDER("resources/images/pokemon/hurt/Starters/charmanderOne.png", "resources/images/pokemon/hurt/Starters/charmanderTwo.png", "resources/images/pokemon/enemy/Starters/charmanderOne.png", "resources/images/pokemon/enemy/Starters/charmanderTwo.png", "resources/images/pokemon/player/Starters/charmanderOne.png", "resources/images/pokemon/player/Starters/charmanderTwo.png", TYPE.FIRE, CHARMELEON),
    SQUIRTLE("resources/images/pokemon/hurt/Starters/squirtleOne.png", "resources/images/pokemon/hurt/Starters/squirtleTwo.png", "resources/images/pokemon/enemy/Starters/squirtleOne.png", "resources/images/pokemon/enemy/Starters/squirtleTwo.png", "resources/images/pokemon/player/Starters/squirtleOne.png", "resources/images/pokemon/player/Starters/squirtleTwo.png", TYPE.WATER, WARTORTLE);


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
