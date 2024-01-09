package ca.tetervak.mydice.service;

public class Dice {

    public static final int INIT_VALUE = 1;

    private int value;

    public int getValue() {
        return value;
    }

    public final void setValue(int value) {
        if (value >= 1 && value <= 6) {
            this.value = value;
        } else {
            throw new IllegalArgumentException("Illegal dice value " + value);
        }
    }

    public Dice(int value) {
        setValue(value);
    }

    public Dice() {
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
