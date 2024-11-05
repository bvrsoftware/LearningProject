package com.bvr.geoTool.file.csv;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadExcelWithApachePoi {
    /**
     * Returns content of the excel file.
     */
    public static List<List<String>> get(String filename) {
        List<List<String>> rows = new ArrayList<>();
        try{ 
            FileInputStream excelFile = new FileInputStream(new File(filename));
            XSSFWorkbook workbook = new XSSFWorkbook(excelFile);
            // Read only first sheet
            XSSFSheet datatypeSheet = workbook.getSheetAt(0);
            // Read each row with all cells
            datatypeSheet.forEach(r -> {
                List<String> columns = new ArrayList<String>();
                r.forEach(c -> {
                    columns.add(c.toString());
                });
                rows.add(columns);
            });
        } catch (IOException e) {
            e.fillInStackTrace();
        }
        return rows;
    }
}
