package ca.tetervak.model;

public class Die {

    public static final int INIT_VALUE = 1;

    private int value;

    public int getValue() {
        return value;
    }

    public final void setValue(int value) {
        if (value >= 1 && value <= 6) {
            this.value = value;
        } else {
            throw new IllegalArgumentException("Illegal die value " + value);
        }
    }

    public Die(int value) {
        setValue(value);
    }

    public Die() {
        this(INIT_VALUE);
    }

    public void reset() {
        value = INIT_VALUE;
    }

    public int roll() {
        value = 1 + (int) (6 * Math.random());
        return value;
    }
}
