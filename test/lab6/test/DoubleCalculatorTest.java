package lab6.test;

import lab6.advanced.DoubleCalculator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DoubleCalculatorTest {

    private DoubleCalculator calc;

    @BeforeEach
    public void setUp() {
        calc = new DoubleCalculator();
        calc.init();
    }

    // --- add ---

    @Test
    public void testAddPositive() {
        // arrange: state = 0.0
        // act
        double result = calc.add(3.5).add(1.5).result();
        // assert
        Assertions.assertEquals(5.0, result, 0.0001);
    }

    @Test
    public void testAddNegatives() {
        // arrange: state = 0.0
        // act
        double result = calc.add(-2.5).add(-1.5).result();
        // assert
        Assertions.assertEquals(-4.0, result, 0.0001);
    }

    // --- subtract ---

    @Test
    public void testSubtractPositives() {
        // arrange
        calc.add(10.0);
        // act
        double result = calc.subtract(3.3).result();
        // assert
        Assertions.assertEquals(6.7, result, 0.0001);
    }

    @Test
    public void testSubtractNegatives() {
        // arrange
        calc.add(5.0);
        // act
        double result = calc.subtract(-2.0).result();
        // assert
        Assertions.assertEquals(7.0, result, 0.0001);
    }

    // --- multiply ---

    @Test
    public void testMultiplyPositives() {
        // arrange
        calc.add(4.0);
        // act
        double result = calc.multiply(2.5).result();
        // assert
        Assertions.assertEquals(10.0, result, 0.0001);
    }

    @Test
    public void testMultiplyNegatives() {
        // arrange
        calc.add(4.0);
        // act
        double result = calc.multiply(-2.0).result();
        // assert
        Assertions.assertEquals(-8.0, result, 0.0001);
    }

    @Test
    public void testMultiplyBy0() {
        // arrange
        calc.add(100.0);
        // act
        double result = calc.multiply(0.0).result();
        // assert
        Assertions.assertEquals(0.0, result, 0.0001);
    }

    // --- divide ---

    @Test
    public void testDividePositives() {
        // arrange
        calc.add(10.0);
        // act
        double result = calc.divide(4.0).result();
        // assert
        Assertions.assertEquals(2.5, result, 0.0001);
    }

    @Test
    public void testDivideNegatives() {
        // arrange
        calc.add(10.0);
        // act
        double result = calc.divide(-2.0).result();
        // assert
        Assertions.assertEquals(-5.0, result, 0.0001);
    }

    @Test
    public void testDivideBy0() {
        // arrange
        calc.add(10.0);
        // act: double / 0.0 = Infinity in Java, no exception
        double result = calc.divide(0.0).result();
        // assert
        Assertions.assertTrue(Double.isInfinite(result));
    }
}
