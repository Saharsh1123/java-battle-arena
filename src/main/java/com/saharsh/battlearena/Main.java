package com.saharsh.battlearena;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String name;

        while (true) {
            System.out.println("Enter Combatants name: ");
            name = scanner.nextLine();

            if (!name.isBlank()) {
                break;
            }

            System.out.println("Name cannot be blank!");
        }


        Combatant fighter = new Combatant(name, 50, 300);
        Combatant defender = new Combatant("defender", 30, 400);

        while (defender.isAlive() && fighter.isAlive()) {
            System.out.println("Defender: %d".formatted(defender.getHealth()));
            System.out.println("%s: %d".formatted(name, fighter.getHealth()));
            fighter.attack(defender);

            if (defender.isAlive()) {
                defender.attack(fighter);
            }
        }
        System.out.println("Defender: %d".formatted(defender.getHealth()));
        System.out.println("%s: %d".formatted(name, fighter.getHealth()));
        
        if (fighter.getHealth() > 0) {
            System.out.println("Winner: %s".formatted(name));
        } else {
            System.out.println("Winner: Defender");
        }

        scanner.close();
    }
}
