package sample;

import sample.Selectors.*;

import javax.swing.*;

public abstract class Player {

    private static int money = 0;
    private static int level = 5;
    private static int completedBadges;
    private static boolean finishedTutorial = false;

    private static TRAINER trainerSprite = TRAINER.FEMALE_TRAINER_THREE;

    private static POKEMON fireSprite = POKEMON.CHARMANDER;
    private static POKEMON waterSprite = POKEMON.SQUIRTLE;
    private static POKEMON grassSprite = POKEMON.BULBOSAUR;

    private static LOCATION location;
    private static ITEM selectedItem;
    private static boolean hasUsedItem = false;

    private static boolean hasChoiceBand = false;
    private static boolean hasAmuletCoin = false;
    private static boolean hasXPShare = false;

    private static boolean hasCharcoal = false;
    private static boolean hasMysticWater = false;
    private static boolean hasMiracleSeed = false;

    private static int potions = 0;
    private static int waterPlates = 0;
    private static int firePlates = 0;
    private static int grassPlates = 0;

    public static double calculateDamage(int level, TYPE type) {
        double damage = (double) 1 / level;
        if (type == TYPE.FIRE && hasCharcoal)
            damage *= 2;
        if (type == TYPE.WATER && hasMysticWater)
            damage *= 2;
        if (type == TYPE.GRASS && hasMiracleSeed)
            damage *= 2;

        return damage;
    }

    public static boolean isFinishedTutorial() {
        return finishedTutorial;
    }

    public static int getMoney() {
        return money;
    }

    public static int getLevel() {
        return level;
    }

    public static int getCompletedBadges() {
        return completedBadges;
    }

    public static LOCATION getLocation() {
        return location;
    }

    public static TRAINER getTrainerSprite() {
        return trainerSprite;
    }

    public static POKEMON getFireSprite() {
        return fireSprite;
    }

    public static POKEMON getWaterSprite() {
        return waterSprite;
    }

    public static POKEMON getGrassSprite() {
        return grassSprite;
    }

    public static boolean isHasUsedItem() {
        return hasUsedItem;
    }

    public static boolean isHasChoiceBand() {
        return hasChoiceBand;
    }

    public static boolean isHasAmuletCoin() {
        return hasAmuletCoin;
    }

    public static boolean isHasXPShare() {
        return hasXPShare;
    }

    public static boolean isHasCharcoal() {
        return hasCharcoal;
    }

    public static boolean isHasMysticWater() {
        return hasMysticWater;
    }

    public static boolean isHasMiracleSeed() {
        return hasMiracleSeed;
    }

    public static int getPotions() {
        return potions;
    }

    public static int getWaterPlates() {
        return waterPlates;
    }

    public static int getFirePlates() {
        return firePlates;
    }

    public static int getGrassPlates() {
        return grassPlates;
    }

    public static ITEM getSelectedItem() {
        return selectedItem;
    }

    public static void addMoney(int money) {
        Player.money += money;
    }

    public static void removeMoney(int money) {
        Player.money -= money;
    }

    public static void increaseLevel() {

        int numLevels;

        if (hasXPShare) {
            numLevels = 4;
        } else {
            numLevels = 2;
        }

        for (int i = 0; i < numLevels; i++) {
            level++;
            if (level == 16) {
                evolvePokemon();
            }

            if (level == 32) {
                evolvePokemon();
            }
        }

    }

    public static void setFinishedTutorial(boolean finishedTutorial) {
        Player.finishedTutorial = finishedTutorial;
    }

    public static void setCompletedBadges(int completedBadges) {
        if (completedBadges > 12) {
            return;
        }
        Player.completedBadges = completedBadges;
    }

    public static void evolvePokemon() {
        fireSprite = fireSprite.getEvolution();
        waterSprite = waterSprite.getEvolution();
        grassSprite = grassSprite.getEvolution();
        JOptionPane.showMessageDialog(null, "Your pokemon have evolved!- ");
    }

    public static void setTrainerSprite(TRAINER trainerSprite) {
        Player.trainerSprite = trainerSprite;
    }

    public static void setSelectedItem(ITEM selectedItem) {
        Player.selectedItem = selectedItem;
    }

    public static void setLocation(LOCATION location) {
        Player.location = location;
    }

    public static void setHasUsedItem(boolean hasUsedItem) {
        Player.hasUsedItem = hasUsedItem;
    }

    public static void setHasChoiceBand(boolean hasChoiceBand) {
        Player.hasChoiceBand = hasChoiceBand;
    }

    public static void setHasAmuletCoin(boolean hasAmuletCoin) {
        Player.hasAmuletCoin = hasAmuletCoin;
    }

    public static void setHasXPShare(boolean hasXPShare) {
        Player.hasXPShare = hasXPShare;
    }

    public static void setHasCharcoal(boolean hasCharcoal) {
        Player.hasCharcoal = hasCharcoal;
    }

    public static void setHasMysticWater(boolean hasMysticWater) {
        Player.hasMysticWater = hasMysticWater;
    }

    public static void setHasMiracleSeed(boolean hasMiracleSeed) {
        Player.hasMiracleSeed = hasMiracleSeed;
    }

    public static void addPotions(int potions) {
        Player.potions += potions;
    }

    public static void removePotions(int potions) {
        Player.potions -= potions;
    }

    public static void addWaterPlates(int waterPlates) {
        Player.waterPlates += waterPlates;
    }

    public static void removeWaterPlates(int waterPlates) {
        Player.waterPlates -= waterPlates;
    }

    public static void addFirePlates(int firePlates) {
        Player.firePlates += firePlates;
    }

    public static void removeFirePlates(int firePlates) {
        Player.firePlates -= firePlates;
    }

    public static void addGrassPlates(int grassPlates) {
        Player.grassPlates += grassPlates;
    }

    public static void removeGrassPlates(int grassPlates) {
        Player.grassPlates -= grassPlates;
    }
}
