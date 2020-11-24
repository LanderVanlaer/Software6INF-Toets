package me.landervanlaer.toetsen.toets6;

import java.util.ArrayList;
import java.util.List;

public class Garage {
    private final String naam;
    private final List<Auto> autos = new ArrayList<>();

    public Garage(String naam) {
        this.naam = naam;
    }

    public String getNaam() {
        return naam;
    }

    public List<Auto> getAutos() {
        return autos;
    }

    public void addAuto(Auto auto) {
        getAutos().add(auto);
    }
}
