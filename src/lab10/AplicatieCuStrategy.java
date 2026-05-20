package lab10;

import java.util.Arrays;
import java.util.List;

public class AplicatieCuStrategy {
    public static void main(String[] args) {
        List<Student> studenti = Arrays.asList(
            new Student(1025, "Andrei",   "Popa",      "ISM141/2",  8.70),
            new Student(1024, "Ioan",     "Mihalcea",  "ISM141/1",  10),
            new Student(1026, "Anamaria", "Prodan",    "TI131/1",   8.90),
            new Student(1029, "Bianca",   "Popescu",   "TI131/1",   10),
            new Student(1029, "Maria",    "Pana",      "TI131/2",   4.10),
            new Student(1029, "Gabriela", "Mohanu",    "TI131/2",   7.33),
            new Student(1029, "Marius",   "Nasta",     "TI131/2",   3.20),
            new Student(1029, "Marius",   "Nasta",     "TI131/1",   5.12),
            new Student(1029, "Andrei",   "Dobrescu",  "TI131/2",   2.22)
        );

        Exporter exporter = new Exporter();

        // a) Afisare in consola
        System.out.println("=== a) Export consola ===");
        IStudentiExport strategyConsole = new StudentiInConsola();
        exporter.startExport(strategyConsole, studenti);

        // b) Export in fisier text
        System.out.println("\n=== b) Export fisier text ===");
        String textFileName = "src/lab10/studentiStrategyText.txt";
        StudentiInFisierText strategyFisierText = new StudentiInFisierText(textFileName);
        exporter.startExport(strategyFisierText, studenti);

        // c) Export in fisier xlsx
        System.out.println("\n=== c) Export fisier xlsx ===");
        String xlsxFileName = "src/lab10/studentiStrategyExcel.xlsx";
        StudentiInFisierXlsx strategyFisierExcel = new StudentiInFisierXlsx(xlsxFileName);
        exporter.startExport(strategyFisierExcel, studenti);

        // d) Import din fisier text
        System.out.println("\n=== d) Import din fisier text ===");
        Importer importer = new Importer();
        StudentiDinFiserText strategyImportText = new StudentiDinFiserText(textFileName);
        List<Student> studentiDinText = importer.startImport(strategyImportText);
        studentiDinText.forEach(System.out::println);

        // e) Import din fisier xlsx
        System.out.println("\n=== e) Import din fisier xlsx ===");
        StudentiDinFiserXlsx strategyImportXlsx = new StudentiDinFiserXlsx(xlsxFileName);
        List<Student> studentiDinXlsx = importer.startImport(strategyImportXlsx);
        studentiDinXlsx.forEach(System.out::println);
    }
}
