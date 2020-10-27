package me.landervanlaer.toetsen.toets4;

import com.sun.media.jfxmedia.events.PlayerEvent;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;

import java.io.File;

public class Build {

    public ListView<String> list;
    public Label ploegNaam;
    public Label divisie;
    public ImageView imageView;
    private Ploeg ploeg;

    public void initialize() {
        setPloeg(new Ploeg("KFC Boom", 2));
        getPloeg().getSpelers().add(new Speler("Jos", "Center", 100000));
        getPloeg().getSpelers().add(new Speler("Frank", "Keeper", 150000));
        getPloeg().getSpelers().add(new Speler("Tibo", "Links voor", 123400));
        getPloeg().getSpelers().add(new Speler("Steven", "Links achter", 162000));
        getPloeg().getSpelers().add(new Speler("Jan", "verdedeging", 101500));
    }


    public void toonSpelers() {
        list.getItems().clear();
        for(Speler speler : getPloeg().getSpelers()) {
            list.getItems().add(speler.toString());
        }
    }

    public Ploeg getPloeg() {
        return ploeg;
    }

    public void setPloeg(Ploeg ploeg) {
        this.ploeg = ploeg;
    }

    public void ploegDivisieOmhoog(ActionEvent actionEvent) {
        getPloeg().verhoogDivisie();
        showDivisie();
    }

    public void ploegDivisieOmlaag(ActionEvent actionEvent) {
        getPloeg().verlaagDivisie();
        showDivisie();
    }

    public void showDivisie() {
        divisie.setText(String.valueOf(getPloeg().getDivisie()));
    }

    public void toonData(ActionEvent actionEvent) {
        toonSpelers();
        showDivisie();
        ploegNaam.setText(getPloeg().getNaam());
    }

    public void openImage(ActionEvent actionEvent) {
        FileChooser chooser = new FileChooser();
        chooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Image", "*.png", "*.jpg", "*.jpeg"));
        File file = chooser.showOpenDialog(imageView.getScene().getWindow());
        if(file == null) return;
        imageView.setImage(new Image("file:" + file.getAbsolutePath()));
    }

    public void close(ActionEvent actionEvent) {
        Platform.exit();
    }
}
