package lab10;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class StudentiDinFiserText implements IStudentiImport {
    private final String fileName;

    public StudentiDinFiserText(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public List<Student> doImport() {
        List<Student> studenti = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(";");
                if (parts.length == 5) {
                    int numarMatricol = Integer.parseInt(parts[0].trim());
                    String prenume = parts[1].trim();
                    String nume = parts[2].trim();
                    String formatie = parts[3].trim();
                    double nota = Double.parseDouble(parts[4].trim());
                    studenti.add(new Student(numarMatricol, prenume, nume, formatie, nota));
                }
            }
            System.out.println("Import text realizat: " + fileName + " (" + studenti.size() + " studenti)");
        } catch (IOException e) {
            System.err.println("Eroare la import text: " + e.getMessage());
        }
        return studenti;
    }
}
