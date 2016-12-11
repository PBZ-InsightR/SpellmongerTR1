/*
package edu.insightr.spellmonger;

import org.junit.Before;
import org.junit.Test;
import java.util.List;
import static org.junit.Assert.assertEquals;

/**
 * Created by Adriana on 09/12/2016.
 *
public class PlayerTest2 {
    @Before
    public void initialize() {
        Deck deck = new Deck();
        List<Card> hand;
        int lifePoint = 10;
        Player P = new Player("PlayerTest", lifePoint, deck.DistributionCarte(), hand);
    }

    @Test
    public void damage() throws Exception {

        //case where damage point is positive
        //case that it should works in the application
        int damagePoint = 2;
        Player P_lifePoint8 = new Player ("Player8LifePoints", 8, deck.DistributionCarte(), hand);
        P.damage(damagePoint);
        assertEquals("Damage equals 8", P_lifePoint8.getPv(), P.getPv());

        //case where damage points is null
        damagePoint =0;
        P.damage(damagePoint);
        assertEquals("Damage equals 0", P_lifePoint8.getPv(), P.getPv());

        //case where damage points is negative
        //the damage should not be negative in the application
        damagePoint = -2;
        P.damage(damagePoint);
        Player P_lifePoint10 = new Player("Player10LifePoints", 10, deck.DistributionCarte(), hand);
        assertEquals("Damage is negative", P_lifePoint10.getPv(), P.getPv());
    }

    @org.junit.Test
    public void estMort() throws Exception {
        boolean expected = false;
        assertEquals("Player is not dead", expected, P.estMort());

        lifePoint =0;
        expected = true;
        Player P_dead = new Player("PlayerDead", lifePoint, deck.DistributionCarte(),hand );
        assertEquals("Player is dead ", expected, P_dead.estMort());
    }

    @org.junit.Test
    public void estEnVie() throws Exception {
        boolean expected = false;
        assertEquals("Player is not dead", expected, P.estEnVie());

        lifePoint = 12;
        expected = true;
        Player P_alive = new Player("PlayerDead", lifePoint, deck.DistributionCarte(),hand );
        assertEquals("Player is alive ", expected, P_alive.estEnVie());
    }

    @Test
    public void creaVsCrea() throws Exception {

    }

    @Test
    public void rituVsRitu() throws Exception {

    }

    @Test
    public void creaVsRituJ1() throws Exception {

    }

    @Test
    public void creaVsRituJ2() throws Exception {

    }


}
*/