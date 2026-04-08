package lab3;

import java.io.*;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CitireStudenti {
    public static void main(String[] args) {
        List<lab3.Student> studenti = null;
        try {
            // a) citirea studentilor din fisier
            studenti = citireStudentiDinFisier("src/lab3/studenti_in.txt");

            // b) afisare studenti cititi
            System.out.println("Studenții citiți din fișie ");
            for (lab3.Student student : studenti) {
                System.out.println(student);
            }

            // c) sorteaza studentii dupa nume
            sortareStudentiDupaNum(studenti);

            System.out.println("\nStudenții sortați după nume ");
            for (Student student : studenti) {
                System.out.println(student);
            }

            // d) fisier output
            salvareStudentiInFisier("src/lab3/studenti_out.txt", studenti);

            System.out.println("\nFișierul studenti_out.txt a fost salvat cu SUCCES!");

        } catch (IOException e) {
            System.err.println("EROARE! " + e.getMessage());
            e.printStackTrace();

// tema lab3
            System.out.println("\nTema de casă: Sortare după formatieDeStudiu și nume");
            sortareStudentiDupaFormatieDeStudiuSiNume(studenti);

            System.out.println("\nStudenții sortați după formatieDeStudiu și apoi după nume:");
            for (Student student : studenti) {
                System.out.println(student);
            }

            try {
                salvareStudentiInFisier("src/lab3/studenti_out_sorted.txt", studenti);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
            System.out.println("\nFișierul studenti_out_sorted.txt a fost salvat cu SUCCES!");

        }
    }

    // functie pentru citirea studentilor din fisier
    public static List<Student> citireStudentiDinFisier(String numeFisier) throws IOException {
        List<Student> studenti = new ArrayList<>();

        List<String> linii = Files.readAllLines(Paths.get(numeFisier));

        for (String linie : linii) {
            //separare campuri
            String[] campuri = linie.split(",");

            if (campuri.length == 4) {
                int numarMatricol = Integer.parseInt(campuri[0].trim());
                String prenume = campuri[1].trim();
                String nume = campuri[2].trim();
                String formatieDeStudiu = campuri[3].trim();

                Student student = new Student(numarMatricol, prenume, nume, formatieDeStudiu);
                studenti.add(student);
            }
        }

        return studenti;
    }

    // functie pentru sortare dupa nume
    public static void sortareStudentiDupaNum(List<Student> studenti) {
        Collections.sort(studenti, new Comparator<Student>() {
            @Override
            public int compare(Student s1, Student s2) {
                return s1.getNume().compareTo(s2.getNume());
            }
        });
    }

    // functie pentru sortare dupa formatie de studiu nume
    public static void sortareStudentiDupaFormatieDeStudiuSiNume(List<Student> studenti) {
        Collections.sort(studenti, new Comparator<Student>() {
            @Override
            public int compare(Student s1, Student s2) {
                // prima data se compara formatia de studiu
                int comparareFormatie = s1.getFormatieDeStudiu().compareTo(s2.getFormatieDeStudiu());

                // daca formatiile coincid, se compara numele
                if (comparareFormatie == 0) {
                    return s1.getNume().compareTo(s2.getNume());
                }

                return comparareFormatie;
            }
        });
    }


    // functie pentru salvarea studentilor in fisier
    public static void salvareStudentiInFisier(String numeFisier, List<Student> studenti) throws IOException {
        try (FileWriter writer = new FileWriter(numeFisier)) {
            for (Student student : studenti) {
                writer.write(student.toString() + "\n");
            }
        }


    }
}


