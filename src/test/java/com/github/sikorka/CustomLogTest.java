package com.github.sikorka;

import com.github.sikorka.tinylog.Color;
import com.github.sikorka.tinylog.Font;
import com.github.sikorka.tinylog.SpaceOut;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import static com.github.sikorka.TinyLog.*;

/**
 * Shows usage of {@link Outfit).
 */
public class CustomLogTest {

    static Outfit previousOutfit = TinyLog.myOutfit;

    @BeforeClass
    public static void applyOutfitToLog() {
        Outfit bold = new Outfit()
                .sayColor(Color.YELLOW_BOLD) // INFO
                .loudColor(Color.NONE_BOLD)
                .highlightColor(Color.RED_BOLD)
                .highlightFont(Font.NONE)
                .shoutColor(Color.RED_BOLD)
                .shoutFont(Font.STRAIGHT)
                .setSpaceOut(SpaceOut.ONE_LINE);

        bold.applyLook();

        TinyLog.dressUp(bold);

        new TinyLog(bold);
    }

    @AfterClass
    public static void bringBackPreviousOutfit() {
        TinyLog.myOutfit = previousOutfit;
    }

    @Test
    public void sayPlainTest() {
        writePlain("Writing plain.");
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
        shout("Shouting!");
    }

    @Test
    public void highlightTest() {
        highlight("Highlighting.");
    }

}
