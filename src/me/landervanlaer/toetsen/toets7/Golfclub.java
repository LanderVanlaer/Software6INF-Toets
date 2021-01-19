package me.landervanlaer.toetsen.toets7;

/**
 * A class concerning the merk and sterkte of a golfclub.
 *
 * @author Tom Van Geenhoven
 * @version 1.0
 */
public class Golfclub {

    /**
     * Variable registering the minimal strength of all golfclubs.
     */
    private static int MINIMALE_STERKTE = 80;


    /**
     * Variable registering the maximal strength of all golfclubs.
     */
    private static int MAXIMALE_STERKTE = 200;
    /**
     * Variable registering the merk of this golfclub.
     */
    private String merk = null;
    /**
     * Variable registering the sterkte of this golfclub.
     */
    private int sterkte = 80;


    /**
     * Initializes this new golfclub with a merk and a sterkte.
     *
     * @param merk    The merk to be initialised to this new golfclub.
     * @param sterkte The sterkte to be initialised to this new golfclub.
     * @post The merk of this new golfclub is initialised to the given merk
     * @post If the given sterkte is between the MINIMALE_STERKTE and the MAXIMALE_STERKTE,
     * and the given sterkte is dividable by 10, the sterkte of this new golfclub is set on the given sterkte.
     * @Exception The given sterkte is an invalid sterkte.
     */
    public Golfclub(String merk, int sterkte) {
        this.merk = merk;
        //TODO Maak hier gebruik van een exception om de sterkte te initialiseren
        if(!isValidSterkte(sterkte))
            throw new IllegalArgumentException("De gegeven sterkte is niet valid");
        this.sterkte = sterkte;
    }

    /**
     * Calculate the correct sterkte for a given sterkte.
     *
     * @param sterkte The sterkte to calculate the correct sterkte from.
     * @return Returns the MINIMALE_STERKTE of all golclubs if the given sterkte is below the MINIMALE_STERKTE of all golclubs, else
     * returns the MAXIMALE_STERKTE of all golclubs if the given sterkte is above the MAXIMALE_STERKTE of all golclubs,
     * else returns the given sterkte rounded downwards to the first sterkte dividable by 10.
     */
    private static int calculateSterkte(int sterkte) {
        if(sterkte < Golfclub.MINIMALE_STERKTE)
            return Golfclub.MINIMALE_STERKTE;
        if(sterkte > Golfclub.MAXIMALE_STERKTE)
            return Golfclub.MAXIMALE_STERKTE;
        return ((sterkte / 10) * 10);
    }

    /**
     * Checks whether the given sterkte is a valid sterkte for this golfclub.
     *
     * @param sterkte The sterkte to be checked.
     * @return Returns true if and only if the given sterkte is between the MINIMALE_STERKTE and the MAXIMALE_STERKTE of all golfclubs
     * and if the given sterkte is dividable by 10.
     */
    //TODO MAAK HIER UW CHECKER isValidSterkte
    public static boolean isValidSterkte(int sterkte) {
        return (sterkte >= MINIMALE_STERKTE && sterkte <= MAXIMALE_STERKTE) && (sterkte % 10 == 0);
    }

    /**
     * Returns the merk of this golfclub.
     */
    public String getMerk() {
        return this.merk;
    }

    /**
     * Sets the merk of this golfclub to the given merk.
     *
     * @param merk The merk to be set to this golfclub.
     * @post The given merk is set to the merk of this golfclub.
     */
    public void setMerk(String merk) {
        this.merk = merk;
    }

    /**
     * Returns the sterkte of this golfclub.
     */
    public int getSterkte() {
        return sterkte;
    }

    /**
     * Sets the sterkte of this golfclub to the given sterkte.
     *
     * @param sterkte The sterkte to be set to this golfclub.
     * @effect If the given sterkte is between the MINIMALE_STERKTE and the MAXIMALE_STERKTE,
     * and the given sterkte is dividable by 10, the sterkte of this golfclub is set on the given sterkte.
     * Otherwise, if the given sterkte is not dividable by 10 the sterkte of this golfclub is set on the first correct
     * sterkte, calculated as the given sterkte rounded downwards, if the given sterkte is below the MINIMALE_STERKTE,
     * the sterkte of this golfclub is set on the MINIMALE_STERKTE, if the given sterkte is above the MAXIMALE_STERKTE, the sterkte of this new golfclub is set on the MAXIMALE_STERKTE..
     */
    public void setSterkte(int sterkte) {
        this.sterkte = calculateSterkte(sterkte);
    }
}
