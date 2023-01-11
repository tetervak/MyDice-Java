package ca.tetervak;

import ca.tetervak.model.Die;
import static java.lang.System.out;

public class Main {
    public static void main(String[] args) {

        out.println("Hello from MyDice App!");

        Die die = new Die();
        out.println("Initial die value: " + die.getValue());

        out.print("Die rolling values:");
        for (int i = 1; i <= 5; i++) {
            die.roll();
            out.print(" " + die.getValue());
        }
        out.println();

        die.reset();
        out.println("Die reset value: " + die.getValue());

        out.println("See you later!");
    }
}
