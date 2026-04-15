package lab6.test;

import lab6.AplicatieCuBursa;
import lab6.StudentBursier;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class AplicatieCuBursaTest {

    @Test
    public void testSort() {
        AplicatieCuBursa app = new AplicatieCuBursa();
        List<StudentBursier> lista = app.genereaza();
        
        app.sorteaza(lista);
        
        // Check order
        for (int i = 0; i < lista.size() - 1; i++) {
            StudentBursier s1 = lista.get(i);
            StudentBursier s2 = lista.get(i + 1);
            
            int compFormatie = s1.getFormatieDeStudiu().compareTo(s2.getFormatieDeStudiu());
            Assertions.assertTrue(compFormatie <= 0);
            
            if (compFormatie == 0) {
                int compNume = s1.getNume().compareTo(s2.getNume());
                Assertions.assertTrue(compNume <= 0);
            }
        }
    }
}
