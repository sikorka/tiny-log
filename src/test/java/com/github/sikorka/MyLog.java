package com.github.sikorka;

import com.github.sikorka.tinylog.Color;
import com.github.sikorka.tinylog.Font;

/**
 * My Log is a custom log using Tiny Log's API.
 */
public class MyLog extends TinyLog {
    private TinyLogOutfit tinyLogBuilder;

    public MyLog() {
        super(new TinyLogOutfit()
            .highlightColor(Color.BLUE)
            .shoutFont(Font.SLANT));
    }


    public static void main(String args[]) {
        //TODO add unit tests for another log creation
        MyLog me = new MyLog();

        me.shout("aaa");
        me.highlight("I I, wow!");
    }

}
