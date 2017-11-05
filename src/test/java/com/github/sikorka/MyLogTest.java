package com.github.sikorka;

import com.github.sikorka.tinylog.Color;
import org.junit.Test;

/**
 * My Log is a custom log using Tiny Log's API.
 */
public class ZMyLogTest extends TinyLog {
    private TinyLogOutfit tinyLogBuilder;

    public ZMyLogTest() {
        super(new TinyLogOutfit()
                .shoutColor(Color.BACKGROUND_INTENSE_YELLOW)
                .highlightColor(Color.BACKGROUND_YELLOW)
                .loudColor(Color.UNDERLINED_YELLOW)
                .sayColor(Color.YELLOW));
    }


    @Test
    public void sayTest() {
        this.say("Somethin...");
    }

    @Test
    public void sayLoudTest() {
        this.sayLoud("Nothin much :}");
    }

    @Test
    public void shoutTest() {
        this.shout("Abc");
    }

    @Test
    public void highlightTest() {
        this.highlight("I I, wow!");
    }
}
