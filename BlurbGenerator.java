/*
 * **********************************************
 * San Francisco State University
 * CSC 220 -  Data Structures
 * File Name: BlurbGenerator.java
 * Author: Java Foundation
 * Author: Duc Ta
 * Author: Bryan Khor
 * **********************************************
 */

import java.util.Random;

public class BlurbGenerator {

    private Random random;
    /**
     * Instantiates a random number generator needed for blurb creation.
     */
    public BlurbGenerator() {
        this.random = new Random();
    }

    /**
     * Generates and returns a random Blurb. A Blurb is a Whoozit followed by
     * one or more Whatzits.
     */
    public String makeBlurb() {
        return makeWhoozit() + makeMultiWhatzits(random.nextInt(4) + 1);
    }

    /**
     * Generates a random Whoozit. A Whoozit is the character 'x' followed by
     * zero or more 'y's.
     */
    private String makeWhoozit() {
        return "x" + makeYString(random.nextInt(4));
    }

    /**
     * Recursively generates a string of zero or more 'y's.
     */
    private String makeYString(int count) {
        if (count != 0) {
            return makeYString(count - 1) + "y";
        }
        return "";
    }

    /**
     * Recursively generates a string of one or more Whatzits.
     */
    private String makeMultiWhatzits(int count) {
        String multi = "";
        if (count == 1) {
            return makeWhatzit();
        } else {
            multi += makeMultiWhatzits(count - 1) + makeWhatzit();
        }
        return multi;
    }

    /**
     * Generates a random Whatzit. A Whatzit is a 'q' followed by either a 'z'
     * or a 'd', followed by a Whoozit.
     */
    private String makeWhatzit() {
        String ZorD = "";

        int random = (int) (Math.random() * 2);

        if (random == 0) {
            ZorD = "z";
        } else {
            ZorD = "d";
        }

        return "q" + ZorD + makeWhoozit();
    }

    public Random getRandom() {
        return random;
    }

    public void setRandom(Random random) {
        this.random = random;
    }
}
