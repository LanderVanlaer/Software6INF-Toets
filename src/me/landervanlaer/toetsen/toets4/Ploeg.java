package me.landervanlaer.toetsen.toets4;

import java.util.ArrayList;
import java.util.List;

public class Ploeg {
    List<Speler> spelers = new ArrayList<>();
    private String naam;
    private int divisie;

    public Ploeg(String naam, int divisie) {
        this.naam = naam;
        this.divisie = divisie;
    }

    public List<Speler> getSpelers() {
        return spelers;
    }

    public void setSpelers(List<Speler> spelers) {
        this.spelers = spelers;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public void verhoogDivisie() {
        setDivisie(getDivisie() + 1);
    }

    public void verlaagDivisie() {
        setDivisie(getDivisie() - 1);
    }

    public int getDivisie() {
        return divisie;
    }

    public void setDivisie(int divisie) {
        if(divisie >= 1 && divisie <= 4)
            this.divisie = divisie;
    }
}
