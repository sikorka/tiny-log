package com.github.sikorka;

import org.junit.After;

import static com.github.sikorka.TinyLog.*;

/**
 * A base class for any tinylog tests.
 */
public abstract class AbstractTinyLogTest {

    @After
    public void afterCheck() {
        spaceOut();
    }

}
