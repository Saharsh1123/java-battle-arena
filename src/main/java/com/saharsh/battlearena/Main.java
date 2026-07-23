package com.saharsh.battlearena;

public class Main {
    public static void main(String[] args) {
        Combatant fighter = new Combatant("fighter", 50, 300);
        Combatant defender = new Combatant("defender", 30, 400);

        while (defender.isAlive() && fighter.isAlive()) {
            System.out.println("Defender: %d".formatted(defender.getHealth()));
            System.out.println("Fighter: %d".formatted(fighter.getHealth()));
            fighter.attack(defender);

            if (defender.isAlive()) {
                defender.attack(fighter);
            }
        }
        System.out.println("Defender: %d".formatted(defender.getHealth()));
        System.out.println("Fighter: %d".formatted(fighter.getHealth()));
        
        if (fighter.getHealth() > 0) {
            System.out.println("Winner: Fighter");
        } else {
            System.out.println("Winner: Defender");
        }
    }
}
