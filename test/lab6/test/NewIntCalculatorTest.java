package lab6.test;

import lab6.advanced.NewIntCalculator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class NewIntCalculatorTest {

    private NewIntCalculator calc;

    @BeforeEach
    public void setUp() {
        calc = new NewIntCalculator();
        calc.init();
    }

    // --- add ---

    @Test
    public void testAddPositive() {
        // arrange: state = 0
        // act
        int result = calc.add(5).add(3).result();
        // assert
        Assertions.assertEquals(8, result);
    }

    @Test
    public void testAddNegatives() {
        // arrange: state = 0
        // act
        int result = calc.add(-4).add(-6).result();
        // assert
        Assertions.assertEquals(-10, result);
    }

    // --- subtract ---

    @Test
    public void testSubtractPositives() {
        // arrange
        calc.add(10);
        // act
        int result = calc.subtract(3).result();
        // assert
        Assertions.assertEquals(7, result);
    }

    @Test
    public void testSubtractNegatives() {
        // arrange
        calc.add(5);
        // act
        int result = calc.subtract(-3).result();
        // assert
        Assertions.assertEquals(8, result);
    }

    // --- multiply ---

    @Test
    public void testMultiplyPositives() {
        // arrange
        calc.add(4);
        // act
        int result = calc.multiply(3).result();
        // assert
        Assertions.assertEquals(12, result);
    }

    @Test
    public void testMultiplyNegatives() {
        // arrange
        calc.add(4);
        // act
        int result = calc.multiply(-3).result();
        // assert
        Assertions.assertEquals(-12, result);
    }

    @Test
    public void testMultiplyBy0() {
        // arrange
        calc.add(100);
        // act
        int result = calc.multiply(0).result();
        // assert
        Assertions.assertEquals(0, result);
    }

    // --- divide ---

    @Test
    public void testDividePositives() {
        // arrange
        calc.add(10);
        // act
        int result = calc.divide(2).result();
        // assert
        Assertions.assertEquals(5, result);
    }

    @Test
    public void testDivideNegatives() {
        // arrange
        calc.add(10);
        // act
        int result = calc.divide(-2).result();
        // assert
        Assertions.assertEquals(-5, result);
    }

    @Test
    public void testDivideBy0() {
        // arrange
        calc.add(10);
        // act + assert: integer division by zero throws ArithmeticException
        Assertions.assertThrows(ArithmeticException.class, () -> calc.divide(0));
    }
}
