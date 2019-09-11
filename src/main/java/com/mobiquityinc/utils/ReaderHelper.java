package com.mobiquityinc.utils;

import com.mobiquityinc.exception.APIException;
import com.mobiquityinc.model.Item;
import com.mobiquityinc.model.Package;

import java.io.File;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

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

    /**
     * Utility method to read holy file
     *
     * @param path to input file
     * @return List of packages
     * @throws APIException if something went wrong
     */
    static List<Package> readFile(String path) throws APIException {
        File file = new File(path);
        List<Package> packages = new ArrayList<>();

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String inputLine = scanner.nextLine();
                packages.add(parseLine(inputLine));
            }
        } catch (Exception e) {
            throw new APIException("Something went wrong reading file", e);
        }

        return packages;
    }

    /**
     * Translate line into Package Model Class
     *
     * @param line to be parsed
     * @return parsed Package
     * @throws APIException if format is invalid
     */
    static private Package parseLine(String line) throws APIException {
        if (!validateLine(line)) {
            throw new APIException("Invalid format");
        }
        String tokens[] = line.split(" ");
        Float packageWeigh = Float.parseFloat(tokens[0]);
        List<Item> items = new LinkedList<>();

        for (int i = 2 ; i < tokens.length ; i++){
            String[] split = tokens[i].replaceAll("[()€]", "").split(",");
            Integer index = Integer.valueOf(split[0]);
            Float weight = Float.valueOf(split[1]);
            Float cost = Float.valueOf(split[2]);
            items.add(new Item(index, weight, cost));
        }

        return new Package(packageWeigh, items);
    }



}
