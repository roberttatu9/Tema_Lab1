package lab10;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class StudentiInFisierText implements IStudentiExport {
    private final String fileName;

    public StudentiInFisierText(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void doExport(List<Student> studenti) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (Student s : studenti) {
                writer.write(s.getNumarMatricol() + ";" + s.getPrenume() + ";" +
                             s.getNume() + ";" + s.getFormatieDeStudiu() + ";" + s.getNota());
                writer.newLine();
            }
            System.out.println("Export text realizat: " + fileName);
        } catch (IOException e) {
            System.err.println("Eroare la export text: " + e.getMessage());
        }
    }
}
