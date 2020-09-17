package me.landervanlaer.toetsen.toets2;

import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Controller {
    public TextField voornaam;
    public TextField achternaam;
    public Label achternaamError;
    public Label voornaamError;
    public Label gebruikersNummer;

    public void click(ActionEvent actionEvent) {
        voornaamError.setText(null);
        achternaamError.setText(null);
        gebruikersNummer.setText(null);

        voornaam.setText(voornaam.getText().trim());
        achternaam.setText(achternaam.getText().trim());

        boolean error = false;

        final String startUpperCaseError = "Naam moet beginnen met een hoofdletter";
        final String emptyError = "Veld mag niet leeg zijn";
        if(voornaam.getText().isBlank()) {
            voornaamError.setText(emptyError);
            error = true;
        } else if(!voornaam.getText().substring(0, 1).equals(voornaam.getText().substring(0, 1).toUpperCase())) {
            voornaamError.setText(startUpperCaseError);
            error = true;
        }

        if(achternaam.getText().isBlank()) {
            achternaamError.setText(emptyError);
            error = true;
        } else if(!achternaam.getText().substring(0, 1).equals(achternaam.getText().substring(0, 1).toUpperCase())) {
            achternaamError.setText(startUpperCaseError);
            error = true;
        }

        if(error) return;

        final String achternaamNoSpaces = achternaam.getText().replaceAll(" ", "");

        String name = String.valueOf(voornaam.getLength()) +
                achternaamNoSpaces.substring(0, Math.min(achternaamNoSpaces.length(), 5)) +
                voornaam.getText().charAt(0);

        gebruikersNummer.setText(name);
    }
}
