package edu.insightr.spellmonger;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Dam's on 11/12/2016.
 */
public class RitualTest {



    @Test
    public void getValue() throws Exception {

        Ritual blessing = new Ritual("Blessing");
        Ritual curse = new Ritual("Curse");
        Ritual shield = new Ritual("Shield");

        assertEquals(" Blessing ", -3, blessing.getValue());
        assertEquals("Curse",3,curse.getValue());
        assertEquals("Shield",0,shield.getValue());

    }



}