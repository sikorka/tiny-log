package com.github.sikorka;

import com.github.sikorka.tinylog.Case;
import com.github.sikorka.tinylog.Color;
import com.github.sikorka.tinylog.Font;
import com.github.sikorka.tinylog.SpaceOut;

/**
 * Dresses up {@link TinyLog} in pretty colors / sizes and fonts.
 */
public class TinyLogOutfit {
    //TODO add specific texts before msg, like [DEBUG]
    //highlight just that text

    //TODO create predefined, lazy loggers
    //GIRLY - with pink (and blue?) colors
    //DEFAULT
    //SUBTLE - making bold msg but same color (is it possible?)
    //DRAMA - with bold fonts and backgrounds
    //STAR WARS :))))
    //BLANK

    //TODO add background / foreground colors

    private Color sayColor = Color.BOLD_YELLOW;
    private Color loudColor = Color.BOLD_RED;
    private Color highlightColor = Color.BOLD_INTENSE_RED;
    private Color shoutColor = highlightColor;

    /**
     * Recommended are {@link Font#MINI}, {@link Font#STRAIGHT} or {@link Font#THREEPOINT}.
     */
    private Font highlightFont = Font.STRAIGHT;
    /**
     * Recommended are {@link Font#STANDARD}, {@link Font#SLANT}.
     */
    private Font shoutFont = Font.SLANT;

    //TODO methods for cases
    private Case sayCase = Case.LOWER;
    private Case sayLouderCase = Case.LOWER;
    private Case highlightCase = Case.LOWER;
    private Case shoutCase = Case.LOWER;

    private SpaceOut spaceOutSize = SpaceOut.MEDIUM;

    private SpaceOut clearScreenSize = SpaceOut.SCREEN;


    public TinyLogOutfit sayColor(Color color) {
        if (color == null) {
            this.sayColor = Color.NO_COLOR;
            return this;
        }

        this.sayColor = color;

        return this;
    }

    public TinyLogOutfit loudColor(Color color) {
        if (color == null) {
            this.loudColor = Color.NO_COLOR;
            return this;
        }

        this.loudColor = color;

        return this;
    }

    TinyLogOutfit highlightColor(Color color) {
        if (color == null) {
            this.highlightColor = Color.NO_COLOR;
            return this;
        }

        this.highlightColor = color;

        return this;
    }

    public TinyLogOutfit shoutColor(Color color) {
        if (color == null) {
            this.shoutColor = Color.NO_COLOR;
            return this;
        }

        this.shoutColor = color;

        return this;
    }

    //noColor
    //yellow
    //redBold


    public TinyLogOutfit highlightFont(Font font) {
        this.highlightFont = font;

        return this;
    }

    public TinyLogOutfit shoutFont(Font font) {
        this.shoutFont = font;

        return this;
    }

    //normalSize
    //medium
    //huge

    TinyLog build() {
        return new TinyLog(this);
    }



    public TinyLogOutfit setClearScreen(SpaceOut size) {
        clearScreenSize = size;

        return this;
    }

    public TinyLogOutfit setSpaceOut(SpaceOut size) {
        spaceOutSize = size;

        return this;
    }

    //newLine
    //spaceOut

    public String getSpaceOut() {
        return spaceOutSize.getSpace();
    }

    public String getClearScreen() {
        return clearScreenSize.getSpace();
    }

    public Color getHighlightColor() {
        return highlightColor;
    }

    public Color getSayColor() {
        return sayColor;
    }

    public Color getLoudColor() {
        return loudColor;
    }

    public Color getShoutColor() {
        return shoutColor;
    }

    public Font getHighlightFont() {
        return highlightFont;
    }

    public Font getShoutFont() {
        return shoutFont;
    }


    public static void main(String args[]) {
        TinyLogOutfit b = new TinyLogOutfit()
                .shoutColor(Color.BOLD_PURPLE)
                .shoutFont(Font.THREEPOINT);

        TinyLog log = new TinyLog(b);

        log.say("I I, sir.");
        log.shout("Nothin.");
    }



    //create

//    //Usage
//    new TinyLogOutfit().
    //    upper(). //if upper then huge will set width differently
//        huge().
//        yellow().
//        newLine();

//    new TinyLogOutfit().
//        yellow().
//        huge().
//        newLine();

}