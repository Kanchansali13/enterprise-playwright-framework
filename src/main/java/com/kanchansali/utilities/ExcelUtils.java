package com.kanchansali.utilities;

import org.apache.poi.ss.usermodel.*;
import java.io.FileInputStream;
import java.io.IOException;

public class ExcelUtils {

    private Workbook workbook;
    private Sheet sheet;

    public ExcelUtils(String filePath, String sheetName) {

        try {
            FileInputStream fis = new FileInputStream(filePath);

            workbook = WorkbookFactory.create(fis);

            sheet = workbook.getSheet(sheetName);

        } catch (IOException e) {

            throw new RuntimeException(e);

        }

    }

    public int getRowCount() {

        return sheet.getLastRowNum();

    }

    public int getColumnCount() {

        return sheet.getRow(0).getLastCellNum();

    }

    public String getCellData(int row, int column) {

        return sheet.getRow(row).getCell(column).toString();

    }

}