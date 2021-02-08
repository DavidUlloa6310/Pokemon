package sample.Controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import sample.Player;
import sample.SceneLibrary;
import sample.Selectors.ITEM;
import sample.Selectors.LOCATION;

import java.util.Locale;

public class BagController {
    @FXML
    private ImageView hyperPotionButton;
    @FXML
    private Label hyperPotionLabel;

    @FXML
    private ImageView grassPlateButton;
    @FXML
    private Label grassPlateLabel;

    @FXML
    private ImageView firePlateButton;
    @FXML
    private Label firePlateLabel;

    @FXML
    private ImageView waterPlateButton;
    @FXML
    private Label waterPlateLabel;

    @FXML
    public void initialize() {
        updateQuantities();
    }

    public void updateQuantities() {
        hyperPotionLabel.setText("" + Player.getPotions());
        grassPlateLabel.setText("" + Player.getGrassPlates());
        waterPlateLabel.setText("" + Player.getWaterPlates());
        firePlateLabel.setText("" + Player.getFirePlates());
    }

    public void useHyperPotion() {
        if (Player.getPotions() >= 1) {
            Player.setSelectedItem(ITEM.POTION);
            Player.removePotions(1);
            Player.setHasUsedItem(true);
            updateQuantities();
            SceneLibrary.goBack();
        }
    }

    public void useFirePlate() {
        if (Player.getFirePlates() >= 1) {
            Player.setSelectedItem(ITEM.FIREPLATE);
            Player.removeFirePlates(1);
            Player.setHasUsedItem(true);
            updateQuantities();
            SceneLibrary.goBack();
        }
    }

    public void useWaterPlate() {
        if (Player.getWaterPlates() >= 1) {
            Player.setSelectedItem(ITEM.WATERPLATE);
            Player.removeWaterPlates(1);
            Player.setHasUsedItem(true);
            updateQuantities();
            SceneLibrary.goBack();
        }
    }

    public void useGrassPlate() {
        if (Player.getGrassPlates() >= 1) {
            Player.setSelectedItem(ITEM.GRASSPLATE);
            Player.removeGrassPlates(1);
            Player.setHasUsedItem(true);
            updateQuantities();
            SceneLibrary.goBack();
        }
    }

    public void goBack() {
        SceneLibrary.goBack();
    }

}
