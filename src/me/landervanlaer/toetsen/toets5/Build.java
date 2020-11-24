package me.landervanlaer.toetsen.toets5;

import javafx.beans.Observable;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.File;

public class Build {
    private static final String DIRECTORY = "src/me/landervanlaer/toetsen/toets5/logo/";

    private final Garage garage = new Garage("Trump Tower Parking", 7);
    public TextField maxSnelheid;
    public TextField merkNaam;
    public Label toegevoegdeAuto;
    public ListView<String> listView;
    public Label garageNaam;
    public ImageView imageView;
    private String[] namen;

    public void initialize() {
        listView.getSelectionModel().selectedItemProperty().addListener(this::changeImage);
        File[] files = new File(DIRECTORY).listFiles();
        namen = new String[files.length];
        for(int i = 0; i < namen.length; i++)
            namen[i] = files[i].getName().replace(".jpg", "").toLowerCase();
    }

    private boolean isLogo(String s) {
        if(s == null) return false;
        for(String n : namen)
            if(n.equals(s.toLowerCase())) return true;
        return false;
    }

    private void changeImage(Observable observable) {
        final String selectedMerknaam = listView.getSelectionModel().getSelectedItem();

        imageView.setImage(null);

        if(isLogo(selectedMerknaam))
            imageView.setImage(new Image("file:" + DIRECTORY + selectedMerknaam + ".jpg"));
    }

    public void addAuto(ActionEvent actionEvent) {
        toegevoegdeAuto.setText(null);

        if(maxSnelheid.getText().isBlank() || merkNaam.getText().isBlank())
            return;

        if(!isNumber(maxSnelheid.getText())) return;

        final Auto auto = new Auto(Double.parseDouble(maxSnelheid.getText()), merkNaam.getText().trim());

        garage.add(auto);
        toegevoegdeAuto.setText(auto.getMerk());

        maxSnelheid.setText(null);
        merkNaam.setText(null);
    }

    private boolean isNumber(String num) {
        try {
            Double.parseDouble(num);
        } catch(NumberFormatException e) {
            return false;
        }
        return true;
    }

    public void showList(ActionEvent actionEvent) {
        listView.getItems().clear();
        garageNaam.setText(null);

        for(Auto auto : garage.getAutos())
            listView.getItems().add(auto.getMerk());

        garageNaam.setText(garage.getNaam());
    }
}
