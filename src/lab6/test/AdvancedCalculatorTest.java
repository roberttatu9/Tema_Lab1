package lab6.test;

import lab6.calculator.AdvancedCalculator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AdvancedCalculatorTest {

    @Test
    public void testDivideByZeroThrowsException() {
        AdvancedCalculator calculator = new AdvancedCalculator(10);
        Assertions.assertThrows(ArithmeticException.class, () -> {
            calculator.divide(0);
        });
    }
}
