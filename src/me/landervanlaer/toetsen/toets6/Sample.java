package me.landervanlaer.toetsen.toets6;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.util.Duration;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.Scanner;

public class Sample {
    @FXML
    private Label maxSnelheid;
    @FXML
    private Label merkAuto;
    @FXML
    private ImageView imageView;
    @FXML
    private Label garageNaam;
    @FXML
    private ChoiceBox<Integer> choiseBox;

    private Garage garage;
    private Timeline timeline;
    private Iterator<Auto> iterator;

    public void openFile(ActionEvent actionEvent) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Tekst", "*.txt"));
        File file = fileChooser.showOpenDialog(choiseBox.getScene().getWindow());

        if(file == null) return;

        leesInBestand(file, choiseBox.getValue());
        updateScene();
    }

    public void updateScene() {
        garageNaam.setText(getGarage().getNaam());
        setIterator(getGarage().getAutos().iterator());
        setTimeline(new Timeline(new KeyFrame(Duration.seconds(3), this::updateAuto)));
        getTimeline().setCycleCount(getGarage().getAutos().size());
        getTimeline().playFromStart();
        updateAuto(null);
    }

    private void updateAuto(ActionEvent actionEvent) {
        if(getIterator() != null && getIterator().hasNext()) {
            final Auto auto = getIterator().next();
            maxSnelheid.setText(String.valueOf(auto.getMaximaleSnelheid()));
            merkAuto.setText(auto.getMerk());
            imageView.setImage(auto.getLogo());
        } else {
            setIterator(null);
            setTimeline(null);
        }
    }

    public void leesInBestand(File file, int maxAantal) {
        try {
            Scanner scanner = new Scanner(file);
            setGarage(new Garage(scanner.nextLine()));
            for(int i = 0; i < maxAantal && scanner.hasNext(); ++i)
                getGarage().addAuto(new Auto(scanner.next(), scanner.nextInt()));
            scanner.close();
        } catch(FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Garage getGarage() {
        return garage;
    }

    public void setGarage(Garage garage) {
        this.garage = garage;
    }

    public Iterator<Auto> getIterator() {
        return iterator;
    }

    public void setIterator(Iterator<Auto> iterable) {
        this.iterator = iterable;
    }

    public Timeline getTimeline() {
        return timeline;
    }

    public void setTimeline(Timeline timeline) {
        this.timeline = timeline;
    }
}
