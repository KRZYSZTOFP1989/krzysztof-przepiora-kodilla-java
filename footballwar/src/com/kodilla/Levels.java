package com.kodilla;

import javafx.scene.control.ChoiceDialog;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Levels {

    private List<Level> levels;

    public Levels() {

        levels = new ArrayList<>();

        Level easy = new Level("Łatwy");
        Level medium = new Level("Średni");
        Level hard = new Level("Trudny");

        levels.add(easy);
        levels.add(medium);
        levels.add(hard);

    }

    public void showChooseLevelAlert() {

        ChoiceDialog<Level> dialog = new ChoiceDialog<>(levels.get(0), levels);
        dialog.setTitle("Witaj w grze FootballWar!");
        dialog.setHeaderText("Wybierz poziom gry");
        dialog.setContentText("Dostępne poziomy:");

        Optional<Level> result = dialog.showAndWait();
        if (result.isPresent()) {

        }

    }

}

