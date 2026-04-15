package lab4;

import lab3.Student;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AppLab4 {
    public static void main(String[] args) {
        // --- 4.5.1 ---
        System.out.println("=== 4.5.1 ===");
        HashMap<String, Integer> varste = new HashMap<>();
        varste.put("Ioan", 21);
        varste.put("Maria", 22);
        varste.put("Victor", 20);
        varste.put("Simina", 20);
        varste.put("Marius", 21);
        varste.put("Mihai", 21);
        varste.put("Daniela", 23);

        varste.put("Vlad", 19);
        varste.put("Iulia", 19);

        System.out.println("Varste: " + varste);

        Map<String, String> adrese = Map.of(
                "Ioan", "Sibiu", "Maria", "Bucuresti", "Victor", "Cluj",
                "Simina", "Alba-Iulia", "Marius", "Medias", "Mihai", "Cisnadie",
                "Daniela", "Sibiu"
        );

        HashMap<String, Tanar> tineri = new HashMap<>();
        for (String nume : varste.keySet()) {
            if (adrese.containsKey(nume)) {
                tineri.put(nume, new Tanar(nume, varste.get(nume), adrese.get(nume)));
            } else {
                // Adresa implicita daca nu exista in map-ul de adrese (ex: Vlad, Iulia)
                tineri.put(nume, new Tanar(nume, varste.get(nume), "Necunoscuta"));
            }
        }

        System.out.println("Tineri:");
        for (Map.Entry<String, Tanar> entry : tineri.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }

        // --- 4.5.2 ---
        System.out.println("\n=== 4.5.2 ===");
        HashMap<Integer, Student> mapStudenti = new HashMap<>();
        try {
            List<String> liniiStudenti = Files.readAllLines(Paths.get("src/lab3/studenti_in.txt"));
            for (String linie : liniiStudenti) {
                String[] split = linie.split(",");
                if (split.length == 4) {
                    int nrMatricol = Integer.parseInt(split[0].trim());
                    Student s = new Student(nrMatricol, split[1].trim(), split[2].trim(), split[3].trim());
                    mapStudenti.put(nrMatricol, s);
                }
            }

            List<String> liniiNote = Files.readAllLines(Paths.get("src/lab4/note_anon.txt"));
            for (String linie : liniiNote) {
                String[] split = linie.split(",");
                if (split.length == 2) {
                    int nrMatricol = Integer.parseInt(split[0].trim());
                    float nota = Float.parseFloat(split[1].trim());
                    if (mapStudenti.containsKey(nrMatricol)) {
                        mapStudenti.get(nrMatricol).setNota(nota);
                    }
                }
            }

            System.out.println("Map Studenti cu note alocate:");
            for (Map.Entry<Integer, Student> entry : mapStudenti.entrySet()) {
                System.out.println(entry.getKey() + " -> " + entry.getValue());
            }

        } catch (IOException e) {
            System.out.println("A apărut o eroare la citirea fișierelor!");
            e.printStackTrace();
        }

        // --- 4.5.3 ---
        System.out.println("\n=== 4.5.3 ===");
        // Aici map-ul folosit este cel de Studenti in loc de `tineri`, deoarece vrem notele (potrivit indicatiilor assignment-ului)
        float notaM = gasesteNota("Bianca", "Popescu", mapStudenti);
        float notaN = gasesteNota("Ioan", "Popa", mapStudenti); // Exemplu invalid dupa assignment
        
        System.out.println("Nota gasita pentru Bianca Popescu: " + notaM);
        System.out.println("Nota gasita pentru Ioan Popa: " + notaN);
    }

    /**
     * Returneaza nota unui Student in O(1) folosind prenumele si numele.
     */
    public static float gasesteNota(String prenume, String nume, Map<Integer, Student> mapStudenti) {
        HashMap<String, Student> numeToStudent = new HashMap<>();
        
        // Construim HashMap cu cheia "prenume-nume"
        for (Student s : mapStudenti.values()) {
            numeToStudent.put(s.getPrenume() + "-" + s.getNume(), s);
        }

        String keyCautata = prenume + "-" + nume;
        if (numeToStudent.containsKey(keyCautata)) {
            return numeToStudent.get(keyCautata).getNota();
        }
        return 0.0f; // Returneaza 0.0 daca nu este gasit
    }
}