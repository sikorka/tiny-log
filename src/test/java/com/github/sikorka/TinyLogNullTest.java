package com.github.sikorka;

import org.junit.jupiter.api.Test;

import static com.github.sikorka.TinyLog.*;

/**
 * Checks tinylog.
 */
public class TinyLogNullTest extends AbstractTinyLogTest {

    @Test
    public void sayNull() {
        writePlain("In the depth of logs...");
        writePlain("And unnoticed messages!");
        say(null);
        writePlain("See? That works.");
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
