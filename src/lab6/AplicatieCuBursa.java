package lab6;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class AplicatieCuBursa {

    public List<StudentBursier> genereaza() {
        List<StudentBursier> lista = new ArrayList<>();
        lista.add(new StudentBursier(1025, "Andrei", "Popa", "ISM141/2", 8.70f, 725.50));
        lista.add(new StudentBursier(1024, "Ioan", "Mihalcea", "ISM141/1", 9.80f, 801.10));
        lista.add(new StudentBursier(1029, "Bianca", "Popescu", "TI131/1", 9.10f, 780.80));
        lista.add(new StudentBursier(1026, "Anamaria", "Prodan", "TI131/1", 8.90f, 745.50));
        lista.add(new StudentBursier(1029, "Bianca", "Popescu", "TI131/1", 9.10f, 100.80)); // For sorting test
        return lista;
    }

    public List<StudentBursier> sorteaza(List<StudentBursier> lst) {
        lst.sort(Comparator.comparing(StudentBursier::getFormatieDeStudiu)
                .thenComparing(StudentBursier::getNume)
                .thenComparing(StudentBursier::getPrenume)
                .thenComparing(StudentBursier::getNota)
                .thenComparing(StudentBursier::getCuantumBursa));
        return lst;
    }

    public static void main(String[] args) {
        AplicatieCuBursa instanta = new AplicatieCuBursa();
        List<StudentBursier> lista = instanta.genereaza();
        System.out.println("Lista initiala:");
        lista.forEach(System.out::println);

        System.out.println("\nLista sortata:");
        instanta.sorteaza(lista);
        lista.forEach(System.out::println);
    }
}
