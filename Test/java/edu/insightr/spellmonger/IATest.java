package edu.insightr.spellmonger;

import org.junit.Test;
import static org.junit.Assert.*;
import java.util.List;

/**
 * Test of the IA class
 */
public class IATest {
    @Test
    public void attack_cards() throws Exception {

    }

    @Test
    public void defense_cards() throws Exception {

    }

    @Test
    public void chooseBestCard() throws Exception {
        Deck deck = new Deck();
        List<Card> deckP = deck.DistributionCarte();
        Hand handP = new Hand(deckP);
        Hand handUnexpected = new Hand(deckP);
        int lifePoint = 20;
        Player P = new Player("Player Test IA", lifePoint, deckP);
        Player PUnexpected = new Player("Player Test IA Unexpected", lifePoint, deckP);

        handP.GetMainJoueur().clear();
        IA IA_P = new IA(P, PUnexpected , handP.GetMainJoueur());
        IA IA_PUnexpected = new IA(PUnexpected, P , handUnexpected.GetMainJoueur());

        //assertNotEquals ( Object unexpected , Object actual)
        //Check if the return the right message if the hand is empty
        assertNotEquals(IA_PUnexpected.ChooseBestCard(),IA_P.ChooseBestCard());
    }

}