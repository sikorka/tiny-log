package com.github.sikorka;

import com.github.sikorka.tinylog.Case;
import com.github.sikorka.tinylog.Color;
import com.github.sikorka.tinylog.Font;
import com.github.sikorka.tinylog.SpaceOut;

/**
 * Dresses up {@link TinyLog} in pretty colors / sizes and fonts.
 */
public class Outfit {
    //TODO add specific texts before msg, like [DEBUG]
    //highlight just that text

    //TODO create predefined, lazy loggers
    //GIRLY - with pink (and blue?) colors
    //DEFAULT
    //SUBTLE - making bold msg but same color (is it possible?)
    //DRAMA - with bold fonts and backgrounds
    //STAR WARS :))))
    //BLANK

    private Color sayColor = Color.YELLOW_BOLD;
    private Color loudColor = Color.RED_BOLD;
    private Color highlightColor = Color.RED_BOLD_INTENSE;
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


    public Outfit sayColor(Color color) {
        if (color == null) {
            this.sayColor = Color.NONE;
            return this;
        }

        this.sayColor = color;

        return this;
    }

    public Outfit loudColor(Color color) {
        if (color == null) {
            this.loudColor = Color.NONE;
            return this;
        }

        this.loudColor = color;

        return this;
    }

    Outfit highlightColor(Color color) {
        if (color == null) {
            this.highlightColor = Color.NONE;
            return this;
        }

        this.highlightColor = color;

        return this;
    }

    public Outfit shoutColor(Color color) {
        if (color == null) {
            this.shoutColor = Color.NONE;
            return this;
        }

        this.shoutColor = color;

        return this;
    }

    //noColor
    //yellow
    //redBold


    public Outfit highlightFont(Font font) {
        this.highlightFont = font;

        return this;
    }

    public Outfit shoutFont(Font font) {
        this.shoutFont = font;

        return this;
    }

    //normalSize
    //medium
    //huge

    /**
     * Returns {@link TinyLog} dressed up in this outfit.
     * Do this only one time in any place of your app
     * to configure the how {@link TinyLog} displays
     * messages from now on.
     *
     * @return the single instance of {@link TinyLog}
     * */
    TinyLog applyLook() {
        return new TinyLog(this);
    }



    public Outfit setClearScreen(SpaceOut size) {
        clearScreenSize = size;

        return this;
    }

    public Outfit setSpaceOut(SpaceOut size) {
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
        Outfit b = new Outfit()
                .shoutColor(Color.BOLD_PURPLE)
                .shoutFont(Font.THREEPOINT);

        TinyLog log = new TinyLog(b);

        log.say("I I, sir.");
        log.shout("Nothin.");
    }



    //create

//    //Usage
//    new Outfit().
    //    upper(). //if upper then huge will set width differently
//        huge().
//        yellow().
//        newLine();

//    new Outfit().
//        yellow().
//        huge().
//        newLine();

}