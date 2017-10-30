package com.github.sikorka;

import org.junit.Test;

import static com.github.sikorka.TinyLog.*;

/**
 * Checks tinylog.
 */
public class TinyLogNullTest extends AbstractTinyLogTest {


    @Test
    public void sayNull() {
        whisper("In the depth of logs...");
        whisper("And unnoticed messages!");
        say(null);
        whisper("See? That works.");
    }

    @Test
    public void sayNullLouder() {
        sayLoud(null);
    }

    @Test
    public void shoutNull() {
        shout(null);
    }

    @Test
    public void highlightNull() {
        highlight(null);
    }

}
