package sample.Controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.ImageView;
import sample.Player;
import sample.SceneLibrary;
import sample.Selectors.TRAINER;

public class tutorialController {
    @FXML
    Label textBox;

    @FXML
    ImageView maleTrainerOne, maleTrainerTwo, maleTrainerThree, femaleTrainerOne, femaleTrainerTwo, femaleTrainerThree;

    @FXML
    ImageView fightButton, fireButton, grassButton, waterButton, chargeAttackButton, bagButton, shopButton, runButton;

    @FXML
    ProgressBar progressBar;

    @FXML
    public void initialize() {
        progressBar.setStyle("-fx-accent: orange;");
        progressBar.progressProperty().set(1);
        textBox.setText("Welcome to the world of Pokemon!\n Please select your trainer model below.");
    }

    public void selectMaleTrainerOne() {
        Player.setTrainerSprite(TRAINER.MALE_TRAINER_ONE);
        hideTrainers();
    }

    public void selectFemaleTrainerOne() {
        Player.setTrainerSprite(TRAINER.FEMALE_TRAINER_ONE);
        hideTrainers();
    }

    public void selectMaleTrainerTwo() {
        Player.setTrainerSprite(TRAINER.MALE_TRAINER_TWO);
        hideTrainers();
    }

    public void selectFemaleTrainerTwo() {
        Player.setTrainerSprite(TRAINER.FEMALE_TRAINER_TWO);
        hideTrainers();
    }

    public void selectMaleTrainerThree() {
        Player.setTrainerSprite(TRAINER.MALE_TRAINER_THREE);
        hideTrainers();
    }

    public void selectFemaleTrainerThree() {
        Player.setTrainerSprite(TRAINER.FEMALE_TRAINER_THREE);
        hideTrainers();
    }


    public void hideTrainers() {
        maleTrainerOne.setVisible(false);
        maleTrainerTwo.setVisible(false);
        maleTrainerThree.setVisible(false);
        femaleTrainerOne.setVisible(false);
        femaleTrainerTwo.setVisible(false);
        femaleTrainerThree.setVisible(false);

        textBox.setText("Once you start the battle, you can select the fight\n button. Please click the fight button to continue.");
        fightButton.setVisible(true);
    }

    public void showTrainers() {
        maleTrainerOne.setVisible(true);
        maleTrainerTwo.setVisible(true);
        maleTrainerThree.setVisible(true);
        femaleTrainerOne.setVisible(true);
        femaleTrainerTwo.setVisible(true);
        femaleTrainerThree.setVisible(true);
        textBox.setText("Welcome to the world of Pokemon!\n Please select your trainer model below.");
    }

    public void hideFightButton() {
        fightButton.setVisible(false);
        fireButton.setVisible(true);
        grassButton.setVisible(true);
        waterButton.setVisible(true);
        textBox.setText("Clicking a type will release that pokemon. \nClick one to continue. ");
    }

    public void hideTypeButtons() {
        fireButton.setVisible(false);
        waterButton.setVisible(false);
        grassButton.setVisible(false);
        progressBar.setVisible(true);
        chargeAttackButton.setVisible(true);
        textBox.setText("When you get hit, your charge bar increases.\n Once it is full, you can click the charge button. \n Click the charge button now.");
    }

    public void hideProgressBar() {
        progressBar.setVisible(false);
        chargeAttackButton.setVisible(false);
        bagButton.setVisible(true);
        shopButton.setVisible(true);
        runButton.setVisible(true);
        textBox.setText("Bag button opens inventory, shop button opens shop.\nRun button goes to menu. Click it to finish tutorial.");
    }

    public void finishTutorial() {
        runButton.setVisible(false);
        shopButton.setVisible(false);
        bagButton.setVisible(false);

        Player.setFinishedTutorial(true);
        SceneLibrary.startMenu();

        showTrainers();

    }
}
