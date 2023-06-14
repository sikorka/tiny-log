package com.github.sikorka;

import com.github.sikorka.tinylog.Case;
import com.github.sikorka.tinylog.Color;
import com.github.sikorka.tinylog.Font;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;

/**
 * My Log is a custom logger using Tiny Log's API.
 */
public class MyLogTest extends TinyLog {

    static Outfit previousOutfit = TinyLog.myOutfit;

    public MyLogTest() {
        super(new Outfit()
                .shoutColor(Color.BG_BLUE_YELLOW_INTENSE_FG)
                .shoutFont(Font.BIG)
                .highlightColor(Color.BLUE)
                .highlightFont(Font.THIN_STRAIGHT)
                .loudColor(Color.BOLD_PURPLE)
                .sayLouderCase(Case.UPPER)
                .sayColor(Color.YELLOW));
    }

    @AfterAll
    public static void bringBackPreviousOutfit() {
        TinyLog.myOutfit = previousOutfit;
    }

    @Test
    public void sayTest() {
        say("Just sayin in non-bold yellow.");
    }

    @Test
    public void sayLoudTest() {
        sayLoud("Saying loud in uppercase with bold purple.");
    }

    @Test
    public void shoutTest() {
        shout("Shouting blue bg with bold bright yellow text.");
    }

    @Test
    public void highlightTest() {
        highlight("HIGHLIGHTING in non-bold blue.");
    }

}
