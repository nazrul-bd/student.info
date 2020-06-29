package com.student.main.helper;

import com.student.main.Model.StudentResult;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ExcelHelper {


    public static String TYPE = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";
    static String[] HEADERs = { "Id", "Name", "Bangla", "English", "Math" , "Gpa" , "Grade" };
    static String SHEET = "Tutorials";

    public static boolean hasExcelFormat(MultipartFile file) {

        if (!TYPE.equals(file.getContentType())) {
            return false;
        }

        return true;
    }

    public static ByteArrayInputStream tutorialsToExcel(List<StudentResult> studentResults) {

        try (Workbook workbook = new XSSFWorkbook(); ByteArrayOutputStream out = new ByteArrayOutputStream();) {
            Sheet sheet = workbook.createSheet(SHEET);

            // Header
            Row headerRow = sheet.createRow(0);

            for (int col = 0; col < HEADERs.length; col++) {
                Cell cell = headerRow.createCell(col);
                cell.setCellValue(HEADERs[col]);
            }

            int rowIdx = 1;
            for (StudentResult result : studentResults) {
                Row row = sheet.createRow(rowIdx++);


                row.createCell(0).setCellValue(result.getId());
                row.createCell(0).setCellValue(result.getName());
                row.createCell(0).setCellValue(result.getBangla());
                row.createCell(0).setCellValue(result.getEnglish());
                row.createCell(0).setCellValue(result.getMath());
                row.createCell(0).setCellValue(result.getGpa());
                row.createCell(0).setCellValue(result.getGrade());
            }

            workbook.write(out);
            return new ByteArrayInputStream(out.toByteArray());
        } catch (IOException e) {
            throw new RuntimeException("fail to import data to Excel file: " + e.getMessage());
        }
    }

    public static List<StudentResult> excelToTutorials(InputStream is) {
        try {
            Workbook workbook = new XSSFWorkbook(is);

            Sheet sheet = workbook.getSheet(SHEET);
            Iterator<Row> rows = sheet.iterator();

            List<StudentResult> studentResults = new ArrayList<StudentResult>();

            int rowNumber = 0;
            while (rows.hasNext()) {
                Row currentRow = rows.next();

                // skip header
                if (rowNumber == 0) {
                    rowNumber++;
                    continue;
                }

                Iterator<Cell> cellsInRow = currentRow.iterator();

                StudentResult result = new StudentResult();

                int cellIdx = 0;
                while (cellsInRow.hasNext()) {
                    Cell currentCell = cellsInRow.next();

                    switch (cellIdx) {

                        case 0:
                            result.setId((int) currentCell.getNumericCellValue());
                            break;

                        case 1:
                            result.setName(currentCell.getStringCellValue());
                            break;


                        case 2:
                            result.setBangla((double) currentCell.getNumericCellValue());
                            break;

                        case 3:
                            result.setEnglish((double) currentCell.getNumericCellValue());
                            break;

                        case 4:
                            result.setMath((double) currentCell.getNumericCellValue());
                            break;

                        case 5:
                            result.setGpa((double) currentCell.getNumericCellValue());
                            break;

                        case 6:
                            result.setGrade(currentCell.getStringCellValue());
                            break;



                        default:
                            break;
                    }

                    cellIdx++;
                }

                studentResults.add(result);
            }

            workbook.close();

            return studentResults;
        } catch (IOException e) {
            throw new RuntimeException("fail to parse Excel file: " + e.getMessage());
        }
    }
}
