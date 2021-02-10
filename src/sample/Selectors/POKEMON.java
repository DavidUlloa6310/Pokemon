package sample.Selectors;

import javafx.scene.image.Image;

import java.util.ArrayList;

public enum POKEMON {

    VENOSAUR("venosaur", TYPE.GRASS), CHARIZARD("charizard", TYPE.FIRE), BLASTOISE("blastoise", TYPE.WATER),
    IVYSAUR("ivysaur", TYPE.GRASS, VENOSAUR), WARTORTLE("wartortle", TYPE.WATER, BLASTOISE), CHARMELEON("charmeleon", TYPE.FIRE, CHARIZARD),
    BULBOSAUR("bulbosaur", TYPE.GRASS, IVYSAUR), CHARMANDER("charmander", TYPE.FIRE, CHARMELEON), SQUIRTLE("squirtle", TYPE.WATER, WARTORTLE),

    VULPIX("vulpix", TYPE.FIRE), PUMPLUF("pumpluf", TYPE.GRASS), PELIPPER("pelipper", TYPE.WATER),
    VESPIQUEEN("vespiqueen", TYPE.GRASS), PONYTA("ponyta", TYPE.FIRE), SURSKIT("surskit", TYPE.WATER),
    BIBAREL("bibarel", TYPE.WATER), FLAREON("flareon", TYPE.FIRE), PARAS("paras", TYPE.GRASS),
    SHARPEDO("sharpedo", TYPE.WATER), SHRIFTY("shrifty", TYPE.GRASS), HOUNDDOOM("hounddoom", TYPE.FIRE),
    POLIWRATH("poliwrath", TYPE.WATER), BRELOOM("breloom", TYPE.GRASS), BLAZIKEN("blaziken", TYPE.FIRE),
    EMPOLEAN("empolean", TYPE.WATER), TORKOAL("torkoal", TYPE.FIRE), CRADILY("cradily", TYPE.GRASS),
    ABOMASNOW("abomasnow", TYPE.GRASS), WALREIN("walrein", TYPE.WATER), ARCANINE("arcanine", TYPE.FIRE),
    GYRADOS("gyrados", TYPE.FIRE), TROPIUS("tropius", TYPE.GRASS),
    SCEPTILE("sceptile", TYPE.GRASS),
    SHINY_VENOSAUR("shinyVenosaur", TYPE.GRASS), SHINY_CHARIZARD("shinyCharizard", TYPE.FIRE), SHINY_BLASTOISE("shinyBlastoise", TYPE.WATER);


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

    POKEMON(String name, TYPE type, POKEMON evolution) {
        this("resources/images/pokemon/hurt/" + name + "One.png", "resources/images/pokemon/hurt/" + name + "Two.png", "resources/images/pokemon/enemy/" + name + "One.png", "resources/images/pokemon/enemy/" + name + "Two.png", "resources/images/pokemon/player/" + name + "One.png", "resources/images/pokemon/player/" + name + "Two.png", type, evolution);
    }

    POKEMON(String name, TYPE type) {
        this(name, type, null);
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
