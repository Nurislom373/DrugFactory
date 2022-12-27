package org.khasanaof.drugfactory.utils;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Author: Nurislom
 * <br/>
 * Date: 12/27/2022
 * <br/>
 * Time: 4:05 PM
 * <br/>
 * Package: org.khasanaof.drugfactory.utils
 */
public class JExcelHelper {

    public static Map<Integer, List<String>> readExcel(String location) throws IOException {
        Map<Integer, List<String>> data = new HashMap<>();

        FileInputStream stream = new FileInputStream(location);
        XSSFWorkbook workbook = new XSSFWorkbook(stream);
        XSSFSheet sheet = workbook.getSheetAt(0);

        int i = 0;
        for (Row row : sheet) {
            data.put(i, new ArrayList<>());
            for (Cell cell : row) {
                switch (cell.getCellType()) {
                    case STRING -> data.get(i).add(cell.getRichStringCellValue().getString());
                    case BOOLEAN -> data.get(i).add(cell.getBooleanCellValue() + "");
                    case NUMERIC ->  data.get(i).add(cell.getNumericCellValue() + "");
                    case FORMULA -> data.get(i).add(cell.getCellFormula() + "");
                }
            }
            i++;
        }

        return data;
    }

    public static void main(String[] args) throws IOException {
        Map<Integer, List<String>> map = readExcel("src/main/resources/data/Book1.xlsx");
        System.out.println("map = " + map);
    }

}
