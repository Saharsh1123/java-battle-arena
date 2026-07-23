package com.saharsh.battlearena;

public class Main {
    public static void main(String[] args) {
        Combatant fighter = new Combatant("fighter", 50, 300);
        Combatant defender = new Combatant("defender", 30, 400);

        System.out.println(defender.getHealth());

        fighter.attack(defender);

        System.out.println(defender.getHealth());
    }
}
