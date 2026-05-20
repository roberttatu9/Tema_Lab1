package lab10;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class StudentiInFisierXlsx implements IStudentiExport {
    private final String fileName;

    public StudentiInFisierXlsx(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void doExport(List<Student> studenti) {
        try (XSSFWorkbook workbook = new XSSFWorkbook()) {
            XSSFSheet sheet = workbook.createSheet("Studenti");

            XSSFRow header = sheet.createRow(0);
            header.createCell(0).setCellValue("NumarMatricol");
            header.createCell(1).setCellValue("Prenume");
            header.createCell(2).setCellValue("Nume");
            header.createCell(3).setCellValue("FormatieDeStudiu");
            header.createCell(4).setCellValue("Nota");

            for (int i = 0; i < studenti.size(); i++) {
                Student s = studenti.get(i);
                XSSFRow row = sheet.createRow(i + 1);
                row.createCell(0).setCellValue(s.getNumarMatricol());
                row.createCell(1).setCellValue(s.getPrenume());
                row.createCell(2).setCellValue(s.getNume());
                row.createCell(3).setCellValue(s.getFormatieDeStudiu());
                row.createCell(4).setCellValue(s.getNota());
            }

            try (FileOutputStream out = new FileOutputStream(fileName)) {
                workbook.write(out);
                System.out.println("Export xlsx realizat: " + fileName);
            }
        } catch (IOException e) {
            System.err.println("Eroare la export xlsx: " + e.getMessage());
        }
    }
}
