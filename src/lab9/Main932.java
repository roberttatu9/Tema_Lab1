package lab9;

import java.util.*;
import java.util.stream.Collectors;

public class Main932 {
    public static void main(String[] args) {
        String text = "Acesta este un program scris in java pentru expresii lambda";
        List<String> cuvinte = Arrays.asList(text.split(" "));

        // a) Cuvinte cu lungime >= 5, afisare lista filtrata
        List<String> cuvintelungi = cuvinte.stream()
                .filter(c -> c.length() >= 5)
                .collect(Collectors.toList());
        System.out.println("Cuvinte cu lungime >= 5 (" + cuvintelungi.size() + "): " + cuvintelungi);

        // b) Ordonare si afisare
        List<String> sortate = cuvintelungi.stream()
                .sorted()
                .collect(Collectors.toList());
        System.out.println("Sortate: " + sortate);

        // c) Primul element care incepe cu 'p'
        Optional<String> cuP = cuvinte.stream()
                .filter(c -> c.startsWith("p"))
                .findFirst();
        if (cuP.isPresent()) {
            System.out.println("Element care incepe cu 'p': " + cuP.get());
        } else {
            System.out.println("Nu exista cuvant care incepe cu 'p'.");
        }
    }
}
