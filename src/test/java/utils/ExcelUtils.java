package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {

    // Finds the row whose first column matches testId and returns it as column name -> value
    public static Map<String, String> getRowByTestId(String filePath, String sheetName, String testId) {
        DataFormatter formatter = new DataFormatter();

        try (FileInputStream fis = new FileInputStream(filePath);
             Workbook workbook = new XSSFWorkbook(fis)) {

            Sheet sheet = workbook.getSheet(sheetName);
            if (sheet == null) {
                throw new RuntimeException("Sheet not found: " + sheetName);
            }
            Row header = sheet.getRow(0);

            for (int i = 1; i <= sheet.getLastRowNum(); i++) {
                Row row = sheet.getRow(i);
                if (row == null) {
                    continue;
                }
                if (formatter.formatCellValue(row.getCell(0)).equals(testId)) {
                    Map<String, String> data = new HashMap<>();
                    for (int c = 0; c < header.getLastCellNum(); c++) {
                        data.put(formatter.formatCellValue(header.getCell(c)),
                                 formatter.formatCellValue(row.getCell(c)));
                    }
                    return data;
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("Could not read Excel file: " + filePath, e);
        }
        throw new RuntimeException("TestId not found in Excel: " + testId);
    }
}