package com.github.sikorka;

import com.github.lalyos.jfiglet.FigletFont;
import com.github.sikorka.tinylog.Color;
import com.github.sikorka.tinylog.Font;
import com.github.sikorka.tinylog.SpaceOut;

import java.io.PrintStream;
import java.util.Arrays;

/**
 * Tiny logger.
 * <p>
 * Delivers tiny API for printing msgs to standard out.
 * Prints them with string effects for each msg type.
 * <p>
 * Makes log messages more readable and thus reading logs easier.
 *
 * <p>
 * TODO describe the API's basic usage here
 */
public class TinyLog {

    private static final PrintStream OUT = System.out;

    static TinyLogOutfit myOutfit = new TinyLogOutfit()
            .shoutColor(Color.BOLD_PURPLE)
            .shoutFont(Font.STANDARD);

    /**
     * Do this one time in any place of your app
     * to configure {@link TinyLog} permanently.
     *
     * @param outfit the proud outfit of the Tiny Log looks
     * */
    public TinyLog(TinyLogOutfit outfit) {
        myOutfit = outfit;
    }

    /**
     * Logs object to standard out in color {@link TinyLogOutfit#getSayColor()}.
     *
     * @param ob any object
     */
    public static void say(Object ob) {
        writePlainAndNoLine(myOutfit.getSayColor(), String.valueOf(ob));
        newLine();
    }

    /**
     * Logs array to standard out.
     *
     * @param array any object
     */
    public static void say(Object[] array) {
        say(Arrays.toString(array));
    }

    /**
     * Adds significant space between log msgs to standard out.
     */
    public static void spaceOut() {
        writePlainAndNoLine(myOutfit.getSpaceToAdd());
    }

    /**
     * Highlights object at standard out.
     * <p>
     * Prints string of any length to standard out in {@link TinyLogOutfit#getLoudColor()}.
     *
     * @param ob any object
     */
    public static void sayLoud(Object ob) {
        sayLoudNoLine(ob);
        newLine();
    }

    private static void sayLoudNoLine(Object ob) {
        writePlainAndNoLine(myOutfit.getLoudColor(), ob);

    }

    /**
     * Prints plain object to standard out - no colors, no highlight, no new line.
     *
     * @param ob any object to be printed
     * @param color the print color to be used
     */
    protected static void writePlainAndNoLine(Color color, Object ob) {
        if (ob == null) {
            writePlainAndNoLine(color.toString() + ob + RESET);
            return;
        }

        String[] lines = ob.toString().split(System.lineSeparator());
        for (String line : lines)
            writePlain(color.toString() + line + RESET);
    }

    /**
     * Prints plain object to standard out - no colors, no highlight, no new line.
     *
     * @param ob any object
     */
    protected static void writePlainAndNoLine(Object ob) {
        OUT.print(ob);
    }

    /**
     * Prints plain object to standard out (no colors, no highlight) + new line.
     *
     * @param ob any object
     */
    static void writePlain(Object ob) {
        writePlainAndNoLine(ob);
        newLine();
    }

    /**
     * Prints plain object to standard out (no colors, no highlight) + new line.
     *
     * @param ob any object
     */
    static void writePlain(Color color, Object ob) {
        writePlainAndNoLine(color, ob);
        newLine();
    }

    /**
     * Prints new line to standard out.
     */
    protected static void newLine() {
        OUT.println();
    }

    /**
     * Can't stay unnoticed. Draws big string to standard out using {@link TinyLogOutfit#getHighlightFont()}.
     *
     * Uses object's <code>toString()</code> method to draw its representations.
     * Wraps the string at {@link Font#getMaxOneLinerChars()}.
     *
     * @param something anything to print
     */
    public static void highlight(Object something) {
        useBigFont(myOutfit.getHighlightFont(), myOutfit.getHighlightColor(), something);
    }

    /**
     * Can't stay unnoticed. Draws huge string to standard out using {@link TinyLogOutfit#getShoutFont()}.
     * <p>
     * Uses object's <code>toString()</code> method to draw its representations.
     * Wraps the string at {@link Font#getMaxOneLinerChars()}.
     *
     * @param ob any object
     */
    public static void shout(Object ob) {
        useBigFont(myOutfit.getShoutFont(), myOutfit.getShoutColor(), ob);
    }

    private static void useBigFont(Font font, Color color, Object ob) {
        Object[] brokenString = Wrapper.breakAfter(
                String.valueOf(ob),
                font.getMaxOneLinerChars());

        try {
            for (Object line : brokenString)
                writePlainAndNoLine(color,
                        FigletFont.convertOneLine(
                                font.getFontPathForFiglet(),
                                String.valueOf(line)));
        } catch (Exception e) {
            handleException(e, brokenString);
        }
    }

    private static void handleException(Exception e, Object ob) {
        sayLoud("Problem with font! " + e.getCause());
        e.printStackTrace();

        sayLoud(ob);
    }

    /** Adds a lot of empty lines, see @{@link SpaceOut#SCREEN}. */
    public static void clearScreen() {
        writePlainAndNoLine(SpaceOut.SCREEN);
    }

    private static final Color RESET = Color.RESET_CURRENT_COLOR;

}