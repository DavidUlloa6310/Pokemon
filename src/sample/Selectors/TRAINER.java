package sample.Selectors;

import javafx.scene.image.Image;

import java.io.File;
import java.util.ArrayList;
import java.util.Random;

public enum TRAINER {

    MALE_TRAINER_ONE("resources/images/trainers/player/maleTrainer/maleTrainerOne.png", "resources/images/trainers/player/maleTrainer/maleTrainerTwo.png", "resources/images/trainers/player/maleTrainer/maleTrainerThree.png", "resources/images/trainers/player/maleTrainer/maleTrainerFour.png", "resources/images/trainers/player/maleTrainer/maleTrainerFive.png", "resources/images/trainers/player/maleTrainer/maleTrainerSix.png", "resources/images/trainers/player/maleTrainer/maleTrainerSeven.png", "resources/images/trainers/player/maleTrainer/maleTrainerEight.png", "resources/images/trainers/enemy/maleTrainer.png"),
    MALE_TRAINER_TWO("resources/images/trainers/player/maleTrainerTwo/maleTrainerOne.png", "resources/images/trainers/player/maleTrainerTwo/maleTrainerTwo.png", "resources/images/trainers/player/maleTrainerTwo/maleTrainerThree.png", "resources/images/trainers/player/maleTrainerTwo/maleTrainerFour.png", "resources/images/trainers/player/maleTrainerTwo/maleTrainerFive.png", "resources/images/trainers/player/maleTrainerTwo/maleTrainerSix.png", "resources/images/trainers/player/maleTrainerTwo/maleTrainerSix.png", "resources/images/trainers/player/maleTrainerTwo/maleTrainerSix.png", "resources/images/trainers/enemy/maleTrainerTwo.png"),
    MALE_TRAINER_THREE("resources/images/trainers/player/maleTrainerThree/maleTrainerOne.png", "resources/images/trainers/player/maleTrainerThree/maleTrainerTwo.png", "resources/images/trainers/player/maleTrainerThree/maleTrainerThree.png", "resources/images/trainers/player/maleTrainerThree/maleTrainerFour.png", "resources/images/trainers/player/maleTrainerThree/maleTrainerFive.png", "resources/images/trainers/player/maleTrainerThree/maleTrainerSix.png", "resources/images/trainers/player/maleTrainerThree/maleTrainerSix.png", "resources/images/trainers/player/maleTrainerThree/maleTrainerSix.png", "resources/images/trainers/enemy/maleTrainerThree.png"),

    FEMALE_TRAINER_ONE("resources/images/trainers/player/femaleTrainer/femaleTrainerOne.png", "resources/images/trainers/player/femaleTrainer/femaleTrainerTwo.png", "resources/images/trainers/player/femaleTrainer/femaleTrainerThree.png", "resources/images/trainers/player/femaleTrainer/femaleTrainerFour.png", "resources/images/trainers/player/femaleTrainer/femaleTrainerFive.png", "resources/images/trainers/player/femaleTrainer/femaleTrainerSix.png", "resources/images/trainers/player/femaleTrainer/femaleTrainerSeven.png", "resources/images/trainers/player/femaleTrainer/femaleTrainerEight.png", "resources/images/trainers/enemy/femaleTrainer.png"),
    FEMALE_TRAINER_TWO("resources/images/trainers/player/femaleTrainerTwo/femaleTrainerOne.png", "resources/images/trainers/player/femaleTrainerTwo/femaleTrainerTwo.png", "resources/images/trainers/player/femaleTrainerTwo/femaleTrainerThree.png", "resources/images/trainers/player/femaleTrainerTwo/femaleTrainerFour.png", "resources/images/trainers/player/femaleTrainerTwo/femaleTrainerFive.png", "resources/images/trainers/player/femaleTrainerTwo/femaleTrainerSix.png", "resources/images/trainers/player/femaleTrainerTwo/femaleTrainerSeven.png", "resources/images/trainers/player/femaleTrainerTwo/femaleTrainerEight.png", "resources/images/trainers/enemy/femaleTrainerTwo.png"),
    FEMALE_TRAINER_THREE("resources/images/trainers/player/femaleTrainerThree/femaleTrainerOne.png", "resources/images/trainers/player/femaleTrainerThree/femaleTrainerTwo.png", "resources/images/trainers/player/femaleTrainerThree/femaleTrainerThree.png", "resources/images/trainers/player/femaleTrainerThree/femaleTrainerFour.png", "resources/images/trainers/player/femaleTrainerThree/femaleTrainerFive.png", "resources/images/trainers/player/femaleTrainerThree/femaleTrainerSix.png", "resources/images/trainers/player/femaleTrainerThree/femaleTrainerSix.png", "resources/images/trainers/player/femaleTrainerThree/femaleTrainerSix.png", "resources/images/trainers/enemy/femaleTrainerThree.png"),

    ARCHITECT("architect"),
    BIMBO("bimbo"),
    BIRD_CATCHER("birdCatcher"),
    BOY("boy"),
    BUG_CATCHER("bugcatcher"),
    CRAZY_LADY("crazyLady"),
    DANCERS("dancers"),
    DINOSAUR("dinosaur"),
    DRAGON_TRAINER_MALE("dragonTrainerMale"),
    DRAGON_TRAINER_FEMALE("dragonTrainerFemale"),
    FIRE_MAN("fireMan"),
    KARATE("karate"),
    KYOSHI("kyoshi"),
    MAGICIAN("magician"),
    MONK("monk"),
    OLD_MAN("oldMan"),
    RICH_MAN("richMan"),
    ROBOT_MAN("robotMan"),
    ROCKET_FEMALE("rocketFemale"),
    ROCKET_MALE("rocketMale"),
    SCHOOL_GIRL("schoolGirl"),
    SCIENTIST("scientist"),
    SWIMMER_FEMALE("swimmerFemale"),
    SWIMMER_MALE("swimmerMale"),
    TWINS("twins"),

    FALKNER("falker"), BUGSY("bugsy"), WHITNEY("whitney"), MORTY("morty"), CHUCK("chuck"),
    JASMINE("jasmine"), PRYCE("pryce"), CLAIR("clair"), LANCE("lance"), Red("red");

    private final Image frontImage;
    private final ArrayList<Image> frames = new ArrayList<Image>();
    private static final TRAINER[] trainers = {
            MALE_TRAINER_ONE,
            MALE_TRAINER_TWO,
            MALE_TRAINER_THREE,
            FEMALE_TRAINER_ONE,
            FEMALE_TRAINER_TWO,
            FEMALE_TRAINER_THREE,
            ARCHITECT,
            BIMBO,
            BIRD_CATCHER,
            BOY,
            BUG_CATCHER,
            CRAZY_LADY,
            DANCERS,
            DINOSAUR,
            DRAGON_TRAINER_MALE,
            DRAGON_TRAINER_FEMALE,
            FIRE_MAN,
            KARATE,
            KYOSHI,
            MAGICIAN,
            MONK,
            OLD_MAN,
            RICH_MAN,
            ROBOT_MAN,
            ROCKET_FEMALE,
            ROCKET_MALE,
            SCHOOL_GIRL,
            SCIENTIST,
            SWIMMER_FEMALE,
            SWIMMER_MALE,
            TWINS
    };


    TRAINER(String frameOne, String frameTwo, String frameThree, String frameFour, String frameFive, String frameSix, String frameSeven, String frameEight, String imagePath) {
        frontImage = new Image(imagePath);
        frames.add(new Image(frameOne));
        frames.add(new Image(frameTwo));
        frames.add(new Image(frameThree));
        frames.add(new Image(frameFour));
        frames.add(new Image(frameFive));
        frames.add(new Image(frameSix));
        frames.add(new Image(frameSeven));
        frames.add(new Image(frameEight));
    }

    TRAINER(String name) {
        frontImage = new Image("resources/images/trainers/enemy" + name + ".png");
        frames.add(frontImage);
    }

    public Image getFrontImage() {
        return frontImage;
    }

    public ArrayList<Image> getFrames() {
        return frames;
    }

    public static TRAINER getRandomTrainer() {
        Random random = new Random();
        return trainers[random.nextInt(trainers.length)];
    }
}
