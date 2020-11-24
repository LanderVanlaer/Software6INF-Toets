package me.landervanlaer.toetsen.toets6;

import javafx.scene.image.Image;

public class Auto {
    private final String merk;
    private final int maximaleSnelheid;
    private final Image logo;

    public Auto(String merk, int maximaleSnelheid) {
        this.merk = merk;
        this.maximaleSnelheid = maximaleSnelheid;
        this.logo = new Image("file:src/resources/garage/" + getMerk().toLowerCase() + ".jpg");
    }

    public String getMerk() {
        return merk;
    }

    public int getMaximaleSnelheid() {
        return maximaleSnelheid;
    }

    public Image getLogo() {
        return logo;
    }
}
