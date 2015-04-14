package org.ucu.teoria2.actividad3;

import junit.framework.TestCase;
import org.ucu.utils.ReadStringFromFileLineByLine;

/**
 * Created by fernando on 14/04/15.
 */
public class TestParserCSV extends TestCase {

    String[] lineas;

    protected void setUp() {
        lineas = ReadStringFromFileLineByLine.read("sampleCSV.csv");
    }

    public void testCases() {
        for (String linea : lineas) {
            System.out.print("|");

            for (String s : ParserCSV.parse(linea)) {
                System.out.print(s + "|");
            }
            System.out.println();
        }
    }

}
