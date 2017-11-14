package com.github.sikorka;

import org.junit.Test;

import static com.github.sikorka.TinyLog.*;

/**
 * Checks tiny-log.
 */
public class TinyLogTest extends AbstractTinyLogTest {

    @Test
    public void sayCheck() {
        writePlain("In the depth of logs...");
        writePlain("And unnoticed messages!");
        say("I am saying something.");
        writePlain("Did you see me there?");
    }

    @Test
    public void sayLoudCheck() {
        sayLoud("I am saying something loud, so you notice me.");
    }

    @Test
    public void shoutCheck() {
        shout("Did you start Appium?");
    }

    @Test
    public void highlightCheck() {
        writePlain("In the depth of logs...");
        writePlain("And unnoticed messages!");
        highlight("I am highlighting a problem here, so you notice me.");
        writePlain("Did you see me?");
    }

    @Test
    public void highlightUppercaseTest() {
        writePlain("Well, hello...");
        writePlain("Let's spell this out loud:");
        highlight("I AM HIGHLIGHTING A PROBLEM HERE, SO YOU NOTICE ME.");
        writePlain("Could you possibly not see me?");
    }

    @Test
    public void highlightHoustonTest() {
        writePlain("In the depth of logs...");
        writePlain("And unnoticed messages!");
        highlight("Houston? We've got issues.");
        writePlain("Did you see me?");
    }

}
