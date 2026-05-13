package lab9;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main931 {
    public static void main(String[] args) {
        Random random = new Random();

        List<Integer> numbers = IntStream.range(0, 10)
                .map(i -> 5 + random.nextInt(21))
                .boxed()
                .collect(Collectors.toList());

        System.out.println("Lista: " + numbers);

        // a) Suma elementelor
        int sum = numbers.stream().reduce(0, Integer::sum);
        System.out.println("Suma: " + sum);

        // b) Maxim si minim
        int max = numbers.stream().max(Comparator.naturalOrder()).get();
        int min = numbers.stream().min(Comparator.naturalOrder()).get();
        System.out.println("Max: " + max);
        System.out.println("Min: " + min);

        // c) Filtrare interval [10..20]
        List<Integer> filtered = numbers.stream()
                .filter(n -> n >= 10 && n <= 20)
                .collect(Collectors.toList());
        System.out.println("Elemente in [10..20]: " + filtered);

        // d) Mapare Integer -> Double
        List<Double> doubles = numbers.stream()
                .map(n -> n.doubleValue())
                .collect(Collectors.toList());
        System.out.println("Lista Double: " + doubles);

        // e) Verificare daca exista valoarea 12
        boolean contains12 = numbers.stream().anyMatch(n -> n == 12);
        System.out.println("Contine valoarea 12: " + contains12);
    }
}
