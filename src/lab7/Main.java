package lab7;

import lab7.forms.Circle;
import lab7.forms.Form;
import lab7.forms.Square;
import lab7.forms.Triangle;
import lab7.util.PasswordMaker;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        // 7.6.1. Contor instante
        Triangle tri = new Triangle(1.1F, 2.0F, "red");
        Circle c = new Circle(1.5F, "yellow");
        Square sq = new Square(1.2F, "blue");
        System.out.println("Area = " + tri.getArea() + " details: " + tri);
        System.out.println("Area = " + c.getArea() + " details: " + c);
        System.out.println("Area = " + sq.getArea() + " details: " + sq);
        System.out.println("Total instance count is " + Form.getInstanceCount());

        // 7.6.2 Password maker singleton
        PasswordMaker pm2 = PasswordMaker.getInstance();
        System.out.println("\n7.6.2 a+b) Generated passwords: ");
        System.out.println("1:" + PasswordMaker.getInstance().getPassword());
        System.out.println("2:" + PasswordMaker.getInstance().getPassword());
        System.out.println("3:" + PasswordMaker.getInstance().getPassword());
        System.out.println("4:" + pm2.getPassword());
        System.out.println("5:" + pm2.getPassword());
        System.out.println("\n7.6.2 c) Number of time getInstance() has been called: " + PasswordMaker.getCallingCounts());

        // 7.6.3 Imutabilitate
        Set<Student> studenti = new LinkedHashSet<>();
        studenti.add(new Student(9322, "Dan", "Beat", "TI21/1"));
        studenti.add(new Student(120, "Alis", "Popa", "TI21/1"));
        studenti.add(new Student(112, "Maria", "Popa", "TI21/1"));
        studenti.add(new Student(150, "Ion", "Ionescu", "TI21/1"));
        studenti.add(new Student(200, "Ana", "Dumitrescu", "TI21/1"));

        studenti = imparteInDouaFormatii(studenti, "TI 211_1", "TI 211_2");
        System.out.println("\n7.6.3 Studenti impartiti in doua formatii:");
        for (Student s : studenti) {
            System.out.println(s);
        }

        // 8.5.4 a
        String xlsFileName = "src/lab7/laborator8_students.xlsx";
        writeToXls(studenti, xlsFileName);

        // 8.5.4 b
        List<Student> studentsFromXls = readFromXls(xlsFileName);
        System.out.println("\nStudenti cititi din xlsx:");
        for (Student st : studentsFromXls) {
            System.out.println(st);
        }
    }

    static Student schimbaFormatia(Student st, String nouaFormatieDeStudiu) {
        return new Student(st.getNumarMatricol(), st.getPrenume(), st.getNume(), nouaFormatieDeStudiu);
    }

    static void writeToXls(Set<Student> studenti, String fileName) {
        try (XSSFWorkbook workbook = new XSSFWorkbook()) {
            XSSFSheet sheet = workbook.createSheet("Studenti");

            Row header = sheet.createRow(0);
            header.createCell(0).setCellValue("numarMatricol");
            header.createCell(1).setCellValue("prenume");
            header.createCell(2).setCellValue("nume");
            header.createCell(3).setCellValue("formatieDeStudiu");

            int rowNum = 1;
            for (Student s : studenti) {
                Row row = sheet.createRow(rowNum++);
                row.createCell(0).setCellValue(s.getNumarMatricol());
                row.createCell(1).setCellValue(s.getPrenume());
                row.createCell(2).setCellValue(s.getNume());
                row.createCell(3).setCellValue(s.getFormatieDeStudiu());
            }

            try (FileOutputStream out = new FileOutputStream(fileName)) {
                workbook.write(out);
                System.out.println("\nlaborator8_students.xlsx generat cu succes.");
            }
        } catch (IOException e) {
            System.err.println("Eroare la scriere xlsx: " + e.getMessage());
        }
    }

    static List<Student> readFromXls(String fileName) {
        List<Student> result = new ArrayList<>();
        try (FileInputStream fis = new FileInputStream(fileName);
             XSSFWorkbook workbook = new XSSFWorkbook(fis)) {

            XSSFSheet sheet = workbook.getSheetAt(0);
            boolean firstRow = true;
            for (Row row : sheet) {
                if (firstRow) { firstRow = false; continue; } // sari header
                int matricol = (int) row.getCell(0).getNumericCellValue();
                String prenume = row.getCell(1).getStringCellValue();
                String nume = row.getCell(2).getStringCellValue();
                String formatie = row.getCell(3).getStringCellValue();
                result.add(new Student(matricol, prenume, nume, formatie));
            }
        } catch (IOException e) {
            System.err.println("Eroare la citire xlsx: " + e.getMessage());
        }
        return result;
    }

    static Set<Student> imparteInDouaFormatii(Set<Student> studenti, String formatia1, String formatia2) {
        List<Student> lista = new ArrayList<>(studenti);
        int jumatate = (lista.size() + 1) / 2;
        Set<Student> rezultat = new LinkedHashSet<>();
        for (int i = 0; i < lista.size(); i++) {
            if (i < jumatate) {
                rezultat.add(schimbaFormatia(lista.get(i), formatia1));
            } else {
                rezultat.add(schimbaFormatia(lista.get(i), formatia2));
            }
        }
        return rezultat;
    }
}
