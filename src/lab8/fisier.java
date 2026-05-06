package lab8;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;

public class fisier {

    public static void main(String[] args) {
        citesteSiAfiseaza();
        genereazaOutput2();
        genereazaOutput3();
    }

    static void citesteSiAfiseaza() {
        try (FileInputStream file = new FileInputStream("src/lab8/laborator8_input.xlsx");
             XSSFWorkbook workbook = new XSSFWorkbook(file)) {

            Sheet sheet = workbook.getSheetAt(0);
            Iterator<Row> rowIterator = sheet.iterator();

            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();
                Iterator<Cell> cellIterator = row.cellIterator();

                while (cellIterator.hasNext()) {
                    Cell cell = cellIterator.next();
                    switch (cell.getCellType()) {
                        case NUMERIC -> System.out.print(cell.getNumericCellValue() + "\t");
                        case STRING  -> System.out.print(cell.getStringCellValue() + "\t");
                        default      -> System.out.print(cell + "\t");
                    }
                }
                System.out.println();
            }

        } catch (IOException e) {
            System.err.println("Eroare I/O: " + e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            System.err.println("Eroare neasteptata: " + e.getMessage());
            e.printStackTrace();
        }
    }

    static void genereazaOutput3() {
        try (FileInputStream file = new FileInputStream("src/lab8/laborator8_input.xlsx");
             XSSFWorkbook inputWorkbook = new XSSFWorkbook(file);
             XSSFWorkbook outputWorkbook = new XSSFWorkbook()) {

            Sheet inputSheet = inputWorkbook.getSheetAt(0);
            XSSFSheet outputSheet = outputWorkbook.createSheet("Sheet1");

            for (Row inputRow : inputSheet) {
                Row outputRow = outputSheet.createRow(inputRow.getRowNum());
                int lastCol = inputRow.getLastCellNum();

                // copiaza toate celulele din randul curent
                for (Cell inputCell : inputRow) {
                    Cell outputCell = outputRow.createCell(inputCell.getColumnIndex());
                    if (inputCell.getCellType() == CellType.NUMERIC) {
                        outputCell.setCellValue(inputCell.getNumericCellValue());
                    } else if (inputCell.getCellType() == CellType.STRING) {
                        outputCell.setCellValue(inputCell.getStringCellValue());
                    }
                }

                // scrie formula AVERAGE pentru ultimele 3 coloane
                int excelRow = inputRow.getRowNum() + 1; // Excel e 1-indexed
                char colStart = (char) ('A' + lastCol - 3);
                char colEnd   = (char) ('A' + lastCol - 1);
                String formula = "AVERAGE(" + colStart + excelRow + ":" + colEnd + excelRow + ")";
                outputRow.createCell(lastCol).setCellFormula(formula);
            }

            try (FileOutputStream out = new FileOutputStream("src/lab8/laborator8_output3.xlsx")) {
                outputWorkbook.write(out);
                System.out.println("laborator8_output3.xlsx generat cu succes.");
            }

        } catch (IOException e) {
            System.err.println("Eroare I/O: " + e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            System.err.println("Eroare neasteptata: " + e.getMessage());
            e.printStackTrace();
        }
    }

    static void genereazaOutput2() {
        try (FileInputStream file = new FileInputStream("src/lab8/laborator8_input.xlsx");
             XSSFWorkbook inputWorkbook = new XSSFWorkbook(file);
             XSSFWorkbook outputWorkbook = new XSSFWorkbook()) {

            Sheet inputSheet = inputWorkbook.getSheetAt(0);
            XSSFSheet outputSheet = outputWorkbook.createSheet("Sheet1");

            for (Row inputRow : inputSheet) {
                Row outputRow = outputSheet.createRow(inputRow.getRowNum());
                int lastCol = inputRow.getLastCellNum();

                // copiaza toate celulele din randul curent
                for (Cell inputCell : inputRow) {
                    Cell outputCell = outputRow.createCell(inputCell.getColumnIndex());
                    if (inputCell.getCellType() == CellType.NUMERIC) {
                        outputCell.setCellValue(inputCell.getNumericCellValue());
                    } else if (inputCell.getCellType() == CellType.STRING) {
                        outputCell.setCellValue(inputCell.getStringCellValue());
                    }
                }

                // calculeaza media ultimelor 3 coloane (valori numerice)
                double sum = 0;
                int count = 0;
                for (int c = lastCol - 3; c < lastCol; c++) {
                    Cell cell = inputRow.getCell(c);
                    if (cell != null && cell.getCellType() == CellType.NUMERIC) {
                        sum += cell.getNumericCellValue();
                        count++;
                    }
                }
                double medie = count > 0 ? sum / count : 0;
                outputRow.createCell(lastCol).setCellValue(medie);
            }

            try (FileOutputStream out = new FileOutputStream("src/lab8/laborator8_output2.xlsx")) {
                outputWorkbook.write(out);
                System.out.println("laborator8_output2.xlsx generat cu succes.");
            }

        } catch (IOException e) {
            System.err.println("Eroare I/O: " + e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            System.err.println("Eroare neasteptata: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
