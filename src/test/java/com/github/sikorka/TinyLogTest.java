package com.github.sikorka;

import org.junit.Test;

import static com.github.sikorka.TinyLog.*;

/**
 * Checks tiny-log.
 */
public class TinyLogTest extends AbstractTinyLogTest {

    @Test
    public void sayCheck() {
        blendIn("In the depth of logs...");
        blendIn("And unnoticed messages!");
        say("I am saying something.");
        blendIn("Did you see me there?");
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
        blendIn("In the depth of logs...");
        blendIn("And unnoticed messages!");
        highlight("I am highlighting a problem here, so you notice me.");
        blendIn("Did you see me?");
    }

    @Test
    public void highlightUppercaseTest() {
        blendIn("Well, hello...");
        blendIn("Let's spell this out loud:");
        highlight("I AM HIGHLIGHTING A PROBLEM HERE, SO YOU NOTICE ME.");
        blendIn("Could you possibly not see me?");
    }

    @Test
    public void highlightHoustonTest() {
        blendIn("In the depth of logs...");
        blendIn("And unnoticed messages!");
        highlight("Houston? We've got issues.");
        blendIn("Did you see me?");
    }

}
