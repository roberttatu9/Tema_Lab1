package lab6.advanced;

public abstract class ACalculator<T> {
    protected Object state;

    abstract <S extends ACalculator> S init();

    public T result() {
        return (T)state;
    }

    public void clear() {
        state = null;
    }
}
