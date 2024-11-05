package com.bvr.geoTool.file.csv;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class ReadCsvWithApacheCommons {
    /**
     * Returns content of the csv file.
     */
    public static List<List<String>> get(String filename) {
        List<List<String>> rows = new ArrayList<>();
        try {
            // Read file
            CSVParser parser = CSVParser.parse(new File(filename), StandardCharsets.UTF_8, CSVFormat.EXCEL);

            // Add content rows
            for (var row : parser.getRecords()) {
                var columns = new ArrayList<String>();
                row.forEach(columns::add);
                rows.add(columns);
            }
        } catch (IOException e) {
            e.fillInStackTrace();
        }
        return rows;
    }
}
