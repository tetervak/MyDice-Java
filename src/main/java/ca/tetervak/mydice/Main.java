package ca.tetervak.mydice;


import ca.tetervak.mydice.model.Dice;

import static java.lang.System.out;

public class Main {
    public static void main(String[] args) {

        out.println("Hello from MyDice App!");

        Dice dice = new Dice();
        out.println("Initial die value: " + dice.getValue());

        out.print("Die rolling values:");
        for (int i = 1; i <= 5; i++) {
            dice.roll();
            out.print(" " + dice.getValue());
        }
        out.println();

        dice.reset();
        out.println("Die reset value: " + dice.getValue());

        out.println("See you later!");
    }
}
