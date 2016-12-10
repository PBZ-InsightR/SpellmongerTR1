package edu.insightr.spellmonger;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Adriana on 08/12/2016.
 */
public class DeckTest {
    List<Card> deck ;
    int nombreCarte = 41;


    @Test
    public void creationDeck() throws Exception { // à refaire : test failed
        Card card;
        int i;
        int nbEagles = 0;

        for (i = 0; i < nombreCarte/4; i++)
        {

            card = new Creature("Eagle");
            deck.add(card);
            nbEagles ++;
        }

        assertEquals("It supposed to be 10 Eagles in the desk", 10 , nbEagles );
    }

    @Test
    public void distributionCarte() throws Exception {

    }

    @Test
    public void creationMain() throws Exception {

    }

    @Test
    public void afficherDeck() throws Exception {

    }

    @Test
    public void afficherMain() throws Exception {

    }

    @Test
    public void pickCard() throws Exception {

    }

}