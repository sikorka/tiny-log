package com.github.sikorka;

import org.junit.jupiter.api.AfterEach;

import static com.github.sikorka.TinyLog.*;

/**
 * A base class for any tinylog tests.
 */
public abstract class AbstractTinyLogTest {

    @AfterEach
    public void afterCheck() {
        spaceOut();
    }

}
