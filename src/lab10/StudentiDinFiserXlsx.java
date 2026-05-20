package lab10;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class StudentiDinFiserXlsx implements IStudentiImport {
    private final String fileName;

    public StudentiDinFiserXlsx(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public List<Student> doImport() {
        List<Student> studenti = new ArrayList<>();
        try (FileInputStream fis = new FileInputStream(fileName);
             XSSFWorkbook workbook = new XSSFWorkbook(fis)) {

            var sheet = workbook.getSheetAt(0);
            boolean firstRow = true;
            for (Row row : sheet) {
                if (firstRow) { firstRow = false; continue; }
                int numarMatricol = (int) row.getCell(0).getNumericCellValue();
                String prenume = row.getCell(1).getStringCellValue();
                String nume = row.getCell(2).getStringCellValue();
                String formatie = row.getCell(3).getStringCellValue();
                double nota = row.getCell(4).getNumericCellValue();
                studenti.add(new Student(numarMatricol, prenume, nume, formatie, nota));
            }
            System.out.println("Import xlsx realizat: " + fileName + " (" + studenti.size() + " studenti)");
        } catch (IOException e) {
            System.err.println("Eroare la import xlsx: " + e.getMessage());
        }
        return studenti;
    }
}
