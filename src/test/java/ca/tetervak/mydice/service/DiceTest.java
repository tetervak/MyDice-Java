package ca.tetervak.mydice.service;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Random;

import static java.lang.System.out;
import static org.junit.jupiter.api.Assertions.*;

class DiceTest {

    @BeforeEach
    void setUp() {
        out.println("--- testing case ---");
    }

    @AfterEach
    void tearDown() {
        out.println("--- ------- ---- ---");
    }

    // used to get the same sequence of random numbers each time
    static Random random;
    @BeforeAll
    static void init(){
        out.println("**** Starting Dice Class Tests ****");
        // providing the seed value makes the random sequence reproducible
        random = new Random(222);
    }

    @AfterAll
    static void finish(){
        out.println("**** Finished Dice Class Tests ****");
    }

    @SuppressWarnings("ConstantValue")
    @Test
    @DisplayName("Check that min dice value < max dice value")
    void limits(){
        out.println("min value = " + Dice.MIN_VALUE);
        out.println("max value = " + Dice.MAX_VALUE);
        assertTrue(Dice.MIN_VALUE < Dice.MAX_VALUE);
    }

    @Test
    @DisplayName("Call Constructor without arguments")
    void constructor_default() {
        out.println("constructor with all default parameters");
        var dice = new Dice();
        out.println("dice = " + dice);
        assertEquals(Dice.INIT_VALUE, dice.getValue());
    }

    @Test
    @DisplayName("Call Constructor with max value")
    void constructor_maxValue() {
        out.println("constructor with max value set");
        var dice = new Dice(Dice.MAX_VALUE);
        out.println("dice = " + dice);
        assertEquals(Dice.MAX_VALUE, dice.getValue());
    }

    @Test
    @DisplayName("Get max value")
    void getMaxValue() {
        out.println("get max value");
        var maxValue = Dice.getMaxValue();
        out.println("maxValue = " + maxValue);
        assertEquals(Dice.MAX_VALUE, maxValue);
    }

    @Test
    @DisplayName("Set max value")
    void setValue_maxValue() {
        var dice = new Dice();
        out.println("dice = " + dice);
        out.println("setting max value");
        dice.setValue(Dice.MAX_VALUE);
        out.println("dice = " + dice);
        assertEquals(Dice.MAX_VALUE, dice.getValue());
    }

    @Test
    @DisplayName("Set illegal, too small, value. Check exception message")
    void setValue_tooSmall() {
        var dice = new Dice();
        out.println("dice = " + dice);
        out.println("set illegal values");
        out.println("setting too small value");
        var tooSmallValue = Dice.MIN_VALUE - 1;
        Exception exception = assertThrows(
                IllegalArgumentException.class,
                () -> dice.setValue(tooSmallValue)
        );
        assertEquals("Illegal dice value " + tooSmallValue, exception.getMessage());
    }

    @Test
    @DisplayName("Set illegal, too large, value")
    void setValue_tooLarge() {
        var dice = new Dice();
        out.println("dice = " + dice);
        out.println("setting too large value");
        var tooLargeValue = Dice.MAX_VALUE + 1;
        assertThrows(
                IllegalArgumentException.class,
                () -> dice.setValue(tooLargeValue)
        );
    }

    @Test
    @DisplayName("Set Illegal values")
    void setValue_illegal() {
        var dice = new Dice();
        out.println("dice = " + dice);
        out.println("set illegal values");
        out.println("setting too small value");
        var tooSmallValue = Dice.MIN_VALUE - 1;
        Exception exception = assertThrows(
                IllegalArgumentException.class,
                () -> dice.setValue(tooSmallValue)
        );
        assertEquals("Illegal dice value " + tooSmallValue, exception.getMessage());
        out.println("setting too large value");
        var tooLargeValue = Dice.MAX_VALUE + 1;
        assertThrows(
                IllegalArgumentException.class,
                () -> dice.setValue(tooLargeValue)
        );
    }

    @DisplayName("Set min and max values")
    @ParameterizedTest(name = "setting {0} value")
    @ValueSource(ints = { Dice.MIN_VALUE, Dice.MAX_VALUE })
    void setValue_edges(int value) {
        var dice = new Dice(Dice.MIN_VALUE + 1);
        out.println("before set value = " + value);
        out.println("dice = " + dice);
        dice.setValue(value);
        out.println("after set value = " + value);
        assertEquals(value, dice.getValue());
    }

    @DisplayName("Calling reset")
    @Test
    void reset() {
        var dice = new Dice(Dice.MIN_VALUE + 1);
        out.println("before reset = " + dice);
        dice.reset();
        out.println("after reset = " + dice);
        assertEquals(Dice.INIT_VALUE, dice.getValue());
    }

    @Test
    @DisplayName("Calling roll. Check the returned value")
    void roll() {
        var dice = new Dice(Dice.INIT_VALUE, random);
        out.println("before roll = " + dice);
        var returned = dice.roll();
        out.println("after roll = " + dice);
        assertEquals(dice.getValue(), returned);
        assertTrue(dice.getValue() >= Dice.MIN_VALUE);
        assertTrue(dice.getValue() <= Dice.MAX_VALUE);
    }


    @DisplayName("Calling roll repeatably")
    @RepeatedTest(10)
    void roll_repeated() {
        // providing the seed value makes the random sequence reproducible
        var dice = new Dice(Dice.INIT_VALUE, random);
        out.println("before roll = " + dice);
        dice.roll();
        out.println("after roll = " + dice);
        assertTrue(dice.getValue() >= Dice.MIN_VALUE);
        assertTrue(dice.getValue() <= Dice.MAX_VALUE);
    }

}