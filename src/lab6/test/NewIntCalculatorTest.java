package lab6.test;

import lab6.advanced.NewIntCalculator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class NewIntCalculatorTest {
    private NewIntCalculator calculator;

    @BeforeEach
    public void setup() {
        calculator = new NewIntCalculator();
        calculator.init();
    }

    @Test
    public void testAddPositive() {
        calculator.add(5).add(3);
        Assertions.assertEquals(8, calculator.result());
    }

    @Test
    public void testAddNegatives() {
        calculator.add(-5).add(-3);
        Assertions.assertEquals(-8, calculator.result());
    }

    @Test
    public void testSubtractPositives() {
        calculator.add(10).subtract(3);
        Assertions.assertEquals(7, calculator.result());
    }

    @Test
    public void testMultiplyBy0() {
        calculator.add(10).multiply(0);
        Assertions.assertEquals(0, calculator.result());
    }
}
