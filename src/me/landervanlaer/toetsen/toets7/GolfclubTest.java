package me.landervanlaer.toetsen.toets7;


import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GolfclubTest {
    private Golfclub golfclub;

    @Before
    public void setUp() throws Exception {
        golfclub = new Golfclub("IKBR", 120);
    }

    @Test
    public void constructorTestLegal() {
        Golfclub golfclub = new Golfclub("kd", 90);
        assertEquals("kd", golfclub.getMerk());
        assertEquals(90, golfclub.getSterkte());
    }

    @Test(expected = IllegalArgumentException.class)
    public void constructorTestIllegal() throws IllegalArgumentException {
        Golfclub golfclub = new Golfclub("kd", 70);
    }

    @Test
    public void setSterkte_10() {
        golfclub.setSterkte(10);
        assertEquals(80, golfclub.getSterkte());
    }

    @Test
    public void setSterkte_99() {
        golfclub.setSterkte(99);
        assertEquals(90, golfclub.getSterkte());
    }


    @Test
    public void setSterkte_210() {
        golfclub.setSterkte(210);
        assertEquals(200, golfclub.getSterkte());
    }

    @Test
    public void setSterkte_150() {
        golfclub.setSterkte(150);
        assertEquals(150, golfclub.getSterkte());
    }

}