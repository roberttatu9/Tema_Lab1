package lab5.advanced;

public abstract class ACalculator {
    protected Object state;

    public Object result() {
        return state;
    }

    public ACalculator clear() {
        this.init();
        return this;
    }

    protected abstract void init();
    public abstract ACalculator add(Object value);
    public abstract ACalculator subtract(Object value);
    public abstract ACalculator multiply(Object value);
}
