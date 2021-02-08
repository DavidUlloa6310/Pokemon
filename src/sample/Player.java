package sample;

import sample.Selectors.ITEM;
import sample.Selectors.LOCATION;
import sample.Selectors.TYPE;

public abstract class Player {

    private static int money = 0;
    private static int level = 5;

    private static LOCATION location;
    private static ITEM selectedItem;

    private static boolean hasChoiceBand = true;
    private static boolean hasAmuletCoin = false;
    private static boolean hasXPShare = true;

    private static boolean hasCharcoal = true;
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

    public static int getMoney() {
        return money;
    }

    public static int getLevel() {
        return level;
    }

    public static LOCATION getLocation() {
        return location;
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
                //EVOLVE FIRST STAGE
            }

            if (level == 32) {
                //EVOLVE SECOND STAGE
            }
        }

    }

    public static void setSelectedItem(ITEM selectedItem) {
        Player.selectedItem = selectedItem;
    }

    public static void setLocation(LOCATION location) {
        Player.location = location;
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
