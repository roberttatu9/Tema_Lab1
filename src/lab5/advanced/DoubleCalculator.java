package lab5.advanced;

public class DoubleCalculator extends ACalculator {

    public DoubleCalculator(double initialState) {
        this.state = initialState;
    }

    @Override
    protected void init() {
        this.state = 0.0;
    }

    @Override
    public ACalculator add(Object value) {
        this.state = (Double) this.state + (Double) value;
        return this;
    }

    @Override
    public ACalculator subtract(Object value) {
        this.state = (Double) this.state - (Double) value;
        return this;
    }

    @Override
    public ACalculator multiply(Object value) {
        this.state = (Double) this.state * (Double) value;
        return this;
    }
}
