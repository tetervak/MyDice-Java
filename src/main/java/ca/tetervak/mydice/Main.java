package ca.tetervak.mydice;


import ca.tetervak.mydice.service.Dice;

import static java.lang.System.out;

public class Main {
    public static void main(String[] args) {

        out.println("Hello from MyDice App!");

        Dice dice = new Dice();
        out.println("Initial dice value: " + dice.getValue());

        out.print("Dice rolling values:");
        for (int i = 1; i <= 10; i++) {
            dice.roll();
            out.print(" " + dice.getValue());
        }
        out.println();

        dice.reset();
        out.println("Dice reset value: " + dice.getValue());

        out.println("See you later!");
    }
}
