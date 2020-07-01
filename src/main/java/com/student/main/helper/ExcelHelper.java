package com.student.main.helper;

import com.student.main.Model.Result;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ExcelHelper {


    public static List<Result> parseExcelFile(InputStream is) {
        try {
            Workbook workbook = new XSSFWorkbook(is);

            Sheet sheet = workbook.getSheetAt(0);
            Iterator<Row> rows = sheet.iterator();

            List<Result> ResultList = new ArrayList<Result>();

            int rowNumber = 0;
            while (rows.hasNext()) {
                Row currentRow = rows.next();

                // skip header
                if(rowNumber == 0) {
                    rowNumber++;
                    continue;
                }

                Iterator<Cell> cellsInRow = currentRow.iterator();

                Result result = new Result();

                int cellIndex = 0;
                while (cellsInRow.hasNext()) {
                    Cell currentCell = cellsInRow.next();

                    if(cellIndex==0) {
                        result.setId((int) currentCell.getNumericCellValue());
                    } else if(cellIndex==1) {
                        result.setName(currentCell.getStringCellValue());
                    } else if(cellIndex==2) {
                        result.setGpa((int) currentCell.getNumericCellValue());
                    } else if(cellIndex==3) {
                        result.setGrade(currentCell.getStringCellValue());
                    }

                    cellIndex++;
                }

                ResultList.add(result);
            }

            // Close WorkBook
            workbook.close();

            return ResultList;
        } catch (IOException e) {
            throw new RuntimeException("FAIL! -> message = " + e.getMessage());
        }
    }

}
