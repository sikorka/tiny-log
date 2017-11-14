package com.github.sikorka;

import com.github.sikorka.tinylog.Color;
import com.github.sikorka.tinylog.Font;
import org.junit.AfterClass;
import org.junit.Test;

/**
 * My Log is a custom logger using Tiny Log's API.
 */
public class MyLogTest extends TinyLog {

    static Outfit previousOutfit = TinyLog.myOutfit;

    public MyLogTest() {
        super(new Outfit()
                .shoutColor(Color.BG_BLUE_YELLOW_INTENSE_FG)
                .shoutFont(Font.STANDARD)
                .highlightColor(Color.BLUE)
                .loudColor(Color.BOLD_PURPLE)
                .sayColor(Color.YELLOW));
    }

    @AfterClass
    public static void bringBackPreviousOutfit() {
        TinyLog.myOutfit = previousOutfit;
    }

    @Test
    public void sayTest() {
        say("Just sayin.");
    }

    @Test
    public void sayLoudTest() {
        sayLoud("Saying loud.");
    }

    @Test
    public void shoutTest() {
        shout("Shouting blue bg with bold bright yellow text.");
    }

    @Test
    public void highlightTest() {
        highlight("Highlighting.");
    }

}
