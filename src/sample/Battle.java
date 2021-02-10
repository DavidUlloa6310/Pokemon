package sample;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import sample.Selectors.POKEMON;
import sample.Selectors.TRAINER;

import java.util.LinkedList;

public class Battle {

    private static Battle[] battles = generateCampaignBattles();
    private static int currentBattle = 0;

    private Image background;
    private TRAINER trainer;

    private POKEMON firePokemon;
    private POKEMON waterPokemon;
    private POKEMON grassPokemon;

    public Image getBackground() {
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

    public Battle(Image background, TRAINER trainer, POKEMON firePokemon, POKEMON waterPokemon, POKEMON grassPokemon) {
        this.background = background;
        this.trainer = trainer;
        this.firePokemon = firePokemon;
        this.waterPokemon = waterPokemon;
        this.grassPokemon = grassPokemon;
    }

    private void generateBattle(ImageView background, Trainer trainer) {
        background.setImage(battles[currentBattle].getBackground());
        trainer.changeTrainer(battles[currentBattle].getTrainer());
    }

    public static void nextBattle(ImageView background, Trainer trainer) {
        Player.setCompletedBadges(currentBattle + 1);
        currentBattle++;
        if (currentBattle > 12) {
            currentBattle = 0;
        }
        battles[currentBattle].generateBattle(background, trainer);
    }

    public static Battle[] generateCampaignBattles() {
        Battle[] battles = new Battle[13];
//        battles[0] = new Battle();
//        battles[1] = new Battle();
//        battles[2] = new Battle();
//        battles[3] = new Battle();
//        battles[4] = new Battle();
//        battles[5] = new Battle();
//        battles[6] = new Battle();
//        battles[7] = new Battle();
//        battles[8] = new Battle();
//        battles[9] = new Battle();
//        battles[10] = new Battle();
//        battles[11] = new Battle();
//        battles[12] = new Battle();
        return battles;
    }
}
