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
 * TODO describe here the API's basic usage
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
     * @param toBePrinted any object
     */
    public static void say(String toBePrinted) {
        writePlainNoLine(
                myOutfit.getSayColor(),
                toBePrinted);

        newLine();
    }

//    /**
//     * Logs array to standard out.
//     *
//     * @param arrayToPrint an array object
//     */
//    public static void say(Object[] arrayToPrint) {
//        say(Arrays.toString(arrayToPrint));
//    }

    /**
     * Highlights object at standard out.
     * <p>
     * Prints string of any length to standard out in {@link TinyLogOutfit#getLoudColor()}.
     *
     * @param toBePrinted any object
     */
    public static void sayLoud(String toBePrinted) {
        sayLoudNoLine(toBePrinted);
        newLine();
    }

    private static void sayLoudNoLine(String toBePrinted) {
        writePlainNoLine(myOutfit.getLoudColor(), toBePrinted);

    }

    /**
     * Prints plain object to standard out - no colors, no highlight, no new line.
     *
     * @param toBePrinted any object to be printed
     * @param printColor the print color to be used
     */
    protected static void writePlainNoLine(Color printColor, String toBePrinted) {
        if (toBePrinted == null ||
                !toBePrinted.contains(System.lineSeparator())) {
            writePlainNoLine(printColor + toBePrinted + RESET);
            return;
        }

        String[] lines = toBePrinted.split(System.lineSeparator());
        for (String line : lines)
            writePlain(printColor + line + RESET);
    }

    /**
     * Prints plain object to standard out - no colors, no highlight, no new line.
     *
     * @param toBePrinted any object
     */
    protected static void writePlainNoLine(String toBePrinted) {
        OUT.print(toBePrinted);
    }

    /**
     * Prints plain object to standard out (no colors, no highlight) + new line.
     *
     * @param toBePrinted any object
     */
    static void writePlain(String toBePrinted) {
        writePlainNoLine(toBePrinted);
        newLine();
    }

    /**
     * Prints plain object to standard out (no colors, no highlight) + new line.
     *
     * @param toBePrinted any object
     */
    static void writePlain(Color color, String toBePrinted) {
        writePlainNoLine(color, toBePrinted);
        newLine();
    }

    /**
     * Can't stay unnoticed. Draws big string to standard out using {@link TinyLogOutfit#getHighlightFont()}.
     *
     * Uses object's <code>toString()</code> method to draw its representations.
     * Wraps the string at {@link Font#getMaxCharsInOneLine()}.
     *
     * @param somethingToPrint anything to print
     */
    public static void highlight(String somethingToPrint) {
        writeInBigFont(
                myOutfit.getHighlightFont(),
                myOutfit.getHighlightColor(),
                somethingToPrint);
    }

    /**
     * Can't stay unnoticed. Draws huge string to standard out using {@link TinyLogOutfit#getShoutFont()}.
     * <p>
     * Uses object's <code>toString()</code> method to draw its representations.
     * Wraps the string at {@link Font#getMaxCharsInOneLine()}.
     *
     * @param toBePrinted any object to be printed
     */
    public static void shout(String toBePrinted) {
        writeInBigFont(
                myOutfit.getShoutFont(),
                myOutfit.getShoutColor(),
                toBePrinted);
    }

    private static void writeInBigFont(Font useFont, Color useColor, String ob) {
        if (useFont == null ||
                useFont == Font.NO_FONT) {
            writePlainNoLine(useColor, String.valueOf(ob));
            return;
        }

        String[] brokenString = Wrapper.breakText(
                String.valueOf(ob),
                useFont.getMaxCharsInOneLine());

        try {
            for (String line : brokenString)
                writePlainNoLine(
                        useColor,
                        FigletFont.convertOneLine(
                            useFont.getFontPath(),
                            line)
                );
        } catch (Exception e) {
            handleException(e, brokenString);
        }
    }

    private static void handleException(Exception e, Object toBePrinted) {
        sayLoud("Problem with font! " + e.getCause());
        e.printStackTrace();

        sayLoud(String.valueOf(toBePrinted));
    }

    /**
     * Prints new line to standard out.
     */
    protected static void newLine() {
        OUT.println();
    }


    /**
     * Adds significant space between log msgs to standard out.
     */
    public static void spaceOut() {
        writePlainNoLine(myOutfit.getSpaceOut());
    }

    /** Adds a lot of empty lines, see @{@link SpaceOut#SCREEN}. */
    public static void clearScreen() {
        writePlainNoLine(myOutfit.getClearScreen());
    }

    private static final Color RESET = Color.RESET_CURRENT_COLOR;

}