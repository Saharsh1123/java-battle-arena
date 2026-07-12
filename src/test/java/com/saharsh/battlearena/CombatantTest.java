package com.saharsh.battlearena;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;


class CombatantTest {
    @Test
    void blankNameThrowsIllegalArgumentException() {
        IllegalArgumentException exception = assertThrows(
            IllegalArgumentException.class,
            () -> new Combatant("",50, 100)
        );

        assertEquals("Name cannot be empty!", exception.getMessage());
    }


    @Test
    void whitespaceNameThrowsIllegalArgumentException() {
        IllegalArgumentException exception = assertThrows(
            IllegalArgumentException.class,
            () -> new Combatant("  ",50, 100)
        );

        assertEquals("Name cannot be empty!", exception.getMessage());
    }


    @Test
    void nullNameThrowsIllegalArgumentException() {
        IllegalArgumentException exception = assertThrows(
            IllegalArgumentException.class,
            () -> new Combatant(null,50, 100)
        );

        assertEquals("Name cannot be empty!", exception.getMessage());
    }


    @Test
    void negativeStrengthThrowsIllegalArgumentException() {
        IllegalArgumentException exception = assertThrows(
            IllegalArgumentException.class,
            () -> new Combatant("Knight", -30, 100)
        );

        assertEquals("Strength cannot be negative!", exception.getMessage());
    }


    @Test
    void negativeDamageThrowsIllegalArgumentException() {
        Combatant fighter = new Combatant("Knight", 50, 100);

        IllegalArgumentException exception = assertThrows(
            IllegalArgumentException.class,
            () -> fighter.takeDamage(-20)
        );

        assertEquals("Damage cannot be negative!", exception.getMessage());
    }


    @Test
    void zeroHealthThrowsIllegalArgumentException() {
        IllegalArgumentException exception = assertThrows(
            IllegalArgumentException.class,
            () -> new Combatant("Knight",50, 0)
        );

        assertEquals("Health must be positive!", exception.getMessage());
    }


    @Test
    void negativeHealthThrowsIllegalArgumentException() {
        IllegalArgumentException exception = assertThrows(
            IllegalArgumentException.class,
            () -> new Combatant("Knight",50, -10)
        );

        assertEquals("Health must be positive!", exception.getMessage());
    }


    @Test
    void nullAttackTargetThrowsIllegalArgumentException() {
        Combatant fighter = new Combatant("Knight",50, 100);

        IllegalArgumentException exception = assertThrows(
            IllegalArgumentException.class,
            () -> fighter.attack(null)
        );

        assertEquals("Specify a valid target!", exception.getMessage());
    }


    @Test
    void takeDamageReducesHealth() {
        Combatant target = new Combatant("Target", 20, 100);
        int startingHealth = target.getHealth();

        target.takeDamage(50);
        assertEquals(startingHealth - 50, target.getHealth());
    }


    @Test
    void zeroDamageDoesNotChangeHealth() {
        Combatant target = new Combatant("Target", 20, 100);

        target.takeDamage(0);
        assertEquals(100, target.getHealth());
    }


    @Test
    void exactDamageReducesHealthToZero() {
        Combatant target = new Combatant("Target", 20, 100);

        target.takeDamage(100);

        assertEquals(0, target.getHealth());
    }


    @Test
    void excessDamageClampsHealthToZero() {
        Combatant target = new Combatant("Target", 20, 100);

        target.takeDamage(110);

        assertEquals(0, target.getHealth());
    }


    @Test
    void targetDiesWhenAtZeroHealth() {
        Combatant target = new Combatant("Target", 20, 100);

        target.takeDamage(100);

        assertFalse(target.isAlive());
    }


    @Test
    void attackDamagesTargetByStrength() {
        Combatant target = new Combatant("Target", 20, 100);
        Combatant fighter = new Combatant("Knight",50, 100);

        int targetStartingHealth = target.getHealth();

        fighter.attack(target);

        assertEquals(targetStartingHealth - fighter.getStrength(), target.getHealth());
    }


    @Test
    void attackDoesNotDamageAttacker() {
        Combatant target = new Combatant("Target", 20, 100);
        Combatant fighter = new Combatant("Knight",50, 100);

        fighter.attack(target);

        assertEquals(100, fighter.getHealth());
    }


    @Test
    void deadCombatantAttackDoesNothing() {
        Combatant target = new Combatant("Target", 20, 100);
        Combatant fighter = new Combatant("Knight",100, 100);

        fighter.attack(target);
        assertFalse(target.isAlive());

        target.attack(fighter);

        assertEquals(100, fighter.getHealth());
    }


    @Test
    void aliveCombatantReturnsTrue() {
        Combatant fighter = new Combatant("Knight", 100, 100);

        assertTrue(fighter.isAlive());
    }


    @Test
    void constructorStoresValidValues() {
        Combatant combatant = new Combatant("Knight", 50, 100);

        assertEquals("Knight", combatant.getName());
        assertEquals(50, combatant.getStrength());
        assertEquals(100, combatant.getHealth());
    }
}