package com.mobiquityinc.utils;

/**
 * Utility class to read all data from input file format's
 *
 * @author Lucas Nascimento
 */
public class ReaderHelper {

    /**
     * Validate if line has correct amount of tokens
     *
     * @param line to read
     * @return true if line is valid
     */
    static boolean validateLine(String line) {
        return line.split(" ") .length >= 3 ;
    }



}
