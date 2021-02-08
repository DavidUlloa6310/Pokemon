package sample.Controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import sample.Player;
import sample.SceneLibrary;
import sample.Selectors.LOCATION;

public class StoreController {
    @FXML
    ImageView hyperPotionButton;

    @FXML
    ImageView waterPlateButton;

    @FXML
    ImageView firePlateButton;

    @FXML
    ImageView grassPlateButton;

    @FXML
    ImageView miracleSeedButton;

    @FXML
    ImageView mysticWaterButton;

    @FXML
    ImageView charcoalButton;

    @FXML
    ImageView xpShareButton;

    @FXML
    ImageView amuletCoinButton;

    @FXML
    ImageView choiceBandButton;

    @FXML
    Label boxLabel;

    @FXML
    Label moneyLabel;

    @FXML
    public void initialize() {
        moneyLabel.setText("Your money " + Player.getMoney());
        boxLabel.setText("Hover over item to see information.");

        hyperPotionButton.hoverProperty().addListener(e -> displayPotionInfo());
        waterPlateButton.hoverProperty().addListener(e -> displayWaterPlateInfo());
        firePlateButton.hoverProperty().addListener(e -> displayFirePlateInfo());
        grassPlateButton.hoverProperty().addListener(e -> displayGrassPlateInfo());
        miracleSeedButton.hoverProperty().addListener(e -> displayMiricaleSeedInfo());
        charcoalButton.hoverProperty().addListener(e -> displayCharcoalInfo());
        xpShareButton.hoverProperty().addListener(e -> displayXPShareInfo());
        amuletCoinButton.hoverProperty().addListener(e -> displayAmuletCoinInfo());
        choiceBandButton.hoverProperty().addListener(e -> displayChoiceBandInfo());


    }

    public void backButton() {
        if (Player.getLocation() == LOCATION.CAMPAIGN)
            SceneLibrary.startCampaign();
        else if (Player.getLocation() == LOCATION.ENDLESS)
            SceneLibrary.startEndless();
        else if (Player.getLocation() == LOCATION.TUTORIAL);
            //START TUTORIAL. MUST DO!!!
    }

    public void buyPotion() {
        if (Player.getMoney() >= 500) {
            Player.addPotions(1);
            Player.removeMoney(200);
            moneyLabel.setText("Your money " + Player.getMoney());
        }
    }

    public void buyFirePlate() {
        if (Player.getMoney() >= 250) {
            Player.addFirePlates(1);
            Player.removeMoney(250);
            moneyLabel.setText("Your money " + Player.getMoney());
        }
    }

    public void buyWaterPlate() {
        if (Player.getMoney() >= 250) {
            Player.addWaterPlates(1);
            Player.removeMoney(250);
            moneyLabel.setText("Your money " + Player.getMoney());
        }
    }

    public void buyGrassPlate() {
        if (Player.getMoney() >= 250) {
            Player.addGrassPlates(1);
            Player.removeMoney(250);
            moneyLabel.setText("Your money " + Player.getMoney());
        }
    }

    public void buyChoiceBand() {
        if (Player.getMoney() >= 1000 && !Player.isHasChoiceBand()) {
            Player.setHasChoiceBand(true);
            Player.removeMoney(1000);
            choiceBandButton.setOpacity(.5);
            moneyLabel.setText("Your money " + Player.getMoney());
        }
    }

    public void buyXPShare() {
        if (Player.getMoney() >= 500 && !Player.isHasXPShare()) {
            Player.setHasXPShare(true);
            Player.removeMoney(500);
            choiceBandButton.setOpacity(.5);
            moneyLabel.setText("Your money " + Player.getMoney());
        }
    }

    public void buyAmuletCoin() {
        if (Player.getMoney() >= 1000 && !Player.isHasAmuletCoin()) {
            Player.setHasAmuletCoin(true);
            Player.removeMoney(1000);
            choiceBandButton.setOpacity(.5);
            moneyLabel.setText("Your money " + Player.getMoney());
        }
    }

    public void buyCharcoal() {
        if (Player.getMoney() >= 200 && !Player.isHasCharcoal()) {
            Player.setHasCharcoal(true);
            Player.removeMoney(200);
            choiceBandButton.setOpacity(.5);
            moneyLabel.setText("Your money " + Player.getMoney());
        }
    }

    public void buyMistcWater() {
        if (Player.getMoney() >= 200 && !Player.isHasMysticWater()) {
            Player.setHasMysticWater(true);
            Player.removeMoney(200);
            choiceBandButton.setOpacity(.5);
            moneyLabel.setText("Your money " + Player.getMoney());
        }
    }

    public void buyMiracleSeed() {
        if (Player.getMoney() >= 200 && !Player.isHasMiracleSeed()) {
            Player.setHasMiracleSeed(true);
            Player.removeMoney(200);
            choiceBandButton.setOpacity(.5);
            moneyLabel.setText("Your money " + Player.getMoney());
        }
    }

    public void displayPotionInfo() {
        boxLabel.setText("Restores health completely.");
    }

    public void displayCharcoalInfo() {
        boxLabel.setText("Increases fire damage permanently. Single purchase.");
    }

    public void displayMisticWaterInfo() {
        boxLabel.setText("Increases water damage permanently. Single purchase.");
    }

    public void displayMiricaleSeedInfo() {
        boxLabel.setText("Increases grass damage permanently. Single purchase.");
    }

    public void displayWaterPlateInfo() {
        boxLabel.setText("Prevents enemy trainer from using water type pokemon.");
    }

    public void displayGrassPlateInfo() {
        boxLabel.setText("Prevents enemy trainer from using grass type pokemon.");
    }

    public void displayXPShareInfo() {
        boxLabel.setText("Increases levels gained per trainer from 2, to 4.");
    }

    public void displayAmuletCoinInfo() {
        boxLabel.setText("Doubles the amount of money earned from each trainer.");
    }

    public void displayFirePlateInfo() {
        boxLabel.setText("Prevents enemy trainer from using fire type pokemon.");
    }

    public void displayChoiceBandInfo() {
        boxLabel.setText("Makes critical hits more likely and reduces required charges for charged attack from 5 to 3.");
    }


}
