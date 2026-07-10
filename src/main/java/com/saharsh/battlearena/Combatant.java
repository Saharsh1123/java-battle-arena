package com.saharsh.battlearena;

public class Combatant {
    private final String name;
    private int strength;
    private int health;


    public Combatant(String name, int strength, int health) {
        if (name.isBlank() || name == null) {
            throw new IllegalArgumentException("Name cannot be empty!");
        }
        if (strength < 0) {
            throw new IllegalArgumentException("Strength cannot be negative!");
        }
        if (health <= 0) {
            throw new IllegalArgumentException("Health must be positive!");
        }

        this.name = name;
        this.strength = strength;
        this.health = health;
    }

    
    public boolean isAlive() {
        return this.health > 0;
    }

    public String getName() {
        return this.name;
    }

    public int getStrength() {
        return this.strength;
    }

    public int getHealth() {
        return this.health;
    }

    public void takeDamage(int damage) {
        if (damage < 0) {
            throw new IllegalArgumentException("Damage cannot be negative!");
        }

        this.health = Math.max(0, this.health - damage);

    }

    public void attack(Combatant target) {
        if (target == null) {
            throw new IllegalArgumentException("Specify a valid target!");
        }

        if (!this.isAlive()) {
            return;
        }
        target.takeDamage(this.strength);
    }
}
