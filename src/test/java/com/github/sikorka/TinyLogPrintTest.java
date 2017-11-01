package com.github.sikorka;

import org.junit.Test;

import static com.github.sikorka.TinyLog.*;

/**
 * Prints 'tiny log'.
 */
public class TinyLogPrintTest extends AbstractTinyLogTest {

    @Test
    public void sayCheck() {
        say("tiny-log");
    }

    @Test
    public void sayLouderCheck() {
        sayLoud("tiny-log");
    }

    @Test
    public void shoutCheck() {
        shout("tiny-log");
    }

    @Test
    public void highlightCheck() {
        blendIn("In the depth of logs...");
        blendIn("And unnoticed messages!");
        highlight("tiny-log");
        blendIn("Did you see me?");
    }

    @Test
    public void highlightUppercaseTest() {
        blendIn("Well, hello...");
        blendIn("Let's spell this out loud:");
        highlight("TINY-LOG");
        blendIn("Could you possibly not see me?");
    }

}
