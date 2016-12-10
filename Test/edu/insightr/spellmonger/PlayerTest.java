package edu.insightr.spellmonger;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Adriana on 07/12/2016.
 */
public class PlayerTest {
    Deck deck = new Deck();
    List<Card> hand;
    int lifePoint = 10;
    Player P = new Player("PlayerTest", lifePoint, deck.DistributionCarte(), hand );

    @org.junit.Test
    public void damage() throws Exception {
        int damagePoint = 2;

        assert("Life's points should be 8", 8, damage(damagePoint));

        damagePoint =0;
        assertEquals("Damage equals 0", lifePoint, damage(damagePoint));

        damagePoint = -2;
        assertEquals("Damage is negative", 12, damage(damagePoint));
    }

    @org.junit.Test
    public void estMort() throws Exception {
        boolean expected = false;
        assertEquals("Player is not dead", expected, P.estMort());

        lifePoint =0;
        expected = true;
        Player P_dead = new Player("PlayerDead", lifePoint, deck.DistributionCarte() );
        assertEquals("Player is dead ", expected, P_dead.estMort());
    }

    @org.junit.Test
    public void estEnVie() throws Exception {

    }

    @org.junit.Test
    public void creaVsCrea() throws Exception {

    }

    @org.junit.Test
    public void rituVsRitu() throws Exception {

    }

    @org.junit.Test
    public void creaVsRituJ1() throws Exception {

    }

    @org.junit.Test
    public void creaVsRituJ2() throws Exception {

    }

}