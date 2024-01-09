package ca.tetervak.mydice.service;

import java.util.Random;

public class Dice {

    public static final int INIT_VALUE = 1;
    public static final int MIN_VALUE = 1;
    public static final int MAX_VALUE = 6;

    private final Random random;

    private int value;

    public int getValue() {
        return value;
    }

    public final void setValue(int value) {
        if (value >= MIN_VALUE && value <= MAX_VALUE) {
            this.value = value;
        } else {
            throw new IllegalArgumentException("Illegal dice value " + value);
        }
    }

    public Dice(int value, Random random){
        this.random = random;
        setValue(value);
    }


    public Dice(int value) {
        this(value, new Random());
    }


    public Dice() {
        this(INIT_VALUE);
    }

    public void reset() {
        value = INIT_VALUE;
    }

    public int roll() {
        value = MIN_VALUE + random.nextInt(MAX_VALUE);
        return value;
    }
}
