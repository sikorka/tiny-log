package com.github.sikorka;

import com.github.sikorka.tinylog.Case;
import com.github.sikorka.tinylog.Color;
import com.github.sikorka.tinylog.Font;
import com.github.sikorka.tinylog.SpaceOut;

import static com.github.sikorka.TinyLog.*;

/**
 * Dresses up {@link TinyLog} in pretty colors / sizes and fonts.
 */
public class Outfit {

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
     * Recommended are {@link Font#THIN_MINI}, {@link Font#THIN_STRAIGHT} or {@link Font#THIN_STRAIGHT}.
     */
    private Font highlightFont = Font.THIN_STRAIGHT;

    /**
     * Recommended are {@link Font#BIG}, {@link Font#BIG_CURSIVE}.
     */
    private Font shoutFont = Font.BIG_CURSIVE;

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

    public Outfit highlightColor(Color color) {
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
        if (font == null) {
            this.highlightFont = Font.NONE;
            return this;
        }

        this.highlightFont = font;
        return this;
    }

    public Outfit shoutFont(Font font) {
        if (font == null) {
            this.shoutFont = Font.NONE;
            return this;
        }

        this.shoutFont = font;
        return this;
    }

    public Outfit shoutCase(Case c) {
        if (c == null) {
            this.shoutCase = Case.LOWER;
            return this;
        }

        this.shoutCase = c;
        return this;
    }

    public Outfit sayCase(Case c) {
        if (c == null) {
            this.sayCase = Case.LOWER;
            return this;
        }

        this.sayCase = c;
        return this;
    }

    public Case getSayCase() {
        return sayCase;
    }

    public Case getSayLouderCase() {
        return sayLouderCase;
    }

    public Case getHighlightCase() {
        return highlightCase;
    }

    public Case getShoutCase() {
        return shoutCase;
    }

    public Outfit sayLouderCase(Case c) {
        if (c == null) {
            this.sayLouderCase = Case.LOWER;
            return this;
        }

        this.sayLouderCase = c;
        return this;
    }

    public Outfit highlightCase(Case c) {
        if (c == null) {
            this.highlightCase = Case.LOWER;
            return this;
        }

        this.highlightCase = c;
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
    public void applyLook() {
        TinyLog.dressUp(this);
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


    public static void main(String[] args) {
        Outfit b = new Outfit()
                .shoutColor(Color.BOLD_PURPLE)
                .shoutFont(Font.THIN_STRAIGHT)
                .shoutCase(Case.UPPER);
        dressUp(b);
        say("------ colors");
        say("say");
        shout("shout!");


        Outfit a = new Outfit()
                .shoutFont(null)
                .highlightFont(null);
        dressUp(a);
        say("------ fonts");
        shout("shouting");
        highlight("highlight");
        say("say");
        sayLoud("say loud");

        Outfit c = new Outfit()
                .sayCase(Case.UPPER)
                .shoutCase(Case.UPPER)
                .highlightCase(Case.UPPER)
                .sayLouderCase(Case.UPPER);
        TinyLog.dressUp(c);
        say("------ upper lower case");
        say("say");
        shout("shouted");
        highlight("highlight");
        sayLoud("say loud");
    }



    //create

//    //Usage
//    new Outfit().
//        upper(). //if upper then huge will set width differently
//        huge().
//        yellow().
//        newLine();

//    new Outfit().
//        yellow().
//        huge().
//        newLine();

}