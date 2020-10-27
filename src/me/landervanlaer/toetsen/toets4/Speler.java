package me.landervanlaer.toetsen.toets4;


public class Speler {
    private String naam;
    private String positie;
    private double loon;

    public Speler(String naam, String positie, double loon) {
        this.naam = naam;
        this.positie = positie;
        this.loon = loon;
    }

    @Override
    public String toString() {
        return naam + ", " + "" + positie + ", " + loon + " euro";
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public String getPositie() {
        return positie;
    }

    public void setPositie(String positie) {
        this.positie = positie;
    }

    public double getLoon() {
        return loon;
    }

    public void setLoon(double loon) {
        this.loon = loon;
    }
}
