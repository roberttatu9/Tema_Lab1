package lab5;

import lab3.Student;
import lab5.advanced.DoubleCalculator;
import lab5.advanced.NewIntCalculator;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class AppLab5 {
    public static void main(String[] args) {
        // 5.5.1
        System.out.println("=== 5.5.1 ===");
        IntCalculator calculator = new IntCalculator(10);
        int result1 = calculator.add(5).subtract(3).multiply(2).result();
        System.out.println("System.out.println(\"a) \" + result); -> a) " + result1);

        AdvancedCalculator advCalc = new AdvancedCalculator(10);
        int result2 = advCalc.divide(4).power(2).root(2).result();
        System.out.println("System.out.println(\"b) \" + result2); -> b) " + result2);

        // 5.5.2
        System.out.println("\n=== 5.5.2 ===");
        NewIntCalculator nIntCalc = new NewIntCalculator(10);
        int resInt = (Integer) nIntCalc.add(5).subtract(3).multiply(2).result();
        System.out.println("(10 + 5 - 3) * 2 = " + resInt);

        DoubleCalculator dCalc = new DoubleCalculator(10.0);
        double resDouble = (Double) dCalc.add(5.0).subtract(3.3).multiply(2.2).result();
        System.out.println("(10 + 5 - 3.3) * 2.2 = " + resDouble);

        // 5.5.3
        System.out.println("\n=== 5.5.3 ===");
        List<StudentBursier> bursieri = new ArrayList<>();
        bursieri.add(new StudentBursier(1025, "Andrei", "Popa", "ISM141/2", 8.70f, 725.50));
        bursieri.add(new StudentBursier(1024, "Ioan", "Mihalcea", "ISM141/1", 9.80f, 801.10));
        bursieri.add(new StudentBursier(1026, "Anamaria", "Prodan", "TI131/1", 8.90f, 745.50));
        bursieri.add(new StudentBursier(1029, "Bianca", "Popescu", "TI131/1", 9.10f, 780.80));

        salvareInFisier("src/lab5/bursieri_out.txt", bursieri);
        System.out.println("Lista bursieri salvata in src/lab5/bursieri_out.txt");
    }

    public static void salvareInFisier(String filename, Collection<? extends Student> lista) {
        try (FileWriter writer = new FileWriter(filename)) {
            for (Student s : lista) {
                writer.write(s.toString() + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
