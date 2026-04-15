package lab5.advanced;

public class NewIntCalculator extends ACalculator {

    public NewIntCalculator(int initialState) {
        this.state = initialState;
    }

    @Override
    protected void init() {
        this.state = 0;
    }

    @Override
    public ACalculator add(Object value) {
        this.state = (Integer) this.state + (Integer) value;
        return this;
    }

    @Override
    public ACalculator subtract(Object value) {
        this.state = (Integer) this.state - (Integer) value;
        return this;
    }

    @Override
    public ACalculator multiply(Object value) {
        this.state = (Integer) this.state * (Integer) value;
        return this;
    }
}
