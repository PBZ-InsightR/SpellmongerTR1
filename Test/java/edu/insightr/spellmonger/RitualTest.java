package edu.insightr.spellmonger;

//import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Dam's on 11/12/2016.
 */
public class RitualTest {
    /*@Before
    public void Init() {
        String shieldCard = "Shield";
        String curseCard = "Curse";
        String blessingCard = "Blessing";
    }*/

    @Test
    public void getValue() throws Exception {

        Ritual blessing = new Ritual("Blessing");
        Ritual curse = new Ritual("Curse");
        Ritual shield = new Ritual("Shield");

        assertEquals(" Blessing ", -3, blessing.getValue());
        assertEquals("Curse",3,curse.getValue());
        assertEquals("Shield",0,shield.getValue());

    }

    @Test
    public void getShield() throws Exception {
        String shieldCard = "Shield";
        String curseCard = "Curse";
        String blessingCard = "Blessing";

        Ritual shieldRitual = new Ritual(shieldCard);
        Ritual curseRitual = new Ritual(curseCard);
        Ritual blessingRitual = new Ritual(blessingCard);

        boolean expected = true;
        assertEquals("This card is a shield", expected, shieldRitual.getShield() );

        expected = false;
        assertEquals("This card(curse) is not a shield", expected, curseRitual.getShield() );
        assertEquals("This card(blessing) is not a shield", expected, blessingRitual.getShield() );
    }

}