package me.landervanlaer.toetsen.toets5;

import java.util.ArrayList;
import java.util.List;

public class Garage {
    private final int maxAantalAutos;
    private String naam;
    private List<Auto> list = new ArrayList<>();

    public Garage(String naam, int maxAantalAutos) {
        this.naam = naam;
        this.maxAantalAutos = maxAantalAutos;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public int getMaxAantalAutos() {
        return maxAantalAutos;
    }

    public List<Auto> getAutos() {
        return this.list;
    }

    public void add(Auto auto) {
        if(getList().size() >= getMaxAantalAutos()) return;
        getList().add(auto);
    }

    private List<Auto> getList() {
        return list;
    }

    public void setList(List<Auto> list) {
        this.list = list;
    }
}
