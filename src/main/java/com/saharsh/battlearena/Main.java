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


        Combatant fighter = new Combatant(name, (int)(Math.random() * 41) + 20, (int)(Math.random() * 401) + 100);

        Combatant defender = new Combatant("defender", (int)(Math.random() * 41) + 20, (int)(Math.random() * 401) + 100);


        while (defender.isAlive() && fighter.isAlive()) {
            System.out.println("Defender: %d".formatted(defender.getHealth()));
            System.out.println("%s: %d".formatted(fighter.getName(), fighter.getHealth()));
            fighter.attack(defender);

            if (defender.isAlive()) {
                defender.attack(fighter);
            }
        }
        System.out.println("Defender: %d".formatted(defender.getHealth()));
        System.out.println("%s: %d".formatted(fighter.getName(), fighter.getHealth()));
        
        if (fighter.isAlive()) {
            System.out.println("Winner: %s".formatted(fighter.getName()));
        } else {
            System.out.println("Winner: Defender");
        }

        scanner.close();
    }
}
