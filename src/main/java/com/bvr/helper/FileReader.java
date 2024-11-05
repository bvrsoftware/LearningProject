package com.bvr.helper;

import org.json.simple.parser.JSONParser;

import java.io.BufferedReader;

public class FileReader {

    public static Object readJSONFile(String filePath) {

        Object obj = null;
        try {
            obj = new JSONParser().parse(filePath);
        } catch (Exception ex) {
            ex.fillInStackTrace();
        }
        return obj;
    }

    public static BufferedReader readCSVFile(String filePath) {
        BufferedReader br = null;
        try {
            br = new BufferedReader(new java.io.FileReader(filePath));
        } catch (Exception ex) {
            ex.fillInStackTrace();
        }
        return br;
    }
}
