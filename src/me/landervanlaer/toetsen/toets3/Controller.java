package me.landervanlaer.toetsen.toets3;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.util.Duration;

public class Controller {
    public ListView<String> list;
    public Label label;
    public ChoiceBox<String> choiceBox;

    private int counter = 0;
    private Timeline timeline;

    public void initialize() {
        list.getSelectionModel().selectedItemProperty().addListener(o -> {
            if(timeline != null) timeline.stop();
            timeline = new Timeline();

            final String selectedItem = list.getSelectionModel().getSelectedItem();
            counter = 0;
            label.setText("");

            String[] woord;
            if(choiceBox.getValue().equals("Normale volgorde")) {
                woord = selectedItem.split("");
            } else {
                woord = new String[selectedItem.length()];
                for(int i = 0; i < selectedItem.length(); i++) {
                    woord[i] = String.valueOf(selectedItem.charAt(selectedItem.length() - 1 - i));
                }
            }

            timeline.getKeyFrames().add(new KeyFrame(Duration.seconds(2), e -> {
                label.setText(label.getText() + woord[counter++]);
            }));
            timeline.setCycleCount(woord.length);
            timeline.playFromStart();
        });
    }
}
