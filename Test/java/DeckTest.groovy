package edu.insightr.spellmonger.Test

import edu.insightr.spellmonger.Card
import edu.insightr.spellmonger.Creature

class DeckTest extends GroovyTestCase {
    void setUp() {
        super.setUp()

    }

    void testCreationDeck() {

        Card card;
        int i;

         for (i = 0; i < nombreCarte/4; i++)
         {

            card = new Creature("Eagle");
            deck.add(card);
         }

        assertEquals()

    }

    void testMix() {

    }

    void testCreationMain() {

    }

    void testAfficherMain() {

    }

    void testPickCard() {

    }
}
