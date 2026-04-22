package lab6.test;

import lab6.AplicatieCuBursa;
import lab6.StudentBursier;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class AplicatieCuBursaTest {

    AplicatieCuBursa appCuBursa = new AplicatieCuBursa();

    @Test
    public void sortTest1() {
        // arrange
        List<StudentBursier> lista = appCuBursa.genereaza();

        // act
        List<StudentBursier> sortata = appCuBursa.sorteaza(lista);

        // assert: check each consecutive pair satisfies the sort order
        for (int i = 0; i < sortata.size() - 1; i++) {
            StudentBursier a = sortata.get(i);
            StudentBursier b = sortata.get(i + 1);

            int cmpFormatie = a.getFormatieDeStudiu().compareTo(b.getFormatieDeStudiu());
            if (cmpFormatie != 0) {
                Assertions.assertTrue(cmpFormatie <= 0,
                        "formatieDeStudiu out of order at index " + i);
                continue;
            }

            int cmpNume = a.getNume().compareTo(b.getNume());
            if (cmpNume != 0) {
                Assertions.assertTrue(cmpNume <= 0,
                        "nume out of order at index " + i);
                continue;
            }

            int cmpPrenume = a.getPrenume().compareTo(b.getPrenume());
            if (cmpPrenume != 0) {
                Assertions.assertTrue(cmpPrenume <= 0,
                        "prenume out of order at index " + i);
                continue;
            }

            int cmpNota = Float.compare(a.getNota(), b.getNota());
            if (cmpNota != 0) {
                Assertions.assertTrue(cmpNota <= 0,
                        "nota out of order at index " + i);
                continue;
            }

            Assertions.assertTrue(a.getCuantumBursa() <= b.getCuantumBursa(),
                    "cuantumBursa out of order at index " + i);
        }
    }

    @Test
    public void sortTestEmptyList() {
        // arrange
        List<StudentBursier> lista = new java.util.ArrayList<>();
        // act
        List<StudentBursier> sortata = appCuBursa.sorteaza(lista);
        // assert
        Assertions.assertNotNull(sortata);
        Assertions.assertEquals(0, sortata.size());
    }

    @Test
    public void sortTestOriginalListUnchanged() {
        // arrange
        List<StudentBursier> lista = appCuBursa.genereaza();
        List<StudentBursier> copie = new java.util.ArrayList<>(lista);
        // act
        appCuBursa.sorteaza(lista);
        // assert: sorteaza() must not modify the input list
        Assertions.assertEquals(copie, lista);
    }
}
