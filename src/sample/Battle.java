package sample;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import sample.Selectors.BACKGROUND;
import sample.Selectors.POKEMON;
import sample.Selectors.TRAINER;

import javax.swing.*;
import java.util.LinkedList;

public class Battle {

    //Class for a possible battle, which consists of a background, trainer, and pokemon sprites.

    private static Battle[] battles = generateCampaignBattles();
    private static int currentBattle = -1;

    private BACKGROUND background;
    private TRAINER trainer;

    private POKEMON firePokemon;
    private POKEMON waterPokemon;
    private POKEMON grassPokemon;

    public BACKGROUND getBackground() {
        return background;
    }

    public TRAINER getTrainer() {
        return trainer;
    }

    public POKEMON getFirePokemon() {
        return firePokemon;
    }

    public POKEMON getWaterPokemon() {
        return waterPokemon;
    }

    public POKEMON getGrassPokemon() {
        return grassPokemon;
    }

    public Battle(BACKGROUND background, TRAINER trainer, POKEMON firePokemon, POKEMON waterPokemon, POKEMON grassPokemon) {
        this.background = background;
        this.trainer = trainer;
        this.firePokemon = firePokemon;
        this.waterPokemon = waterPokemon;
        this.grassPokemon = grassPokemon;
    }

    private void generateBattle(ImageView background, Trainer trainer) {
        background.setImage(battles[currentBattle].getBackground().getBackgroundImage());
        trainer.changeTrainer(battles[currentBattle].getTrainer());
        trainer.setFirePokemon(battles[currentBattle].getFirePokemon());
        trainer.setGrassPokemon(battles[currentBattle].getGrassPokemon());
        trainer.setWaterPokemon(battles[currentBattle].getWaterPokemon());
    }

    public static void nextBattle(ImageView background, Trainer trainer) {
        Player.setCompletedBadges(currentBattle + 1);
        currentBattle++;
        if (currentBattle > 9) {
            currentBattle = 0;
            JOptionPane.showMessageDialog(null, "Congratulation, you have completed the campaign!");
            SceneLibrary.startMenu();
        }
        battles[currentBattle].generateBattle(background, trainer);
    }

    public static Battle[] generateCampaignBattles() {
        Battle[] battles = new Battle[13];
        battles[0] = new Battle(BACKGROUND.DESERT, TRAINER.FALKNER, POKEMON.VULPIX, POKEMON.PELIPPER, POKEMON.PUMPLUF);
        battles[1] = new Battle(BACKGROUND.DARK_GRASS, TRAINER.BUGSY, POKEMON.PONYTA, POKEMON.SURSKIT, POKEMON.VESPIQUEEN);
        battles[2] = new Battle(BACKGROUND.NORMAL, TRAINER.WHITNEY, POKEMON.FLAREON, POKEMON.BIBAREL, POKEMON.PARAS);
        battles[3] = new Battle(BACKGROUND.GHOST, TRAINER.MORTY, POKEMON.HOUNDDOOM, POKEMON.SHARPEDO, POKEMON.SHRIFTY);
        battles[4] = new Battle(BACKGROUND.GROUND, TRAINER.CHUCK, POKEMON.BLAZIKEN, POKEMON.POLIWRATH, POKEMON.BRELOOM);
        battles[5] = new Battle(BACKGROUND.NORMAL, TRAINER.JASMINE, POKEMON.TORKOAL, POKEMON.EMPOLEAN, POKEMON.CRADILY);
        battles[6] = new Battle(BACKGROUND.SNOW, TRAINER.PRYCE, POKEMON.ARCANINE, POKEMON.WALREIN, POKEMON.ABOMASNOW);
        battles[7] = new Battle(BACKGROUND.UNDERGROUND, TRAINER.CLAIR, POKEMON.CHARIZARD, POKEMON.DRAGONAIR, POKEMON.TROPIUS);
        battles[8] = new Battle(BACKGROUND.NORMAL, TRAINER.LANCE, POKEMON.CHARIZARD, POKEMON.GYRADOS, POKEMON.SCEPTILE);
        battles[9] = new Battle(BACKGROUND.SNOW, TRAINER.RED, POKEMON.SHINY_CHARIZARD, POKEMON.SHINY_BLASTOISE, POKEMON.SHINY_VENOSAUR);
        return battles;
    }
}
