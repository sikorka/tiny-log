package com.github.sikorka;

import org.junit.Test;

import static com.github.sikorka.TinyLog.*;

/**
 * Checks tiny-log.
 */
public class TinyLogTest extends AbstractTinyLogTest {

    @Test
    public void sayCheck() {
        whisper("In the depth of logs...");
        whisper("And unnoticed messages!");
        say("I am saying something.");
        whisper("Did you see me there?");
    }

    @Test
    public void sayLouderCheck() {
        sayLoud("I am saying something sayLoud, so you notice me.");
    }

    @Test
    public void shoutCheck() {
        shout("Did you start Appium?");
    }

    @Test
    public void highlightCheck() {
        whisper("In the depth of logs...");
        whisper("And unnoticed messages!");
        highlight("I am highlighting a problem here, so you notice me.");
        whisper("Did you see me?");
    }

    @Test
    public void highlightUppercaseTest() {
        whisper("Well, hello...");
        whisper("Let's spell this out loud:");
        highlight("I AM HIGHLIGHTING A PROBLEM HERE, SO YOU NOTICE ME.");
        whisper("Could you possibly not see me?");
    }

    @Test
    public void highlightHoustonTest() {
        whisper("In the depth of logs...");
        whisper("And unnoticed messages!");
        highlight("Houston? We've got issues.");
        whisper("Did you see me?");
    }

}
