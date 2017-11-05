package com.github.sikorka;

import com.github.sikorka.tinylog.Case;
import com.github.sikorka.tinylog.Color;
import com.github.sikorka.tinylog.Font;
import com.github.sikorka.tinylog.SpaceOut;

/**
 * Dresses up {@link TinyLog} in pretty colors / sizes and fonts.
 */
public class TinyLogOutfit {
    //TODO create predefined, lazy loggers
    //GIRLY - with pink (and blue?) colors
    //DEFAULT
    //SUBTLE - making bold msg but same color (is it possible?)
    //DRAMA - with bold fonts and backgrounds
    //STAR WARS :))))
    //BLANK

    private Color sayColor = Color.INTENSE_YELLOW;
    private Color loudColor = Color.BOLD_RED;
    private Color highlightColor = loudColor;
    private Color shoutColor = loudColor;

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

    private SpaceOut spaceOutSize = SpaceOut.HUGE;


    public TinyLogOutfit sayColor(Color color) {
        this.sayColor = color;

        return this;
    }

    public TinyLogOutfit loudColor(Color color) {
        this.loudColor = color;

        return this;
    }

    TinyLogOutfit highlightColor(Color color) {
        this.highlightColor = color;

        return this;
    }

    public TinyLogOutfit shoutColor(Color color) {
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

    //newLine
    //spaceOut

    public String getSpaceToAdd() {
        return spaceOutSize.getSpace();
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


    public TinyLogOutfit setSpaceOut(SpaceOut size) {
        spaceOutSize = size;

        return this;
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

}