package lab3_text;

import java.io.*;
import java.nio.file.*;
import java.util.List;

public class ProceseazaText {
    public static void main(String[] args) {
        try {
            // citește datele din fișierul studenti_in.txt
            List<String> linii = Files.readAllLines(Paths.get("src/lab3/studenti_in.txt"));

            System.out.println("Date citite din fisier: ");
            for (String linie : linii) {
                System.out.println(linie);
            }

            // a) newline la sfarsitul fiecarei linii
            System.out.println("\n a) newline la sfarsitul fiecarei linii ");
            StringBuilder rezultatA = new StringBuilder();
            for (String linie : linii) {
                rezultatA.append(linie).append("\n");
            }
            System.out.println(rezultatA.toString());

            // b) newline dupa fiecare punct
            System.out.println(" b) newline dupa fiecare punct ");
            StringBuilder rezultatB = new StringBuilder();
            for (String linie : linii) {
                String liniaModificata = linie.replace(".", ".\n");
                rezultatB.append(liniaModificata).append("\n");
            }
            System.out.println(rezultatB.toString());

            // c) salvare rezultat in out.txt
            salvareRezultate("out.txt", rezultatA.toString(), rezultatB.toString());

            System.out.println("Fisier salvat cu SUCCES!");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // functie pentru salvare rezultat in out.txt
    public static void salvareRezultate(String numeFisier, String rezultatA, String rezultatB) throws IOException {
        try (FileWriter writer = new FileWriter(numeFisier)) {
            writer.write("a) newline la sfarsitul fiecarei linii \n");
            writer.write(rezultatA);
            writer.write("\n\n");

            writer.write("b) newline dupa fiecare punct \n");
            writer.write(rezultatB);
        }
    }
}
