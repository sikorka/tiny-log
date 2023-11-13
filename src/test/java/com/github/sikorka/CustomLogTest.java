package com.github.sikorka;

import com.github.sikorka.tinylog.Color;
import com.github.sikorka.tinylog.Font;
import com.github.sikorka.tinylog.SpaceOut;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.github.sikorka.TinyLog.*;

/**
 * Shows usage of {@link Outfit).
 */
public class CustomLogTest {

    static Outfit previousOutfit = TinyLog.myOutfit;

    @BeforeAll
    public static void applyOutfitToLog() {
        Outfit bold = new Outfit()
                .sayColor(Color.YELLOW_BOLD) // INFO
                .loudColor(Color.NONE_BOLD)
                .highlightColor(Color.RED_BOLD)
                .highlightFont(Font.NONE)
                .shoutColor(Color.RED_BOLD)
                .shoutFont(Font.THIN_STRAIGHT)
                .setSpaceOut(SpaceOut.ONE_LINE);

        bold.applyLook();

        TinyLog.dressUp(bold);
    }

    @AfterAll
    public static void bringBackPreviousOutfit() {
        TinyLog.myOutfit = previousOutfit;
    }

    @Test
    void sayPlainTest() {
        writePlain("Writing plain.");
    }

    @Test
    void sayTest() {
        say("Just sayin.");
    }


    @Test
    void sayLoudTest() {
        sayLoud("Saying loud.");
    }

    @Test
    void shoutTest() {
        shout("Shouting!");
    }

    @Test
    void highlightTest() {
        highlight("Highlighting.");
    }

}
