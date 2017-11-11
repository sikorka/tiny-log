package com.github.sikorka;

import com.github.sikorka.tinylog.Color;
import org.junit.AfterClass;
import org.junit.Test;

/**
 * My Log is a custom logger using Tiny Log's API.
 */
public class MyLogTest extends TinyLog {

    static TinyLogOutfit previousOutfit = TinyLog.myOutfit;

    public MyLogTest() {
        super(new TinyLogOutfit()
                .shoutColor(Color.BACKGROUND_INTENSE_YELLOW)
                .highlightColor(Color.BACKGROUND_YELLOW)
                .loudColor(Color.BOLD_PURPLE)
                .sayColor(Color.YELLOW));
    }

    @AfterClass
    public static void bringBackPreviousOutfit() {
        TinyLog.myOutfit = previousOutfit;
    }

    @Test
    public void sayTest() {
        say("Somethin...");
    }

    @Test
    public void sayLoudTest() {
        sayLoud("Nothin much :}");
    }

    @Test
    public void shoutTest() {
        shout("Abc");
    }

    @Test
    public void highlightTest() {
        highlight("I I, wow!");
    }

}
