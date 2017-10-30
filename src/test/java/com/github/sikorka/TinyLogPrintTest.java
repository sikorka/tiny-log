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
        whisper("In the depth of logs...");
        whisper("And unnoticed messages!");
        highlight("tiny-log");
        whisper("Did you see me?");
    }

    @Test
    public void highlightUppercaseTest() {
        whisper("Well, hello...");
        whisper("Let's spell this out loud:");
        highlight("TINY-LOG");
        whisper("Could you possibly not see me?");
    }

}
