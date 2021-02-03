package sample.Selectors;

import javafx.scene.image.Image;

public enum PokemonSelector {
    BULBOSAUR("resources/images/pokemon/front/bulbosaur_1.png", "resources/images/pokemon/front/bulbosaur_2.png", "resources/images/pokemon/back/bulbosaur_1.png", "resources/images/pokemon/back/bulbosaur_2.png");

    private final Image frontImageOne;
    private final Image frontImageTwo;
    private final Image backImageOne;
    private final Image backImageTwo;

    PokemonSelector(String frontImageOne, String frontImageTwo, String backImageOne, String backImageTwo) {
        this.frontImageOne = new Image(frontImageOne);
        this.frontImageTwo = new Image(frontImageTwo);
        this.backImageOne = new Image(backImageOne);
        this.backImageTwo = new Image(backImageTwo);
    }

    public Image getFrontImageOne() {
        return frontImageOne;
    }

    public Image getFrontImageTwo() {
        return frontImageTwo;
    }

    public Image getBackImageOne() {
        return backImageOne;
    }

    public Image getBackImageTwo() {
        return backImageTwo;
    }
}
