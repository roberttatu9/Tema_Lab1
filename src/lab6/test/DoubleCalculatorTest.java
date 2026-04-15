package lab6.test;

import lab6.advanced.DoubleCalculator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DoubleCalculatorTest {
    private DoubleCalculator calculator;

    @BeforeEach
    public void setup() {
        calculator = new DoubleCalculator();
        calculator.init();
    }

    @Test
    public void testAddPositive() {
        calculator.add(5.5).add(4.5);
        Assertions.assertEquals(10.0, calculator.result());
    }

    @Test
    public void testDivideByZero() {
        calculator.add(10.0).divide(0.0);
        Assertions.assertEquals(Double.POSITIVE_INFINITY, calculator.result());
    }
}
