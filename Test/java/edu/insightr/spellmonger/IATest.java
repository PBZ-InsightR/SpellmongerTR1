package edu.insightr.spellmonger;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Dam's on 11/12/2016.
 */
public class IATest {
    @Test
    public void chooseBestCard_1() throws Exception {
        Deck deck = new Deck();
        List<Card> deckP = deck.DistributionCarte();
        List<Card> handP = deck.CreationMain(deckP);
        List<Card> handUnexpected = deck.CreationMain(deckP);
        int lifePoint = 20;
        Player P = new Player("Player Test IA", lifePoint, deckP, handP);
        Player PUnexpected = new Player("Player Test IA Unexpected", lifePoint, deckP, handUnexpected);

        handP.clear();
        IA IA_P = new IA(P.GetMainDuJoueur());
        IA IA_PUnexpected = new IA(PUnexpected.GetMainDuJoueur());

        //assertNotEquals ( Object unexpected , Object actual)
        //Check if the return the right message if the hand is empty
        assertNotEquals(IA_PUnexpected.ChooseBestCard(),IA_P.ChooseBestCard());
    }

}