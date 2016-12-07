package edu.insightr.spellmonger

/**
 * Created by Adriana on 06/12/2016.
 */
class PlayerTest extends GroovyTestCase {
    Deck deck = new Deck();
    int lifePoint = 10;
    Player P = new Player("PlayerTest", lifePoint, deck.DistributionCarte());

    void testDamage() {

        int damagePoint = 2;
        assertEquals("Life's points should be 8", 8, damage(damagePoint));

        damagePoint =0;
        assertEquals("Damage equals 0", lifePoint, damage(damagePoint));

        damagePoint = -2;
        assertEquals("Damage is negative", 12, damage(damagePoint));
    }

    void testEstMort() {

    }

    void testEstEnVie() {

    }

    void testCreaVsCrea() {

    }

    void testRituVsRitu() {

    }

    void testCreaVsRituJ1() {

    }

    void testCreaVsRituJ2() {

    }
}
