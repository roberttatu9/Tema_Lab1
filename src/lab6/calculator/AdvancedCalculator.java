package lab6.calculator;

import lab5.IntCalculator;

public class AdvancedCalculator extends IntCalculator {
    public AdvancedCalculator(int initialState) {
        super(initialState);
    }

    public AdvancedCalculator divide(int a) {
        state = state / a;
        return this;
    }
}
