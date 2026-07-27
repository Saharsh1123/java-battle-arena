package com.saharsh.battlearena;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Combatant fighter = createCombatant(scanner, "fighter");
        Combatant defender = createCombatant(scanner, "defender");

        runBattle(fighter, defender);

        scanner.close();
    }

    static void runBattle(Combatant fighter, Combatant defender) {
        while (defender.isAlive() && fighter.isAlive()) {
            System.out.println("%s: %d".formatted(defender.getName(), defender.getHealth()));
            System.out.println("%s: %d".formatted(fighter.getName(), fighter.getHealth()));
            fighter.attack(defender);

            if (defender.isAlive()) {
                defender.attack(fighter);
            }
        }

        System.out.println("%s: %d".formatted(defender.getName(), defender.getHealth()));
        System.out.println("%s: %d".formatted(fighter.getName(), fighter.getHealth()));
        
        if (fighter.isAlive()) {
            System.out.println("Winner: %s".formatted(fighter.getName()));
        } else {
            System.out.println("Winner: Defender");
        }
    }


    static Combatant createCombatant(Scanner scanner, String role) {
        String name;

        while (true) {
            System.out.println("Enter %ss name: ".formatted(role));
            name = scanner.nextLine();

            if (!name.isBlank()) {
                break;
            }

            System.out.println("Name cannot be blank!");
        }

        return new Combatant(name, (int)(Math.random() * 41) + 20, (int)(Math.random() * 401) + 100);
    }
}
