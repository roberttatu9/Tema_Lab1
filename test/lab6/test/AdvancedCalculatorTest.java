package lab6.test;

import lab6.calculator.AdvancedCalculator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AdvancedCalculatorTest {

    private AdvancedCalculator calc;

    @BeforeEach
    public void setUp() {
        calc = new AdvancedCalculator(0);
    }

    @Test
    public void testAddPositive() {
        int result = calc.add(5).add(3).result();
        Assertions.assertEquals(8, result);
    }

    @Test
    public void testSubtractPositives() {
        int result = calc.add(10).subtract(4).result();
        Assertions.assertEquals(6, result);
    }

    @Test
    public void testMultiplyPositives() {
        int result = calc.add(5).multiply(3).result();
        Assertions.assertEquals(15, result);
    }

    @Test
    public void testMultiplyBy0() {
        int result = calc.add(100).multiply(0).result();
        Assertions.assertEquals(0, result);
    }

    @Test
    public void testDividePositives() {
        int result = calc.add(10).divide(2).result();
        Assertions.assertEquals(5, result);
    }

    @Test
    public void testDivideNegatives() {
        int result = calc.add(10).divide(-2).result();
        Assertions.assertEquals(-5, result);
    }

    // 6.8.2 – negative path: divide by 0 silently leaves state unchanged
    @Test
    public void testDivideBy0() {
        calc.add(10);
        int stateBefore = calc.result();
        calc.divide(0);
        Assertions.assertEquals(stateBefore, calc.result());
    }

    @Test
    public void testPower() {
        int result = calc.add(3).power(3).result();
        Assertions.assertEquals(27, result);
    }

    @Test
    public void testRoot() {
        int result = calc.add(27).root(3).result();
        Assertions.assertEquals(3, result);
    }

    // 6.8.2 – negative path: root(0) silently leaves state unchanged
    @Test
    public void testRootBy0() {
        calc.add(16);
        int stateBefore = calc.result();
        calc.root(0);
        Assertions.assertEquals(stateBefore, calc.result());
    }
}
