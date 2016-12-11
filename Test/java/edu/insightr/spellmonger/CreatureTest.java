package edu.insightr.spellmonger;

import java.util.Objects;

import static org.junit.Assert.*;

/**
 * Created by Dam's on 07/12/2016.
 */
public class CreatureTest {



    @org.junit.Test
    public void getDamage() throws Exception {
        
        Creature creatureEagle = new Creature("Eagle");
        Creature creatureWolf = new Creature("Wolf");
        Creature creatureBear = new Creature("Bear");

        assertEquals(" attacks of an eagle ", 1, creatureEagle.getDamage());
        assertEquals("attacks of an wolf",2,creatureWolf.getDamage());
        assertEquals("attacks of an bear  ",3,creatureBear.getDamage());

    }

}