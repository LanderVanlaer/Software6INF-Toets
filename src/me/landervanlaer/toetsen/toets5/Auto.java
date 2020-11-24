package me.landervanlaer.toetsen.toets5;

public class Auto {
    private double maxSnelheid;
    private double snelheid = 0;
    private String merk;

    public Auto(double maxSnelheid, String merk) {
        this.maxSnelheid = maxSnelheid;
        this.merk = merk;
    }

    public double getMaxSnelheid() {
        return maxSnelheid;
    }

    public void setMaxSnelheid(double maxSnelheid) {
        this.maxSnelheid = maxSnelheid;
    }

    public double getSnelheid() {
        return snelheid;
    }

    public void setSnelheid(double snelheid) {
        if(snelheid > getMaxSnelheid() || snelheid < 0) return;
        this.snelheid = snelheid;
    }

    public String getMerk() {
        return merk;
    }

    public void setMerk(String merk) {
        this.merk = merk;
    }
}
