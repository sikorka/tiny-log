package com.github.sikorka

import spock.lang.Specification
import spock.lang.Unroll

import static com.github.sikorka.TinyLog.*


/**
 * Tests {@Wrapper}.
 */
class WrapperTest extends Specification {

    String[] lines;

    @Unroll
    def "should break text into #linesAmount lines"() {

        given:
        String longString = "I am highlighting a problem here, so you notice. ";

        when:
        lines = Wrapper.breakAfter(longString, maxLengthInLine);

        then:
        lines.size() == linesAmount;

        where:
        maxLengthInLine | linesAmount
        100           | 1
        14            | 4
        13            | 5
        12            | 5
        11            | 5
        10            | 6
        9             | 6
        8             | 7
        7             | 7
        6             | 7
        5             | 8
        4             | 8
        3             | 9
        2             | 9
        1             | 9

    }

    @Unroll
    def "when text is '#text' and maxLengthInLine is #maxLengthInLine, then breaking does not work - null returned"() {

        when:
        String[] lines = Wrapper.breakAfter(text, maxLengthInLine);

        then:
        lines == null

        where:
        text       | maxLengthInLine
        null       | 100
        null       | 0
        null       | -1
        null       | -100
        "a bb c"   | 0
        "aaa bb c" | -1
        "a b c"    | -100

    }

    def "should handle null, empty and blank strings well"() {

        when:
        lines = Wrapper.breakAfter(text, maxLineLength);

        then:
        lines.size() == 0

        where:
        text             | maxLineLength
        ""               | 100
        " "              | 100
        "\t\n   "        | 100
        "   \t\t  \n   " | 100

    }

    def cleanup() {
        say(lines);
    }

}
