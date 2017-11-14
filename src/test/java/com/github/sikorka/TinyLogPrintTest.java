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
    public void highlightCheck() {
        writePlain("In the depth of logs...");
        writePlain("And unnoticed messages!");
        highlight("tiny-log");
        writePlain("Did you see me?");
    }

    @Test
    public void highlightUppercaseTest() {
        writePlain("Well, hello...");
        writePlain("Let's spell this out loud:");
        highlight("TINY-LOG");
        writePlain("Could you possibly not see me?");
    }

    @Test
    public void shoutCheck() {
        shout("tiny-log");
    }

}
