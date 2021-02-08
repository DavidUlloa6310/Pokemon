package sample.Controllers;

import sample.Player;
import sample.SceneLibrary;
import sample.Selectors.LOCATION;

public class MenuController {
    public void playEndless() {
        SceneLibrary.startEndless();
    }

    public void playCampaign() {
        SceneLibrary.startCampaign();
    }
}
