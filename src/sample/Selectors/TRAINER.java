package sample.Selectors;

import javafx.scene.image.Image;

import java.util.ArrayList;

public enum TRAINER {

    MALE_TRAINER("resources/images/trainers/player/maleTrainer/maleTrainerOne.png", "resources/images/trainers/player/maleTrainer/maleTrainerTwo.png", "resources/images/trainers/player/maleTrainer/maleTrainerThree.png", "resources/images/trainers/player/maleTrainer/maleTrainerFour.png", "resources/images/trainers/player/maleTrainer/maleTrainerFive.png", "resources/images/trainers/player/maleTrainer/maleTrainerSix.png", "resources/images/trainers/player/maleTrainer/maleTrainerSeven.png", "resources/images/trainers/player/maleTrainer/maleTrainerEight.png", "resources/images/trainers/enemy/maleTrainer.png"),
    FEMALE_TRAINER("resources/images/trainers/player/femaleTrainer/femaleTrainerOne.png", "resources/images/trainers/player/femaleTrainer/femaleTrainerTwo.png", "resources/images/trainers/player/femaleTrainer/femaleTrainerThree.png", "resources/images/trainers/player/femaleTrainer/femaleTrainerFour.png", "resources/images/trainers/player/femaleTrainer/femaleTrainerFive.png", "resources/images/trainers/player/femaleTrainer/femaleTrainerSix.png", "resources/images/trainers/player/femaleTrainer/femaleTrainerSeven.png", "resources/images/trainers/player/femaleTrainer/femaleTrainerEight.png", "resources/images/trainers/enemy/femaleTrainer.png");

    private Image frontImage;
    private ArrayList<Image> frames = new ArrayList<Image>();


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

    TRAINER(String imagePath) {
        frontImage = new Image(imagePath);
        frames.add(frontImage);
    }

    public Image getFrontImage() {
        return frontImage;
    }

    public ArrayList<Image> getFrames() {
        return frames;
    }
}
